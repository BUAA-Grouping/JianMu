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
            // $("#category").val(object.major);
            $('#category option:eq(object.major)').attr('selected','selected');
            // $("#category-2").val(object.campus);
            $('#category-2 option:eq(object.campus)').attr('selected','selected');
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    });
    $("#save-update").click(function (message) {
        let $emailID = $("#emailID").val();
        let $username = $("#user-real-name").val();
        let $schoolId = $("#schoolId").val();
        let $profile = $("#summernote").val();
        let $major = $("#category").val();
        let $campus = $("#category-2").val();
        let userdata = {
            "emailID": $emailID,
            "name": $username,
            "schoolId": $schoolId,
            "profile": $profile,
            "major": $major,
            "campus": $campus
        };
        userdata = JSON.stringify(userdata);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/user_modify",
            data: {"userdata": userdata},
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