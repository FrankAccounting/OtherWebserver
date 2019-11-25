<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List gear</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Gear List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <button class="add-button"
                onclick="window.location.href='showAddGearForm'; return false;">Add Gear</button>

        <form:form action="search" method="GET">
            <input type="search" name="searchTerm">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Description</th>
                <th>Damage</th>
                <th>Price</th>
                <th>Weight</th>
            </tr>

            <c:forEach var="tempGear" items="${gearList}">

                <tr>
                    <td>

                    </td>
                    <td>${tempGear.name}</td>
                    <td>${tempGear.description}</td>
                    <td>${tempGear.damage}</td>
                    <td>${tempGear.price}</td>
                    <td>${tempGear.weight}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
