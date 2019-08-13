
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>角色授权页</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<table border="1px">
    <tr>
        <td>角色名称</td>
        <td>${role.name}</td>
    </tr>

    <tr>
        <td>当前角色拥有的权利</td>
        <td>
            <c:forEach items="${rolePrivilege}" var="privi">
                ${privi.privName}
            </c:forEach>
        </td>
    </tr>

    ${allPrivilege}
    <tr>
        <td>系统拥有的所有权利</td>
        <td>
            <form action="${pageContext.request.contextPath}/admin/addquan" method="post">
                <%--让服务器知道要修改哪一个用户，就要把用户的id传递过去--%>
                <input type="hidden" name="role_id" value="${role.id}">

                <c:forEach items="${allPrivilege}" var="privileges">
                    ${privileges.privId}
                    <input type="checkbox" name="privilege_id" value="${privileges.privId}">${privileges.privName}
                </c:forEach>
                <input type="submit" value="添加权利">
            </form>
        </td>
    </tr>
</table>


</body>
</html>
