package com.t2scrud.t2scrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Comentario {

private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)  
    private long codigo;
 @NotEmpty   
private String nomeComentario;
 @NotEmpty
private String comentario1;

@ManyToOne
private Reclamacao reclamacao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
