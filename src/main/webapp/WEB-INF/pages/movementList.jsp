<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Employees List</title>
  <!-- Bootstrap CSS -->
  <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <style type="text/css">
    .myrow-container {
      margin: 20px;
    }
    .panel-body{
    }
  </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
  <div class="panel panel-success">
    <div class="panel-heading">
      <h3 class="panel-title">
        <div align="left"><b>Движения по сотрудникам </b> <a href="/getAllEmployees"> Сотрудники</a> <a href="/getAllOrderTypes"> Типы приказов</a></div>
        <div align="right"><a href="/createMovement">Добавить новое движение</a></div>
      </h3>
    </div>
    <div class="panel-body">
      <c:if test="${empty movementList}">
        There are no Movements
      </c:if>
      <c:if test="${not empty movementList}">

        <form action="/searchMovement">
          <div class="row">
            <div class="col-md-4">Поиск движений: <input type='text' name='searchName' id='searchName'/> </div>
            <div class="col-md-4"><input class="btn btn-success" type='submit' value='Поиск'/></div>
          </div>
        </form>

        <table class="table table-hover table-bordered">
          <thead style="background-color: #bce8f1;">
          <tr>
            <th>Id</th>
            <th>Дата приказа</th>
            <th>Номер приказа</th>
            <th>Тип приказа</th>
            <th>ФИО</th>
            <th>Текст приказа</th>
            <th>Редактировать</th>
            <th>Удалить</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${movementList}" var="mov">
            <tr>
              <th><c:out value="${mov.id}"/></th>
              <th><c:out value="${mov.orderdate}"/></th>
              <th><c:out value="${mov.ordernum}"/></th>
              <th><c:out value="${mov.ordertype}"/></th>
              <th><c:out value="${mov.fio}"/></th>
              <th><c:out value="${mov.ordertext}"/></th>
              <th><a href="/editMovement?id=<c:out value='${mov.id}'/>">Редактировать</a></th>
              <th><a href="/deleteMovement?id=<c:out value='${mov.id}'/>">Удалить</a></th>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
   --%>


</body>
</html>