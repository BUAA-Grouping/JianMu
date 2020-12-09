$(function () {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/job_search",
        dataType: "json",
        async: false,
        success: function (msg) {
            addJob(msg);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
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
                swal(xhr.message, "Error!", 'error');
            }
        });
    });
})

function addJob(msg) {
    if (msg.message === "成功找到相关项目") {
        let postJobID = 0;
        let length = msg.jobList.length;
        $('#job-cards').append('<div class="card">\n' +
            '                        <div class="card-header" id="heading' + postJobID + '"' + '>\n' +
            '                            <h2 class="mb-0">\n' +
            '                                  <button class="btn btn-link" type="button"\n' +
            '                                          data-toggle="collapse" data-target="#collapse' + postJobID + '"' + '\n' +
            '                                          aria-expanded="true" aria-controls="collapse' + postJobID + '"' + '>\n' +
            '                                          <div class="mg-list-wrap">\n' +
            '                                               <div class="mg-list-thumb">\n' +
            '                                                   <img src="assets/img/计算机学院.png" class="mx-auto" alt=""/>\n' +
            '                                                                </div>\n' +
            '                                                                <div class="mg-list-caption">\n' +
            '                                                                    <h4 class="mg-title">数据库大作业</h4>\n' +
            '                                                                </div>\n' +
            '                                                            </div>\n' +
            '                                                        </button>\n' +
            '                                                    </h2>\n' +
            '                                                </div>\n' +
            '\n' +
            '                                                <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo"\n' +
            '                                                     data-parent="#accordionExample">\n' +
            '                                                    <div class="card-body">\n' +
            '                                                        <div class="mg-list-wrap">\n' +
            '                                                            <div class="mg-list-thumb">\n' +
            '                                                                <img src="assets/img/user-6.jpg" class="mx-auto"\n' +
            '                                                                     alt=""/>\n' +
            '                                                            </div>\n' +
            '                                                            <div class="mg-list-caption">\n' +
            '                                                                <h3 class="mg-title">小美</h3>\n' +
            '                                                                <span class="mg-subtitle">产品经理</span>\n' +
            '                                                            </div>\n' +
            '                                                        </div>\n' +
            '\n' +
            '                                                        <div class="mg-action">\n' +
            '                                                            <div class="btn-group custom-drop">\n' +
            '                                                                <button type="button" class="btn btn-more"\n' +
            '                                                                        data-toggle="dropdown" aria-haspopup="true"\n' +
            '                                                                        aria-expanded="false">\n' +
            '                                                                    <i class="ti-more"></i>\n' +
            '                                                                </button>\n' +
            '                                                                <div class="dropdown-menu pull-right animated flipInX">\n' +
            '                                                                    <a href="candidate-detail.html">查看个人主页</a>\n' +
            '                                                                    <!--记得修改-->\n' +
            '                                                                    <a>此处为项目名</a>\n' +
            '                                                                </div>\n' +
            '                                                            </div>\n' +
            '                                                            <div class="btn-group ml-2">\n' +
            '                                                                <a href="#" class="mg-delete"><i\n' +
            '                                                                        class="ti-trash"></i></a>\n' +
            '                                                            </div>\n' +
            '                                                        </div>\n' +
            '                                                    </div>\n' +
            '                                                </div>\n' +
            '                                            </div>');

    }
}