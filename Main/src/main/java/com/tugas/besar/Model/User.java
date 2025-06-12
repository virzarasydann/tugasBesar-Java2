/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 *
 * @author VirzaAbsyar
 */
// model/User.java
public abstract class User {
    private int id;
    private String username;
    private String password;

    public User(int id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    
    public boolean login(String inputPass) {
        BCrypt.Result result = BCrypt.verifyer().verify(inputPass.toCharArray(), this.password);
        return result.verified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return  username;
    }
    
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

   
    public abstract String getRole();
    
    
}
