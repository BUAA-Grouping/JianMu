$(function () {
    let ur = location.href;
    if (ur.search("#") !== -1) {
        let key_words = decodeURI(ur.split('#')[1]);
        let major = ur.split('#')[2];
        let campus = ur.split('#')[3];
        $('#key-words').attr("value", key_words);
        let majorNameSelect = $("#category").select2();
        majorNameSelect.val(major).trigger("change");
        majorNameSelect.change();
        let campusNameSelect = $("#category-2").select2();
        campusNameSelect.val(campus).trigger("change");
        campusNameSelect.change();
        document.getElementById('search-job').click();
    }
})