package labdb.service;

import labdb.entity.Criptomoeda;
import labdb.repository.CrudSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CriptomoedaService {

    @Autowired
    CrudSelect crudSelect;

    public List<Criptomoeda> getAllCriptomoedas(){
        List<Criptomoeda> criptomoedas = crudSelect.getAll();

        Collections.sort(criptomoedas, Comparator.comparing(Criptomoeda::getMktCapRank));
        return criptomoedas;
    }

    public Criptomoeda buscaAcriptomoeda(String id){
        List<Criptomoeda> criptomoeda = crudSelect.getOne(id);
        return  criptomoeda.isEmpty() ? null :criptomoeda.get(0);
    }

    public void addCriptomoeda(Criptomoeda criptomoeda){
        crudSelect.addOne(criptomoeda);
    }

    public void updateCriptomoeda(Criptomoeda criptomoeda){
        crudSelect.updateOne(criptomoeda);
    }

    public void deleteCriptomoeda(String idCripto){
        crudSelect.deleteOne(idCripto);
    }
}
