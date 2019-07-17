$(document).ready(function (){
    $('#check').click(function (){
        if($('#check').is(':checked')) $('.pagamento').fadeOut();
        else $('.pagamento').fadeIn();
    });

    $('.login-btn').click(function (){
        $.get("LoginCarrello?email="+$('#email').val()+"&pass="+$('#pass').val(),function (data, status) {
           
            if(data == "ok") {
                $('.textErr').text("Login Effettuato!");
                $('.login').fadeOut();
            }
            else
                $('.textErr').text("Email o Password errata!");
          });
    });
});