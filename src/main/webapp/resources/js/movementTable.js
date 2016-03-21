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

    //фильтр по типу приказа
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

    //фильтр по вхождению
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

    /***
     * Datepicker фильтр
     */

    //инициализаци€
    $('.input-daterange').datepicker({
        format: "yyyy-mm-dd",
        language: "ru"
    });

    //фильтр текущий мес€ц
    $('#btn-movement-datepicker-m').click(function(){
        var d = new Date();
        var day = 1;
        var year = d.getYear() + 1900;
        var month = d.getMonth();
        month++;
        var lastDayOfMonth = new Date(year, month, day);
        var lastDay = lastDayOfMonth.getUTCDate();
        var month_start = new Date(year,month-1,1);
        var formated_date_ms = moment(month_start).format("YYYY-MM-DD");
        var month_end = new Date(year,month-1,lastDay);
        var formated_date_md = moment(month_end).format("YYYY-MM-DD");
        $('input[name=start]').val(formated_date_ms);
        $('input[name=end]').val(formated_date_md);
    });

    //фильтр текущий год
    $('.btn-movement-datepicker-y button').click(function(){
        var d = new Date();
        var year = d.getYear() + 1900;
        var month = d.getMonth();
        var year_start = new Date(year,0,1);
        var formated_date_ys = moment(year_start).format("YYYY-MM-DD");
        var year_end = new Date(year,11,31);
        var formated_date_yd = moment(year_end).format("YYYY-MM-DD");
        $('input[name=start]').val(formated_date_ys);
        $('input[name=end]').val(formated_date_yd);
    });

    //сброс фильтра
    $('.date-filter-clean button').click(function(){
        $('input[name=start]').val("");
        $('input[name=end]').val("");
        var $rows = $('tbody tr'); $rows.show();
    });

    //функци€ фильтровки данных
    $('.date-filter button').click(function(){
        var from_date = $('input[name=start]').val();
        var to_date = $('input[name=end]').val();
        $('table tr').each(function(){
            var date = $(this).find('td').eq(0).text().trim();

            if(date.length && from_date.length && to_date.length){

                var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})/
                dateElements = date.match(pattern),
                    day = dateElements[3],
                    month = dateElements[2],
                    year = dateElements[1];
                var d = new Date(year,month-1,day);

                var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})/
                dateElements = from_date.match(pattern),
                    day = dateElements[3],
                    month = dateElements[2],
                    year = dateElements[1];
                var fromDate = new Date(year, month - 1, day);

                var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})/
                dateElements = to_date.match(pattern),
                    day = dateElements[3],
                    month = dateElements[2],
                    year = dateElements[1];
                var toDate = new Date(year, month - 1, day);

                if (fromDate.getTime() <= d.getTime() &&
                    d.getTime() <= toDate.getTime())
                {
                    $(this).show();
                }
                else {
                    $(this).hide();
                }
            }

        });
    });

});
