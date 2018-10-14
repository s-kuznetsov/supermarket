<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='/resources/css/style.css' %>
    </style>
</head>
<body>
<form:form action="/page-admin/add-product" method="POST" modelAttribute="productForm">
    <table>
        <tr>
            <td align="right" >Наименование товара : </td>
            <td>
                <form:input path="orderType"/>
            </td>
            <td><form:errors path="orderType" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td align="right" >Цена : </td>
            <td>
                <form:input path="cost"/>
            </td>
            <td><form:errors path="cost" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
