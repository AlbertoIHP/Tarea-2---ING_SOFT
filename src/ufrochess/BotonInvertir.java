/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class BotonInvertir extends JButton implements MouseListener{

    GUI padre;
    
    public BotonInvertir(GUI padre) {
        this.padre = padre;
        this.setLabel("INVERTIR TABLERO");
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
    }

    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        this.padre.invertirTablero();
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
}
