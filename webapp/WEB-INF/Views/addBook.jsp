<%--
  Created by IntelliJ IDEA.
  User: Valya
  Date: 09.12.2017
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<head>
    <title>Новая книга</title>
</head>
<body>
<form action="addBook" method="post">

    <input name="productId" hidden value="${book.getId()}" type="number"/>

    <p><b>Название:</b><br>
        <input name="name" required value="${book.getName()}" type="text"/>
    </p>
    <p><b>Автор:</b><br>
        <input name="author" value="${book.getAuthor()}" type="text"/>
    </p>
    <p><b>Издатель:</b><br>
        <input name="publisher" value="${book.getPublisher()}" type="text"/>
    </p>
    <p><b>Год издания:</b><br>
        <input name="releaseYear"  min="0" max="${maxYear}" value="${book.getReleaseYear()}" type="number"/>
    </p>
    <p><b>Количество страниц:</b><br>
        <input name="pagesNumber"  min="0" value="${book.getPagesNumber()}" type="number"/>
    </p>


    <button type="reset"> Отмена</button>
    <button type="submit">Сохранить</button>
</form>

<br>
<a href="admin"> <i class="material-icons" style="font-size: 20pt;">home</i></a>
</body>
</html>