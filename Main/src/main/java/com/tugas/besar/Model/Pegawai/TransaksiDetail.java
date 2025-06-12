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
public class TransaksiDetail {
    private int id;
    private int idTransaksi;
    private String produkNama;
    private int quantity;
    private int harga;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public TransaksiDetail(int idTransaksi, String produkNama, int quantity, int harga, Timestamp createdAt, Timestamp updatedAt) {
        
        this.idTransaksi = idTransaksi;
        this.produkNama = produkNama;
        this.quantity = quantity;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransaksiDetail(int id, int idTransaksi, String produkNama, int quantity, int harga, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.idTransaksi = idTransaksi;
        this.produkNama = produkNama;
        this.quantity = quantity;
        this.harga = harga;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getProdukNama() {
        return produkNama;
    }

    public void setProdukNama(String produkNama) {
        this.produkNama = produkNama;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
