$(function () {
    $("#search-job").click(function (message) {
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
                if (msg.message === "成功找到相关项目") {
                    for (let i = 0; i < msg.joblist.length; i++) {
                        let job = msg.joblist[i];
                        $('#jobs').append('                <div class="col-lg-4 col-md-6 col-sm-6">\n' +
                            '                    <div class="classic-joblist ultimate-center">\n' +
                            '                        <div class="cl-job-employer">\n' +
                            '                            <div class="cljb-emp-thumg">\n' +
                            '                                <a href="job-detail.html"><img src="assets/img/软件学院.png" alt=""/></a>\n' +
                            '                            </div>\n' +
                            '                            <div class="cljb-emp-detail">\n' +
                            '                                <h5><a href="employer-detail.html">' + job.campus + '</a></h5>\n' +
                            '                                <span class="cljb-date">' + job.start_time + '</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <h4 class="job-title"><a href="job-detail.html">' + job.title + '</a>\n' +
                            '                        </h4>\n' +
                            '                        <div class="cl-job-intro">\n' +
                            '                            <span class="cl-jb-loaction"><i class="ti-location-pin"></i>' + job.poster + '</span>\n' +
                            '                        </div>\n' +
                            '                    </div>\n' +
                            '                </div>');
                    }
                }
                console.log(msg);
            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
    })
})