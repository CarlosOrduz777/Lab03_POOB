package domain;

import java.awt.Color;

/**
 * Write a description of class Calefactor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Calefactor implements Elemento{
    protected Color color;
    private AutomataCelular automata;
    private int fila;
    private int columna;
    
    public Calefactor(AutomataCelular ac,int fila, int columna){
        automata = ac;
        this.fila = fila;
        this.columna = columna;
        color = Color.RED;
        this.automata.setElemento(fila,columna, (Elemento)this);
    }
    
    public int forma(){
        return CUADRADA;
    }
    public Color getColor(){
        return this.color;
    }
    public void cambie(){
        if(this.getColor().equals(Color.RED)){
            color = Color.YELLOW;
        }else{
            color = Color.RED;
        }
    }
}
