package domain;

import java.util.ArrayList;
import java.awt.Color;
/**
 * Write a description of class Bacteria here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bacteria extends Celula implements Elemento{
    
    protected char estadoSiguiente;
    protected Color color;
    private int fila;
    private int columna;
    private AutomataCelular automata;
    
    public Bacteria(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        color = Color.orange;
    }
    
    /**
     * Returns the adjoint positions of the Special cell position
     * @return the adjoint positions
     */
    public ArrayList<Elemento> getPosicionesAdyacentes(){
        ArrayList <Elemento> result = new ArrayList<>();
        int[] coordenada_i = {0,1,1,1,0,-1,-1,-1};
        int[] coordenada_j = {1,1,0,-1,-1,-1,0,1};
        int nueva_posicion_fila = 0;
        int nueva_posicion_columna = 0;
        for(int k=0; k<8; k++){
            nueva_posicion_fila = fila + coordenada_i[k];
            nueva_posicion_columna = columna + coordenada_j[k];
            
            if((0 <= nueva_posicion_fila) && (nueva_posicion_fila < automata.getAutomata().length) && 
            (0<= nueva_posicion_columna) && (nueva_posicion_columna < automata.getAutomata()[0].length)){
                result.add(automata.getElemento(nueva_posicion_fila,nueva_posicion_columna));
                
            }
            
        }
        return result;
    }
    /**
     * if there are cells around the bacteria, it kills all of them
     */
    public void matarCelulas(){
        ArrayList<Elemento> adjointPositions = getPosicionesAdyacentes();
        
        for(Elemento e : adjointPositions){
            if (e instanceof Celula){
                Celula c = (Celula) e;
                c.setEstadoSiguiente(Ser.MUERTO);
            }
            
        }
    }
    /**
     * decides the next status of the bacteria
     */
    public void decida(){
        if(getEdad() >= 2){
            estadoSiguiente = Ser.MUERTO;
        }
    }
    
    /**
     * Updates its actual status considering which is the next status
     */
    public final void cambia(){
        cumple();
        estado = estadoSiguiente;
    }
}
