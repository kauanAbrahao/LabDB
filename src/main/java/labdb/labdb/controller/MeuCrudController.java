package labdb.labdb.controller;

import labdb.labdb.entity.Criptomoeda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/meuCrud")
public class MeuCrudController {

    @GetMapping(path = "/form")
    public String create(Model model){
        model.addAttribute("criptomoeda", new Criptomoeda());
        //service.fazAporraDoCrud();

        return "meuForm";
    }

}
