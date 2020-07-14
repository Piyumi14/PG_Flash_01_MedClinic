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
public class PatientDetails extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {
        "ID",
        "Full Name",
        "Age",
        "Gender",
        "NIC",
        "Address",
        "Telephone",
        "Height",
        "Weight",
        "Presenting Complain",
        "Past Medical History",
        "Menstrual History",
        "Allergies",
        "Examination",
        "Investigation"
    };
    private static ArrayList<Patient> list;

    PatientDetails(ArrayList<Patient> pList) {
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
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getFullName();
            case 2:
                return list.get(rowIndex).getAge();
            case 3:
                return list.get(rowIndex).getGender();
            case 4:
                return list.get(rowIndex).getNic();
            case 5:
                return list.get(rowIndex).getAddress();
            case 6:
                return list.get(rowIndex).getTelephone();
            case 7:
                return list.get(rowIndex).getHeight();
            case 8:
                return list.get(rowIndex).getWeight();
            case 9:
                return list.get(rowIndex).getPresentingComplain();
            case 10:
                return list.get(rowIndex).getPastMedicalHistory();
            case 11:
                return list.get(rowIndex).getMenstrualHistory();
            case 12:
                return list.get(rowIndex).getAllergies();
            case 13:
                return list.get(rowIndex).getExamination();
            case 14:
                return list.get(rowIndex).getInvestigation();
            default:
                return "Error";
        }
    }

    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

}
