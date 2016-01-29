<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee DB</title>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="/resources/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/icons.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/table.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/nautilus-font.css" />
    <script src="/resources/js/modernizr.custom.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
</head>
<body>
<div class="modal fade" id="editEmployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
        </div>
    </div>
</div><!--Modal window edit employee-->
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Удаление сотрудника</h4>
            </div>
            <div class="modal-body">
                Удалить сотрудника?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                <a href="" class="btn btn-danger deleteBtn">Удалить</a>
            </div>
        </div>
    </div>
</div>
<!-- Modal window delete confirmation-->
<div id="st-container" class="st-container">
    <div class="st-pusher">
        <!--
            example menus
            these menus will be under the push wrapper
        -->
        <nav class="st-menu st-effect-8" id="menu-8">
            <h2 class="icon icon-stack">Меню</h2>
            <ul>
                <li><a class="icon icon-user" href="#">Начать редактир.</a></li>
                <li><a class="icon icon-data" href="/getAllOrderTypes" id="menuOrderTypes">Типы приказов</a></li>
                <li><a class="icon icon-data" href="/getAllMovements">Движ. по сотрудникам</a></li>
                <li><a class="icon icon-data" href="#">Сохр. архив по сотрудникам</a></li>
                <li><a class="icon icon-data" href="#">Откр. архив по сотрудникам</a></li>
                <li><a class="icon icon-data" href="#">Откр. архив по движ. по сотрудникам</a></li>
                <li><a class="icon icon-pen" href="#">Перенос данных в MS Excel</a></li>
                <li><a class="icon icon-pen" href="#">Перенос данных из MS Excel</a></li>
                <li><a class="icon icon-study" href="#">Помощь</a></li>
                <li><a class="icon icon-lock" href="#">Закончить редактир.</a></li>
            </ul>
        </nav>

        <div class="st-content hide-overflow"><!-- this is the wrapper for the content -->
            <div class="st-content-inner"><!-- extra div for emulating position:fixed of the menu -->
                <!-- Top Navigation -->
                <div class="codrops-top clearfix">
                    <div id="st-trigger-effects">
                        <button data-effect="st-effect-8" class="btn-menu"  style="color: #fff; font-size: 1.2em;"><span class="fa fa-plus"></span>&nbsp;Меню</button>
                        <div class="table-name"><h3>Сотрудники</h3></div>
                        <button class="btn-menu" style="color: #fff; font-size: 1.2em; float: right;"><span class="fa fa-home"></span>&nbsp;Возврат</button>
                    </div>
                </div>

            </div><!-- /main -->
            <div class="container-fluid">
                <div class="row">
                    <div class="panel panel-primary filterable">
                        <div class="panel-heading">
                            <a class="btn btn-default btn-xs" data-title="Create" data-toggle="modal" data-target="#editEmployee" href="/createEmployee"><span class="fa fa-user-plus"></span> Добавить сотрудника</a>
                            <div class="pull-right">
                                <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Фильтр</button>
                            </div>
                        </div>
                        <div class="panel-body to-scroll" id="content">
                            <table class="table table-bordered table-hover table-striped" id="datatable">
                                <thead>
                                <tr class="filters">
                                    <th><input type="text" class="form-control" placeholder="ФИО" disabled></th>
                                    <th>Телефон</th>
                                    <th>Адрес</th>
                                    <th>ВУЗ</th>
                                    <th>Специальность</th>
                                    <th>
                                        <div class="row" id="datepicker">
                                            <div class="col-sm-12">
                                                <select class="input form-control" id="datevalue">
                                                    <option value="all">Все</option>
                                                    <option value="01">Январь</option>
                                                    <option value="02">Февраль</option>
                                                    <option value="03">Март</option>
                                                    <option value="04">Апрель</option>
                                                    <option value="05">Май</option>
                                                    <option value="06">Июнь</option>
                                                    <option value="07">Июль</option>
                                                    <option value="08">Август</option>
                                                    <option value="09">Сентябрь</option>
                                                    <option value="10">Октябрь</option>
                                                    <option value="11">Ноябрь</option>
                                                    <option value="12">Декабрь</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="birth-name" id="datename">Дата рождения</div>
                                    </th>
                                    <th>Идент. код</th>
                                    <th>Паспорт</th>
                                    <th><input type="text" class="form-control" placeholder="Должность 1" disabled></th>
                                    <th><input type="text" class="form-control" placeholder="Должность 2" disabled></th>
                                    <th>Почта</th>
                                    <th><input type="text" class="form-control" placeholder="Где работает" disabled></th>
                                    <th>
                                        <div class="row" id="orderpicker">
                                            <div class="col-sm-12">
                                                <select class="input form-control" id="ordervalue">
                                                    <option value="all">Все</option>
                                                    <option value="Осн">Осн</option>
                                                    <option value="Совм">Совм</option>
                                                    <option value="Б/о">Б/о</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="order-name" id="ordername">Тип оформления</div>
                                    </th>
                                    <th>
                                        <div class="row" id="childpicker">
                                            <div class="col-sm-12">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" id="childcheck"> Есть дети
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="child-name" id="childname">Дети до 16 лет</div>
                                    </th><!--Не пустое-->
                                    <th>Дата зачисления</th>
                                    <th>Приказ о зачислении</th>
                                    <th>Дата приказа о зачисл.</th>
                                    <th>Трудовая книжка</th>
                                    <th>Примечания</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${employeeList}" var="emp">
                                    <tr>
                                        <td>
                                            <p data-placement="top" data-toggle="tooltip" title="Edit" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#editEmployee" href="editEmployee?id=<c:out value='${emp.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></p>
                                            <p data-placement="top" data-toggle="tooltip" title="Delete" class="btn-disp"><a class="btn btn-opt btn-danger btn-xs triggerDelete"  href="deleteEmployee?id=<c:out value='${emp.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></p>
                                            <c:out value="${emp.name}"/>
                                        </td>
                                        <td><c:out value="${emp.phone}"/></td>
                                        <td><c:out value="${emp.address}"/></td>
                                        <td><c:out value="${emp.study}"/></td>
                                        <td><c:out value="${emp.speciality}"/></td>
                                        <td><c:out value="${emp.birthday}"/></td>
                                        <td><c:out value="${emp.code}"/></td>
                                        <td><c:out value="${emp.passport}"/></td>
                                        <td><c:out value="${emp.position1}"/></td>
                                        <td><c:out value="${emp.position2}"/></td>
                                        <td><c:out value="${emp.mail}"/></td>
                                        <td><c:out value="${emp.workplace}"/></td>
                                        <td><c:out value="${emp.decortype}"/></td>
                                        <td><c:out value="${emp.children}"/></td>
                                        <td><c:out value="${emp.enrolldate}"/></td>
                                        <td><c:out value="${emp.enrollorder}"/></td>
                                        <td><c:out value="${emp.enrollorderdate}"/></td>
                                        <td><c:out value="${emp.recofservice}"/></td>
                                        <td><c:out value="${emp.notes}"/></td>
                                    </tr>

                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div><!-- /table -->
        </div><!-- /st-content-inner -->
    </div><!-- /st-content -->
</div><!-- /st-pusher -->
</div><!-- /st-container -->
<script src="/resources/js/classie.js"></script>
<script src="/resources/js/sidebarEffects.js"></script>
<script src="/resources/js/table.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#datatable').DataTable( {
            "paging":   false,
            "info":     false,
            "searching": false,
            "columnDefs": [
                { "orderable": false, "targets": [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 ] }
            ]
        } );

        $(".triggerDelete").click(function(e) {
            e.preventDefault();
            $("#modalDelete .deleteBtn").attr("href", $(this).attr("href"));
            $('#modalDelete').modal();
        });
    } );
</script>
</body>
</html>