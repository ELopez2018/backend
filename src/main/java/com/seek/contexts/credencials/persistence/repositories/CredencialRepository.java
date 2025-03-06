package com.seek.contexts.credencials.persistence.repositories;

import com.seek.contexts.credencials.persistence.entities.Credencial;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredencialRepository extends CrudRepository<Credencial, Long> {

 Optional<Credencial> findByEmail(String email);
}
