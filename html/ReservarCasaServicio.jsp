<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.Oferta" %>
<%@ page import="casarural.Servicio" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Selecci�n de Servicio de Recogida</title>
	<jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
	<jsp:setProperty name="reservarCasaBean" property="numCasa" param="numCasa" />
	<jsp:setProperty name="reservarCasaBean" property="diaIni" param="diaIni" />
	<jsp:setProperty name="reservarCasaBean" property="numNoches" param="numNoches" />
	<jsp:setProperty name="reservarCasaBean" property="numTfnoReserva" param="numTfnoReserva" />
	<jsp:useBean id="servicioRecogidaBean" scope="request" class="casarural.ServicioRecogidaBean"></jsp:useBean>
	<link rel="StyleSheet" href="css/base.css" type="text/css" />
	<link rel="StyleSheet" href="css/layout.css" type="text/css" />
	<link rel="StyleSheet" href="css/skeleton.css" type="text/css" />
	<link rel="stylesheet" href="css/tables.css" type="text/css" />
</head>
<body>
	<div class="container">
		<h1>Selecci�n de Servicio de Recogida</h1>
		<%
			String select = request.getParameter("servicio");
			if (select != null && select.equals("si")) {
				List<Servicio> listaServicios =
						servicioRecogidaBean.MostrarServicios(reservarCasaBean.getNumCasa(), reservarCasaBean.getDiaIni());
				if (!listaServicios.isEmpty()) {
		%>
		<p>Puede elegir un servicio, entre los disponibles asignados a la casa rural que ha elegido.</p>
		<p>�Recuerde! Solo tiene la posibilidad de elegir un servicio.</p>
		<br />
		<form action="AceptarReserva.jsp" method="post">
			<div id="tabla" class="zebra-striped">
				<table>
					<thead>
						<tr>
							<th>Hora</th>
							<th>Precio</th>
							<th>Plazas totales</th>
							<th>Plazas reservadas</th>
							<th>Recorrido</th>
							<th><b><u>Elegir servicio</u></b></th>
							<th><b><u>Elija n�mero de plazas</u></b>
						</tr>
					</thead>
					<tbody>
						<%
					for (Servicio servicio : listaServicios) {
						%>
						<tr>
							<td><%=servicio.getHora()%></td>
							<td><%=servicio.getPrecio()%></td>
							<td><%=servicio.getNumPlazas()%></td>
							<td><%=servicio.getNumPlazasReservadas()%>
							<td><%=servicio.getNumRecorrido()%></td>
							<td><input type="radio" name="idservicio"
								value="<%=servicio.getNumServicio()%>" /></td>
							<td>
								<select name="plazas">
									<%
						int i;
						int plazaslibres = (servicio.getNumPlazas()-servicio.getNumPlazasReservadas());
						for (i=1; i<=plazaslibres; i++) {
									%>
									<option value='<%= i %>'><%= i %></option>
									<%
						}
									%>
								</select>
							</td>
						</tr>
						<%
					}
						%>
					</tbody>
				</table>
			</div>
			<br />
			<input type="submit" value="Continuar" />
			<input type="button" value="Volver" onclick="history.back()" />
		</form>
		<%
				} else {
		%>
		<p style="color: blue;">Lamentamos comunicarle que no hay ning�n
			servicio de recogida disponible, a la casa rural que usted desea
			reservar en la fecha indicada.</p>
		<input type="button" value="Continuar sin recogida"	onclick="location.href('AceptarReserva.jsp')" />
		<input type="button" value="Volver" onclick="history.back()" />
			<%
				}
			} else {
				response.sendRedirect("AceptarReserva.jsp");
			}
			%>
	</div>
</body>
</html>