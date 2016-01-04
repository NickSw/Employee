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
    <script src="/resources/js/modernizr.custom.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
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
                <li><a class="icon icon-data" href="/getAllOrderTypes">Типы приказов</a></li>
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
                            <button class="btn btn-default btn-xs"><span class="fa fa-user-plus"></span> Добавить сотрудника</button>
                            <div class="pull-right">
                                <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Фильтр</button>
                            </div>
                        </div>
                        <div class="panel-body to-scroll">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr class="filters">
                                    <th><input type="text" class="form-control" placeholder="ФИО" disabled></th>
                                    <th>Телефон</th>
                                    <th>Адрес</th>
                                    <th>ВУЗ</th>
                                    <th>Специальность</th>
                                    <th><input type="text" class="form-control" placeholder="Дата рождения" disabled></th>
                                    <th>Идент. код</th>
                                    <th>Паспорт</th>
                                    <th><input type="text" class="form-control" placeholder="Должность 1" disabled></th>
                                    <th><input type="text" class="form-control" placeholder="Должность 2" disabled></th>
                                    <th>Почта</th>
                                    <th><input type="text" class="form-control" placeholder="Где работает" disabled></th>
                                    <th>Тип оформления</th>
                                    <th>Дети до 16 лет</th>
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
                                        <th><c:out value="${emp.name}"/></th>
                                        <th><c:out value="${emp.phone}"/></th>
                                        <th><c:out value="${emp.address}"/></th>
                                        <th><c:out value="${emp.study}"/></th>
                                        <th><c:out value="${emp.speciality}"/></th>
                                        <th><c:out value="${emp.birthday}"/></th>
                                        <th><c:out value="${emp.code}"/></th>
                                        <th><c:out value="${emp.passport}"/></th>
                                        <th><c:out value="${emp.position1}"/></th>
                                        <th><c:out value="${emp.position2}"/></th>
                                        <th><c:out value="${emp.mail}"/></th>
                                        <th><c:out value="${emp.workplace}"/></th>
                                        <th><c:out value="${emp.decortype}"/></th>
                                        <th><c:out value="${emp.children}"/></th>
                                        <th><c:out value="${emp.enrolldate}"/></th>
                                        <th><c:out value="${emp.enrollorder}"/></th>
                                        <th><c:out value="${emp.enrollorderdate}"/></th>
                                        <th><c:out value="${emp.recofservice}"/></th>
                                        <th><c:out value="${emp.notes}"/></th>
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

</body>
</html>