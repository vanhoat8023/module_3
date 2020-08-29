<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/27/2020
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>calculator</title>
  </head>
  <body>
  <form action="/result" method="post">
    <h1>Simple Calculator</h1>
    <table>
      <tr>
        <td><lable>First operand</lable></td>
        <td><input type="text" value="0" name="first-operator"></td>
      </tr>
      <tr>
        <td><label>Operator</label></td>operator
        <td>
          <select name="operator">
            <option value="+">summation</option>
            <option value="-">Subtraction</option>
            <option value="*">multiplication</option>
            <option value="/">division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td><label>Second operand</label></td>
        <td><input type="text" name="second-operator"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="calculate"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
