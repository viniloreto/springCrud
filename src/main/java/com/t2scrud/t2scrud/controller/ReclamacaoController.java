package com.t2scrud.t2scrud.controller;

import com.t2scrud.t2scrud.model.Comentario;
import com.t2scrud.t2scrud.model.Reclamacao;
import com.t2scrud.t2scrud.repository.ComentarioRepository;
import com.t2scrud.t2scrud.repository.ReclamacaoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReclamacaoController {
    
    @Autowired
    private ReclamacaoRepository rr;
   
    @Autowired
    private ComentarioRepository cr;
    
    @RequestMapping(value="/cadastrarReclamacao", method=RequestMethod.GET)
    public String form(){
        return "formReclamacao";
    }
    
    @RequestMapping(value="/cadastrarReclamacao", method=RequestMethod.POST)
    public String form(Reclamacao reclamacao){
        
        rr.save(reclamacao);
        return "redirect:/cadastrarReclamacao";
    }
    
    @RequestMapping("/reclamacoes")
    public ModelAndView listaReclamacao(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Reclamacao> reclamacoes = rr.findAll();
        mv.addObject("reclamacoes", reclamacoes);
        return mv;
    }
   
    
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalheReclamacao(@PathVariable("codigo") long codigo){
        Reclamacao reclamacao = rr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("detalheReclamacao");
        mv.addObject("reclamacao", reclamacao);
        
        Iterable<Comentario> comentarios = cr.findByReclamacao(reclamacao);
        mv.addObject("comentarios", comentarios);
        return mv;
    }
    
     @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalheReclamacaoPOST(@PathVariable("codigo") long codigo, @Valid Comentario comentario, BindingResult result,RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/{codigo}";
        }
       Reclamacao reclamacao = rr.findByCodigo(codigo);
       comentario.setReclamacao(reclamacao);
       cr.save(comentario);       
       attributes.addFlashAttribute("mensagem","Comentario registrado com sucesso");
        return "redirect:/{codigo}";
    }
    
    @RequestMapping("/deletarReclamacao")
    public String deletarReclamacao(long codigo){
        Reclamacao reclamacao = rr.findByCodigo(codigo);
        rr.delete(reclamacao);
        return "redirect:/reclamacoes";
    }
    
    
   @RequestMapping("/deletarComentario")
	public String deletarComentario(String rg){
		Comentario comentario = cr.findByRg(rg);
		cr.delete(comentario);
		
		Reclamacao reclamacao = comentario.getReclamacao();
		long codigoLong = reclamacao.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
    
}
    
