package com.note.book.banco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.note.book.entidade.Usuario;

@Repository
public interface UsuarioBanco extends CrudRepository<Usuario, Integer>{
    
}
