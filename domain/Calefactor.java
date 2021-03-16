package domain;

import java.awt.Color;

/**
 * Write a description of class Calefactor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public final class Calefactor implements Elemento{
    private Color color;
    private AutomataCelular automata;
    private int fila;
    private int columna;
    
    public Calefactor(AutomataCelular ac,int fila, int columna){
        automata = ac;
        this.fila = fila;
        this.columna = columna;
        color = Color.red;
    }
    
    public int forma(){
        return CUADRADA;
    }
    
    public void cambie(){
        if(this.getColor().equals(Color.red)){
            color = Color.yellow;
        }else{
            color = Color.red;
        }
    }
}
