/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pegawai;

/**
 *
 * @author VirzaAbsyar
 */
public class Keranjang {
    private String namaMakanan;
    private int hargaMakanan;
    private int jumlahPesanan;
    

    public Keranjang(String namaMakanan, int hargaMakanan, int jumlahPesanan) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.jumlahPesanan = jumlahPesanan;
    }
    
    public Keranjang(String namaMakanan, int hargaMakanan) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;

    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public int getHargaMakanan() {
        return hargaMakanan;
    }

    public void setHargaMakanan(int hargaMakanan) {
        this.hargaMakanan = hargaMakanan;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }
    
    
    
}
