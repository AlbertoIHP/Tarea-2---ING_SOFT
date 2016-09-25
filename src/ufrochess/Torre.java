package ufrochess;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.*;
import java.util.LinkedList;

 /*
 * @author Carlos Cares para Ingeniería de Software
 */
public class Torre extends Pieza{

    @Override
    public void ubicar(Casilla c) {
        ImageIcon g=null;
        if (c!=null){
            c.fijaPieza(this);
            this.micasilla=c;
            if (this.esNegra)
                g = new ImageIcon("src/ufrochess/images/aatorreNt.png");
            else
                g = new ImageIcon("src/ufrochess/images/aatorreNt.png");
            
            int ancho = this.micasilla.getWidth() - 30;
            int alto = this.micasilla.getHeight() - 20;
            g = new ImageIcon(g.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_REPLICATE));
            
            
            //Image esc = g.getImage().getScaledInstance(c.getWidth(),c.getHeight(),Image.SCALE_SMOOTH);
            c.setIcon(g);
        }
    }

    @Override
    public LinkedList<Casilla> alcance() {
        LinkedList<Casilla> h = new LinkedList();
        Casilla k;
        if (this.micasilla!=null){
            String pos = this.micasilla.miPos();
            char letra = pos.charAt(0);
            int  num = Integer.parseInt(""+pos.charAt(1));
            //avanza
            boolean sigue=true;
            for(int i=num+1;i<9&&sigue;i++) {
                k = this.micasilla.casillaEnPos(letra,i);
                if (sigue=k.vacia()) h.add(k);
            }
            //retrocede
            sigue=true;
            for(int i=num-1;i>0&&sigue;i--) {
                k = this.micasilla.casillaEnPos(letra,i);
                if (sigue=k.vacia()) h.add(k);
            }
            //costado derecho
            sigue=true;
            for(char c=(char)(letra+1);c<='h'&&sigue;c++){
                k = this.micasilla.casillaEnPos(c,num);
                if (sigue=k.vacia()) h.add(k);
            }
            //costado izquierdo
            sigue=true;
            for(char c=(char)(letra-1);c>='a'&&sigue;c--){
                k = this.micasilla.casillaEnPos(c,num);
                if (sigue=k.vacia()) h.add(k);
            }
        }
        return h;
    }
}
