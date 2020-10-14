$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/user_modify",
        dataType: "json",
        async: false,
        success: function (msg) {
            var object = JSON.parse(msg.userdata);
            $("#user-real-name").attr("value", object.name);
            $("#emailID").attr("value", object.emailID);
            $("#schoolId").attr("value", object.schoolId);
            $("#summernote").attr("value", object.profile);
            $("#category").attr("value", object.major);
            $("#category-2").attr("value", object.campus);
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    });
    $("#save-update").click(function (message) {
        var $emailID = $("#emailID").val();
        var $username = $("#user-real-name").val();
        var $schoolId = $("#schoolId").val();
        var $profile = $("#summernote").val();
        var $major = $("#category").val();
        var $campus = $("#category-2").val();
        var userdata = {
            "emailID": $emailID,
            "user": $username,
            "schoolId": $schoolId,
            "profile": $profile,
            "major": $major,
            "campus": $campus
        };
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/sign_in",
            data: userdata,
            dataType: "json",
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