<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Inicio | APPujimática</title>
	
	<!-- core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
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

<body class="homepage">

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
						    			<a href="${pageContext.request.contextPath}/usuario/perfil.html">${identificador}</a></strong></font> 
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
                        <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
                        <li><a href="${pageContext.request.contextPath}/catalogo/productos.html">Productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/simulador/simulador.html">Configurador</a></li>
                        <li><a href="${pageContext.request.contextPath}/contact-us.jsp">Contacto</a></li>                        
                        <li><a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a></li>
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header><!--/header-->

    <section id="main-slider" class="no-margin">
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
                <li data-target="#main-slider" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item active" style="background-color: #209c94">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">¡Configura tu propio ordenador!</h1>
                                    <h2 class="animation animated-item-2">Accede al configurador y elige los componentes que quieres incorporar a tu futuro ordenador...</h2>
                                    <a class="btn-slide animation animated-item-3" href="${pageContext.request.contextPath}/simulador/simulador.html">Acceder</a>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="${pageContext.request.contextPath}/images/slider/logo.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(${pageContext.request.contextPath}/images/slider/bg2.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Los últimos productos del mercado de la mejor calidad</h1>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="${pageContext.request.contextPath}/images/slider/img2.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(images/slider/bg3.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Encuentra las piezas que necesitas en nuestro catálogo</h1>
                                    <a class="btn-slide animation animated-item-3" href="${pageContext.request.contextPath}/catalogo/productos.html">Acceder</a>
                                </div>
                            </div>
                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="${pageContext.request.contextPath}/images/slider/img3.png" class="img-responsive">
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/.item-->
            </div><!--/.carousel-inner-->
        </div><!--/.carousel-->
        <a class="prev hidden-xs" href="${pageContext.request.contextPath}/#main-slider" data-slide="prev">
            <i class="fa fa-chevron-left"></i>
        </a>
        <a class="next hidden-xs" href="${pageContext.request.contextPath}/#main-slider" data-slide="next">
            <i class="fa fa-chevron-right"></i>
        </a>
    </section><!--/#main-slider-->

    

    <section id="services" class="service-item">
	   <div class="container">
            <div class="center wow fadeInDown">
                <h2>Nuestros servicios</h2>
                <p class="lead">Conócenos mejor</p>
            </div>

            <div class="row">

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services1.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Configura tu ordenador ideal</h3>
                            <p>Optimiza tu ordenador eligiendo los componentes que más se ajusten a tu bolsillo</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services2.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Rápido y sencillo</h3>
                            <p>Crear tu primer ordenador es rápido y sencillo gracias a nuestras configuraciones preestablecidas</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services3.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Guarda tus configuraciones</h3>
                            <p>Cada vez que crees tu propio ordenador, podrás guardarlo para saber de qué componentes está compuesto</p>
                        </div>
                    </div>
                </div>  

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services4.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">¿Quieres que te avisemos sobre nuevos productos?</h3>
                            <p>Suscríbete a nuestro servicio de notificaciones y serás el primero en saber nuestras novedades y promociones</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services5.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Configura tu ordenador desde cualquier sitio</h3>
                            <p>Prúeba a acceder desde tu smartphone o tablet a nuestro servicio, te sorprenderá</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4">
                    <div class="media services-wrap wow fadeInDown">
                        <div class="pull-left">
                            <img class="img-responsive" src="${pageContext.request.contextPath}/images/services/services6.png">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">¿Tienes dudas?</h3>
                            <p>Contacta con nosotros, nuestro equipo estará encantado de atenderte</p>
                        </div>
                    </div>
                </div>                                                
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#services-->

    
 

    <section id="partner">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Nuestros colaboradores</h2>
            </div>    

            <div class="partners">
                <ul>
                    <li> <a href="${pageContext.request.contextPath}/#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms" src="${pageContext.request.contextPath}/images/partners/partner1.png"></a></li>
                    <li> <a href="${pageContext.request.contextPath}/#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms" src="${pageContext.request.contextPath}/images/partners/partner2.png"></a></li>
                    <li> <a href="${pageContext.request.contextPath}/#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="900ms" src="${pageContext.request.contextPath}/images/partners/partner3.png"></a></li>
                    <li> <a href="${pageContext.request.contextPath}/#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1200ms" src="${pageContext.request.contextPath}/images/partners/partner4.png"></a></li>
                    <li> <a href="${pageContext.request.contextPath}/#"><img class="img-responsive wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="1500ms" src="${pageContext.request.contextPath}/images/partners/partner5.png"></a></li>
                </ul>
            </div>        
        </div><!--/.container-->
    </section><!--/#partner-->

    

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
                    &copy; 2014 <a target="_blank" href="${pageContext.request.contextPath}/#">APPujimática</a>. All Rights Reserved.
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