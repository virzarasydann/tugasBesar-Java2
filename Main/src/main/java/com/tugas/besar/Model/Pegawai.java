/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model;

/**
 *
 * @author VirzaAbsyar
 */
public class Pegawai extends User{
    public Pegawai(int id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public String getRole() {
        return "PEGAWAI";
    }

    
    public void inputTransaksi() {
        System.out.println("Input transaksi baru...");
    }
}
