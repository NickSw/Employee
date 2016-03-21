<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Employee DB</title>

  <!--Bootstrap 3.3.6 css-->
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <!--Table css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/table.css"/>

</head>
<body>
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h4 class="modal-title" id="myModalLabel">Информация о движении</h4>
</div>
<div class="modal-body">
  <form:form data-toggle="validator" role="form" data-target="#editMovementArchive" cssClass="form-horizontal" modelAttribute="movementArchive" method="post" action="saveMovementArchive">

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="orderdate" >Дата приказа</form:label> </div>
      <div class="col-xs-6">
        <form:hidden path="id" value="${movementArchiveObject.id}"/>
        <form:input cssClass="form-control" path="orderdate" value="${movementArchiveObject.orderdate}"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordernum" >Номер приказа</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="ordernum" value="${movementArchiveObject.ordernum}"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordertype" >Тип приказа</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="ordertype" value="${movementArchiveObject.ordertype}"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="fio" >ФИО</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="fio" value="${movementArchiveObject.fio}"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordertext" >Тип приказа</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="ordertext" value="${movementArchiveObject.ordertext}"/>
      </div>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
      <input type="submit" class="btn btn-primary" value="Сохранить"/>
    </div>
  </form:form>
</div>

<!--Jquery 1.11.1-->
<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<!--Bootstrap 3.3.6 js-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</body>
</html>