



package domain;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;

/**
 * Write a description of class CelulaEspecial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CelulaEspecial extends Celula{
    private int fila;
    private int columna;
  
    public CelulaEspecial(AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        this.fila = fila;
        this.columna = columna;
        color=Color.green;
        
    }
    
    /**
     * Determine if the special cell is alone
     * @return true if is alone, otherwise false
     */
    public boolean estaSola(){
        ArrayList<int[]> adjointPositions = generarPosicionesValidas();
        
        for(int[] ap: adjointPositions){
            if(getAutomata().getElemento(ap[0], ap[1])!=null){
                if(getAutomata().getElemento(ap[0], ap[1]).isVivo()){
                    return false;
                }
            }
        }
        return true;
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
            
            new Celula(getAutomata(),temp[0],temp[1]);
            
        }
        
       
    }

    public boolean rodeadoCelulasMuertas(){
        ArrayList<int[]> positions = generarPosicionesValidas();
        boolean muere = true;
        for(int[] p: positions){
            if(getAutomata().getElemento(p[0], p[1])!=null){
                muere = muere && (!getAutomata().getElemento(p[0], p[1]).isVivo() && getAutomata().getElemento(p[0], p[1]) instanceof Celula);
            }else{
                muere = false;
            }

        }
        return muere;
    }
    /**
     * decide cual será el estado siguiente
     */
    public void decida(){
        generaCelula();
        if(rodeadoCelulasMuertas()){
            estadoSiguiente = Ser.MUERTO;
        }
    }

    
}

