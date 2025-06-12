package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.TransaksiDetailDAO;
import com.tugas.besar.Model.Pegawai.TransaksiDetail;

import java.sql.Timestamp;
import java.util.List;

public class TransaksiDetailController {
   
    private final TransaksiDetailDAO transaksiDetailDAO;

    public TransaksiDetailController() {
        this.transaksiDetailDAO = new TransaksiDetailDAO();
    }
  
    public boolean create(int transaksiId, String produkNama, int quantity, int harga) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        TransaksiDetail detail = new TransaksiDetail(transaksiId, produkNama, quantity, harga, now, now);
        return transaksiDetailDAO.insert(detail);
    }

    // READ
    public List<TransaksiDetail> get() {
        return transaksiDetailDAO.getAll();
    }
}
