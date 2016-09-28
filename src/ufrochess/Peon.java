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
public class Peon extends Pieza {

    private String[] imagenes = {"src/ufrochess/images/peon_blanco.png", "src/ufrochess/images/peon_negro.png"};

    public Peon(String color) {
        super.definirImagen(imagenes, color);
    }

    @Override
    public LinkedList<Casilla> alcance() {
        LinkedList<Casilla> h = new LinkedList();
        Casilla k;
        boolean seUbico = false;
        char auxLetra;
        int auxNum;
        if (this.esNegra) {
            if (this.micasilla != null) {

                String pos = this.micasilla.miPos();
                char letra = pos.charAt(0);
                int num = Integer.parseInt("" + pos.charAt(1));

                for (char i = 'a'; i <= 'h'; i++) {
                    if (this.micasilla.getCodigo().equals(i + "7")) {
                        seUbico = true;
                        auxLetra = letra;
                        auxNum = num;

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

                    } else if (i == 'h' && seUbico == false) {
                        auxLetra = letra;
                        auxNum = num;

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
        } else {
            if (this.micasilla != null) {
                seUbico = false;
                String pos = this.micasilla.miPos();
                char letra = pos.charAt(0);
                int num = Integer.parseInt("" + pos.charAt(1));

                for (char i = 'a'; i <= 'h'; i++) {
                    if (this.micasilla.getCodigo().equals(i + "2")) {
                        seUbico = true;
                        auxLetra = letra;
                        auxNum = num;

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

                    } else if (i == 'h' && seUbico==false) {
                        auxLetra = letra;
                        auxNum = num;

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
            }
        }

        k = null;
        return h;
    }

}
