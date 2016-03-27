/***
 * Выпадающий список экспорта -> переход по ссылке
 * */
$(".modal-body select").change(function () {
    //console.log($('.modal-body select').find(":selected").val());
    var selectet_val = $('.modal-body select').find(":selected").val();

    if (selectet_val == "employee"){
        $("#modalExport .exportBtn").attr("href", "/export/employee");
    } else if (selectet_val == "movement"){
        $("#modalExport .exportBtn").attr("href", "/export/movement");
    } else if (selectet_val == "workplace"){
        $("#modalExport .exportBtn").attr("href", "/export/workplace");
    } else if (selectet_val == "ordertype"){
        $("#modalExport .exportBtn").attr("href", "/export/ordertype");
    }
});