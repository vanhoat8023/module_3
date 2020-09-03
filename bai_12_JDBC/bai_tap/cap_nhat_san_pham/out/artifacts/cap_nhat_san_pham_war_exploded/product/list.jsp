<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/1/2020
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <a href="/product?action=create">thêm mới sản phẩm</a>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productListServlet}">
        <tr>
            <td scope="row">${product.id}</td>
            <td>${product.name}</td>
            <td>${product.address}</td>
            <td><a href="/product?action=edit&id=${product.id}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
