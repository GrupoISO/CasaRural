<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="casarural.Oferta" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
    <jsp:setProperty name="reservarCasaBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="reservarCasaBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="reservarCasaBean" property="numNoches" param="numNoches" />
    <jsp:setProperty name="reservarCasaBean" property="numTfnoReserva" param="numTfnoReserva" />
    <jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
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
		<% if (request.getParameter("idservicio") == null) {
			casarural.Reserva reserva = reservarCasaBean.getResultado();
			if (reserva == null) { %>
		<p style="color: red;">No se ha realizado la reserva, intente de nuevo</p>
		<% } else { %>
		<p>
			Se ha realizado la reserva, su número de reserva es:
			<%= reserva.getNumReserva() %>
		</p>
		<%
			}
		} else {
			Oferta oferta = new Oferta();
			oferta.setNumCasa(reservarCasaBean.getNumCasa());
			oferta.setPrecio(100);
			boolean estado = servicioRecogidaBean.transaccionDeReserva(oferta, reservarCasaBean.getNumTfnoReserva(), Integer.parseInt(request.getParameter("idservicio")), Integer.parseInt(request.getParameter("plazas")));
			if (estado){
		%>
		<p>Se ha realizado la reserva y se ha asignado el servicio selecionado.</p>
		<%
			}else{ %>
		<p style="color: red;">¡No se ha podido realizar la reserva con el servicio asociado!</p>
		<% }
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
