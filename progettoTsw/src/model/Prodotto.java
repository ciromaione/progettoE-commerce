package model;

public class Prodotto {

	private int id, idRisto, idCat, prezzoCent;
	private String nome, descrizione;
	
	
	public int getId() { return id;}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdRisto() { return idRisto;}
	public void setIdRisto(int idRisto) {
		this.idRisto = idRisto;
	}
	
	public int getIdCat() { return idCat;}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	
	public int getPrezzoCent() { return prezzoCent;}
	public String getPrezzoEuro() {
		String price = Integer.toString(this.prezzoCent);
		int size = price.length();
		if(size == 1) return "0,0"+price;
		else if(size == 2) return "0,"+price;
		else return price.substring(0, size-3)+","+price.substring(size-3);
	}
	public void setPrezzoCent(int prezzoCent) {
		this.prezzoCent = prezzoCent;
	}
	
	public String getNome() { return nome;}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() { return descrizione;}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
}
