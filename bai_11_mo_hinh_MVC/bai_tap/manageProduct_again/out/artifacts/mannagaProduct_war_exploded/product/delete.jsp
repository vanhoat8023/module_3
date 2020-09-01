<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/1/2020
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Delete Element</h2>
<p>
    <a href="/product">Back to element list</a>
</p>
<form method="post" action="delete">
    <h3>bạn muốn xóa sản phẩm này</h3>
    <h3>thông tin sản phẩm</h3>
    <table>
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
