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

    <br><br><br>

    <form:form method="POST" action="/overview/add" id="animalForm" modelAttribute="animalForm">

    <div class="form-group row">
        <form:label for="inputName" class="col-sm-2 col-form-label" path="gender">Gender</form:label>

        <div class="col-sm-10">
            <form:select id="genderSelector" class="selectpicker" title=" " form="animalForm" path="gender">
                <c:forEach var="availableGender" items="${availableGenders}">
                    <option value="${availableGender.getName()}">
                            ${availableGender.getSimpleName()}
                    </option>
                </c:forEach>
            </form:select>
        </div>
    </div>


    <div class="form-group row">
        <form:label for="inputBodyCovering" class="col-sm-2 col-form-label" path="bodyCovering">Body covering</form:label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputBodyCovering" path="bodyCovering">
        </div>
    </div>

    <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputName" path="name">
        </div>
    </div>

    <div class="form-group row">
        <form:label for="inputColor" class="col-sm-2 col-form-label" path="color">Color</form:label>

        <div class="col-sm-10">
            <div id="cp2" class="input-group colorpicker-component">
                <form:input type="text" value="" class="form-control" id="inputColor" path="color"/>
                <span class="input-group-addon"><i></i></span>
            </div>
        </div>
    </div>

    <div class="form-group row">
        <form:label for="inputWeight" class="col-sm-2 col-form-label" path="weight">Weight</form:label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputWeight" path="weight">
        </div>
    </div>


    <div class="form-group row">
        <form:label for="inputMaxNumberOfEggs" class="col-sm-2 col-form-label" path="maxNumberOfEggs">Max number of eggs</form:label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control" id="inputMaxNumberOfEggs" path="maxNumberOfEggs">
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
    });

</script>
</body>