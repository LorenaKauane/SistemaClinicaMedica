package br.com.ClinicaMedica.Controller;

import br.com.ClinicaMedica.Dao.DaoQueryDoctor;
import br.com.ClinicaMedica.Entity.QueryDoctor;
import java.util.List;

public class QueryDoctorController {

    private DaoQueryDoctor daoQuery;

    public QueryDoctorController() {
        daoQuery = new DaoQueryDoctor();
    }

    public String validationChecks(QueryDoctor query) {

        if (query.getSick().equals("")
                || query.getSick() == null) {
            return "O campo de doença está em branco";
        } else if (query.getState().equals("")
                || query.getState() == null) {
            return "O campo da situação está em branco";
        } else if( query.getDoctor().getName() == null 
                || query.getDoctor().equals("")){
            return "O nome do medico não é valido!";
        }
        else {
            return null;
        }

    }

    public String save(QueryDoctor query) {
        String validation = validationChecks(query);
        if (validation == null) {
            if (daoQuery.save(query)) {
                return null;
            } else {
                return "Não foi possivel salvar! Aconteceu alguma coisa com o banco!";
            }
        }else{
            return validation;
        }
    }
    
     public void delet(QueryDoctor query){
        daoQuery.delet(query);
    }
    
    public List<QueryDoctor> search (String campo,String pesquisa){
        return daoQuery.search(campo, pesquisa);
    }
    
    public List<QueryDoctor> getAll(){
        return daoQuery.getAll();
    }

}
