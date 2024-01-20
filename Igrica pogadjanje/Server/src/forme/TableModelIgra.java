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
public class TableModelIgra extends AbstractTableModel {

    private int[][] matrica = new int[3][3];
    private int brojUnetih = 0;

    public TableModelIgra() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrica[i][j] = -1;
            }
        }
    }

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
        return matrica[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String vrednost = (String) aValue;
        if(brojUnetih == 3){
            return;
        }
        try {
            int broj = Integer.parseInt(vrednost);

            if (broj > 0 && broj < 10) {
                boolean nePostoji = true;

                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(matrica[i][j] == broj){
                            nePostoji = false;
                        }
                    }
                }
                if (nePostoji) {
                    matrica[rowIndex][columnIndex] = broj;
                    brojUnetih++;
                }
            }
        } catch (Exception ex) {

        }

    }

    public int getBrojUnetih() {
        return brojUnetih;
    }

    public int[][] getMatrica() {
        return matrica;
    }
    
    

}
