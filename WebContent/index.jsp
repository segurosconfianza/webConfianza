<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.Properties"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="es" ng-app=FrmMainApp>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />

		<title>Confianza, honramos nuestro nombre</title>

		<%
			Properties prop=new Properties();
			prop.load(getServletContext().getResourceAsStream("/WEB-INF/Confianza.properties"));
			
			String WEB_SERVER = prop.getProperty("WEB_SERVER");				  	
			String PRIVATEKEY = prop.getProperty("PRIVATEKEY");
			String SITEKEY = prop.getProperty("SITEKEY");
	    %>	
	       
		<script >var WEB_SERVER='<%out.print(WEB_SERVER);%>';
				 var PRIVATEKEY='<%out.print(PRIVATEKEY);%>';
				 var SITEKEY='<%out.print(SITEKEY);%>';				 
		</script>
	
		<script src="lib/Angular/1.3.2/angular.js"></script>	    
	    <script src="lib/Angular/1.3.2/angular-route.js"></script>
	    <script src="lib/Angular/1.3.2/angular-ui-tree.js"></script>  
	    <script src="lib/bootstrap/Angular/ui-bootstrap-tpls-0.11.2.min.js"></script>    	    	          
	    	    
    	<!--ng grid...-->
	    <script src="lib/Angular/angular-ui-ng-grid/3.0/jquery.min.js"></script>
    	<script src="lib/Angular/angular-ui-ng-grid/3.0/ng-grid.debug.js" type="text/javascript" ></script>
    	
    	<script src="lib/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    	<script src="lib/bootstrap/3.1.1/js/bootstrap.js"></script>
    	
	    <!--inclusion de estilos ...-->
	    <link  href="lib/CSS/Base.css" rel="stylesheet"></link>
	    <link  href="lib/CSS/angular-ui-tree.min.css" rel="stylesheet"></link>
	    <link  href="lib/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet"></link>  
 		<!--ng grid...-->
		<link href="lib/Angular/angular-ui-ng-grid/3.0/ng-grid.css" rel="stylesheet" type="text/css"></link>
		
		<!--inclusion de app, servicios, controles ...-->		
	    <script src="WebResources/framework/frmmenu/FrmMenuApp.js"></script>
	    <script src="WebResources/poliza/poliza/PolizaApp.js"></script>
	    	    
	    <script src="WebResources/framework/frmmenu/FrmMenuService.js"></script>
	    <script src="WebResources/poliza/poliza/PolizaService.js"></script>
	    	    
	    <script src="WebResources/framework/frmmenu/FrmMenuController.js"></script>	
	    <script src="WebResources/poliza/poliza/PolizaController.js"></script>

	    
	    
	    <!--inclusion de Confianza ...-->
		<link href="lib/Confianza/estilos.css" rel="stylesheet" type="text/css"></link>
		<link href="lib/Confianza/menu.css" rel="stylesheet" type="text/css"></link>
		<link href="lib/Confianza/lightbox.css" rel="stylesheet" type="text/css" media="screen"></link>
		<link href="lib/Confianza/highslide.css" rel="stylesheet" type="text/css"></link>
		
		<script src="lib/Confianza/stuHover.js" type="text/javascript"></script>
		<script src="lib/Confianza/prototype.js" type="text/javascript"></script>
		<script src="lib/Confianza/lightbox.js" type="text/javascript"></script>
		<script src="lib/Confianza/highslide-with-gallery.js" type="text/javascript"></script>

		<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback" async defer></script>
		
	</head>
		
	<body>
		<div id="contenedor">
			<style type="text/css">
				#cabezote {
							background-image: url(lib/Confianza/imagenes/estructura/logo.png);
							background-repeat:no-repeat;
				}
			</style>
		
		 	<div id="cabezote">
			     <form id="motor" name="motor" method="get" action="/index.php">
					<table border="0" cellpadding="0" cellspacing="0" width="300">
			    <tbody><tr>			      
			      <td>
			      <img src="lib/Confianza/imagenes/estructura/items.jpg" alt="" usemap="#redes" align="right" border="0" height="22" width="120"></img>
			      <map name="redes" id="redes">				      
					  <area shape="rect" coords="3,2,28,19" href="http://www.confianza.com.co/index.php" title="Buscar" alt="Buscar"></area>
					  <area shape="rect" coords="32,2,55,21" href="http://www.confianza.com.co/index.php" title="Home" alt="Home"></area>					  
					  <area shape="rect" coords="87,-2,108,23" href="http://www.confianza.com.co/index.php" title="in english" alt="in english"></area>
				  </map>
				  </td>
			    </tr></tbody></table>	
			    			   	    
			  	 </form>
		    	                                 
		  	</div>	
		
		 	<!--contenido de la pagina-->
			<aside>
				<div ng-view></div>
			</aside>
			<!-- fin del contenido-->
		  
			<div id="submenu">	  
			  <table border="0" cellpadding="0" cellspacing="0" width="950">
			    <tbody><tr>
			      <td><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=8">Defensor del cliente</a> &nbsp;&nbsp;&nbsp;<a href="http://www.confianza.com.co/index.php?seccion=preguntas">Preguntas frecuentes</a> &nbsp;&nbsp;&nbsp;<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=9">Sitios de interés</a> &nbsp;&nbsp;&nbsp;<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=10">Políticas de Privacidad y Seguridad</a> &nbsp;&nbsp;&nbsp;<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=12">Consumidor Financiero</a> &nbsp;&nbsp;&nbsp;</td>
			      <td>
			      <img src="lib/Confianza/imagenes/estructura/redes.jpg" alt="" usemap="#redes" align="right" border="0" height="22" width="168"></img>
			      <map name="redes" id="redes">
				      <area shape="rect" coords="32,2,55,21" href="https://webmail.confianza.com.co/owa" target="_blank" title="Correo Interno" alt="Correo Interno"></area>
					  <area shape="rect" coords="58,1,81,20" href="http://200.74.130.49/intranet/opadmci.nsf/" target="_blank" title="Intranet" alt="Intranet"></area>
					  <area shape="rect" coords="3,2,28,19" href="http://www.confianza.com.co/index.php?seccion=sugerencias" title="Escríbanos" alt="Escríbanos"></area>
					  <area shape="rect" coords="87,-2,108,23" href="http://seconfianza.blogspot.com/" title="Lee nuestro blog" alt="Lee nuestro blog"></area>
					  <area shape="rect" coords="119,1,139,20" href="http://twitter.com/confianza_sa" target="_blank" title="Síganos en Twitter" alt="Síganos en Twitter"></area>
					  <area shape="rect" coords="147,0,168,32" href="http://www.facebook.com/confianza.sa" target="_blank" title="Síganos en Facebook" alt="Síganos en Facebook"></area>
				  </map>
				  </td>
			    </tr></tbody></table>	
			    <div>
					<font color="black"></>Esta web optimizada para funcionar bajo el uso de los siguientes navegadores:</font>
					<a href="http://www.mozilla.org/es-ES/firefox/fx/" target="_blank" title="Descargue Mozilla Firefox">
						<span>Firefox</span>
						<img width="30" height="30" border="0" align="bottom" alt="Firefox" src="Imagenes/Iconos/firefox.png"></img>
					</a>				  		
					<a href="https://www.google.com/intl/es/chrome/browser/?hl=es" target="_blank" title="Descargue Google Chrome">
						<span>Chrome</span>
						<img width="30" height="30" border="0" align="bottom" alt="Chrome" src="Imagenes/Iconos/chrome.png"></img>
					</a>
					<a href="http://www.apple.com/es/safari/" target="_blank" title="Descargue Safari">
						<span>Safari</span>
						<img width="30" height="30" border="0" align="bottom" alt="Safari" src="Imagenes/Iconos/safari.png"></img>
					</a>
					<a href="http://www.opera.com/computer/windows" target="_blank" title="Descargue Opera">
						<span>Opera</span>
						<img width="30" height="30" border="0" align="bottom" alt="Opera" src="Imagenes/Iconos/opera.png"></img>
					</a>
					<a href="http://windows.microsoft.com/es-es/internet-explorer/download-ie" target="_blank" title="Descargue Internet Explorer">
						<span>Internet Explorer 9x</span>
						<img width="30" height="30" border="0" align="bottom" alt="Internet Explorer" src="Imagenes/Iconos/ie.png"></img>
					</a>
			  </div>     			  
			</div>				
			<div id="pie">	  
			  <div class="pull-right">
				  <div class="region region-piefilalogos">
				  	<div id="block-block-3" class="block block-block">
					  <div class="content">
					    <p/><p/><p><img alt="Certicámara" src="lib/Confianza/imagenes/estructura/certicamara.png" style="width: 120px; height: 27px;" /><img alt="Vigilado Superintendencia Financiera de Colombia" src="lib/Confianza/imagenes/estructura/super_financiera.png" style="width: 200px; height: 14px;" /></p>
					  </div>
					</div>
	  			  </div>
	          </div>
	          <div class="texto-legal">
				  <div class="region region-piefilatarjeta">
					 <div id="block-block-4" class="block block-block">										    
					  <div class="content"><p/><p/>
					    <p class="grey">CONFIANZA.COM.CO COPYRIGHT ©2010 -2014 CONFIANZA S.A.<br />
					Calle 82 No. 11 - 37 (Piso 7) Bogotá Colombia - (57) 1- 6 44 46 90<br />
					Se prohíbe la reproducción total o parcial de cualquiera de los contenidos,<br />
					así como su traducción a cualquier idioma sin autorización escrita de su titular.</p>
					  </div>
					</div>
				  </div>
	          </div>
			</div>
		</div>
		<script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		
		<script src="lib/Confianza/ga.js" type="text/javascript"></script>
		
		<script type="text/javascript">
		try {
		var pageTracker = _gat._getTracker("UA-15403159-1");
		pageTracker._trackPageview();
		} catch(err) {}</script>
		
		
		<div id="overlay"></div>
		<div class="loading" id="lightbox"><div id="lbLoadMessage"><p>Loading</p></div></div>
		<div style="padding: 0px; border: medium none; margin: 0px; position: absolute; left: 0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;" class="highslide-container"><a style="position: absolute; top: -9999px; opacity: 0.75; z-index: 1;" href="javascript:;" title="Click to cancel" class="highslide-loading">Loading...</a><div style="display: none;"></div><div style="padding: 0px; border: medium none; margin: 0px; visibility: hidden;" class="highslide-viewport highslide-viewport-size"></div><table style="padding: 0px; border: medium none; margin: 0px; visibility: hidden; position: absolute; border-collapse: collapse; width: 0px;" cellspacing="0"><tbody style="padding: 0px; border: medium none; margin: 0px;"><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px 0px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -40px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px 0px transparent; height: 20px; width: 20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -80px transparent; height: 20px; width: 20px;"></td><td class="rounded-white highslide-outline" style="padding: 0px; border: medium none; margin: 0px; position: relative;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px -80px transparent; height: 20px; width: 20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -20px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -60px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px -20px transparent; height: 20px; width: 20px;"></td></tr></tbody></table></div>
	</body>
</html>
