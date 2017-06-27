
package br.com.ClinicaMedica.Dao;

import br.com.ClinicaMedica.Entity.Patient;
import br.com.ClinicaMedica.Factory.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoPatient {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DaoPatient() {
        if(this.connection == null){
            this.connection = DatabaseConnection.conector();
        }
        
    }
    
    public boolean save(Patient patient){
        String query = "INSERT INTO Patients(name,address,phone) VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getAddress());
            ps.setString(3, patient.getPhone());
            
            ps.execute();
            ps.close();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(Patient patient){
        
        String query = "UPDATE  Patients SET name = ? ,address = ?,phone =? where idPatient = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getAddress());
            ps.setString(3, patient.getPhone());
            ps.setInt   (4, patient.getIdPatient());
            
            ps.execute();
            ps.close();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delet(Patient patient){
        String query = "delete from Patients where idPatient=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, patient.getIdPatient());
            
            ps.execute();
            ps.close();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Patient> searchId(String campo, String pesquisa){
         String query = "Select * from Patients where "+ campo+" like '%"+pesquisa+"%'";
         Patient patient = new Patient();
         List<Patient> patients = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) { 
                patient.setIdPatient(rs.getInt("idPatient"));
                patient.setName(rs.getString("name"));
                patient.setAddress(rs.getString("address"));
                patient.setPhone(rs.getString("phone"));
                patients.add(patient);
            }
            ps.close();
            rs.close();
            return patients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Patient> getall(){
         String query = "Select * from Patients";
         List<Patient> patients =  new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) { 
                Patient patient = new Patient();
                patient.setIdPatient(rs.getInt("idPatient"));
                patient.setName(rs.getString("name"));
                patient.setAddress(rs.getString("address"));
                patient.setPhone(rs.getString("phone"));
                patients.add(patient);
            }
            ps.close();
            rs.close();
            return patients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
}
