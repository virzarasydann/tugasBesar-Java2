/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.KategoriDAO;
import com.tugas.besar.DataAccesObject.Pegawai.ProductDAO;
import com.tugas.besar.Model.Pegawai.Kategori;
import com.tugas.besar.Model.Pegawai.Product;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class KategoriController {
   public boolean create(String nama) {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        KategoriDAO kategoriDAO = new KategoriDAO();

        Kategori newKategori = new Kategori(nama, timeNow, timeNow);

        return kategoriDAO.create(newKategori);
    }

    public List<Kategori> read() {
        KategoriDAO kategoriDAO = new KategoriDAO();
        return kategoriDAO.read();
    }

    public boolean update(int id, String namaBaru) {
        KategoriDAO kategoriDAO = new KategoriDAO();
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());

        Kategori kategori = new Kategori(namaBaru, null, timeNow);
        kategori.setId(id);

        return kategoriDAO.update(kategori);
    }

    public boolean delete(int id) {
        KategoriDAO kategoriDAO = new KategoriDAO();
        return kategoriDAO.delete(id);
    }
}
