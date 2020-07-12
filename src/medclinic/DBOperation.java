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
            String query = "Insert into patient values (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, p.getId());
            pst.setString(2, p.getName());
            pst.setString(3, p.getAge());
            pst.setString(4, p.getAddress());

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
    
    ArrayList<Patient>getPatients(){
        try {
            ArrayList<Patient> list = new ArrayList<Patient>();
            
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM patient";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();
            
            while(rs.next()){
                Patient p = new Patient();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setAge(rs.getString(3));
                p.setAddress(rs.getString(4));
                
                list.add(p);   
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }
    public boolean updatePatient(Patient p){
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE patient SET name='"+p.getName()+"' , age='"+p.getAge()+"' , address='"+p.getAddress()+"' WHERE id="+p.getId();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } 
    }
    
    public boolean deletePatient(Patient p){
          try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "DELETE FROM patient WHERE id="+p.getId();
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } 
    }
} 
    
