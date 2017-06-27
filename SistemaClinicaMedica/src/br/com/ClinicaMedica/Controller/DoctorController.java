package br.com.ClinicaMedica.Controller;

import br.com.ClinicaMedica.Dao.DaoDoctor;
import br.com.ClinicaMedica.Entity.Doctor;
import java.util.List;

public class DoctorController {

    private DaoDoctor daoDoctor;

    public DoctorController() {
        this.daoDoctor = new DaoDoctor();
    }

    public String validationChecks(Doctor doctor) {
        if (doctor.getName().equals("")
                || doctor.getName() == null) {
            return "Favor insira o nome!";
        } else if (doctor.getSpecialization().equals("")
                || doctor.getSpecialization() == null 
                || doctor.getSpecialization() == "Selecione!") {
            return "Favor insira a especialização do medico!";
        } else {
            return null;
        }

    }

    public String save(Doctor doctor) {
        String validation = validationChecks(doctor);
        System.out.println(doctor.getName());
  
        if (validation == null) {
            if (doctor.getIdDoctor() == 0) {
                if (daoDoctor.save(doctor)) {
                    return null;
                } else {
                    return "Aconteceu alguma coisa com o banco!";
                }
            } else {
                if (daoDoctor.update(doctor)) {
                    return null;
                } else {
                    return "Aconteceu alguma coisa com o banco!";
                }
            }
        } else {
            return validation;
        }

    }
    
    public void delet(Doctor doctor){
        daoDoctor.delet(doctor);
    }
    public List<Doctor> searchId (String campo,String pesquisa){
        return daoDoctor.searchId(campo, pesquisa);
    }
    
    public List<Doctor> getAll(){
        return daoDoctor.getall();
    }

}