<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
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
  <!--Data Tables Bootstrap css-->
  <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
  <!--Date Picker 1.6.0 Bootstrap css-->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker3.min.css">

</head>
<body>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
</form><!--Скрытая форма выхода из сессии-->

<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div><!--Модальное окно логина-->

<div class="modal fade" id="changePassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div><!--Модальное окно замены пароля-->

<div class="modal fade" id="editMovement" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div><!--Модальное окно создания/редактирования-->

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
</div><!--Модальное окно подтверждения удаления-->

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

<div class="modal fade" id="modalImport" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabelImport">Выберите таблицу</h4>
      </div>
      <div class="modal-body form-horizontal">
        <form:form modelAttribute="fileBean" cssclass="importForm" method="post" action="" enctype="multipart/form-data">
          <div class="form-group">
            <div class="col-xs-6">
              <select class="form-control" id="#importSelect">
                <option value="default">Выберите таблицу</option>
                <option value="employee">Сотрудники</option>
                <option value="ordertype">Типы приказов</option>
                <option value="workplace">Место работы</option>
                <option value="movement">Приказы по сотрудникам</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-xs-6"><form:input path="fileData" id="browseImport" type="file" value="Выберите файл" data-filename-placement="inside"/></div>
          </div>
        </form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
        <a class="btn btn-default modalSubmit">Импорт</a>
      </div>
    </div>
  </div>
</div><!--Модальное окно выбора импортируемой таблицы-->

<div id="st-container" class="st-container">
  <div class="st-pusher">
    <nav class="st-menu st-effect-8" id="menu-8">
      <h2 class="icon icon-stack">Меню</h2>
      <ul>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
          <li>
            <a class="icon icon-user" href="/login"  data-toggle="modal" data-target="#login">Начать редактир.</a>
          </li>
        </c:if>
        <li><a class="icon icon-data" href="/getAllOrderTypes">Типы приказов</a></li>
        <li><a class="icon icon-data" href="/getAllWorkPlaces">Место работы</a></li>
        <li><a class="icon icon-data" href="/getAllMovements">Приказы по сотрудникам</a></li>
        <li><a class="icon icon-data" href="/getAllEmployeesArchive">Откр. архив данных сотрудникам</a></li>
        <li><a class="icon icon-data" href="/getAllMovementsArchive">Откр. архив приказов по сотрудникам</a></li>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li><a class="icon icon-pen" href="#" data-toggle="modal" data-target="#modalImport">Импорт данных из MS Excel</a></li>
        </c:if>
        <li><a class="icon icon-pen" href="#" data-toggle="modal" data-target="#modalExport">Экспорт данных в MS Excel</a></li>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li><a class="icon icon-pen changePassword" href="#">Замена и восст. пароля</a></li>
        </c:if>
        <li><a class="icon icon-study" href="/help">Помощь</a></li>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <li>
            <a class="icon icon-lock" href="javascript:formSubmit()">Закончить редактир.</a>
          </li>
        </c:if>
      </ul>
    </nav>

    <div class="st-content hide-overflow">
      <div class="st-content-inner">
        <!-- Верхняя навигация -->
        <div class="codrops-top clearfix">
          <div id="st-trigger-effects">
            <button data-effect="st-effect-8" class="btn-menu" data-toggle="tooltip" title="Открыть меню"><span class="fa fa-plus" ></span>&nbsp;Меню</button>
            <div class="table-name">
              <h3>
                Приказы по сотрудникам
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                  (Редактирование)
                </c:if>
              </h3>
            </div>
            <div class="btn-home"><a href="/getAllEmployees"><button class="btn-menu" data-toggle="tooltip" title="На главную таблицу сотрудников"><span class="fa fa-home"></span>&nbsp;База сотрудников</button></a></div>
          </div>
        </div>

      </div>
      <div class="container-fluid">
        <div class="row">
          <div class="panel panel-primary filterable">
            <div class="panel-heading">
              <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="btn btn-default btn-xs" data-title="Create" data-toggle="modal" data-target="#editMovement" href="/createMovement"><span class="fa fa-user-plus"></span> Добавить приказ</a>
              </c:if>
              <div class="pull-right">
                <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Фильтр</button>
              </div>
            </div>
            <div class="panel-body to-scroll" id="content">
              <table class="table table-bordered table-hover table-striped">
                <thead>
                <tr class="filters">
                  <th>
                    <div id="movement-datepicker">
                    <div class="input-daterange input-group col-xs-12" id="datepicker1">
                      <input type="text" class="input-sm form-control" name="start"/>
                      <span class="input-group-addon">по</span>
                      <input type="text" class="input-sm form-control" name="end"/>
                    </div>
                    <div class="btn-movement-datepicker-m">
                      <button class="btn btn-default btn-sm" id="btn-movement-datepicker-m">Текущий месяц</button>
                        <div class="btn-movement-datepicker-y">
                          <button class="btn btn-default btn-sm">Текущий год</button>
                        </div>
                        <div class="date-filter">
                          <button class="btn btn-default btn-sm">Фильтровать</button>
                          <div class="date-filter-clean">
                            <button class="btn btn-default btn-sm">Сброс фильтра</button>
                          </div>
                        </div>
                    </div>
                    </div>
                    <div class="movement-datename" id="movement-datename">Дата приказа</div>
                  </th>
                  <th>Номер приказа</th>
                  <th>
                    <div class="row" id="ordertypepicker">
                      <div class="col-sm-12">
                        <select class="input form-control" id="ordertypevalue">
                          <option value="all">Все</option>
                          <c:forEach items="${model.orderTypeList}" var="ord">
                            <option value="${ord.ordertype}"><c:out value="${ord.ordertype}"/></option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>
                    <div class="ordertype-name" id="ordertypename">Тип приказа</div>
                  </th>
                  <th><input type="text" class="form-control" placeholder="ФИО" disabled></th>
                  <th>Текст приказа</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${model.movementList}" var="mov">
                  <tr>
                    <td>
                      <c:if test="${pageContext.request.userPrincipal.name != null}">
                      <p data-placement="top" data-toggle="tooltip" title="Изменить" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs triggerEdit" data-title="Edit" data-toggle="modal" data-target="#editMovement" href="/editMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Удалить" class="btn-disp"><a class="btn btn-opt btn-danger btn-xs triggerDelete"  href="/deleteMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Перенести в архив" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs triggerArchive" href="/archiveMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-floppy-disk"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Скопировать запись" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs triggerCopy" href="/copyMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-copy"></span></a></p>
                      </c:if>
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
<!--Moment js w locales-->
<script language="JavaScript" src="http://momentjs.com/downloads/moment-with-locales.js" type="text/javascript"></script>
<!--Bootstrap 3.3.6 js-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!--Date Picker 1.6.0 js-->
<script language="JavaScript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<!--Date Picker 1.6.0 locale ru js-->
<script language="JavaScript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/locales/bootstrap-datepicker.ru.min.js" type="text/javascript"></script>
<!--Data Tables 1.10.4 js-->
<script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
<!--Data Tables bootstrap js-->
<script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
<!--Modernizr js-->
<script src="/resources/js/modernizr.custom.js"></script>
<!--Classie js-->
<script src="/resources/js/classie.js"></script>
<!--Sidebar Effects js-->
<script src="/resources/js/sidebarEffects.js"></script>
<!--Movement table js-->
<script src="/resources/js/movementTable.js"></script>
<!--Triggers(delete)-->
<script src="/resources/js/triggers.js"></script>
<!--Dropdown Export table js-->
<script src="/resources/js/dropdownExport.js"></script>
<!--Import table js-->
<script src="/resources/js/importTable.js"></script>
<!--Page security js-->
<script src="/resources/js/security.js"></script>

</body>
<script>

</script>
</html>