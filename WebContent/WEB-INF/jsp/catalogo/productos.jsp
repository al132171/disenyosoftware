<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						    			<a href="${pageContext.request.contextPath}/usuario/perfil.html">${identificador}</strong></font> 
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
                        <li class="active"><a href="${pageContext.request.contextPath}/catalogo/productos.html">Productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/simulador/simulador.html">Configurador</a></li>
                        <li><a href="${pageContext.request.contextPath}/contact-us.jsp">Contacto</a></li>                        
                        <li><a href="${pageContext.request.contextPath}/ayuda.jsp">Ayuda</a></li>
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
		
    </header><!--/header-->

	<section id="recent-works">
        <div class="container">
            <div class="center wow fadeInDown">
                <h2>Componentes disponibles</h2>
                <p class="lead">Puedes consultar las características y precios de los diferentes componentes <br> disponibles en nuestra tienda on-line.</p>
            </div>

            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/placa.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Placas base</a> </h3>
                                <p>Placas base a todos los precios</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listPlacasBase.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/procesador.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Procesadores</a></h3>
                                <p>Los últimos procesadores del mercado los encontrarás aquí</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listProcesador.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/ram.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Memorias RAM</a></h3>
                                <p>Memorias RAM de todas las capacidades</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listRam.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/hdd.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Discos Duros</a></h3>
                                <p>- Discos duros internos<br>- Discos duros externos</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listDiscoDuro.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   
                
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/grafica.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Tarjetas gráficas</a></h3>
                                <p>Tarjetas gráficas adaptables</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listTarjetaGrafica.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/monitor.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Monitores</a></h3>
                                <p>Distintos tipos de monitores y materiales</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listMonitor.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div> 

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/dvd.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Lectoras/grabadoras de DVD</a></h3>
                                <p>Grabadoras para grabar tus ficheros o recuerdos</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listDvd.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   

                <div class="col-xs-12 col-sm-4 col-md-3">
                    <div class="recent-work-wrap">
                        <img class="img-responsive" src="${pageContext.request.contextPath}/images/componentes/thumbs/otro.png" alt="">
                        <div class="overlay">
                            <div class="recent-work-inner">
                                <h3><a href="#">Otros periféricos</a></h3>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority</p>
                                <a class="preview" href="${pageContext.request.contextPath}/catalogo/listOtros.html"><i class="fa fa-eye"></i> Ver</a>
                            </div> 
                        </div>
                    </div>
                </div>   
            </div><!--/.row-->
        </div><!--/.container-->
    </section><!--/#recent-works-->
	
    <section id="bottom">
        <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
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
                </div><!--/.col-md-3-->

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
                </div><!--/.col-md-3-->

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
                </div><!--/.col-md-3-->

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
                </div><!--/.col-md-3-->
            </div>
        </div>
    </section><!--/#bottom-->

    <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
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
    </footer><!--/#footer-->
    

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $('.carousel').carousel()
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.isotope.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
</body>
</html>