
$(document).ready(function (){

    $('#risto-radio').click(function (){
      $('.ristonly').show();
      $('.usronly').hide();
    });
    $('#user-radio').click(function (){
      $('.ristonly').hide();
      $('.usronly').show();
    });

    
    $('#reg-form').submit(function (){
      var res = true;
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
      if($('#risto-radio').is(':checked')){
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
      if($('#user-radio').is(':checked')){
        if(!testNcarta($('#ncar'))){
          res = false;
          $('#errncar').show();
          $('#ncar').addClass("errclass");
        }
        else{
          $('#errncar').hide();
          $('#ncar').removeClass("errclass");
        }
        if(!testScad($('#scad'))){
          res = false;
          $('#errscad').show();
          $('#scad').addClass("errclass");
        }
        else{
          $('#errscad').hide();
          $('#scad').removeClass("errclass");
        }
        if(!testCvv($('#cvv'))){
          res = false;
          $('#errcvv').show();
          $('#cvv').addClass("errclass");
        }
        else{
          $('#errcvv').hide();
          $('#cvv').removeClass("errclass");
        }
      }
      return res;
    });

});

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
  function testNcarta(el){
    var exp = /^[0-9]{16}$/;
    if(exp.test(el.val())) return true;
    return false;
  }
  function testScad(el){
    var exp = /^(0[1-9]|1[0-2])\/[0-9]{2}$/;
    if(exp.test(el.val())) return true;
    return false;
  }
  function testCvv(el){
    var exp =/^[0-9]{3}$/;
    if(exp.test(el.val())) return true;
    return false;
  }