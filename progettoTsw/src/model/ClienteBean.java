package model;

import exceptions.*;
import java.util.regex.Pattern;

public class ClienteBean {

	private String nome,email,password,indirizzo,telefono;
	private PayCard carta;
	
	public ClienteBean(String n,String e,String p,String in,String tel,PayCard c) throws IrregularFormatException {
		if(!Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}",e))
			throw new IrregularFormatException("formato email non valido!");
		if(p.equals(password)) throw new IrregularFormatException("la password deve essere diversa dalla vecchia!");
		if(p.length()<8) throw new IrregularFormatException("password troppo corta!");
		if(!Pattern.matches("[0-9]{10}",tel))
			throw new IrregularFormatException("numero di telefono non valido!");
		
		nome=n;
		email=e;
		password=p;
		indirizzo=in;
		telefono=tel;
		carta=c;
	}
	
	
	public String getNome() {return nome;}
	public void setNome(String n) {nome=n;}
	
	public String getEmail() {return email;}
	public void setEmail(String e) throws IrregularFormatException {
		if(!Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}",e))
			throw new IrregularFormatException("formato email non valido!");
		email=e;
	}
	
	public String getPassword() {return password;}
	public void setPassword(String p) throws IrregularFormatException {
		if(p.equals(password)) throw new IrregularFormatException("la password deve essere diversa dalla vecchia!");
		if(p.length()<8) throw new IrregularFormatException("password troppo corta!");
		
		password=p;
	}
	
	public String getIndirizzo() {return indirizzo;}
	public void setIndirizzo(String in) {indirizzo=in;}
	
	public String getTelefono() {return telefono;}
	public void setTelefono(String tel) throws IrregularFormatException {
		if(!Pattern.matches("[0-9]{10}",tel))
			throw new IrregularFormatException("numero di telefono non valido!");
		telefono=tel;
	}
	
	public PayCard getCarta() {return carta;}
	public void setCarta(PayCard c) {carta=c;}
	
	
}
