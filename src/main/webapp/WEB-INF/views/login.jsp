<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<div class="left">
    <p><a href="/">Супермаркет Лента</a></p>
</div>
<div class="title">
    <h2 class="margin52">ВХОД</h2>
</div>
<form:form class="table" method="post" action="/j_spring_security_check">
    <table>
        <tr>
            <td>Логин:</td>
            <td>
                <input type='text' name='login'>
            </td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td>
                <input type='password' name='password' value=''>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Войти"/>
            </td>
        </tr>
    </table>
    <span class="error">${error}</span>
    <span class="green">${message}</span>
</form:form>
</body>
</html>
