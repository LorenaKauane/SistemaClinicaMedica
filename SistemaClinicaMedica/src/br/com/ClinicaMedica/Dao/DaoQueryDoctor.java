package br.com.ClinicaMedica.Dao;

import br.com.ClinicaMedica.Entity.Doctor;
import br.com.ClinicaMedica.Entity.HistoricPatient;
import br.com.ClinicaMedica.Entity.Patient;
import br.com.ClinicaMedica.Entity.QueryDoctor;
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
public class DaoQueryDoctor {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public DaoQueryDoctor() {
        if(this.connection == null){
            this.connection = DatabaseConnection.conector();
        }
        
    }
    
    

    public boolean save(QueryDoctor queryDoctor) {
        String query = "INSERT INTO QueryDoctors(idPatient,IdHistoric,idDoctor,sick,state) VALUES (?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, queryDoctor.getPatient().getIdPatient());
            ps.setInt(2, queryDoctor.getHistoric().getIdHistoric());
            ps.setInt(3, queryDoctor.getDoctor().getIdDoctor());
            ps.setString(4, queryDoctor.getSick());
            ps.setString(5, queryDoctor.getState());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delet(QueryDoctor queryDoctor){
        String query = "delete from QueryDoctors where idQuery=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, queryDoctor.getIdQuery());
            
            ps.execute();
            ps.close();
           return true;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPatient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public List<QueryDoctor> search(String campo, String campoPesquisa) {
        List<QueryDoctor> querys = new ArrayList<>();
        String sql = 
                       "SELECT " +
                " query.idQuery, " +
                " query.sick, " +
                " query.state, " +
                
                " patient.idPatient, " +
                " patient.name, " +
                " patient.phone, " +      
                      
                      
                " historic.IdHistoric, " +
                " historic.historicDiseases, " +
                " historic.date," +
  
                " doctor.name, " +
                " doctor.idDoctor "+
                
                "FROM Patients patient " +
                        " INNER JOIN QueryDoctors query ON " +
                        " patient.idPatient = query.idPatient  " +

                        "INNER JOIN HistoricPatients historic  ON " +
"               	historic.IdHistoric = query.IdHistoric " + 
                        
                        "INNER JOIN Doctors doctor  ON " +
"               	doctor.idDoctor = query.idDoctor "+
                
                "WHERE " + campo + " like '%" + campoPesquisa + "%'";
        
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                QueryDoctor query = new QueryDoctor();
                Patient patient = new Patient();
                HistoricPatient historic = new HistoricPatient();
                Doctor doctor = new Doctor();
                
                query.setIdQuery(rs.getInt("query.idQuery"));
                query.setSick(rs.getString("query.sick"));
                query.setState(rs.getString("query.state"));
                
                patient.setIdPatient(rs.getInt("patient.idPatient"));
                patient.setName(rs.getString("patient.name"));
                patient.setPhone(rs.getString("patient.phone"));
                
                historic.setIdHistoric(rs.getInt("historic.IdHistoric"));
                historic.setHistoricDiseases(rs.getString("historic.historicDiseases"));
                historic.setDate(rs.getTimestamp("historic.date"));

                doctor.setName(rs.getString("doctor.name"));
                doctor.setIdDoctor(rs.getInt("doctor.idDoctor"));

                query.setPatient(patient);
                query.setHistoric(historic);
                query.setDoctor(doctor);

                querys.add(query);


            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return querys;
    }

     public List<QueryDoctor> getAll(){
            List<QueryDoctor> querys = new ArrayList<>();
              String sql = 
                "SELECT " +
                " query.idQuery, " +
                " query.sick, " +
                " query.state, " +
                
                " patient.idPatient, " +
                " patient.name, " +
                " patient.phone, " +      
                      
                      
                " historic.IdHistoric, " +
                " historic.historicDiseases, " +
                " historic.date," +
  
                " doctor.name, " +
                " doctor.idDoctor "+
                
                "FROM Patients patient " +
                        " INNER JOIN QueryDoctors query ON " +
                        " patient.idPatient = query.idPatient  " +

                        "INNER JOIN HistoricPatients historic  ON " +
"               	historic.IdHistoric = query.IdHistoric " + 
                        
                        "INNER JOIN Doctors doctor  ON " +
"               	doctor.idDoctor = query.idDoctor";
        
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                QueryDoctor query = new QueryDoctor();
                Patient patient = new Patient();
                HistoricPatient historic = new HistoricPatient();
                Doctor doctor = new Doctor();
                
                query.setIdQuery(rs.getInt("query.idQuery"));
                query.setSick(rs.getString("query.sick"));
                query.setState(rs.getString("query.state"));
                
                patient.setIdPatient(rs.getInt("patient.idPatient"));
                patient.setName(rs.getString("patient.name"));
                patient.setPhone(rs.getString("patient.phone"));
                
                historic.setIdHistoric(rs.getInt("historic.IdHistoric"));
                historic.setHistoricDiseases(rs.getString("historic.historicDiseases"));
                historic.setDate(rs.getTimestamp("historic.date"));

                doctor.setName(rs.getString("doctor.name"));
                doctor.setIdDoctor(rs.getInt("doctor.idDoctor"));

                query.setPatient(patient);
                query.setHistoric(historic);
                query.setDoctor(doctor);

                querys.add(query);

            }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return querys; 
         
         
     }
}
