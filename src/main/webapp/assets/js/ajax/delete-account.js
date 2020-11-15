$(function() {
    $("#delete-account").click(function(message) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/user_delete",
            async: false,
            dataType: "json",
            success: function(msg) {
                swal({
                    title: msg.message,
                    text: "Success!",
                    type: 'success',
                    timer: 1000
                });
            },
            error: function(xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    })
})