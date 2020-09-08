<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/8/2020
  Time: 10:27 AM
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
        <c:if test="${error!=''}"><p>${error}</p></c:if>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id_cr"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="1"></td>
        </tr>
        <tr>
            <td>Area:</td>
            <td><input type="text" name="2" ></td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td><input type="text" name="3"></td>
        </tr>
        <tr>
            <td>max_people:</td>
            <td><input type="text" name="4"></td>
        </tr>
        <tr>
            <td>standard:</td>
            <td><input type="text" name="5" ></td>
        </tr>
        <tr>
            <td>description_other_convenience:</td>
            <td><input type="text" name="6" ></td>
        </tr>
        <tr>
            <td>pool_area:</td>
            <td><input type="text" name="7" ></td>
        </tr>
        <tr>
            <td>number_of_floors:</td>
            <td><input type="text" name="8" ></td>
        </tr>
        <tr>
            <td><span>Update?</span></td>
            <td><input type="submit" value="Update Element"></td>
        </tr>
    </table>
</form>
</body>
</html>
