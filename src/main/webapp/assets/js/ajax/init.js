$(function initData() {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/sign_in",
        dataType: "json",
        async: false,
        success: function (msg) {
            // alert(msg.message);
            if (msg.message === "登陆成功") {
                document.getElementById("sign-up&sign-in").style.display = "none";
                document.getElementById("user-name-label").innerText = msg.username;
                document.getElementById("user-name-space").style.display = "inline";
                $('#login').modal('hide');
            }
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    });
})