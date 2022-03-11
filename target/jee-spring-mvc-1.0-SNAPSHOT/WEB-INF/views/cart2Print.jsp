<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: emzio
  Date: 09.03.2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart2Print</title>
</head>
<body>
    <table>
        <thead>
            <th>quantity</th>
            <th>name</th>
            <th>id</th>
            <th>price</th>
        </thead>

        <tbody>
        <c:forEach var="cartItem" items="${cartItems}">
            <tr>
                <td>${cartItem.getQuantity()}</td>
                <td>${cartItem.getProduct().getName()}</td>
                <td>${cartItem.getProduct().getId()}</td>
                <td>${cartItem.getProduct().getPrice()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
