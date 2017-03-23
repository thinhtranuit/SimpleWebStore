<%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 19-Mar-17
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <style>
        .border-table{
            border: 1px black solid;
            text-align: center;
        }
    </style>
</head>
<body>
    <jsp:include page="_header.jsp"/>
    <jsp:include page="_menu.jsp"/>
    <h4 style="color: red">${requestScope.error}</h4>
    <table class="border-table">
        <tr>
            <th class="border-table">Product Code</th>
            <th class="border-table">Product Name</th>
            <th class="border-table">Product Price</th>
            <th class="border-table">Delete Product</th>
            <th class="border-table">Edit Product</th>
        </tr>
        <c:forEach items="${requestScope.products}" var="product">
            <tr>
                <td class="border-table">${product.code}</td>
                <td class="border-table">${product.name}</td>
                <td class="border-table">${product.price}</td>
                <td class="border-table">
                    <a href="deleteProduct?code=${product.code}">Delete</a>
                </td>
                <td class="border-table">
                    <a href="editProduct?code=${product.code}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn" href="${pageContext.request.contextPath}/addProduct">Add New Product</a>
    <jsp:include page="_footer.jsp"/>
</body>
</html>
