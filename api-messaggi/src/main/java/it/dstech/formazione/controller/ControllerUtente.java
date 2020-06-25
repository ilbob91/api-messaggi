package it.dstech.formazione.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.formazione.model.Messaggio;
import it.dstech.formazione.model.Utente;
import it.dstech.formazione.service.MessaggioServiceDAO;
import it.dstech.formazione.service.UtenteServiceDAO;

@RestController
public class ControllerUtente {
@Autowired
private UtenteServiceDAO utenteDao;
@Autowired
private MessaggioServiceDAO messaggioDao;

@RequestMapping("/")
public List<String> getNickname() {
	return utenteDao.findNick();
}

@RequestMapping(value = ("/"), method = RequestMethod.POST)
public boolean addNewUtente(@RequestBody Utente u) {
	return utenteDao.add(u);
}

@RequestMapping(value = ("/"), method = RequestMethod.DELETE)
public boolean removeUtente(@RequestBody Utente u) {
	utenteDao.remove(u);
	return true;
}

@RequestMapping(value = ("/messaggio"), method = RequestMethod.POST)
public List<Messaggio> getMessaggiRicevuti(@RequestBody String nick, @RequestBody String tipo) {
	return utenteDao.get(nick, tipo);
}

@RequestMapping(value = ("/add"), method = RequestMethod.POST)
public Messaggio addNewMessaggio(@RequestBody Messaggio m) {
	return messaggioDao.add(m);
}




}
