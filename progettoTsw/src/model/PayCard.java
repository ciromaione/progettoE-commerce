package model;

import java.util.regex.Pattern;

import exceptions.*;

public class PayCard {
	
	private String numero,scadenza;
	private int cvv;
	
	public PayCard(String n,String sc,int c) throws IrregularFormatException {
		if(!Pattern.matches("[0-9]{16}",n)) throw new IrregularFormatException("formato numero carta non valido!");
		if(!Pattern.matches("(0[1-9]|1[0-2)/[12][0-9]",sc))
			throw new IrregularFormatException("formato data di scadenza non valido!");
		if(c<100 || c>=1000) throw new IrregularFormatException("formato cvv non valido!");
		numero=n;
		scadenza=sc;
		cvv=c;
	}
	
	public String getNumero() {return numero;}
	public String getScadenza() {return scadenza;}
	public int getCvv() {return cvv;}

}
