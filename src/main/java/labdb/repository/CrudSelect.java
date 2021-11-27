package labdb.repository;

import labdb.entity.Criptomoeda;
import labdb.repository.rowmapper.CriptomoedaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrudSelect extends DatabaseCrud {

    @Autowired
    CriptomoedaRowMapper criptomoedaRowMapper;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Criptomoeda> getAll(){
        String sql = getSql("buscarCriptomoedas"); //Aqui você passa o nome da query. Escrever ela na DatabaseCrud
        try{
            return namedParameterJdbcTemplate.query(sql, criptomoedaRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
