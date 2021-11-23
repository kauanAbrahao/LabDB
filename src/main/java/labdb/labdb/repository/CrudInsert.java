package labdb.labdb.repository;

import labdb.labdb.entity.Criptomoeda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class CrudInsert extends DatabaseCrud {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    public List<Criptomoeda> getAll(){
//        String sql = getSql("getAllCriptoValor"); //Aqui você passa o nome da query. Escrever ela na DatabaseCrud
//        try{
//            return namedParameterJdbcTemplate.query(sql);
//        } catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
