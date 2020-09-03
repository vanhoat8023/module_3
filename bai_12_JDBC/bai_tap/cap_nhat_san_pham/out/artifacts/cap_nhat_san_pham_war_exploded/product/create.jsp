<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/2/2020
  Time: 7:50 PM
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
<form method="post">
    <table>
        <input type="hidden" value="create" name="action" >
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="b" ></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create product"></td>
        </tr>
    </table>
</form>
</body>
</html>
