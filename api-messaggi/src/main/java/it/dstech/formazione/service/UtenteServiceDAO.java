package it.dstech.formazione.service;

import java.util.List;

import it.dstech.formazione.model.Messaggio;
import it.dstech.formazione.model.Richiesta;
import it.dstech.formazione.model.Utente;

public interface UtenteServiceDAO {

	boolean add(Utente t);
	
	List<Utente> findAll();
	
	void remove(Utente t);
	
	List<String> findNick();

	List<Messaggio> get(Richiesta r);

	
	
}
