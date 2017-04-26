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
            .form-group-id-dp{
                margin-left: 41px;
            }
            
        </style>
        
    </head>
    <body>
        <h1>Thông tin phòng ban</h1>
        <div class="form-group">  ${message}</div>
        <form:form action="admin/depart.htm" modelAttribute="depart">

            <div class="form-group-id-dp">
                <label>Id</label> 
                <form:input path="id" /> <span>*</span>
                <form:errors path="id"/>
            </div>
            <div class="form-group">
                <label>Name</label>
                <form:input path="name"/> <span>*</span>
                <form:errors path="name"/>
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
                <th>Id</th>
                <th>Name</th>
                <th></th>
            </tr>
            <c:forEach var="u" items="${departs}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>                                  
                    <td><a href="admin/depart/edit/${u.id}.htm">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
