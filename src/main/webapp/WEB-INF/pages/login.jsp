<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Employee DB</title>

  <!--Bootstrap 3.3.6 css-->
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
  <!--Table css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/table.css"/>
  <!--Login css-->
  <link rel="stylesheet" type="text/css" href="/resources/css/login.css"/>

</head>
<body>

<form:form role="form" modelAttribute="admin" method="post" action="saveNewPassword">
  <form:hidden path="name" cssClass="pass" value="${admin.password}"/>
</form:form>

<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <h4 class="modal-title" id="myModalLabel">Вход в систему</h4>
</div>
<div class="modal-body">

  <form class="form-horizontal" name='loginForm' id="loginForm"
        action="<c:url value='/j_spring_security_check' />" method='POST'>

    <div class="form-group has-error" id="result">
      <label for="inputEmail" class="col-sm-6 control-label"></label>

    </div>
    <div class="form-group username">
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
    <input class="sub" name="submit" type="submit"
           value="submit"/>
    <!--<input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" /> -->
  </form>

</div>
<div class="modal-footer">
  <a class="changePassword" style="float: left;"  href="#">Замена пароля</a>
  <button id="close" type="button" class="btn btn-default" data-dismiss="modal" href="/getAllEmployees">Назад</button>
  <a class="btn btn-default modalSubmit1">Вход</a>
</div>

<!--Jquery 1.11.1-->
<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<!--Bootstrap 3.3.6 js-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<!--TODO:Refactor script-->
<script>


  $(function () {
    $('body').on('click', '.modalSubmit1', function (e) {
      $('#inputEmail').val("admin");
      var passfromDb = $('.pass').val();
      $('.pass').val("");
      var passField = $('#inputPassword').val();
      if (passfromDb != passField){
        e.preventDefault();
        $('#result label').html("Неверный пароль");
      }
      if (passfromDb == passField){
        $('.modal-body form .sub').click();
        //function formSubmit() {
        document.getElementById("loginForm").submit();
        //}
      }
    });
  });


</script>
<!--  Ajax script
<script type="text/javascript">
  function crunchifyAjax() {
    $.ajax({
      url : 'ajaxtest.html',
      success : function(data) {
        $('#result').html(data);
      }
    });
  }
</script>

<script type="text/javascript">
  var intervalId = 0;
  intervalId = setInterval(crunchifyAjax, 3000);
</script>
-->
</body>
</html>