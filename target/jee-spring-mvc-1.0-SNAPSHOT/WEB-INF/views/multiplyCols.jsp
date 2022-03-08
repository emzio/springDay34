<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 27.02.2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

cols${cols}
rows${rows}
<table>
    <tr>
        <th>x</th>
        <c:forEach var="single" begin="1" end="${cols}">
            <th>${single}</th>
        </c:forEach>
    </tr>

    <c:forEach var="single" begin="1" end="${rows}">
    <tr>
        <th>${single}</th>
        <c:forEach begin="1" end="${cols}" var="actualNumber">
        <td>
                ${actualNumber * single}
        </td>
        </c:forEach>
    <tr>
        </c:forEach>
</table>
</body>
</html>
