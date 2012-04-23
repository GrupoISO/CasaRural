<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="casarural.ConsultarDisponibilidadBean" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>untitled</title>
    <jsp:useBean id="consultarDisponibilidadBean" scope="request" class="casarural.ConsultarDisponibilidadBean"/>
    <jsp:setProperty name="consultarDisponibilidadBean" property="numCasa" param="numCasa" />
    <jsp:setProperty name="consultarDisponibilidadBean" property="diaIni" param="diaIni" />
    <jsp:setProperty name="consultarDisponibilidadBean" property="numNoches" param="numNoches" />
  </head>
  <body>
     <form>
        <P>
          <STRONG><U><FONT size="4">Disponibilidad de casas rurales</FONT></U></STRONG>
        </P>
        <P>Num Casa:
          <jsp:getProperty name="consultarDisponibilidadBean" property="numCasa"/>
          <br/>Dia Ini:
          <jsp:getProperty name="consultarDisponibilidadBean" property="diaIni"/>
          <br/>Num noches:
          <jsp:getProperty name="consultarDisponibilidadBean" property="numNoches"/>
          <br/>
        </P>
        <P>&nbsp;</P>
        <table width="50%" border="2">
          <tr>
            <td width="50%">Dia</td>
            <td width="50%">Estado</td>
          </tr>
          
          <% java.util.Date baseDate = consultarDisponibilidadBean.getDiaIniAsDate(); %>
          <% java.util.Vector estados = consultarDisponibilidadBean.getResultado(); %>
          <% for (int index = 0; index < consultarDisponibilidadBean.getNumNoches(); index++) { %>
            <tr>
              <td width="50%">
                <%= (new java.util.Date(baseDate.getTime()+(24*60*60*1000*index))).toString() %>
              </td>
              <td>
                <% if (estados != null) {%>
                  <%= estados.elementAt(index).toString() %>
                <% } else { %>
                  [ERROR DE ESTADOS]
                <% } %>
              </td>
            </tr>
          <% } %>
        </table>
        <P>
          <input value="Aceptar" type="SUBMIT"/>
          <input type="BUTTON" value="Cancelar" onclick="history.back()"/>
        </P>
      </form>
  </body>
</html>
