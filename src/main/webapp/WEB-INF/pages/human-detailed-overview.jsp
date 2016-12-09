<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bas
  Date: 14-11-2016
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detailed human overview</title>


    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>

    <script type="text/javascript"></script>

</head>
<body>
<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center"><h1>Detailed human overview</h1></div>
</div>

<div class="container" style="width: 85%;">

    <button type="button" class="btn btn-outline-primary" disabled>Delete animal</button>
    <button type="button" class="btn btn-outline-primary" disabled>Update animal</button>

    <br><br>
    <button type="button" class="btn btn-outline-primary" id="marryButton" disabled>Marry</button>
    <button type="button" class="btn btn-outline-primary" id="makeLoveButton" disabled>Make love</button>
    <button type="button" class="btn btn-outline-primary" id="giveBirthButton" disabled>Give birth</button>


    <br><br><br>


    <br><br>


    <h2>STDs</h2>
    <table class="table table-responsive">
        <thead>
        <th>Name</th>
        </thead>

        <tbody>
        <c:forEach var="animalSTD" items="${animalSTDs}">
            <tr>
                <td>${animalSTD.getName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>

    <a href="/">
        <button type="button" class="btn btn-link">Home page</button>
    </a>
</div>

</body>