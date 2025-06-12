package com.tugas.besar.DataAccesObject.Pegawai;

import com.tugas.besar.DataAccesObject.DatabaseConnection;
import com.tugas.besar.Model.Pegawai.TransaksiDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDetailDAO {
    private final Connection connection;

    public TransaksiDetailDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // CREATE
    public boolean insert(TransaksiDetail transaksiDetail) {
        String sql = "INSERT INTO transaksi_detail (transaksi_id, produk_nama, quantity, harga, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, transaksiDetail.getIdTransaksi());
            stmt.setString(2, transaksiDetail.getProdukNama());
            stmt.setInt(3, transaksiDetail.getQuantity());
            stmt.setInt(4, transaksiDetail.getHarga());
            stmt.setTimestamp(5, transaksiDetail.getCreatedAt());
            stmt.setTimestamp(6, transaksiDetail.getUpdatedAt());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Insert transaksi_detail failed: " + e.getMessage());
            return false;
        }
    }

    // READ
    public List<TransaksiDetail> getAll() {
        List<TransaksiDetail> detailList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi_detail";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TransaksiDetail detail = new TransaksiDetail(
                        rs.getInt("id"),
                        rs.getInt("transaksi_id"),
                        rs.getString("produk_nama"),
                        rs.getInt("quantity"),
                        rs.getInt("harga"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                detailList.add(detail);
            }

        } catch (SQLException e) {
            System.err.println("Fetch transaksi_detail failed: " + e.getMessage());
        }

        return detailList;
    }

//    // UPDATE
//    public boolean update(TransaksiDetail detail) {
//        String sql = "UPDATE transaksi_detail SET produk_nama = ?, quantity = ?, harga = ?, updated_at = ? WHERE id = ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, detail.getProdukNama());
//            stmt.setInt(2, detail.getQuantity());
//            stmt.setInt(3, detail.getHarga());
//            stmt.setTimestamp(4, detail.getUpdatedAt());
//            stmt.setInt(5, detail.getId());
//
//            int rowsUpdated = stmt.executeUpdate();
//            return rowsUpdated > 0;
//
//        } catch (SQLException e) {
//            System.err.println("Update transaksi_detail failed: " + e.getMessage());
//            return false;
//        }
//    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM transaksi_detail WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Delete transaksi_detail failed: " + e.getMessage());
            return false;
        }
    }
}
