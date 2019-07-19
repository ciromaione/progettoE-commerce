package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class LoginCarrelloServlet
 */
@WebServlet("/LoginCarrello")
public class LoginCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		String messaggioCarrello;
		int errorCode=0;
		
		UtenteDAO ud = new UtenteDAO();
		Utente u = ud.doRetriveByEmail(email);
		if (u == null) {
			messaggioCarrello = "Email non corretta!";
			errorCode = 1;
		}
		else if (u.getPass().equals(pass)) {
			request.getSession().setAttribute("utente", u);
			request.getSession().setAttribute("type", "utente");
			messaggioCarrello = "Login effettuato!";
		}
		else {
			messaggioCarrello = "Password non corretta!";
			errorCode = 1;
		}
		
		request.setAttribute("messaggioCarrello", messaggioCarrello);
		request.setAttribute("errorCode", errorCode);
		
		request.getRequestDispatcher("view/html-jsp/carrello.jsp").forward(request, response);
		
	}

}
