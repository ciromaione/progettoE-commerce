package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.Prodotto;
import model.ProdottoDAO;
import model.Ristorante;
import model.RistoranteDAO;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddRemToCart")
public class AddRemToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProd = Integer.parseInt(request.getParameter("id-piatto"));
		String quantity = request.getParameter("quantity");
		
		
		
		ProdottoDAO pd = new ProdottoDAO();
		Prodotto p = pd.doRetriveById(idProd);
		
		Carrello cart = (Carrello) request.getSession().getAttribute("cart");
		
		if(quantity == null) {
			cart.remove(p);
			if(cart.getProdotti().isEmpty()) request.getSession().removeAttribute("cart");
			else request.getSession().setAttribute("cart", cart);
	
			request.getRequestDispatcher("Carrello").forward(request, response);
		}
		else {
			
			if(cart == null)
				cart = new Carrello();
			
			cart.put(p, Integer.parseInt(quantity));
			
			request.getSession().setAttribute("cart", cart);
			
			
			request.getRequestDispatcher("Ristorante?id="+p.getIdRisto()).forward(request, response);
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
