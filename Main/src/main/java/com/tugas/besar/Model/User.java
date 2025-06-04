/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model;

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
        return this.password.equals(inputPass);
    }

   
    public abstract String getRole();
    
    
}
