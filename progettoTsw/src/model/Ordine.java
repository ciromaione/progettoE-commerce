package model;

import java.sql.Date;

public class Ordine {

	private int id, totale;
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
	
	
	
}
