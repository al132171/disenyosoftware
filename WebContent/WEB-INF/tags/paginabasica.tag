<%@ tag description="Estructura d’una pàgina normal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilo.css">
<title>${title}</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<center>
				<h1>Jarcada</h1>
			</center>
		</div>
		<div id="logininfo">
				<t:logininfo />
			<div id="userType">
				<t:userType />
			</div>
		</div>
		<div id="content-container">
			<div id="content">
				<jsp:doBody />
			</div>
			<div id="footer">
				<br> 
				<p align="right">En colaboraci&oacute;n con el ayuntamiento de
					Castell&oacute;n
				<HR width=90% align="center">
				<p align="center">
					<a href="${pageContext.request.contextPath}/index.jsp">P&aacute;gina principal -</a> 
					<a href="${pageContext.request.contextPath}/somos.jsp">Quienes somos -</a> 
					<a href="${pageContext.request.contextPath}/contacto.jsp">Contacto-</a> 
					<a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a>
			</div>
		</div>
	</div>
</body>
</html>
