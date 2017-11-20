package com.t2scrud.t2scrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Comentario {

    
    @Id
    private String rg;
  
   private String nomeComentario;

private String comentario1;

@ManyToOne
private Reclamacao reclamacao;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeComentario() {
        return nomeComentario;
    }

    public void setNomeComentario(String nomeComentario) {
        this.nomeComentario = nomeComentario;
    }

    public String getComentario1() {
        return comentario1;
    }

    public void setComentario1(String comentario1) {
        this.comentario1 = comentario1;
    }

    public Reclamacao getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }

}
