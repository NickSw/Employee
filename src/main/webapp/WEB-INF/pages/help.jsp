<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Помощь по программе</title>

  <link href="/resources/libs/css/bootstrap.css" rel="stylesheet">
  <link href="/resources/libs/css/bootstrap-responsive.css" rel="stylesheet">
  <link href="/resources/css/docs.css" rel="stylesheet">
  <link href="/resources/libs/js/google-code-prettify/prettify.css" rel="stylesheet">
  <link rel="stylesheet" href="/resources/libs/css/font-awesome.css" type="text/css" />

</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar">

<!-- Верхнее меню
================================================== -->
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand" href="/getAllEmployees">На главную</a>
    </div>
  </div>
</div>

<!-- Subhead
================================================== -->
<header class="jumbotron subhead" id="overview">
  <div class="container">
    <h1>Помощь</h1>
    <p class="lead">Этот раздел преднзначен для помощи работы с программой</p>
  </div>
</header>

<div class="container">

  <!-- Навигация по документации
  ================================================== -->
  <div class="row">
    <div class="span3 bs-docs-sidebar">
      <ul class="nav nav-list bs-docs-sidenav">
        <li><a href="#admin"><i class="icon-chevron-right"></i> Режим редактирования</a></li>
        <li><a href="#error"><i class="icon-chevron-right"></i> Ошибки</a></li>
      </ul>
    </div>
    <div class="span9">

      <!-- Редактирование
      ================================================== -->
      <section id="admin">
        <h1>Режим редактирования</h1>
        </br>
        <p>Для режима включения редактирования выполните заданные шаги:</p>
        <ol>
          <li>Зайдите в меню</li>
          <li>Выберите пункт "Начать редактир."</li>
          <li>Введите пароль.</li>
        </ol>
      </section>

      <hr class="bs-docs-separator">

      <section id="error">
        <h1>Ошибки при импорте</h1>
        <h3>Ошибки при импорте могут возникать из-за:</h3>
        <ol>
          <li>Несоответствия последовательности полей импортируемого документа и таблицы</li>
          <li>Несоответствия типов полей импортируемого документа и таблицы</li>
        </ol>
      </section>

    </div>
  </div>

</div>

</body>
</html>
