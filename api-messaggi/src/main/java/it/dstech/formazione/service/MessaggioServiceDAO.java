package it.dstech.formazione.service;

import java.util.List;

import it.dstech.formazione.model.Messaggio;

public interface MessaggioServiceDAO {

	Messaggio add(Messaggio t);
    List<Messaggio> findAll();
    void remove(Messaggio t);
}
