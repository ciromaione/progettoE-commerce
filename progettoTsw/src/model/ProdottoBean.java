package model;

public class ProdottoBean {
	
	private long codice;
	private String nome,descrizione;
	private float prezzo;
	
	public ProdottoBean(long k,String n,String des,float p) {
		codice=k;
		nome=n;
		descrizione=des;
		prezzo=p;
	}
	
	public long getCodice() {return codice;}
	
	public String getNome() {return nome;}
	public void setNome(String n) {nome=n;}
	
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String des) {descrizione=des;}
	
	public float getPrezzo() {return prezzo;}
	public void setPrezzo(float p) {prezzo=p;}

}
