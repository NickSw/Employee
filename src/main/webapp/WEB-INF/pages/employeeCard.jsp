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
  <link rel="stylesheet" type="text/css" href="/resources/css/form.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
<body>
<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h4 class="modal-title" id="myModalLabel">Информация о сотруднике</h4>
</div>
<div class="modal-body">
  <form:form data-target="#getEmployee" cssClass="form-horizontal" modelAttribute="employee">
    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="name" >ФИО</form:label> </div>
      <div class="control-label col-xs-3">
         <form:label path="name" ><c:out value="${employeeObject.name}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="phone" >Телефон</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="phone" ><c:out value="${employeeObject.phone}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="address" >Адрес</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="address" ><c:out value="${employeeObject.address}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="study" >ВУЗ</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="study" ><c:out value="${employeeObject.study}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="speciality" >Специальность</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="speciality" ><c:out value="${employeeObject.speciality}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="birthday" >Дата Рождения</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="birthday" ><c:out value="${employeeObject.birthday}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="code" >Идент. код</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="code" ><c:out value="${employeeObject.code}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="passport" >Паспорт</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="passport" ><c:out value="${employeeObject.passport}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="position1" >Должность 1</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="position1" ><c:out value="${employeeObject.position1}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="position2" >Должность 2</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="position2" ><c:out value="${employeeObject.position2}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="mail" >Почта</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="mail" ><c:out value="${employeeObject.mail}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="workplace" >Где работает</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="workplace" ><c:out value="${employeeObject.workplace}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="decortype" >Тип оформления</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="decortype" ><c:out value="${employeeObject.decortype}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="children" >Дети до 16 лет</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="children" ><c:out value="${employeeObject.children}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="enrolldate" >Дата зачисления</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="enrolldate" ><c:out value="${employeeObject.enrolldate}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="enrollorder" >Приказ о зачислении</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="enrollorder" ><c:out value="${employeeObject.enrollorder}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="enrollorderdate" >Дата приказа о зачисл.</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="enrollorderdate" ><c:out value="${employeeObject.enrollorderdate}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="recofservice" >Трудовая книжка</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="recofservice" ><c:out value="${employeeObject.recofservice}"/></form:label>
      </div>
    </div>

    <div class="form-group">
      <div class="control-label col-xs-3"> <form:label path="notes" >Примечания</form:label> </div>
      <div class="control-label col-xs-3">
        <form:label path="notes" ><c:out value="${employeeObject.notes}"/></form:label>
      </div>
    </div>
    <div class="modal-footer">
      <button type="button" id="clearEmpForm" class="btn btn-default" data-dismiss="modal">Закрыть</button>
    </div>
  </form:form>
</div>
</body>
</html>