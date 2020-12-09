$(function() {
    $("#quit").click(function(msg) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/quit",
            dataType: "json",
            async: false,
            success: function(msg) {
                swal({
                    title: msg.message,
                    type: 'success',
                    timer: 1000
                });
            },
            error: function(xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    })
    $("#quit2").click(function(msg) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/quit",
            dataType: "json",
            async: false,
            success: function(msg) {
                swal({
                    title: msg.message,
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