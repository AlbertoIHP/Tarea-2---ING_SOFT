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
public class Rey extends Pieza {

    private String[] imagenes = {"src/ufrochess/images/rey_blanco.png", "src/ufrochess/images/rey_negro.png"};

    public Rey(String color) {
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
            
            //DIAGONAL SUPERIOR DERECHA
            if (this.micasilla.casillaEnPos(++auxLetra, ++auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    h.add(k);

                } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                } else {
                    h.add(k);
                }
            }
            
            //DIAGONAL INFERIOR IZQUEIRDA
            auxLetra = letra;
            auxNum = num;
            
            if (this.micasilla.casillaEnPos(--auxLetra, --auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    h.add(k);

                } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                } else {
                    h.add(k);
                }
            }
            
            
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
            
            
            auxLetra = letra;
            auxNum = num;
            
            if (this.micasilla.casillaEnPos(--auxLetra, auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    h.add(k);

                } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                } else {
                    h.add(k);
                }
            }
            
            auxLetra = letra;
            auxNum = num;
            
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
            
            
            auxLetra = letra;
            auxNum = num;
            
            if (this.micasilla.casillaEnPos(--auxLetra, ++auxNum) != null) {
                k = this.micasilla.casillaEnPos(auxLetra, auxNum);
                if (this.micasilla.casillaEnPos(auxLetra, auxNum).vacia()) {

                    h.add(k);

                } else if (k.getMiPieza() != null && k.getMiPieza().esBlanca && this.esBlanca) {

                } else if (k.getMiPieza() != null && k.getMiPieza().esNegra && this.esNegra) {

                } else {
                    h.add(k);
                }
            }
            
            
            auxLetra = letra;
            auxNum = num;
            
            if (this.micasilla.casillaEnPos(++auxLetra, --auxNum) != null) {
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
        System.out.println(h);
        return h;
    }

}
