/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.DataAccesObject;

import com.tugas.besar.Model.User;
import com.tugas.besar.Model.Pemilik.Pemilik;
import com.tugas.besar.Model.Pegawai.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
