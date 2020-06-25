package it.dstech.formazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, String>{

}
