$(function () {
    $("#apply-job").click(function (message) {
        let ur = location.href;
        let jobID = decodeURI(ur.split('#')[1]);
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/apply-job",
            dataType: "json",
            data: {"id": jobID},
            async: false,
            success: function (msg) {
                if (msg.message === "请勿重复申请") {
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
                }
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    })
})


