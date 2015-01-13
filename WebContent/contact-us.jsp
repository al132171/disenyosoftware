<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Contacto | APPujimática</title>
    
    <!-- core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>

    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />    
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Productos | APPujimática</title>
	
	<!-- core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
	
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>

        <header id="header">
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p><i class="fa fa-phone-square"></i>  +0123 456 70 90</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <div class="search">
                            <c:choose>
						    	<c:when test="${empty identificador}">
							    	<a href="${pageContext.request.contextPath}/usuario/login.html"><strong>Iniciar sesión</strong></a>
									<span>&nbsp;&nbsp;&nbsp;<strong>|</strong>&nbsp;&nbsp;&nbsp;</span>
									<a href="${pageContext.request.contextPath}/usuario/registro.html"><strong>Registro</strong></a>
						    	</c:when>
						    	<c:otherwise>
						    		<font color="#FFF"><strong>Bienvenido
						    		
						    		<%if(session.getAttribute("puesto").equals("A")) {%>
						    			${identificador}</strong></font> 
						    		<%} else {%>
						    			<a href="${pageContext.request.contextPath}/usuario/historico.html">${identificador}</strong></font> 
						    		<%} %>
						    			
						    		<a href="${pageContext.request.contextPath}/usuario/logout.html"> [Desconectar] </a>
                            	</c:otherwise>
                            </c:choose>
								
                           </div>
                       </div>
                    </div>
                </div>
            </div><!--/.container-->
        </div>

        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/images/logo-min.png" alt="logo"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                        <li><a href="${pageContext.request.contextPath}/catalogo/productos.html">Productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/simulador/simulador.html">Configurador</a></li>
                        <li class="active"><a href="${pageContext.request.contextPath}/contact-us.jsp">Contacto</a></li>                        
                        <li><a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a></li>
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header><!--/header-->

    <section id="contact-info">
        <div class="center">                
            <h2>¿Dónde estamos?</h2>
            <p class="lead">No dudes en ponerte en contacto con nosotros en caso de necesitarlo</p>
        </div>
        <div class="gmap-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-5 text-center">
                        <div class="gmap">
                            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12227.029194643637!2d-0.07028367858304406!3d39.99152877989518!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd5ffe0fca9b5147%3A0x1368bf53b3a7fb3f!2sUniversitat+Jaume+I!5e0!3m2!1ses!2ses!4v1418490264960"></iframe>
                        </div>
                    </div>

                    <div class="col-sm-7 map-content">
                        <ul class="row">
                            <li class="col-sm-6">
                                <address>
                                    <h5>Oficina central</h5>
                                    <p>Universitat Jaume I <br>
									Av de Vicent Sos Baynat <br>
									12071 Castellón, Castelló</p>
                                    <p>Tlf.:964-11-22-33 <br>
                                    Email Address:appujimatica@gmail.com</p>
                                </address>

                           
                            </li>


                            <li class="col-sm-6">
                                <address>
                                    <h5>Ingeniero#1</h5>
                                    <p>Calle en medio, 23</p>
                                    <p>Tlf.:670-898-280 <br>
                                    Email Address:hectorujimatica@domain.com</p>
                                </address>

                                <address>
                                    <h5>Ingeniero#2</h5>
                                    <p>Calle en medio, 23 <br>
                                    Tumon, MP 96911</p>
                                    <p>Phone:670-898-281 <br>
                                    Email Address:fernandoujimatica@domain.com</p>
                                </address>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>  <!--/gmap_area -->

    <section id="contact-page">
        <div class="container">
            <div class="center">        
                <h2>¿Tiene alguna duda?</h2>
                <p class="lead">Escriba su mensaje aquí</p>
            </div> 
            <div class="row contact-wrap"> 
                <div class="status alert alert-success" style="display: none"></div>
                <form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="sendemail.php">
                    <div class="col-sm-5 col-sm-offset-1">
                        <div class="form-group">
                            <label>Nombre </label>
                            <input type="text" name="name" class="form-control" required="required">
                        </div>
                        <div class="form-group">
                            <label>Email </label>
                            <input type="email" name="email" class="form-control" required="required">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="number" class="form-control">
                        </div>
                                     
                    </div>
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label>Asunto</label>
                            <input type="text" name="subject" class="form-control" required="required">
                        </div>
                        <div class="form-group">
                            <label>Mensaje</label>
                            <textarea name="message" id="message" required="required" class="form-control" rows="8"></textarea>
                        </div>                        
                        <div class="form-group">
                            <button type="submit" name="submit" class="btn btn-primary btn-lg" required="required">Submit Message</button>
                        </div>
                    </div>
                </form> 
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#contact-page-->

    <section id="bottom">
        <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Company</h3>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/#">About us</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">We are hiring</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Meet the team</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Copyright</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Terms of use</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Privacy policy</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Contact us</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Support</h3>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/#">Faq</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Blog</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Forum</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Documentation</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Refund policy</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Ticket system</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Billing system</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Developers</h3>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/#">Web Development</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">SEO Marketing</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Theme</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Development</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Email Marketing</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Plugin Development</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Article Writing</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->

                <div class="col-md-3 col-sm-6">
                    <div class="widget">
                        <h3>Our Partners</h3>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/#">Adipisicing Elit</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Eiusmod</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Tempor</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Veniam</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Exercitation</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Ullamco</a></li>
                            <li><a href="${pageContext.request.contextPath}/#">Laboris</a></li>
                        </ul>
                    </div>    
                </div><!--/.col-md-3-->
            </div>
        </div>
    </section><!--/#bottom-->

    <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="${pageContext.request.contextPath}/http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="${pageContext.request.contextPath}/#">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/#">About Us</a></li>
                        <li><a href="${pageContext.request.contextPath}/#">Faq</a></li>
                        <li><a href="${pageContext.request.contextPath}/#">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer><!--/#footer-->

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
</body>
</html>