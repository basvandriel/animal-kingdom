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

    <script type="text/javascript">
        $(document).ready(function () {
            console.log("No");

            console.log(localStorage.getItem('selectedAnimalRace'));

            /*            console.log("No");

             console.log(localStorage.getItem('selectedAnimal'));

             if (localStorage.getItem('selectedAnimal') != undefined) {
             // console.log(localStorage.getItem('selectedAnimal'));

             document.getElementById("raceSelector").options[localStorage.getItem('selectedAnimal')].selected = true;
             }

             // On change store the value
             document.getElementById("raceSelector").onchange = function () {

             localStorage.setItem('selectedAnimal', document.getElementById("raceSelector").value);
             console.log(localStorage.getItem('selectedAnimal'));

             window.location.href = this.value;

             };*/

            $(function () {
                if (localStorage.getItem('selectedAnimalRace')) {
                    var selectedAnimalRace = localStorage.getItem('selectedAnimalRace');


                    $('button[data-id="raceSelector"]').attr("title", selectedAnimalRace);
                    $('button[data-id="raceSelector"] span.filter-option').text(selectedAnimalRace);

                }

                document.getElementById("raceSelector").onchange = function () {
                    var select = document.getElementById("raceSelector");
                    var race = select.options[select.selectedIndex].text;

                    localStorage.setItem('selectedAnimalRace', race);

                    window.location.href = this.value;
                };

                localStorage.setItem('selectedAnimalRace', "Select an animal race");

            });


        });


    </script>

</head>
<body>
<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center"><h1>Animals overview</h1>
        <p class="lead">Use the button below to filter Animal races</p></div>
</div>

<div class="container" style="width: 85%;">

<select id="raceSelector" class="selectpicker" title="Select an animal race">
    <c:forEach var="availableAnimal" items="${availableAnimals}">
        <option value="/animals?race=${availableAnimal.getName()}">
                ${availableAnimal.getSimpleName()}
        </option>
    </c:forEach>
</select>

<table class="table table-responsive">
    <thead>
    <th>Animal</th>
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

</div>

</body>