<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.Casa" %>
<%@ page import="casarural.CrearRecorridoBean" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recorrido</title>
	<jsp:useBean id="crearRecorridoBean" scope="request" class="casarural.CrearRecorridoBean"/>
    <link rel="stylesheet" href="css/base.css" type="text/css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/tables.css">
</head>
<body>
	<div class="container">
		<h1>CrearRecorrido</h1>
		<br />
		<h2>Lista de Casas Rurales</h2>
		<p>Seleccione las casas rurales que forman parte del recorrido que
			quiere crear</p>
		<form>
		<% crearRecorridoBean.getCasas(); %>
			<div id="tablaCasas" class="zebra-striped">
				<table>
					<thead>
						<tr>
							<th>N�mero Casa</th>
							<th>Propietario</th>
							<th>Poblaci�n</th>
							<th><b>A�adir</b></th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int index = 0; index < crearRecorridoBean.getCasas().size(); index++) {
						%>
						<tr>
							<td>23</td>
							<td>Yo</td>
							<td>Donostia</td>
							<td>Checkbox</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<br />
			<input type="submit" value="Crear Recorrido" />
			<input type="button" value="Cancelar" onclick="history.back()" />
		</form>
	</div>
</body>
</html>