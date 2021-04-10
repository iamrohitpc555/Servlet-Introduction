<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h3> Hi <%= request.getAttribute("user") %>, Login Successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>