<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/9/2020
  Time: 6:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <input type="hidden" value="create" name="action" >
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id_cr"></td>
        </tr>
        <tr>
            <td>Start_date:</td>
            <td><input type="text" name="1"></td>
        </tr>
        <tr>
            <td>End_date:</td>
            <td><input type="text" name="2" ></td>
        </tr>
        <tr>
            <td>Deposit:</td>
            <td><input type="text" name="3"></td>
        </tr>
        <tr>
            <td>Total_money:</td>
            <td><input type="text" name="4"></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
