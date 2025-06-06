package com.tugas.besar.DataAccesObject.Pegawai;

import com.tugas.besar.Model.Pegawai.Product;
import com.tugas.besar.DataAccesObject.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private final Connection connection;

    public ProductDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    
        public boolean insert(Product product) {
            String sql = "INSERT INTO produk (nama, harga, kategori_id, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product.getNama());
                stmt.setInt(2, product.getHarga());
                stmt.setInt(3, product.getKategoriId());
                stmt.setTimestamp(4, product.getCreatedAt());
                stmt.setTimestamp(5, product.getUpdatedAt());

                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException e) {
                System.err.println("Insert product failed: " + e.getMessage());
                return false;
            }
        }

    
    public List<Product> get() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM produk";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("harga"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getInt("kategori_id")
                );
                products.add(product);
            }

        } catch (SQLException e) {
            System.err.println("Fetch all products failed: " + e.getMessage());
        }

        return products;
    }

    // READ BY ID
    public Product getProductById(int id) {
        String sql = "SELECT * FROM produk WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("harga"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getInt("kategori_id")
                );
            }
        } catch (SQLException e) {
            System.err.println("Fetch product by ID failed: " + e.getMessage());
        }

        return null;
    }

    // UPDATE
    public boolean update(Product product) {
        String sql = "UPDATE produk SET nama = ?, harga = ?, kategori_id = ?, updated_at = NOW() WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getNama());
            stmt.setInt(2, product.getHarga());
            stmt.setInt(3, product.getKategoriId());
            stmt.setInt(4, product.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Update product failed: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM produk WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Delete product failed: " + e.getMessage());
            return false;
        }
    }
}
