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
public class Patient {
    private int    idPatient;
    private String  name;
    private String  address;
    private String  phone;

    public Patient() {
    }

    public Patient(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Patient(int idPatient, String name, String address, String phone) {
        this.idPatient = idPatient;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
