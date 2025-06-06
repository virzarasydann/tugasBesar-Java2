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
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public boolean login(String inputPass) {
        BCrypt.Result result = BCrypt.verifyer().verify(inputPass.toCharArray(), this.password);
        return result.verified;
    }

   
    public abstract String getRole();
    
    
}
