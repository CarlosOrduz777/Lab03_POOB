package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
public class CelulaConway extends Celula {
    private int fila;
    private int columna;
    public CelulaConway(AutomataCelular ac,int fila,int columna){
        super(ac,fila,columna);
        this.fila= fila;
        this.columna = columna;
    }

    /**
     * 
     * @return numero de celulas vivas alrededor, -1 si la celula esta viva
     */
    public int celulMuertacelulasAdyacentes(int i, int j){
        if(getAutomata().getElemento(i,j)!= null && !getAutomata().getElemento(i, j).isVivo()){
            ArrayList<int[]> posiciones = getPosicionesAdyacentes(fila,columna);

            int contadorCelulas = 0;

            for(int[] p: posiciones){
                if(getAutomata().getElemento(p[0], p[1])!= null){
                    if(getAutomata().getElemento(p[0], p[1]).isVivo()){
                        contadorCelulas++;
                    }
                }
            }
           return contadorCelulas;
        }
        return -1;
    }

    /**
     * 
     * @return numero de celulas vivas alrededor, -1 si la celula esta muerta
     */
    public int celulaVivacelulasAdyacentes(int i, int j){
        if(getAutomata().getElemento(i,j)!= null && getAutomata().getElemento(i, j).isVivo()){
            ArrayList<int[]> posiciones = getPosicionesAdyacentes(fila,columna);

            int contadorCelulas = 0;

            for(int[] p: posiciones){
                if(getAutomata().getElemento(p[0], p[1])!= null){
                    if(getAutomata().getElemento(p[0], p[1]).isVivo()){
                        contadorCelulas++;
                    }
                }
            }
           return contadorCelulas;
        }
        return -1;
    }

     /**
     * Returns the adjoint positions of the Special cell position
     * @return the adjoint positions
     */
    public ArrayList<int[]> getPosicionesAdyacentes(int i ,int j){
        ArrayList <int[]> result = new ArrayList<>();
        int[] coordenada_i = {0,1,1,1,0,-1,-1,-1};
        int[] coordenada_j = {1,1,0,-1,-1,-1,0,1};
        int nueva_posicion_fila = 0;
        int nueva_posicion_columna = 0;
        for(int k=0; k<8; k++){
            nueva_posicion_fila = i + coordenada_i[k];
            nueva_posicion_columna = j + coordenada_j[k];
            
            if(((0 <= nueva_posicion_fila) && (nueva_posicion_fila < 30)) && 
            ((0<= nueva_posicion_columna) && (nueva_posicion_columna < 30))){
                int[] posicion = {nueva_posicion_fila,nueva_posicion_columna};
                result.add(posicion);
                
            }
            
        }
        return result;
    }
    /**
     * 
     * @return el numero de celulas alrededor
     */
    public int celulasAdyacentes(int i , int j){
        ArrayList<int[]> posiciones = getPosicionesAdyacentes(i,j);

        int contadorCelulas = 0;

        for(int[] p: posiciones){
            if(getAutomata().getElemento(p[0], p[1])!= null){
                if(getAutomata().getElemento(p[0], p[1]).isVivo()){
                    contadorCelulas++;
                }
            }
        }
        return contadorCelulas;
    }

    public CelulaConway vecindario(){
       for(int i=0;i<30;i++){
           for(int j=0;j<30;j++){
               if(getAutomata().getElemento(i, j)==null){
                   int numCelulas = celulasAdyacentes(i, j);
                   if(numCelulas==3){
                    CelulaConway co = new CelulaConway(getAutomata(), i, j);
                    return co;
                   }
               }
           }
       }
       return null;
    }
    public void decida(){
            if(celulMuertacelulasAdyacentes(fila,columna) != -1 && celulMuertacelulasAdyacentes(fila,columna) == 3){
                estadoSiguiente = Ser.VIVO;
            }else if(celulaVivacelulasAdyacentes(fila,columna) !=-1 && (celulaVivacelulasAdyacentes(fila,columna) == 3 || celulaVivacelulasAdyacentes(fila,columna)==2)){
                estadoSiguiente = Ser.VIVO;
            }else if(celulasAdyacentes(fila, columna)>3 && celulasAdyacentes(fila, columna)<2){
                estadoSiguiente = Ser.MUERTO;
            }
            
        vecindario();

    }



}
