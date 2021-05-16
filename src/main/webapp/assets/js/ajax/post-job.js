$(function () {
    let ur = location.href;
    let courseId = decodeURI(ur.split('#')[2]);
    if (courseId !== '') {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/JianMu_war/job_post",
            data: {"id": courseId},
            dataType: "json",
            async: false,
            success: function (msg) {
                $("#job-course").attr("value",msg.courseTitle);
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    }
    $("#post-job-save-update").click(function (message) {
        let title = $("#job-title").val();
        let profile = $("#jb-description").summernote('code');
        let exceptedNumOfMember = $("#exceptedNumOfMember").val();
        let college = $("#category1").val();
        let campus = $("#category2").val();
        let telephone = $("#job-telephone").val();
        let emailID = $("#job-email").val();
        let expected_end_time = $("#expected-end-time").val();
        let jobdata = {
            "emailID": emailID,
            "title": title,
            "telephone": telephone,
            "profile": profile,
            "college": college,
            "campus": campus,
            "exceptedNumOfMember": exceptedNumOfMember,
        };
        jobdata = JSON.stringify(jobdata);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_post",
            data: {
                "jobdata": jobdata,
                "expected_end_time": expected_end_time,
                "courseId": courseId
            },
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