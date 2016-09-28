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
    private String[] imagenes = {"src/ufrochess/images/torre_blanca.png", "src/ufrochess/images/torre_negra.png"};
    
    public Torre(String color) {
        super.definirImagen(imagenes, color);
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
                }else if(sigue = (k.getMiPieza().esBlanca && this.esBlanca)){
                    break;
                }else if(sigue = (k.getMiPieza().esNegra && this.esNegra)){
                    break;
                }else{
                    h.add(k);
                }
            }
            //retrocede
            sigue = true;
            for (int i = num - 1; i > 0 && sigue; i--) {
                k = this.micasilla.casillaEnPos(letra, i);
                if (sigue = k.vacia()) {
                    h.add(k);
                }else if(sigue = (k.getMiPieza().esBlanca && this.esBlanca)){
                    break;
                }else if(sigue = (k.getMiPieza().esNegra && this.esNegra)){
                    break;
                }else{
                    h.add(k);
                }
            }
            //costado derecho
            sigue = true;
            for (char c = (char) (letra + 1); c <= 'h' && sigue; c++) {
                k = this.micasilla.casillaEnPos(c, num);
                if (sigue = k.vacia()) {
                    h.add(k);
                }else if(sigue = (k.getMiPieza().esBlanca && this.esBlanca)){
                    break;
                }else if(sigue = (k.getMiPieza().esNegra && this.esNegra)){
                    break;
                }else{
                    h.add(k);
                }
            }
            //costado izquierdo
            sigue = true;
            for (char c = (char) (letra - 1); c >= 'a' && sigue; c--) {
                k = this.micasilla.casillaEnPos(c, num);
                if (sigue = k.vacia()) {
                    h.add(k);
                }else if(sigue = (k.getMiPieza().esBlanca && this.esBlanca)){
                    break;
                }else if(sigue = (k.getMiPieza().esNegra && this.esNegra)){
                    break;
                }else{
                    h.add(k);
                }
            }
        }
        System.out.println(h);
        return h;
    }
}
