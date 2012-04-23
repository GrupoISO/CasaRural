<%@ page contentType="text/html;charset=windows-1252"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>
Obtener mejor reserva
</title>
</head>
<body>
<h2>
Obtener mejor oferta 
</h2>
<form action="MejorOferta.jsp" name="formulario" method="post">
 <P>
        <STRONG><U><FONT size="4">Obtener mejor oferta</FONT></U></STRONG> 
      </P>
      <P>&nbsp;</P>
      
      <P>Dia de entrada: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="diaIni"/> (dd/mm/aaaa)
      </P>
       <P>Dia de salida: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="diaFin"/> (dd/mm/aaaa)
      </P>
       <P>Habitaciones: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="numHabs"/> 
      </P>
       <P>Baños: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="numBanos"/> 
      </P>
      <P>Criterio: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <select  name="criterio">
<option value="precio" selected>precio</option>
<option value="tamaño">tamano</option>
</select></P>
      <P>&nbsp;</P>
      <P>&nbsp;</P>
      <P>
        <input value="Aceptar" type="SUBMIT"/>
        <input type="BUTTON" value="Cancelar" onclick="window.location='PantallaInicio.jsp'"/>
      </P>
</form>

</body>
</html>
