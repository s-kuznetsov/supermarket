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
</h1>
<div class="title">
    <h2>Список товаров магазина</h2>
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
                <td>
                        <form method="post" action="/user/${login}/buy-product/${product.idOrderType}">
                            <input type="submit" value="Купить"/>
                        </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
