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
public class hasil_order {

    int id;
    int nomeja;
    String atasnama;
    String tgl_order;
    int total;

    public hasil_order() {
    }

    public hasil_order(int id, int nomeja, String atasnama, String tgl_order, int total) {
        this.id = id;
        this.nomeja = nomeja;
        this.atasnama = atasnama;
        this.tgl_order = tgl_order;
        this.total = total;
    }

    public List<hasil_order> get(Connection c) {
        List<hasil_order> bList = new ArrayList<>();
        String sql = "SELECT * FROM hasil_order";

        try (Statement s = c.createStatement();
                ResultSet r = s.executeQuery(sql)) {
            while (r.next()) {

                hasil_order list = new hasil_order();
                list.setId(r.getInt("id"));
                list.setNomeja(r.getInt("no_meja"));
                list.setAtasnama(r.getString("atas_nama"));
                list.setTgl_order(r.getString("tgl_order"));
                list.setTotal(r.getInt("total"));

                bList.add(list);
            }
            r.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(hasil_order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bList;
    }

    public int INSERT(Connection c) {
        int b = -1;
        String sql = "INSERT INTO hasil_order values(?,?,?,?,?)";

        try (PreparedStatement s = (PreparedStatement) c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            s.setInt(1, id);
            s.setInt(2, nomeja);
            s.setString(3, atasnama);
            s.setString(4, tgl_order);
            s.setInt(5, total);

            s.executeUpdate();
            try (ResultSet r = s.getGeneratedKeys()) {
                if (r.next()) {
                    b = r.getInt(1);

                }
                r.close();
            }
            s.close();

        } catch (SQLException ex) {
            Logger.getLogger(hasil_order.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomeja() {
        return nomeja;
    }

    public void setNomeja(int nomeja) {
        this.nomeja = nomeja;
    }

    public String getAtasnama() {
        return atasnama;
    }

    public void setAtasnama(String atasnama) {
        this.atasnama = atasnama;
    }

    public String getTgl_order() {
        return tgl_order;
    }

    public void setTgl_order(String tgl_order) {
        this.tgl_order = tgl_order;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
