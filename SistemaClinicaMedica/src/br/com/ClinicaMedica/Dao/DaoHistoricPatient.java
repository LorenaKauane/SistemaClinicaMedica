/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.Dao;

import br.com.ClinicaMedica.Entity.HistoricPatient;
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

/**
 *
 * @author IAGO
 */
public class DaoHistoricPatient {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public DaoHistoricPatient() {
        if(this.connection == null){
            this.connection = DatabaseConnection.conector();
        }
    }

    public boolean save(HistoricPatient historicPatient) {
        String query = "INSERT INTO HistoricPatients(idPatient,historicDiseases) VALUES (?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, historicPatient.getIdPatient().getIdPatient());
            ps.setString(2, historicPatient.getHistoricDiseases());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(HistoricPatient historicPatient) {

        String query = "UPDATE  HistoricPatients SET historicDiseases = ? where IdHistoric = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, historicPatient.getHistoricDiseases());
            ps.setInt(2, historicPatient.getIdHistoric());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delet(HistoricPatient historicPatient) {
        String query = "delete from HistoricPatients where IdHistoric=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, historicPatient.getIdHistoric());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<HistoricPatient> search(String campo, String campoPesquisa) {

        String sql = "	SELECT "
                + "		     patient.idPatient,"
                + "                  patient.name,"
                + "                  historic.IdHistoric "
                + "                  historic.historicDiseases "
                + "                  historic.date "
                + "FROM Patients patient "
                + "	INNER JOIN HistoricPatients historic ON "
                + "	patient.idPatient = historic.idPatient "
                + " WHERE " + campo + " like '%" + campoPesquisa + "%'";

        List<HistoricPatient> historics = new ArrayList<>();
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HistoricPatient historic = new HistoricPatient();
                Patient patient = new Patient();

                patient.setIdPatient(rs.getInt("patient.idPatient"));
                patient.setName(rs.getString("patient.name"));

                historic.setIdHistoric(rs.getInt("IdHistoric"));
                historic.setHistoricDiseases(rs.getString("historicDiseases"));
                historic.setDate(rs.getTimestamp("date"));

                historic.setIdPatient(patient);

                historics.add(historic);

            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return historics;
    }
    
    public List<HistoricPatient> getAll(){
          String sql = "	SELECT "
                + "		     patient.idPatient,"
                + "                  patient.name,"
                + "                  historic.IdHistoric "
                + "                  historic.historicDiseases "
                + "                  historic.date "
                + "FROM Patients patient "
                + "	INNER JOIN HistoricPatients historic ON "
                + "	patient.idPatient = historic.idPatient; ";
             

        List<HistoricPatient> historics = new ArrayList<>();
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HistoricPatient historic = new HistoricPatient();
                Patient patient = new Patient();

                patient.setIdPatient(rs.getInt("patient.idPatient"));
                patient.setName(rs.getString("patient.name"));

                historic.setIdHistoric(rs.getInt("IdHistoric"));
                historic.setHistoricDiseases(rs.getString("historicDiseases"));
                historic.setDate(rs.getTimestamp("date"));

                historic.setIdPatient(patient);

                historics.add(historic);

            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return historics;
    }

}
