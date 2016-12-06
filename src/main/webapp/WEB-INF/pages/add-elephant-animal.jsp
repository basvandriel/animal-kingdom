<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <script src="/webjars/bootstrap-colorpicker/2.3.6/dist/js/bootstrap-colorpicker.min.js"></script>
    <link rel="stylesheet" href="../webjars/bootstrap-colorpicker/2.3.6/dist/css/bootstrap-colorpicker.min.css">
    <script type="application/javascript">
        $(document).ready(function () {

            $(".selectpicker").selectpicker();

            if (localStorage.getItem('add-animal-raceSelectorOption') != "undefined") {
                console.log("get here?");
                var selectedAnimalRaceOptionIndex = localStorage.getItem('add-animal-raceSelectorOption');
                var selectedAnimalRaceOption = document.getElementById('add-animal-raceSelector').options[selectedAnimalRaceOptionIndex];

                //Elements for setting the dropdown title
                $('button[data-id="add-animal-raceSelector"]').attr("title", selectedAnimalRaceOption.text);
                $('button[data-id="add-animal-raceSelector"] span.filter-option').text(selectedAnimalRaceOption.text);

                console.log(typeof selectedAnimalRaceOptionIndex);

                document.getElementById('add-animal-raceSelector').options[selectedAnimalRaceOptionIndex].selected = true;

//                localStorage.setItem('add-animal-raceSelectorTitle', "Select an animal race");
                localStorage.setItem('add-animal-raceSelectorOption', undefined);
            };


            document.getElementById("add-animal-raceSelector").onchange = function () {
                console.log("what the fck");
                var select = document.getElementById("add-animal-raceSelector");
                localStorage.setItem('add-animal-raceSelectorOption', select.selectedIndex);

                window.location.href = "/overview/add?race=" + this.value;
            };


        });
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
    <select id="add-animal-raceSelector" class="selectpicker" title="Select an animal race">
        <c:forEach var="availableAnimal" items="${availableAnimals}">
            <option value="${availableAnimal.getName()}">
                    ${availableAnimal.getSimpleName()}
            </option>
        </c:forEach>
    </select>

    <br><br><br>

    <form id="animalForm" action="/overview/add" method="POST">

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Gender</label>

            <div class="col-sm-10">
                <select id="genderSelector" class="selectpicker" title=" " form="animalForm">
                    <c:forEach var="availableGender" items="${availableGenders}">
                        <option value="${availableGender.getName()}">
                                ${availableGender.getSimpleName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group row">
            <label for="inputBodyCovering" class="col-sm-2 col-form-label">Body covering</label>
            <div class="col-sm-10">
                <input type="text" name="bodyCovering" class="form-control" id="inputBodyCovering">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="name" name="name" class="form-control" id="inputName">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputColor" class="col-sm-2 col-form-label">Color</label>

            <div class="col-sm-10">
                <div id="cp2" class="input-group colorpicker-component">
                    <input type="text" name="color" value="" class="form-control" id="inputColor"/>
                    <span class="input-group-addon"><i></i></span>
                </div>
            </div>
        </div>

        <div class="form-group row">
            <label for="inputWeight" class="col-sm-2 col-form-label">Weight</label>
            <div class="col-sm-10">
                <input type="text" name="weight" class="form-control" id="inputWeight">
            </div>
        </div>


        <div class="form-group row">
            <label for="inputMaxNumberOfEggs" class="col-sm-2 col-form-label">Max number of eggs</label>
            <div class="col-sm-10">
                <input type="text" name="maxNumberOfEggs" class="form-control" id="inputMaxNumberOfEggs">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputEarSize" class="col-sm-2 col-form-label">Ear size</label>
            <div class="col-sm-10">
                <input type="text" name="earSize" class="form-control" id="inputEarSize">
            </div>
        </div>

        <br>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Add animal</button>
            </div>
        </div>
    </form>

    <br><br>

    <br><br>

    <a href="/overview">
        <button type="button" class="btn btn-link">Overview</button>
    </a>

    <a href="/">
        <button type="button" class="btn btn-link">Home page</button>
    </a>


</div>
<script type="text/javascript">

    $(function () {
        $('#cp2').colorpicker({/*options...*/});
        console.log(" hey");
    });

</script>
</body>