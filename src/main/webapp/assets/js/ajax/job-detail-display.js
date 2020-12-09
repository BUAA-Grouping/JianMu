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
            let job = JSON.parse(msg.job);
            let poster=JSON.parse(msg.poster);
            let endTime=msg.endTime;
            $('#expected-end-time').text(endTime);
            $('#expected-num').text(job.exceptedNumOfMember);
            $('#job-profile').text(job.profile);
            $('#job-title').text(job.title);
            $('#major').text(job.major);
            $('#campus').text(job.campus);
            $('#poster-name').text(poster.name);
            $('#poster-major').text(poster.major);
            $('#job-email').text(poster.emailID);
            $('#job-telephone').text(job.telephone);
            $('#job-campus').text(job.campus);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})