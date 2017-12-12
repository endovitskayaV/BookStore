<%--
  Created by IntelliJ IDEA.
  User: Valya
  Date: 28.10.2017
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table>
    <c:forEach var="book" items="${books}" >
        <tr>
            <td>
                <a href="bookInfo?id=${book.getId()}"> ${book.getName()}</a><br>
                    ${book.getAuthor()}
                <br><br>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>