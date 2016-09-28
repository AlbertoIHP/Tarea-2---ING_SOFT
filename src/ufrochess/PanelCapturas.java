/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alberto
 */
public class PanelCapturas extends JPanel{
    private JButton[] piezasCapturadas;
    private int indiceCaptura;
    private GUI comunicacionTablero;
    private GridLayout diseñoMatriz;

    public PanelCapturas(GUI gui) {
        //Definimos un arreglo con 9 (El principio es nada) botones en los que se insertara un label con las letras
        this.piezasCapturadas = new JButton[16];
        
        this.comunicacionTablero = gui;
        this.indiceCaptura = 0;
        this.diseñoMatriz = new GridLayout(1, 16);
        //Definimos un diseño de panel como una matriz de 1 filas y 9 columna
        this.setLayout(this.diseñoMatriz);
        
        this.diseñoMatriz.setColumns(8);
        this.diseñoMatriz.setRows(2);
        this.agregarPieza();
        this.rePintarTablero();
    }
    
    
    public void agregarCaptura(Icon imagenPiezaCapturada){
        
        this.piezasCapturadas[this.indiceCaptura].setIcon(imagenPiezaCapturada);
        this.rePintarTablero();
        indiceCaptura++;
    }
    
    public void rePintarTablero(){
        this.removeAll();
        this.repaint();
        for (int i = 0; i < 16; i++) {
            this.add(this.piezasCapturadas[i]);
        }
    }
    public void agregarPieza(){
        for (int i = 0; i < 16; i++) {
            JButton boton = new JButton(" ");
            this.piezasCapturadas[i] = boton;
            boton.setRolloverEnabled(false);
            boton.setBackground(Color.LIGHT_GRAY);
        }
    }
    
    public void agregarPieza(Casilla pieza){
        
        this.piezasCapturadas[indiceCaptura] = pieza;
        this.add(this.piezasCapturadas[indiceCaptura]);
        
        indiceCaptura++;
        
        
    }
    
    
    
    
}
