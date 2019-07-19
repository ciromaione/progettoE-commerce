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

    <%@ include file="header.html" %>
    
    

    <section class="carousel">
        <!-- Slideshow container -->
        <div class="slideshow-container">
        
            <%
            Ristorante r = (Ristorante) request.getAttribute("ristorante");
            String [] foto = r.getFoto();
            
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
	
	<section class="desc">
		<h4><%= r.getCitta()+", "+r.getIndirizzo()+", Tel. "+r.getTelefono() %></h4>
		<h5><%= "aperto dalle "+r.getOraAp()+" alle "+r.getOraCh() %></h5>
	</section>

    <section class="menu-prodotti">
    	<%
    	ArrayList<Prodotto> menu = (ArrayList<Prodotto>) request.getAttribute("menu");
    	int lastIdCat = -1;
    	String lastCat = null;
    	for(Prodotto prod:menu){
    		if(prod.getIdCat() != lastIdCat) {
    			lastIdCat = prod.getIdCat();
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
                    <%= "€ "+prod.getPrezzoEuro() %> 
                    <input type="hidden" value="<%= prod.getId() %>" name="id-piatto">
                    <input type="number" name="quantity" class="quantity" value="1" min="1" max="10">
                    <input type="submit" value="+" class="plus-btn">
                </form>
            </div>
        </div>
        <%} %>

    </section>


	<%@ include file="footer.html" %>

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