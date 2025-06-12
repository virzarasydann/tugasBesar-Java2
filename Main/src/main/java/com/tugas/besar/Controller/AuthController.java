/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller;
import com.tugas.besar.DataAccesObject.userDAO;
import com.tugas.besar.Model.User;
import com.tugas.besar.Model.Pemilik.Pemilik;
import com.tugas.besar.Model.Pegawai.Pegawai;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

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
    
    public boolean registerPegawai(String username, String password) {
    userDAO userDao = new userDAO();
    return userDao.tambahPegawai(username, password);
}

    // UPDATE Pegawai
    public boolean editPegawai(int id, String username, String password) {
        userDAO userDao = new userDAO();
        return userDao.updatePegawai(id, username, password);
    }

    // DELETE Pegawai
    public boolean hapusPegawai(int id) {
        userDAO userDao = new userDAO();
        return userDao.deletePegawai(id);
    }
    
    public List<User> getAllPegawai() {
        userDAO userDao = new userDAO();
        return userDao.getAllPegawai();
    }
}
