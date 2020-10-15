$(function () {
    //监听内容的实时输入
    $("body").delegate("#set-password", "propertychange input", function () {
        //判断是否输入了内容
        if ($(this).val().length > 0) {
            //让按钮可用
            $("#signup-submit").prop("disabled", false);
        } else {
            $("#signup-submit").prop("disabled", true);
            //让按钮不可用
        }
    });
    //监听提交按钮的点击
    $("#signup-submit").click(function () {
        let $realname = $("#real-name").val();
        let $schoolID = $("#school-id").val();
        let $emailID = $("#email-id").val();
        let $password = $("#set-password").val();
        // alert("username: " + $username + ", password: " + $password);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/sign_up",
            data: {
                "realname": $realname,
                "schoolID": $schoolID,
                "emailID": $emailID,
                "password": $password
            },
            dataType: "json",
            async: false,
            success: function (msg) {
                alert(msg.message);
                if (msg.message === "注册成功") {
                    document.getElementById("sign-up&sign-in").style.display = "none";
                    document.getElementById("user-name-label").innerText = $realname;
                    document.getElementById("user-name-space").style.display = "inline";
                    $('#signup').modal('hide');
                }
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
        // console.log("submit");
    })
})