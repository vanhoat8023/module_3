<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2020
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Element</h2>
<p>
    <a href="/product">Back to Element List</a>
</p>
<form method="post" action="edit">
    <h3>edit product</h3>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a" id="a" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="b" id="b" value="${product.price}"></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
