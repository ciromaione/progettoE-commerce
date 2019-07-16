<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Accedi</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link href="https://fonts.googleapis.com/css?family=Henny+Penny&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="view/css/style-reg.css">
   	<%if(request.getAttribute("errmsg") != null) {%>
   	<style type="text/css">
   		#err{ display: block;}
   	</style>
   	<%} %>
</head>
<body>

    <header class="header">
        <a href="." class="logo">Ristogram</a>
    </header>

    <section>
        <form action="Login" method="post" id="login-form">
          <div class="container">
            <h2>Benvenuto!</h2>
            <hr>
            <input type="radio" name="type" id="user-radio" value="utente" checked>
            <label for="user-radio">Utente</label>
            <input type="radio" name="type" id="risto-radio" value="ristorante">
            <label for="risto-radio">Ristorante</label><br>
            <label for="email">Email</label>
            <input type="email" name="email" id="email" class="input-text" required>
            <label for="pass">Password</label>
            <input type="password" name="pass" id="pass" class="input-text" required>
            <span id="err"><%=request.getAttribute("errmsg") %></span>
            <hr>
            <input type="submit" value="Registrati" class="input-text btn">
            <label>Non sei registrato? <a href="Registrati">Registrati</a></label>
          </div>


        </form>
    </section>
    
    
</body>
</html>