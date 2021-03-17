package domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import java.util.Random;

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
    
    private boolean isAlive = false;
    
    static ArrayList<int[]> positions = new ArrayList<int[]>();
  
    /**
     * Constructor for the CelulaEspecial class.
     * @param The instance of AutomataCelular
     * @param The row where the cell is placed
     * @param The column where the cell is placed
     */
    public CelulaEspecial(AutomataCelular ac,int fila, int columna){      
        super(ac,fila,columna);
        color=Color.green;
        
        this.automata = ac; 
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
        ArrayList <Elemento> result = new ArrayList<Elemento>();
        int[] coordenada_i = {0,1,1,1,0,-1,-1,-1};
        int[] coordenada_j = {1,1,0,-1,-1,-1,0,1};
        
        int nueva_posicion_fila = 0;
        int nueva_posicion_columna = 0;
        
        for(int k=0; k<8; k++){
            nueva_posicion_fila = this.fila + coordenada_i[k];
            nueva_posicion_columna = this.columna + coordenada_j[k];            
           
            if((0 <= nueva_posicion_fila) && 
            (nueva_posicion_fila < automata.getAutomata().length) && 
            (0<= nueva_posicion_columna) && 
            (nueva_posicion_columna < automata.getAutomata()[0].length)){
                //System.out.println("Coordenada: " + nueva_posicion_fila +
                //" - " + nueva_posicion_columna);
                //automata.setElemento(nueva_posicion_fila, nueva_posicion_columna, 
                //new testCell(this.automata, nueva_posicion_fila, nueva_posicion_columna));
                
                result.add(automata.getElemento(nueva_posicion_fila,nueva_posicion_columna));
                
            }
            
        }        
                
        return result;
    }
    
    /**
     * Second attempt for anything
     */
    public void specialCellPositions() {        
        for(int i = 0; i < this.automata.getLongitud(); i++){
            for(int j = 0; j < this.automata.getLongitud(); j++){
                if(this.automata.getElemento(i, j) != null){
                    if (this.automata.getElemento(i, j) instanceof CelulaEspecial){
                        int[] coo = {-1, -1};
                        
                        int[] temp = {i,j};
                        this.isAlive = this.isAnyoneAlive(temp);
                        
                        // Verificamos que los puntos cardinales sean válidos para agregar una célula
                        // Norte
                        if (this.automata.getElemento(i - 1, j) == null && i-1 >= 0){
                            coo[0] = i-1;
                            coo[1] = j;
                            this.positions.add(coo);
                            
                            //automata.setElemento(i-1, j, 
                            //new testCell(this.automata, i-1, j));
                        }
                        
                        // Sur
                        if (this.automata.getElemento(i + 1, j) == null && i+1 <= 29){
                            coo[0] = i+1;
                            coo[1] = j;
                            this.positions.add(coo);
                            
                            //automata.setElemento(i+1, j, 
                            //new testCell(this.automata, i+1, j));
                        }
                        
                        // Oriente
                        if (this.automata.getElemento(i, j+1) == null && j+1 <= 29){
                            coo[0] = i;
                            coo[1] = j+1;
                            this.positions.add(coo);
                            
                            //automata.setElemento(i, j+1, 
                            //new testCell(this.automata, i, j+1));
                        }
                        
                        // Occidente
                        if (this.automata.getElemento(i, j-1) == null && j-1 >= 0){
                            coo[0] = i;
                            coo[1] = j-1;
                            this.positions.add(coo);
                            
                            //automata.setElemento(i, j-1, 
                            //new testCell(this.automata, i, j-1));
                        }
                        //System.out.println("Hay algo en: " + i + " - " + j + " de tipo: " +this.automata.getElemento(i, j).getClass());
                    }
                }
            }
        } 
       
        
        
        //System.out.println("La lista de posiciones tiene una longitud de: " + positions.size());
        //S//ystem.out.println("Una posición aleatoria: " + r.nextInt(positions.size()));
        //System.out.println(Arrays.toString(positions.get(r.nextInt(positions.size()))));
    }
    
    
    /**
     * if the special cell is alone, it generates a new cell
     * @return a cell if the special cell is alone, otherwise null
     */
    public Celula generaCelula(){
        ArrayList<Elemento> adjointPositions = getPosicionesAdyacentes();
        
        
        for(Elemento e : adjointPositions){                
                //System.out.println(e.getFila() + " - " + e.getColumna());
                
                
                /*if(((Celula)e).isVivo()){
                    return null;
                } else {
                    System.out.println("Está muerto!");
                }*/
        }
        
        //int fil = (int) Math.random() * 29;
        //int col = (int) Math.random() * 29;
        
        int fil = 15;
        int col = 15;
        
        //System.out.println("generaCelula(" + fil + ", " + col +")");
        
        
        return new Celula(automata,fil,col);
    }
    
    /**
     * if the special cell is alone, it generates a new cell
     * @return a cell if the special cell is alone, otherwise null
     */
    public void crearCelula(){
        Random r = new Random(); 
        this.specialCellPositions();  
               
        int[] newCoordinate = this.positions.get(r.nextInt(this.positions.size()));
        //System.out.println("Célula creada en " + newCoordinate[0] + " - " + newCoordinate[1]);
        
        
        if(this.isAlive){
            return;
        }
        
        // Si están todos muertos creamos la célula
        if(!this.isAlive){
            this.automata.setElemento(newCoordinate[0], newCoordinate[1], new Celula(this.automata, newCoordinate[0], newCoordinate[1]));
            this.specialCellPositions();
        }
        
        
        
    }
    
    
    /**
     * Verify alive around
     * @param An array with the x and y values of the cell
     */
    public boolean isAnyoneAlive(int[] coordinate){
        int x = coordinate[0];
        int y = coordinate[1];
        
        System.out.println(Arrays.toString(coordinate));       
        
        
        // Norte   
        try {
            if ((this.automata.getElemento(x - 1, y) != null) && (this.automata.getElemento(x - 1, y) instanceof Celula) && (x-1 >= 0)){           
            System.out.println("Revisando: " + (x-1) + " - " + y);
            if(this.automata.getElemento(x - 1, y).isVivo()){                
                System.out.println("Hay un vivo en: " + (x-1) + " - " + y);
                return true;
            }
        }
        } catch(NullPointerException e){
        }
        
        
        try {
            // Sur
        if (this.automata.getElemento(x + 1, y) != null && this.automata.getElemento(x + 1, y) instanceof Celula && x+1 <= 29){
            System.out.println("Revisando: " + (x+1) + " - " + y);
           if(this.automata.getElemento(x + 1, y).isVivo()){
                System.out.println("Hay un vivo en: " + (x+1) + " - " + y);
                return true;
            } 
        }
        } catch(NullPointerException e){
        }

                        
        try {
            // Oriente
        if ((this.automata.getElemento(x, y+1) != null) && (this.automata.getElemento(x, y+1) instanceof Celula) && (y+1 <= 29)){
            System.out.println("Revisando: " + (x) + " - " + (y+1));
            if(this.automata.getElemento(x, y+1).isVivo()){
                System.out.println("Hay un vivo en: " + (x) + " - " + (y+1));
                return true;
            }
        }
        } catch(NullPointerException e){
        }
        
        
        try {
            // Occidente
        if (this.automata.getElemento(x, y-1) != null && this.automata.getElemento(x, y-1) instanceof Celula && y-1 >= 0){
            System.out.println("Revisando: " + (x) + " - " + (y-1));
            if(this.automata.getElemento(x, y+1).isVivo()){
                System.out.println("Hay un vivo en: " + x + " - " + (y+1));
                return true;
            }
        }
        } catch(NullPointerException e) {
        }
        
        
        return false;
        
    }
    
    /**
     * decide cual será el estado siguiente
     */
    /*public void decida(){
        if(this.crearCelula() == null){
           estadoSiguiente = Ser.MUERTO; 
           System.out.println("if decida()");
        }else{
            System.out.println("else decida()");
            estadoSiguiente = Ser.VIVO;
            this.crearCelula();
        }        
    }*/
    
    public void decida(){        
        estadoSiguiente = Ser.VIVO; 
        this.crearCelula();
                 
    }
    
}

