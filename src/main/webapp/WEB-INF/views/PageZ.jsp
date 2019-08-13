<%--
  Created by IntelliJ IDEA.
  User: zyx3.2
  Date: 2019/8/3
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/adduser" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加用户"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
        ${AddUser}
    </table>
</form>



</body>
</html>
