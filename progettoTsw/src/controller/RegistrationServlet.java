package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import model.FotoIndexPool;
import model.Ristorante;
import model.RistoranteDAO;
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registrazione")
@MultipartConfig
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
		
		
	}


	private Ristorante createRisto(HttpServletRequest request) throws IOException, ServletException {
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
			
			List<Part> fileParts = request.getParts().stream().filter(part -> "filein".equals(part.getName())).collect(Collectors.toList()); 
			int imgIndex = FotoIndexPool.getLastFotoIndex();
			if(imgIndex == -1) throw new RuntimeException();
			++imgIndex;
			String [] foto = new String[fileParts.size()];
			
			int i = 0;
		    for (Part filePart : fileParts) {
		    	
		        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		        int index = fileName.lastIndexOf('.');
				String ext;
				if(index == -1) ext = ".png";
				else ext = fileName.substring(index+1);
				
				InputStream initialStream = filePart.getInputStream();
				
				String path = getServletContext().getRealPath("view");
				String newFileName = imgIndex+"."+ext;
				++imgIndex;
				
				File targetFile = new File(path+"/imgRisto/"+newFileName);
				
				foto[i++] = newFileName;
				
			    java.nio.file.Files.copy(
			      initialStream, 
			      targetFile.toPath(), 
			      StandardCopyOption.REPLACE_EXISTING);
			 
			    IOUtils.closeQuietly(initialStream);
		    }
			
			r.setFoto(foto);
		}
		catch(RuntimeException e) {
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
		}
		catch(RuntimeException e) {
			return null;
		}
		return u;
	}

}
