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
    <title>Animals overview</title>

    <link rel="stylesheet" href="/resources/css/style.css"/>

    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>


</head>
<body>
<div class="bg"></div>
<div class="jumbotron">
    <h1>Animals overview</h1>
    <p class="lead">Use the button below to filter Animal races</p>
</div>

<span class="btn-select-value">Select an Item</span>
<select class="selectpicker" title="Choose one of the following..." onchange="location = this.value;">
    <c:forEach var="selectAnimal" items="${animals}">
        <option value="/animals?race=${selectAnimal.getClass().getName()}">${selectAnimal.getClass().getSimpleName()}</option>
    </c:forEach>
</select>

<table class="table table-responsive">
    <thead>
    <th>Animal Type</th>
    <th>Name</th>
    <th>Color</th>
    <th>Body covering</th>
    <th>Weight</th>
    <th>Max number of eggs</th>
    </thead>

    <tbody>
    <c:forEach var="Animal" items="${selectedAnimals}">
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