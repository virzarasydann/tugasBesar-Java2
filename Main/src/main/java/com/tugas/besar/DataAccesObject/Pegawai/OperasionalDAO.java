package com.tugas.besar.DataAccesObject.Pegawai;

import com.tugas.besar.Model.Pegawai.Operasional;
import com.tugas.besar.DataAccesObject.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OperasionalDAO {
    private final Connection connection;

    public OperasionalDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    
    public boolean insert(Operasional operasional) {
        String sql = "INSERT INTO operasional (nama, harga, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operasional.getNama());
            stmt.setInt(2, operasional.getHarga());
            stmt.setTimestamp(3, operasional.getCreatedAt());
            stmt.setTimestamp(4, operasional.getUpdatedAt());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public List<Operasional> get() {
        List<Operasional> list = new ArrayList<>();
        String sql = "SELECT * FROM operasional";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operasional operasional = new Operasional(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getInt("harga"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                list.add(operasional);
            }
            
            if (list.isEmpty()) {
              
                Operasional dummy = new Operasional(
                  
                    "Data kosong",         
                    0
                 
                );
                list.add(dummy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public boolean update(Operasional operasional) {
        String sql = "UPDATE operasional SET nama = ?, harga = ?, updated_at = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operasional.getNama());
            stmt.setInt(2, operasional.getHarga());
            stmt.setTimestamp(3, operasional.getUpdatedAt());
            stmt.setInt(4, operasional.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean delete(int id) {
        String sql = "DELETE FROM operasional WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}