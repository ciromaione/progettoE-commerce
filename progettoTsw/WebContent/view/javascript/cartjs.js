$(document).ready(function (){
    $('#check').click(function (){
        if($('#check').is(':checked')) $('.pagamento').fadeOut();
        else $('.pagamento').fadeIn();
    });

    
    $('.acquista-btn').click(function (){

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