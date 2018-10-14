<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<div>
    <p><a href="/user/${login}/main-page" class="super">Супермаркет Лента</a></p>
</div>
<form class="left">
    <a href="/user/${login}/orders" class="super">Мои заказы</a>
</form>
<a href="/user/${login}/main-page" class="super">Список Товаров</a>
<form class="right" action="/j_spring_security_logout" method="get">
    <a href="/j_spring_security_logout">Выход</a>
</form>
<h1 class="user" >
    ${value}
    <%--<%=nameOfUser%>--%>
</h1>
<div class="title">
    <h2>Мои заказы</h2>
</div>
<div class="table">
<table style="width: 500px;">
    <thead>
    <tr>
        <th>№</th>
        <th>Наименование товара</th>
        <th>Цена</th>
        <th>Дата покупки</th>
        <th>Статус</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td><c:out value="${order.idOrder}"></c:out></td>
            <td><c:out value="${order.orderType}"></c:out></td>
            <td><c:out value="${order.cost}"></c:out></td>
            <td><c:out value="${order.dateOfCreation}"></c:out></td>
            <td><c:out value="${order.orderStatus}"></c:out></td>
            <td>
                <form method="post" action="/user/${login}/delete-order/${order.idOrder}">
                    <input type="submit" value="Отказаться"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
