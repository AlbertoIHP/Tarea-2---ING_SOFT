package ufrochess;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Cares para Ing. de Software
 */
public class GUI extends JFrame implements WindowListener{
    private MiAjedrez tablero;
    private PanelLetras panelLetras;
    private PanelNumeros panelNumeros;
    private BorderLayout diseñoDeBordes;    
    
    
    public GUI() {
        //CON ESTE PODEMOS DEFINIR EL TITULO DE LA VENTANA
        super("Juego del Ajedrez"); // el titulo de la ventana
        
        diseñoDeBordes = new BorderLayout();
        //CADA FRAME TIENE UN JPANEL O CONTENEDOR POR DEFECTO EL CUAL SE LLAMA A SI MISMO COMO THIS
        this.setLayout(diseñoDeBordes); // Le damos un diseño de bordes
        
        
        //MEDIANTE ADD AGREGAMOS ELEMENTOS A NUESTRO JPANEL (CONTENEDOR), PUEDEN SER BOTONES, LABEL, MAS JPANEL, ETC.
        
         //REALIZANDO UNA MODIFICACION Y DEJANDO MIAJEDREZ COMO UN JPANEL, ESTE PUEDE SER INTRODUCIDO EN CUALQUEIR JFRAME (VENTANA)
        tablero = new MiAjedrez();
        Torre t = new Torre("negro");
        Torre q = new Torre("negro");
        tablero.ponerPieza("c4", t);
        tablero.ponerPieza("c6", q);
        this.add(tablero, BorderLayout.CENTER);
        
        
        //Ponemos a la izquierda o al oeste el panel de letras
        panelLetras = new PanelLetras();
        this.add(panelLetras, BorderLayout.SOUTH);
        
        //Ponemos abajo o al sur el panel de numeros
        panelNumeros = new PanelNumeros();
        this.add(panelNumeros, BorderLayout.WEST);
        
        
       
        this.setVisible(true); // mostramos la ventana 
        //this.pack(); // la ajustamos 
        
        //Como esta clase tiene un rol de escuchador de ventana entonces, le podemos decir que se escuche a si misma para reaccionar
        this.addWindowListener(this);
    }

    public static void main(String[] a) {
         new GUI();
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
