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

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddProdToCart")
public class AddProdToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idProd = Integer.parseInt(request.getParameter("id-piatto"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Carrello cart = (Carrello) request.getSession().getAttribute("cart");
		if(cart == null)
			cart = new Carrello();
		
		ProdottoDAO pd = new ProdottoDAO();
		Prodotto p = pd.doRetriveById(idProd);
		
		cart.put(p, quantity);
		
		request.getSession().setAttribute("cart", cart);
		
		request.getRequestDispatcher("view/html-jsp/ristorante.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
