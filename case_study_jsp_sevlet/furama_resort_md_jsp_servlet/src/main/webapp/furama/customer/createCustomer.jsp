<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/8/2020
  Time: 4:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>
        <a href="/customer?action=listCustomer">back to menu</a>
    </p>
    <table>
        <input type="hidden" value="create" name="action" >
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id_cr"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="1"></td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="text" name="2" ></td>
        </tr>
        <tr>
            <td>gender:</td>
            <td><input type="text" name="3"></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><input type="text" name="4"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="5" ></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="6" ></td>
        </tr>
        <tr>
            <td>Id-card:</td>
            <td><input type="text" name="7" ></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
