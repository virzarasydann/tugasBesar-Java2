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
public class Kategori {
    private int id;
    private String nama;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Kategori(String nama, Timestamp createdAt, Timestamp updatedAt) {
        
        this.nama = nama;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
