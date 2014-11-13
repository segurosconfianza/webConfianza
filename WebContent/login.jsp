
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="pagina web">
    <meta name="author" content="Seguros Confianza">

    <title>Seguros Confianza</title>

    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap/3.2.0-dist/css/bootstrap.css" rel="stylesheet">  
  </head>

  <body>
	
	<c:if test="${!empty param.login_error}">	
			<div align="center">	
			<p/><img src="Imagenes/Iconos/candado_roto.jpg" width="40" height="40" ><span class="label label-danger">Incorreto nombre de usuario y/o contrase&ntilde;a</span>
			</div>
	</c:if>
		
    <div class="container" align="center">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" align="center">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Inicio de sesi&oacute;n</div>                        
                    </div>     

                    <div class="panel-body-confianza">
                        <img src="Imagenes/Confianza/img2.jpg" width=100%>
						<img src="Imagenes/Confianza/im3.jpg" >						                        
                            
                        <form id="loginform" class="form-horizontal" role="form" action="<c:url value='/j_spring_security_check'/>" method="post">
                            <p/>        
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="j_username" value="" placeholder="nombre de usuario">                                        
                            </div>
                                
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="j_password" placeholder="contrase&ntilde;a">
                            </div>

                            <div class="form-group">
                                <!-- Button -->
								<p/>
                                <div class="col-sm-12 controls" align="center" >
                                  <input name="submit" type="submit" value="Login"/>
                                </div>
                            </div>
                            <img src="Imagenes/Confianza/im4.jpg" >   
                        </form>     
                    </div>                     
            </div>  
        </div> 
    </div>    	
  </body>
</html>
