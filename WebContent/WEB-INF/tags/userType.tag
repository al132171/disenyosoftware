<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- La session esta disponible automaticamente en el objete "session" -->
<c:set var="comprador" scope="request"
	value='${session.getAttribute("comprador")}' />

<p class="loggeduser">
	<c:choose>
		<c:when test='${comprador != null}'>
			<p align="right">
				<c:choose>
				<c:when test='${comprador.tipo.equals("A")}'>
					Gestionar:
					<a href="${pageContext.request.contextPath}/edificio/list.html">edificios</a>
					<a href="${pageContext.request.contextPath}/sala/list.html">salas</a>
					<a href="${pageContext.request.contextPath}/espectaculo/listAdmin.html">espectaculos</a>
					<a href="${pageContext.request.contextPath}/sesion/listAdminDirecto.html">sesiones</a>
					<a href="${pageContext.request.contextPath}/responsable/list.html">responsables</a>
					<a href="${pageContext.request.contextPath}/comprador/list.html">usuarios</a>
					<a href="${pageContext.request.contextPath}/venta/listAdmin.html">ventas</a>
				</c:when>
				</c:choose>
		</c:when>
	</c:choose>
</p>