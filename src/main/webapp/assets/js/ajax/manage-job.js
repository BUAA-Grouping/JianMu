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
    let applying = list[0];
    let accept = list[1];
    let deny = list[2];
    for (let i = 0; i < applying.length; i = i + 1) {
        addJob(applying[i], i, 0);
    }
    for (let i = 0; i < accept.length; i = i + 1) {
        addJob(applying[i], i, 1);
    }
    for (let i = 0; i < deny.length; i = i + 1) {
        addJob(applying[i], i, 2);
    }
}

function addJob(item, postJobID, type) {
    let job = item.job;
    let appliers = item.applies;
    let users = item.users;
    let applyString = '';
    for (let i = 0; i < appliers.length; i++) {
        applyString += addApplier(users[i], type);
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
        '   <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo"\n' +
        '        data-parent="#accordionExample">\n' +
        '       <div class="card-body">\n' +
        '           <div class="manage-list">' +
        applyString +
        '           </div>' +
        '       </div>\n' +
        '   </div>\n' +
        '</div>'
    );
}

function addApplier(user, type) {
    if (type === 0) {
        return (
            '<div class="mg-list-wrap">\n' +
            '   <div class="mg-list-thumb">\n' +
            '       <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
            '   </div>\n' +
            '   <div class="mg-list-caption">\n' +
            '       <a href="candidate-detail.html#' + user.id + 'class="mg-title">' + user.name + '</a>\n' +
            '   </div>\n' +
            '</div>\n' +
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <a href="#" id="pass-applier" class="btn btn-view" data-toggle="tooltip"\n' +
            '           data-placement="top" title="通过申请"><i class="ti-check"></i></a>\n' +
            '       <a href="#" id="deny-applier" class="mg-delete ml-2" data-toggle="tooltip"\n' +
            '           data-placement="top" title="拒绝申请"><i class="ti-close"></i></a>\n' +
            '   </div>\n' +
            '</div>'
        );
    } else if (type === 1) {
        return (
            '<div class="mg-list-wrap">\n' +
            '   <div class="mg-list-thumb">\n' +
            '       <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
            '   </div>\n' +
            '   <div class="mg-list-caption">\n' +
            '       <a href="candidate-detail.html#' + applier.userId + 'class="mg-title">' + applier.name + '</a>\n' +
            '   </div>\n' +
            '</div>\n' +
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <div class="btn btn-view" data-toggle="tooltip" data-placement="top">' +
            '           已通过该成员</div>\n' +
            '   </div>\n' +
            '</div>'
        );
    } else {
        return (
            '<div class="mg-list-wrap">\n' +
            '   <div class="mg-list-thumb">\n' +
            '       <img src="assets/img/软件学院.png" class="mx-auto" alt=""/>\n' +
            '   </div>\n' +
            '   <div class="mg-list-caption">\n' +
            '       <a href="candidate-detail.html#' + applier.userId + 'class="mg-title">' + applier.name + '</a>\n' +
            '   </div>\n' +
            '</div>\n' +
            '<div class="mg-action">\n' +
            '   <div class="btn-group ml-2">\n' +
            '       <div class="mg-delete ml-2" data-toggle="tooltip"\n' +
            '           data-placement="top" >已拒绝该成员</div>\n' +
            '   </div>\n' +
            '</div>'
        );
    }

}