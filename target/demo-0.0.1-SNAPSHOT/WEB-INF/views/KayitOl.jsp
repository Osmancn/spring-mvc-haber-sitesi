<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: 7.08.2018
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<html>

<head>

    <title>Kayıt Ol</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <h2 align="center"> Kayıt Ol</h2>
    <form method="post" action="/KayitOl" modelAttribute="userForm" align="center" enctype="multipart/form-data">

        <div class="form-group" align="center">
            <div class="form-group">
                </br>  <input type="text" name="ad" class="form-control" placeholder="AD"
                              style="width: 250px" style="height:250px" required="required"></br>
            </div>
            <div class="form-group">
                </br>  <input type="text" name="soyad" class="form-control"  placeholder="SOYAD"
                              style="width: 250px" style="height:250px" required="required"></br>
            </div>
            <div class="form-group">
                </br>  <input type="email" name="email" class="form-control"  placeholder="E-MAIL"
                              style="width: 250px" style="height:250px" required="required"></br>
            </div>
            <div class="form-group">
                </br>  <input type="password" name="sifre" class="form-control"  placeholder="SİFRE"
                              style="width: 250px" style="height:250px" required="required"></br>
            </div>
        </div>

        </br><br><input type="submit" class="btn btn-primary"><br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>

