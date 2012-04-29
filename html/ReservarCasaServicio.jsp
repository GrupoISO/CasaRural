<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="casarural.Servicio" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleciones Servicio De Recogida</title>
<jsp:useBean id="mejorOfertaBean" scope="request" class="casarural.MejorOfertaBean"/>
<jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
<jsp:setProperty name="reservarCasaBean" property="numCasa" param="numCasa" />
<jsp:setProperty name="reservarCasaBean" property="diaIni" param="diaIni" />
<jsp:setProperty name="reservarCasaBean" property="numNoches" param="numNoches" />
<jsp:setProperty name="reservarCasaBean" property="numTfnoReserva" param="numTfnoReserva" />
<jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
<link rel="StyleSheet" href="css/base.css" type="text/css">
<link rel="StyleSheet" href="css/layout.css" type="text/css">
<link rel="StyleSheet" href="css/skeleton.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1> Seleccione Servicio </h1>
		<p>Puede elegir un servicio, entre los disponibles asignados a la casa rural que ha elegido.<p>
		<br>
		<form action="AceptarReserva.jsp" method="post">
			<div id="tabla" class="zebra-striped">
				<table>
					<thead>
						<tr>
							<th>Numero Servicio</th>
							<th>Horario</th>
							<th>Num Plazas</th>
							<th>Precio<th>
							<th>Num Plazas Reservadas</th>
							<th>Num Recorrido</th>
							<th><b><u>Elegir Servicio</u></b></th>
						</tr>
					</thead>
					<tbody>
						<% if(servicioRecogidaBean.MostrarServicios(numCasa, fechaElegida)) %>
					</tbody>
				</table>
			</div>
		</form> 
	</div>
</body>
</html>