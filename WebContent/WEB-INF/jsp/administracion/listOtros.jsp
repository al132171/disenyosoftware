<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Administración | APPujimática</title>

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
							<font color="#FFF"><strong>Bienvenido
									${identificador}</strong></font> <span>&nbsp;&nbsp;&nbsp;<strong>|</strong>&nbsp;&nbsp;&nbsp;
							</span> <a href="${pageContext.request.contextPath}/usuario/logout.html">
								[Desconectar] </a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.top-bar--> <nav class="navbar navbar-inverse" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/index.html"><img
				src="${pageContext.request.contextPath}/images/logo-min.png"
				alt="logo"></a>
		</div>

		<div class="collapse navbar-collapse navbar-right">
			<ul class="nav navbar-nav">
				<li><a
					href="${pageContext.request.contextPath}/administracion/index.html">Inicio
						administración</a></li>
				<li><a
					href="${pageContext.request.contextPath}/administracion/anyadir.html">Añadir
						producto</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/administracion/listar.html">Listar
						productos</a></li>
				<li><a
					href="${pageContext.request.contextPath}/simulador/simulador.html" target="_blank">Configurador</a></li>
				<li><a href="#">Gestionar perfiles</a></li>
			</ul>
		</div>
	</div>
	<!--/.container--> </nav><!--/nav--> </header>
	<!--/header-->

	<c:choose>
		<c:when test="${empty identificador}">

			<section id="atencion" class="transparent-bg">
			<div class="container">
				<div class="get-started center wow fadeInDown animated"
					id="atencion" style="background-color: #FECACA;">
					<h2>¡Atención, está intentando acceder a una zona restringida!</h2>
					<p class="lead">
					<h2>Sólo los administradores pueden acceder a esta zona</h2>
					<h3>
						¿Eres administrador? <a
							href="${pageContext.request.contextPath}/usuario/login.html"
							class="btn btn-primary">Acceder</a>
					</h3>
					</p>
				</div>
				<div class="row contact-wrap">
					<div class="status alert alert-success" style="display: none"></div>
				</div>
			</div>
			<!--/.item--> </section>
		</c:when>
		<c:otherwise>

			<section id="recent-works">
			<div class="container" id="listado">
				<div class="center wow fadeInDown">
					<h2>Otros</h2>
					<p class="lead">Listado de características y precios</p>
				</div>

				<div class="row contact-wrap">
					<div class="col-sm-10 col-sm-offset-1">
						<table style="width: 100%">
							<tr bgcolor="#C4C4C4">
								<td><h4>Nombre</h4></td>
								<td><h4>Descripcion</h4></td>
								<td><h4>Precio</h4></td>
								<td><h4>Editar</h4></td>
							</tr>
							<c:forEach items="${otros}" var="otro" varStatus="loopStatus">
								<tr bgcolor="${loopStatus.index % 2 == 0 ? '' : '#F0F0F0'}">
									<td><h5>${otro.nombre}</h5></td>
									<td><h5>${otro.descripcion}</h5></td>
									<td><h5>${otro.precio}€</h5></td>
									<td><h5>
											<a
												href="${pageContext.request.contextPath}/administracion/editaOtros/${otro.id}.html">Edita</a>
										</h5></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<!--/.row-->
			</div>
			<!--/.container--> </section>
			<!--/#recent-works-->

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
						<li><a href="${pageContext.request.contextPath}/#">We are
								hiring</a></li>
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
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
</body>
</html>