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
    <title>Cage overview</title>


    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">


    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>


</head>
<body>
<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center" style="text-shadow: 1px 1px 2px black, 0 0 25px #9aa5a9, 0 0 5px darkblue;"><h1>
        Cage overview</h1>
    </div>
</div>

<div class="container" style="width: 85%;">


    <table class="table table-responsive">
        <thead>
        <th>Type</th>
        <th>Amount of animals</th>
        </thead>

        <tbody>
        <c:forEach var="Cage" items="${cages}">
            <tr>
                <td>${Cage.getCageRace().getSimpleName()}</td>
                <td>${Cage.getCagedAnimals().size()}</td>
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