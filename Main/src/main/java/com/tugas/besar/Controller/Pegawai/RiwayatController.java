/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.besar.Controller.Pegawai;

import com.tugas.besar.DataAccesObject.Pegawai.RiwayatDAO;
import com.tugas.besar.Model.Pegawai.Riwayat;
import java.util.List;

/**
 *
 * @author VirzaAbsyar
 */
public class RiwayatController {
    public List<Riwayat> read() {
        RiwayatDAO riwayatDAO = new RiwayatDAO();
        return riwayatDAO.get();
    }
    
    
}
