<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: 27.08.2018
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Haber</title>
</head>
<body class="wrapper col7">
    <div id="container">
        <div id="featured_post">
            <img src="${haber.files[0].fileURL}" alt="" height="350" width="880">
            <p>${haber.title}</p>
            <p>${haber.description}</p>
            <p class="readmore"><a href="${haber.URL}" target="_blank">Devamını Oku »</a></p>
        </div>
    </div>

</body>
</html>
