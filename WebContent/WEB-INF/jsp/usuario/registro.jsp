<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="csstransforms csstransforms3d csstransitions">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Registro | APPujimática</title>

<!-- core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css"
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
							<a href="${pageContext.request.contextPath}/index.jsp"><strong>Volver
									al índice</strong></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/.container-->
	</div>
	<!--/.top-bar--> </header>
	<!--/header-->

	<section id="contact-page">
	<div class="container">
		<div class="center">
			<div class="get-started center wow animated animated"
				style="margin-top: 0px; visibility: visible;">
				<h2>Introducir datos personales</h2>
				<p class="lead"></p>
			</div>
		</div>

		<div class="row contact-wrap" style="margin-top: 0">
			<form:form class="contact-form" method="post"
				modelAttribute="usuario">
				<div class="col-sm-5 col-sm-offset-1">
					<div class="form-group">
						<form:label path="nombre">Nombre</form:label>
						<form:input path="nombre" type="text" name="nombre"
							class="form-control" required="required"></form:input>
						<form:errors path="nombre" class="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="apellidos">Apellidos</form:label>
						<form:input path="apellidos" type="text" name="apellidos"
							class="form-control" required="required"></form:input>
						<form:errors path="apellidos" class="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="email">E-mail</form:label>
						<form:input path="email" type="email" name="email"
							class="form-control" required="required"></form:input>
						<form:errors path="email" class="error"></form:errors>
					</div>				
				</div>
				<div class="col-sm-5">
					<div class="form-group">
						<form:label path="nickname">Nickname</form:label>
						<form:input path="nickname" type="text" name="nickname"
							class="form-control" required="required"></form:input>
						<form:errors path="nickname" class="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="contrasenya">Contraseña</form:label>
						<form:input path="contrasenya" type="password" name="passwd"
							class="form-control" required="required"></form:input>
						<form:errors path="contrasenya" class="error">
						</form:errors>
					</div>
					<div class="form-group">
						<form:label path="contrasenyaRepetida">Repetir contraseña</form:label>
						<form:input path="contrasenyaRepetida" type="password"
							name="passwd2" class="form-control" required="required"></form:input>
						<form:errors path="contrasenyaRepetida" class="error"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="suscritoNovedades">¿Quieres recibir avisos con las novedades? </form:label>
						<form:checkbox path="suscritoNovedades" name="suscritoNovedades" value="S"></form:checkbox> 
					</div>	
										
					<div class="form-group">
						<button type="submit" name="submit" class="btn btn-primary btn-lg"
							required="required">Registrarme</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	
	
	<!--/.container--> </section>
	<!--/#contact-page-->

	<section id="bottom">
	<div class="container wow fadeInDown animated"
		data-wow-duration="1000ms" data-wow-delay="600ms"
		style="visibility: visible; -webkit-animation: fadeInDown 1000ms 600ms;">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<h3>Company</h3>
					<ul>
						<li><a href="#">About us</a></li>
						<li><a href="#">We are hiring</a></li>
						<li><a href="#">Meet the team</a></li>
						<li><a href="#">Copyright</a></li>
						<li><a href="#">Terms of use</a></li>
						<li><a href="#">Privacy policy</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
			</div>
			<!--/.col-md-3-->

			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<h3>Support</h3>
					<ul>
						<li><a href="#">Faq</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Forum</a></li>
						<li><a href="#">Documentation</a></li>
						<li><a href="#">Refund policy</a></li>
						<li><a href="#">Ticket system</a></li>
						<li><a href="#">Billing system</a></li>
					</ul>
				</div>
			</div>
			<!--/.col-md-3-->

			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<h3>Developers</h3>
					<ul>
						<li><a href="#">Web Development</a></li>
						<li><a href="#">SEO Marketing</a></li>
						<li><a href="#">Theme</a></li>
						<li><a href="#">Development</a></li>
						<li><a href="#">Email Marketing</a></li>
						<li><a href="#">Plugin Development</a></li>
						<li><a href="#">Article Writing</a></li>
					</ul>
				</div>
			</div>
			<!--/.col-md-3-->

			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<h3>Our Partners</h3>
					<ul>
						<li><a href="#">Adipisicing Elit</a></li>
						<li><a href="#">Eiusmod</a></li>
						<li><a href="#">Tempor</a></li>
						<li><a href="#">Veniam</a></li>
						<li><a href="#">Exercitation</a></li>
						<li><a href="#">Ullamco</a></li>
						<li><a href="#">Laboris</a></li>
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
				© 2013 <a target="_blank" href="http://shapebootstrap.net/"
					title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>.
				All Rights Reserved.
			</div>
			<div class="col-sm-6">
				<ul class="pull-right">
					<li><a href="#">Home</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Faq</a></li>
					<li><a href="#">Contact Us</a></li>
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