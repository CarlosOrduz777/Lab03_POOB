



package domain;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;
import java.util.HashMap;
/**
 * Write a description of class CelulaEspecial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CelulaEspecial extends Celula{
    private AutomataCelular automata;
    private int fila;
    private int columna;
  
    public CelulaEspecial(AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        color=Color.green;
        
    }
    
    /**
     * Determine if the special cell is alone
     * @return true if is alone, otherwise false
     */
    public boolean estaSola(){
        ArrayList<int[]> adjointPositions = generarPosicionesValidas();
        
        for(int[] ap: adjointPositions){
            if(automata.getElemento(ap[0], ap[1]).isVivo()){
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * Returns the adjoint positions of the Special cell position
     * @return the adjoint positions
     */
    public ArrayList<int[]> getPosicionesAdyacentes(int i,int j){
        ArrayList <int[]> result = new ArrayList<>();
        int[] coordenada_i = {0,1,1,1,0,-1,-1,-1};
        int[] coordenada_j = {1,1,0,-1,-1,-1,0,1};
        int nueva_posicion_fila = 0;
        int nueva_posicion_columna = 0;
        for(int k=0; k<8; k++){
            nueva_posicion_fila = i + coordenada_i[k];
            nueva_posicion_columna = j + coordenada_j[k];
            
            if( ((0 <= nueva_posicion_fila) && (nueva_posicion_fila < 30)) && 
            ((0<= nueva_posicion_columna) && (nueva_posicion_columna < 30))){
                int[] posicion = {nueva_posicion_fila,nueva_posicion_columna};
                result.add(posicion);
                
            }
            
        }
        return result;
    }
    
    public ArrayList<int[]> generarPosicionesValidas(){
        ArrayList<int[]> result = new ArrayList<>();
        int[] coordenada_i = {-1,0,0,1};
        int[] coordenada_j = {0,-1,1,0};
        int nueva_posicion_fila = 0;
        int nueva_posicion_columna = 0;
        for(int k=0; k<4; k++){
            nueva_posicion_fila = fila + coordenada_i[k];
            nueva_posicion_columna = columna + coordenada_j[k];
            
            if((0 <= nueva_posicion_fila) && (nueva_posicion_fila < 30) && 
            (0<= nueva_posicion_columna) && (nueva_posicion_columna < 30)){
                int[] posicion = {nueva_posicion_fila,nueva_posicion_columna};
                result.add(posicion);
            }
            
        }
        return result;
    }
    
    /**
     * if the special cell is alone, it generates a new cell
     * @return a cell if the special cell is alone, otherwise null
     */
    public void generaCelula(){
        Random r = new Random();
        if(this.estaSola()){
            ArrayList<int[]> positions = generarPosicionesValidas();
            int[] temp = positions.get(r.nextInt(positions.size()));
            
            System.out.println(temp[0]+"-"+temp[1]);
            new Celula(automata,temp[0],temp[1]);
            
        }
        
       
    }
    /**
     * decide cual será el estado siguiente
     */
    public void decida(){
        generaCelula();
    }
    
}

