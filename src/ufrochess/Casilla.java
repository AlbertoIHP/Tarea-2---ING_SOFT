package ufrochess;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class Casilla extends JButton implements MouseListener {
    private String codigo;
    private Pieza miPieza = null;
    private Color respaldo=new Color(0,0,0);
    private Color ilumina = new Color(100,100,100);
    private LinkedList<Casilla> llega=null;
    private MiAjedrez padre;
    
    public Casilla(String cod,MiAjedrez ptrPadre) {
        this.codigo = cod;
        this.padre = ptrPadre;
        this.addMouseListener(this);
    }
    
    public Casilla casillaEnPos(char ch,int j){
        return this.padre.enPosicion(""+ch+j);
    }
    
    public String miPos() {
        return this.codigo;
    }
    
    public boolean vacia(){
        return this.miPieza==null;
    }
    
    public void fijaPieza(Pieza p){
        this.miPieza = p;
        //NO ME QUEDA CLARO QUE HACE ESTE ESCUCHADOR
        this.addComponentListener(p);
    }
    
    public void respaldaColor(){
        this.respaldo = this.getBackground();
    }
    
    public void recuperaColor(){
        this.setBackground(this.respaldo);
    }
    
    public void ilumina(){
        this.respaldaColor();
        this.setBackground(this.respaldo.brighter());
    }
    
    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        if (miPieza!=null){
            this.llega = this.miPieza.alcance();
            Casilla c;
            Iterator it = this.llega.iterator();
            while(it.hasNext()){
                c = (Casilla)it.next();
                c.ilumina();
           }
        }
    }
    
    public void mouseExited(MouseEvent e) {
        if (this.llega!=null){
            Casilla c;
            Iterator it = this.llega.iterator();
            while(it.hasNext()){
                c = (Casilla)it.next();
                c.recuperaColor();
            }
        }
    }    
    
}