
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>角色授权左边页面</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/showuser" target="body">用户管理</a><br><br><br><br>
<a href="${pageContext.request.contextPath}/admin/showallroles" target="body">角色管理</a><br><br><br><br>
<a href="${pageContext.request.contextPath}/admin/showprivilege" target="body">权限管理</a><br><br><br><br>

</body>
</html>
