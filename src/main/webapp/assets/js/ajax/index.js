$(function () {
    //监听内容的实时输入
    $("body").delegate(":password", "propertychange input", function () {
        //判断是否输入了内容
        if ($(this).val().length > 0) {
            //让按钮可用
            $("#login-submit").prop("disabled", false);
        } else {
            $("#login-submit").prop("disabled", true);
            //让按钮不可用
        }
    });
    //监听提交按钮的点击
    $("#login-submit").click(function () {
        var $username = $("#emailID").val();
        var $password = $(":password").val();
        // alert("username: " + $username + ", password: " + $password);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/sign_in",
            data: {"name": "$username", "password": "$password"},
            dataType: "json",
            async:false,
            success: function (msg) {
                var object = JSON.parse(msg);
                alert(object.message);
                // alert("username: " + $username + ", password: " + $password);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
        // console.log("submit");
    })
})