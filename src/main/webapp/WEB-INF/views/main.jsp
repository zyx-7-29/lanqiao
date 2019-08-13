<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.taru.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transition//BN" "http://www.w3.org/TR/htm14/loose.dtd">--%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
</head>
<body>
<table border="1" align="center">
    <tr>
        <td>用戶ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td>电话</td>
        <td>商店名</td>
        <td>地址</td>
        <td>备注</td>
        <td>状态</td>
        <td>操作</td>
    </tr>

 <c:forEach items="${users}" var="u">
     <tr>
         <td>${u.userId}</td>
         <td>${u.userUserName}</td>
         <td>${u.userPassword}</td>
         <td>${u.userTelphone}</td>
         <td>${u.userShopName}</td>
         <td>${u.userAddress}</td>
         <td>${u.userComment}</td>
         <td>${u.userStatus}</td>
         <td>
             <a href="/lanqiao-mvc-online/admin/delete?Id=${u.userId}">删除</a>
             <a href="/lanqiao-mvc-online/admin/alter?userId=<${u.userId}">修改</a>
         </td>
     </tr>
 </c:forEach>

</table>
</body>
</html>
