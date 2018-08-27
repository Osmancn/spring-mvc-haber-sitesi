<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: 7.08.2018
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Üye Giriş</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body class="wrapper col7">
<div class="wrapper col7">
    </br></br></br>
    <form method="POST" align="center" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading" style="font-family: Georgia">GİRİŞ YAP</h2>
        <div class="form-group" align="center">
            <div class="form-group  ${error != null ? 'has-error' : ''}">
                </br><span>${message}</span></br>
                </br>  <input type="email" name="email" class="form-control"  placeholder="Email" style="width: 250px" style="height:250px"></br>
                </br>  <input type="password" name="sifre" class="form-control"  placeholder="Parola"  style="width: 250px" style="height:250px" maxlength="6"></br>
                <span>${error}</span></br>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </br><button class="btn btn-primary btn-block" type="submit" style="width: 250px" style="height:250px">Giriş Yap</button></br>
                </br><button class="btn btn-info" style="width: 250px" style="height:250px"   onclick="this.disabled= true; location.href='${contextPath}/KayitOl'">Kayıt Olmak İçin Tıklayınız...</button>

                </br></br></br></br></br>
                <br class="clear">
            </div>
        </div>

    </form>

</div>
<div class="wrapper col7">

    <div id="copyright">
        <p class="fl_left">Telif Hakkı © 2014 - Bütün Hakkı Saklıdır - İND Bilişim</p>
        <p class="fl_right">Osmancan Güven</p>
        <br class="clear">
    </div>
</div>

</body>

</html>
