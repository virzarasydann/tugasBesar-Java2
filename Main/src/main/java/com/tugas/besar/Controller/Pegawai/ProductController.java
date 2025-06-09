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
    
    public List<Product> read() {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.get();
    }

    public boolean create(String nama, int harga, int kategoriId) {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Product newProduct = new Product(nama, harga,  timeNow, timeNow,kategoriId);
        ProductDAO productDAO = new ProductDAO();
        return productDAO.insert(newProduct);
    }

    public boolean update(int id, String namaBaru, int hargaBaru, int kategoriIdBaru) {
        ProductDAO productDAO = new ProductDAO();
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());

        Product product = new Product(namaBaru, hargaBaru,  timeNow, timeNow,kategoriIdBaru);
        product.setId(id);

        return productDAO.update(product);
    }

    public boolean delete(int id) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.delete(id);
    }

}
