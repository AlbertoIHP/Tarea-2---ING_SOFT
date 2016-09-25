/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alberto
 */
public class PanelNumeros extends JPanel{

    private JButton[] numeros;
    
    public PanelNumeros() {
        //Definimos un arreglo con 8 botones en los que se insertara un label con los numeros
        this.numeros = new JButton[8];
        
        //Utilizamos el metodo crearNumeros para que cree los botones y les setee un label con el numero en cuestion
        this.crearNumeros();
        
        //Definimos un diseño de matriz de 8 filas y 1 columna
        this.setLayout(new GridLayout(8,1));
        
       
    }
    
    
    public void crearNumeros(){
        
        for (int i = 0; i < 8; i++) {
            //Creamos el nuevo boton
            this.numeros[i] = new JButton();
            
            //Le insertamos un label con el numero en cuestion
            this.numeros[i].setLabel(String.valueOf((i+1)));
            
            //Seteamos su color en blanco
            this.numeros[i].setBackground(Color.WHITE);
            
            //Y lo desabilitamos para ser clickeado
            this.numeros[i].setEnabled(false);
            
            //Finalmente lo añadimos al panel en el que estamos contenidos (Nosotros mismos)
            this.add(this.numeros[i]);
        }
    }
    
    
}
