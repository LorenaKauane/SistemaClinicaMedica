/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.Controller;

import br.com.ClinicaMedica.Dao.DaoHistoricPatient;
import br.com.ClinicaMedica.Entity.HistoricPatient;
import java.util.List;

/**
 *
 * @author IAGO
 */
public class HistoricPatientController {

    private DaoHistoricPatient daoHistoric;

    public HistoricPatientController() {
        daoHistoric = new DaoHistoricPatient();
    }

    public String validationChecks(HistoricPatient historic) {

        if (historic.getHistoricDiseases().equals("")
                || historic.getHistoricDiseases() == null) {
            return "O campo de historico de doenças está em branco";
        } else {
            return null;
        }

    }

    public String save(HistoricPatient historic) {
        String validation = validationChecks(historic);

        if (validation == null) {
            if (historic.getIdHistoric() == 0) {
                if (daoHistoric.save(historic)) {
                    return null;
                } else {
                    return "Aconteceu alguma coisa com o banco!";
                }
            } else {
                if (daoHistoric.update(historic)) {
                    return null;
                } else {
                    return "Aconteceu alguma coisa com o banco!";
                }
            }
        } else {
            return validation;
        }
    }

    public void delet(HistoricPatient historic) {
        daoHistoric.delet(historic);
    }
    
    public List<HistoricPatient> search(String campo,String pesquisa){
        return daoHistoric.search(campo, pesquisa);
    }
    
    public List<HistoricPatient> getAll(){
        return daoHistoric.getAll();
    }

}
