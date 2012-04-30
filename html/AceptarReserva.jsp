<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="casarural.Oferta" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Finalización de Reserva de Casa Rural</title>
    <jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
    <jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
    <link rel="StyleSheet" href="css/base.css" type="text/css" />
	<link rel="StyleSheet" href="css/layout.css" type="text/css" />
	<link rel="StyleSheet" href="css/skeleton.css" type="text/css" />
  </head>
<body>
	<div class="container">
		<h1>Reserva Completada</h1>
		<p>
			Los datos de la reserva son los siguientes:<br />
			<strong>Número de casa</strong>: <jsp:getProperty name="reservarCasaBean" property="numCasa" /><br />
			<strong>Día de inicio</strong>: <jsp:getProperty name="reservarCasaBean" property="diaIni" /><br />
			<strong>Número de noches</strong>: <jsp:getProperty name="reservarCasaBean" property="numNoches" /><br />
			<strong>Teléfono</strong>: <jsp:getProperty name="reservarCasaBean" property="numTfnoReserva" /><br />
		<%
		if (request.getParameter("idservicio") == null) {
		%>
		</p>
		<%
			casarural.Reserva reserva = reservarCasaBean.getResultado();
			if (reserva == null) {
		%>
		<p class="error">No se ha realizado la reserva, inténtelo de nuevo.</p>
		<%
			} else {
		%>
		<p>
			Se ha realizado la reserva de la casa.
			Número de reserva: <strong><%= reserva.getNumReserva() %></strong>
		</p>
		<%
			}
		} else {
			String id = request.getParameter("idservicio");
			int idservicio = Integer.parseInt(id);
			int plazas = Integer.parseInt(request.getParameter("plazas" + id));
		%>
			<strong>Servicio de recogida</strong>: <%= idservicio %> (<%= plazas %> plazas)<br />
		</p>
		<%
			casarural.Reserva reserva = reservarCasaBean.getResultado(idservicio, plazas);
			if (reserva == null) {
		%>
		<p class="error">No se ha realizado la reserva, inténtelo de nuevo.</p>
		<%
			} else {
		%>
		<p>
			Se ha realizado la reserva de la casa y del servicio de recogida.
			Número de reserva: <strong><%= reserva.getNumReserva() %></strong>
		</p>
		<%
			}
		}
		%>
		<p>
			<input type="button" value="Inicio" onclick="location.href='./'" />
			<input type="button" value="Volver" onclick="history.back()" />
		</p>
	</div>
</body>
</html>
