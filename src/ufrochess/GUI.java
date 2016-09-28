package ufrochess;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Cares para Ing. de Software
 */
public class GUI extends JPanel {

    private MiAjedrez tablero;
    private PanelLetras panelLetras;
    private PanelNumeros panelNumerosIzquierda, panelNumerosDerecha;
    private BorderLayout diseñoDeBordes;
    private boolean isInvertido;
    public Ventana miPadre;

    public void invertirTablero() {
        if (isInvertido) {
            System.out.println("ENDEREZANDO");
            this.panelNumerosIzquierda.enderezarPanel();
            this.panelNumerosDerecha.enderezarPanel();
            this.tablero.enderezarTablero();
            this.isInvertido = false;
        } else {
            System.out.println("INVIRTIENDO");
            this.tablero.invertirTablero();
            this.panelNumerosDerecha.invertirPanel();
            this.panelNumerosIzquierda.invertirPanel();
            this.isInvertido = true;
        }
    }
    
    public Casilla pedirCasilla(){
        return null;
    }

    public void reportarCaptura(Icon imagenPiezaCapturada){
        this.miPadre.reportarCaptura(imagenPiezaCapturada);
    }
    
    public void reportarMovimiento(String jugada){
        this.miPadre.reportarMovimiento(jugada);
    }
    
    
    
    public GUI(Ventana miPadre) {

        this.miPadre = miPadre;
        //CON ESTE PODEMOS DEFINIR EL TITULO DE LA VENTANA
        //super("Juego del Ajedrez"); // el titulo de la ventana
        this.isInvertido = false;
        diseñoDeBordes = new BorderLayout();
        //CADA FRAME TIENE UN JPANEL O CONTENEDOR POR DEFECTO EL CUAL SE LLAMA A SI MISMO COMO THIS
        this.setLayout(diseñoDeBordes); // Le damos un diseño de bordes

        //MEDIANTE ADD AGREGAMOS ELEMENTOS A NUESTRO JPANEL (CONTENEDOR), PUEDEN SER BOTONES, LABEL, MAS JPANEL, ETC.
        //REALIZANDO UNA MODIFICACION Y DEJANDO MIAJEDREZ COMO UN JPANEL, ESTE PUEDE SER INTRODUCIDO EN CUALQUEIR JFRAME (VENTANA)
        //tablero = new MiAjedrez();
        tablero = new MiAjedrez(0, this);
        
        
        //PIEZAS NEGRAS
        for (char i = 'a'; i <= 'e'; i++) {
            if (i == 'a') {
                tablero.ponerPieza(i + "8", new Torre("negro"));
                tablero.ponerPieza("h8", new Torre("negro"));
            } else if (i == 'b') {
                tablero.ponerPieza(i + "8", new Caballo("negro"));
                tablero.ponerPieza("g8", new Caballo("negro"));
            } else if (i == 'c') {
                tablero.ponerPieza(i + "8", new Alfil("negro"));
                tablero.ponerPieza("f8", new Alfil("negro"));

            } else if (i == 'd') {
                tablero.ponerPieza(i + "8", new Rey("negro"));
            } else if (i == 'e') {
                tablero.ponerPieza(i + "8", new Dama("negro"));
            }
        }

        for (char i = 'a'; i <= 'h'; i++) {
            tablero.ponerPieza(i + "7", new Peon("negro"));
        }

        //PIEZAS BLANCAS
        for (char i = 'a'; i <= 'e'; i++) {
            if (i == 'a') {
                tablero.ponerPieza(i + "1", new Torre("blanco"));
                tablero.ponerPieza("h1", new Torre("blanco"));
            } else if (i == 'b') {
                tablero.ponerPieza(i + "1", new Caballo("blanco"));
                tablero.ponerPieza("g1", new Caballo("blanco"));
            } else if (i == 'c') {
                tablero.ponerPieza(i + "1", new Alfil("blanco"));
                tablero.ponerPieza("f1", new Alfil("blanco"));
            } else if (i == 'd') {
                tablero.ponerPieza(i + "1", new Rey("blanco"));
            } else if (i == 'e') {
                tablero.ponerPieza(i + "1", new Dama("blanco"));

            }
        }

        for (char i = 'a'; i <= 'h'; i++) {
            tablero.ponerPieza(i + "2", new Peon("blanco"));
        }

        this.add(tablero, BorderLayout.CENTER);

        //Ponemos a la izquierda o al oeste el panel de letras
        panelLetras = new PanelLetras();
        this.add(new BotonInvertir(this), BorderLayout.SOUTH);
        this.add(panelLetras, BorderLayout.NORTH);
        diseñoDeBordes.setHgap(45);
        //Ponemos abajo o al sur el panel de numeros
        //panelNumeros = new PanelNumeros();
        panelNumerosIzquierda = new PanelNumeros();
        panelNumerosDerecha = new PanelNumeros();
        this.add(panelNumerosIzquierda, BorderLayout.EAST);
        this.add(panelNumerosDerecha, BorderLayout.WEST);

        this.setVisible(true); // mostramos la ventana 
       
    }

    
}
