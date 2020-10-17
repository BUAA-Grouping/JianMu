$(function () {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/job_search",
        dataType: "json",
        async: false,
        success: function (msg) {
            addTab(msg);
        },
        error: function (xhr) {
            alert(xhr.status);
        }
    });
    $("#search-job").click(function (message) {
        $('#jobs').empty();
        $('#pages').empty();
        let $keyword = $('#key-words').val();
        let $college = $('#category').val();
        let $campus = $('#category-2').val();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_search",
            data: {
                "keyword": $keyword,
                "campus": $campus,
                "college": $college
            },
            dataType: "json",
            async: false,
            success: function (msg) {
                addTab(msg);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
    });
})

function addTab(msg) {
    if (msg.message === "成功找到相关项目") {
        let num = 0;
        let length = msg.jobList.length;
        $('#pages').append(' <li class="page-item">\n' +
            '            <a id="previous" class="page-link" onclick="jumpToPrevious()" href="#" aria-label="Previous">\n' +
            '            <span class="ti-arrow-left"></span>\n' +
            '            <span class="sr-only">Previous</span>\n' +
            '            </a>\n' +
            '            </li>');
        do {
            let k = 0;
            for (; k < Math.min(12, length); num++, k++) {
                let job = msg.jobList[num];
                $('#jobs').append('<div id="tab' + (num + 1).toString() + '" class="col-lg-4 col-md-6 col-sm-6">\n' +
                    '<div class="classic-joblist ultimate-center">\n' +
                    '<div class="cl-job-employer">\n' +
                    '<div class="cljb-emp-thumg">\n' +
                    '<a href="job-detail.html"><img src="assets/img/软件学院.png" alt=""/></a>\n' +
                    '</div>\n' +
                    '<div class="cljb-emp-detail">\n' +
                    '<h5><a href="employer-detail.html">' + job.campus + '</a></h5>\n' +
                    '<span class="cljb-date">' + job.start_time + '</span>\n' +
                    '</div>\n' +
                    '</div>\n' +
                    '<h4 class="job-title"><a href="job-detail.html">' + job.title + '</a>\n' +
                    '</h4>\n' +
                    '<div class="cl-job-intro">\n' +
                    '<span class="cl-jb-loaction"><i class="ti-user"></i>' + job.poster + '</span>\n' +
                    '</div>\n' +
                    '</div>\n' +
                    '</div>');
                if (num >= 12) $('#tab' + (num + 1).toString()).css('display', 'none');
            }
            if (Math.ceil(num / 12) === 1) {
                $('#pages').append('<li id="page1" class="page-item active"><a onclick="jumpToPage(1)" href="#" class="page-link">' + 1 + '</a></li>');

            } else {
                let page = Math.ceil(num / 12);
                $('#pages').append('<li id="page' + page + '" class="page-item"><a class="page-link" onclick="jumpToPage(' + page + ')" href="#">' + page + '</a></li>');

            }
            length -= k;
        } while (length > 0);
        $('#pages').append('<li class="page-item">\n' +
            '            <a id="next" class="page-link" onclick="jumpToNext()" href="#" aria-label="Next">\n' +
            '            <span class="ti-arrow-right"></span>\n' +
            '            <span class="sr-only">Next</span>\n' +
            '            </a>\n' +
            '            </li>');
    }
}

function jumpToPage(page) {//传入参数为当前的page
    $('#page' + page).click(function (message) {
        if ($('#page' + page).hasClass("active"))
            return;
        $('#page' + page).addClass('active');
        let i = (page - 1) * 12 + 1;
        while ($('#tab' + i).length > 0) {
            $('#tab' + i.toString()).css('display', 'block');
            i++;
        }
        let k = 1;
        while ($('#page' + k).length > 0) {
            if (k !== page && $('#page' + k).hasClass("active")) {
                let j = (k - 1) * 12 + 1;
                while ($('#tab' + j).length > 0 && j <= k * 12) {
                    $('#tab' + j.toString()).css('display', 'none');
                    j++;
                }
                $('#page' + k).removeClass("active");
                break;
            }
            k++;
        }
    })
}

function jumpToPrevious() {
    let k = 1;
    while ($('#page' + k).length > 0) {
        if ($('#page' + k).hasClass("active")) {
            if (k === 1)
                break;
            let i = (k - 1) * 12;
            while ($('#tab' + (i + 1).toString()).length > 0 && (i < k * 12)) {
                $('#tab' + (i + 1).toString()).css('display', 'none');
                i++;
            }
            $('#page' + k).removeClass("active");
            for (let i = (k - 2) * 12; i < (k - 1) * 12; i++) {
                $('#tab' + (i + 1).toString()).css('display', 'block');
            }
            $('#page' + (k - 1).toString()).addClass("active");
            break;
        }
        k++;
    }
}

function jumpToNext() {
    let k = 1;
    while ($('#page' + k).length > 0) {
        if ($('#page' + k).hasClass("active")) {
            let pageK = $('#page' + (k + 1).toString());
            if (pageK.length <= 0)
                break;
            for (let i = (k - 1) * 12; i < k * 12; i++) {
                $('#tab' + (i + 1).toString()).css('display', 'none');
            }
            $('#page' + k).removeClass("active");
            let i = k * 12;
            while ($('#tab' + (i + 1).toString()).length > 0 && (i < (k + 1) * 12)) {
                $('#tab' + (i + 1).toString()).css('display', 'block');
                i++;
            }
            pageK.addClass("active");
            break;
        }
        k++;
    }
}