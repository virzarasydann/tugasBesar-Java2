/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pegawai;

import java.sql.Timestamp;

/**
 *
 * @author VirzaAbsyar
 */
public class Operasional {
    private int id;
    private String nama;
    private int harga;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Operasional(int id, String nama, int harga, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Operasional(String nama, int harga, Timestamp createdAt, Timestamp updatedAt) {
        
        this.nama = nama;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Operasional(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
