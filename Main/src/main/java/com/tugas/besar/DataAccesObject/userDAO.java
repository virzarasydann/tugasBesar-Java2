/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.DataAccesObject;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.tugas.besar.Model.User;
import com.tugas.besar.Model.Pemilik.Pemilik;
import com.tugas.besar.Model.Pegawai.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class userDAO {

    public String testing;
    public int testing2;
    
    public User checkUsername(String username) {
        User user = null;
        Connection connectDatabase = DatabaseConnection.getConnection();

        String query = "SELECT * FROM users WHERE name = ?";
        try (PreparedStatement execute = connectDatabase.prepareStatement(query)) {
            execute.setString(1, username);
            ResultSet result = execute.executeQuery();
            if (result.next()) {
                int id = result.getInt("id");
                String password = result.getString("password");
                String role = result.getString("role");
                  

                if ("PEMILIK".equalsIgnoreCase(role)) {
                    user = new Pemilik(id,username, password);
                    
                } else if ("PEGAWAI".equalsIgnoreCase(role)) {
                    user = new Pegawai(id,username, password);
                } else {
                    System.err.println("Peran tidak dikenali: " + role);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching user: " + e.getMessage());
        }

        return user;
    }
    
    public boolean tambahPegawai(String username, String password) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        String query = "INSERT INTO users (name, password, role) VALUES (?, ?, 'PEGAWAI')";

        Connection connectDatabase = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connectDatabase.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, bcryptHashString);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menambah pegawai: " + e.getMessage());
            return false;
        } finally {
            // Tutup hanya PreparedStatement, bukan Connection
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Gagal menutup PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    // UPDATE - Ubah Data Pegawai
   public boolean updatePegawai(int id, String username, String password) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        String query = "UPDATE users SET name = ?, password = ? WHERE id = ? AND role = 'PEGAWAI'";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, bcryptHashString);
            stmt.setInt(3, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error saat mengubah pegawai: " + e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Gagal menutup PreparedStatement: " + e.getMessage());
                }
            }
        }
    }

    // DELETE - Hapus Pegawai
    public boolean deletePegawai(int id) {
        String query = "DELETE FROM users WHERE id = ? AND role = 'PEGAWAI'";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error saat menghapus pegawai: " + e.getMessage());
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("Gagal menutup PreparedStatement: " + e.getMessage());
                }
            }
        }
    }
    
    public List<User> getAllPegawai() {
        List<User> pegawaiList = new ArrayList<>();
        Connection connectDatabase = DatabaseConnection.getConnection();
        String query = "SELECT * FROM users WHERE role = 'PEGAWAI'";

        try (PreparedStatement stmt = connectDatabase.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("name");
                String password = rs.getString("password");
                Pegawai pegawai = new Pegawai(id, username, password);
                pegawaiList.add(pegawai);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching pegawai users: " + e.getMessage());
        }

        return pegawaiList;
    }
}
