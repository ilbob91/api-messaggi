package it.dstech.formazione.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.model.Messaggio;
import it.dstech.formazione.model.Richiesta;
import it.dstech.formazione.model.Utente;
import it.dstech.formazione.repository.UtenteRepository;

@Service
public class UtenteServiceDaoImplement implements UtenteServiceDAO {

	@Autowired
	private UtenteRepository repo;

	@Override
	public boolean add(Utente t) {
		repo.save(t);
		return true;
	}

	@Override
	public List<Utente> findAll() {

		return repo.findAll();
	}

	@Override
	public void remove(Utente t) {
		repo.delete(t);

	}

	@Override
	public List<Messaggio> get(Richiesta richiesta) {
		List<Messaggio> listaMessaggiInviati = new ArrayList<>();
		List<Messaggio> listaMessaggiRicevuti = new ArrayList<>();
		Utente t = repo.findById(richiesta.getNickname()).get();
		for (Messaggio messaggio : t.getListaMessaggi()) {
			if (messaggio.getUserSend().getNickname().equals(t.getNickname())) {
				listaMessaggiInviati.add(messaggio);
			} else {
				listaMessaggiRicevuti.add(messaggio);
			}
		}
		if (0 == richiesta.getTipo()) {
			return listaMessaggiInviati;
		} else {
			return listaMessaggiRicevuti;
		}
	}

	@Override
	public List<String> findNick() {
		List<Utente> listaUtenti = repo.findAll();
		List<String> listaNick = new ArrayList<>();
		for (Utente utente : listaUtenti) {
			listaNick.add(utente.getNickname());
		}
		return listaNick;
	}

	
}
