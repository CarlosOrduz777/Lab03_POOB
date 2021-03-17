package domain;
import java.awt.Color;

/**
 * Write a description of class testCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testCell extends Celula
{
    public testCell(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        super.color = Color.red;
    }
}
