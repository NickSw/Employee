//submit via modal bootstrap
$(function () {
    $('body').on('click', '.modalSubmit', function (e) {
        $('.modal-body form').submit();
        $('#myModal').modal('hide');
    });
});

/***
 * Выпадающий список импорта -> переход по ссылке
 * */
$(".modal-body .form-group select").change(function () {
    console.log($('.modal-body .form-group select').find(":selected").val());
    var selectet_val = $('.modal-body .form-group select').find(":selected").val();

    if (selectet_val == "employee"){
        $('.modal-body form').attr("action", "/importEmployee");
    } else if (selectet_val == "movement"){
        $('.modal-body form').attr("action", "/importMovement");
    } else if (selectet_val == "workplace"){
        $('.modal-body form').attr("action", "/importWorkPlace");
    } else if (selectet_val == "ordertype"){
        $('.modal-body form').attr("action", "/importOrderType");
    }
});