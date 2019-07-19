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
    
    <%@ include file="header.html" %>


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
                <h5>Totale € <%= cart.getTotaleEuro() %></h5>
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


	<%@ include file="footer.html" %>
    
    <script src="view/javascript/cartjs.js"></script>
    

</body>
</html>