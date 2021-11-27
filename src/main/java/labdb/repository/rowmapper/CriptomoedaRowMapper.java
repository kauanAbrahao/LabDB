package labdb.repository.rowmapper;

import labdb.entity.Criptomoeda;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CriptomoedaRowMapper implements RowMapper<Criptomoeda> {

    @Override
    public Criptomoeda mapRow(ResultSet resultSet, int i) throws SQLException {
        Criptomoeda criptomoeda = new Criptomoeda();
        criptomoeda.setId(resultSet.getString("ID_Cripto"));
        criptomoeda.setNome(resultSet.getString("Nome_Cripto"));
        criptomoeda.setMktCapRank(resultSet.getInt("MKT_Cap_Rank"));
        criptomoeda.setSymbol((resultSet.getString("Symbol")));
        return criptomoeda;
    }
}
