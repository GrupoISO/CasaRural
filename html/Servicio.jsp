<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.Recorrido" %>
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
			return cfecha() && chora() && cprecio() && cplazas();
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
		function cfecha() {
			var a = document.getElementById("fecha").value;
			var b = a.length == 10 && a[4] == '/' && a[7] == '/' && es_num(a.substring(0,4))
					&& es_num(a.substring(5,7)) && es_num(a.substring(8,10))
					&& a.substring(5,7) >= 1 && a.substring(5,7) <= 12
					&& a.substring(8,10) >= 1 && a.substring(8,10) <= 31;
			error("fecha", !b);
			return b;
		}
		function chora() {
			var a = document.getElementById("hora").value;
			var b = a.length == 5 && a[2] == ':'
					&& es_num(a.substring(0,2)) && es_num(a.substring(3,5))
					&& a.substring(0,2) < 24 && a.substring(3,5) < 60;
			error("hora", !b);
			return b;
		}
		function cprecio() {
			var a = document.getElementById("precio").value;
			var b = a.length > 0;
			var n = a.indexOf(".");
			if (n == -1) b = b && es_num(a);
			else b = b && es_num(a.substring(0,n)) && es_num(a.substring(n+1));
			error("precio", !b);
			return b;
		}
		function cplazas() {
			var a = document.getElementById("plazas").value;
			var b = a.length > 0 && es_num(a);
			error("plazas", !b);
			return b;
		}
		-->
	</script>
</head>
<body>
	<div class="container">
		<form action="Servicio2.jsp" name="f" method="post" onSubmit="return validar();">
			<h1>Crear Servicio de Recogida</h1>
			<p>
				Fecha (aaaa/mm/dd):
				<span id="error_fecha" class="oculto">Dato incorrecto</span>
				<input type="text" id="fecha" name="fecha" onBlur="cfecha()" />
			</p>
			<p>
				Hora (hh:mm):
				<span id="error_hora" class="oculto">Dato incorrecto</span>
				<input type="text" id="hora" name="hora" onBlur="chora()" />
			</p>
			<p>
				Precio:
				<span id="error_precio" class="oculto">Dato incorrecto</span>
				<input type="text" id="precio" name="precio" onBlur="cprecio()" />
			</p>
			<p>
				Plazas:
				<span id="error_plazas" class="oculto">Dato incorrecto</span>
				<input type="text" id="plazas" name="plazas" onBlur="cplazas()" />
			</p>
			<p>
				Recorrido:
				<select id="recorrido" name="recorrido">
					<%
						List<Recorrido> lista = crearServicioBean.getRecorridos();
						for (Recorrido r: lista) {
					%>
					<option value="<%= r.getNumRecorrido() %>"><%= r.getNumRecorrido() %></option>
					<%
						}
					%>
				</select>
			</p>
			<p>
				Recogida:
				<select id="recogida" name="recogida">
					<option value="1">Aeropuerto de Loiu</option>
					<option value="2">Estación de Amara</option>
				</select>
			</p>
			<input value="Crear Servicio" type="submit" />
			<input value="Cancelar" type="button" onclick="location.href='./'" />
		</form>
	</div>
</body>
</html>