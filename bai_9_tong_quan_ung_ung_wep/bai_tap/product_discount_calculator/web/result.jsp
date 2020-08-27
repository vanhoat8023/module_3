<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/27/2020
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>price: <%=request.getParameter("price")%></h1>
<h1>discount: <%=request.getParameter("discount")%></h1>
<h1>result: <%=request.getAttribute("id")%></h1>
<h1>result: <%=request.getAttribute("id2")%></h1>
</body>
</html>
