<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/27/2020
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>product</title>
  </head>
  <body>
  <form method="post" action="/discount">
    <label for="description"> Product description </label>
    <input id="description" placeholder="description" >
    <label for="price">List Price</label>
    <input id="price" placeholder="price" name="price">
    <label for="discount">Discount Percent</label>
    <input id="discount" placeholder="Description" name="discount">
    <input type="submit" value="Calculate">
  </form>
  </body>
</html>
