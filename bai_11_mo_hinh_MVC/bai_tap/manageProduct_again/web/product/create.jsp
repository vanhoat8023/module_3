<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2020
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Thêm mới sản phẩm</h2>
<p>
    <a href="/product">Back to menu</a>
</p>
<form method="post">
    <h3>thông tin sản phẩm</h3>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a" id="a"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="b" id="b"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create Element"></td>
        </tr>
    </table>

</form>
</body>
</html>
