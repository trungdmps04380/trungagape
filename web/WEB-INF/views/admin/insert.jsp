<%-- 
    Document   : insert
    Created on : Feb 22, 2017, 4:15:44 PM
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
                font-size: 16px;
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="form-group"> ${message} </div>
    <form:form action="admin/insert.htm" modelAttribute="record">
        <div class="form-group">
            <label>Nhân viên</label>
            <form:select path="staff.id"
                         items="${staffs}" itemValue="id" itemLabel="name"/>
        </div>
        <div class="form-group">
            <label>Loại</label> <span>*</span>
            <form:radiobutton path="type" value="true" label="Thành tích"/>
            <form:radiobutton path="type" value="false" label="Kỷ luật"/>
            
            <form:errors path="type"/>
        </div>
        <div class="form-group">
            <label>Lý do</label>
            <form:textarea path="reason" rows="3"/>
        </div>
        <div class="form-group"><button>Insert</button>
        </div>
    </form:form>
</body>
</html>
