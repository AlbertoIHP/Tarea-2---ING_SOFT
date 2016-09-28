/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.util.LinkedList;

/**
 *
 * @author Alberto
 */
public class Dama extends Pieza {

    private String[] imagenes = {"src/ufrochess/images/dama_blanca.png", "src/ufrochess/images/dama_negra.png"};

    public Dama(String color) {
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
                } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                    break;
                } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                    break;
                } else {
                    h.add(k);
                }
            }
            //retrocede
            sigue = true;
            for (int i = num - 1; i > 0 && sigue; i--) {
                k = this.micasilla.casillaEnPos(letra, i);
                if (sigue = k.vacia()) {
                    h.add(k);
                } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                    break;
                } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                    break;
                } else {
                    h.add(k);
                }
            }
            //costado derecho
            sigue = true;
            for (char c = (char) (letra + 1); c <= 'h' && sigue; c++) {
                k = this.micasilla.casillaEnPos(c, num);
                if (sigue = k.vacia()) {
                    h.add(k);
                } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                    break;
                } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                    break;
                } else {
                    h.add(k);
                }
            }
            //costado izquierdo
            sigue = true;
            for (char c = (char) (letra - 1); c >= 'a' && sigue; c--) {
                try {
                    k = this.micasilla.casillaEnPos(c, num);
                    if (sigue = k.vacia()) {
                        h.add(k);
                    } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                        break;
                    } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                        break;
                    } else {
                        h.add(k);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            //Diagonal superior izquierda
            sigue = true;
            int i = num + 1;
            for (char c = (char) (letra - 1); c >= 'a' && sigue; c--) {
                try {

                    k = this.micasilla.casillaEnPos(c, i);
                    if (sigue = k.vacia()) {
                        h.add(k);
                    } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                        break;
                    } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                        break;
                    } else {
                        h.add(k);
                    }
                    i++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //Diagonal inferior izquierda
            sigue = true;
            i = num - 1;
            for (char c = (char) (letra - 1); c >= 'a' && sigue; c--) {
                try {

                    k = this.micasilla.casillaEnPos(c, i);
                    if (sigue = k.vacia()) {
                        h.add(k);
                    } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                        break;
                    } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                        break;
                    } else {
                        h.add(k);
                    }
                    i--;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //Diagonal superior derecha
            sigue = true;
            i = num + 1;
            for (char c = (char) (letra + 1); c <= 'h' && sigue; c++) {
                try {

                    k = this.micasilla.casillaEnPos(c, i);
                    if (sigue = k.vacia()) {
                        h.add(k);
                    } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                        break;
                    } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                        break;
                    } else {
                        h.add(k);
                    }
                    i++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //Diagonal inferior derecha
            sigue = true;
            i = num - 1;
            for (char c = (char) (letra + 1); c <= 'h' && sigue; c++) {
                try {

                    k = this.micasilla.casillaEnPos(c, i);
                    if (sigue = k.vacia()) {
                        h.add(k);
                    } else if (sigue = (k.getMiPieza().esBlanca && this.esBlanca)) {
                        break;
                    } else if (sigue = (k.getMiPieza().esNegra && this.esNegra)) {
                        break;
                    } else {
                        h.add(k);
                    }
                    i--;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        System.out.println(h);
        return h;
    }

}
