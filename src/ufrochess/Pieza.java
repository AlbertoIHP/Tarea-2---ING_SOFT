package ufrochess;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.MouseListener;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;
import java.util.Iterator;
import javax.swing.ImageIcon;
/**
 *
 * @author Carlos Cares para Ingeniería de Software
 */
public abstract class Pieza implements ComponentListener {
    
    protected Casilla micasilla=null;
    public boolean esBlanca = true;
    public boolean esNegra = false;
    protected ImageIcon imagenPieza;


    public Pieza() {
    }
    
    protected void definirImagen(String[] imagenes, String color){
        if(color.equals("negro")){
            this.fijaColorNegro();
        }else if(color.equals("blanco")){
            this.fijaColorBlanco();
        }
        
        ImageIcon g;
        if (this.esBlanca) {
            g = new ImageIcon(imagenes[0]);
        } else {
            g = new ImageIcon(imagenes[1]);
        }
        g = new ImageIcon(g.getImage().getScaledInstance(50,50,java.awt.Image.SCALE_REPLICATE));
        this.imagenPieza = g;
    }
    
    
    public void fijaColorBlanco() {
        this.esBlanca = true;
        this.esNegra = false;
        
    }
    
    public void fijaColorNegro() {
        this.esBlanca = false;
        this.esNegra = true;
    }
    
    public void ubicar(Casilla c){
        if(c!=null){
            c.setIcon(this.imagenPieza);
            c.fijaPieza(this);
            this.micasilla = c;
        }else{
            System.out.println("La casilla no existe");
        }
    };
    
    
    public abstract LinkedList<Casilla> alcance();

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        this.ubicar(this.micasilla);
    }
    
}
