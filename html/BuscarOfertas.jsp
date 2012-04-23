<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
  	<script language="javascript">
      function validarFormulario() {
      	var diainicio=0; var mesinicio=0; var anyoinicio=0;
		var diafin=0; var mesfin=0; var anyofin=0; var mayor=0;
		
        if (formularioOfertas.diaIni.value.length == 0 || formularioOfertas.diaFin.value.length == 0){
        	alert('Es necesario rellenar los campos de fechas');
        	return false;
        }else{
        	diainicio=formularioOfertas.diaIni.value.substr(0,2);
			mesinicio=formularioOfertas.diaIni.value.substr(3,2);
			anyoinicio=formularioOfertas.diaIni.value.substr(6,4);
			diafin=formularioOfertas.diaFin.value.substr(0,2);
			mesfin=formularioOfertas.diaFin.value.substr(3,2);
			anyofin=formularioOfertas.diaFin.value.substr(6,4);
			
			/*control si la fecha inicial es mayor a la inicial*/
			if (anyofin<anyoinicio){
				mayor=1;
			}else if (mesfin<mesinicio && anyofin==anyoinicio){
				mayor=1;
			}else if (diafin<=diainicio && mesfin==mesinicio && anyofin==anyoinicio){
				mayor=1;
			}
			if (mayor==1){
				alert('La fecha de inicio no puede ser mayor o igual que la final');
				return false;
			}
        }
      return true;
      }
  	</script>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Buscar Ofertas</title>
    <LINK REL=StyleSheet HREF="calendar.css" TYPE="text/css">
		<SCRIPT LANGUAGE="JavaScript" SRC="weeklycalendar.js">
		</SCRIPT>
		<script language="javascript">				
			buildWeeklyCalendar(0);
		</script>
  </head>
  <body title="Buscar Ofertas">
    <form action="Ofertas.jsp" name="formularioOfertas" method="post" onsubmit="return validarFormulario()">
      <p>
        <strong><u><font size="4">Buscar Ofertas</font></u></strong> 
      </p>
      <p>Fecha de inicio:
        <input type="text" name="diaIni" id="diaIni" readonly="true"/>
        <input type="button" value="..." onClick="w_displayCalendar('diaIni');">
      </p>
      <p>Fecha de fin:
        <input type="text" name="diaFin" id="diaFin" readonly="true"/>
        <input type="button" value="..." onClick="w_displayCalendar('diaFin');">
      </p>
      
      <p>Precio m&aacute;ximo: <input type="text" name="precio"/></p>
      <p>N&uacute;mero m&iacute;nimo  de d&iacute;as: <input type="text" name="diasMin"/></p>
      <p>N&uacute;mero m&iacute;nimo de dormitorios: <input type="text" name="minDormitorios"/></p>
      <p>N&uacute;mero m&iacute;nimo de ba&ntilde;os: <input type="text" name="minWC"/></p>
      <p>Orden: 
      	<select name="orden">
      		<option value="1">Precio</option>
      		<option value="2">N&uacute;mero de noches</option>
      	</select>
      </p>
      <br/>
      <p>
        <input value="Aceptar" type="submit" />
        <input type="button" value="Cancelar" onclick="window.location='PantallaInicio.jsp'"/>
      </p> 
    </form>
  </body>
</html>
