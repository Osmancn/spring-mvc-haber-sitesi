<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: 10.08.2018
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Profil</title>
</head>
<body class="wrapper col4">
    </br></br></br>
    <table align="center">
        <div align="center">
            <br/>ID= ${user.getid()}<br/>
            <br/>AD= ${user.ad}<br/>
            <br/>SOYAD= ${user.soyad}<br/>
            <br/>E-MAIL= ${user.email}<br/>
        </div>
    </table>
    </br></br></br></br></br></br></br></br></br></br></br></br>
    </br></br></br></br></br></br></br></br></br></br></br></br>
    <br class="clear">
    <div class="wrapper col7">
        <div id="copyright">
            <p class="fl_left">Telif Hakkı © 2014 - Bütün Hakkı Saklıdır - İND Bilişim</p>
            <p class="fl_right">Osmancan Güven</p>
            <br class="clear">
        </div>
    </div>
</body>
</html>
