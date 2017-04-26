<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath}/">
	<meta charset="utf-8"/>
	<title>Tổ chức giao diện</title>
	<link href="css/layout.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<header>
			<h1>HWL GROUP</h1>
		</header>
		<nav>
                        <a href="home/index.htm">Trang chủ</a> |
                        <a href="home/about.htm">Giới thiệu</a> |
                        <a href="#">English</a> |
                        <a href="#">Tiếng Việt</a>
		</nav>
		<article>
                        <jsp:include page="${param.view}"/>
		</article>
		<aside>CONTROL PANEL</aside>
		<footer></footer>
	</div>
</body>
</html>
