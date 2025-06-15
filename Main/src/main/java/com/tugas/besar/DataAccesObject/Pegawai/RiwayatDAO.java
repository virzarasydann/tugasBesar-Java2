/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.DataAccesObject.Pegawai;

import com.tugas.besar.DataAccesObject.DatabaseConnection;
import com.tugas.besar.Model.Pegawai.Riwayat;
import com.tugas.besar.Model.Pegawai.TransaksiStatistik;
import com.tugas.besar.Model.Pemilik.StatistikBulanan;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;


/**
 *
 * @author VirzaAbsyar
 */
public class RiwayatDAO {
    private final Connection connection;

    public RiwayatDAO() {
        this.connection = DatabaseConnection.getConnection();
    }
    
    public List<Riwayat> get() {
        List<Riwayat> riwayatList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Riwayat riwayat = new Riwayat(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("total_harga"),
                        rs.getString("metode_pembayaran"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                riwayatList.add(riwayat);
            }

        } catch (SQLException e) {
            System.err.println("Fetch all transaksi failed: " + e.getMessage());
        }

        return riwayatList;
    }
    
    public TransaksiStatistik getTransaksiStatistik() {
    String sql = "SELECT COUNT(*) AS total_transaksi, SUM(total_harga) AS total_pendapatan, AVG(total_harga) AS rata_rata_pendapatan FROM transaksi";

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if (rs.next()) {
            int totalTransaksi = rs.getInt("total_transaksi");
            double totalPendapatan = rs.getDouble("total_pendapatan");
            double rataRata = rs.getDouble("rata_rata_pendapatan");

            return new TransaksiStatistik(totalTransaksi, totalPendapatan, rataRata);
        }

    } catch (SQLException e) {
        System.err.println("Gagal ambil statistik transaksi: " + e.getMessage());
    }

    return new TransaksiStatistik(0, 0, 0); // Default jika error
}
    
    
    
    public List<Riwayat> getByTanggal(Date tanggal) {
        List<Riwayat> riwayatList = new ArrayList<>();
        String sql = "SELECT * FROM transaksi WHERE DATE(created_at) = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(tanggal.getTime()));
            
            System.out.println(new java.sql.Date(tanggal.getTime()));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Riwayat riwayat = new Riwayat(
                            rs.getInt("id"),
                            rs.getString("nama"),
                            rs.getInt("total_harga"),
                            rs.getString("metode_pembayaran"),
                            rs.getTimestamp("created_at"),
                            rs.getTimestamp("updated_at")
                    );
                    riwayatList.add(riwayat);
                }
            }

        } catch (SQLException e) {
            System.err.println("Gagal fetch transaksi by tanggal: " + e.getMessage());
        }

        return riwayatList;
    }

    public TransaksiStatistik getStatistikByTanggal(Date tanggal) {
        String sql = "SELECT COUNT(*) AS total_transaksi, SUM(total_harga) AS total_pendapatan, AVG(total_harga) AS rata_rata_pendapatan FROM transaksi WHERE DATE(created_at) = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(tanggal.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total_transaksi");
                    double sum = rs.getDouble("total_pendapatan");
                    double avg = rs.getDouble("rata_rata_pendapatan");

                    return new TransaksiStatistik(total, sum, avg);
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal ambil statistik by tanggal: " + e.getMessage());
        }

        return new TransaksiStatistik(0, 0, 0);
    }
    
    
    public List<Riwayat> getByRentangTanggal(Date dari, Date sampai) {
        List<Riwayat> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi WHERE created_at >= ? AND created_at <= ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Timestamp start = new Timestamp(dari.getTime());
            Timestamp end = new Timestamp(sampai.getTime());

            stmt.setTimestamp(1, start);
            stmt.setTimestamp(2, end);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Riwayat r = new Riwayat(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getInt("total_harga"),
                    rs.getString("metode_pembayaran"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
                );
                list.add(r);
            }

        } catch (SQLException e) {
            System.err.println("Gagal ambil data by rentang: " + e.getMessage());
        }

        return list;
    }

    public TransaksiStatistik getStatistikByRentangTanggal(Date dari, Date sampai) {
        String sql = "SELECT COUNT(*) AS total_transaksi, SUM(total_harga) AS total_pendapatan, AVG(total_harga) AS rata_rata_pendapatan FROM transaksi WHERE created_at >= ? AND created_at <= ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Timestamp start = new Timestamp(dari.getTime());
            Timestamp end = new Timestamp(sampai.getTime());

            stmt.setTimestamp(1, start);
            stmt.setTimestamp(2, end);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TransaksiStatistik(
                    rs.getInt("total_transaksi"),
                    rs.getDouble("total_pendapatan"),
                    rs.getDouble("rata_rata_pendapatan")
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal ambil statistik by rentang: " + e.getMessage());
        }

        return new TransaksiStatistik(0, 0, 0);
    }
    
    
    
    public List<StatistikBulanan> getStatistikBulananByTahunDanBulan(int tahun, int bulan) {
        List<StatistikBulanan> list = new ArrayList<>();

        String sql = "SELECT MONTH(created_at) AS bulan, SUM(total_harga) AS total_pendapatan " +
                     "FROM transaksi " +
                     "WHERE YEAR(created_at) = ? AND MONTH(created_at) = ? " +
                     "GROUP BY MONTH(created_at)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, tahun);
            stmt.setInt(2, bulan);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bulanDB = rs.getInt("bulan");
                double pendapatan = rs.getDouble("total_pendapatan");
                list.add(new StatistikBulanan(bulanDB, pendapatan));
            }

        } catch (SQLException e) {
            System.err.println("Gagal ambil statistik bulanan per bulan & tahun: " + e.getMessage());
        }

        return list;
    }



}
