package it.dstech.formazione.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utente {
	@Id
	private String nickname;
	private String nome;
	private String cognome;
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "utente_id")
	private List<Messaggio> listaMessaggi = new ArrayList<>();
	
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<Messaggio> getListaMessaggi() {
		return listaMessaggi;
	}
	public void setListaMessaggi(List<Messaggio> listaMessaggi) {
		this.listaMessaggi = listaMessaggi;
	}
	
	
}
