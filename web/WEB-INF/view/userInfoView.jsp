<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 17-Mar-17
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
    <h3>Hello: ${user.userName}</h3>

    User Name: <b>${user.userName}</b>
    <br />
    Gender: ${user.gender } <br />
    <jsp:include page="_footer.jsp"/>
</body>
</html>
