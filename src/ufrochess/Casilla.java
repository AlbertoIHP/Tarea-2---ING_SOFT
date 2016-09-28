package ufrochess;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class Casilla extends JButton implements MouseListener {

    public Casilla(Pieza pieza, String codigo, Color respaldo, Color ilumina, LinkedList<Casilla> llega, MiAjedrez padre) {
        this.miPieza = pieza;
        this.codigo = codigo;
        this.respaldo = respaldo;
        this.ilumina = ilumina;
        this.llega = llega;
        this.padre = padre;
    }

    private String codigo;
    private Pieza miPieza = null;
    private Color respaldo = new Color(0, 0, 0);
    private Color ilumina = new Color(100, 100, 100);
    private LinkedList<Casilla> llega = null;
    private MiAjedrez padre;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMiPieza(Pieza miPieza) {
        this.miPieza = miPieza;
    }

    public Pieza getMiPieza() {
        return miPieza;
    }

    public Casilla(String cod, MiAjedrez ptrPadre) {
        this.codigo = cod;
        this.padre = ptrPadre;
        this.addMouseListener(this);
    }

    public Casilla casillaEnPos(char ch, int j) {
        return this.padre.enPosicion("" + ch + j);
    }

    public String miPos() {
        return this.codigo;
    }

    public Color getRespaldo() {
        return respaldo;
    }

    public void setRespaldo(Color respaldo) {
        this.respaldo = respaldo;
    }

    public Color getIlumina() {
        return ilumina;
    }

    public void setIlumina(Color ilumina) {
        this.ilumina = ilumina;
    }

    public LinkedList<Casilla> getLlega() {
        return llega;
    }

    public void setLlega(LinkedList<Casilla> llega) {
        this.llega = llega;
    }

    public MiAjedrez getPadre() {
        return padre;
    }

    public void setPadre(MiAjedrez padre) {
        this.padre = padre;
    }

    public boolean vacia() {
        return this.miPieza == null;
    }

    public void fijaPieza(Pieza p) {
        this.miPieza = p;
        //NO ME QUEDA CLARO QUE HACE ESTE ESCUCHADOR
        this.addComponentListener(p);
    }

    public void respaldaColor() {
        this.respaldo = this.getBackground();
    }

    public void recuperaColor() {
        this.setBackground(this.respaldo);
    }

    public void ilumina() {
        this.respaldaColor();
        this.setBackground(this.respaldo.brighter());
    }

    public void entregarInfoTablero() {
        String[] arregloDeAlcance = new String[(llega.size() + 1)];
        System.out.println(llega.size());

        for (int i = 0; i < (llega.size() + 1); i++) {

            if (i == llega.size()) {
                arregloDeAlcance[i] = this.getCodigo();
            } else {
                arregloDeAlcance[i] = llega.get(i).codigo;
            }
        }

        padre.setPuntosAlcanzables(arregloDeAlcance);
    }

    public void clickeadoNegro() {
        this.respaldaColor();
        this.setBackground(Color.DARK_GRAY);
    }

    public void desClickeado() {
        padre.getCasillaClickeada().recuperaColor();
    }

    public void clickeadoBlanco() {
        this.respaldaColor();
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void mouseClicked(MouseEvent e) {
        if (this.padre.getPiezaClickeada() == null) {
            if (this.miPieza != null && this.miPieza.esNegra) {

                this.clickeadoNegro();
            } else if (this.miPieza != null && this.miPieza.esBlanca) {
                this.clickeadoBlanco();
            }
        }

        boolean noLogrado = true;
        if (this.getMiPieza() != null && padre.getPiezaClickeada() == null) {
            padre.setPiezaClickeada(miPieza);
            padre.setCasillaClickeada(this);
            this.entregarInfoTablero();
            this.setIcon(null);
            this.fijaPieza(null);

        } else {
            if (this.getMiPieza() == null) {
                if (padre.getPiezaClickeada() != null) {

                    for (int i = 0; i < padre.getPuntosAlcanzables().length; i++) {

                        if (this.codigo.equals(padre.getPuntosAlcanzables()[i])) {

                            if (padre.getPiezaClickeada() instanceof Torre) {
                                this.padre.reportarMovimiento("T" + codigo);
                            } else if (padre.getPiezaClickeada() instanceof Alfil) {
                                this.padre.reportarMovimiento("A" + codigo);
                            } else if (padre.getPiezaClickeada() instanceof Dama) {
                                this.padre.reportarMovimiento("D" + codigo);
                            } else if (padre.getPiezaClickeada() instanceof Peon) {
                                this.padre.reportarMovimiento("P" + codigo);
                            } else if (padre.getPiezaClickeada() instanceof Rey) {
                                this.padre.reportarMovimiento("R" + codigo);
                            } else if (padre.getPiezaClickeada() instanceof Caballo) {
                                this.padre.reportarMovimiento("C" + codigo);
                            }

                            noLogrado = false;
                            miPieza = padre.getPiezaClickeada();
                            miPieza.micasilla = this;
                            padre.setPiezaClickeada(null);
                            this.setIcon(miPieza.imagenPieza);
                            padre.getCasillaClickeada().recuperaColor();

                            padre.getCasillaClickeada().mouseExited(e);
                            padre.setCasillaClickeada(null);
                            this.mouseEntered(e);

                        } else if (noLogrado && i >= padre.getPuntosAlcanzables().length - 1) {
                            if (padre.getPiezaClickeada() instanceof Peon) {
                                JOptionPane.showMessageDialog(this.padre, "Este Peon no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
                            } else if (padre.getPiezaClickeada() instanceof Torre) {
                                JOptionPane.showMessageDialog(this.padre, "Este Torre no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
                            } else if (padre.getPiezaClickeada() instanceof Rey) {
                                JOptionPane.showMessageDialog(this.padre, "Este Rey no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
                            } else if (padre.getPiezaClickeada() instanceof Dama) {
                                JOptionPane.showMessageDialog(this.padre, "Esta Dama no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
                            } else if (padre.getPiezaClickeada() instanceof Alfil) {
                                JOptionPane.showMessageDialog(this.padre, "Este Alfil no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
                            } else if (padre.getPiezaClickeada() instanceof Caballo) {
                                JOptionPane.showMessageDialog(this.padre, "Este Caballo no tiene alcance en esta casilla", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);

                            }

                        }

                    }

                }
            } else {

                for (int i = 0; i < padre.getPuntosAlcanzables().length; i++) {
                    if (this.codigo.equals(padre.getPuntosAlcanzables()[i])) {
                        if (padre.getCasillaClickeada().getMiPieza() != null && padre.getCasillaClickeada().getMiPieza().esBlanca && this.miPieza.esBlanca) {

                        } else {
                            if (padre.getCasillaClickeada().getMiPieza() != null && padre.getCasillaClickeada().getMiPieza().esNegra && this.miPieza.esNegra) {

                            } else {
                                /*
                                 miPieza = padre.getPiezaClickeada();
                                 miPieza.micasilla = this;
                                 padre.setPiezaClickeada(null);
                                 this.setIcon(miPieza.imagenPieza);
                                 padre.getCasillaClickeada().recuperaColor();

                                 padre.getCasillaClickeada().mouseExited(e);
                                 padre.setCasillaClickeada(null);
                                 */

                                //METODO IMPORTANTE-->>      
                                this.padre.reportarCaptura(miPieza.imagenPieza);

                                if (padre.getPiezaClickeada() instanceof Torre) {
                                    this.padre.reportarMovimiento("Tx" + codigo);
                                } else if (padre.getPiezaClickeada() instanceof Alfil) {
                                    this.padre.reportarMovimiento("Ax" + codigo);
                                } else if (padre.getPiezaClickeada() instanceof Dama) {
                                    this.padre.reportarMovimiento("Dx" + codigo);
                                } else if (padre.getPiezaClickeada() instanceof Peon) {
                                    this.padre.reportarMovimiento("Px" + codigo);
                                } else if (padre.getPiezaClickeada() instanceof Rey) {
                                    this.padre.reportarMovimiento("Rx" + codigo);
                                } else if (padre.getPiezaClickeada() instanceof Caballo) {
                                    this.padre.reportarMovimiento("Cx" + codigo);
                                }


                                miPieza = padre.getPiezaClickeada();
                                miPieza.micasilla = this;
                                this.padre.setPiezaClickeada(null);
                                this.setIcon(miPieza.imagenPieza);
                                padre.getCasillaClickeada().recuperaColor();
                                padre.getCasillaClickeada().mouseExited(e);
                                padre.setCasillaClickeada(null);
                                /*
                                 padre.setCasillaCapturada(this);
                                 this.setIcon(padre.getPiezaClickeada().imagenPieza);
                                 this.padre.getCasillaClickeada().recuperaColor();
                                 this.padre.setCasillaClickeada(null);
                                 */
                                this.mouseEntered(e);
                            }
                        }
                    }
                }

            }
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Esta casilla es la " + this.codigo);
        if (padre.getPiezaClickeada() != null) {

        } else {
            if (miPieza != null) {
                this.llega = this.miPieza.alcance();
                Casilla c;
                Iterator it = this.llega.iterator();
                while (it.hasNext()) {
                    c = (Casilla) it.next();
                    c.ilumina();
                }
            }
        }

    }

    public String getCodigo() {
        return codigo;
    }

    public void mouseExited(MouseEvent e) {
        if (padre.getPiezaClickeada() != null) {

        } else {
            if (this.llega != null) {
                Casilla c;
                Iterator it = this.llega.iterator();
                while (it.hasNext()) {
                    c = (Casilla) it.next();
                    c.recuperaColor();
                }
            }
        }

    }

}
