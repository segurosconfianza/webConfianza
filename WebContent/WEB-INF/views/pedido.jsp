<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pedido</title>
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../lib/myprayer.css" rel="stylesheet">
</head>
<body>
	<div class="formulario">
		<h1>Oramos por ti</h1>
		<form class="form" method="POST" action="Pedido">
			
			<div class="row input-lg">
			<div class="col-md-4"><input type="checkbox" name="persmoti4" value="Vidaespiritual"> Vida espiritual</div>
			<div class="col-md-4"><input type="checkbox" name="persmoti1" value="Salud"> Salud</div>
			<div class="col-md-4"><input type="checkbox" name="persmoti3" value="Familia"> Familia</div>
			</div>
			<div class="row input-lg">
			<div class="col-md-4"><input type="checkbox" name="persmoti2" value="Estudio"> Estudio</div>
			<div class="col-md-4"><input type="checkbox" name="persmoti5" value="Trabajo"> Trabajo</div>
			<div class="col-md-4"><input type="checkbox" name="persmoti6" value="Otro"> Otro</div>
			</div>
		
			<div class="form-group">
			<textarea class="form-control input-lg" rows="3" name="perstext" placeholder="Quiero pedir por" required="required"></textarea>
			</div>
			<div class="row form-group">
				<div class="col-md-9"><input type="text" class="form-control input-lg" name="persnomb" placeholder="Mi nombre es"  required="required"/></div>
				<div class="col-md-3">
				<select class="form-control input-lg" name="perssexo">
					<option value="M">Mujer</option>
					<option value="H">Hombre</option>
				</select>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Enviar</button>
			</div>
		</form>
		<blockquote class="blockquote-reverse">
			<p class="lead">
				"Y todo lo que pidiereis en oración, creyendo, lo recibiréis." 
				<footer>Mateo 21:22</footer>
			</p>
		</blockquote>
		<div class="row">
			<div class="col-md-2"><a href="./"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;Pedido</a></div>
			<div class="col-md-2"><a href="Resumen"><span class="glyphicon glyphicon-tasks"></span>&nbsp;Resumen</a></div>
			<div class="col-md-2"><a href="Listado"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;Listado</a></div>
		</div>
			
	</div>
	
</body>
</html>