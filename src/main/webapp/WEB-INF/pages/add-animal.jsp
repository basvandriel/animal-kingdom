<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animals overview</title>


    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="../webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">

    <script src="../webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>

    <script type="text/javascript">


    </script>

</head>
<body>
<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center" style="text-shadow: 1px 1px 2px black, 0 0 25px #9aa5a9, 0 0 5px darkblue;"><h1>
        Animals overview</h1>
        <p class="lead">Use the button below to filter Animal races</p></div>
</div>

<div class="container" style="width: 85%;">

    <p>Animal race</p>
    <select id="raceSelector" class="selectpicker" title="Select an animal race">
        <option value=""></option>
        <c:forEach var="availableAnimal" items="${availableAnimals}">
            <option value="/overview?race=${availableAnimal.getName()}">
                    ${availableAnimal.getSimpleName()}
            </option>
        </c:forEach>
    </select>

    <br><br>

    <button type="button" class="btn btn-outline-primary">Add animal</button>

    <br><br>

    <a href="/overview">
        <button type="button" class="btn btn-link">Overview</button>
    </a>

    <a href="/">
        <button type="button" class="btn btn-link">Home page</button>
    </a>


</div>

</body>