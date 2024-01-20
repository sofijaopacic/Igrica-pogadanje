/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sofija
 */
public class TableModelIgraKlijent extends AbstractTableModel{
    
    private int matrica [][] = new int [3][3];

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(matrica[rowIndex][columnIndex]==0){
            return "";
        }
        
        return matrica[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int broj = (int) aValue;
        matrica[rowIndex][columnIndex] = broj;
        fireTableDataChanged();
    }
    
    
}
