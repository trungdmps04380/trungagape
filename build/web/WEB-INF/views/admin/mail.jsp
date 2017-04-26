<%-- 
    Document   : mail
    Created on : Feb 17, 2017, 3:02:33 PM
    Author     : Do Tien Dung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${pageContext.servletContext.contextPath}/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send email</title>
    </head>
    <div class="form-group"
    <body>
       <div class="form-group">  ${message} </div> 
        <form action="admin/send.htm" method="post">
            <p><input name="from" placeholder="From"></p>
            <p><input name="to" placeholder="To"></p>
            <p><input name="subject" placeholder="Subject"></p>
            <p><textarea name="body" placeholder="Body" rows="3" cols="30"></textarea></p>
            <button>Send</button>
        </form>
    </body>
    </div>
</html>
