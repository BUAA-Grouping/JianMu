$(function () {
    let ur = location.href;
    let jobID = decodeURI(ur.split('#')[1]);
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/course_detail",
        dataType: "json",
        data: {"id": jobID}, async: false,
        success: function (msg) {
            let course = JSON.parse(msg.course);
            let teacher = JSON.parse(msg.teacher);
            let jobList = JSON.parse(msg.jobList);
            let teamList = JSON.parse(msg.studentList);
            $('#capacity').text(course.capacity);
            $('#course-profile').text(course.profile);
            $('#course-title').text(course.title);
            $('#poster-name').text(teacher.name);
            $('#major').text(teacher.major);
            $('#poster-major').text(teacher.major);
            $('#job-email').text(teacher.emailID);
            $('#job-telephone').text(teacher.telephone);
            $('#course-campus').text(teacher.campus);
            addJobList(jobList, teamList);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})

function addJobList(jobList, teamList) {
    for (let i = 0; i < jobList.length; i = i + 1) {
        addJobInCourse(jobList[i], teamList[i], i);
    }
}

function addJobInCourse(job, appliers, postJobID) {
    let applyString = '';
    for (let i = 0; i < appliers.length; i++) {
        applyString += addTeammate(appliers[i]);
    }
    $('#job-cards').append(
        '<div class="card">\n' +
        '   <div class="card-header" id="heading' + postJobID + '"' + '>\n' +
        '       <h2 class="mb-0">\n' +
        '           <button class="btn btn-link" type="button"\n' +
        '               data-toggle="collapse" data-target="#collapse' + postJobID + '"' + '\n' +
        '               aria-expanded="true" aria-controls="collapse' + postJobID + '"' + '>\n' +
                    job.title +
        '           </button>\n' +
        '               <div class="mg-action ">\n' +
        '                   <div class="btn-group mb-0">\n' +
        '                       <a href="job-detail.html#' + job.id + '" class="btn btn-view" data-toggle="tooltip"\n' +
        '                           data-placement="top" ><i class="ti-check-box"></i>加入该项目</a>\n' +
        '                   </div>\n' +
        '               </div>' +
        '       </h2>\n' +
        '   </div>\n' +

        '   <div id="collapse' + postJobID + '"' + ' class="collapse show" aria-labelledby="heading' + postJobID + '"' + '\n' +
        '        data-parent="#accordionExample">\n' +
        '       <div class="card-body">\n' +
        applyString +
        '           </div>' +
        '       </div>\n' +
        '   </div>\n' +
        '</div>'
    );
}

function addTeammate(user) {
    return (
        '<div class="manage-list">' +
        '<div class="mg-list-wrap">\n' +
        '   <div class="mg-list-thumb">\n' +
        '       <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
        '   </div>\n' +
        '   <div class="mg-list-caption">\n' +
        '       <a href="candidate-detail.html#' + user.id + '" class="mg-title">' + user.name + '</a>\n' +
        '   </div>\n' +
        '</div>\n' +
        '</div>'
    );
}