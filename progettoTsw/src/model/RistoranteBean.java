package model;

import java.util.regex.Pattern;

import exceptions.*;

/*----------------------------------
	MANCANO IMMAGINI
----------------------------------*/

public class RistoranteBean {

	private long id;
	private String nome,indirizzo,email,password,telefono,apertura,chiusura;
	
	public RistoranteBean(long idr,String n,String ind,String e,String p,String tel,String ap,String ch) throws IrregularFormatException {
		if(!Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,4}",e))
			throw new IrregularFormatException("formato emali non valido!");
		if(p.length()<8) throw new IrregularFormatException("password troppo corta!");
		if(!Pattern.matches("[0-9]{10}",tel)) throw new IrregularFormatException("numero di telefono non valido!");
		if(!Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",ap) || !Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",ch))
			throw new IrregularFormatException("formato ora non valido!");
		id=idr;
		nome=n;
		indirizzo=ind;
		email=e;
		password=p;
		telefono=tel;
		apertura=ap;
		chiusura=ch;
	}
	
	public long getId() {return id;}
	
	public String getNome(){return nome;}
	public void setNome(String n) {nome=n;}
	
	public String getIndirizzo() {return indirizzo;}
	public void setIndirizzo(String ind) {indirizzo=ind;}
	
	public String getEmail() {return email;}
	public void setEmail(String e) throws IrregularFormatException {
		if(!Pattern.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,4}",e))
			throw new IrregularFormatException("formato emali non valido!");
		email=e;
	}
	
	public boolean testPassword(String p) {return password.equals(p);}
	public void setPassword(String p) throws IrregularFormatException {
		if(p.equals(password)) throw new IrregularFormatException("la password deve essere diversa dalla vecchia!");
		if(p.length()<8) throw new IrregularFormatException("password troppo corta!");
		
		password=p;
	}
	
	public String getTelefono() {return telefono;}
	public void setTelefono(String tel) throws IrregularFormatException {
		if(!Pattern.matches("[0-9]{10}",tel))
			throw new IrregularFormatException("numero di telefono non valido!");
		telefono=tel;
	}
	
	public String getOraApertura() {return apertura;}
	public void setOraApertura(String ap) throws IrregularFormatException {
		if(!Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",ap))
			throw new IrregularFormatException("formato ora non valido!");
		
		apertura=ap;
	}
	
	public String getOraChiusura() {return chiusura;}
	public void setOraChiusura(String ch) throws IrregularFormatException {
		if(!Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]",ch))
			throw new IrregularFormatException("formato ora non valido!");
		
		chiusura=ch;
	}
	
}
