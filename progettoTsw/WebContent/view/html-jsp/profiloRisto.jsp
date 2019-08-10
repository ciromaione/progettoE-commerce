<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*" %>
    <%@ page import="java.util.ArrayList" %>
    
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
    
    <%
    String ilTuoMenu = (String) request.getAttribute("ilTuoMenu");
    if(ilTuoMenu==null){
    %>
    <style>
        .menu-piatti{display: none;}
    </style>
    
    <%
    } else {
    %>
    <style>
        #dati{display: none;}
    </style>
    <% }%>

</head>
<body>
	
	<%@	include file="header.html" %>
	
	<section class="navigator">
        <div>
            <ul>
                <li><a class="nav-item <%if(ilTuoMenu == null) {%>active<%} %>" id="1">I tuoi dati</a></li> |
                <li><a class="nav-item <%if(ilTuoMenu != null) {%>active<%} %>" id="2">Il tuo menù</a></li> |
                <li><a href="Logout" class="nav-item">Logout</a></li>
            </ul>
        </div>
    </section>
	
    <section class="contenuto">
    	
    	<section id="dati">
	    	<%
	    	Ristorante risto = (Ristorante) request.getSession().getAttribute("ristorante");
	    	%>
	    	<strong>Nome</strong><%="  "+risto.getNome() %><br><br>
	    	<strong>Email</strong><%="  "+risto.getEmail() %><br><br>
	    	<strong>Città</strong><%="  "+risto.getCitta() %><br><br>
	    	<strong>Indirizzo</strong><%="  "+risto.getIndirizzo() %><br><br>
            <strong>Telefono</strong><%="  "+risto.getTelefono() %><br><br>
            <strong>Ora di apertura</strong><%="  "+risto.getOraAp() %><br><br>
            <strong>Ora di chiusura</strong><%="  "+risto.getOraCh() %><br><br>
        </section>
        
        <section class="menu-piatti">
            <%
            ProdottoDAO pd = new ProdottoDAO();
            ArrayList<Prodotto> menu = pd.doRetriveMenu(risto.getId());
            for(Prodotto prod:menu){
            %>
            <div class="piatto clearfix">
	            <div class="testo-piatto">
	                <h4><%= prod.getNome() %></h4>
	            </div>
	            <div class="azioni-piatto">
	                <form action="AddRemToMenu" method="GET">
	                    <%= "€ "+prod.getPrezzoEuro() %> 
	                    <input type="hidden" value="<%= prod.getId() %>" name="id-piatto">
	                    <input type="submit" value="-" class="menus-btn" name="submit">
	                </form>
	            </div>
        	</div>
            <%} %>
        </section>
        <section class="menu-piatti">
            <h2>Aggiungi Piatto</h2>
            <form action="AddRemToMenu" method="POST" id="addForm">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" class="input-text" required maxlength="50">
                <label for="desc">Descrizione</label>
                <textarea name="desc" id="desc" rows="5" style="width: 100%"></textarea>
                <label for="cat">Categoria</label>
                <select name="cat" id="cat" class="input-text">
                    <%
                    ArrayList<Categoria> cat = CategoriaDAO.doRetriveAll();
                    for(Categoria c:cat){
                    %>
                    <option value="<%= c.getId()%>"><%= c.getNome()%></option>
                    <% }%>
                </select>
                <label for="prezzo">Prezzo</label>
                <input type="text" name="prezzo" id="prezzo" class="input-text" placeholder="00,00">
                <div class="errPrezzo">Formato prezzo non valido!</div>
                <input type="hidden" name="idRisto" value="<%= risto.getId() %>">
                <input type="submit" value="Aggiungi" class="submit" name="submit">
            </form>
        </section>

    </section>
    
    <%@ include file="footer.html" %>
    
    <script>
        $(document).ready(function (){

            $('.nav-item').click(function (){
                $('.active').removeClass("active");
                $(this).addClass("active");
            });
            $('#1').click(function (){
                $('.menu-piatti').fadeOut();
                $('#dati').fadeIn();
                window.scrollTo(0,0);
            });
            $('#2').click(function (){
                $('#dati').fadeOut();
                $('.menu-piatti').fadeIn();
                window.scrollTo(0,0);
            });

            $('#addForm').submit(function (){
                if(!testPrezzo()){
                    $('#prezzo').css("border-color", "red");
                    $('.errPrezzo').show();
                    return false;
                }
                return true;
            });

        });

        function testPrezzo(){
            var exp = /^[1-9][0-9]*(,|\.)[0-9]{2}$/;
            if(exp.test($('#prezzo').val())) return true;
            return false;
        }
    </script>
    
</body>
</html>