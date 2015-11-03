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
    <title>Employee Information</title>
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
                    Информация о сотруднике
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="employee" method="post" action="saveEmployee">

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >ФИО</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${employeeObject.id}"/>
                            <form:input cssClass="form-control" path="name" value="${employeeObject.name}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="phone" >Телефон</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="phone" value="${employeeObject.phone}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="address" >Адрес</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="address" value="${employeeObject.address}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="study" >ВУЗ</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="study" value="${employeeObject.study}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="speciality" >Специальность</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="speciality" value="${employeeObject.speciality}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="birthday" >Дата Рождения</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="birthday" value="${employeeObject.birthday}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="code" >Идент. код</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="code" value="${employeeObject.code}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="passport" >Паспорт</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="passport" value="${employeeObject.passport}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="position1" >Должность 1</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="position1" value="${employeeObject.position1}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="position2" >Должность 2</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="position2" value="${employeeObject.position2}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="mail" >Почта</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="mail" value="${employeeObject.mail}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="workplace" >Где работает</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="workplace" value="${employeeObject.workplace}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="decortype" >Тип оформления</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="decortype" value="${employeeObject.decortype}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="children" >Дети до 16 лет</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="children" value="${employeeObject.children}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="enrolldate" >Дата зачисления</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="enrolldate" value="${employeeObject.enrolldate}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="enrollorder" >Приказ о зачислении</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="enrollorder" value="${employeeObject.enrollorder}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="enrollorderdate" >Дата приказа о зачисл.</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="enrollorderdate" value="${employeeObject.enrollorderdate}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="recofservice" >Трудовая книжка</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="recofservice" value="${employeeObject.recofservice}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="notes" >Примечания</form:label> </div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="notes" value="${employeeObject.notes}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveEmployee" class="btn btn-primary" value="Сохранить" onclick="return submitEmployeeForm();"/>
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
		function submitEmployeeForm() {				
			
		    // getting the employee form values
            var name = $('#name').val().trim();
            var phone = $('#phone').val;
            var address  = $('#address').val();
            var study = $('#study').val();
            var speciality = $('#speciality');
            var birthday = $('#birthday').val();
            var code = $('#code').val();
            var passport = $('#passport').val();
            var position1 = $('#position1').val();
            var position2 = $('#position2').val();
            var mail = $('#mail').val();
            var workplace = $('#workplace').val();
            var decortype = $('#decortype').val();
            var children = $('#children').val();
            var enrolldate = $('#enrolldate').val();
            var enrollorder = $('#enrollorder').val();
            var enrollorderdate = $('#enrollorderdate').val();
            var recofservice = $('#recofservice').val();
            var notes = $('#notes').val();

		    if(name.length ==0) {
		        alert('Please enter name');
		        $('#name').focus();
		        return false;
		    }

            if(phone.length ==0) {
                alert('Please enter phone');
                $('#phone').focus();
                return false;
            }

            if(address.length ==0) {
                alert('Please enter address');
                $('#address').focus();
                return false;
            }

            if(study.length ==0) {
                alert('Please enter study');
                $('#study').focus();
                return false;
            }

            if(study.length ==0) {
                alert('Please enter speciality');
                $('#speciality').focus();
                return false;
            }

            if(birthday.length ==0) {
                alert('Please enter birthday');
                $('#birthday').focus();
                return false;
            }

            if(code.length ==0) {
                alert('Please enter Id code');
                $('#code').focus();
                return false;
            }

            if(passport.length ==0) {
                alert('Please enter Passport Info');
                $('#passport').focus();
                return false;
            }

            if(position1.length ==0) {
                alert('Please enter Position 1');
                $('#position1').focus();
                return false;
            }

            if(position2.length ==0) {
                alert('Please enter Position 2');
                $('#position2').focus();
                return false;
            }

            if(mail.length ==0) {
                alert('Please enter Mail');
                $('#mail').focus();
                return false;
            }

            if(workplace.length ==0) {
                alert('Please enter workplace');
                $('#workplace').focus();
                return false;
            }

            if(decortype.length ==0) {
                alert('Please enter Decor type');
                $('#decortype').focus();
                return false;
            }

            if(children.length ==0) {
                alert('Please enter children');
                $('#children').focus();
                return false;
            }

            if(enrolldate.length ==0) {
                alert('Please enter enrollment date');
                $('#enrolldate').focus();
                return false;
            }

            if(enrollorder.length ==0) {
                alert('Please enter enrollment order');
                $('#enrollorder').focus();
                return false;
            }

            if(enrollorderdate.length ==0) {
                alert('Please enter enrollment order date');
                $('#enrollorderdate').focus();
                return false;
            }

            if(recofservice.length ==0) {
                alert('Please enter Records of Service');
                $('#recofservice').focus();
                return false;
            }

            if(notes.length ==0) {
                alert('Please enter notes');
                $('#notes').focus();
                return false;
            }

        };
	</script>

</body>
</html>