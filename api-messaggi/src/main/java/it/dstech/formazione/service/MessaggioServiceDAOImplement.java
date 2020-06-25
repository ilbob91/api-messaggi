package it.dstech.formazione.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.model.Messaggio;
import it.dstech.formazione.model.Utente;
import it.dstech.formazione.repository.MessaggioRepository;
import it.dstech.formazione.repository.UtenteRepository;

@Service
public class MessaggioServiceDAOImplement implements MessaggioServiceDAO{
@Autowired
private MessaggioRepository repo;
@Autowired
private UtenteRepository utenteRepo;

@Override
public Messaggio add(Messaggio t) {

	t.setTimestamp(LocalDateTime.now());
	Messaggio salvato = repo.save(t);
	Utente sender = utenteRepo.findById(t.getUserSend().getNickname()).get();
	Utente receiver = utenteRepo.findById(t.getiDuserReceive()).get();
	sender.getListaMessaggi().add(salvato);
	utenteRepo.save(sender);
	Messaggio m = new Messaggio();
	m.setTipo(1);
	m.setiDuserReceive(salvato.getiDuserReceive());
	m.setMessage(salvato.getMessage());
	m.setUserSend(salvato.getUserSend());
	m.setTimestamp(salvato.getTimestamp());
	repo.save(m);
	receiver.getListaMessaggi().add(m);
	utenteRepo.save(receiver);
	
	return salvato;
}

@Override
public List<Messaggio> findAll() {
	return repo.findAll();
}

@Override
public void remove(Messaggio t) {
	repo.delete(t);
	
}


}
