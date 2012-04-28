<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Recorrido</title>
<jsp:useBean id="comprobarAdministradorBean" class="casarural.ComprobarAdministradorBean"></jsp:useBean>
<link rel="StyleSheet" href="css/base.css" type="text/css">
<link rel="StyleSheet" href="css/layout.css" type="text/css">
<link rel="StyleSheet" href="css/skeleton.css" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Crear Recorrido</h1>
		<p>Para crear un servicio, debe autenticarse como Administrador</p>
		<form action="CrearRecorrido.jsp" name="formularioRec" method="post">
			<p>
				Nombre de Usuario: <input type="text" name="nombre" />
			</p>
			<input type="submit" value="Entrar" />
		</form>
		<%
			String usuario = request.getParameter("nombre");
			if (usuario != null)
				if (comprobarAdministradorBean.esAdministrador(usuario)) {
					response.sendRedirect("Recorrido.jsp");
				} else {
		%>
		<div id="error" style="color:red;">
			<p>
				<b>Administrador no valido!</b>
			<p>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>