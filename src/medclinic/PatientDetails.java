/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medclinic;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PIYUMI
 */
public class PatientDetails extends AbstractTableModel{

    private static final String[] COLUMN_NAMES = {"ID", "Name", "Age", "Address"}; 
    private static ArrayList<Patient> list;
    
    PatientDetails (ArrayList<Patient> pList){
        list = pList;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : 
                return list.get(rowIndex).getId();
            case 1 : 
                return list.get(rowIndex).getName();
            case 2 : 
                return list.get(rowIndex).getAge();
            case 3 : 
                return list.get(rowIndex).getAddress();
            default : 
                return "Error";
        }
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    
}
