<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="model.Prodotto" %>
    <%@ page import="model.Carrello" %>
    <%@ page import="model.Carrello.ProdQuant" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carrello</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Henny+Penny&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="view/css/style.css">
    <link rel="stylesheet" href="view/css/style-cart.css">
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


    <section class="content clearfix">
        <div class="left-content">
        	<%
        	String msg = (String) request.getAttribute("messaggioCarrello");
        	int err = (int) request.getAttribute("errorCode");
        	if(err != 0) {
        	%>
        	<h2 class="textErr"><%= msg %></h2>
        	<%
        	}
        	if(err == 1) {
        	%>
            <div class="login">
                <form action="">
                    <h2>Login</h2><hr>
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" class="input-text">
                    <label for="pass">Password</label>
                    <input type="password" name="pass" id="pass" class="input-text">
                    <button class="login-btn">Accedi</button>
                </form>
            </div>
            <%} %>
        </div>
        <div class="right-content">
        	<%
        	Carrello cart = (Carrello) request.getSession().getAttribute("cart");
            if(cart == null) {
        	%>
        	<h2>Nessun Prodotto nel Carrello!</h2>
        	<%
        	}
            else {
            %>
            <div class="prod-list">
                <h2>Prodotti</h2>
                <%
                ArrayList<ProdQuant> prodotti = new ArrayList<ProdQuant>(cart.getProdotti());
                for(ProdQuant pq:prodotti){
                	Prodotto p = pq.getProdotto();
                	int q = pq.getQuantita();
                %>
                <div class="prodotto">
                   <%= "x"+q+" "+p.getNome()+" € "+p.getPrezzoEuro() %> 
                   <form action="AddRemToCart" method="get">
                   		<input type="hidden" name="id-piatto" value="<%= p.getId() %>">
                   		<input type="submit" value="-" class="btn-rimuovi">
                   </form>
                </div>
                <%} %>
                <h5>Totale € <%= cart.getTotale() %></h5>
                <input type="checkbox" id="check">Pagamento alla consegna<br>
                <div class="pagamento">
                	<h3>Carta di Credito</h3><hr>
                   	<label for="ncarta">Numero Carta</label>
                    <input type="text" name="ncarta" id="ncarta" class="input-text">
                    <label for="scad">Scadenza</label>
                    <input type="text" name="scad" id="scad" class="input-text" placeholder="mm/aa">
                    <label for="cvv">CVV</label>
                    <input type="text" name="cvv" id="cvv" class="input-text">
                </div>            
                        
                <a href="Acquista"><button class="acquista-btn">Acquista</button></a>
            </div>
			<%} %>
            
        </div>
    </section>



    <footer>
        <p>© 2019 Copyright: <a href>Ristogram.com</a></p>
    </footer>


    <script src="view/javascript/jquery.js"></script>
    <script src="view/javascript/cartjs.js"></script>
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