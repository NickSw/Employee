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
            position: relative;
        }
        .panel-body{
            position: absolute;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Сотрудники </b><a href="/getAllMovements">Движения по сотрудникам </a><a href="/getAllOrderTypes"> Типы приказов</a></div>
                <div align="right"><a href="createEmployee">Добавить нового сотрудника</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty employeeList}">
                There are no Employees
            </c:if>
            <c:if test="${not empty employeeList}">   
            
            	<form action="searchEmployee">
            		<div class="row">
					  <div class="col-md-4">Поиск сотрудников: <input type='text' name='searchName' id='searchName'/> </div>
					  <div class="col-md-4"><input class="btn btn-success" type='submit' value='Поиск'/></div>
					</div>
            	</form>         	
            	            	
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Id</th>
                        <th>ФИО</th>
                        <th>Телефон</th>
                        <th>Адрес</th>
                        <th>ВУЗ</th>
                        <th>Специальность</th>
                        <th>Дата рождения</th>
                        <th>Идент. код</th>
                        <th>Паспорт</th>
                        <th>Должность 1</th>
                        <th>Должность 2</th>
                        <th>Почта</th>
                        <th>Где работает</th>
                        <th>Тип оформления</th>
                        <th>Дети до 16 лет</th>
                        <th>Дата зачисления</th>
                        <th>Приказ о зачислении</th>
                        <th>Дата приказа о зачисл.</th>
                        <th>Трудовая книжка</th>
                        <th>Примечания</th>
                        <th>Редактировать</th>
                        <th>Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeList}" var="emp">
                        <tr>
                        	<th><c:out value="${emp.id}"/></th>
                        	<th><c:out value="${emp.name}"/></th>
                            <th><c:out value="${emp.phone}"/></th>
                            <th><c:out value="${emp.address}"/></th>
                            <th><c:out value="${emp.study}"/></th>
                            <th><c:out value="${emp.speciality}"/></th>
                            <th><c:out value="${emp.birthday}"/></th>
                            <th><c:out value="${emp.code}"/></th>
                            <th><c:out value="${emp.passport}"/></th>
                            <th><c:out value="${emp.position1}"/></th>
                            <th><c:out value="${emp.position2}"/></th>
                            <th><c:out value="${emp.mail}"/></th>
                            <th><c:out value="${emp.workplace}"/></th>
                            <th><c:out value="${emp.decortype}"/></th>
                            <th><c:out value="${emp.children}"/></th>
                            <th><c:out value="${emp.enrolldate}"/></th>
                            <th><c:out value="${emp.enrollorder}"/></th>
                            <th><c:out value="${emp.enrollorderdate}"/></th>
                            <th><c:out value="${emp.recofservice}"/></th>
                            <th><c:out value="${emp.notes}"/></th>
                        	<th><a href="editEmployee?id=<c:out value='${emp.id}'/>">Редактировать</a></th>
                        	<th><a href="deleteEmployee?id=<c:out value='${emp.id}'/>">Удалить</a></th>
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