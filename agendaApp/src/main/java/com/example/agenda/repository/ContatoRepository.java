package com.example.agenda.repository;

import com.example.agenda.models.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, String> {
    Contato findById(long id);
}
