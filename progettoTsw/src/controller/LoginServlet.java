package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String type = request.getParameter("type");
		
		if(type.equals("utente")) {
			UtenteDAO ud = new UtenteDAO();
			Utente u = ud.doRetriveByEmail(email);
			if (u == null) returnWError(request, response, "Email non corretta!");
			else if (u.getPass().equals(pass)) {
				request.getSession().setAttribute("utente", u);
				request.getSession().setAttribute("type", type);
				response.sendRedirect("Profilo");
			}
			else returnWError(request, response, "Password non corretta!");
		}
		else {
			RistoranteDAO rd = new RistoranteDAO();
			Ristorante r = rd.doRetriveByEmail(email);
			if (r == null) returnWError(request, response, "Email non corretta!");
			else if (r.getPass().equals(pass)) {
				request.getSession().setAttribute("ristorante", r);
				request.getSession().setAttribute("type", type);
				response.sendRedirect("Profilo");
			}
			else returnWError(request, response, "Password non corretta!");
		}
		
	}
	
	private void returnWError(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
		request.setAttribute("errmsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("view/html-jsp/login.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
