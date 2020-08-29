<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/27/2020
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>xxx</title>
</head>
<body>
<h1>first-operator: <%=request.getParameter("first-operator")%></h1>
<h1>operator: <%=request.getParameter("operator")%></h1>
<h1>second-operator: <%=request.getAttribute("second-operator")%></h1>
<h1>result ${requestScope["id"]}</h1>

</body>
</html>
