$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/JianMu_war/manage",
        dataType: "json",
        async: false,
        success: function (msg) {
            addList(msg);
        },
        error: function (xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
})

function addList(msg) {
    let list = JSON.parse(msg.jobList);
    for (let i = 0; i < list.length; i = i + 1) {
        addJob(list[i], i);
    }
}

function addJob(item, postJobID) {
    let job = item.job;
    let appliers = item.applies;
    let users = item.users;
    let applyString = '';
    let applying = appliers[0];
    let accept = appliers[1];
    let deny = appliers[2];
    let applyingUsers = users[0];
    let acceptUsers = users[1];
    let denyUsers = users[2];
    for (let i = 0; i < applying.length; i++) {
        applyString += addApplier(applyingUsers[i], 0, job.id);
    }
    for (let i = 0; i < accept.length; i++) {
        applyString += addApplier(acceptUsers[i], 1, job.id);
    }
    for (let i = 0; i < deny.length; i++) {
        applyString += addApplier(denyUsers[i], 2, job.id);
    }
    $('#job-cards').append(
        '<div class="card">\n' +
        '   <div class="card-header" id="heading' + postJobID + '"' + '>\n' +
        '       <h2 class="mb-0">\n' +
        '           <button class="btn btn-link" type="button"\n' +
        '               data-toggle="collapse" data-target="#collapse' + postJobID + '"' + '\n' +
        '               aria-expanded="true" aria-controls="collapse' + postJobID + '"' + '>\n' +
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

function addApplier(user, type, jobId) {
    if (type === 0) {
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
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <a href="#" onclick="pass(' + user.id + ',' + jobId + ',2)"  class="btn btn-view" data-toggle="tooltip"\n' +
            '           data-placement="top" title="通过申请"><i class="ti-check"></i></a>\n' +
            '       <a href="#" onclick="pass(' + user.id + ',' + jobId + ',3)"  class="mg-delete ml-2" data-toggle="tooltip"\n' +
            '           data-placement="top" title="拒绝申请"><i class="ti-close"></i></a>\n' +
            '   </div>\n' +
            '</div>' +
            '</div>'
        );
    } else if (type === 1) {
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
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <div class="btn btn-view" data-toggle="tooltip" data-placement="top">' +
            '           已通过该成员</div>\n' +
            '   </div>\n' +
            '</div>' +
            '</div>'
        );
    } else {
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
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <div class="mg-delete ml-2" data-toggle="tooltip"\n' +
            '           data-placement="top" >已拒绝该成员</div>\n' +
            '   </div>\n' +
            '</div>' +
            '</div>'
        );
    }
}

function pass(userId, jobId, status) {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/manage",
        data: {
            "userId": userId,
            "jobId": jobId,
            "status": status
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