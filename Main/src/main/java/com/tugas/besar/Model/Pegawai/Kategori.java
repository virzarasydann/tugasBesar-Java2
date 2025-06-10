/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pegawai;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author VirzaAbsyar
 */
public class Kategori {
    private int id;
    private String nama;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Kategori(int id,String nama, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.nama = nama;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
     public Kategori(String nama, Timestamp createdAt, Timestamp updatedAt) {
        
        this.nama = nama;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
     
     public Kategori(String nama) {
        
        this.nama = nama;
        
    }
    
    
    @Override
    public String toString() {
        return nama; // Ini akan ditampilkan di JComboBox
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kategori)) return false;
        Kategori other = (Kategori) o;
        return id == other.id; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
