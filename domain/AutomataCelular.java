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
        /*
        Celula indiana = new Celula(this, 1, 1);
        Celula _007 = new Celula(this, 2, 2);
        
        CelulaEspecial agamenon = new CelulaEspecial(this, 3, 3);
        CelulaEspecial venus = new CelulaEspecial(this, 4, 4);

        Calefactor suroeste = new Calefactor(this,29,0);
        Calefactor noreste = new Calefactor(this, 0, 29);
        
        this.automata[1][1] = indiana;
        this.automata[2][2] =  _007;
        this.automata[3][3] = agamenon;
        this.automata[4][4] = venus;
        this.automata[29][0] = suroeste;
        this.automata[0][29] = noreste;
        */
        CelulaConway john = new CelulaConway(this, 5, 3);
        CelulaConway horton = new CelulaConway(this, 5, 4);

        //Bloque
        CelulaConway c1 = new CelulaConway(this, 28, 0);
        CelulaConway c2 = new CelulaConway(this, 29, 0);
        CelulaConway c3 = new CelulaConway(this, 28, 1);
        CelulaConway c4 = new CelulaConway(this, 29, 1);


        this.automata[5][3] = john;
        this.automata[5][4] = horton;

        //Bloque
        this.automata[28][0] = c1;
        this.automata[29][0] = c2;
        this.automata[28][1] = c3;
        this.automata[29][1] = c4;

        //Parpadeador

        CelulaConway c5 = new CelulaConway(this, 26, 15);
        CelulaConway c6 = new CelulaConway(this, 26, 14);
        CelulaConway c7 = new CelulaConway(this, 26, 13);
        

        
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
