$(function() {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/job_detail",
        dataType: "json",
        async: false,
        success: function(msg) {
            $('#expected-end-time').text(msg.job.expected_end_time);
            $('#expected-num').text(msg.job.exceptedNumOfMember);
            $('#job-profile').text(msg.job.profile);
            $('#job-title').text(msg.job.title);
            $('#major').text(msg.job.major);
            $('#campus').text(msg.job.campus);
            $('#poster-name').text(msg.poster.name);
            $('#poster-major').text(msg.poster.major);
            $('#job-email').text(msg.job.email);
            $('#job-telephone').text(msg.job.telephone);
        },
        error: function(xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})