
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
<%--${list}--%>
<%--${empty(list)}--%>
<c:if test="${empty(list)}">
    您还没有任何角色，请添加！
</c:if>

<c:if test="${!empty(list)}">
    <table border="1px">
        <tr>
            <td>角色名称</td>
            <td>描述</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="role">
            <tr>
                <td>${role.name}</td>
                <td>${role.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/addprivilege?role_id=${role.id}">
                        为角色授权
                    </a>
                    <a href="#">删除角色</a>
                    <a href="#">修改角色</a>
                </td>
            </tr>
        </c:forEach>
    </table>


</c:if>



</body>
</html>
