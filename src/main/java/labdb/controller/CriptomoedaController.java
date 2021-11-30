package labdb.controller;

import labdb.entity.Criptomoeda;
import labdb.service.CriptomoedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class CriptomoedaController {

    @Autowired
    CriptomoedaService criptomoedaService;

    @GetMapping("/")
    public String getAllCriptomoedas(Model model){
        //TODO - SELECT DE EXEMPLO:
        // CONTROLLER -> SERVICE -> REPOSITORY (BOA PRÁTICA EM JAVA)
        List<Criptomoeda> criptomeodas = criptomoedaService.getAllCriptomoedas();
        model.addAttribute("criptomoedas", criptomeodas);

        return "index";
    }

    @PostMapping("/addCripto")
    public String updateOrAddCripto(Criptomoeda criptomoeda){
        //TODO
        //service.fazAporraDoInsertOuUpdate();
        Criptomoeda exists = criptomoedaService.buscaAcriptomoeda(criptomoeda.getId());
        if(exists == null){
            //TODO FAZ SEU INSERT AQUI
        } else {
            criptomoedaService.updateCriptomoeda(criptomoeda);
        }
        return "redirect:/";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editCriptoById(Model model, @PathVariable("id")Optional<String> idCripto){
        if (idCripto.isPresent()){
            //TODO
            Criptomoeda criptomoeda = criptomoedaService.buscaAcriptomoeda(idCripto.get());
            model.addAttribute("criptomoeda", criptomoeda);
        } else {
            model.addAttribute(new Criptomoeda());
        }

        return "criptomoeda";
    }

    @RequestMapping(path = "/delete/{id}")
    public String removeCripto(@PathVariable ("id") Long idCripto){
        //TODO
        //service.removePorId

        return "redirect:/";
    }

}
