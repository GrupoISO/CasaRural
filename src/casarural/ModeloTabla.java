/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casarural;


import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Santi
 */
public class ModeloTabla extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
    
    /**PARAMETROS**/
    Object[][] objetos;
    String[] titles;
    boolean editable;
    
    /**CONSTRUCTOR*/
    public ModeloTabla(Object[][] obj, String[] titulos, boolean editable) {
        super(obj, titulos);
        objetos = obj;
        titles = titulos;
        this.editable = editable;
    }
    
    /**METODOS**/
    
    /**
     * PRE: Se necesita saber si una casilla es editable por el usuario o no.
     * POST: Se ha devuelto un valor booleano que indica si es editable o no.
     * Descripción: Devuelve un valor booleano que indica si una casilla es editable o no.
     * @param: int la fila en la que se encuentra la casilla.
     * @param: int la columna en la que se encuentra la casilla.
     * @return: boolean.
     */
    public boolean isCellEditable(int row, int column)
    {
    	if (column==3){return true;}
        return editable;
    }
    

    
    /**public void setValueAt(Object o, int row, int col)
    {
        if(o instanceof Integer)
        {
            Integer i = (Integer)o;
            super.setValueAt(i, row, col);
        }
        else
        {
            super.setValueAt(o, row, col);
        }
    } **/  
}