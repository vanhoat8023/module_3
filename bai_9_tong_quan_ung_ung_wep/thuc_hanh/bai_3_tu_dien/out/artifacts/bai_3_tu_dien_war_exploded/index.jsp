<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/26/2020
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>tu_dien</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="traTuDien" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  </body>
</html>
