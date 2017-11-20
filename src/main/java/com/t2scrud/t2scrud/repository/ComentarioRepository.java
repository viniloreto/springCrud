/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2scrud.t2scrud.repository;

import com.t2scrud.t2scrud.model.Comentario;
import com.t2scrud.t2scrud.model.Reclamacao;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioRepository extends CrudRepository<Comentario, String>{
    Iterable<Comentario> findByReclamacao(Reclamacao reclamacao);
}
