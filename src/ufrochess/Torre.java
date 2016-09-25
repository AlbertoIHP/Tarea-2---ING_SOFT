package ufrochess;

import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.*;
import java.util.LinkedList;

/*
 * @author Carlos Cares para Ingeniería de Software
 */
public class Torre extends Pieza {
    private String[] imagenes = {"src/ufrochess/images/aatorreB.png", "src/ufrochess/images/aatorreNt.png"};
    
    public Torre(String color) {
        
        if(color.equals("negro")){
            super.fijaColorNegro();
        }else if(color.equals("blanco")){
            super.fijaColorBlanco();
        }
        
        ImageIcon g;
        if (super.esBlanca) {
            g = new ImageIcon(this.imagenes[0]);
        } else {
            g = new ImageIcon(this.imagenes[1]);
        }
        g = new ImageIcon(g.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_REPLICATE));
        super.imagenPieza = g;
    }


    @Override
    public LinkedList<Casilla> alcance() {
        LinkedList<Casilla> h = new LinkedList();
        Casilla k;
        if (this.micasilla != null) {
            String pos = this.micasilla.miPos();
            char letra = pos.charAt(0);
            int num = Integer.parseInt("" + pos.charAt(1));
            //avanza
            boolean sigue = true;
            for (int i = num + 1; i < 9 && sigue; i++) {
                k = this.micasilla.casillaEnPos(letra, i);
                if (sigue = k.vacia()) {
                    h.add(k);
                }
            }
            //retrocede
            sigue = true;
            for (int i = num - 1; i > 0 && sigue; i--) {
                k = this.micasilla.casillaEnPos(letra, i);
                if (sigue = k.vacia()) {
                    h.add(k);
                }
            }
            //costado derecho
            sigue = true;
            for (char c = (char) (letra + 1); c <= 'h' && sigue; c++) {
                k = this.micasilla.casillaEnPos(c, num);
                if (sigue = k.vacia()) {
                    h.add(k);
                }
            }
            //costado izquierdo
            sigue = true;
            for (char c = (char) (letra - 1); c >= 'a' && sigue; c--) {
                k = this.micasilla.casillaEnPos(c, num);
                if (sigue = k.vacia()) {
                    h.add(k);
                }
            }
        }
        return h;
    }
}
