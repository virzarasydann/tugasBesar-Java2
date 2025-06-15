/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Model.Pemilik;

/**
 *
 * @author VirzaAbsyar
 */
public class StatistikBulanan {
    private int bulan;
    private double totalPendapatan;

    public StatistikBulanan(int bulan, double totalPendapatan) {
        this.bulan = bulan;
        this.totalPendapatan = totalPendapatan;
    }

    public int getBulan() {
        return bulan;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }
}
