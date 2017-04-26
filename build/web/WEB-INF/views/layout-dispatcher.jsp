<%
    String view = request.getParameter("view");
    if (view.startsWith("admin/")) {
        pageContext.forward("admin-layout.jsp");
    }
    else {
        pageContext.forward("login-layout.jsp");
    }
%>
