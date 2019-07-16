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
    
    <header class="header clearfix">
        <a href="." class="logo">Ristogram</a>
        <a href="" class="icon-menu">
            <span></span>
            <span></span>
            <span></span>
        </a>
        <ul class="menu animate">
            <li class="menu-item"><a href=".">Home</a></li>
            <li class="menu-item"><a href="">Contatti</a></li>
            <li class="menu-item"><a href="Profilo">Profilo</a></li>
            <li class="menu-item menu-item-icon"><a href="" id="search-icon"><img src="view/icons/magnifying-glass.png" alt="ricerca prodotto" height="18px" width="18px"></a></li>
            <li class="menu-item menu-item-icon"><a href=""><img src="view/icons/shopping-cart.png" alt="carrello prodotti" height="18px" width="18px"></a></li>
        </ul>
    </header>

    <div id="myNav" class="overlay">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <div class="overlay-content">
              <form action="Ricerca" method="get" id="search-form">
              	  <select id="sb-citta" class="select-search">
	            	<option value="napoli">Napoli</option>
	            	<option value="salerno">Salerno</option>
	        	  </select>
                  <input type="text" name="sb-text" class="search-input-text" placeholder="ricerca un piatto...">
                  <input type="image" class="search-input-icon" src="view/icons/magnifying-glass.png">
              </form>
        </div>
    </div>

    
    
    <div class="searchbar">
    	<form action="Ricerca" method="get">
	        <select id="sb-citta" class="select" name="sb-citta">
	            <option value="napoli">Napoli</option>
	            <option value="salerno">Salerno</option>
	        </select>
	        <input type="text" id="sb-text" name="sb-text" placeholder="Cerca piatto ...">
	        <input type="submit" id="sb-btn" class="btn" value="Cerca">
	 	</form>
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

    <footer>
        <p>Â© 2019 Copyright: <a href>Ristogram.com</a></p>
    </footer>


    <script src="view/javascript/jquery.js"></script>
    <script>
        $(document).ready(function (){
            $('.icon-menu').click(function (e){
                $('.menu').toggleClass('is-open');
                e.preventDefault();
            });

            $('#search-icon').click(function (e){
                openNav();
                e.preventDefault();
            });
        });
    </script>
    <script>
        function openNav() {
          document.getElementById("myNav").style.height = "100%";
        }
        
        function closeNav() {
          document.getElementById("myNav").style.height = "0%";
        }
    </script>
</body>
</html>