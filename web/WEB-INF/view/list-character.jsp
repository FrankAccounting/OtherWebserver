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
                onclick="window.location.href='showAddPlayerForm'; return false;">Add Player</button>

        <form:form action="search" method="GET">
            <input type="search" name="searchTerm">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Description</th>
                <th>Align</th>
                <th>XP</th>
            </tr>

            <c:forEach var="tempPlayer" items="${playerList}">

                <tr>
                    <td>

                    </td>
                    <td>${tempPlayer.characterNm}</td>
                    <td>${tempPlayer.description}</td>
                    <td>${tempPlayer.alignment}</td>
                    <td>${tempPlayer.xp}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
