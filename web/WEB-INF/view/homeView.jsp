<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 16-Mar-17
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Store</title>
    <link href="${pageContext.request.contextPath}/WEB-INF/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/WEB-INF/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
    <h1>Welcome to my online fucking store</h1>
    <b>It includes the following functions:</b>
    <ul>
        <li>Login</li>
        <li>Storing user information in cookies</li>
        <li>Product List</li>
        <li>Create Product</li>
        <li>Edit Product</li>
        <li>Delete Product</li>
    </ul>
    <jsp:include page="_footer.jsp"/>
</body>
</html>
