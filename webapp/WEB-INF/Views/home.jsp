<%--
  Created by IntelliJ IDEA.
  User: Valya
  Date: 28.10.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<table>
    <tr>
        <td>${concreteProducts.getProduct().getName()}</td>
        <td>${concreteProducts.getProduct().getClass().getSimpleName()}</td>
    </tr>
</table>
</body>
</html>
