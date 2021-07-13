<%--
  Created by IntelliJ IDEA.
  User: LongTran
  Date: 7/12/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.company.util.Mappings" %>

<html>
<head>
    <title>View Item</title>
</head>
<body>
<div align="center">
    

    <table border="1" cellpadding="5">
        <caption><h2>View Items</h2></caption>

        <tr>
            <th>ID</th>
            <th>Tittle</th>
            <th>Deadline</th>
            <th>Detail</th>
        </tr>

        <tr>
            // id, title, deadLine, details must match in TodoItem and AttributeName
            <td><c:out value="${todoItem69.id}"/></td>
            <td><c:out value="${todoItem69.title}"/></td>
            <td><c:out value="${todoItem69.deadLine}"/></td>
            <td><c:out value="${todoItem69.details}"/></td>
        </tr>
    </table>
    <c:url var="viewUrl" value="${Mappings.ITEMs}"/>
    <a href="${viewUrl}">Show Table</a>
</div>
</body>
</html>
