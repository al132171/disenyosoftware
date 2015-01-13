<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<head>
<meta charset="iso">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Simulador | APPujimática</title>

<!-- core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/responsive.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/error.css"
	rel="stylesheet">

<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">

<script>
	function ordenadorDecorado() {
		alert("ENTRÉ");
		var ord = ordenadorDecorado.split('\n');
		for (var i = 0; i < ord.length; i++)
			ord[i] = document.getElementById('resumen');
	}
</script>

</head>
<!--/head-->

<body>

	<header id="header">
		<div class="top-bar">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-xs-4">
						<div class="top-number">
							<p>
								<i class="fa fa-phone-square"></i> +0123 456 70 90
							</p>
						</div>
					</div>
					<div class="col-sm-6 col-xs-8">
						<div class="social">
							<div class="search">
								<c:choose>
									<c:when test="${empty identificador}">
										<a
											href="${pageContext.request.contextPath}/usuario/login.html"><strong>Iniciar
												sesión</strong></a>
										<span>&nbsp;&nbsp;&nbsp;<strong>|</strong>&nbsp;&nbsp;&nbsp;
										</span>
										<a href="registro.jsp"><strong>Registro</strong></a>
									</c:when>
									<c:otherwise>
										<font color="#FFF"><strong>Bienvenido <%
											if (session.getAttribute("puesto").equals("A")) {
										%>
												${identificador}
										</strong></font>
										<%
											} else {
										%>
										<a
											href="${pageContext.request.contextPath}/usuario/perfil.html">${identificador}</strong></font>
											<%
												}
											%> <a
											href="${pageContext.request.contextPath}/usuario/logout.html">
												[Desconectar] </a>
									</c:otherwise>
								</c:choose>

							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/.container-->
		</div>

		<nav class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/index.jsp"><img
						src="${pageContext.request.contextPath}/images/logo-min.png"
						alt="logo"></a>
				</div>

				<div class="collapse navbar-collapse navbar-right">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
						<li><a
							href="${pageContext.request.contextPath}/catalogo/productos.html">Productos</a></li>
						<li class="active"><a
							href="${pageContext.request.contextPath}/simulador/simulador.html">Configurador</a></li>
						<li><a
							href="${pageContext.request.contextPath}/contact-us.jsp">Contacto</a></li>
						<li><a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a></li>
					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->

	</header>
	<!--/header-->


	<c:choose>
		<c:when test="${empty identificador}">

			<section id="atencion" class="transparent-bg">
				<div class="container">
					<div class="get-started center wow fadeInDown animated"
						id="atencion" style="background-color: #FECACA;">
						<h2>¡Atención!</h2>
						<p class="lead">
						<h2>Sólo los usuarios registrados pueden acceder al simulador
							de ordenadores</h2>
						<h3>
							¿Eres usuario? <a
								href="${pageContext.request.contextPath}/usuario/login.html"
								class="btn btn-primary">Acceder</a>
						</h3>
						<h3>
							¿Aún no eres usuario? <a
								href="${pageContext.request.contextPath}/usuario/registro.html"
								class="btn btn-primary">Regístrarse gratis</a>
						</h3>
						</p>
					</div>
					<div class="row contact-wrap">
						<div class="status alert alert-success" style="display: none"></div>
					</div>
				</div>
				<!--/.item-->
			</section>
		</c:when>
		<c:otherwise>
		



		<br><br><br><br>
			<section id="feature" class="transparent-bg">
				<div class="container">
					<div class="get-started center wow fadeInDown animated"
						id="simulador">
						<h2>Configurador</h2>
						<p class="lead">Elige los componentes de tu futuro PC</p>
					</div>
					<div class="row contact-wrap">
						<div class="status alert alert-success" style="display: none"></div>
						<form:form class="contact-form" method="post"
							modelAttribute="ordenador">

							<div class="col-sm-5 col-sm-offset-1">
								<div class="form-group">
									<form:label path="idPlacaBase">Placa base</form:label>
									<form:select path="idPlacaBase" name="placa"
										class="form-control" required="required">

										<c:choose>
											<c:when test="${ordenador.idPlacaBase eq 0 }">
												<option selected value="0">Selecciona una placa
													base</option>
												<c:forEach items="${placasBase}" var="pb"
													varStatus="loopStatus">
													<option value="${pb.id}">${pb.modelo}-
														${pb.socketProcesador}, ${pb.interfazDiscoDuro} ,
														${pb.tipoRam}, ${pb.interfazDvd}, ${pb.busTj},
														${pb.modelo}, Precio: ${pb.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona una placa base</option>
												<c:forEach items="${placasBase}" var="pb"
													varStatus="loopStatus">

													<c:choose>
														<c:when test="${pb.id eq ordenador.idPlacaBase}">
															<option selected value="${pb.id}">${pb.modelo}-
																${pb.socketProcesador}, ${pb.interfazDiscoDuro} ,
																${pb.tipoRam}, ${pb.interfazDvd}, ${pb.busTj},
																${pb.modelo}, Precio: ${pb.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${pb.id}">${pb.modelo}-
																${pb.socketProcesador}, ${pb.interfazDiscoDuro} ,
																${pb.tipoRam}, ${pb.interfazDvd}, ${pb.busTj},
																${pb.modelo}, Precio: ${pb.precio}€</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idPlacaBase" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idProcesador">Procesador</form:label>
									<form:select path="idProcesador" name="procesador"
										class="form-control" required="required">

										<c:choose>
											<c:when test="${ordenador.idProcesador eq 0 }">
												<option selected value="0">Selecciona un procesador</option>
												<c:forEach items="${procesador}" var="pr"
													varStatus="loopStatus">
													<option value="${pr.id}">${pr.modelo}-Núcleos:
														${pr.nucleos}, Frecuencia: ${pr.frecuencia} , ${pr.marca},
														${pr.socket}, Precio: ${pr.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona un procesador</option>
												<c:forEach items="${procesador}" var="pr"
													varStatus="loopStatus">

													<c:choose>
														<c:when test="${pr.id eq ordenador.idProcesador}">
															<option selected value="${pr.id}">${pr.modelo}-Núcleos:
																${pr.nucleos}, Frecuencia: ${pr.frecuencia} ,
																${pr.marca}, ${pr.socket}, Precio: ${pr.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${pr.id}">${pr.modelo}-Núcleos:
																${pr.nucleos}, Frecuencia: ${pr.frecuencia} ,
																${pr.marca}, ${pr.socket}, Precio: ${pr.precio}€</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idProcesador" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idRAM">Memoria RAM</form:label>
									<form:select path="idRAM" name="ram" class="form-control"
										required="required">

										<c:choose>

											<c:when test="${ ordenador.idRAM eq 0 }">
												<option selected value="0">Selecciona memoria RAM</option>
												<c:forEach items="${ram}" var="ram" varStatus="loopStatus">
													<option value="${ram.id}">${ram.modelo}-
														${ram.tipo}, ${ram.capacidad} , Precio: ${ram.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona memoria RAM</option>
												<c:forEach items="${ram}" var="ram" varStatus="loopStatus">

													<c:choose>
														<c:when test="${ram.id eq ordenador.idRAM }">
															<option selected value="${ram.id}">${ram.modelo}-
																${ram.tipo}, ${ram.capacidad} , Precio: ${ram.precio}€</option>
														</c:when>
														<c:otherwise>

															<option value="${ram.id}">${ram.modelo}-
																${ram.tipo}, ${ram.capacidad} , Precio: ${ram.precio}€</option>
														</c:otherwise>

													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idRAM" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idDiscoDuro">Disco duro</form:label>
									<form:select path="idDiscoDuro" name="discoDuro"
										class="form-control" required="required">

										<c:choose>
											<c:when test="${ordenador.idDiscoDuro eq 0 }">
												<option selected value="0">Selecciona un disco duro</option>
												<c:forEach items="${discoDuro}" var="dd"
													varStatus="loopStatus">
													<option value="${dd.id}">${dd.interfaz}-
														${dd.capacidad}, ${dd.cache}, ${dd.rpm}, Precio:
														${dd.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona un disco duro</option>
												<c:forEach items="${discoDuro}" var="dd"
													varStatus="loopStatus">

													<c:choose>
														<c:when test="${dd.id eq ordenador.idDiscoDuro}">
															<option selected value="${dd.id}">${dd.interfaz}-
																${dd.capacidad}, ${dd.cache}, ${dd.rpm}, Precio:
																${dd.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${dd.id}">${dd.interfaz}-
																${dd.capacidad}, ${dd.cache}, ${dd.rpm}, Precio:
																${dd.precio}€</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
											</c:otherwise>

										</c:choose>
									</form:select>
									<form:errors path="idDiscoDuro" class="error"></form:errors>
								</div>
							</div>

							<div class="col-sm-5">
								<div class="form-group">
									<form:label path="idTarjetaGrafica">Tarjeta gráfica</form:label>
									<form:select path="idTarjetaGrafica" name="tarjetaGrafica"
										class="form-control" required="required">

										<c:choose>
											<c:when test="${ordenador.idTarjetaGrafica eq 0 }">
												<option selected value="0">Selecciona una tarjeta
													gráfica</option>
												<c:forEach items="${tarjetaGrafica}" var="tj"
													varStatus="loopStatus">
													<option value="${tj.id}">${tj.chipset}-
														${tj.memoria}, ${tj.tipoMemoria} , ${tj.bus}, Precio:
														${tj.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona una tarjeta gráfica</option>
												<c:forEach items="${tarjetaGrafica}" var="tj"
													varStatus="loopStatus">

													<c:choose>
														<c:when test="${tj.id eq ordenador.idTarjetaGrafica}">
															<option selected value="${tj.id}">${tj.chipset}-
																${tj.memoria}, ${tj.tipoMemoria} , ${tj.bus}, Precio:
																${tj.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${tj.id}">${tj.chipset}-
																${tj.memoria}, ${tj.tipoMemoria} , ${tj.bus}, Precio:
																${tj.precio}€</option>
														</c:otherwise>

													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idTarjetaGrafica" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idMonitor">Monitor</form:label>
									<form:select path="idMonitor" name="monitor"
										class="form-control" required="required">

										<c:choose>
											<c:when test="${ordenador.idMonitor eq 0}">
												<option selected value="0">Selecciona un monitor</option>
												<c:forEach items="${monitor}" var="m" varStatus="loopStatus">
													<option value="${m.id}">${m.pantalla}-${m.tamanyo},
														${m.resolucion} , Precio: ${m.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona un monitor</option>
												<c:forEach items="${monitor}" var="m" varStatus="loopStatus">

													<c:choose>
														<c:when test="${m.id eq ordenador.idMonitor}">
															<option selected value="${m.id}">${m.pantalla}-${m.tamanyo},
																${m.resolucion} , Precio: ${m.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${m.id}">${m.pantalla}-${m.tamanyo},
																${m.resolucion} , Precio: ${m.precio}€</option>
														</c:otherwise>

													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idMonitor" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idUnidadDVD">Lectora/grabadora de DVD</form:label>
									<form:select path="idUnidadDVD" name="dvd" class="form-control"
										required="required">

										<c:choose>
											<c:when test="${ordenador.idUnidadDVD eq 0}">
												<option selected value="0">Selecciona una grabadora
													DVD</option>
												<c:forEach items="${dvd}" var="dvd" varStatus="loopStatus">
													<option value="${dvd.id}">${dvd.tipo}-
														${dvd.interfaz}, x${dvd.velocidadEscritura} , Precio:
														${dvd.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona una grabadora DVD</option>
												<c:forEach items="${dvd}" var="dvd" varStatus="loopStatus">

													<c:choose>
														<c:when test="${dvd.id eq ordenador.idUnidadDVD}">
															<option selected value="${dvd.id}">${dvd.tipo}-
																${dvd.interfaz}, x${dvd.velocidadEscritura} , Precio:
																${dvd.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${dvd.id}">${dvd.tipo}-
																${dvd.interfaz}, x${dvd.velocidadEscritura} , Precio:
																${dvd.precio}€</option>
														</c:otherwise>

													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idUnidadDVD" class="error"></form:errors>
								</div>

								<div class="form-group">
									<form:label path="idOtros">Otro periférico</form:label>
									<form:select path="idOtros" name="otro" class="form-control"
										required="required">

										<c:choose>
											<c:when test="${ordenador.idOtros eq 0}">
												<option value="0">Selecciona un periférico</option>
												<c:forEach items="${otros}" var="o" varStatus="loopStatus">
													<option value="${o.id}">${o.nombre}-${o.datos},
														Precio: ${o.precio}€</option>
												</c:forEach>

											</c:when>
											<c:otherwise>

												<option value="0">Selecciona un periférico</option>
												<c:forEach items="${otros}" var="o" varStatus="loopStatus">

													<c:choose>

														<c:when test="${o.id eq ordenador.idOtros}">
															<option selected value="${o.id}">${o.nombre}-${o.datos},
																Precio: ${o.precio}€</option>
														</c:when>
														<c:otherwise>
															<option value="${o.id}">${o.nombre}-${o.datos},
																Precio: ${o.precio}€</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>

											</c:otherwise>

										</c:choose>

									</form:select>
									<form:errors path="idOtros" class="error"></form:errors>
								</div>

								<div class="form-group">
									<button type="submit" name="submit"
										class="btn btn-primary btn-lg">Aceptar</button>
								</div>
							</div>
						</form:form>
					</div>
					<!--/.row-->
				</div>
				<!--/.container-->
			</section>
			<!--/#feature-->

		</c:otherwise>
	</c:choose>

	<section id="bottom">
		<div class="container wow fadeInDown" data-wow-duration="1000ms"
			data-wow-delay="600ms">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="widget">
						<h3>Company</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/#">About
									us</a></li>
							<li><a href="${pageContext.request.contextPath}/#">We
									are hiring</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Meet
									the team</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Copyright</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Terms
									of use</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Privacy
									policy</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Contact
									us</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->

				<div class="col-md-3 col-sm-6">
					<div class="widget">
						<h3>Support</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/#">Faq</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Blog</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Forum</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Documentation</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Refund
									policy</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Ticket
									system</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Billing
									system</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->

				<div class="col-md-3 col-sm-6">
					<div class="widget">
						<h3>Developers</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/#">Web
									Development</a></li>
							<li><a href="${pageContext.request.contextPath}/#">SEO
									Marketing</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Theme</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Development</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Email
									Marketing</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Plugin
									Development</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Article
									Writing</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->

				<div class="col-md-3 col-sm-6">
					<div class="widget">
						<h3>Our Partners</h3>
						<ul>
							<li><a href="${pageContext.request.contextPath}/#">Adipisicing
									Elit</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Eiusmod</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Tempor</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Veniam</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Exercitation</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Ullamco</a></li>
							<li><a href="${pageContext.request.contextPath}/#">Laboris</a></li>
						</ul>
					</div>
				</div>
				<!--/.col-md-3-->
			</div>
		</div>
	</section>
	<!--/#bottom-->





	<footer id="footer" class="midnight-blue">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					&copy; 2013 <a target="_blank"
						href="${pageContext.request.contextPath}/http://shapebootstrap.net/"
						title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>.
					All Rights Reserved.
				</div>
				<div class="col-sm-6">
					<ul class="pull-right">
						<li><a href="${pageContext.request.contextPath}/#">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/#">About
								Us</a></li>
						<li><a href="${pageContext.request.contextPath}/#">Faq</a></li>
						<li><a href="${pageContext.request.contextPath}/#">Contact
								Us</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!--/#footer-->

	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/mainsimulador.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
</body>
</html>