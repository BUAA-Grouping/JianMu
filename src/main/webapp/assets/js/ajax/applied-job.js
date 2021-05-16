$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/manage",
        dataType: "json",
        async: false,
        success: function (msg) {
            addAppliedList(msg);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})

function addAppliedList(msg) {
    let list = JSON.parse(msg.myApply);
    let jobs = JSON.parse(msg.myApplyJob);
    for (let i = 0; i < list.length; i++) {
        let app = list[i];
        let job = jobs[i];
        let statusString = '';
        switch (app.status) {
            case 1: {
                statusString = '审核中';
                break;
            }
            case 2: {
                statusString = '已通过';
                break;
            }
            case 3: {
                statusString = '已被拒绝';
                break;
            }
        }
        $('#applied-jobs').append(
            '<div class="manage-list">\n' +
            '   <div class="mg-list-wrap">\n' +
            '       <div class="mg-list-thumb">\n' +
            '           <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
            '       </div>\n' +
            '       <div class="mg-list-caption">\n' +
            '           <a href="candidate-detail.html" class="mg-title">' + job.title + '</a>\n' +
            '       </div>\n' +
            '   </div>\n' +
            '   <div class="mg-action">\n' +
            '       <div class="btn-group ml-2">\n' +
            '           <div href="job-detail.html' + '#' + app.jobId + '" class="btn btn-view" data-toggle="tooltip"\n' +
            '                data-placement="top" title="查看任务详情">' + statusString + '</div>\n' +
            '           <div href="" class="mg-delete ml-2" data-toggle="tooltip"\n' +
            '                        data-placement="top" title="删除"><i class="ti-trash"></i></div>\n' +
            '       </div>\n' +
            '   </div>\n' +
            '</div>'
        )
        ;
    }
}