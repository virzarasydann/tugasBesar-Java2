/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model;

/**
 *
 * @author VirzaAbsyar
 */
public class Pemilik extends User{
    public Pemilik(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRole() {
        return "PEMILIK";
    }

    
    public void generateLaporanKeuangan() {
        System.out.println("Menampilkan laporan keuangan...");
    }
}
