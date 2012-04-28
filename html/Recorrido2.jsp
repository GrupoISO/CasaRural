<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="casarural.Casa" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Crear Recorrido</title>
	<link rel="stylesheet" href="css/base.css">
	<jsp:useBean id="crearRecorridoBean" scope="request" class="casarural.CrearRecorridoBean"/>
    <link rel="stylesheet" href="css/base.css" type="text/css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/tables.css">
</head>
<body>
	<div class="container">
		<%
			String select[] = request.getParameterValues("recorrido");
			if (select != null && select.length != 0) {
				java.util.List<Casa> listaRecorrido = new java.util.ArrayList<Casa>();
				for (int i = 0; i < select.length; i++) {
					Casa casa = new Casa();
					casa.setNumCasa(Integer.parseInt(select[i]));
					listaRecorrido.add(casa);
				}
				crearRecorridoBean.selecCasas(listaRecorrido);
		%>
		<div id="exito">
			<h2>Se ha creado el recorrido</h2>
		</div>
		<%
			} else {
		%>
		<div id="error">
			<h2>Ha ocurrido un erro</h2>
			<p>Compruebe que ha seleccionado alg�n campo al crear el
				recorrido
			<p>
			<p>En caso de que el problema persista, ponganse en contacto con
				el administrador del sistema
			<p>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>