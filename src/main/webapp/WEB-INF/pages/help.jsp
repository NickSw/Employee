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
        <li><a href="#authorization"><i class="icon-chevron-right"></i>Авторизация</a></li>
        <li><a href="#employee-table"><i class="icon-chevron-right"></i>Таблица сотрудников</a></li>
        <li><a href="#orders-for-employees-table"><i class="icon-chevron-right"></i>Таблица приказов по сотрудникам</a></li>
        <li><a href="#archives"><i class="icon-chevron-right"></i>Архивы</a></li>
        <li><a href="#export"><i class="icon-chevron-right"></i>Экспорт</a></li>
        <li><a href="#import"><i class="icon-chevron-right"></i>Импорт</a></li>
      </ul>
    </div>
    <div class="span9">

      <!-- Редактирование
      ================================================== -->
      <section id="authorization">
        <h1>Авторизация</h1>
        </br>
        <h3>Режим редактирования</h3>
        <p>Для входа в режим редактировния необходимо:</p>
        <ol>
          <li>Зайти в меню</li>
          <li>Выбрать пункт "Начать редактир."</li>
          <li>Ввести пароль</li>
        </ol>
        </br>
        <h3>Смена пароля</h3>
        <p>Для смены пароля необходимо:</p>
        <ol>
          <li>Зайти в меню</li>
          <li>Выбрать пункт "Начать редактир."</li>
          <li>В появившемся окне выбрать пункт смена пароля</li>
          <li>Ввести старый пароль, новый пароль и подтвердить новый пароль</li>
        </ol>
        <p>Для смены пароля в режиме редактирования необходимо:</p>
        <ol>
          <li>Зайти в меню</li>
          <li>Выбрать пункт "Замена и восст. пароля"</li>
          <li>Ввести старый пароль, новый пароль и подтвердить новый пароль</li>
        </ol>
        </br>
        <h3>Сброс пароля</h3>
        <p>Для сброса пароля необходимо открыть форму замены пароля и перейти по ссылке сброса пароля</p>
      </section>

      <hr class="bs-docs-separator">

      <section id="employee-table">
        <h1>Таблица сотрудников</h1>
        </br>
        <h3>Функциональные возможности таблицы сотрудников:</h3>
        <ol>
          <li>Фильтр данных</li>
          <li>Добавление сотрудника</li>
          <li>Редактирование сотрудника</li>
          <li>Удаление сотрудника</li>
          <li>Перемещение сотрудника в архив</li>
          <li>Просмотр карточки сотрудника</li>
        </ol>
        </br>
        <h3>Фильтр данных</h3>
        <p>Некоторые поля в таблице имеют фильтр для удобства просмотра данных</p>
        <ol>
          <li>ФИО - фильтр по сортировке и вхождению</li>
          <li>Должность 1 - фильтр по вхождению</li>
          <li>Должность 2 - фильтр по вхождению</li>
          <li>Место работы - фильтр по списку мест работы(из таблицы мест работы)</li>
          <li>Дата рождения - фильтр по списку месяцев рождения</li>
          <li>Дети до 16 лет - фильтр показывающий сотрудников, у которых есть дети</li>
          <li>Тип оформления - фильтр по списку типов оформления</li>
        </ol>
        </br>
        <h3>Добавление сотрудника</h3>
        <h4>Особенности ввода данных (валидация формы)</h4>
        <p>Для добавления сотрудника необходимо нажать кнопку "Добавить сотрудника", которая расположена под кнопкой меню</p>
        <ol>
          <li>Обязательное поле - ФИО</li>
          <li>Даты необходимо писать в формате ГГГГ-ММ-ДД(под полями дат есть подсказки)</li>
          <li>Поле Идентификационный код необходимо заполнять только числами(под полем есть подсказка)</li>
        </ol>

      </section>

      <hr class="bs-docs-separator">

      <section id="orders-for-employees-table">
        <h1>Таблица приказов по сотрудникам</h1>
        </br>
        <h3>Функциональные возможности таблицы приказов по сотрудникам:</h3>
        <ol>
          <li>Фильтр данных</li>
          <li>Добавление приказа</li>
          <li>Редактирование приказа</li>
          <li>Удаление приказа</li>
          <li>Перемещение приказа в архив</li>
          <li>Копирование приказа</li>
        </ol>
        </br>
        <h3>Фильтр данных</h3>
        <p>Некоторые поля в таблице имеют фильтр для удобства просмотра данных</p>
        <ol>
          <li>Дата приказа - фильтр(календарь) по дате приказа</li>
          <li>Тип приказа - фильтр по списку типов приказов(из таблицы типов приказов)</li>
          <li>ФИО - фильтр по вхождению</li>
        </ol>
        </br>
        <h3>Добавление приказа</h3>
        <h4>Особенности ввода данных (валидация формы)</h4>
        <p>Для добавления приказа необходимо нажать кнопку "Добавить приказ", которая расположена под кнопкой меню</p>
        <ol>
          <li>Обязательные поля: дата приказа, тип приказа и ФИО</li>
          <li>Даты необходимо писать в формате ГГГГ-ММ-ДД(под полями дат есть подсказки)</li>
        </ol>

      </section>

      <hr class="bs-docs-separator">

      <section id="archives">
        <h1>Архивы</h1>
        </br>
        <h3>Функциональные возможности архивных таблиц:</h3>
        <ol>
          <li>Фильтры архивных таблиц аналогичны фильтрам основных таблиц</li>
          <li>Удаление полей</li>
          <li>Экспорт и очистка архива - экспорт excel файла таблицы и очистка архивной таблицы</li>
        </ol>
      </section>

      <hr class="bs-docs-separator">

      <section id="export">
        <h1>Экспорт</h1>
        </br>
        <h3>Для экспорта таблицы необходимо:</h3>
        <ol>
          <li>Зайти в меню</li>
          <li>Выбрать пункт "Экспорт данных в MS Excel"</li>
          <li>Выбрать таблицу из выпадающего списка</li>
          <li>Нажать кнопку экспорт</li>
        </ol>
      </section>

      <hr class="bs-docs-separator">

      <section id="import">
        <h1>Импорт</h1>
        </br>
        <h3>Для импорта таблицы необходимо:</h3>
        <ol>
          <li>Зайти в меню</li>
          <li>Выбрать пункт "Экспорт данных в MS Excel"</li>
          <li>Выбрать таблицу из выпадающего списка</li>
          <li>Выбрать файл, содержащий подходящие данные для таблицы</li>
          <li>Нажать кнопку импорт</li>
        </ol>
        <br>
        <h3>Ошибки при импорте могут возникать из-за:</h3>
        <br>
        <h4>Неправильной последовательности полей и типов полей</h4>
        <h5>Таблица сотрудников</h5>
        <ol>
          <li>ФИО - текстовое поле</li>
          <li>Телефон - текстовое поле</li>
          <li>Почта - текстовое поле</li>
          <li>Должность 1 - текстовое поле</li>
          <li>Должность 2 - текстовое поле</li>
          <li>Где работает - текстовое поле</li>
          <li>Дата рождение - поле даты</li>
          <li>Дети до 16 лет - текстовое поле</li>
          <li>Адресс - текстовое поле</li>
          <li>ВУЗ - текстовое поле</li>
          <li>Специальность - текстовое поле</li>
          <li>Идент. код - числовое поле</li>
          <li>Паспорт - текстовое поле</li>
          <li>Тип оформления - текстовое поле</li>
          <li>Дата зачисления - поле даты</li>
          <li>Приказ о зачислении - текстовое поле</li>
          <li>Дата приказа о зачислении - поле даты</li>
          <li>Трудовая книжка - текстовое поле</li>
          <li>Примечание - текстовое поле</li>
        </ol>
        <h5>Таблица типов приказов</h5>
        <ol>
          <li>Тип приказа - текстовое поле</li>
          <li>Примечание - текстовое поле</li>
        </ol>
        <h5>Таблица мест работы</h5>
        <ol>
          <li>Место работы - текстовое поле</li>
          <li>Адресс - текстовое поле</li>
          <li>Телефон - текстовое поле</li>
        </ol>
        <h5>Таблица приказов по сотрудникам</h5>
        <ol>
          <li>Дата приказа - поле даты</li>
          <li>Номер приказа - текстовое поле</li>
          <li>Тип приказа - текстовое поле</li>
          <li>ФИО - текстовое поле</li>
          <li>Текст приказа - текстовое поле</li>
        </ol>
        <br>
        <h4>Данные в excel файле должны начинаться с 4 строки(см. пример экспортированого файла)</h4>
        <br>
        <h4>Попытка импортировать файл другой таблицы</h4>
      </section>

      <hr class="bs-docs-separator">

    </div>
  </div>

</div>

</body>
</html>