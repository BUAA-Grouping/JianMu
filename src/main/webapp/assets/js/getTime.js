function getdates() {
    let d = new Date();
    let year = d.getFullYear();
    let month = d.getMonth() + 1;
    let day = d.getDate();
    let week = d.getDay();
    let h = d.getHours();
    let mins = d.getMinutes();
    let s = d.getSeconds();
    if (month < 10) month = "0" + month
    if (day < 10) month = "0" + day
    if (h < 10) h = "0" + h
    if (mins < 10) mins = "0" + mins
    if (s < 10) s = "0" + s
    var shows = month + "-" + day + "-" + year;
    $("#expected-end-time").attr("value", shows);
}

$(function () {
    getdates();
})