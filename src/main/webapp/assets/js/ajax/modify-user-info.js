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
            $("#schoolId").attr("value", object.studentId);
            $("#summernote").attr("value", object.profile);
            $("#user-name-big").attr("value", object.name);
            $('#personal-index').attr("href", "candidate-detail.html#" + object.id);
            $("#user-name-big").text(object.name);
            $("#user-greeting").text("您好！" + object.name);
            let majorNameSelect = $("#category").select2();
            majorNameSelect.val(object.collegeId.toString()).trigger("change");
            majorNameSelect.change();
            let campusNameSelect = $("#category-2").select2();
            campusNameSelect.val(object.campus.toString()).trigger("change");
            campusNameSelect.change();
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
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
            "studentId": $schoolId,
            "profile": $profile,
            "collegeId": $major,
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
                swal({
                    title: msg.message,
                    text: "Success!",
                    type: 'success',
                    timer: 1000
                });
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    })
})