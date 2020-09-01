<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/29/2020
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<p>
    <a href="/product?action=create">Thêm mới sản phẩm</a>
</p>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Exit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${productServlet}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
            <td><a href="/product?action=edit&id=${product.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="/product?action=search">
    <input type="text" name="name" placeholder="input name product">
    <input type="submit" value="search">
    <button><a href="/product">back to menu</a></button>
</form>

</body>
</html>
