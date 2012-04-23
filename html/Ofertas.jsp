<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="casarural.Oferta" %>
<%! final int diams = 1000*60*60*24; %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Ofertas</title>
    <jsp:useBean id="buscarOfertasBean" scope="request" class="casarural.BuscarOfertasBean"/>
    <jsp:setProperty name="buscarOfertasBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="buscarOfertasBean" property="diaFin" param="diaFin" />
    <jsp:setProperty name="buscarOfertasBean" property="precio" param="precio" />
    <jsp:setProperty name="buscarOfertasBean" property="diasMin" param="diasMin" />
    <jsp:setProperty name="buscarOfertasBean" property="minDormitorios" param="minDormitorios" />
    <jsp:setProperty name="buscarOfertasBean" property="minWC" param="minWC" />
    <jsp:setProperty name="buscarOfertasBean" property="orden" param="orden" />
  </head>
  <body>
    <p>
      <strong><u><font size="4">Ofertas de casas rurales</font></u></strong>
    </p>
    <% 	Vector ofertas = buscarOfertasBean.getOfertas();
    	for (int index = 0; index < ofertas.size(); index++) { %>
  
    	<form action="ReservarCasa.jsp" name="formularioReservar" method="post"> 
    		<% Oferta ofer = (Oferta)ofertas.elementAt(index); 
    		   int numCasa = ofer.getNumCasa();
    		   Date diaIni = ofer.getDiaIni();
    		   Date diaFin = ofer.getDiaFin();
    		   float precio = ofer.getPrecio();
    		   int numNoches = (int)((diaFin.getTime() - diaIni.getTime())/diams);
    		   
    		   Scanner sc; String dia, mes, anio; 
   			   sc = new Scanner(diaIni.toString());
   			   sc.useDelimiter("-");
   			   anio = sc.next(); mes = sc.next(); dia = sc.next();
   			   String diaInicial = dia+"/"+mes+"/"+anio;
   			   
   			   sc = new Scanner(diaFin.toString());
   			   sc.useDelimiter("-");
			   anio = sc.next(); mes = sc.next(); dia = sc.next();
			   String diaFinal = dia+"/"+mes+"/"+anio;	   
   			%>
   			Del <%=diaInicial %> al <%=diaFinal %> con precio <%=precio %>€ &nbsp; 
    		<input type="hidden" name="numCasa" value="<%=numCasa%>" />  
    		<input type="hidden" name="diaIni" value="<%=diaInicial%>" />  
    		<input type="hidden" name="numNoches" value="<%=numNoches%>" />  
			<input value="Reservar!" type="submit"/>     
    	</form><br/>
    <% } %>
    <p>
      <input type="button" value="Nueva busqueda" onclick="history.back()"/>
      <input type="button" value="Volver a Inicio" onclick="window.location='PantallaInicio.jsp'"/>
    </p>
  </body>
</html>
