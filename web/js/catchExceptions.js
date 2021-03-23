
function teste() {

    var valorRecebido = $('#testee').val();

    $.ajax({
        method: "POST",
        url: "catchException",
        data: {valor: valorRecebido}
    })
            .done(function (response) {
                alert(response);
        
            })
            .fail(function (xhr, status, errorThrown) {
                alert(xhr.responseText);
        
            });
}


