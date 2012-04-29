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
    <jsp:useBean id="mejorOfertaBean" scope="request" class="casarural.MejorOfertaBean"/>
	<jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
    <link rel="StyleSheet" href="css/base.css" type="text/css">
	<link rel="StyleSheet" href="css/layout.css" type="text/css">
	<link rel="StyleSheet" href="css/skeleton.css" type="text/css">
  </head>
  <body>
	<div class="container">
		<form action="ReservarCasaServicio.jsp" name="formulario" method="post">
			<h1>Reservar Casa Rural</h1>
			<P>
				Codigo de la casa: &nbsp;&nbsp;&nbsp;
				<%String casa=request.getParameter("numCasa");%>
				<input type="text" name="numCasa" value=<%= casa %>>
			</P>
			<P>
				Dia de entrada: (dd/mm/aaaa) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%String fecha=request.getParameter("diaIni");%>
				<input type="text" name="diaIni" value=<%= fecha %>>
			</P>
			<P>
				Numero de noches: &nbsp;&nbsp;
				<%String numnoches=request.getParameter("numNoches");%>
				<input type="text" name="numNoches" value=<%= numnoches %>>
			</P>
			<P>
				Telefono de contacto: <input type="text" name="numTfnoReserva" />
			</P>
			<p>
				Si es posible, ¿Desea utilizar un servicio de recogida?
				<select id="servicio" name="servicio">
					<option value="no">No</option>
					<option value="si">Si</option>
				</select>
			</p>
			<input value="Aceptar" type="SUBMIT" onclick="checkValues()" />
			<input value="Cancelar" type="BUTTON" onclick="history.back()" />
		</form>
	</div>
</body>
</html>
