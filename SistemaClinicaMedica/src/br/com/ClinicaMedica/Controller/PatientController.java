package br.com.ClinicaMedica.Controller;

import br.com.ClinicaMedica.Dao.DaoPatient;
import br.com.ClinicaMedica.Entity.Patient;
import java.util.List;

public class PatientController {

    private DaoPatient daoPatient;
    
    public PatientController(){
        this.daoPatient = new DaoPatient();
    }

    public String validationChecks(Patient patient) {

        if (patient.getName().equals(" ")
                || patient.getName() == null) {
            return "Favor insira o nome!";
        } else if (patient.getAddress().equals(" ")
                || patient.getAddress() == null) {
            return "Favor insira o endereço!";
        } else if (patient.getPhone().equals(" ")
                || patient.getPhone() == null) {
            return "Favor insira o telefone!";
        } else {
            return null;
        }
    }

    public String save(Patient patient) {
        String validation = validationChecks(patient);
        
        if (validation == null) {
            if (patient.getIdPatient() == 0) {
                if (daoPatient.save(patient)) {
                    return null;
                } else {
                    return "Não foi possivel salvar! Aconteceu alguma coisa com o banco!";
                }
            }else{
                if(daoPatient.update(patient)){
                    System.out.println("ENTROU NO UPDADE");
                    return null;
                }else{
                    return "Não foi possivel salvar! Aconteceu alguma coisa com o banco!";
                }
                
            }
        } else {
            return validation;
        }
    }
    
    public void delet(Patient patient){
        daoPatient.delet(patient);
    }
    
    public List<Patient> searchId (String campo,String pesquisa){
        if(pesquisa == null || pesquisa.equals("")){
            return null;
        }
        return daoPatient.searchId(campo, pesquisa);
    }
    
    public List<Patient> getAll(){
        return daoPatient.getall();
    }
    

}
