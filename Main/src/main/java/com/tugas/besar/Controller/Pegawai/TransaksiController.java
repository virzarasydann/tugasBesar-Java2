package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.TransaksiDAO;
import com.tugas.besar.Model.Pegawai.Transaksi;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class TransaksiController {
    
    
    public List<Transaksi> read() {
        TransaksiDAO transaksiDAO = new TransaksiDAO();
        return transaksiDAO.get();  
    }

    
    public Integer create(String nama, int totalHarga, String metodePembayaran) {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Transaksi newTransaksi = new Transaksi(nama, totalHarga, metodePembayaran, timeNow, timeNow);
        TransaksiDAO transaksiDAO = new TransaksiDAO();
        return transaksiDAO.insert(newTransaksi);
    }

    
    public boolean update(int id, String namaBaru, int totalHargaBaru, String metodePembayaranBaru) {
        TransaksiDAO transaksiDAO = new TransaksiDAO();
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());

        Transaksi transaksi = new Transaksi(
            namaBaru,
            totalHargaBaru,
            metodePembayaranBaru,
            timeNow,
            timeNow
        );
        transaksi.setId(id);

        return transaksiDAO.update(transaksi);
    }

    
    public boolean delete(int id) {
        TransaksiDAO transaksiDAO = new TransaksiDAO();
        return transaksiDAO.delete(id);
    }
}