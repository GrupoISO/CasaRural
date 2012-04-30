<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.util.List" %>
<%@ page import="casarural.Servicio" %>
<html>
  <head>
  <script type="text/javascript">
<!--
    function checkValues()
    {
      if (document.formulario.numCasa.value < 0)
        alert('El numero de casa tiene que ser mayor que cero');
      return true;
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
		<form action="ReservarCasaServicio.jsp" name="formulario" method="post">
			<h1>Reservar Casa Rural</h1>
			<p>
				Código de la casa:
				<% String casa = request.getParameter("numCasa"); %>
				<% if (casa == null) { %>
				<input type="text" name="numCasa" />
				<% } else { %>
				<input type="text" name="numCasa" value='<%= casa %>' />
				<% } %>
			</p>
			<p>
				Día de entrada (dd/mm/aaaa):
				<% String fecha = request.getParameter("diaIni"); %>
				<% if (fecha == null) { %>
				<input type="text" name="diaIni" />
				<% } else { %>
				<input type="text" name="diaIni" value='<%= fecha %>' />
				<% } %>
			</p>
			<p>
				Número de noches:
				<% String numnoches = request.getParameter("numNoches"); %>
				<% if (numnoches == null) { %>
				<input type="text" name="numNoches" />
				<% } else { %>
				<input type="text" name="numNoches" value='<%= numnoches %>' />
				<% } %>
			</p>
			<p>
				Telefono de contacto:
				<% String telf = request.getParameter("numTfnoReserva"); %>
				<% if (telf == null) { %>
				<input type="text" name="numTfnoReserva" />
				<% } else { %>
				<input type="text" name="numTfnoReserva" value='<%= telf %>' />
				<% } %>
			</p>
			<p>
				Si es posible, ¿desea utilizar un servicio de recogida?
				<select id="servicio" name="servicio">
					<option value="no">No</option>
					<option value="si">Sí</option>
				</select>
			</p>
			<input value="Aceptar" type="submit" onclick="checkValues()" />
			<input value="Cancelar" type="button" onclick="history.back()" />
		</form>
	</div>
</body>
</html>
