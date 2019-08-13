
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>用户功能首页</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<c:if test="${empty(users)}">
    对不起，暂时没有任何客户
</c:if>

<c:if test="${!empty(users)}">

    <table border="1px" align="center">
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName}</td>
                <td>${user.userPassword}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/topower?user_id=${user.userId}">为用户授权角色</a>
                    <a href="#">修改用户</a>
                    <a href="#">删除用户</a>
                </td>
            </tr>
        </c:forEach>

    </table>

</c:if>
</body>
</html>
