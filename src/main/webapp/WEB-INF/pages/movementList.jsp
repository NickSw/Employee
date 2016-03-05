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
  <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
  <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
</head>
<body>
<div class="modal fade" id="editMovement" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div><!--Modal window edit movement-->
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
        <li><a class="icon icon-data" href="/getAllEmployeesArchive">Откр. архив по сотрудникам</a></li>
        <li><a class="icon icon-data" href="/getAllMovementsArchive">Откр. архив по движ. по сотрудникам</a></li>
        <li><a class="icon icon-pen" href="#">Импорт данных из MS Excel</a></li>
        <li><a class="icon icon-pen" href="#">Экспорт данных в MS Excel</a></li>
        <li><a class="icon icon-study" href="#">Помощь</a></li>
        <li><a class="icon icon-lock" href="#">Закончить редактир.</a></li>
      </ul>
    </nav>

    <div class="st-content hide-overflow"><!-- this is the wrapper for the content -->
      <div class="st-content-inner"><!-- extra div for emulating position:fixed of the menu -->
        <!-- Top Navigation -->
        <div class="codrops-top clearfix">
          <div id="st-trigger-effects">
            <button data-effect="st-effect-8" class="btn-menu"  style="color: #fff; font-size: 1.2em;" data-toggle="tooltip" title="Открыть меню"><span class="fa fa-plus" ></span>&nbsp;Меню</button>
            <div class="table-name"><h3>Движения сотрудников</h3></div>
            <div style="position: absolute; right: 0%; top: 0;"><a style="padding: 0" href="/getAllEmployees"><button class="btn-menu" style="color: #fff; font-size: 1.2em; " data-toggle="tooltip" title="Таблица сотрудницов"><span class="fa fa-home"></span>&nbsp;Возврат</button></a></div>
          </div>
        </div>

      </div><!-- /main -->
      <div class="container-fluid">
        <div class="row">
          <div class="panel panel-primary filterable">
            <div class="panel-heading">
              <a class="btn btn-default btn-xs" data-title="Create" data-toggle="modal" data-target="#editMovement" href="/createMovement"><span class="fa fa-user-plus"></span> Добавить движения</a>
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
                <c:forEach items="${movementList}" var="mov">
                  <tr>
                    <td>
                      <p data-placement="top" data-toggle="tooltip" title="Изменить" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#editMovement" href="editMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-pencil"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Удалить" class="btn-disp"><a class="btn btn-opt btn-danger btn-xs triggerDelete"  href="/deleteMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-trash"></span></a></p>
                      <p data-placement="top" data-toggle="tooltip" title="Переместить в архив" class="btn-disp"><a class="btn btn-opt btn-primary btn-xs" href="/archiveMovement?id=<c:out value='${mov.id}'/>"><span class="glyphicon glyphicon-floppy-disk"></span></a></p>
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
<script src="/resources/js/classie.js"></script>
<script src="/resources/js/sidebarEffects.js"></script>
<script src="/resources/js/table.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $(".triggerDelete").click(function(e) {
      e.preventDefault();
      $("#modalDelete .deleteBtn").attr("href", $(this).attr("href"));
      $('#modalDelete').modal();
    });
  } );
</script>
</body>
</html>