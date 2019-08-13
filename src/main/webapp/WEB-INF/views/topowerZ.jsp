
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>用户授权页</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>

<table border="1px">
    <tr>
        <td>当前用户名称</td>
        <td>${user.userName}</td>
    </tr>

    <tr>
        <td>当前用户所拥有的角色</td>
        <td>
            <c:forEach items="${userRoles}" var="userRole">
                ${userRole.name}
            </c:forEach>
        </td>
    </tr>

    <tr>
        <td>当前系统所拥有的角色</td>
        ${allRoles}
        <td>
            <form method="post" action="${pageContext.request.contextPath}/admin/addrole">

                <%--要为用户添加角色，需要知道是哪一个用户，通过hidden传递过去用户的id--%>
                <input type="hidden" name="user_id" value="${user.userId}">

                <c:forEach items="${allRoles}" var="roles">
                    <input type="checkbox" name="role_id" value="${roles.id}">
                    ${roles.name}
                </c:forEach>

                <input type="submit" value="添加角色！">
            </form>
        </td>
    </tr>

</table>


</body>
</html>
