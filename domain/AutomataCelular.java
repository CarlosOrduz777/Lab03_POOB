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
        this.automata[1][1] = new Celula(this, 1, 1);
        this.automata[2][2] = new Celula(this, 2, 2); 
    }
    
    public void ticTac(){
        this.automata[1][1].decida();
        this.automata[1][1].cambie();          
        
        this.automata[2][2].decida();
        this.automata[2][2].cambie();
    }

}
