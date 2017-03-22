<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 17-Mar-17
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
    <h1>Login Page</h1>
    <p style="text-decoration-color: red">${requestScope.error}</p>
    <form method="post" action="doLogin">
        <table>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="userName" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Remember Me!</td>
                <td><input type="checkbox" name="remember" value="Y"></td>
            </tr>
        </table>
        <input type="submit" value="Login">
    </form>
    <jsp:include page="_footer.jsp"/>
</body>
</html>
