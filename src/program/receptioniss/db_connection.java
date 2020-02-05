/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.receptioniss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boipasta
 */
public class db_connection {
 
    private static Connection koneksi;

    public static Connection getkoneksi() {
        koneksi = null;
        try {
            String url = "jdbc:mysql://localhost:3306/receptionis";
            String user = "root";
            String password = "";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,user,password);

        } catch (SQLException ex) {
            Logger.getLogger(db_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return koneksi;
    }
}
