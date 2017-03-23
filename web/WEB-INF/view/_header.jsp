<%@ page import="ultis.MyUtils" %><%--
  Created by IntelliJ IDEA.
  User: THINH TRAN
  Date: 16-Mar-17
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="row" style="background: #E0E0E0;">
    <div class="col-md-4">
        <a style="text-decoration: none;" href="${pageContext.request.contextPath}/home" ><h1>My Site</h1></a>
    </div>
    <div class="col-md-8">
        Hello <b>${sessionScope.loginedUser.userName}</b><a href="${pageContext.request.contextPath}/logout"><%
        if (MyUtils.getLoginedUser(request.getSession()) != null){
            %>Đăng xuất<%
        }
        %></a>
        <br/>
        Search <input name="search">
    </div>
</div>
