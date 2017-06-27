package br.com.ClinicaMedica.Dao;

import br.com.ClinicaMedica.Entity.Doctor;
import br.com.ClinicaMedica.Factory.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoDoctor {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public DaoDoctor() {
        if(this.connection == null){
            this.connection = DatabaseConnection.conector();
        }
        
    }

    public boolean save(Doctor doctor) {
        String query = "INSERT INTO Doctors (name,specialization) VALUES (?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Doctor doctor) {

        String query = "UPDATE  Doctors SET name = ? ,specialization = ? where idDoctor =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setInt(3, doctor.getIdDoctor());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delet(Doctor doctor) {
        String query = "delete from Doctors where idDoctor=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, doctor.getIdDoctor());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Doctor> searchId(String campo, String pesquisa) {
        //String query = "Select * from Patients where "+ campo+" like '%"+pesquisa+"%'";
        String query = "Select * from Doctors where "+campo +" like '%" + pesquisa + "%'";
        Doctor doctor = new Doctor();
        List<Doctor> doctors = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                doctor.setIdDoctor(rs.getInt("idDoctor"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctors.add(doctor);
            }
            ps.close();
            rs.close();
            return doctors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Doctor> getall() {
        String query = "Select * from Doctors";
        List<Doctor> doctors = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdDoctor(rs.getInt("idDoctor"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));

                doctors.add(doctor);
            }
            ps.close();
            rs.close();
            return doctors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
