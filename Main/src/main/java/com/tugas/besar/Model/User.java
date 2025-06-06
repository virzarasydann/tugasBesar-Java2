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
    private int id;
    private String username;
    private String password;

    public User(int id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    
    public boolean login(String inputPass) {
        return this.password.equals(inputPass);
    }

   
    public abstract String getRole();
    
    
}
