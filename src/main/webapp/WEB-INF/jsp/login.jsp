<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/9 0009
  Time: 下午 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<form action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    账号:<input type="text" name="username" value="ym"><br/>
    <%--密码:<input type="text" name="pwd" value="123"><br/>--%>
    <input type="submit" value="登陆">
</form>
</body>
</html>
