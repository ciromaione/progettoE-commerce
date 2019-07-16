package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.ProdottoDAO;
import model.Ristorante;
import model.RistoranteDAO;

/**
 * Servlet implementation class RistoranteServlet
 */
@WebServlet("/Ristorante")
public class RistoranteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idRisto = Integer.parseInt(request.getParameter("id"));
		RistoranteDAO rd = new RistoranteDAO();
		Ristorante r = rd.doRetriveById(idRisto);
		
		request.setAttribute("ristorante", r);
		
		ProdottoDAO pd = new ProdottoDAO();
		ArrayList<Prodotto> menu = pd.doRetriveMenu(r.getId());
		menu.sort((x,y) -> x.getIdCat()-y.getIdCat());
		
		request.setAttribute("menu", menu);
		
		request.getRequestDispatcher("view/html-jsp/ristorante.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
