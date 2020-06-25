package it.dstech.formazione.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Messaggio {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne
private Utente userSend;
@ManyToOne
private Utente userReceive;
private String message;
private LocalDateTime timestamp;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Utente getUserSend() {
	return userSend;
}
public void setUserSend(Utente userSend) {
	this.userSend = userSend;
}
public Utente getUserReceive() {
	return userReceive;
}
public void setUserReceive(Utente userReceive) {
	this.userReceive = userReceive;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}


}
