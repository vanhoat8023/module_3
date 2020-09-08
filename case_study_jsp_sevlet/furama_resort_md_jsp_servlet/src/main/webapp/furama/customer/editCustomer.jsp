<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/8/2020
  Time: 5:30 AM
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
<form method="post" action="/customer">
    <input type="hidden" name="action" value="edit">
    <h3>edit customer</h3>
    <table>
        <input type="hidden" name="id" value="${customer.id}">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a" value="${customer.customer_name}"></td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="text" name="b" value="${customer.customer_birthday}"></td>
        </tr>
        <tr>
            <td>gender:</td>
            <td><input type="text" name="c" value="${customer.customer_gender}"></td>
        </tr>
        <tr>
            <td>Id_card:</td>
            <td><input type="text" name="d" value="${customer.customer_id_card}"></td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><input type="text" name="e" value="${customer.customer_phone}"></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="text" name="f" value="${customer.customer_email}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="g" value="${customer.customer_address}"></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
