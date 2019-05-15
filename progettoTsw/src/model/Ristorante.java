package model;

import java.util.regex.Pattern;


public class Ristorante {
	
	private int id, capCitta;
	private String nome, indirizzo, email, pass, telefono, oraAp, oraCh;
	
	
	public int getId() { return id;}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() { return nome;}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCapCitta() {	return capCitta;}
	public void setCapCitta(int capCitta) {
		this.capCitta = capCitta;
	}
	
	public String getIndirizzo() { return indirizzo;}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getEmail() { return email;}
	public void setEmail(String email) {
		if(!Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,4}",email))
			throw new RuntimeException("formato email non valido!");
		this.email = email;
	}
	
	public String getPass() { return pass;}
	public void setPass(String pass) {
		if(pass.length()<8) throw new RuntimeException("password troppo corta!");
		this.pass = pass;
	}
	
	public String getTelefono() { return telefono;}
	public void setTelefono(String telefono) {
		if(!Pattern.matches("[0-9]{10}",telefono))
			throw new RuntimeException("numero di telefono non valido!");
		this.telefono = telefono;
	}
	
	public String getOraAp() {return oraAp;}
	public void setOraAp(String oraAp) {
		if(!Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",oraAp))
			throw new RuntimeException("formato ora non valido!");
		this.oraAp = oraAp;
	}
	
	public String getOraCh() { return oraCh;}
	public void setOraCh(String oraCh) {
		if(!Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",oraCh))
			throw new RuntimeException("formato ora non valido!");
		this.oraCh = oraCh;
	}
	
	

}
