/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pegawai;

/**
 *
 * @author VirzaAbsyar
 */
public class TransaksiStatistik {
    private int totalTransaksi;
    private double totalPendapatan;
    private double rataRataPendapatan;

    public TransaksiStatistik(int totalTransaksi, double totalPendapatan, double rataRataPendapatan) {
        this.totalTransaksi = totalTransaksi;
        this.totalPendapatan = totalPendapatan;
        this.rataRataPendapatan = rataRataPendapatan;
    }

    public int getTotalTransaksi() {
        return totalTransaksi;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }

    public double getRataRataPendapatan() {
        return rataRataPendapatan;
    }
}
