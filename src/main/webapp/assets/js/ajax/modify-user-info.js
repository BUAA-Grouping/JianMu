$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/user_modify",
        dataType: "json",
        async: false,
        success: function (msg) {
            let object = JSON.parse(msg.userdata);
            let type = JSON.parse(msg.type);
            $("#user-real-name").attr("value", object.name);
            $("#emailID").attr("value", object.emailID);
            $("#summernote").attr("value", object.profile);
            $("#user-name-big").attr("value", object.name);
            $("#user-name-big").text(object.name);
            $('#personal-index').attr("href", "candidate-detail.html#" + object.id);
            let majorNameSelect = $("#category").select2();
            majorNameSelect.val(object.collegeId.toString()).trigger("change");
            majorNameSelect.change();
            let campusNameSelect = $("#category-2").select2();
            campusNameSelect.val(object.campus.toString()).trigger("change");
            campusNameSelect.change();
            if (type === 0) {
                $("#schoolId").attr("value", object.studentId);
            } else {
                $("#manage-courses-tab").show();
                $("#post-new-course-tab").show();
                $("#applied-tab").hide();
                $("#user-greeting").text("您好！" + object.name.substr(0, 1) + "老师");
                $("#teacherId").attr("value", object.teacherId);
                $("#teacher-title").attr("value", object.title);
            }
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
    $("#save-update").click(function (message) {
        let $emailID = $("#emailID").val();
        let $username = $("#user-real-name").val();
        let greeting = $("#user-greeting").text();
        let $profile = $("#summernote").val();
        let $major = $("#category").val();
        let $campus = $("#category-2").val();
        let userdata;
        if (greeting.substr(greeting.length - 2, 2) === "老师") {
            let $teacherId = $("#teacherId").val();
            userdata = {
                "emailID": $emailID,
                "name": $username,
                "studentId": $teacherId,
                "profile": $profile,
                "collegeId": $major,
                "campus": $campus
            };
        }else{
            let $schoolId = $("#schoolId").val();
            userdata = {
                "emailID": $emailID,
                "name": $username,
                "studentId": $schoolId,
                "profile": $profile,
                "collegeId": $major,
                "campus": $campus
            };
        }
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