
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>添加角色页面</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<c:forEach items="${list}" var="role">
    <tr>
        <td>${role.name}</td>
        <td>${role.description}</td>
        <td>
            <a href="${pageContext.request.contextPath}/LookRolePrivilege?role_id=${role.id}">
                为角色授权
            </a>
            <a href="#">删除角色</a>
            <a href="#">修改角色</a>
        </td>
    </tr>
</c:forEach>

</body>
</html>
