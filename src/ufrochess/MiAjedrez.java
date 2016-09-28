package ufrochess;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiAjedrez extends JPanel {

    private Casilla[] casi;
    private Color casillaBlanca;
    private Color casillaNegra;
    private Pieza piezaClickeada;
    private String[] puntosAlcanzables;
    private Casilla casillaClickeada;
    private Casilla[] casillasInvertidas;

    private String[] codigosCasillaNoInvertidas;
    private Pieza[] piezasNoInvertidas;
    
    private GUI miPadre;

    public Casilla getCasillaCapturada() {
        return casillaCapturada;
    }

    public void setCasillaCapturada(Casilla casillaCapturada) {
        this.casillaCapturada = casillaCapturada;
    }
    
    public void reportarCaptura(Icon imagenPiezaCapturada){
        this.miPadre.reportarCaptura(imagenPiezaCapturada);
    }
    
    public void reportarMovimiento(String jugada){
        this.miPadre.reportarMovimiento(jugada);
    }
    
    private Casilla casillaCapturada;

    public Casilla[] getCasi() {
        return casi;
    }

    public void limpiarTablero() {
        this.removeAll();
        this.repaint();

    }

    public void enderezarTablero() {
        this.limpiarTablero();
        for (int i = 0; i < 64; i++) {
            Casilla aux = this.casi[i];
            this.add(aux);
        }
    }

    //##################################################3
    public void invertirTablero() {
        this.limpiarTablero();

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[56 + i];
            aux.setVisible(true);
            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[48 + i];
            aux.setVisible(true);
            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[40 + i];
            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[32 + i];
            aux.setVisible(true);

            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[24 + i];
            aux.setVisible(true);
            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[16 + i];
            aux.setVisible(true);
            this.add(aux);

        }

        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[8 + i];
            aux.setVisible(true);
            this.add(aux);

        }
        for (int i = 0; i < 8; i++) {
            Casilla aux = this.casi[0 + i];
            aux.setVisible(true);
            this.add(aux);

        }

    }

    public void setCasi(Casilla[] casi) {
        this.casi = casi;
    }

    public Color getCasillaBlanca() {
        return casillaBlanca;
    }

    public void setCasillaBlanca(Color casillaBlanca) {
        this.casillaBlanca = casillaBlanca;
    }

    public Color getCasillaNegra() {
        return casillaNegra;
    }

    public void setCasillaNegra(Color casillaNegra) {
        this.casillaNegra = casillaNegra;
    }

    public Pieza getPiezaClickeada() {
        return piezaClickeada;
    }

    public void setPiezaClickeada(Pieza piezaClickeada) {
        this.piezaClickeada = piezaClickeada;
    }

    public String[] getPuntosAlcanzables() {
        return puntosAlcanzables;
    }

    public void setPuntosAlcanzables(String[] puntosAlcanzables) {
        this.puntosAlcanzables = puntosAlcanzables;
    }

    //public void recuperarColorCasillas(){
    //  for (int i = 0; i < casi.length; i++) {
    //     casi[i].recuperaColor();
    //}
    //}
    public Casilla getCasillaClickeada() {
        return casillaClickeada;
    }

    public void setCasillaClickeada(Casilla casillaClickeada) {
        this.casillaClickeada = casillaClickeada;
    }

    public MiAjedrez(int i, GUI gui) {
        this.miPadre = gui;
        this.piezasNoInvertidas = new Pieza[64];
        this.casillasInvertidas = new Casilla[64];
        this.codigosCasillaNoInvertidas = new String[64];
        this.casillaBlanca = new Color(218, 247, 166);
        this.casillaNegra = new Color(144, 12, 63);
        this.casi = new Casilla[64];
        this.setLayout(new GridLayout(8, 8));
        this.creaCasillas(i);
    }

    private void creaCasillas(int z) {
        if (z == 0) {

            int k = -1;
            char letracel = 'a';
            int numecel = 8;

            for (int i = 1; i <= 64; i++) {
                this.casi[i - 1] = new Casilla("" + letracel + numecel, this);
                //this.casi[i-1].setLabel(this.casi[i-1].miPos());
                this.add(this.casi[i - 1]);
                if (k == 1) {
                    this.casi[i - 1].setBackground(casillaNegra);
                } else {
                    this.casi[i - 1].setBackground(casillaBlanca);
                }
                k *= -1;
                letracel++;
                if (i % 8 == 0) {
                    k *= -1;
                    numecel--;
                    letracel = 'a';
                }
            }
        } else if (z == 1) {

            int k = -1;
            char letracel = 'a';
            int numecel = 1;

            for (int i = 1; i <= 64; i++) {
                this.casi[i - 1] = new Casilla("" + letracel + numecel, this);
                //this.casi[i-1].setLabel(this.casi[i-1].miPos());
                this.add(this.casi[i - 1]);
                if (k == 1) {
                    this.casi[i - 1].setBackground(casillaBlanca);
                } else {
                    this.casi[i - 1].setBackground(casillaNegra);
                }
                k *= -1;
                letracel++;
                if (i % 8 == 0) {
                    k *= -1;
                    numecel++;
                    letracel = 'a';
                }
            }
        }
    }

    public boolean ponerPieza(String posicion, String pieza) {
        Casilla cas = this.enPosicion(posicion);
        if (cas != null) {
            cas.setLabel(pieza);
        }
        return cas != null;
    }

    public boolean ponerPieza(String posicion, Pieza p) {
        Casilla cas = this.enPosicion(posicion);
        if (cas != null) {
            p.micasilla = cas;
        }
        p.ubicar(cas);
        return cas != null;
    }

    public Casilla enPosicion(String posicion) {
        Casilla cas = null;
        int k = 0;
        while (cas == null && k < 64) {
            if (this.casi[k].miPos().equals(posicion)) {
                cas = this.casi[k];
            }
            k++;
        }
        return cas;
    }

}
