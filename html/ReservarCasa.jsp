<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.util.List" %>
<%@ page import="casarural.Servicio" %>
<html>
  <head>
  <script type="text/javascript">
	<!--
	function validar() {
		return ccasa() && cfecha() && cnoches() && ctelf();
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
	function ccasa() {
		var a = document.getElementById("numCasa").value;
		var b = a.length > 0 && es_num(a) && a > 0;
		error("numCasa", !b);
		return b;
	}
	function cfecha() {
		var a = document.getElementById("diaIni").value;
		var b = a.length == 10 && a[4] == '/' && a[7] == '/' && es_num(a.substring(0,4))
				&& es_num(a.substring(5,7)) && es_num(a.substring(8,10))
				&& a.substring(5,7) >= 1 && a.substring(5,7) <= 12
				&& a.substring(8,10) >= 1 && a.substring(8,10) <= 31;
		error("diaIni", !b);
		return b;
	}
	function cnoches() {
		var a = document.getElementById("numNoches").value;
		var b = a.length > 0 && es_num(a) && a > 0;
		error("numNoches", !b);
		return b;
	}
	function ctelf() {
		var a = document.getElementById("numTfnoReserva").value;
		var b = a.length > 0;
		error("numTfnoReserva", !b);
		return b;
	}
	-->
  </script>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Reservar casa</title>
	<jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
    <link rel="StyleSheet" href="css/base.css" type="text/css">
	<link rel="StyleSheet" href="css/layout.css" type="text/css">
	<link rel="StyleSheet" href="css/skeleton.css" type="text/css">
  </head>
  <body>
	<div class="container">
		<form action="ReservarCasaServicio.jsp" name="formulario" method="post" onSubmit="return validar();">
			<h1>Reservar Casa Rural</h1>
			<p>
				Código de la casa:
				<span id="error_numCasa" class="oculto">Dato incorrecto</span>
				<% String casa = request.getParameter("numCasa"); %>
				<% if (casa == null) { %>
				<input type="text" id="numCasa" name="numCasa" onBlur="ccasa()" />
				<% } else { %>
				<input type="text" id="numCasa" name="numCasa" onBlur="ccasa()" value='<%= casa %>' />
				<% } %>
			</p>
			<p>
				Día de entrada (aaaa/mm/dd):
				<span id="error_diaIni" class="oculto">Dato incorrecto</span>
				<% String fecha = request.getParameter("diaIni"); %>
				<% if (fecha == null) { %>
				<input type="text" id="diaIni" name="diaIni" onBlur="cfecha()" />
				<% } else { %>
				<input type="text" id="diaIni" name="diaIni" onBlur="cfecha()" value='<%= fecha %>' />
				<% } %>
			</p>
			<p>
				Número de noches:
				<span id="error_numNoches" class="oculto">Dato incorrecto</span>
				<% String numnoches = request.getParameter("numNoches"); %>
				<% if (numnoches == null) { %>
				<input type="text" id="numNoches" name="numNoches" onBlur="cnoches()" />
				<% } else { %>
				<input type="text" id="numNoches" name="numNoches" onBlur="cnoches()" value='<%= numnoches %>' />
				<% } %>
			</p>
			<p>
				Telefono de contacto:
				<span id="error_numTfnoReserva" class="oculto">Dato incorrecto</span>
				<% String telf = request.getParameter("numTfnoReserva"); %>
				<% if (telf == null) { %>
				<input type="text" id="numTfnoReserva" name="numTfnoReserva" onBlur="ctelf()" />
				<% } else { %>
				<input type="text" id="numTfnoReserva" name="numTfnoReserva" onBlur="ctelf()" value='<%= telf %>' />
				<% } %>
			</p>
			<p>
				Si es posible, ¿desea contratar un servicio de recogida?
				<select id="servicio" name="servicio">
					<option value="no">No</option>
					<option value="si">Sí</option>
				</select>
			</p>
			<input value="Aceptar" type="submit" />
			<input value="Cancelar" type="button" onclick="history.back()" />
		</form>
	</div>
</body>
</html>
