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
    <%--<%=nameOfUser%>--%>
</h1>
<div class="title">
    <h2>Список всех товаров магазина</h2>
</div>
<div class="table">
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>Наименование товара</th>
            <th>Цена</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.idOrderType}"></c:out></td>
                <td><c:out value="${product.orderType}"></c:out></td>
                <td><c:out value="${product.cost}"></c:out></td>
                <td><a href="/page-admin/${product.idOrderType}/edit-product">Редактировать</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/page-admin/add-product">Добавить товар</a>
</div>
</body>
</html>
