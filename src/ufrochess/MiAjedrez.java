package ufrochess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiAjedrez extends JPanel {

	private Casilla[] casi;
        private Color casillaBlanca;
        private Color casillaNegra;
        
        public MiAjedrez() {
            
            this.casillaBlanca = new Color(218,247,166);
            this.casillaNegra = new Color(144,12,63);
            this.casi = new Casilla[64];
            this.setLayout(new GridLayout(8,8));
            this.creaCasillas();
        }
        
        private void creaCasillas() {
            int k = -1;
            char letracel='a';
            int  numecel=8;
            
            
            for(int i=1;i<=64;i++){
                this.casi[i-1]=new Casilla(""+letracel+numecel,this);
                //this.casi[i-1].setLabel(this.casi[i-1].miPos());
                this.add(this.casi[i-1]);
                if(k==1) this.casi[i-1].setBackground(casillaNegra);
                else this.casi[i-1].setBackground(casillaBlanca);
                k *= -1;
                letracel++;
                if(i%8==0){
                    k*=-1;
                    numecel--;
                    letracel='a';
                }
            }
        }

    public boolean ponerPieza(String posicion,String pieza){
        Casilla cas = this.enPosicion(posicion);
        if (cas!=null)
            cas.setLabel(pieza);
        return cas!=null;
    }
    
    public boolean ponerPieza(String posicion, Pieza p){
        Casilla cas = this.enPosicion(posicion);
        if (cas!=null)
            p.ubicar(cas);
        return cas!=null;
    }
    
    public Casilla enPosicion(String posicion){
        Casilla cas = null;
        int k=0;
        while(cas==null && k<64){
            if (this.casi[k].miPos().equals(posicion))
                cas = this.casi[k];
            k++;
        }
        return cas;
    }
    
    
    

}