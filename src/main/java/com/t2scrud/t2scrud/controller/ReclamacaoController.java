package com.t2scrud.t2scrud.controller;

import com.t2scrud.t2scrud.model.Reclamacao;
import com.t2scrud.t2scrud.repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReclamacaoController {
    
    @Autowired
    private ReclamacaoRepository er1;
            
    @RequestMapping(value="/cadastrarReclamacao", method=RequestMethod.GET)
    public String form(){
        return "formReclamacao";
    }
    
    @RequestMapping(value="/cadastrarReclamacao", method=RequestMethod.POST)
    public String form(Reclamacao reclamacao){
        
        er1.save(reclamacao);
        return "redirect:/cadastrarReclamacao";
    }
}
