<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 27.02.2022
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>multiply</title>
</head>
<body>


    <table>
        <tr>
            <th>x</th>
            <c:forEach var="single" items="${size}">
            <th>${single}</th>
            </c:forEach>
        </tr>
        <c:forEach var="single" items="${size}">
        <tr>
            <th>${single}</th>
            <c:forEach begin="1" end="${fn:length(size)}" var="actualNumber">
            <td>
                ${actualNumber * single}
            </td>
            </c:forEach>
        <tr>
            </c:forEach>
    </table>

</body>
</html>
