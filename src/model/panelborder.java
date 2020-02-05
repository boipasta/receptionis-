package model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boipasta
 */
public class panelborder extends JPanel {
    private int cornerRadius = 15;
    
    public panelborder(int radius){
        super();
        cornerRadius = radius;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension arcs= new Dimension(cornerRadius,cornerRadius);
        Graphics2D graphichs = (Graphics2D) g;
        graphichs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphichs.setColor(getBackground());
        graphichs.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        graphichs.setColor(getForeground());
        super.paintComponent(g);
    }
   
    
}
