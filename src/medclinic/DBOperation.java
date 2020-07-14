/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medclinic;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PIYUMI
 */
public class DBOperation {

    String url = "jdbc:mysql://localhost:3306/medclinic";
    String username = "root";
    String password = "root";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    boolean addPatient(Patient p) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "Insert into patient values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, p.getId());
            pst.setString(2, p.getFullName());
            pst.setInt(3, p.getAge());
            pst.setString(4, p.getGender());
            pst.setString(5, p.getNic());
            pst.setString(6, p.getAddress());
            pst.setInt(7, p.getTelephone());
            pst.setInt(8, p.getHeight());
            pst.setInt(9, p.getWeight());
            pst.setString(10, p.getPresentingComplain());
            pst.setString(11, p.getPastMedicalHistory());
            pst.setString(12, p.getMenstrualHistory());
            pst.setString(13, p.getAllergies());
            pst.setString(14, p.getExamination());
            pst.setString(15, p.getInvestigation());

            pst.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                    return false;
                }
            }
        }

    }

    ArrayList<Patient> getPatients() {
        try {
            ArrayList<Patient> list = new ArrayList<Patient>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM patient";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt(1));
                p.setFullName(rs.getString(2));
                p.setAge(rs.getInt(3));
                p.setGender(rs.getString(4));
                p.setNic(rs.getString(5));
                p.setAddress(rs.getString(6));
                p.setTelephone(rs.getInt(7));
                p.setHeight(rs.getInt(8));
                p.setWeight(rs.getInt(9));
                p.setPresentingComplain(rs.getString(10));
                p.setPastMedicalHistory(rs.getString(11));
                p.setMenstrualHistory(rs.getString(12));
                p.setAllergies(rs.getString(13));
                p.setExamination(rs.getString(14));
                p.setInvestigation(rs.getString(15));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean updatePatient(Patient p) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE patient SET fullName='" + p.getFullName() 
                    + "' , age='" + p.getAge() 
                    + "' , gender='" + p.getGender() 
                    + "' , nic='" + p.getNic() 
                    + "' , address='" + p.getAddress()
                    + "' , telephone='" + p.getTelephone()
                    + "' , height='" + p.getHeight()
                    + "' , weight='" + p.getWeight()
                    + "' , pc_presentingComplaim='" + p.getPresentingComplain()
                    + "' , pmh_pastMedicalHistory='" + p.getPastMedicalHistory()
                    + "' , mh_menstrualHistory='" + p.getMenstrualHistory()
                    + "' , allergies='" + p.getAllergies()
                    + "' , examination='" + p.getExamination()
                    + "' , investigation='" + p.getInvestigation()
                    
                    
                    
                    + "' WHERE id=" + p.getId();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deletePatient(Patient p) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM patient WHERE id=" + p.getId();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
    
