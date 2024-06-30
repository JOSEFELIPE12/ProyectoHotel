<%-- 
    Document   : VistaHabitaciones
    Created on : 15/06/2024, 12:10:59 PM
    Author     : Jose Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="presentacion.PresReserva"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Habitaciones</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid black;
        }
        input[type="text"] {
            width: 100%;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <h1>Lista de Habitaciones</h1>
    <form action="ControlReserva" method="post">
        <input type="hidden" name="acc" value="Agregar Habitación">
        <table>
            <tr>
                <th>Número</th>
                <th>Tipo</th>
                <th>Precio</th>
                <th>Fecha Entrada</th>
                <th>Fecha Salida</th>
                <th>Acción</th>
            </tr>
            <c:forEach var="habitacion" items="${pres.habitaciones}">
                <tr>
                    <td><input type="text" name="numh" value="${habitacion[0]}" readonly></td>
                    <td><input type="text" name="tipo" value="${habitacion[1]}" readonly></td>
                    <td><input type="text" name="pre" value="${habitacion[2]}" readonly></td>
                    <td><input type="text" name="fent"></td>
                    <td><input type="text" name="fsal"></td>
                    <td><input type="submit" value="Agregar Habitación"></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>