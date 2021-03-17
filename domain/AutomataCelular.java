package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class AutomataCelular{
    static private int LONGITUD=30;
    private Elemento[][] automata;
    
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }
    
    public Elemento[][] getAutomata(){
        return this.automata;
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        Celula indiana = new Celula(this, 1, 1);
        Celula _007 = new Celula(this, 2, 2);
        
        CelulaEspecial agamenon = new CelulaEspecial(this, 3, 3);
        CelulaEspecial venus = new CelulaEspecial(this, 4, 4);
        
        
    }
    
    public void ticTac(){
        for(int i=0; i<LONGITUD;i++){
            for(int j=0;j<LONGITUD;j++){
                if(automata[i][j]!=null){
                    automata[i][j].decida();
                    automata[i][j].cambie();
                }
            }
        }
        
    }

}
