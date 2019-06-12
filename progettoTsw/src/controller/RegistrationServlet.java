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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type-reg");
		if(type.equals("utente")) {
			Utente u = createUser(request);
			if(u == null) goToErrorPage(request, response);
			else {
				UtenteDAO ud = new UtenteDAO();
				try {
					ud.doSave(u);
				}
				catch(RuntimeException e) {
					goToErrorPage(request, response);
				}
			}
		}
		else {
			Ristorante r = createRisto(request);
			if(r == null) goToErrorPage(request, response);
			else {
				RistoranteDAO rd = new RistoranteDAO();
				try {
					rd.doSave(r);
				}
				catch(RuntimeException e) {
					goToErrorPage(request, response);
				}
			}
		}
		
	}


	private void goToErrorPage(HttpServletRequest request, HttpServletResponse response) {
		
		RequestDispatcher rd = request.getRequestDispatcher("errorPage.html");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


	private Ristorante createRisto(HttpServletRequest request) {
		Ristorante r = new Ristorante();
		try {
			r.setNome(request.getParameter("nome"));
			r.setCitta(request.getParameter("citta"));
			r.setIndirizzo(request.getParameter("indirizzo"));
			r.setEmail(request.getParameter("email"));
			r.setPass(request.getParameter("pass"));
			r.setTelefono(request.getParameter("telefono"));
			r.setOraAp(request.getParameter("oraap"));
			r.setOraCh(request.getParameter("orach"));
			r.setFoto(null);
		}
		catch(RuntimeException e) {
			System.out.print("Eccezzioni: \n\n"+e);
			return null;
		}
		return r;
	}


	private Utente createUser(HttpServletRequest request) {
		Utente u = new Utente();
		try {
			u.setNome(request.getParameter("nome"));
			u.setCitta(request.getParameter("citta"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setEmail(request.getParameter("email"));
			u.setPass(request.getParameter("pass"));
			u.setTelefono(request.getParameter("telefono"));
			u.setnCarta(request.getParameter("ncar"));
			u.setScadCarta(request.getParameter("scad"));
			u.setCvv(request.getParameter("cvv"));
		}
		catch(RuntimeException e) {
			System.out.println(e);
			return null;
		}
		return u;
	}

}
