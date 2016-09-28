/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Icon;
import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class Ventana extends JFrame implements WindowListener{
    
    private GUI pantallaPrincipal;
    private PanelJugadas pantallaJugadas;
    private PanelCapturas pantallaCapturas;
    private BorderLayout diseñoDeBordes;

    
    public void reportarCaptura(Icon imagenPiezaCapturada){
        this.pantallaCapturas.agregarCaptura(imagenPiezaCapturada);
    }
    
    public void reportarMovimiento(String jugada){
        this.pantallaJugadas.agregarJugada(jugada);
    }
    
    public Ventana(){
        diseñoDeBordes = new BorderLayout();
        //CADA FRAME TIENE UN JPANEL O CONTENEDOR POR DEFECTO EL CUAL SE LLAMA A SI MISMO COMO THIS
        this.setLayout(diseñoDeBordes); 
        
        pantallaPrincipal = new GUI(this);
        this.add(pantallaPrincipal, BorderLayout.CENTER);
        
        pantallaJugadas = new PanelJugadas(this.pantallaPrincipal);
        
        this.add(pantallaJugadas, BorderLayout.WEST);
        
        
        this.pantallaCapturas = new PanelCapturas(this.pantallaPrincipal);
        this.add(this.pantallaCapturas, BorderLayout.SOUTH);
        this.setVisible(true);
        this.pack();
        
        
    }
    
    public static void main(String[] args) {
        new Ventana();
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
    
}
