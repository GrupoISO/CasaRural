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
    <link rel="stylesheet" href="css/layout.css" type="text/css">
    <link rel="stylesheet" href="css/skeleton.css" type="text/css">
    <link rel="stylesheet" href="css/tables.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>CrearRecorrido</h1>
		<br />
		<h2>Lista de Casas Rurales</h2>
		<p>Seleccione las casas rurales que forman parte del recorrido que
			quiere crear</p>
		<form action="Recorrido2.jsp">
			<div id="tablaCasas" class="zebra-striped">
				<table>
					<thead>
						<tr>
							<th>Número Casa</th>
							<th>Propietario</th>
							<th>Población</th>
							<th><b>Añadir</b></th>
						</tr>
					</thead>
					<tbody>
						<%
							if (crearRecorridoBean.getCasas() != null){
								List<Casa> lista = crearRecorridoBean.getCasas();
								for (Casa casa: lista) {
						%>
						<tr>
							<td><%= casa.getNumCasa() %></td>
							<td><%= casa.getPropietario() %></td>
							<td><%= casa.getPoblacion() %></td>
							<td><input type="checkbox" name="recorrido" value="<%= casa.getNumCasa() %>"></td>
						</tr>
						<%
								}
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