<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
  <meta charset="UTF-8" />
  <title>Employee DB</title>

  <!--Normalize css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/normalize.css" />
  <!--Demo css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
  <!--Icons css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/icons.css" />
  <!--Component css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/component.css" />
  <!--Table css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/table.css" />
  <!--Nautilus font css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/nautilus-font.css" />
  <!--Bootstrap 3.3.6 css-->
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <!--Font Awesome 4.5.0 css-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

</head>
<body>
<div class="modal fade" id="editMovementArchive" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
<!--Модальное окно создания/редактирования-->

<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Удаление движения</h4>
      </div>
      <div class="modal-body">
        Удалить движение?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
        <a href="" class="btn btn-danger deleteBtn">Удалить</a>
      </div>
    </div>
  </div>
</div>
<!--Модальное окно подтверждения удаления-->

<div class="modal fade" id="modalClear" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabelClear">Очистка архива</h4>
      </div>
      <div class="modal-body">
        Очистить архив сотрудников?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
        <a href="/clear/movementArchive" class="btn btn-danger clearBtn">Очистить</a>
      </div>
    </div>
  </div>
</div><!--Модальное окно подтверждения очитски архива-->

<div class="modal fade" id="modalExport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabelExport">Выберите таблицу</h4>
      </div>
      <div class="modal-body">
        <form>
          <select class="input form-control" id="#exportSelect">
            <option value="default">Выберите таблицу</option>
            <option value="employee">Сотрудники</option>
            <option value="ordertype">Типы приказов</option>
            <option value="workplace">Место работы</option>
            <option value="movement">Приказы по сотрудникам</option>
          </select>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
        <a href="" class="btn btn-default exportBtn">Экспорт</a>
      </div>
    </div>
  </div>
</div><!--Модальное окно выбора экспортируемой таблицы-->

<div id="st-container" class="st-container">
  <div class="st-pusher">
    <nav class="st-menu st-effect-8" id="menu-8">
      <h2 class="icon icon-stack">Меню</h2>
      <ul>
        <li><a class="icon icon-user" href="#">Начать редактир.</a></li>
        <li><a class="icon icon-data" href="/getAllOrderTypes">Типы приказов</a></li>
        <li><a class="icon icon-data" href="/getAllWorkPlaces">Место работы</a></li>
        <li><a class="icon icon-data" href="/getAllMovements">Приказы по сотрудникам</a></li>
        <li><a class="icon icon-data" href="/getAllEmployeesArchive">Откр. архив данных сотрудникам</a></li>
        <li><a class="icon icon-data" href="/getAllMovementsArchive">Откр. архив приказов по сотрудникам</a></li>
        <li><a class="icon icon-pen" href="/upload">Импорт данных из MS Excel</a></li>
        <li><a class="icon icon-pen" href="#" data-toggle="modal" data-target="#modalExport">Экспорт данных в MS Excel</a></li>
        <li><a class="icon icon-study" href="#">Помощь</a></li>
        <li><a class="icon icon-lock" href="#">Закончить редактир.</a></li>
      </ul>
    </nav>

    <div class="st-content hide-overflow">
      <div class="st-content-inner">
        <!-- Верхняя навигация -->
        <div class="codrops-top clearfix">
          <div id="st-trigger-effects">
            <button data-effect="st-effect-8" class="btn-menu" data-toggle="tooltip" title="Открыть меню"><span class="fa fa-plus" ></span>&nbsp;Меню</button>
            <div class="table-name"><h3>Архив приказов по сотрудникам</h3></div>
            <div class="btn-home"><a href="/getAllEmployees"><button class="btn-menu" data-toggle="tooltip" title="На главную таблицу сотрудников"><span class="fa fa-home"></span>&nbsp;Возврат</button></a></div>
          </div>
        </div>

      </div>
      <div class="container-fluid">
        <div class="row">
          <div class="panel panel-primary filterable">
            <div class="panel-heading">
              <a class="btn btn-default btn-xs"  data-toggle="modal" data-target="#modalClear" ><span class="fa fa-file-archive-o"></span> Очистить архив</a>
            </div>
            <div class="panel-body to-scroll" id="content">
              <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr>
                  <th>Дата приказа</th>
                  <th>Номер приказа</th>
                  <th>Тип приказа</th>
                  <th>ФИО</th>
                  <th>Текст приказа</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${movementArchiveList}" var="mov">
                  <tr>
                    <td>
                      <p data-placement="top" data-toggle="tooltip" title="Изменить" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#editMovementArchive" href="editMovementArchive?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Удалить" class="btn-disp"><a class="btn btn-opt btn-danger btn-xs triggerDelete"  href="/deleteMovementArchive?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></p>
                      <c:out value="${mov.orderdate}"/>
                    </td>
                    <td><c:out value="${mov.ordernum}"/></td>
                    <td><c:out value="${mov.ordertype}"/></td>
                    <td><c:out value="${mov.fio}"/></td>
                    <td><c:out value="${mov.ordertext}"/></td>
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

<!--Jquery 1.11.1-->
<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<!--Bootstrap 3.3.6 js-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!--Modernizr js-->
<script src="/resources/js/modernizr.custom.js"></script>
<!--Classie js-->
<script src="/resources/js/classie.js"></script>
<!--Sidebar Effects js-->
<script src="/resources/js/sidebarEffects.js"></script>
<!--Triggers(delete)-->
<script src="/resources/js/triggers.js"></script>
<!--Dropdown Export table js-->
<script src="/resources/js/dropdownExport.js"></script>
<!--Archive Utils js-->
<script src="/resources/js/archiveUtil.js"></script>

</body>
</html>