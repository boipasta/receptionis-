/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BoiPasta
 */
public class rincian_order {
    int id;
    int penjual;
    int barang;
    int totalbarang;
    int harga;

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public rincian_order() {
    }

  
    public rincian_order(int id, int penjual, int barang, int totalbarang) {
        this.id = id;
        this.penjual = penjual;
        this.barang = barang;
        this.totalbarang = totalbarang;
    }
    public List<rincian_order> get(Connection c,int id) {
        List<rincian_order> bList = new ArrayList<>();
        String sql = "SELECT * FROM rincian_order WHERE id_penjual='"+ id +"'";

        try (Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql)) {
            while (r.next()) {
               
                rincian_order list = new rincian_order();
                list.setId(r.getInt("id"));
                list.setPenjual(r.getInt("id_penjual"));
                list.setBarang(r.getInt("id_barang"));
                list.setTotalbarang(r.getInt("total_barang"));

                bList.add(list);
            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(rincian_order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;
    }
    public boolean INSERT(Connection c){
         String sql = "INSERT INTO rincian_order values(?,?,?,?)";
         
            try(PreparedStatement s = (PreparedStatement)c.prepareStatement(sql)){
                s.setInt(1, id);
                s.setInt(2,penjual );
                s.setInt(3,barang);
                s.setInt(4,totalbarang);
                
                s.executeUpdate();
                s.close();
                return true;
            }catch(SQLException ex){
             Logger.getLogger(rincian_order.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPenjual() {
        return penjual;
    }

    public void setPenjual(int penjual) {
        this.penjual = penjual;
    }

    public int getBarang() {
        return barang;
    }

    public void setBarang(int barang) {
        this.barang = barang;
    }

    public int getTotalbarang() {
        return totalbarang;
    }

    public void setTotalbarang(int totalbarang) {
        this.totalbarang = totalbarang;
    }
    
    
}
