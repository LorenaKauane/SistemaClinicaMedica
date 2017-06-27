/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.Entity;

import java.util.Date;

/**
 *
 * @author IAGO
 */
public class HistoricPatient {
    private int     IdHistoric;
    private Patient idPatient;
    private String  historicDiseases; //Historico de doenças 
    private Date    date;

    public HistoricPatient() {
    }

    public HistoricPatient(Patient idPatient, String historicDiseases, Date date) {
        this.idPatient = idPatient;
        this.historicDiseases = historicDiseases;
        this.date = date;
    }

    public HistoricPatient(int IdHistoric, Patient idPatient, String historicDiseases, Date date) {
        this.IdHistoric = IdHistoric;
        this.idPatient = idPatient;
        this.historicDiseases = historicDiseases;
        this.date = date;
    }

    public int getIdHistoric() {
        return IdHistoric;
    }

    public void setIdHistoric(int IdHistoric) {
        this.IdHistoric = IdHistoric;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public String getHistoricDiseases() {
        return historicDiseases;
    }

    public void setHistoricDiseases(String historicDiseases) {
        this.historicDiseases = historicDiseases;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
