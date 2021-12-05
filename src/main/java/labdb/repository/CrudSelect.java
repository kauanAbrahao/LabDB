package labdb.repository;

import labdb.entity.Criptomoeda;
import labdb.repository.rowmapper.CriptomoedaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    public List<Criptomoeda> getOne(String id){
        String sql = getSql("buscarPorID");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", id);
        try{
            return namedParameterJdbcTemplate.query(sql,params, criptomoedaRowMapper);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addOne (Criptomoeda criptomoeda){
        String sql = getSql("insertCriptomoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Nome_Cripto", criptomoeda.getNome());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        params.addValue("Symbol", criptomoeda.getSymbol());
        try{
            namedParameterJdbcTemplate.update(sql,params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateOne (Criptomoeda criptomoeda){
        String sql = getSql("updateCriptomoedas");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", criptomoeda.getId());
        params.addValue("Nome_Cripto", criptomoeda.getNome());
        params.addValue("MKT_Cap_Rank", criptomoeda.getMktCapRank());
        params.addValue("Symbol", criptomoeda.getSymbol());
        try{
            namedParameterJdbcTemplate.update(sql,params);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteOne (String idCripto) {
        String sql = getSql("deleteCriptoMoeda");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ID_Cripto", idCripto);
        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
