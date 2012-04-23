<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
  <script type="text/javascript">
<!--
    function checkValues()
    {
      if (document.formulario.numCasa.value < 0)
        alert('El numero de casa tiene que ser mayor que cero');
      return true;
    }
-->
  </script>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Reservar casa</title>
     <jsp:useBean id="mejorOfertaBean" scope="request" class="casarural.MejorOfertaBean"/>
  </head>
  <body>
    <form action="AceptarReserva.jsp" name="formulario" method="post">
      <P>
        <STRONG><U><FONT size="4">Reservar casa rural</FONT></U></STRONG> 
      </P>
      <P>&nbsp;</P>
      <P>Codigo de la casa: &nbsp;&nbsp;&nbsp;
      <%String casa=request.getParameter("numCasa");%>
        <input type="text" name="numCasa" value=<%= casa %>>
      </P>
      <P>Dia de entrada: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <%String fecha=request.getParameter("diaIni");%>
        <input type="text" name="diaIni" value=<%= fecha %> >(dd/mm/aaaa)
      </P>
      <P>Numero de noches: &nbsp;&nbsp;
      <%String numnoches=request.getParameter("numNoches");%>
        <input type="text" name="numNoches" value=<%= numnoches %>>
      </P>
      <P>Telefono de contacto:
        <input type="text" name="numTfnoReserva"/>
      </P>
      <P>&nbsp;</P>
      <P>&nbsp;</P>
      <P>
        <input value="Aceptar" type="SUBMIT" onclick="checkValues()"/>
        <input value="Cancelar" type="BUTTON" onclick="history.back()"/>
      </P>
    </form>
  </body>
</html>
