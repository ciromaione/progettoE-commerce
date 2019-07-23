<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Ristorante" %>
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
    <link rel="stylesheet" href="view/css/style-ricerca.css">
</head>
<body>
   
    <%@ include file="header.html" %>
    
    
    <div class="searchbar">
    	<form action="Ricerca" method="get" id="formRicerca">
	        <input type="text" id="sb-text" name="sb-text" placeholder="ricerca un piatto un luogo o un ristorante">
	        <input type="submit" id="sb-btn" class="btn" value="Cerca">
         </form>
         <button id="cercaBTN" class="btn">Cerca</button>
    </div>

    <section class="container">
    
    	<%
			ArrayList<Ristorante> ristoranti = (ArrayList<Ristorante>) request.getAttribute("ristoranti");
    		if(ristoranti == null){
    	%>
    	<h2>Nessun risultato trovato!</h2>
    	<%
    		} else for(Ristorante risto:ristoranti) {
		%>
        <div class="result-item">
            <a class="item-link" href="Ristorante?id=<%= risto.getId()%>">
                <div class="img-item" style="background-image: url('view/imgRisto/<%= risto.getFoto()[0]%>')"></div>
                <h4><%= risto.getNome() %></h4>
                <h6><%= risto.getCitta()+", "+risto.getIndirizzo() %></h6>
            </a>
        </div>
        <%} %>
        
        
            
    </section>

    <%@ include file="footer.html" %>

    <script>
        $('#cercaBTN').click(function (e){
                openNav();
                e.preventDefault();
        });
    </script>
</body>
</html>