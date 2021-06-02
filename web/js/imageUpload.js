
function uploadImage() {

    var target = document.querySelector("img");
    var file = document.querySelector("input[type=file]").files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        target.src = reader.result;

        //Codigo ajax para o upload de imagem
        $.ajax({
            method: "POST",
            url: "fileUpload",
            data: {fileUpload: target.src}
        })
                .done(function (response) {
                    alert(" " + response);

                })
                .fail(function (xhr, status, errorThrown) {
                    alert("Erro: " + xhr.responseText);

                });
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        target.src = "";
    }
}


