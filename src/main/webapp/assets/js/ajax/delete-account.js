$(function () {
    //监听提交按钮的点击
    $("#delete-account").click(function (message) {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/user_delete",
            async: false,
            success: function (msg) {
                alert(msg.message);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
    })
})
