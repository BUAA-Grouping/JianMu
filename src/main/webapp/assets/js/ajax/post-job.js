$(function () {
    $("#post-job-save-update").click(function (message) {
        var $emailID = $("#emailID").val();
        var $username = $("#user-real-name").val();
        var $schoolId = $("#schoolId").val();
        var $profile = $("#summernote").val();
        var $major = $("#category").val();
        var $campus = $("#category-2").val();

        var userdata = {
            "emailID": $emailID,
            "name": $username,
            "schoolId": $schoolId,
            "profile": $profile,
            "major": $major,
            "campus": $campus
        };
        userdata=JSON.stringify(userdata);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_post",
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