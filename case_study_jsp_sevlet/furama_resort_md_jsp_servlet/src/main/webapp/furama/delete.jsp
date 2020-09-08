<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/7/2020
  Time: 4:23 PM
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
    <input type="hidden" name="action" value="delete">
    <h3>delete product</h3>
    <table>
        <input type="hidden" name="id1" value="${employee.id}">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a1" value="${employee.name}"></td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="text" name="b1" value="${employee.birthday}"></td>
        </tr>
        <tr>
            <td>salary:</td>
            <td><input type="text" name="c1" value="${employee.salary}"></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><input type="text" name="d1" value="${employee.phone}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="e1" value="${employee.email}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="f1" value="${employee.address}"></td>
        </tr>
        <tr>
            <td>Id-card:</td>
            <td><input type="text" name="g1" value="${employee.id_card}"></td>
        </tr>
        <tr>
            <td><span>delete?</span></td>
            <td><input type="submit" value="delete Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
