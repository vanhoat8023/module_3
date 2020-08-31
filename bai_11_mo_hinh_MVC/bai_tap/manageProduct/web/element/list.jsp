<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/08/2020
  Time: 5:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show List</title>
    <style>
        a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>

<p>
    <a href="/elements?action=create">Create new element</a>
</p>
<table border="1" style="width: 50%">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${elements}" var="e">
        <tr>
            <td>${e.id}</td>
            <td><a href="/elements?action=view&id=${e.id}">${e.name}</a></td>
            <td>${e.price}</td>
            <td>${e.desc}</td>
            <td>${e.producer}</td>
            <td><a href="/elements?action=edit&id=${e.id}">edit</a></td>
            <td><a href="/elements?action=delete&id=${e.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<form method="post" action="/elements?action=search">
    <fieldset style="width: 45%">
        <input type="text" name="name" placeholder="Input element name">
        <input type="submit" value="Search">
        <button><a href="/elements">Back To Element List</a></button>
    </fieldset>
</form>
</body>
</html>
