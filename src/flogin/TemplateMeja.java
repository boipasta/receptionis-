/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flogin;

import java.awt.Color;
import model.model_meja;
import model.panelborder;

public class TemplateMeja extends javax.swing.JPanel {

    home h;
    model_meja meja;

    public TemplateMeja(home h, model_meja meja) {
        initComponents();
        this.h = h;
        this.meja = meja;

        nomeja.setText(String.valueOf(meja.getNo_meja()));
        statusmeja.setText(meja.getAtas_nama() == null ? "Kosong" : "Dipesan");
        statusmeja.setForeground(meja.getAtas_nama() == null ? Color.red : Color.green);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new panelborder(30);
        nomeja = new javax.swing.JLabel();
        statusmeja = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        nomeja.setFont(new java.awt.Font("Roboto Black", 1, 60)); // NOI18N
        nomeja.setForeground(new java.awt.Color(0, 153, 204));
        nomeja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeja.setText("1");
        nomeja.setFocusTraversalPolicyProvider(true);

        statusmeja.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        statusmeja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusmeja.setText("meja kosong");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusmeja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(nomeja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomeja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusmeja)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        h.tnomeja.setText(String.valueOf(meja.getNo_meja()));
        h.tatasnama.setText(meja.getAtas_nama());
        h.buttonorder.setEnabled(meja.getAtas_nama() == null);
        
        h.mejaDipilih = meja;
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nomeja;
    private javax.swing.JLabel statusmeja;
    // End of variables declaration//GEN-END:variables
}
