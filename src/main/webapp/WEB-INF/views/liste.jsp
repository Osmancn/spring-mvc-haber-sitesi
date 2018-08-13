<%--
  Created by IntelliJ IDEA.
  User: osman
  Date: 13.08.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste</title>
</head>
<body>
<c:if test="${not empty liste}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">AD</th>
            <th scope="col">SOYAD</th>
            <th scope="col">E-MAIL</th>
            <th scope="col">SIL</th>
            <th scope="col">ROL</th>
            <th scope="col">ROL DEĞİŞ</th>
        </tr>
        </thead>

        <tbody>
        <ul>
            <c:forEach var="listValue" items="${liste}">
                <tr>
                    <td>${listValue.getid()}</td>
                    <td>${listValue.ad}</td>
                    <td>${listValue.soyad}</td>
                    <td>${listValue.email}</td>
                    <td><button class="btn btn-danger" onclick="this.disabled= true;
                        location.href='${contextPath}/profil/${listValue.getid()}/delete'">Kaydı Sil</button></td>
                    <td> <select id="role">
                        <option value="GUEST">GUEST</option>
                        <option value="USER">USER</option>
                        <option value="ADMIN">ADMIN</option>
                    </select></td>
                    <td><button class="btn btn-info" onclick="this.disabled= true;
                        location.href='${contextPath}/profil/${listValue.getid()}/role/<%=request.getParameter("role")%>'">Rolü değiş</button></td>

                </tr>
            </c:forEach>
        </ul>
        </tbody>
    </table>

</c:if>

</body>
</html>

