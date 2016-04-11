/**Отправка формы выхода из сессии по нажатию кнопки из меню*/
function formSubmit() {
    document.getElementById("logoutForm").submit();
}

$('body').on('click', '.changePassword', function (e) {
    $('#close').click();
    $('#changePassword').modal ({remote : '/changePassword'});
});