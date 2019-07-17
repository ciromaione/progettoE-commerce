package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.Carrello.ProdQuant;
import model.Ordine;
import model.OrdineDAO;
import model.ProdottoXOrdine;
import model.ProdottoXOrdineDAO;
import model.Utente;

/**
 * Servlet implementation class AcquistaServlet
 */
@WebServlet("/Acquista")
public class AcquistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente user = (Utente) request.getSession().getAttribute("utente");
		
		if(user != null) {
		
			Carrello cart = (Carrello) request.getSession().getAttribute("cart");
			ArrayList<ProdQuant> prodotti = new ArrayList<ProdQuant>(cart.getProdotti());
			
			Ordine o = new Ordine();
			OrdineDAO od = new OrdineDAO();
			
			int id = 1+od.doRetriveLastId();
			
			o.setId(id);
			o.setIdUtente(user.getId());
			o.setDataAcq(new Date(new java.util.Date().getTime()));
			o.setTotale(cart.getTotale());
			
			od.doSave(o);
			
			ProdottoXOrdineDAO pod = new ProdottoXOrdineDAO();
			for(ProdQuant pq:prodotti) {
				ProdottoXOrdine po = new ProdottoXOrdine();
				po.setIdOrdine(o.getId());
				po.setIdProd(pq.getProdotto().getId());
				po.setQuantita(pq.getQuantita());
				pod.doSave(po);
			}
			
			
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
