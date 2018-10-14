<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
    <div class="left">
        <p><a href="/">Супермаркет Лента</a></p>
    </div>
    <div class="right">
        <p><a href="login">Вход</a>  <a href="registration">Регистрация</a></p>
    </div>
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
            <c:forEach items="${requestScope.products}" var="product">
                <tr>
                    <td><c:out value="${product.idOrderType}"></c:out></td>
                    <td><c:out value="${product.orderType}"></c:out></td>
                    <td><c:out value="${product.cost}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
