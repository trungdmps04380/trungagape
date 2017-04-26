<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="${pageContext.servletContext.contextPath}/">
        <title>JSP Page</title>
        <style type="text/css">
            *[id$=errors]{
                color:red;
                font-style: italic;
            }
            span{
                color: red;
                font-size: 16px;
            }
        </style>


    </head>
    <body>
        <h1>Thông tin tài khoảng</h1>
        <div class="form-group">  ${message} </div>
        <form:form action="admin/list.htm" modelAttribute="user">

            <div class="form-group">
                <label>Username</label>
                <form:input path="username"/> <span>*</span>
                <form:errors path="username"/>
            </div>
            <div class="form-group">
                <label>Password</label>
                <form:input path="password"/> <span>*</span>
                <form:errors path="password"/>
            </div>
            <div class="form-group">
                <label>Fullname</label>
                <form:input path="fullname"/> <span>*</span>
                <form:errors path="fullname"/>
            </div>
            <div class="form-group">
                <button name="btnInsert" class="btn btn-default">Insert</button>
                <button name="btnUpdate" class="btn btn-default">Update</button>
                <button name="btnDelete" class="btn btn-default">Delete</button>
                <button name="btnReset" class="btn btn-default">Reset</button>
            </div>

        </form:form>
        <table border="1" class="form-group">

            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Fullname</th>
                <th></th>
            </tr>
            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.username}</td>
                    <td>${u.password}</td>
                    <td>${u.fullname}</td>                                    
                    <td><a href="admin/list/edit/${u.username}.htm">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
