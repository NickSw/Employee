<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Nick Lebedev">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Movements Information</title>
  <!-- Bootstrap CSS -->
  <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <style type="text/css">
    .myrow-container{
      margin: 20px;
    }
  </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
  <div class="panel panel-success">
    <div class="panel-heading">
      <h3 class="panel-title">
        Информация о движении
      </h3>
    </div>
    <div class="panel-body">
      <form:form id="movementRegisterForm" cssClass="form-horizontal" modelAttribute="movement" method="post" action="saveMovement">

        <div class="form-group">
          <div class="control-label col-xs-3"> <form:label path="orderdate" >Дата приказа</form:label> </div>
          <div class="col-xs-6">
            <form:hidden path="id" value="${movementObject.id}"/>
            <form:input cssClass="form-control" path="orderdate" value="${movementObject.orderdate}"/>
          </div>
        </div>

        <div class="form-group">
          <div class="control-label col-xs-3"> <form:label path="ordernum" >Номер приказа</form:label> </div>
          <div class="col-xs-6">
            <form:input cssClass="form-control" path="ordernum" value="${movementObject.ordernum}"/>
          </div>
        </div>

        <div class="form-group">
          <div class="control-label col-xs-3"> <form:label path="ordertype" >Тип приказа</form:label> </div>
          <div class="col-xs-6">
            <form:input cssClass="form-control" path="ordertype" value="${movementObject.ordertype}"/>
          </div>
        </div>

         <div class="form-group">
             <div class="control-label col-xs-3"> <form:label path="fio" >ФИО</form:label> </div>
             <div class="col-xs-6">
                 <form:input cssClass="form-control" path="fio" value="${movementObject.fio}"/>
             </div>
         </div>

          <div class="form-group">
              <div class="control-label col-xs-3"> <form:label path="ordertext" >Тип приказа</form:label> </div>
              <div class="col-xs-6">
                  <form:input cssClass="form-control" path="ordertext" value="${movementObject.ordertext}"/>
              </div>
          </div>

        <div class="form-group">
          <div class="row">
            <div class="col-xs-4">
            </div>
            <div class="col-xs-4">
              <input type="submit" id="saveMovement" class="btn btn-primary" value="Сохранить" onclick="return submitMovementForm();"/>
            </div>
            <div class="col-xs-4">
            </div>
          </div>
        </div>

      </form:form>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript">
  function submitMovementForm() {

    var orderdate = $('#orderdate').val();
    var ordernum = $('#ordernum').val();
    var ordertype =('#ordertype').val();
    var fio = ('#fio').val();
    var ordertext = ('#ordertext').val();

    if(orderdate.length ==0) {
      alert('Please enter Order Date');
      $('#orderdate').focus();
      return false;
    }

    if(ordernum.length ==0) {
      alert('Please enter Order Number');
      $('#ordernum').focus();
      return false;
    }

    if(ordertype.length ==0) {
      alert('Please enter Order Type');
      $('#ordertype').focus();
      return false;
    }

    if(fio.length ==0) {
      alert('Please enter fio');
      $('#fio').focus();
      return false;
    }

    if(ordertext.length ==0) {
       alert('Please enter Order Text');
          $('#ordertext').focus();
          return false;
      }


  };
</script>

</body>
</html>