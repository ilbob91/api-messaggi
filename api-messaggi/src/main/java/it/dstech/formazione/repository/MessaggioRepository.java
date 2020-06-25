package it.dstech.formazione.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.formazione.model.Messaggio;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long>{

}
