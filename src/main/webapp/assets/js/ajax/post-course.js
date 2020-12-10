$(function () {
    $("#post-course-save-update").click(function (message) {
        let title = $("#course-title").val();
        let profile = $("#course-description").summernote('code');
        let capacity = $("#capacity").val();
        let college = $("#category-1").val();
        let courseData = {
            "title": title,
            "profile": profile,
            "college": college,
            "capacity": capacity
        };
        courseData = JSON.stringify(courseData);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/course_post",
            data: {
                "courseData": courseData
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