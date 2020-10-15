$(function () {
    $("#post-job-save-update").click(function (message) {
        let $title = $("#job-title").val();
        let $profile = $("#jb-description").summernote('code');
        let $exceptedNumOfMember = $("#exceptedNumOfMember").val();
        let $college = $("#category1").val();
        let $campus = $("#category2").val();
        let $telephone = $("#job-telephone").val();
        let $emailID = $("#job-email").val();
        let $expected_end_time = $("#expected-end-time").val();
        let jobdata = {
            "emailID": $emailID,
            "title": $title,
            "telephone": $telephone,
            "profile": $profile,
            "college": $college,
            "campus": $campus,
            "exceptedNumOfMember": $exceptedNumOfMember,
        };
        jobdata = JSON.stringify(jobdata);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_post",
            data: {
                "jobdata": jobdata,
                "expected_end_time": $expected_end_time
            },
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