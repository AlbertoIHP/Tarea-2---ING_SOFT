/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrochess;

import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Alberto
 */
public class Caballo extends Pieza {

    private String[] imagenes = {"src/ufrochess/images/caballo_blanco.png", "src/ufrochess/images/caballo_negro.png"};

    public Caballo(String color) {
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

            char auxLetra = letra;
            int auxNum = num;
            if (this.micasilla.casillaEnPos(++auxLetra, ++auxNum) != null) {

                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {
                    k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                    if (this.micasilla.casillaEnPos(auxLetra, ++auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);

                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                        auxNum--;

                    }

                    if (this.micasilla.casillaEnPos(++auxLetra, auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);
                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                    }

                }
            }

            auxLetra = letra;
            auxNum = num;
            if (this.micasilla.casillaEnPos(--auxLetra, --auxNum) != null) {
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {
                    k = this.micasilla.casillaEnPos(auxLetra, auxNum);

                    if (this.micasilla.casillaEnPos(--auxLetra, auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);

                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                        auxLetra++;

                    }

                    if (this.micasilla.casillaEnPos(auxLetra, --auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);
                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                    }

                }
            }

            auxLetra = letra;
            auxNum = num;
            if (this.micasilla.casillaEnPos(--auxLetra, ++auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);

                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    if (this.micasilla.casillaEnPos(--auxLetra, auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {
                            h.add(k);

                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                        auxLetra++;

                    }

                    if (this.micasilla.casillaEnPos(auxLetra, ++auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);
                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                    }

                }
            }

            auxLetra = letra;
            auxNum = num;
            if (this.micasilla.casillaEnPos(++auxLetra, --auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    if (this.micasilla.casillaEnPos(++auxLetra, auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);

                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                        auxLetra--;

                    }

                    if (this.micasilla.casillaEnPos(auxLetra, --auxNum) != null) {
                        k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                        if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                            h.add(k);
                        } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                        } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                        } else {
                            h.add(k);
                        }
                    }

                }
            }

        }
        System.out.println(h);
        return h;

    }

}
