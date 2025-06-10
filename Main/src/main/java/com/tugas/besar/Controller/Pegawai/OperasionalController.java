/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.OperasionalDAO;
import com.tugas.besar.Model.Pegawai.Operasional;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class OperasionalController {
    public List<Operasional> read() {
        OperasionalDAO operasionalDAO = new OperasionalDAO();
        return operasionalDAO.get();
    }

    public boolean create(String nama, int harga) {
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Operasional newOperasional = new Operasional(nama, harga,  timeNow, timeNow);
        OperasionalDAO operasionalDAO = new OperasionalDAO();
        return operasionalDAO.insert(newOperasional);
    }

    public boolean update(int id, String namaBaru, int hargaBaru) {
        OperasionalDAO operasionalDAO = new OperasionalDAO();
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());

        Operasional newOperasional = new Operasional(namaBaru, hargaBaru,  timeNow, timeNow);
        newOperasional.setId(id);

        return operasionalDAO.update(newOperasional);
    }

    public boolean delete(int id) {
        OperasionalDAO operasionalDAO = new OperasionalDAO();
        return operasionalDAO.delete(id);
    }
}
