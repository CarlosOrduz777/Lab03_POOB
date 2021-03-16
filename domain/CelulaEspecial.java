package domain;
import java.util.ArrayList;
import java.awt.Color;
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
  
    /**
     * Constructor for the CelulaEspecial class.
     * @param The instance of AutomataCelular
     * @param The row where the cell is placed
     * @param The column where the cell is placed
     */
    public CelulaEspecial(AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        color=Color.green;
        
    }
    
    /**
     * Determine if the special cell is alone
     * @return true if is alone, otherwise false
     */
    public boolean estaSola(){
        ArrayList<Elemento> adjointPositions = getPosicionesAdyacentes();
        
        for(Elemento e: adjointPositions){
            if(e.isVivo()){
                return false;
            }
        }
        
        return true;
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
     * if the special cell is alone, it generates a new cell
     * @return a cell if the special cell is alone, otherwise null
     */
    public Celula generaCelula(){
        ArrayList<Elemento> adjointPositions = getPosicionesAdyacentes();
        
        for(Elemento e : adjointPositions){
                if(e.isVivo()){
                    return null;
                }            
        }
        
        int fil = (int) Math.random() * 29;
        int col = (int) Math.random() * 29;
        return new Celula(automata,fil,col);
    }
    /**
     * decide cual será el estado siguiente
     */
    public void decida(){
        if(this.generaCelula() == null){
           estadoSiguiente = Ser.MUERTO; 
        }else{
            estadoSiguiente = Ser.VIVO;
            this.generaCelula();
        }
    }
    
}

