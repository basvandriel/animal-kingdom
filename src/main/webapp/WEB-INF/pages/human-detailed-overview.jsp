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


    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="../webjars/bootstrap-select/1.9.4/css/bootstrap-select.min.css">

    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

    <script src="../webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../webjars/bootstrap-select/1.9.4/js/bootstrap-select.min.js"></script>

    <script type="text/javascript"></script>

</head>
<body>
<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center"><h1>Detailed human overview</h1></div>
</div>

<div class="container" style="width: 85%;">

    <button type="button" class="btn btn-outline-primary" disabled>Delete animal</button>
    <button type="button" class="btn btn-outline-primary" disabled>Update animal</button>

    <br><br><br>
    <button type="button" class="btn btn-outline-primary" id="divorceButton" disabled>Divorce</button>
    <br><br>
    <div class="col-md-6">
        <h1>Properties</h1>
        <hr>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Gender</label>
            <div class="col-sm-10">
                <p>${human.getGender().getClass().getSimpleName()}</p>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-10">
                <p>${human.getName()}</p>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Insertion</label>
            <div class="col-sm-10">
                <p>${human.getInsertion()}</p>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Last name</label>
            <div class="col-sm-10">
                <p>${human.getLastName()}</p>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Body covering</label>
            <div class="col-sm-10">
                <p>${human.getBodyCovering()}</p>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Color</label>

            <div class="col-sm-10">
                <p>${human.getColor()}</p>

            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Weight</label>
            <div class="col-sm-10">
                <p>${human.getWeight()}</p>
            </div>
        </div>


        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Max number of eggs</label>
            <div class="col-sm-10">
                <p>${human.getMaxNumberOfEggs()}</p>
            </div>
        </div>


        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Using birth control</label>
            <div class="col-sm-10">
                <p>${human.isUsingBirthControl()}</p>
            </div>
        </div>

        <h3>STDs</h3>
        <hr>
        <table class="table table-responsive">
            <thead>
            <th>Name</th>
            </thead>

            <tbody>
            <c:forEach var="humanSTD" items="${animal.getSTDs()}">
                <tr>
                    <td>${animalSTD.getName()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="col-md-6">
        <c:if test="${human.getPartner() != null}">

            <h1>Partner properties</h1>
            <hr>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getGender().getClass().getSimpleName()}</p>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getName()}</p>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Insertion</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getInsertion()}</p>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Last name</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getLastName()}</p>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Body covering</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getBodyCovering()}</p>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Color</label>

                <div class="col-sm-10">
                    <p>${human.getPartner().getColor()}</p>

                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Weight</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getWeight()}</p>
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Max number of eggs</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().getMaxNumberOfEggs()}</p>
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Using birth control</label>
                <div class="col-sm-10">
                    <p>${human.getPartner().isUsingBirthControl()}</p>
                </div>
            </div>

            <h3>STDs</h3>
            <hr>
            <table class="table table-responsive">
                <thead>
                <th>Name</th>
                </thead>

                <tbody>
                <c:forEach var="humanSTD" items="${animal.getPartner().getSTDs()}">
                    <tr>
                        <td>${animalSTD.getName()}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </c:if>
    </div>


    <br><br><br>

    <a href="/">
        <button type="button" class="btn btn-link">Home page</button>
    </a>
</div>

</body>