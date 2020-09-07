<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2020
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/employee">back to menu</a>
</p>
<form method="post" action="/employee">
    <input type="hidden" name="action" value="edit">
    <h3>edit product</h3>
    <table>
        <input type="hidden" name="id" value="${employee.id}">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a" value="${employee.name}"></td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="text" name="b" value="${employee.birthday}"></td>
        </tr>
        <tr>
            <td>salary:</td>
            <td><input type="text" name="c" value="${employee.salary}"></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><input type="text" name="d" value="${employee.phone}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="e" value="${employee.email}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="f" value="${employee.address}"></td>
        </tr>
        <tr>
            <td>Id-card:</td>
            <td><input type="text" name="g" value="${employee.id_card}"></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>