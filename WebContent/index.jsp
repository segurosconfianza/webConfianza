<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="es" ng-app=FrmMainApp><head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

		<title>Confianza, honramos nuestro nombre</title>

		<%
			ServletContext context = pageContext.getServletContext();
			String WEB_SERVER = context.getInitParameter("WEB_SERVER");
		%>	    
		<script >var WEB_SERVER='<%out.print(WEB_SERVER);%>';</script>
	
		<script src="lib/Angular/1.3.2/angular.js"></script>
	    <script src="lib/Angular/1.3.2/angular.min.js"></script>
	    <script src="lib/Angular/1.3.2/angular-route.js"></script>
	    <script src="lib/Angular/1.3.2/angular-ui-tree.js"></script>
	    <script src="lib/bootstrap/Angular/ui-bootstrap-tpls-0.11.2.min.js"></script>    	    	          
	    	    
    	<!--ng grid...-->
	    <script src="lib/Angular/angular-ui-ng-grid/3.0/jquery.min.js"></script>
    	<script src="lib/Angular/angular-ui-ng-grid/3.0/ng-grid.debug.js" type="text/javascript" ></script>
    	
    	<script src="lib/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    	<script src="lib/bootstrap/3.1.1/js/bootstrap.js"></script>
    	
	    <!--inclusion de estilos ...-->
	    <link  href="lib/CSS/Base.css" rel="stylesheet">
	    <link  href="lib/CSS/angular-ui-tree.min.css" rel="stylesheet">
	    <link  href="lib/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">  
 		<!--ng grid...-->
		<link href="lib/Angular/angular-ui-ng-grid/3.0/ng-grid.css" rel="stylesheet" type="text/css" />
		
		<!--inclusion de app, servicios, controles ...-->		
	    <script src="WebResources/framework/frmmenu/FrmMenuApp.js"></script>
	    <script src="WebResources/framework/frmmenu/FrmMenuService.js"></script>
	    <script src="WebResources/framework/frmmenu/FrmMenuController.js"></script>	
	    
	    <script src="WebResources/poliza/poliza/PolizaApp.js"></script>
	    <script src="WebResources/poliza/poliza/PolizaService.js"></script>
	    <script src="WebResources/poliza/poliza/PolizaController.js"></script>
	    
	    <!--inclusion de Confianza ...-->
		<link href="lib/Confianza/estilos.css" rel="stylesheet" type="text/css">
		<link href="lib/Confianza/menu.css" rel="stylesheet" type="text/css">
		<link href="lib/Confianza/lightbox.css" rel="stylesheet" type="text/css" media="screen">
		<link href="lib/Confianza/highslide.css" rel="stylesheet" type="text/css">
		
		<script src="lib/Confianza/stuHover.js" type="text/javascript"></script>
		<script src="lib/Confianza/prototype.js" type="text/javascript"></script>
		<script src="lib/Confianza/lightbox.js" type="text/javascript"></script>
		<script src="lib/Confianza/highslide-with-gallery.js" type="text/javascript"></script>

		<style media="screen" type="text/css">#grande {visibility:hidden}</style><style media="screen" type="text/css">#chico {visibility:hidden}</style><style type="text/css">.highslide img {cursor: url(/highslide/graphics/zoomin.cur), pointer !important;}.highslide-viewport-size {position: fixed; width: 100%; height: 100%; left: 0; top: 0}</style></head>

<body>
<div id="contenedor">
	<style type="text/css">
		#cabezote {
					background-image: url(lib/Confianza/imagenes/estructura/lema.jpg);
					background-repeat:no-repeat;
		}
	</style>

 	<div id="cabezote">
	     <form id="motor" name="motor" method="get" action="/index.php">
			<input name="seccion" value="resultados" type="hidden">
	   	    <table border="0" cellpadding="5" cellspacing="0" width="240">
	   	      <tbody><tr>
	   	        <td><input name="txt" id="textfield" value="Buscar" onfocus="this.value=''" type="text"></td>
	   	        <td><img src="lib/Confianza/imagenes/estructura/items.jpg" usemap="#items_mapa" border="0" height="20" width="86"></td>
	          </tr>
	 	      </tbody></table>
	   	    <map name="items_mapa" id="items_mapa">
		        <area shape="rect" coords="3,1,22,19" href="javascript:document.motor.submit()" title="Buscar" alt="Buscar" ""="">
		        <area shape="rect" coords="28,1,49,19" href="http://www.confianza.com.co/index.php" title="Regrese al home" alt="Regrese al home" ""="">
		        <area shape="rect" coords="55,1,84,19" href="http://www.confianza.com.co/?lang=en" title="in english" alt="in english" ="title="In english" "="">
	    	</map> 
	  	 </form>
    	 <div id="barra">    
            <style type="text/css"> #menu { background-image: url(lib/Confianza/imagenes/estructura/barra.jpg); } </style>
			<div id="menu"> 
                <ul id="nav">
				 	<li id="nuestra" class="top">
						<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1" class="top_link"><img src="lib/Confianza/imagenes/estructura/magic.gif" alt="" border="0" height="40" width="154"></a>
						<ul class="sub">
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=2">Información general</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=3">Estados financieros</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=87">Orgullosos de nuestra gente</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=4">Código de conducta</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=81">Código de gobierno corporativo</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=18">Valores corporativos</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=5">¿Por qué trabajar en Confianza?</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=6">Responsabilidad Social Empresarial</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=7">¿Cómo ser proveedor de Confianza?</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=11">Sistema de Administración de Riesgos</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=1&amp;cont=96">Comunicado de Prensa</a></li>
						</ul>
					</li>
					<li id="porque" class="top">
						<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=2" class="top_link"><img src="lib/Confianza/imagenes/estructura/magic.gif" alt="" border="0" height="40" width="154"></a>
						<ul class="sub">
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=2&amp;cont=8">¿Por qué Confianza?</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=2&amp;cont=9">Nuestro respaldo</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=2&amp;cont=10">Presencia en grandes proyectos</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=2&amp;cont=68">Notas de ingeniería</a></li>
						</ul>
					</li>
					<li id="productos" class="top">
						<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3" class="top_link"><img src="lib/Confianza/imagenes/estructura/magic.gif" alt="" border="0" height="40" width="154"></a>
						<ul class="sub">
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=88">Información general</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=20">Póliza de cumplimiento</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=21">Cauciones judiciales</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=23">Disposiciones legales</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=22">Responsabilidad civil extracontractual</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=3&amp;cont=24">Todo riesgo construcción y/o montaje</a></li>
						</ul>
					</li>
					<li id="intermediarios" class="top">
						<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5" class="top_link"><img src="lib/Confianza/imagenes/estructura/magic.gif" alt="" border="0" height="40" width="154"></a>
						<ul class="sub">
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5&amp;cont=16">¿Cómo ser intermediario de Confianza?</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5&amp;cont=26">Confired</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5&amp;cont=70">Consulte su cartera</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5&amp;cont=58">Convenciones</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=5&amp;cont=80">Normatividad</a></li>
						</ul>
					</li>
					<li id="oficinas" class="top">
						<a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=6" class="top_link"><img src="lib/Confianza/imagenes/estructura/magic.gif" alt="" border="0" height="40" width="154"></a>
						<ul class="sub">
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=6&amp;cont=25">Nuestras Oficinas</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=6&amp;cont=48">Agencias Representantes</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=6&amp;cont=103">Servicio al Cliente</a></li>
						<li><a href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=6&amp;cont=104">Centro de Contacto</a></li>
						</ul>
					</li>
				</ul>
			</div>
    	 </div>                                  
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
	      <img src="lib/Confianza/imagenes/estructura/redes.jpg" alt="" usemap="#redes" align="right" border="0" height="22" width="168">
	      <map name="redes" id="redes">
		      <area shape="rect" coords="32,2,55,21" href="https://webmail.confianza.com.co/owa" target="_blank" title="Correo Interno" alt="Correo Interno">
			  <area shape="rect" coords="58,1,81,20" href="http://200.74.130.49/intranet/opadmci.nsf/" target="_blank" title="Intranet" alt="Intranet">
			  <area shape="rect" coords="3,2,28,19" href="http://www.confianza.com.co/index.php?seccion=sugerencias" title="Escríbanos" alt="Escríbanos">
			  <area shape="rect" coords="87,-2,108,23" href="http://seconfianza.blogspot.com/" title="Lee nuestro blog" alt="Lee nuestro blog">
			  <area shape="rect" coords="119,1,139,20" href="http://twitter.com/confianza_sa" target="_blank" title="Síganos en Twitter" alt="Síganos en Twitter">
			  <area shape="rect" coords="147,0,168,32" href="http://www.facebook.com/confianza.sa" target="_blank" title="Síganos en Facebook" alt="Síganos en Facebook">
		  </map>
		  </td>
	    </tr></tbody></table>
	</div>

	<div id="pie">
	  <hr>
	   	  <table border="0" cellpadding="0" cellspacing="0" width="100%">
	   	    <tbody><tr>
	   	      <td>
	          <img src="lib/Confianza/imagenes/estructura/pie.jpg" usemap="#creditos" title"certificado="" co230272"="" border="0" height="80" width="520">
	          <map name="creditos" id="creditos">
				  <area shape="rect" coords="445,25,519,48" href="http://www.confianza.com.co/index.php?seccion=interna&amp;id=11">
			  </map></td>
	   	      <td align="right">CONFIANZA.COM.CO COPYRIGHT©2010 CONFIANZA S.A.<br>
								Calle 82 No. 11 - 37 (Piso 7) Bogotá Colombia - (57) 1- 6 44 46 90<br>
								Se prohíbe la reproducción total o parcial de cualquiera de los contenidos, <br>así como su traducción a cualquier idioma sin autorización escrita de su titular.</td>
	          </tr></tbody></table>
	</div>
</div>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script><script src="lib/Confianza/ga.js" type="text/javascript"></script>

<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-15403159-1");
pageTracker._trackPageview();
} catch(err) {}</script>


<div id="overlay"></div><div class="loading" id="lightbox"><div id="lbLoadMessage"><p>Loading</p></div></div><div style="padding: 0px; border: medium none; margin: 0px; position: absolute; left: 0px; top: 0px; width: 100%; z-index: 1001; direction: ltr;" class="highslide-container"><a style="position: absolute; top: -9999px; opacity: 0.75; z-index: 1;" href="javascript:;" title="Click to cancel" class="highslide-loading">Loading...</a><div style="display: none;"></div><div style="padding: 0px; border: medium none; margin: 0px; visibility: hidden;" class="highslide-viewport highslide-viewport-size"></div><table style="padding: 0px; border: medium none; margin: 0px; visibility: hidden; position: absolute; border-collapse: collapse; width: 0px;" cellspacing="0"><tbody style="padding: 0px; border: medium none; margin: 0px;"><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px 0px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -40px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px 0px transparent; height: 20px; width: 20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -80px transparent; height: 20px; width: 20px;"></td><td class="rounded-white highslide-outline" style="padding: 0px; border: medium none; margin: 0px; position: relative;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px -80px transparent; height: 20px; width: 20px;"></td></tr><tr style="padding: 0px; border: medium none; margin: 0px; height: auto;"><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -20px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll 0px -60px transparent; height: 20px; width: 20px;"></td><td style="padding: 0px; border: medium none; margin: 0px; line-height: 0; font-size: 0px; background: url(&quot;http://www.confianza.com.co/highslide/graphics/outlines/rounded-white.png&quot;) repeat scroll -20px -20px transparent; height: 20px; width: 20px;"></td></tr></tbody></table></div></body></html>