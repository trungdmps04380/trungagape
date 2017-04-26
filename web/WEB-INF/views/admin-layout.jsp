<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="utf-8"/>
        <base href="${pageContext.servletContext.contextPath}/">
	<title>Tổ chức giao diện</title>
	<link href="css/layout.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<header>
			<h1>HWL GROUP</h1>
		</header>
		<nav>
                        <a href="admin/list.htm">Quản lí tài khoản</a> |
                        <a href="admin.htm">Quản lí nhân viên</a> |
                        <a href="admin/depart.htm">Quản lí phòng ban</a> |
                        <a href="admin/report.htm">Kỷ Luật / Thành Tích</a> |
                        <a href="admin/insert.htm">Ghi Thành Tích / Kỷ Luật</a> |                       
                        <a href="admin/mail.htm">Gửi mail NV</a> |
                        <a></a>
                        <a></a>
                        <a href="home/logoff.htm"> Logoff</a>
		</nav>
		<article>
                    <jsp:include page="${param.view}"/>
		</article>
		<footer></footer>
	</div>
</body>
</html>
