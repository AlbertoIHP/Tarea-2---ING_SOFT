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
