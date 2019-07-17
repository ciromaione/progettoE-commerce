<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Ristorante" %>
    <%@ page import="model.Prodotto" %>
    <%@ page import="model.CategoriaDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ristorante</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Henny+Penny&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="view/css/style.css">
    <link rel="stylesheet" href="view/css/style-risto.css">
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

    <section class="carousel">
        <!-- Slideshow container -->
        <div class="slideshow-container">
        
            <%
            Ristorante r = (Ristorante) request.getParameter("ristorante");
            String foto = r.getFoto();
            
            for(String f:foto){
             %>
            <div class="mySlides fade img" style="background-image: url('view/imgRisto/<%= f%>')">
                <div class="filter"></div>
                <div class="text"><%= r.getNome() %></div>
            </div>
            <%} %>
        
        
            <!-- Next and previous buttons -->
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
        </div>
        <br>
    </section>


    <section class="menu-prodotti">
    	<%
    	ArrayList<Prodotto> menu = (ArrayList<Prodotto>)request.getAttribute("menu");
    	int lastIdCat;
    	String lastCat = null;
    	for(Prodotto prod:menu){
    		if(prod.getIdCat() != lastIdCat) {
    			lastIdCat = prod.getIdCAt();
    			lastCat = CategoriaDAO.doRetriveById(lastIdCat);
    			%>
    			<h2><%= lastCat %></h2>
    	<%
    		}
    	%>
        <div class="piatto clearfix">
            <div class="testo-piatto">
                <h4><%= prod.getNome() %></h4>
                <p><%= prod.getDescrizione() %></p>
            </div>
            <div class="azioni-piatto">
                <form action="AddRemToCart" method="GET">
                    € <%= prod.getPrezzoEuro() %> 
                    <input type="hidden" value="<%= prod.getId() prod. %>" name="id-piatto">
                    <input type="number" name="quantity" class="quantity" value="1" min="1" max="10">
                    <input type="submit" value="+" class="plus-btn">
                </form>
            </div>
        </div>
        <%} %>

    </section>


	<footer>
        <p>© 2019 Copyright: <a href>Ristogram.com</a></p>
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
    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        // Next/previous controls
        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        // Thumbnail image controls
        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {slideIndex = 1} 
            if (n < 1) {slideIndex = slides.length}
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none"; 
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex-1].style.display = "block"; 
            dots[slideIndex-1].className += " active";
        }
    </script>

</body>
</html>