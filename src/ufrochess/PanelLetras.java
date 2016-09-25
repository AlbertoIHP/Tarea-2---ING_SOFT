/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alberto
 */
public class PanelLetras extends JPanel{

    private JButton[] letras;
    
    public PanelLetras() {
        //Definimos un arreglo con 9 (El principio es nada) botones en los que se insertara un label con las letras
        this.letras = new JButton[9];
        
        //Utilizamos el metodo crearLetras para que cree los botones y les setee un label con la letra en cuestion
        this.crearLetras();
        
        //Definimos un diseño de panel como una matriz de 1 filas y 9 columna
        this.setLayout(new GridLayout(1,9));
        
    }

    private void crearLetras() {
        //Definimos la letra inicial
        char letra = 'a';
        
         for (int i = 0; i < 9; i++) {
            //Creamos el nuevo boton
            this.letras[i] = new JButton();
            
            //Le insertamos un label con el numero en cuestion
            if(i == 0){
                //En la primera no hay 
            }else{
            this.letras[i].setLabel(String.valueOf(letra));
            letra++;
            }
            
            //Seteamos su color en blanco
            this.letras[i].setBackground(Color.WHITE);
            
            //Y lo desabilitamos para ser clickeado
            this.letras[i].setEnabled(false);
            
            //Finalmente lo añadimos al panel en el que estamos contenidos (Nosotros mismos)
            this.add(this.letras[i]);
        }
        
    }
    
    
    
    
    
}
