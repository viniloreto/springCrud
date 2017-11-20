package com.t2scrud.t2scrud.repository;

import com.t2scrud.t2scrud.model.Reclamacao;
import org.springframework.data.repository.CrudRepository;

public interface ReclamacaoRepository extends CrudRepository<Reclamacao, String> {

    Reclamacao findByCodigo(long codigo);
    Reclamacao getReclamacaoByCodigo(long codigo);

   

}
