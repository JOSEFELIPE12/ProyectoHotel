<%-- 
    Document   : VistaMenuCliente
    Created on : 15/06/2024, 01:47:29 AM
    Author     : Jose Felipe
--%>

<%@page import="presentacion.PresValidarCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menú del Cliente</title>
</head>
<body>
    <h1>Menú del Cliente</h1>
    <% PresValidarCliente pres = (PresValidarCliente) session.getAttribute("pres"); %>
    <% Object[] fil = pres.getFil(); %>
    <form action="ControlReserva" method="Post">
        <table>
            <tr><td>DNI</td><td><input type="text" name="dni" size="8" value='<%= fil[0] %>' readonly/></td></tr>
            <tr><td>Nombre</td><td><input type="text" name="nom" size="25" value='<%= fil[1] %>' readonly/></td></tr>
        </table>
        <br>
        <input type="submit" name="acc" value="Nueva Reserva"/>
    </form>
</body>
</html>
