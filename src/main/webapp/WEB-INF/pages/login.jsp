<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <h4 class="modal-title" id="myModalLabel">Вход в систему</h4>
</div>
<div class="modal-body">

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <form class="form-horizontal" name='loginForm'
        action="<c:url value='/j_spring_security_check' />" method='POST'>
    <div class="form-group">
      <label for="inputEmail" class="col-sm-2 control-label">Пользователь</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="inputEmail" name='username' placeholder="Имя Пользователя">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-sm-2 control-label">Пароль</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword" name='password' placeholder="Пароль">
      </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
  </form>

</div>
<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
  <a class="btn btn-default modalSubmit" href="javascript:formSubmit()">Вход</a>
</div>

<!--Jquery 1.11.1-->
<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<!--Bootstrap 3.3.6 js-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script>
  function formSubmit() {
    document.getElementById("loginForm").submit();
  }
</script>
</body>
</html>