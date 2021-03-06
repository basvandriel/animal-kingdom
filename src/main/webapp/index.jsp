<%--
  Created by IntelliJ IDEA.
  User: Bas
  Date: 13-11-2016
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animal Kingdom</title>

    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron" style="background-color: rgba(79,130,233,0.89); color: white;">


    <div class="container text-center" style="text-shadow: 1px 1px 2px black, 0 0 25px #9aa5a9, 0 0 5px darkblue;"><h1>
        Animal Kingdom</h1>
    </div>
</div>

<div class="container">
    <div class="list-group">
        <a href="/overview" class="list-group-item list-group-item-action active">
            <h5 class="list-group-item-heading">Overview</h5>
            <p class="list-group-item-text">An overview of all the animals added to the Zoo. You can filter them by
                race.</p>
        </a>
        <br>

        <a href="/cages" class="list-group-item list-group-item-action active">
            <h5 class="list-group-item-heading">Cages</h5>
            <p class="list-group-item-text">An overview of all the cages in to the Zoo.</p>
        </a>
    </div>
</div>

<p>

</p>

</body>
</html>
