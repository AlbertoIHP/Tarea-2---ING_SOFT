/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alberto
 */
public class PanelJugadas extends JPanel {

    private GridLayout diseñoMatriz;
    private GUI comunicacionTablero;
    private JLabel[] registroMovimientos;
    private int indiceJugadas;
    private int reportesJugadas;
    private String textoPrevio;

    public PanelJugadas(GUI gui) {
        this.reportesJugadas = 1;
        this.textoPrevio = "";
        diseñoMatriz = new GridLayout(1, 20);
        registroMovimientos = new JLabel[20];
        this.comunicacionTablero = gui;
        this.setLayout(diseñoMatriz);

        this.diseñoMatriz.setColumns(2);
        this.diseñoMatriz.setRows(20);

        this.agregarFilas();
        this.rePintarTablero();
    }

    public void agregarJugada(String jugada) {

        if (indiceJugadas == 1) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 2) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        if (indiceJugadas == 3) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 4) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }

        
        if (indiceJugadas == 5) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 6) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        if (indiceJugadas == 7) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 8) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        if (indiceJugadas == 9) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 10) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        
        
        if (indiceJugadas == 11) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 12) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        if (indiceJugadas == 13) {
            this.registroMovimientos[this.indiceJugadas] = new JLabel(reportesJugadas + "                                                    " + jugada);
        } else {
            if (indiceJugadas == 14) {
                String a = this.registroMovimientos[this.indiceJugadas - 1].getText();
                this.registroMovimientos[this.indiceJugadas - 1].setText(a +"                                "+jugada);
                this.reportesJugadas++;
            }
        }
        
        /*
        this.registroMovimientos[this.indiceJugadas] = new JLabel(indiceJugadas + "                                                    " + jugada);

        String a = this.registroMovimientos[this.indiceJugadas].getText();
        this.registroMovimientos[this.indiceJugadas].setText(a + jugada);
        */
        
        this.rePintarTablero();

    }

    public void rePintarTablero() {
        this.removeAll();
        this.repaint();
        for (int i = 0; i < 20; i++) {
            this.add(this.registroMovimientos[i]);
        }
    }

    public void agregarFilas() {
        for (int i = 0; i < 20; i++) {
            if (i == 0) {

                JLabel etiqueta = new JLabel("Numero Jugada                     JugadaB                     JugadaN");
                this.registroMovimientos[i] = etiqueta;
                indiceJugadas++;
                etiqueta.setBackground(Color.WHITE);

                /*
                 JButton boton = new JButton("Historial Jugadas ");
                 this.registroMovimientos[i] = n;
                 boton.setRolloverEnabled(false);
                 boton.setBackground(Color.LIGHT_GRAY);
                 
                 */
            } else {
                JLabel etiqueta = new JLabel(" ");
                this.registroMovimientos[i] = etiqueta;
                etiqueta.setBackground(Color.WHITE);
                /*
                 JButton boton = new JButton(" ");
                 this.registroMovimientos[i] = boton;
                 boton.setEnabled(false);
                 boton.setRolloverEnabled(false);
                 boton.setBackground(Color.LIGHT_GRAY);
                 */
            }
        }
    }

}
