/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pemilik;

import com.tugas.besar.Model.User;

/**
 *
 * @author VirzaAbsyar
 */
public class Pemilik extends User{
    public Pemilik(int id,String username, String password) {
        super(id,username, password);
    }

    @Override
    public String getRole() {
        return "PEMILIK";
    }

    
    public void generateLaporanKeuangan() {
        System.out.println("Menampilkan laporan keuangan...");
    }
}
