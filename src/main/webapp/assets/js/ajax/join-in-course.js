$(function () {
    let ur = location.href;
    let courseID = decodeURI(ur.split('#')[1]);
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/course_detail",
        data: {"id": courseID},
        dataType: "json",
        async: false,
        success: function (msg) {
            if (msg.message === "已加入课程") {
                $("#join-course").hide();
                $("#create-job").show();
                $("#create-job-href").attr("href", "candidate-dashboard.html#post-new-job#" + courseID);
            } else if (msg.message === "已发布项目") {
                $("#join-course").hide();
                $("#created").show();
            }
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
    $("#join-course").click(function () {
        let ur = location.href;
        let courseID = decodeURI(ur.split('#')[1]);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/study",
            data: {"id": courseID},
            dataType: "json",
            async: false,
            success: function (msg) {
                if (msg.message === "请先登陆"
                    || msg.message === "无需申请自己创建的课程") {
                    swal({
                        title: msg.message,
                        type: 'warning',
                        timer: 1000
                    });
                } else {
                    swal({
                        title: msg.message,
                        type: 'success',
                        timer: 1000
                    });
                    $("#join-course").hide();
                    $("#create-job").show();
                    $("#create-job").attr("href", "candidate-dashboard.html#post-new-job#" + courseID);
                }
                setTimeout(function () {
                    location.reload();
                }, 1000);
                location.reload();
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    })
})