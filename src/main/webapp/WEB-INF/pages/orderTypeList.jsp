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
        <li><a class="icon icon-data" href="#">Типы приказов</a></li>
        <li><a class="icon icon-data" href="#">Движ. по сотрудникам</a></li>
        <li><a class="icon icon-data" href="#">Сохр. архив по сотрудникам</a></li>
        <li><a class="icon icon-data" href="#">Откр. архив по сотрудникам</a></li>
        <li><a class="icon icon-data" href="#">Откр. архив по движ. по сотрудникам</a></li>
        <li><a class="icon icon-pen" href="#">Перенос данных в MS Excel</a></li>
        <li><a class="icon icon-pen" href="#">Перенос данных из MS Excel</a></li>
        <li><a class="icon icon-study" href="#">Помощь</a></li>
        <li><a class="icon icon-lock" href="#">Закончить редактир.</a></li>
      </ul>
    </nav>

    <div class="st-content" style="height: 100%; overflow: hidden"><!-- this is the wrapper for the content -->
      <div class="st-content-inner"><!-- extra div for emulating position:fixed of the menu -->
        <!-- Top Navigation -->
        <div class="codrops-top clearfix">
            <div id="st-trigger-effects">
              <button data-effect="st-effect-8" class="btn-menu" style="color: #fff; font-size: 1.2em;">Меню</button>
              <button class="btn-menu" style="color: #fff; font-size: 1.2em; float: right">Возврат</button>
            </div>
        </div>



        </div><!-- /main -->
      <div class="container-fluid" style="height: 100%; margin-top: -0.8%; margin-bottom: 0%">
        <div class="row" style="height: 95%">
          <div class="panel panel-primary filterable" style="height: 100%">
            <div class="panel-heading">
              <h3 class="panel-title">Сотрудники</h3>
              <div class="pull-right">
                <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Фильтр</button>
              </div>
            </div>
            <div class="panel-body" id="to-scroll" style="height: 95%">
              <table class="table table-bordered table-hover table-striped">
              <thead>
              <tr class="filters">
                <th><input type="text" class="form-control" placeholder="Тип приказа" disabled></th>
                <th><input type="text" class="form-control" placeholder="Примечание" disabled></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${orderTypeList}" var="ord">
                <tr>
                  <th><c:out value="${ord.ordertype}"/></th>
                  <th><c:out value="${ord.notes}"/></th>
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