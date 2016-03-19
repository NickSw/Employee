$(document).ready(function(){
    $('.filterable .btn-filter').click(function(){
        var $panel = $(this).parents('.filterable'),
            $filters = $panel.find('.filters input'),
            $tbody = $panel.find('.table tbody');
        if ($filters.prop('disabled') == true &&
            $('#ordertypepicker').css('display','none') &&
            $('#movement-datepicker').css('display','none')
        ) {
            $filters.prop('disabled', false);
            $('#ordertypepicker').css('display','inline-table');
            $('#ordertypename').css('display','none');
            $('#movement-datepicker').css('display','inline-table');
            $('#movement-datename').css('display','none');
            //$filters.first().focus();
        } else {
            $filters.val('').prop('disabled', true);
            $tbody.find('.no-result').remove();
            $tbody.find('tr').show();
            $('#ordertypepicker').css('display','none');
            $('#ordertypename').css('display','block');
            $('#movement-datepicker').css('display','none');
            $('#movement-datename').css('display','block');
        }
    });

    $('#ordertypevalue').change(function(){
        var $input = $(this);
        $('table tr').each(function(){
            var order = $(this).find('td').eq(2).text();
            if(order.length){
                if(order==$input.val()){
                    $(this).show();
                }
                else {
                    $(this).hide();
                }
            }
        });
        if($input.val()=="all") {
            $rows= $('table.table tbody tr'); $rows.show();
        }
    });

    $('.filterable .filters input').keyup(function(e){
        /* Ignore tab key */
        var code = e.keyCode || e.which;
        if (code == '9') return;
        //exclude datepicker
        if ($('input[name=start]').is(":focus")) return;
        if ($('input[name=end]').is(":focus")) return;

        /* Useful DOM data and selectors */
        var $input = $(this),
            inputContent = $input.val().toLowerCase(),
            $panel = $input.parents('.filterable'),
            column = $panel.find('.filters th').index($input.parents('th')),
            $table = $panel.find('.table'),
            $rows = $table.find('tbody tr');

        /* Dirtiest filter function ever ;) */
        var $filteredRows = $rows.filter(function(){
            var value = $(this).find('td').eq(column).text().toLowerCase();
            return value.indexOf(inputContent) === -1;
        });

        /* Clean previous no-result if exist */
        $table.find('tbody .no-result').remove();
        $rows.show();
        $filteredRows.hide();
        /* Prepend no-result row if all rows are filtered */
        if ($filteredRows.length === $rows.length) {
            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">No result found</td></tr>'));
        }
    });
});
