/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.ProductDAO;
import com.tugas.besar.Model.Pegawai.Product;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class ProductController {
    
    public void create(String nama, int harga, int kategoriId){
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        ProductDAO productDAO = new ProductDAO();

        Product newProduct = new Product(nama, harga, timeNow, timeNow, kategoriId);

        if (productDAO.insert(newProduct)) {
            System.out.println("Produk berhasil disimpan.");
        } else {
            System.err.println("Gagal menyimpan produk.");
        }
        
        
        
        
    }
}
