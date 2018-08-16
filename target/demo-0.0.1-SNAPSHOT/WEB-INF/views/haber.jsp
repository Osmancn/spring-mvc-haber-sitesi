<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Newserific
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <title>Haberler</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layout/styles/layout.css" type="text/css">
</head>
<body id="top">
<div class="wrapper col4">
    <div id="container">
        <div >
            <div id="featured_post"><img src="${haberList[0].files[0].fileURL}" alt="" height="350" width="880">
                <p>${haberList[0].title}</p>
                <p>${haberList[0].description}</p>
                <p class="readmore"><a href="#">Devamını Oku »</a></p>
            </div>

            <c:forEach var = "i" begin = "0" end = "10">
                <div id="hpage_latest">
                    <ul>
                        <c:forEach var = "j" begin = "1" end = "4">

                            <li><img src="${haberList[(i*4)+j].files[0].fileURL}" alt="img bulunamadı" height="80" width="190">
                                <p>${haberList[(i*4)+j].title}</p>
                                <p>${haberList[(i*4)+j].title}</p>
                                <p class="readmore"><a href="#">Devamını Oku »</a></p>
                            </li>

                        </c:forEach>
                    </ul>
                    <br class="clear"><br/>
                </div>
            </c:forEach>

        </div>

        <br class="clear">
    </div>
    <br class="clear">
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