/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.DataAccesObject.Pegawai;
import com.tugas.besar.Model.Pegawai.Kategori;
import com.tugas.besar.DataAccesObject.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author VirzaAbsyar
 */


public class KategoriDAO {
    private final Connection connection;

    public KategoriDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    
    public boolean create(Kategori kategori) {
        String sql = "INSERT INTO kategori (nama, created_at, updated_at) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, kategori.getNama());
            stmt.setTimestamp(2, kategori.getCreatedAt());
            stmt.setTimestamp(3, kategori.getUpdatedAt());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public List<Kategori> read() {
        List<Kategori> list = new ArrayList<>();
        String sql = "SELECT * FROM kategori";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Kategori kategori = new Kategori(
                    
                    rs.getString("nama"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                kategori.setId(rs.getInt("id"));
                list.add(kategori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public boolean update(Kategori kategori) {
        String sql = "UPDATE kategori SET nama = ?, updated_at = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, kategori.getNama());
            stmt.setTimestamp(2, kategori.getUpdatedAt());
            stmt.setInt(3, kategori.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean delete(int id) {
        String sql = "DELETE FROM kategori WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
