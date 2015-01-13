<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- La session esta disponible automaticamente en el objete "session" -->
<c:set var="comprador" scope="request"
	value='${session.getAttribute("comprador")}' />

<p class="loggeduser">
	<c:choose>
		<c:when test='${comprador == null}'>
			<p align="right">
				No autenticado <a
					href="${pageContext.request.contextPath}/login.html">Entrar/</a> <a
					href="${pageContext.request.contextPath}/comprador/add.html">Registrarse</a>
		</c:when>
		<c:otherwise>
			<p align="right">
				Hola: ${comprador.nombreUsuario} <a href="${pageContext.request.contextPath}/logout.html">Salir</a>
				<a href="${pageContext.request.contextPath}/comprador/miCuenta/${comprador.codComprador}.html">Mi cuenta</a>	
				<a href="${pageContext.request.contextPath}/venta/misCompras/${comprador.codComprador}.html">Mis compras</a>
		</c:otherwise>
	</c:choose>
</p>