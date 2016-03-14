<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Nick Lebedev">
<link rel="stylesheet" type="text/css" href="/resources/css/table.css" />
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Employee Information</title>
  <!-- Bootstrap CSS -->
  <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="/resources/css/form.css" />
  <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
<body>
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h4 class="modal-title" id="myModalLabel">Информация о движении</h4>
</div>
<div class="modal-body">
  <form:form id="movementRegisterForm" data-toggle="validator" role="form" data-target="#editMovement" cssClass="form-horizontal" modelAttribute="movement" method="post" action="saveMovement">

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="orderdate" >Дата приказа *</form:label> </div>
      <div class="col-xs-6">
        <form:hidden path="id" value="${model.movement.id}"/>
        <form:input cssClass="form-control" path="orderdate" value="${model.movement.orderdate}"
                    required="required" pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"/>
        <span class="help-block">ГГГГ-ММ-ДД</span>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordernum" >Номер приказа</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="ordernum" value="${model.movement.ordernum}"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordertype" >Тип приказа</form:label> </div>
      <div class="col-xs-6">
        <form:select class="form-control" path="ordertype" value="${model.movement.ordertype}">
          <c:forEach items="${model.orderTypeList}" var="ord">
            <option><c:out value="${ord.ordertype}"/></option>
          </c:forEach>
        </form:select>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="fio" >ФИО</form:label> </div>
      <div class="col-xs-6">
        <form:select class="form-control" path="fio" value="${model.movement.fio}">
          <c:forEach items="${model.employeeList}" var="emp">
          <option><c:out value="${emp.name}"/></option>
          </c:forEach>
        </form:select>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="ordertext" >Текст приказа</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control" path="ordertext" value="${model.movement.ordertext}"/>
      </div>
    </div>
    <div class="modal-footer">
      <div class="footer-text">* - Обязательные поля</div>
      <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
      <input type="submit" id="saveMovement" class="btn btn-primary" value="Сохранить"/>
    </div>
  </form:form>
</div>
</body>
</html>