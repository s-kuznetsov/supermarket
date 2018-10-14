<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Регистрация</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<div class="left">
    <p><a href="/">Супермаркет Лента</a></p>
</div>
<div class="title">
    <h2 class="margin52">РЕГИСТРАЦИЯ</h2>
</div>
<form:form class="table2" method="post" action="registration" modelAttribute="registrationForm">
    <table>
        <tr>
            <td>Придумайте Логин: </td>
            <td><form:input path="login" />
            </td>
            <td><form:errors path="login" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Придумайте Пароль: </td>
            <td><form:password path="passwordOne" />
            </td>
            <td><form:errors path="passwordOne" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Повторите Пароль: </td>
            <td><form:password path="passwordTwo" />
            </td>
            <td><form:errors path="passwordTwo" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Имя: </td>
            <td><form:input path="name" />
            </td>
            <td><form:errors path="name" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Фамилия: </td>
            <td><form:input path="surname" />
            </td>
            <td><form:errors path="surname" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Отчество: </td>
            <td><form:input path="patronymic" />
            </td>
            <td><form:errors path="patronymic" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Телефон: </td>
            <td><form:input path="phone" />
            </td>
            <td><form:errors path="phone" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>E-mail: </td>
            <td><form:input path="email" />
            </td>
            <td><form:errors path="email" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Зарегистрироваться"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
