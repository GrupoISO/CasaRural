<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="asignarDisponibilidadBean" scope="request" class="casarural.AsignarDisponibilidadBean"/>
    <jsp:setProperty name="asignarDisponibilidadBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="asignarDisponibilidadBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="asignarDisponibilidadBean" property="diaFin" param="diaFin" />
    <jsp:setProperty name="asignarDisponibilidadBean" property="precioString" param="precioString" />
  </head>
  <body>
  <% String error=asignarDisponibilidadBean.setResultado(); 
    if (error!=""){
      out.print(error);
    } else {
    %>
      Oferta añadida satisfactoriamente.  
    <%
    }
    %>
  
  </body>
</html>
