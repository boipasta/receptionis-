/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mbarang {

    int id;
    int harga;
    String jenisbarang;
    String namabarang;
    byte[] gambarmakanan;

    public mbarang() {
    }

    public mbarang(int id, int harga, String jenisbarang, String namabarang, byte[] gambarmakanan) {
        this.id = id;
        this.harga = harga;
        this.jenisbarang = jenisbarang;
        this.namabarang = namabarang;
        this.gambarmakanan = gambarmakanan;
    }

    public List<mbarang> get(Connection c) {
        List<mbarang> bList = new ArrayList<>();
        String sql = "SELECT * FROM ebarang";

        try (Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql)) {
            while (r.next()) {
                Blob blobgambar = (Blob) r.getBlob(4);
                byte[] bytegambar = blobgambar.getBytes(1, (int) blobgambar.length());

                mbarang list = new mbarang();
                list.setId(r.getInt("id"));
                list.setNamabarang(r.getString("nama_barang"));
                list.setJenisbarang(r.getString("jenis_barang"));
                list.setGambarmakanan(bytegambar);
                list.setHarga(r.getInt("harga"));

                bList.add(list);
            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(mbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;

    }

    public mbarang get(Connection c, int id) {
        mbarang bar = new mbarang();
        String sql = "SELECT * FROM ebarang WHERE id='" + id + "'";

        try (Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql)) {
            while (r.next()) {
                Blob blobgambar = (Blob) r.getBlob(4);
                byte[] bytegambar = blobgambar.getBytes(1, (int) blobgambar.length());

                bar.setId(r.getInt("id"));
                bar.setNamabarang(r.getString("nama_barang"));
                bar.setJenisbarang(r.getString("jenis_barang"));
                bar.setGambarmakanan(bytegambar);
                bar.setHarga(r.getInt("harga"));
            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(mbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getJenisbarang() {
        return jenisbarang;
    }

    public void setJenisbarang(String jenisbarang) {
        this.jenisbarang = jenisbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public byte[] getGambarmakanan() {
        return gambarmakanan;
    }

    public void setGambarmakanan(byte[] gambarmakanan) {
        this.gambarmakanan = gambarmakanan;
    }
}
