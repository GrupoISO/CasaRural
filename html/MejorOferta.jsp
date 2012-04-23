<%@ page contentType="text/html;charset=windows-1252"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Mejor Oferta</title>
    <jsp:useBean id="mejorOfertaBean" scope="request" class="casarural.MejorOfertaBean"/>
    <jsp:setProperty name="mejorOfertaBean" property="habitaciones" param="numHabs" />
    <jsp:setProperty name="mejorOfertaBean" property="banos" param="numBanos" />
    <jsp:setProperty name="mejorOfertaBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="mejorOfertaBean" property="diaFin" param="diaFin" />
    <jsp:setProperty name="mejorOfertaBean" property="criterio" param="criterio" />
  </head>
  <body>
     <form action="ReservarCasa.jsp" name="formulario" method="post">
        <P>
          <STRONG><U><FONT size="4">Obtener mejor oferta</FONT></U></STRONG>
        </P>
      
        <P>&nbsp;</P>
      
          <% java.util.Enumeration estados = mejorOfertaBean.getResultado().elements();
            int numcasa=((Integer)estados.nextElement()).intValue();
            float precio=((Float)estados.nextElement()).floatValue();
            int tamano=((Integer)estados.nextElement()).intValue();
if (tamano>0){out.println("La mejor casa es: "+numcasa);%><br/><%
out.println("Su precio es: "+precio+ "€");%><br/><%
out.println("Su tamaño es: "+tamano);}
else {out.println("Lo sentimos, no hay ofertas.");}

          %>
          <input type="hidden" name="diaIni" value="<%= mejorOfertaBean.getDiaIni() %>">
        <input type="hidden" name="numCasa" value="<%= String.valueOf(mejorOfertaBean.getNumCasa()) %>">
        <%
java.sql.Date dfin=mejorOfertaBean.getDiaFinAsDate();
java.sql.Date dini=mejorOfertaBean.getDiaIniAsDate();
long numNoches=(dfin.getTime()-dini.getTime())/(1000*60*60*24);

        %>
        <input type="hidden" name="numNoches" value="<%= Long.toString(numNoches) %>">
        <P>
        <% String s;if (tamano>0) s="SUBMIT";else s="hidden";%>
          <input value="Reservar" type= "<%= s %>"/>
          <input type="BUTTON" value="Volver" onclick="history.back()"/>
        </P>
      </form>
  </body>
</html>

