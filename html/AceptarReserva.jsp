<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="reservarCasaBean" scope="session" class="casarural.ReservarCasaBean"/>
    <jsp:setProperty name="reservarCasaBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="reservarCasaBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="reservarCasaBean" property="numNoches" param="numNoches" />
    <jsp:setProperty name="reservarCasaBean" property="numTfnoReserva" param="numTfnoReserva" />
  </head>
  <body>
    <p>
    Num Casa: 
    <jsp:getProperty name="reservarCasaBean" property="numCasa" /> <br/>
    Dia Ini: 
    <jsp:getProperty name="reservarCasaBean" property="diaIni"  /> <br/>
    Num noches: 
    <jsp:getProperty name="reservarCasaBean" property="numNoches"  /> <br/> 
    Num tfno: 
    <jsp:getProperty name="reservarCasaBean" property="numTfnoReserva" /> <br/>
    </p>
    <%
      casarural.Reserva reserva = reservarCasaBean.getResultado();
      if (reserva == null)
      {
    %>
    <h4>Reserva no realizada</h4>
    <%
      }
      else
      {
    %>
      <%= reserva.getNumReserva() %>
    <%
      }
    %>
      <form>
        <P>&nbsp;</P>
        <P>
          <a href="PantallaInicio.jsp">Pulse aqu&iacute; para volver a la pantalla inicial</a>
        </P>
        <P>&nbsp;</P>
      </form>
  </body>
</html>
