package com.tugas.besar.DataAccesObject.Pegawai;

import com.tugas.besar.DataAccesObject.DatabaseConnection;
import com.tugas.besar.Model.Pegawai.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class TransaksiDAO {
    private final Connection connection;

    public TransaksiDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    
    public Integer insert(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (nama, total_harga, metode_pembayaran, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, transaksi.getNama());
            stmt.setInt(2, transaksi.getTotalHarga());
            stmt.setString(3, transaksi.getMetodePembayaran());
            stmt.setTimestamp(4, transaksi.getCreatedAt());
            stmt.setTimestamp(5, transaksi.getUpdatedAt());

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); 
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Insert transaksi failed: " + e.getMessage());
        }

        return null; 
    }

   
    public List<Transaksi> get() {
        List<Transaksi> transaksiList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Transaksi transaksi = new Transaksi(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("total_harga"),
                        rs.getString("metode_pembayaran"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                transaksiList.add(transaksi);
            }

        } catch (SQLException e) {
            System.err.println("Fetch all transaksi failed: " + e.getMessage());
        }

        return transaksiList;
    }

    
    public boolean update(Transaksi transaksi) {
        String sql = "UPDATE transaksi SET nama = ?, total_harga = ?, metode_pembayaran = ?, updated_at = NOW() WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, transaksi.getNama());
            stmt.setInt(2, transaksi.getTotalHarga());
            stmt.setString(3, transaksi.getMetodePembayaran());
            stmt.setInt(4, transaksi.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Update transaksi failed: " + e.getMessage());
            return false;
        }
    }

    
    public boolean delete(int id) {
        String sql = "DELETE FROM transaksi WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Delete transaksi failed: " + e.getMessage());
            return false;
        }
    }
}