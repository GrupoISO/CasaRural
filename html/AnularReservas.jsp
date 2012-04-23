<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.Reserva" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Anular Reservas</title>
	<jsp:useBean id="anularBean" scope="request" class="casarural.AnularReservaBean" />
	<jsp:setProperty name="anularBean" property="diaIni" param="fechaIni" />
	<jsp:setProperty name="anularBean" property="diaFin" param="fechaFin" />
	<LINK REL=StyleSheet HREF="calendar.css" TYPE="text/css">
	<LINK REL=StyleSheet HREF="css/casarural.css" TYPE="text/css">
	<SCRIPT LANGUAGE="JavaScript" SRC="weeklycalendar.js"></SCRIPT>
	<script language="javascript">				
		buildWeeklyCalendar(0);
	</script>
	<script language="javaScript" src="js/funciones_js.js" ></script>
</head>
<body>
	<h1>ANULAR RESERVAS</h1>
	<form name="frmListado" action="AnularReservas.jsp?accion=listado" method="POST" onSubmit="return validarFechas()">
		<label><strong>Fecha Inicio (dd/mm/aaaa)</strong></label>
		<input type="text" name="fechaIni" id="fechaIni" />
		<input type="button" class="calendario" value="" onClick="w_displayCalendar('fechaIni');" />
		<label><strong>Fecha Fin (dd/mm/aaaa)</strong></label>
		<input type="text" name="fechaFin" id="fechaFin" />
		<input type="button" class="calendario" value="" onClick="w_displayCalendar('fechaFin');" />
		<br>
		<input type="submit" class="boton" name="btnEnviar" value="Listar" />
		<input type="button" class="boton" name="btnVolver" value="Volver" onclick="window.location='PantallaInicio.jsp'" />
	</form>
	<% if (request.getParameter("accion")!=null){
			if (request.getParameter("accion").equals("listado")){ 
			Vector<Reserva> res = anularBean.getReservas();
			if (res==null || res.isEmpty()){
			%>
			<strong>No hay reservas entre las fechas seleccionadas</strong>
			<%}
			else{
			%>
	<form name="frmAnular" action="Anular.jsp" method="POST" onSubmit="return validarAnulaciones()">
		<table>
			<tr>
				<th>Número reserva</th>
				<th>Número casa </th>
				<th>Precio total (euros)</th>
				<th>¿Anular?</th>
			</tr>
		<%for (int i=0;i<res.size();i++){%>
			<tr class="<%if (i%2==0){ %>cebra1<%}else{ %>cebra2<%} %>">
				<td><%=res.elementAt(i).getNumReserva() %></td>
				<td><%=res.elementAt(i).getNumCasa() %></td>
				<td><%=res.elementAt(i).getPrecioTotal() %></td>
				<td><input type="checkbox" name="anular" value="<%=res.elementAt(i).getNumReserva() %>" /></td>
			</tr>
		<%} %>
		</table>
		<input type="submit" class="boton" name="btnEnviar" value="Anular" />
	</form>
	<%}//else
	}//if listado
	}//if null%>
</body>
</html>