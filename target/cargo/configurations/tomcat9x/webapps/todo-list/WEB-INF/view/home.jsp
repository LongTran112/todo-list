<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LongTran
  Date: 7/11/2021
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.company.util.Mappings" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
<div align="center">
    <c:url var="itemsLink" value="${Mappings.ITEMs}"/>
    <h2><a href="${itemsLink}">Show Todo Items</a></h2>
</div>

</body>
</html>
