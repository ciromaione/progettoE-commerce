package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarrelloServlet
 */
@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = (String) request.getSession().getAttribute("type");
		String messaggioCarrello = null;
		int errorCode = 0;
		if(type == null) {
			messaggioCarrello = "Effettua il login per completare l'acquisto!";
			errorCode = 1;
		}
		else if(type == "ristorante") {
			messaggioCarrello = "Stai usando un account 'Ristorante', accedi come 'Utente' per completare l'acquisto!";
			errorCode = 2;
		}
		if(messaggioCarrello != null)
			request.setAttribute("messaggioCarrello", messaggioCarrello);
		request.setAttribute("errorCode", errorCode);
		
		request.getRequestDispatcher("view/html-jsp/carrello.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
