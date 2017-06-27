
package br.com.ClinicaMedica.Entity;

/**
 *
 * @author IAGO
 */
public class QueryDoctor {
     private int             idQuery;
    
    private Patient         patient;
    private HistoricPatient historic;
    private Doctor          Doctor;
    
    private String          Sick;  //Doença do paciente
    private String          state; //Estado atual do paciente 

    public QueryDoctor() {
    }

    public QueryDoctor(Patient patient, HistoricPatient historic, Doctor Doctor, String Sick, String state) {
        this.patient = patient;
        this.historic = historic;
        this.Doctor = Doctor;
        this.Sick = Sick;
        this.state = state;
    }

    public QueryDoctor(int idQuery, Patient patient, HistoricPatient historic, Doctor Doctor, String Sick, String state) {
        this.idQuery = idQuery;
        this.patient = patient;
        this.historic = historic;
        this.Doctor = Doctor;
        this.Sick = Sick;
        this.state = state;
    }

    public int getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(int idQuery) {
        this.idQuery = idQuery;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HistoricPatient getHistoric() {
        return historic;
    }

    public void setHistoric(HistoricPatient historic) {
        this.historic = historic;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor Doctor) {
        this.Doctor = Doctor;
    }

    public String getSick() {
        return Sick;
    }

    public void setSick(String Sick) {
        this.Sick = Sick;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
