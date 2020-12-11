$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/course_manage",
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
    let courseList = JSON.parse(msg.courseList);
    let studentList = JSON.parse(msg.studentList);
    for (let i = 0; i < courseList.length; i = i + 1) {
        addPostCourse(courseList[i], studentList[i], i);
    }
}

function addPostCourse(course, studentList, postCID) {
    let applyString = '';
    for (let i = 0; i < studentList.length; i++) {
        applyString += addStudent(studentList[i], 0, course.id);
    }
    $('#course-cards').append(
        '<div class="card">\n' +
        '   <div class="card-header" id="heading' + postCID + '"' + '>\n' +
        '       <h2 class="mb-0">\n' +
        '           <button class="btn btn-link" type="button"\n' +
        '               data-toggle="collapse" data-target="#collapse-course' + postCID + '"' + '\n' +
        '               aria-expanded="true" aria-controls="collapse-course' + postCID + '"' + '>\n' +
        '               <div class="mg-list-wrap">\n' +
        '                   <div class="mg-list-thumb">\n' +
        '                       <img src="assets/img/计算机学院.png" class="mx-auto" alt=""/>\n' +
        '                   </div>\n' +
        '                   <div class="mg-list-caption">\n' +
        '                       <h4 class="mg-title">' + course.title + '</h4>\n' +
        '                   </div>\n' +
        '               </div>\n' +
        '           </button>\n' +
        '       </h2>\n' +
        '   </div>\n' +
        '   <div id="collapse-course' + postCID + '"' + ' class="collapse show" aria-labelledby="heading' + postCID + '"' + '\n' +
        '        data-parent="#accordionExample">\n' +
        '       <div class="card-body">\n' +
        applyString +
        '           </div>' +
        '       </div>\n' +
        '   </div>\n' +
        '</div>'
    );
}

function addStudent(student,courseId) {
    return (
        '<div class="manage-list">' +
        '<div class="mg-list-wrap">\n' +
        '   <div class="mg-list-thumb">\n' +
        '       <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
        '   </div>\n' +
        '   <div class="mg-list-caption">\n' +
        '       <a href="candidate-detail.html#' + student.id + '" class="mg-title">' + student.name + '</a>\n' +
        '   </div>\n' +
        '</div>\n' +
        '<div class="mg-action">\n' +
        '   <div class="btn-group ml-2">\n' +
        '       <a href="#" onclick="deleteStudent(' + student.id + ',' + courseId + ')"  class="mg-delete ml-2" data-toggle="tooltip"\n' +
        '           data-placement="top" >删除</a>\n' +
        '   </div>\n' +
        '</div>' +
        '</div>'
    );
}

function deleteStudent(studentId, courseId) {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/member_delete",
        data: {
            "courseId": courseId,
            "studentId": studentId
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
    })
}
