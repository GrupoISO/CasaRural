<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
    <jsp:setProperty name="reservarCasaBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="reservarCasaBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="reservarCasaBean" property="numNoches" param="numNoches" />
    <jsp:setProperty name="reservarCasaBean" property="numTfnoReserva" param="numTfnoReserva" />
    <link rel="StyleSheet" href="css/base.css" type="text/css" />
	<link rel="StyleSheet" href="css/layout.css" type="text/css" />
	<link rel="StyleSheet" href="css/skeleton.css" type="text/css" />
  </head>
<body>
	<div class="container">
		<h1>Reserva Completada</h1>
		<p>
			Los Datos de tu reserva son los siguientes:
			<br/>
			Num Casa:
			<jsp:getProperty name="reservarCasaBean" property="numCasa" />
			<br /> Dia Ini:
			<jsp:getProperty name="reservarCasaBean" property="diaIni" />
			<br /> Num noches:
			<jsp:getProperty name="reservarCasaBean" property="numNoches" />
			<br /> Num tfno:
			<jsp:getProperty name="reservarCasaBean" property="numTfnoReserva" />
			<br />
		</p>
		<% if (request.getParameter("servicio") == null) {
			casarural.Reserva reserva = reservarCasaBean.getResultado();
			if (reserva == null) { %>
		<p style="color: red;">No se ha realizado la reserva, intente de nuevo</p>
		<% } else { %>
		<p>
			Se ha realizado la reserva, su número de reserva es:&nbsq;
			<%= reserva.getNumReserva() %>
		</p>
		<%
			}
		} else {
		%>
		<p>Se supone que ha elegido un servicio</p>
		<%
			}
		%>
		<br>
		<p>
			<input type="button" value="Inicio"
				onclick="location.href='PantallaInicio.jsp'" /> <input type="button"
				value="Volver" onclick="history.back()" />
		</p>
	</div>
</body>
</html>
