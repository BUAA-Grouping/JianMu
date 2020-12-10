$(function () {
    let ur = location.href;
    let courseID = decodeURI(ur.split('#')[2]);
    if (courseID !== '') {
        $.ajax({
            type: "get",
            url: "http://localhost:8080/JianMu_war/job-post",
            data: {"id": courseID},
            dataType: "json",
            async: false,
            success: function (msg) {
                $("#job-course").text(msg.courseTitle);
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
        let courseTitle = $("#job-course").val();
        let jobdata = {
            "emailID": emailID,
            "title": title,
            "telephone": telephone,
            "profile": profile,
            "college": college,
            "campus": campus,
            "exceptedNumOfMember": exceptedNumOfMember,
            "courseTitle": courseTitle
        };
        jobdata = JSON.stringify(jobdata);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_post",
            data: {
                "jobdata": jobdata,
                "expected_end_time": expected_end_time
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