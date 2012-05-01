<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear Servicio</title>
<jsp:useBean id="comprobarAdministradorBean" class="casarural.ComprobarAdministradorBean"></jsp:useBean>
<link rel="StyleSheet" href="css/base.css" type="text/css">
<link rel="StyleSheet" href="css/layout.css" type="text/css">
<link rel="StyleSheet" href="css/skeleton.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Crear Servicio</h1>
		<p>Para crear un servicio de recogida, debe autenticarse como Administrador</p>
		<form action="CrearServicio.jsp" name="formularioServ" method="post">
			<p>
				Contraseña: <input type="text" name="nombre" />
			</p>
			<input type="submit" value="Entrar"/>
		</form>
		<%
			String usuario = request.getParameter("nombre");
			if (usuario != null)
				if (comprobarAdministradorBean.esAdministrador(usuario)) {
					response.sendRedirect("Servicio.jsp");
				} else {
		%>
		<div id="error" style="color:red;">
			<p>
				<b>¡Administrador no válido!</b>
			<p>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>