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
                automata[f][c]= null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        //System.out.println("Elemento: " + f + " - " + c);
        return automata[f][c];
    }
    
    public Elemento[][] getAutomata(){
        return this.automata;
    }

    public void setElemento(int f, int c, Elemento nueva){
        //System.out.println("setElemento: " + f + " - " + c);
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        Celula indiana = new Celula(this, 1, 1);
        Celula _007 = new Celula(this, 2, 2);
        
        CelulaEspecial agamenon = new CelulaEspecial(this, 3, 3);
        CelulaEspecial venus = new CelulaEspecial(this, 4, 4);
        
        this.automata[1][1] = indiana;
        this.automata[2][2] =  _007;
        this.automata[3][3] = agamenon;
        this.automata[4][4] = venus;
        
        //this.automata[1][2] = new CelulaEspecial(this, 1, 2);
        /*this.automata[6][6] = new CelulaEspecial(this, 6, 6);
        this.automata[15][15] = new CelulaEspecial(this, 15, 15);
        this.automata[8][8] = new CelulaEspecial(this, 8, 8);*/
        
    }
    
    public void ticTac(){  
        for(int i = 0; i < LONGITUD; i++){
            for(int j = 0; j < LONGITUD; j++){
                if(this.automata[i][j] != null){
                    this.automata[i][j].decida();
                    this.automata[i][j].cambie();
                    
                    //System.out.println("Cambios en "+ i + " - " + j);
                }
            }
        }
        
        //CelulaEspecial test = new CelulaEspecial(this, 15, 15);
        //test.specialCellPositions();
        
        
        //this.automata[3][3].decida();
        //this.automata[4][4].decida();
        
        /*this.automata[1][1].decida();
        this.automata[1][1].cambie();    
        
        System.out.println("indiana done");
        
        this.automata[2][2].decida();
        this.automata[2][2].cambie();
        
        System.out.println("007 done");
        
        this.automata[3][3].decida();
        this.automata[3][3].cambie();
        
        System.out.println("agamenon done");
        
        this.automata[4][4].decida();
        this.automata[4][4].cambie();
        
        System.out.println("venus done");*/
    }

}
