<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>菜单</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<table border="1px" align="center">
    <tr>
        <td>功能列表</td>
    </tr>
    ${privilegeAMList}
    <c:forEach items="${privilegeAMList}" var="priv">
        <tr>
            <td>${priv.privName}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

