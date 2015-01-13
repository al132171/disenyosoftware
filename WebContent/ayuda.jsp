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
						<li><a
							href="${pageContext.request.contextPath}/simulador/simulador.html">Configurador</a></li>
						<li><a
							href="${pageContext.request.contextPath}/contact-us.jsp">Contacto</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a></li>
					</ul>
				</div>
			</div>
			<!--/.container-->
		</nav>
		<!--/nav-->

	</header>
	<!--/header-->

	
				<div class="container">
					<div class="get-started center wow fadeInDown animated" id="ayuda">
						<h1> <font color="red">¡En construcción!</font></h1>
						<img src="${pageContext.request.contextPath}/images/trabajo.png" alt="en construcción" WIDTH=178 HEIGHT=180>
						<p> En esta sección se indicará cuales son las preguntas más frecuentes (FAQs) 
						y se introducirá un pequeño manual de referencia para los usuarios nuevos.</p>
					</div>
				</div>

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