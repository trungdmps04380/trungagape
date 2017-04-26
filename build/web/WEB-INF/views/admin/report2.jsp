<%-- 
    Document   : record
    Created on : Feb 27, 2017, 3:22:51 PM
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
        
    </head>
    <body>
        ${message}
   <%-- <form:form action="admin/insert.htm" modelAttribute="record">
        <div>
            <label>Nhân viên</label>
            <form:select path="staff.id"
                         items="${staffs}" itemValue="id" itemLabel="name"/>
        </div>
        <div>
            <label>Loại</label>
            <form:radiobutton path="type" value="true" label="Thành tích"/>
            <form:radiobutton path="type" value="false" label="Kỷ luật"/>
        </div>
        <div>
            <label>Lý do</label>
            <form:textarea path="reason" rows="3"/>
        </div>
        <div><button>Insert</button>
        </div>
    </form:form>
  --%>
    <table border="1" class="form-group">
        <tr>
            <th>Mã NV</th>
            <th>Tên NV</th>
            <th>Ngày sinh</th>
            <th>Tổng thành tích</th>
            <th>Tổng kỷ luật</th>
            <th>Tổng kết</th>
        </tr>
        <c:forEach var="ar" items="${arrays}">
            <tr>
                <td>${ar[0]}</td>
                <td>${ar[1] }</td>
                <td>${ar[2] }</td>
                <td>${ar[3] }</td>
                <td>${ar[4]}</td>
                <td>${ar[3] - ar[4]}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
