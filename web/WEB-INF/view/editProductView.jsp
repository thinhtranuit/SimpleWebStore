<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 19-Mar-17
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
    <h1>Edit Product</h1>
    <form method="post" action="doEditProduct">
        <table>
            <tr>
                <td>Product Code</td>
                <td style="color: red;">
                    <input type="text" value="${requestScope.product.code}" name="code" readonly/>
                </td>
            </tr>
            <tr>
                <td>Product Name</td>
                <td><input type="text" name="newName"></td>
            </tr>
            <tr>
                <td>Product Price</td>
                <td><input type="number" name="newPrice"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Change"></td>
            </tr>
        </table>
    </form>
<jsp:include page="_footer.jsp"/>
</body>
</html>
