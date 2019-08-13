
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>添加用户角色页面</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<body>
<form action="${pageContext.request.contextPath}/AddRoleController" method="post">
    <table border="1px">
        <tr>
            <td>角色名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>详细描述</td>
            <td><textarea name="description"  cols="30" rows="10"></textarea></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="添加角色">
            </td>
        </tr>
    </table>

</form>


</body>
</html>
