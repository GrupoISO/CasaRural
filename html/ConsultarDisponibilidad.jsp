<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Consultar disponibilidad</title>
  </head>
  <body title="Consultar Disponibilidad">
    <form action="Disponibilidad.jsp" name="formularioDisp" method="post">
      <P>
        <STRONG><U><FONT size="4">Consultar disponibilidad</FONT></U></STRONG> 
      </P>
      <P>&nbsp;</P>
      <P>Codigo de la casa:
        <input type="text" name="numCasa"/>
      </P>
      <P>Dia de entrada: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="diaIni"/> (dd/mm/aaaa)
      </P>
      <P>Numero de noches:
        <input type="text" name="numNoches"/>
      </P>
      <P>&nbsp;</P>
      <P>&nbsp;</P>
      <P>
        <input value="Aceptar" type="SUBMIT"/>
        <input type="BUTTON" value="Cancelar" onclick="window.location='PantallaInicio.jsp'"/>
      </P>
    </form>
    <P>
    </P>
    <P>&nbsp;
    </P>
    <P>&nbsp;</P>
  </body>
</html>
