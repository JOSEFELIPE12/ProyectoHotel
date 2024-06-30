<%-- 
    Document   : VistaValidarCliente
    Created on : 15/06/2024, 01:42:25 AM
    Author     : Jose Felipe
--%>

<%@page import="presentacion.PresValidarCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Acceso al Sistema</title>
</head>
<body>
    <h1>Acceso al Sistema</h1>
    <% PresValidarCliente pres = (PresValidarCliente) session.getAttribute("pres"); %>
    <% String msg = pres.getMsg(); %>
    <form action="ControlValidarCliente" method="Post">
        <table>
            <tr><td>DNI</td><td><input type="text" name="dni" size="15" /></td></tr>
            <tr><td>Password</td><td><input type="password" name="pas" size="15" /></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" name="acc" value="Validarse"/></td></tr>
        </table>
    </form>
    <h3><%= msg %></h3>
</body>
</html>