/***
 *������������� �������� ����� �������� � ������� ������
 * */
$('#modalClear .clearBtn').click(function(e) {
    $('#modalClear').modal('hide');
});
$('#modalClear').on('hidden.bs.modal', function () {
    location.reload();
});