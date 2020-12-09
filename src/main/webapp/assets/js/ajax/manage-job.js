$(function() {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/JianMu_war/job_search",
        dataType: "json",
        async: false,
        success: function(msg) {
            addJob(msg);
        },
        error: function(xhr) {
            swal(xhr.message, "Error!", 'error');
        }
    });
    $("#search-job").click(function(message) {
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
            success: function(msg) {
                addTab(msg);
            },
            error: function(xhr) {
                swal(xhr.message, "Error!", 'error');
            }
        });
    });
})

function addJob(msg) {

}