$(function () {
    //监听提交按钮的点击
    $("#delete-account").click(function (message) {
        var $emailID = $("#emailID").val();
        var $password = $("#putin-password").val();

        // alert("username: " + $emailID + ", password: " + $password);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/sign_in",
            data: {"emailID": $emailID, "password": $password},
            dataType: "json",
            async: false,
            success: function (msg) {
                alert(msg.message);
                if (msg.message === "登陆成功") {
                    document.getElementById("sign-up&sign-in").style.display = "none";
                    document.getElementById("user-name-label").innerText = msg.username;
                    document.getElementById("user-name-space").style.display = "inline";
                    $('#login').modal('hide');
                }
                // alert("username: " + $username + ", password: " + $password);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
        // console.log("submit");
    })
})
