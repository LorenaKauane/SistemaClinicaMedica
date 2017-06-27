/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.Entity;

/**
 *
 * @author IAGO
 */
public class Doctor {
    private int idDoctor;
    private String name;
    private String specialization;

    public Doctor() {
    }

    public Doctor(int idDoctor, String name, String specialization) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.specialization = specialization;
    }

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
