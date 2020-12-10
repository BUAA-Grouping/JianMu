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
        let currentTab = getCurrentTabIndex();
        let $realname, $schoolID, type;
        type = currentTab;
        if (currentTab === 0) {
            $realname = $("#student-real-name").val();
            $schoolID = $("#student-id").val();
        } else {
            $realname = $("#teacher-real-name").val();
            $schoolID = $("#teacher-id").val();
        }
        let $emailID = $("#email-id").val();
        let $password = $("#set-password").val();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/sign_up",
            data: {
                "realname": $realname,
                "schoolID": $schoolID,
                "emailID": $emailID,
                "password": $password,
                "type": type
            },
            dataType: "json",
            async: false,
            success: function (msg) {
                if (msg.message === "注册成功") {
                    document.getElementById("sign-up&sign-in").style.display = "none";
                    document.getElementById("user-name-label").innerText = $realname;
                    document.getElementById("user-name-space").style.display = "inline";
                    $('#signup').modal('hide');
                    location.reload();
                    swal({
                        title: msg.message,
                        text: "Success!",
                        type: 'success',
                        timer: 1000
                    });
                } else {
                    swal(msg.message, "Error!", 'error');
                }
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
        // console.log("submit");
    })
})

function getCurrentTabIndex() {
    if ($("#student-info-tab").hasClass('active')) {
        return 0;
    } else {
        return 1;
    }
}