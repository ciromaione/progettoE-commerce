
$(document).ready(function (){
    $('#risto-radio').click(function (){
      $("label[for='nome']").text("Nome del tuo ristorante");
      $('.ristonly').show();
    });
    $('#user-radio').click(function (){
      $("label[for='nome']").text("Nome e Cognome");
      $('.ristonly').hide();
    });

    
    $('#reg-form').submit(function (){
      var res = true;
      var type = "utente";
      if($('#risto-radio').is(':checked')) type = "ristorante";
      if(!testEmail(type)){
        res = false;
        $('#erremail').show();
        $('#email').addClass("errclass");
      }
      if(!testPass()){
        res = false;
        $('#errpass').show();
        $('#pass').addClass("errclass");
      }
      else{
        $('#errpass').hide();
        $('#pass').removeClass("errclass");
      }
      if(!testTel($('#telefono'))){
        res = false;
        $('#errtel').show();
        $('#telefono').addClass("errclass");
      }
      else{
        $('#errtel').hide();
        $('#telefono').removeClass("errclass");
      }
      if(type == "ristorante"){
        if(!testOra($('#oraap'))){
          res = false;
          $('#erroraap').show();
          $('#oraap').addClass("errclass");
        }
        else{
          $('#erroraap').hide();
          $('#oraap').removeClass("errclass");
        }
        if(!testOra($('#orach'))){
          res = false;
          $('#errorach').show();
          $('#orach').addClass("errclass");
        }
        else{
          $('#errorach').hide();
          $('#orach').addClass("errclass");
        }
      }
      
      return res;
    });

});

  function testEmail(type){
    $.get("TestEmail?email="+$('#email').val()+"&type="+type,function (data, status) {
      if(data == "ok") return true;
      return false;
    });
  }
  function testPass(){
    var str = document.getElementById("pass").value;
    if(str.length >= 8) return true;
    return false;
  }
  function testTel(el){
    var exp = /^[0-9]{10}$/
    if(exp.test(el.val())) return true;
    return false;
  }
  function testOra(el){
    var exp = /^([01][0-9]|2[0-3]):[0-5][0-9]$/;
    if(exp.test(el.val())) return true;
    return false;
  }
  