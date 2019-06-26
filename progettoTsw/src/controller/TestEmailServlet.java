package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ristorante;
import model.RistoranteDAO;
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class TestEmailServlet
 */
@WebServlet("/TestEmail")
public class TestEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		System.out.println("**\n\n"+email+"\n"+type+"\n\n*\n");
		if(type.equals("utente")) {
			UtenteDAO ud = new UtenteDAO();
			Utente u = ud.doRetriveByEmail(email);
			if (u == null) response.getWriter().append("ok");
			else response.getWriter().append("no");
		}
		else {
			RistoranteDAO rd = new RistoranteDAO();
			Ristorante r = rd.doRetriveByEmail(email);
			if (r == null) response.getWriter().append("ok");
			else response.getWriter().append("no");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
