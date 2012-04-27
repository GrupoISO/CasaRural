<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.CrearRecorridoBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Recorrido</title>
	<jsp:useBean id="consultarDisponibilidadBean" scope="request" class="casarural.ConsultarDisponibilidadBean"/>
    <jsp:setProperty name="crearRecorridoBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="crearRecorridoBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="crearRecorridoBean" property="numNoches" param="numNoches" />
</head>
<body>
	<div class="container">
		
	
	</div>
</body>
</html>