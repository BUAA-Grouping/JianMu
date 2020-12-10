$(function () {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/course_search",
        dataType: "json",
        async: false,
        success: function (msg) {
            addCourse(msg);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
    $("#search-job").click(function (message) {
        $('#jobs').empty();
        $('#pages').empty();
        let keyword = $('#key-words').val();
        let college = $('#category').val();
        let teacher = $('#teacher-name').val();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/course_search",
            data: {
                "keyword": keyword,
                "teacher": teacher,
                "college": college
            },
            dataType: "json",
            async: false,
            success: function (msg) {
                addCourse(msg);
            },
            error: function (xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    });
})

function addCourse(msg) {
    let num = 0;
    let courseList = JSON.parse(msg.courseList);
    let teacherList = JSON.parse(msg.teacherList);
    let length = courseList.length;
    $('#courses').append(' <li class="page-item">\n' +
        '            <a id="previous" class="page-link" onclick="jumpToPrevious()" href="#" aria-label="Previous">\n' +
        '            <span class="ti-arrow-left"></span>\n' +
        '            <span class="sr-only">Previous</span>\n' +
        '            </a>\n' +
        '            </li>');
    do {
        let k = 0;
        for (; k < Math.min(12, length); num++, k++) {
            let course = courseList[num];
            let teacher = teacherList[num];
            $('#jobs').append(
                '<div id="tab' + (num + 1).toString() + '" class="col-lg-4 col-md-4 col-sm-6">\n' +
                '   <div class="employer-wrap">\n' +
                '       <div class="employer-cover-image" style="background-image: url(assets/img/des-' + (k % 9 + 1).toString() + '.jpg)">\n' +
                '           <div class="employer-thumb">\n' +
                '                   <a href="#"><img alt="" src="assets/img/微电子.png" class="avatar avatar-120 photo"></a>\n' +
                '           </div>\n' +
                '       </div>\n' +
                '       <div class="employer-detail">\n' +
                '           <div class="employer-detail-inner">\n' +
                '               <h4 class="employer-title"><a class="theme-cl" href="course-detail.html#' + course.id + '">' + course.title + '</a></h4>\n' +
                '               <div class="employer-locations">' +
                '                   <i class="ti-location-pin text-danger"></i>' +
                '                   <a href="#">' + teacher.name + '</a>, ' +
                '                   <div >' + teacher.title + '</div>' +
                '               </div>\n' +
                '               <div class="employer-rating">\n' +
                '                   <i class="ti-star filled"></i>\n' +
                '                   <i class="ti-star filled"></i>\n' +
                '                   <i class="ti-star filled"></i>\n' +
                '                   <i class="ti-star filled"></i>\n' +
                '                   <i class="ti-star"></i>\n' +
                '               </div>\n' +
                '           </div>\n' +
                '       </div>\n' +
                '   </div>\n' +
                '</div>'
            );
            if (num >= 12) $('#tab' + (num + 1).toString()).hide();
        }
        if (Math.ceil(num / 12) === 1) {
            $('#jobs').append('<li id="page1" class="page-item active"><a onclick="jumpToPage(1)" href="#" class="page-link">' + 1 + '</a></li>');

        } else {
            let page = Math.ceil(num / 12);
            $('#jobs').append('<li id="page' + page + '" class="page-item"><a class="page-link" onclick="jumpToPage(' + page + ')" href="#">' + page + '</a></li>');

        }
        length -= k;
    } while (length > 0);
    $('#jobs').append('<li class="page-item">\n' +
        '            <a id="next" class="page-link" onclick="jumpToNext()" href="#" aria-label="Next">\n' +
        '            <span class="ti-arrow-right"></span>\n' +
        '            <span class="sr-only">Next</span>\n' +
        '            </a>\n' +
        '            </li>');

}