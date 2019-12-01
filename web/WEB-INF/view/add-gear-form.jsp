<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gear added</title>
</head>
<body>

<form:form action="save" modelAttribute="aGear">
    <form:hidden path="ID" value="${aGear.ID}"/>

    <table>
        <tr>
            <td><label>name</label></td>
            <td><form:input path="name"/>
                <form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>descript</label></td>
            <td><form:input path="description"/>
                <form:errors path="description" cssClass="error"/></td>


            <td><label>damage</label></td>
            <td><form:input path="damage"/>
                <form:errors path="damage" cssClass="error"/></td>


            <td><label>price</label></td>
            <td><form:input path="price"/>
                <form:errors path="price" cssClass="error"/></td>


            <td><label>weight</label></td>
            <td><form:input path="weight"/>
                <form:errors path="weight" cssClass="error"/></td>



        </tr>
    </table>

    <tr>
        <td></td>
        <td><input type="submit" value="Save" class="save"></td>
    </tr>
</form:form>



</body>
</html>
