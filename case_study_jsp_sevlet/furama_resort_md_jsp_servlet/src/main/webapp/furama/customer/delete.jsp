<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/8/2020
  Time: 6:35 AM
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
    <input type="hidden" name="action" value="delete">
    <h3>delete customer</h3>
    <table>
        <input type="hidden" name="id1" value="${customer.id}">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="a1" >${customer.customer_name}</td>
        </tr>
        <tr>
            <td>birthday:</td>
            <td><input type="text" name="b1" >${customer.customer_birthday}</td>
        </tr>
        <tr>
            <td>gender:</td>
            <td><input type="text" name="c1" >${customer.customer_gender}</td>
        </tr>
        <tr>
            <td>Id-card:</td>
            <td><input type="text" name="g1" >${customer.customer_id_card}</td>
        </tr>
        <tr>
            <td>phone:</td>
            <td><input type="text" name="d1" >${customer.customer_phone}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="e1" >${customer.customer_email}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="f1" >${customer.customer_address}</td>
        </tr>
        <tr>
            <td><span>delete?</span></td>
            <td><input type="submit" value="delete Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
