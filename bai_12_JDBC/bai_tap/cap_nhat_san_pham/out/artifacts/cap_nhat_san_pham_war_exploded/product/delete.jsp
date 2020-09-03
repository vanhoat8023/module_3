<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/2/2020
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Delete product</h2>
<form method="post" action="/product">
    <input type="hidden" name="action" value="delete">
    <h3>bạn muốn xóa sản phẩm này</h3>
    <h3>thông tin sản phẩm</h3>
    <table>
        <input type="hidden" name="id" value="${product.id}">
        <tr>
            <td>Name: </td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td><a href="/product">Back to element list</a></td>
            <td><input type="submit" value="Delete product"></td>
        </tr>
    </table>
</form>
</body>
</html>
