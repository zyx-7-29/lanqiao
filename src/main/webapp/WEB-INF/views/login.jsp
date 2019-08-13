<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transition//BN" "http://www.w3.org/TR/htm14/loose.dtd">--%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html:charset=UTF-8">
            <title>登陆页面</title>
            <link type="text/css" rel="stylesheet" href="/static/css/index.css"/>
    </head>
    <body>

<form action="/admin/login" method="post">

    <table>
        <tr>
            <td>用戶名：</td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>

        <tr>
            <td>密码：</td>
            <td>
                <input type="text" name="password"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="登录"/>
            </td>
        </tr>
<%--        <%=String.valueOf(request.getAttribute("loginError")) %><!--  JSP 内置对象，request-->--%>
        ${logixnError}<!-- EL表达式  和上边的代码作用是一样的-->
    </table>
</form>
</body>
</html>
