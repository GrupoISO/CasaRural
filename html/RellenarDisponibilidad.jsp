<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="asignarDisponibilidadBean" scope="request" class="casarural.AsignarDisponibilidadBean"/>
    <jsp:setProperty name="asignarDisponibilidadBean" property="codPropietario" param="codPropietario" />
  </head>
  <body>
    <form action="procesaDisponibilidad.jsp" name="rellenarDisponibilidad" method="post">
      <P>
        <STRONG><U><FONT size="4">Rellenar disponibilidad</FONT></U></STRONG>
      </P>
      <P>&nbsp;</P>
      <P>Lista de casas:
      </P>
      <P>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="numCasa" size="8">
        <% 
          if (asignarDisponibilidadBean.getResultado() != null)
          {
            java.util.Iterator iteradorCasa = asignarDisponibilidadBean.getResultado().iterator();
            while (iteradorCasa.hasNext())
            {
              Integer casa = (Integer)iteradorCasa.next();
              
        %>
        
        
        <option value="<%= casa.toString()%>"> <%= casa %>  
        </option>
        <%   }
          }
        %>
        </select>
      </P>
      <P>Precio: &nbsp;&nbsp;&nbsp;
      <input type="text" name="precioString"/></P>
      <P>Dia inicio:
        <input type="text" name="diaIni"/>
      </P>
      <P>Dia fin: &nbsp;&nbsp;&nbsp;
        <input type="text" name="diaFin"/>
      </P>
      <P>&nbsp;</P>
      <P>
        <input type="SUBMIT" value="Aceptar"/>
        <input type="BUTTON" value="Cancelar" onclick="history.back()"/>
      </P>
    </form>
  </body>
</html>
