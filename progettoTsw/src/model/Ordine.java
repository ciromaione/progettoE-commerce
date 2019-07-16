package model;

import java.sql.Date;

public class Ordine {

	private int id, totale, idUtente;
	private Date dataAcq;
	
	
	
	public int getId() { return id;}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTotale() { return totale;}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	
	public Date getDataAcq() { return dataAcq;}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	
	public int getIdUtente() { return idUtente;}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
	
	
}
