$(function () {
    $("#").click(function (message) {

        $.ajax({
            type: "post",
            url: "http://localhost:8080/JianMu_war/job_search",
            data: {
                "keyword": ,
                "campus": ,
                "college":
            },
            dataType: "json",
            async: false,
            success: function (msg) {

            },
            error: function (xhr) {
                alert(xhr.status);
            }
        });
    })
})