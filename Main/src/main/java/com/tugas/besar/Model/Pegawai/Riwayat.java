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
public class Riwayat {
    private int id;
    private String nama;
    private int totalHarga;
    private String metodePembayaran;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    

    public Riwayat(int id, String nama, int totalHarga, String metodePembayaran, Timestamp CreatedAt, Timestamp UpdatedAt) {
        this.id = id;
        this.nama = nama;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
    }

    public Riwayat(String nama, int totalHarga, String metodePembayaran, Timestamp CreatedAt, Timestamp UpdatedAt) {
        this.nama = nama;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
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

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Timestamp CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public Timestamp getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Timestamp UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }
    
    
}
