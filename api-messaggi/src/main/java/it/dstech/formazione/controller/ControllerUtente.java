package it.dstech.formazione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.dstech.formazione.model.Messaggio;
import it.dstech.formazione.model.Richiesta;
import it.dstech.formazione.model.Utente;
import it.dstech.formazione.service.MessaggioServiceDAO;
import it.dstech.formazione.service.UtenteServiceDAO;

@RestController
public class ControllerUtente {
	@Autowired
	private UtenteServiceDAO utenteDao;
	@Autowired
	private MessaggioServiceDAO messaggioDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Recupera tutti i nickname", notes = "Con questa chiamata riceveremo tutti i nickname registrati nel sistema")
	public List<String> getNickname() {
		return utenteDao.findNick();
	}

	@RequestMapping(value = ("/"), method = RequestMethod.POST)
	@ApiOperation(value = "Aggiunge un nuovo utente", notes = "Con questa chiamata aggiungeremo un utente nel sistema")
	public boolean addNewUtente(
			@ApiParam(value = "Gli viene passato un oggetto di tipo Utente", name = "utente") @RequestBody Utente u) {
		return utenteDao.add(u);
	}

	@RequestMapping(value = ("/"), method = RequestMethod.DELETE)
	@ApiOperation(value = "Elimina un utente", notes = "Con questa chiamata elimineremo un utente dal sistema")
	public boolean removeUtente(
			@ApiParam(value = "Gli viene passato un oggetto di tipo Utente", name = "utente") @RequestBody Utente u) {
		utenteDao.remove(u);
		return true;
	}

	@RequestMapping(value = ("/messaggio"), method = RequestMethod.POST)
	@ApiOperation(value = "Restituisce tutti i messaggi di un determinato utente", notes = "Con questa chiamata avremo i messaggi di un utente nel sistema")
	public List<Messaggio> getMessaggiRicevuti(
			@ApiParam(value = "Richiesta oggetto custom per eseguire la richiesta di getMessaggio", name = "richiesta") @RequestBody Richiesta richiesta) {
		return utenteDao.get(richiesta);
	}

	@RequestMapping(value = ("/add"), method = RequestMethod.POST)
	@ApiOperation(value = "Crea un nuovo messaggio", notes = "Con questa chiamata creeremo un messaggio nel sistema")
	public Messaggio addNewMessaggio(@ApiParam(value = "Gli viene passato un oggetto di tipo Messaggio", name = "messaggio")@RequestBody Messaggio m) {
		return messaggioDao.add(m);
	}

}
