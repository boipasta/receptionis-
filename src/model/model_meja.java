/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BoiPasta
 */
public class model_meja {

    int id_meja;
    int no_meja;
    String atas_nama;

    public int getId_meja() {
        return id_meja;
    }

    public void setId_meja(int id_meja) {
        this.id_meja = id_meja;
    }

    public int getNo_meja() {
        return no_meja;
    }

    public void setNo_meja(int no_meja) {
        this.no_meja = no_meja;
    }

    public String getAtas_nama() {
        return atas_nama;
    }

    public void setAtas_nama(String atas_nama) {
        this.atas_nama = atas_nama;
    }

    public model_meja(int id_meja, int no_meja, String atas_nama) {
        this.id_meja = id_meja;
        this.no_meja = no_meja;
        this.atas_nama = atas_nama;
    }

    public model_meja() {
    }

    public boolean update(Connection c) {
        StringBuilder sql = new StringBuilder("UPDATE entri_meja SET");

        if (id_meja == 0) {
            return false;
        }
        if (atas_nama != null) {
            sql.append(" atas_nama='").append(atas_nama).append("', ");
        }
        if (no_meja != 0) {
            sql.append(" no_meja='").append(no_meja).append("', ");
        }
        sql.deleteCharAt(sql.length() - 2);
        sql.append(" WHERE id_meja ='").append(id_meja).append("'");
        System.out.println(sql);
        try (Statement s = c.createStatement()) {
            s.executeUpdate(sql.toString());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(model_meja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
