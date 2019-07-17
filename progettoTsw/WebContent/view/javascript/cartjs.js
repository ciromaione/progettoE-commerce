$(document).ready(function (){
    $('#check').click(function (){
        if($('#check').is(':checked')) $('.pagamento').fadeOut();
        else $('.pagamento').fadeIn();
    });
});