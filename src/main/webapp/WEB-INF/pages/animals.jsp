<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bas
  Date: 14-11-2016
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        Dropdown
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <c:forEach var="selectAnimal" items="${animals}">
            <li><a href="/animals?race=${selectAnimal.getClass().getName()}">${selectAnimal.getClass().getSimpleName()}</a></li>
        </c:forEach>
    </ul>
</div>

<table border="1">
    <thead>
    <th>Animal Type</th>
    <th>Name</th>
    <th>Color</th>
    <th>Body covering</th>
    <th>Weight</th>
    <th>Max number of eggs</th>
    </thead>

    <tbody>
    <c:forEach var="Animal" items="${animals}">
        <tr>
            <td>${Animal.getClass().getSimpleName()}</td>
            <td>${Animal.getName()}</td>
            <td>${Animal.getColor()}</td>
            <td>${Animal.getBodyCovering()}</td>
            <td>${Animal.getWeight()}</td>
            <td>${Animal.getMaxNumberOfEggs()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
