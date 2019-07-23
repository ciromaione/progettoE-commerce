$(document).ready(function (){
    $('#check').click(function (){
        if($('#check').is(':checked')) $('.pagamento').fadeOut();
        else $('.pagamento').fadeIn();
    });

    
    $('#formAcq').submit(function (){

        var res = true;
        if(!$('#check').is(':checked')){
            if(!testNcarta($('#ncarta'))){
                res = false;
                $('#errncarta').show();
                $('#ncarta').addClass("errclass");
            }
            else{
                $('#errncarta').hide();
                $('#ncarta').removeClass("errclass");
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


function testNcarta(el) {
    var exp = /^[0-9]{16}$/;
    if(exp.test(el.val())) return true;
    return false;
}
function testScad(el) {
    var exp = /^(0[1-9]|1[0-2])\/[0-9]{2}$/;
    if(exp.test(el.val())) return true;
    return false;
}
function testCvv(el) {
    var exp =/^[0-9]{3}$/;
    if(exp.test(el.val())) return true;
    return false;
}