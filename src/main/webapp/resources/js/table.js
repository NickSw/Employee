$(document).ready(function(){
    $('.filterable .btn-filter').click(function(){
        var $panel = $(this).parents('.filterable'),
            $filters = $panel.find('.filters input'),
            $tbody = $panel.find('.table tbody');
        if ($filters.prop('disabled') == true &&
                $('#datepicker').css('display','none') &&
                $('#orderpicker').css('display','none')) {
            $filters.prop('disabled', false);
            $('#datepicker').css('display','inline-table');
            $('#datename').css('display','none');
            $('#orderpicker').css('display','inline-table');
            $('#ordername').css('display','none');
            $('#childpicker').css('display','inline-table');
            $('#childname').css('display','none');
            $filters.first().focus();
        } else {
            $filters.val('').prop('disabled', true);
            $tbody.find('.no-result').remove();
            $tbody.find('tr').show();
            $('#datepicker').css('display','none');
            $('#datename').css('display','block');
            $('#orderpicker').css('display','none');
            $('#ordername').css('display','block');
            $('#childpicker').css('display','none');
            $('#childname').css('display','block');
        }
    });

    $('#childcheck').on('click', function(){
        var secondField = false;
        $('table tr').each(function(){
            var child = $(this).find('td').eq(13).text();
                if (child.length==0 && secondField){
                    $(this).hide();
                }
                else {
                    $(this).show();
                }
            secondField = true;
        });
        if(!$('#childcheck').is(':checked')) {
            $rows= $('table.table tbody tr'); $rows.show();
        }
    });

    $('#ordervalue').change(function(){
        var $input = $(this);
        $('table tr').each(function(){
            var order = $(this).find('td').eq(12).text();
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

    $("#datevalue").change(function(){
        var $input = $(this);
        $('table tr').each(function(){
        var date = $(this).find('td').eq(5).text();
            if(date.length){
                var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})/
                dateElements = date.match(pattern),
                day = dateElements[3],
                month = dateElements[2],
                year = dateElements[1];

                if(month==$input.val()) {
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
        if ($("#childcheck").is(":focus")) return;
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
