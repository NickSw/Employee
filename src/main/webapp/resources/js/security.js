/**�������� ����� ������ �� ������ �� ������� ������ �� ����*/
function formSubmit() {
    document.getElementById("logoutForm").submit();
}

$('body').on('click', '.changePassword', function (e) {
    $('#close').click();
    $('#changePassword').modal ({remote : '/changePassword'});
});