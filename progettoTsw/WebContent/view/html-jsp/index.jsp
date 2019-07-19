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
    <title>Ristogram</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Henny+Penny&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="view/css/style.css">
    <link rel="stylesheet" href="view/css/style-index.css">
</head>
<body>
	
	<%@ include file="header.html" %>
	
	<section class="carousel">
        <!-- Slideshow container -->
        <div class="slideshow-container">

            <div class="mySlides fade img" style="background-image: url('view/img/imgCarousel1.jpg')">
                <div class="filter"></div>
                <div class="text">Caption Text</div>
            </div>

            <div class="mySlides fade img" style="background-image: url('view/img/imgCarousel2.jpg')">
                <div class="filter"></div>
                <div class="text">Caption Text</div>
            </div>

            <div class="mySlides fade img" style="background-image: url('view/img/imgCarousel3.jpg')">
                <div class="filter"></div>
                <div class="text">Caption Text</div>
            </div>
            
        </div>
        <br>
        <div style="text-align:center">
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		</div>
    </section>

    <section class="ristoranti">
    	<h1>I ristoranti più quotati</h1>
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
        var slideIndex = 0;
        showSlides();

        function showSlides() {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";  
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}    
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";  
        dots[slideIndex-1].className += " active";
        setTimeout(showSlides, 4000); // Change image every 2 seconds
        }
	</script>
	<%
	if(request.getAttribute("acquistoEffettuato") != null){
	%>
	<script>
		$(document).ready(function (){
			alert("Acquisto completato con successo!");
		});
	</script>
	<%} %>

</body>
</html>