<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Resumen de peticiones</title>
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../lib/myprayer.css" rel="stylesheet">
</head>
<body>
	<div class="formulario">
	<h2>Motivos...</h2>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Vida espiritual</h4></div>
		<div class="col-md-6"><h4>${Vidaespiritual}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Salud</h4></div>
		<div class="col-md-6"><h4>${Salud}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Familia</h4></div>
		<div class="col-md-6"><h4>${Familia}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Estudio</h4></div>
		<div class="col-md-6"><h4>${Estudio}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Trabajo</h4></div>
		<div class="col-md-6"><h4>${Trabajo}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Otro</h4></div>
		<div class="col-md-6"><h4>${Otro}</h4></div>
	</div>
	
	<h2>Género...</h2>
	
	<div class="row input-lg">
		<div class="col-md-6"><h4>Mujeres</h4></div>
		<div class="col-md-6"><h4>${M}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Hombres</h4></div>
		<div class="col-md-6"><h4>${H}</h4></div>
	</div>
	<div class="row input-lg">
		<div class="col-md-6"><h4>Total</h4></div>
		<div class="col-md-6"><h4>${Total}</h4></div>
	</div>
	</div>
</body>
</html>