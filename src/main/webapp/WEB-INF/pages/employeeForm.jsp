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
    <h4 class="modal-title" id="myModalLabel">Информация о сотруднике</h4>
</div>
<div class="modal-body">
    <form:form data-toggle="validator" role="form" data-target="#editEmployee" cssClass="form-horizontal" modelAttribute="employee" method="post" action="saveEmployee">

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="name" >ФИО *</form:label> </div>
            <div class="col-xs-6">
                <form:hidden path="id" value="${model.employee.id}"/>
                <form:input cssClass="form-control" path="name" value="${model.employee.name}" required="required"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="phone" >Телефон</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="phone" value="${model.employee.phone}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="mail" >Почта</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="mail" value="${model.employee.mail}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="position1" >Должность 1</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="position1" value="${model.employee.position1}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="position2" >Должность 2</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="position2" value="${model.employee.position2}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="workplace" >Где работает</form:label> </div>
            <div class="col-xs-6">
                <form:select class="form-control" path="workplace" value="${model.employee.workplace}">
                        <option><c:out value="${model.employee.workplace}"/></option>
                    <c:forEach items="${model.workPlaceList}" var="wp">
                        <c:if test="${model.employee.workplace != wp.place}">
                            <option><c:out value="${wp.place}"/></option>
                        </c:if>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="birthdayString" >Дата Рождения</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="birthdayString" value="${model.employee.birthday}"
                            pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"/>
                <span class="help-block">ГГГГ-ММ-ДД</span>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="children" >Дети до 16 лет</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="children" value="${model.employee.children}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="address" >Адрес</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="address" value="${model.employee.address}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="study" >ВУЗ</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="study" value="${model.employee.study}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="speciality" >Специальность</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="speciality" value="${model.employee.speciality}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="code" >Идент. код</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="code" value="${model.employee.code}" pattern="\d+"/>
                <span class="help-block">Только числа</span>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="passport" >Паспорт</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="passport" value="${model.employee.passport}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="decortype" >Тип оформления</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="decortype" value="${model.employee.decortype}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="enrolldate" >Дата зачисления</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="enrolldateString" value="${model.employee.enrolldate}"
                            pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"/>
                <span class="help-block">ГГГГ-ММ-ДД</span>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="enrollorder" >Приказ о зачислении</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="enrollorder" value="${model.employee.enrollorder}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="enrollorderdate" >Дата приказа о зачисл.</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="enrollorderdateString" value="${model.employee.enrollorderdate}"
                            pattern="^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$"/>
                <span class="help-block">ГГГГ-ММ-ДД</span>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="recofservice" >Трудовая книжка</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="recofservice" value="${model.employee.recofservice}"/>
            </div>
        </div>

        <div class="form-group">
            <div class="control-label col-xs-3"> <form:label path="notes" >Примечания</form:label> </div>
            <div class="col-xs-6">
                <form:input cssClass="form-control" path="notes" value="${model.employee.notes}"/>
            </div>
        </div>
        <div class="modal-footer">
            <div class="footer-text">* - Обязательные поля</div>
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