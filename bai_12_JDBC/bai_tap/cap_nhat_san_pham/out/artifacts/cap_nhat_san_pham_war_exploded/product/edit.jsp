<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/2/2020
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/product">back to menu</a>
</p>
<form method="post" action="/product">
    <input type="hidden" name="action" value="edit">
    <h3>edit product</h3>
    <table>
        <input type="hidden" name="id" value="${product.id}">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="b" value="${product.address}"></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
