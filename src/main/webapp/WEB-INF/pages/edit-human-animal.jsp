<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animals overview</title>


    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css" type="text/css">

    <link rel="stylesheet" href="../webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css" type="text/css">

    <script src="../webjars/jquery/3.1.1/jquery.min.js" type="application/javascript"></script>
    <script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js" type="application/javascript"></script>
    <script src="../webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js" type="application/javascript"></script>

    <script src="/webjars/bootstrap-colorpicker/2.3.6/dist/js/bootstrap-colorpicker.min.js"></script>
    <link rel="stylesheet" href="../webjars/bootstrap-colorpicker/2.3.6/dist/css/bootstrap-colorpicker.min.css">

    <script type="application/javascript">
        $(document).ready(function () {
            $(".selectpicker").selectpicker();
        });
    </script>
</head>
<body>

<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center" style="text-shadow: 1px 1px 2px black, 0 0 25px #9aa5a9, 0 0 5px darkblue;">
        <h1>Edit animal</h1>
    </div>
</div>

<div class="container" style="width: 85%;">

    <form id="animalForm" action="/overview/edit" method="POST">
        <input type="hidden" name="uuid" readonly value="${animal.getUuid()}">

        <div class="form-group row">
            <label for="genderSelector" class="col-sm-2 col-form-label">Gender</label>

            <div class="col-sm-10">
                <select id="genderSelector" class="selectpicker"
                        title="${animal.getGender().getClass().getSimpleName()}" form="animalForm" name="gender">
                    <c:forEach var="gender" items="${genders}">
                        <option
                                <c:if test="${animal.getGender().getClass().getName() == gender.getName()}">selected="selected"</c:if>
                                value="${gender.getName()}">
                                ${gender.getSimpleName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group row">
            <label for="inputBodyCovering" class="col-sm-2 col-form-label">Body covering</label>
            <div class="col-sm-10">
                <input type="text" name="bodyCovering" class="form-control" id="inputBodyCovering"
                       value="${animal.getBodyCovering()}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="inputName" value="${animal.getName()}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Insertion</label>
            <div class="col-sm-10">
                <input type="text" name="insertion" class="form-control" id="inputInsertion"
                       value="${animal.getInsertion()}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">Last name</label>
            <div class="col-sm-10">
                <input type="text" name="lastName" class="form-control" id="inputLastName"
                       value="${animal.getLastName()}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputColor" class="col-sm-2 col-form-label">Color</label>

            <div class="col-sm-10">
                <div id="cp2" class="input-group colorpicker-component">
                    <input type="text" name="color" class="form-control" id="inputColor" value="${animal.getColor()}"/>
                    <span class="input-group-addon"><i></i></span>
                </div>
            </div>
        </div>

        <div class="form-group row">
            <label for="inputWeight" class="col-sm-2 col-form-label">Weight</label>
            <div class="col-sm-10">
                <input type="text" name="weight" class="form-control" id="inputWeight" value="${animal.getWeight()}">
            </div>
        </div>


        <div class="form-group row">
            <label for="inputMaxNumberOfEggs" class="col-sm-2 col-form-label">Max number of eggs</label>
            <div class="col-sm-10">
                <input type="text" name="maxNumberOfEggs" class="form-control" id="inputMaxNumberOfEggs"
                       value="${animal.getMaxNumberOfEggs()}">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputMaxNumberOfEggs" class="col-sm-2 col-form-label">Using birth control</label>
            <div class="col-sm-10">
                <input type="checkbox" class="form-control form-check-input" id="inputUsingBirthControl"
                       name="usingBirthControl" <c:if test="${animal.isUsingBirthControl() == true}">checked</c:if>>
            </div>
        </div>

        <br>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Edit animal</button>
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