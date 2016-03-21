
/**
 * Модальное окно удаления
 */

$(".triggerDelete").click(function(e) {
    e.preventDefault();
    $("#modalDelete .deleteBtn").attr("href", $(this).attr("href"));
    $('#modalDelete').modal();
});