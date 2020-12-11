$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/manage",
        dataType: "json",
        async: false,
        success: function (msg) {
            addCourseList(msg);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})

function addCourseList(msg) {
    let list = JSON.parse(msg.courseList);
    for (let i = 0; i < list.length; i = i + 1) {
        addPostCourse(list[i], i);
    }
}

function addPostCourse(item, postJobID) {
    let course = item.course;
    let students = item.students;
    for (let i = 0; i < course.length; i++) {
        applyString += addApplier(applyingUsers[i], 0, job.id);
    }
    $('#course-cards').append(
        '<div class="card">\n' +
        '   <div class="card-header" id="heading' + postJobID + '"' + '>\n' +
        '       <h2 class="mb-0">\n' +
        '           <button class="btn btn-link" type="button"\n' +
        '               data-toggle="collapse" data-target="#collapse-course' + postJobID + '"' + '\n' +
        '               aria-expanded="true" aria-controls="collapse-course' + postJobID + '"' + '>\n' +
        '               <div class="mg-list-wrap">\n' +
        '                   <div class="mg-list-thumb">\n' +
        '                       <img src="assets/img/计算机学院.png" class="mx-auto" alt=""/>\n' +
        '                   </div>\n' +
        '                   <div class="mg-list-caption">\n' +
        '                       <h4 class="mg-title">' + job.title + '</h4>\n' +
        '                   </div>\n' +
        '               </div>\n' +
        '           </button>\n' +
        '       </h2>\n' +
        '   </div>\n' +
        '   <div id="collapse-course' + postJobID + '"' + ' class="collapse show" aria-labelledby="heading' + postJobID + '"' + '\n' +
        '        data-parent="#accordionExample">\n' +
        '       <div class="card-body">\n' +
        applyString +
        '           </div>' +
        '       </div>\n' +
        '   </div>\n' +
        '</div>'
    );
}
