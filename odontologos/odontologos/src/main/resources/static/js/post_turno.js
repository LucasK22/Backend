$(document).ready(function() {
    $("#add_new_turno").submit(function(evt) {
        evt.preventDefault();

        let formData = {
            fecha : $("#fecha").val(),
            odontologo : {
                id: $("#odontologo").val()  
            },
            paciente: {
                id: $("#paciente").val()   
            }
        }

        $.ajax({
            url: '/turnos/',
            type: 'POST',
            contentType : "application/json",
            data: JSON.stringify(formData),
            dataType : 'json',
            async: false,
            cache: false,
            success: function (response) {
                let turno = response
                console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno registrado con éxito </div>'
                $("#response").append(successAlert);
                $("#response").css({"display": "block"});

            },
            error: function (response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Ocurrió un error inesperado </strong> </div>'
                $("#response").append(errorAlert);
                $("#response").css({"display": "block"});

            }
        });
    });

    $.ajax({
        type : "GET",
        url : "/pacientes/list",
        success: function(response){
        $.each(response, (i, paciente) => {
            let option = '<option' +
                                        ' value=' + '\"' + paciente.id + '\">' + paciente.nombre +' '+ paciente.apellido +'</option>';
            $('#paciente').append(option);
        });
        },
        error : function(e) {
        alert("Ocurrió un error inesperado");
        console.log("ERROR: ", e);
        }
    });

    $.ajax({
        type : "GET",
        url : "/odontologos/list",
        success: function(response){
        $.each(response, (i, odontologo) => {
            let option = '<option' +
                                        ' value=' + '\"' + odontologo.id + '\">' + odontologo.nombre +' '+ odontologo.apellido +'</option>';
            $('#odontologo').append(option);
        });
        },
        error : function(e) {
        alert("Ocurrió un error inesperado");
        console.log("ERROR: ", e);
        }
    });

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});