<%-- 
    Document   : nhanvien
    Created on : Feb 25, 2017, 2:20:35 PM
    Author     : Do Tien Dung
--%>

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
            .d1{
                margin-left: 300px;
                
            }
        </style>
    </head>
    <body>
        <div class="d1">
        <h1>Quản lý nhân viên</h1>
        <div class="form-group"> ${message}</div>
        <form:form action="admin.htm" modelAttribute="student">
            <div class="form-group">
                <label>Id</label>
                <form:input path="id" cssClass="form-control"/> <span>*</span>
                <form:errors path="id"/>
            </div>

            <div class="form-group">
                <label>Name</label>
                <form:input path="name" cssClass="form-control"/> <span>*</span>
                <form:errors path="name"/>
            </div>

            <div class="form-group">
                <label>Gender</label>
                <div>
                    <form:radiobutton path="gender" value="true" label="Male"/>
                    <form:radiobutton path="gender" value="false" label="Female"/>
                </div>
            </div>

            <div class="form-group">
                <label>Birthday</label>
                <form:input path="birthday" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label>Photo</label>
                <form:input path="photo" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Email</label>
                <form:input path="email" cssClass="form-control"/> <span>*</span>
                <form:errors path="email"/>
            </div>
            <div class="form-group">
                <label>Phone</label>
                <form:input path="phone" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Salary</label>
                <form:input path="salary" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label>Note</label>
                <form:input path="notes" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label>DepartId</label>
                <form:select path="depart.id" cssClass="form-control"
                             items="${departs}" itemValue="id" itemLabel="name"/>
            </div>

            <div class="form-group text-center">
                <button name="btnInsert" class="btn btn-default">Insert</button>
                <button name="btnUpdate" class="btn btn-default">Update</button>
                <button name="btnDelete" class="btn btn-default">Delete</button>
                <button name="btnReset" class="btn btn-default">Reset</button>
            </div><br>
        </form:form>
        </div>
        <table border="1" class="form-group">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Photo</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Salary</th>
                <th>Note</th>
                <th>DeparId</th>
                <th></th>
            </tr>
            <c:forEach var="m" items="${students}">
                <tr>
                    <td>${m.id}</td>
                    <td>${m.name}</td>
                    <td>${m.gender}</td>
                    <td>${m.birthday}</td>
                    <td>${m.photo}</td>
                    <td>${m.email}</td>
                    <td>${m.phone}</td>
                    <td>${m.salary}</td>
                    <td>${m.notes}</td>
                    <td>${m.depart.name}</td>                   
                    <td><a href="admin/${m.id}.htm">Edit</a></td>
                </tr>
            </c:forEach>
        </table><br>

    </body>
</html>
