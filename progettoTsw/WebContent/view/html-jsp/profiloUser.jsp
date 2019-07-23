<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Utente" %>
    <%@ page import="java.util.TreeSet" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profilo</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Henny+Penny&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="view/css/style.css">
    <link rel="stylesheet" href="view/css/style-pro.css">
</head>
<body>
	
	<%@	include file="header.html" %>
	
	<section class="navigator">
        <div>
            <ul>
            	<li><a class="nav-item active">I tuoi dati</a></li> |
                <li><a href="Logout" class="nav-item">Logout</a></li>
            </ul>
        </div>
    </section>
	
    <section class="contenuto">
    	
    	<section id="dati">
	    	<%
	    	Utente utente = (Utente) request.getSession().getAttribute("utente");
	    	%>
	    	<strong>Nome</strong><%="  "+utente.getNome() %><br><br>
	    	<strong>Email</strong><%="  "+utente.getEmail() %><br><br>
	    	<strong>Città</strong><%="  "+utente.getCitta() %><br><br>
	    	<strong>Indirizzo</strong><%="  "+utente.getIndirizzo() %><br><br>
	    	<strong>Telefono</strong><%="  "+utente.getTelefono() %><br><br>
    	</section>

    </section>
    
    <%@ include file="footer.html" %>

</body>
</html>