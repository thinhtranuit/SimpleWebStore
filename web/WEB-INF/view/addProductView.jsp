<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 22-Mar-17
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<h1>Add New Product</h1>
<form method="post" action="doAddProduct">
    <p style="color:red;">${requestScope.error}</p>
    <table>
        <tr>
            <td>Product Code</td>
            <td>
                <input type="text" name="newCode" required/>
            </td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="newName" required></td>
        </tr>
        <tr>
            <td>Product Price</td>
            <td><input type="number" name="newPrice" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Change"></td>
        </tr>
    </table>
</form>
<jsp:include page="_footer.jsp"/>
</body>
</html>
