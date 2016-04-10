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
  <h4 class="modal-title" id="myModalLabel">Замена пароля</h4>
</div>
<div class="modal-body">
  <form:form data-toggle="validator" role="form" data-target="#changePassword" cssClass="form-horizontal" modelAttribute="admin" method="post" action="saveNewPassword">

    <div class="form-group has-error" id="result">
      <label for="inputError" class="col-sm-6 control-label"></label>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="name" >Старый пароль</form:label> </div>
      <div class="col-xs-6">
        <form:hidden path="id" value="${adminObject.id}"/>
        <form:hidden path="name" value="${adminObject.name}"/>
        <input type="password" class="form-control old-pass-field" id="inputError"/>
        <!--Обычный инпут который сравнивается со старым паролем-->
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="password" >Новый пароль</form:label> </div>
      <div class="col-xs-6">
        <input type="password" class="form-control new-pass-1"/>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="password" >Подтвердите пароль</form:label> </div>
      <div class="col-xs-6">
        <form:input cssClass="form-control new-pass-2 pass-from-db" path="password" type="password" value="${adminObject.password}"/>
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

<script type="text/javascript">
  $(document).ready(function() {

    var passFromDb = $('.pass-from-db').val();
    $('.pass-from-db').val("");

    $('form').on('submit', function(e){
      var oldPassField = $('.old-pass-field').val();
      var newPass1 = $('.new-pass-1').val();
      var newPass2 = $('.new-pass-2').val();

      //не пустые поля
      if (newPass1 == "" || newPass2 == "" || oldPassField == ""){
        e.preventDefault();
        $('#result label').html("Поля не должны быть пустыми");
      }

      //правильный старый пароль
      if (passFromDb != oldPassField){
        e.preventDefault();
        $('#result label').html("Неверный пароль");
      }

      //совпадение паролей
      if (newPass1 != newPass2){
        e.preventDefault();
        $('#result label').html("Пароли не совпадают");
      }

    });
  });


</script>
</body>
</html>