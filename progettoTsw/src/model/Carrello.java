package model;

import java.util.Collection;
import java.util.HashMap;



public class Carrello {
	
	public static class ProdQuant {
		private Prodotto prodotto;
		private int quantita;
		
		public ProdQuant(Prodotto prodotto, int quantita) {
			this.prodotto = prodotto;
			this.quantita = quantita;
		}
		
		public Prodotto getProdotto() { return this.prodotto;}
		public void setProdotto(Prodotto prodotto) { this.prodotto = prodotto;}
		
		public int getQuantita() { return this.quantita;}
		public void setQuantita(int quantita) { this.quantita = quantita;}
	}
	
	private HashMap<Integer,ProdQuant> prodotti;
	private int totale;
	
	public Carrello() {
		prodotti = new HashMap<Integer,ProdQuant>();
		totale = 0;
	}
	
	public void put(Prodotto prodotto, int quantita) {
		totale += prodotto.getPrezzoCent()*quantita;
		this.prodotti.put(prodotto.getId(), new ProdQuant(prodotto, quantita));
	}
	
	public void remove(Prodotto prodotto) {
		this.totale -= prodotto.getPrezzoCent()*this.prodotti.get(prodotto.getId()).getQuantita();
		this.prodotti.remove(prodotto.getId());
	}
	
	public Collection<ProdQuant> getProdotti() {
		return prodotti.values();
	}
	
	public int getTotale() { return this.totale;}
	

}
