<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.Casa" %>
<%@ page import="casarural.CrearServicioBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Crear Servicio de Recogida</title>
	<jsp:useBean id="crearServicioBean" scope="request" class="casarural.CrearServicioBean"/>
    <link rel="stylesheet" href="css/base.css" type="text/css">
    <link rel="stylesheet" href="css/layout.css" type="text/css">
    <link rel="stylesheet" href="css/skeleton.css" type="text/css">
    <link rel="stylesheet" href="css/tables.css" type="text/css">
	<script type="text/javascript">
		<!--
		function validar() {
			/*if (document.formulario.numCasa.value < 0)
				alert('El numero de casa tiene que ser mayor que cero');*/
			return true;
		}
		function error(elem, b) {
			if (b)
				document.getElementById("error_" + elem).className = "error";
			else
				document.getElementById("error_" + elem).className = "oculto";
		}
		function es_digito(d) {
			switch(d) {
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					return true;
				default:
					return false;
			}
		}
		function es_num(input){
			var i, b=true;
			for (i=0; i<input.length; i++)
				b = b && es_digito(input[i]);
			return b;
		}
		function comprobarFecha() {
			var a = document.getElementById("fecha").value;
			var b = a.length == 10 && a[4] == '/' && a[7] == '/' && es_num(a.substring(0,4))
					&& es_num(a.substring(5,7)) && es_num(a.substring(8,10))
					&& a.substring(5,7) <= 12 && a.substring(8,10) <= 31;
			error("fecha", !b);
		}
		-->
	</script>
</head>
<body>
	<div class="container">
		<form action="Servicio2.jsp" name="f" method="post">
			<h1>Crear Servicio de Recogida</h1>
			<p>
				Fecha (aaaa/mm/dd):
				<span id="error_fecha" class="oculto">Prueba</span>
				<input type="text" id="fecha" onBlur="comprobarFecha();" />
			</p>
			<p>
				Hora (hh:mm): 
				<input type="text" name="hora" />
			</p>
			<p>
				Precio: 
				<input type="text" name="precio" />
			</p>
			<p>
				Plazas: 
				<input type="text" name="plazas" />
			</p>
			<p>
				Recorrido:
				<select id="recorrido">
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</p>
			<p>
				Recogida:
				<select id="recogida">
					<option value="1">Aeropuerto de Loiu</option>
					<option value="2">Estación de Amara</option>
				</select>
			</p>
			<input value="Crear Servicio" type="submit" onclick="validar()" />
			<input value="Cancelar" type="button" onclick="location.href='./'" />
		</form>
	</div>
</body>
</html>