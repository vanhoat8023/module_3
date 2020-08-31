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
        <th>Address</th>
    </tr>
    <c:forEach var="product" items="${productServlet}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
