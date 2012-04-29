<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="casarural.Servicio" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Crear Servicio de Recogida</title>
	<jsp:useBean id="crearServicioBean" scope="request" class="casarural.CrearServicioBean"/>
    <link rel="stylesheet" href="css/base.css" type="text/css">
    <link rel="stylesheet" href="css/layout.css" type="text/css">
    <link rel="stylesheet" href="css/skeleton.css" type="text/css">
    <link rel="stylesheet" href="css/tables.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Crear Servicio de Recogida</h1>
		<%
			Servicio s = new Servicio();
		
			StringTokenizer st = new StringTokenizer (request.getParameter("fecha"), "/");
			int a = Integer.parseInt(st.nextToken());
	 		int m = Integer.parseInt(st.nextToken())-1;
	 		int d = Integer.parseInt(st.nextToken());
	 		GregorianCalendar gc = new GregorianCalendar(a, m, d);
			s.setFecha(new java.sql.Date(gc.getTime().getTime()));
			
			st = new StringTokenizer (request.getParameter("hora"), ":");
			int h = Integer.parseInt(st.nextToken())-1; // por alguna extraña razón
	 		int n = Integer.parseInt(st.nextToken());
	 		long l = (h*60+n)*60*1000;
	 		s.setHora(new java.sql.Time(l));
	 		
	 		s.setPrecio(Float.parseFloat(request.getParameter("precio")));
	 		s.setNumPlazas(Integer.parseInt(request.getParameter("plazas")));
	 		s.setNumRecorrido(Integer.parseInt(request.getParameter("recorrido")));
	 		s.setNumRecogida(Integer.parseInt(request.getParameter("recogida")));
	 		
	 		boolean b = crearServicioBean.crearServicio(s);
			
	 		if (b) {
	 	%>
	 	<p>Se ha creado el servicio de recogida satisfactoriamente.</p>
	 	<%
			} else {
		%>
		<p>Ha ocurrido un error. En caso de que el problema persista, ponganse en contacto con el administrador del sistema.</p>
		<%
			}
		%>
		<input type="button" value="Volver" onclick="location.href='./'" />
	</div>
</body>
</html>