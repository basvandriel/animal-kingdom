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
    <title>Animals overview</title>


    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">

    <link rel="stylesheet" href="../resources/css/style.css"/>

    <style type="text/css" rel="stylesheet">
        tbody tr:hover {
            background-color: rgba(79, 130, 233, 0.65);
            cursor: pointer;
        }

        .selectedanimal {
            background-color: rgba(79, 130, 233, 0.65);
        }
    </style>

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>

    <script type="text/javascript">


        $(document).ready(function () {

            $(".selectpicker").selectpicker();

            if (localStorage.getItem('selectedAnimalRace')) {
                var selectedAnimalRace = localStorage.getItem('selectedAnimalRace');

                //Elements for setting the dropdown title
                $('button[data-id="raceSelector"]').attr("title", selectedAnimalRace);
                $('button[data-id="raceSelector"] span.filter-option').text(selectedAnimalRace);

                localStorage.setItem('selectedAnimalRace', "Select an animal race");
            }


            document.getElementById("raceSelector").onchange = function () {
                var select = document.getElementById("raceSelector");
                var race = select.options[select.selectedIndex].text;

                localStorage.setItem('selectedAnimalRace', race);

                window.location.href = this.value;
            };

            $('tbody tr').on('click', function () {
                if ($(this).hasClass('selectedAnimal')) {
                    $(this).removeClass('selectedAnimal');
                } else {
                    $(this).addClass("selectedAnimal");
                }
                /*else if ($(".selectedAnimal").length > 2) {
                 $("#propagateButton").attr("disabled", true);
                 }*/

                var UUIDs = $(".selectedAnimal").map(function (i, o) {
                    return $(o).attr("data-uuid");
                }).get();

                //Disable buttons when nothing is selected
                if (UUIDs.length <= 0) {
                    $("#propagateButton").attr("disabled", true);
                    $("#giveBirthButton").attr("disabled", true);
                    $("#deleteButton").attr("disabled", true);
                }

                //Delete animals
                if (UUIDs.length >= 1) {
                    $("#deleteButton").removeAttr("disabled");
                }

                //If they can give birth
                if (UUIDs.length == 1) {
                    $.ajax({
                        url: "/overview/isPregnant",
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        dataType: 'json',
                        data: JSON.stringify(UUIDs),
                        async: false,
                        cache: false,
                        processData: false,
                        success: function (isPregnant) {
                            if (!isPregnant) {
                                return;
                            }
                            $("#giveBirthButton").removeAttr("disabled");
                        }
                    });
                }

                //When 2 animals are selected, they can propagate
                if (UUIDs.length == 2) {
                    $("#giveBirthButton").attr("disabled", true);

                    $.ajax({
                        url: "/overview/canPropagate",
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        dataType: 'json',
                        data: JSON.stringify(UUIDs),
                        async: false,
                        cache: false,
                        processData: false,
                        success: function (canPropagate) {
                            if (!canPropagate) {
                                return;
                            }
                            $("#propagateButton").removeAttr("disabled");
                        }
                    });
                }

                //When there are more then 2 selected, they can't propagate or give birth
                if (UUIDs.length > 2) {
                    $("#propagateButton").attr("disabled", true);
                    $("#giveBirthButton").attr("disabled", true);
                }
            });

            $("#propagateButton").on('click', function (e) {
                e.preventDefault();
                var UUIDs = $(".selectedAnimal").map(function () {
                    return $(this).attr("data-uuid");
                }).get();

                if (UUIDs.length != 2) {
                    return;
                }

                $.ajax({
                    url: "/overview/propagate",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    data: JSON.stringify(UUIDs),
                    async: false,
                    cache: false,
                    processData: false,
                    success: function (hasPropagated) {
                        if (!hasPropagated) {
                            return;
                        }
                        $("tbody tr").removeClass("selectedAnimal");
                        alert("Successfully propagated");
                    }
                });
            });

            $("#giveBirthButton").on('click', function (e) {
                e.preventDefault();
                var UUIDs = $(".selectedAnimal").map(function () {
                    return $(this).attr("data-uuid");
                }).get();

                if (UUIDs.length != 1) {
                    return;
                }

                $.ajax({
                    url: "/overview/giveBirth",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    data: JSON.stringify(UUIDs),
                    async: false,
                    cache: false,
                    processData: false,
                    success: function (hasGivenBirth) {
                        if (!hasGivenBirth) {
                            return;
                        }
                        alert("Successfully given birth");
                        location.reload();
                    }
                });
            });

            $("#deleteButton").on("click", function () {
                if (!confirm("Are you sure you want to delete this elephant?")) {
                    return;
                }
                var UUIDs = $(".selectedAnimal").map(function (i, o) {
                    return $(o).attr("data-uuid");
                }).get();

                $.ajax({
                    url: "/overview/delete",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    data: JSON.stringify(UUIDs),
                    async: false,
                    cache: false,
                    processData: false,
                    success: function (isDeleted) {
                        if (!isDeleted) {
                            return;
                        }
                        window.location.href = "/overview";
                    }
                });
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
    <a href="/overview/add">
        <button type="button" class="btn btn-outline-primary">Add animal</button>
    </a>

    <button type="button" class="btn btn-outline-primary" id="deleteButton" disabled>Delete animal</button>
    <button type="button" class="btn btn-outline-primary" disabled>Update animal</button>

    <br><br>
    <button type="button" class="btn btn-outline-primary" id="propagateButton" disabled>Propagate</button>
    <button type="button" class="btn btn-outline-primary" id="giveBirthButton" disabled>Give birth</button>

    <br><br><br>

    <select id="raceSelector" class="selectpicker" title="Select an animal race">
        <c:forEach var="availableAnimal" items="${availableAnimals}">
            <option value="/overview?race=${availableAnimal.getName()}">
                    ${availableAnimal.getSimpleName()}
            </option>
        </c:forEach>
    </select>
    <a href="/overview">
        <button type="button" class="btn btn-link">Remove filter</button>
    </a>
    <br><br>


    <table class="table table-responsive">
        <thead>
        <th>Type</th>
        <th>Gender</th>
        <th>Name</th>
        <th>Color</th>
        <th>Body covering</th>
        <th>Weight</th>
        <th>Max number of eggs</th>
        <th>Ear size</th>
        </thead>

        <tbody>
        <c:forEach var="Animal" items="${selectedAnimals}">
            <tr data-uuid="${Animal.getUuid()}">
                <td>${Animal.getClass().getSimpleName()}</td>
                <td>${Animal.getGender().getClass().getSimpleName()}</td>
                <td>${Animal.getName()}</td>
                <td style="color:${Animal.getColor()}">${Animal.getColor()}</td>
                <td>${Animal.getBodyCovering()}</td>
                <td>${Animal.getWeight()}</td>
                <td>${Animal.getMaxNumberOfEggs()}</td>
                <td>${Animal.getEarSize()}</td>
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