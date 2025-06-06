/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller;
import com.tugas.besar.DataAccesObject.userDAO;
import com.tugas.besar.Model.User;
import com.tugas.besar.Model.Pemilik;
import com.tugas.besar.Model.Pegawai;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author VirzaAbsyar
 */
public class AuthController {
    private String username;
    private String password;
    
    
    public User login(String username, String password){
        userDAO userDao = new userDAO();
        User user = userDao.checkUsername(username);

        if (user != null && user.login(password)) {
            
            return user; 
        } else {
            return null; 
        }
    }
}
