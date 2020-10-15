$(function () {
    $("#delete-account").click(function (message) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/user_delete",
            async: false,
            dataType: "json",
            success: function (msg) {
                alert(msg.message);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
    })
})
