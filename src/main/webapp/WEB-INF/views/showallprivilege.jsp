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
<c:if test="${empty(list)}">
    您还没添加任何的权限
</c:if>

<c:if test="${!empty(list)}">
    <table border="1px">
        <tr>
            <td>权限名称</td>
            <td>权限等级</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="privilege">
            <tr>
                <td>${privilege.privName}</td>
                <td>${privilege.privLevel}</td>
                <td>
                    <a href="#">删除权限</a>
                    <a href="#">修改权限</a>
                </td>

            </tr>

        </c:forEach>
    </table>

</c:if>


</body>
</html>
