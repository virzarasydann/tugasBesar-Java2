package com.tugas.besar.Model.Pegawai;

import java.sql.Timestamp;

public class Product {
    private int id;
    private String nama;
    private int harga;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int kategoriId;

    
    public Product(String nama, int harga,Timestamp createdAt, Timestamp updatedAt, int kategoriId) {
        this.nama = nama;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.kategoriId = kategoriId;
    }

  
    public Product(int id, String nama, int harga, Timestamp createdAt, Timestamp updatedAt, int kategoriId) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.kategoriId = kategoriId;
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

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }
    
    
    
    
}
