$(function () {
    let ur = location.href;
    let jobID = decodeURI(ur.split('#')[1]);
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/job_detail",
        dataType: "json",
        data: {"id": jobID},
        async: false,
        success: function (msg) {
            let course = JSON.parse(msg.course);
            let teacher = JSON.parse(msg.teacher);
            let jobList = JSON.parse(msg.jobList);
            $('#capacity').text(course.capacity);
            $('#course-profile').text(course.profile);
            $('#course-title').text(course.title);
            $('#poster-name').text(teacher.name);
            $('#major').text(teacher.major);
            $('#poster-major').text(teacher.major);
            $('#job-email').text(teacher.emailID);
            $('#job-telephone').text(teacher.telephone);
            $('#course-campus').text(teacher.campus);
            addJobList(jobList);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})

function addJobList(jobList) {

}