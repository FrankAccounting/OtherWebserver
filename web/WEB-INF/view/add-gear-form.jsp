<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sstan
  Date: 11/24/2019
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gear added</title>
</head>
<body>

<form:form action="save"
           modelAttribute="aGear">
    <table>
    </table>
</form:form>



<tr>
    <td><label>name</label></td>
    <td><form:input path="name"/></td>
</tr>
<tr>
    <td><label>description</label></td>
    <td><form:input path="description"/></td>

    <td><label>damage</label></td>
    <td><form:input path="damage"/></td>

    <td><label>price</label></td>
    <td><form:input path="price"/></td>

    <td><label>weight</label></td>
    <td><form:input path="weight"/></td>
</tr>

<tr>
    <td></td>
    <td><input type="submit"  value="Save"   class="save"></td>
</tr>

</body>
</html>
