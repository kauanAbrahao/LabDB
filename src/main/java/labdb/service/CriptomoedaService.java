package labdb.service;

import labdb.entity.Criptomoeda;
import labdb.repository.CrudSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CriptomoedaService {

    @Autowired
    CrudSelect crudSelect;

    public List<Criptomoeda> getAllCriptomoedas(){
        List<Criptomoeda> criptomoedas = crudSelect.getAll();

        Collections.sort(criptomoedas, Comparator.comparing(Criptomoeda::getMktCapRank));
        return criptomoedas;
    }

    public Criptomoeda buscaAcriptomoeda(Optional<String> id){
        List<Criptomoeda> criptomoeda = crudSelect.getOne(id.get());
        return criptomoeda.get(0);
    }
}
