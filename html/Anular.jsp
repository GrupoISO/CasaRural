<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Anular Reservas</title>
<LINK REL=StyleSheet HREF="css/casarural.css" TYPE="text/css">
<jsp:useBean id="anularBean" scope="request" class="casarural.AnularReservaBean" />
<%String[] reservas = request.getParameterValues("anular");
anularBean.setAnulaciones(reservas);
int[] res = anularBean.getResultado(); %>
</head>
<body>
<h1>ANULAR RESERVAS</h1>
<strong>Resultado de las anulaciones:</strong><br />
<%if (reservas==null || res==null){ %>
	<strong>No se han hecho anulaciones</strong>
<%}
else{
	for(int i=0;i<res.length;i++){%>
	<p>Reserva <%=reservas[i] %>: <%if (res[i]==0){ %>Anulación correcta<%}
									else if (res[i]==1){%> Error en la anulación<%} 
									else if (res[i]==2){%> Anulación correcta. Se le devolverá el 20% del importe.<%} %>
	</p>
	<%}
}%>
<form name="frmBotones" action="AnularReservas.jsp" />
	<input type="submit" class="boton" name="btnAtras" value="Atr&aacute;s" />
	<input type="button" class="boton" name="btnInicio" value="Volver al inicio" onclick="window.location='PantallaInicio.jsp'" />
</form>
</body>
</html>