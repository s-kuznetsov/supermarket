<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8"/>
    <title>Title</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<%--<% String nameOfUser = (String) request.getSession().getAttribute("value");%>--%>
<div>
    <p><a href="/page-admin/products" class="super">Супермаркет Лента</a></p>
</div>
<a href="/page-admin/products" class="super">Список всех товаров</a>
<form class="left" action="/page-admin/all-orders" method="get">
    <a href="/page-admin/all-orders" class="super">Список всех заказов</a>
</form>
<form class="left" action="/page-admin/all-clients" method="get">
    <a href="/page-admin/all-clients" class="super">Список всех клиентов</a>
</form>
<form class="right" action="/j_spring_security_logout" method="get">
    <a href="/j_spring_security_logout">Выход</a>
</form>
<h1 class="user" >
    ${value}
</h1>
<div class="title2">
    <h2>Список всех заказов магазина</h2>
</div>
<div class="table">
    <table style="width: 600px;">
        <thead>
        <tr>
            <th>№</th>
            <th>Наименование товара</th>
            <th>Имя покупателя</th>
            <th>Фамилия покупателя</th>
            <th>Дата покупки</th>
            <th>Цена</th>
            <th>Статус</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td><c:out value="${order.idOrder}"></c:out></td>
                <td><c:out value="${order.orderType}"></c:out></td>
                <td><c:out value="${order.client.getName()}"></c:out></td>
                <td><c:out value="${order.client.getSurname()}"></c:out></td>
                <td><c:out value="${order.dateOfCreation}"></c:out></td>
                <td><c:out value="${order.cost}"></c:out></td>
                <td><c:out value="${order.orderStatus}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
