<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/4/2020
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css_img/css_index.css">
</head>
<body>

<!-- Header -->
<header>
    <div class="container-fluid">
        <div class="row">
            <div class="col-2">
                <a  href="#"><img src="css_img/logo.jpg" width="50" height="50"/></a>
            </div>
            <div class="col-8"></div>
            <div class="col-2 text-center">Le Van Hoat</div>
        </div>
    </div>
</header>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/employee">Employee <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Contract</a>
                </li>
            </ul>
        </div>
        <form class="form-inline my-2 my-lg-0" style="float: right">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<!-- Page Body -->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
            <div>item one</div>
            <div>item two</div>
            <div>item three</div>
        </div>
        <div class="col-lg-9">
            <a  href="#"><img src="css_img/body.jpg" width="800" height="500"/></a>
        </div>
    </div>
</div>
<footer>
    <div class="container-fluid padding">
        <div class="row text-center col-12">
            <p>Furama &copy;2020. All rights reserved.</p>
        </div>
    </div>
</footer>
    <!-- navigation -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
