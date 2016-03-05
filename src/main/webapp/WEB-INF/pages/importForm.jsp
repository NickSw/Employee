<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>import</title>
</head>
<body>
<form:form modelAttribute="fileBean" method="post" action="xls" enctype="multipart/form-data">
    <form:label for="fileData" path="fileData">Select file</form:label><br/><br/>
    <form:input path="fileData" type="file"/>
    <input type="submit" />
</form:form>
</body>
</html>