package com.t2scrud.t2scrud.controller;

import com.t2scrud.t2scrud.model.Reclamacao;
import com.t2scrud.t2scrud.repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @Autowired
    private ReclamacaoRepository rr;
    
    @RequestMapping("/")
    public ModelAndView listIndex(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Reclamacao> reclamacoes = rr.findAll();
        mv.addObject("reclamacoes", reclamacoes);
        return mv;        
    }
}
