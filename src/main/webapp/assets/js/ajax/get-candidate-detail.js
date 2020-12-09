$(function () {
    let ur = location.href;
    let userId = decodeURI(ur.split('#')[1]);
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/info",
        dataType: "json",
        data: {"id": userId},
        async: false,
        success: function (msg) {
            let object = JSON.parse(msg.userdata);
            let campus = JSON.parse(msg.campus);
            let college = JSON.parse(msg.college);
            $("#user-real-name").text(object.name);
            $("#emailID-display").text(object.emailID);
            $("#schoolId").text(object.studentId);
            $("#profile").text(object.profile);
            $("#campus").text(campus);
            $("#college").text(college);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})