<%-- 
    Document   : VistaReserva
    Created on : 15/06/2024, 11:32:17 AM
    Author     : Jose Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="presentacion.PresReserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registro de Reserva</title>
    <style>
        .center {
            margin: auto;
            width: 70%;
            padding: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        input[type="text"] {
            width: 100%;
            box-sizing: border-box;
        }
        .form-section {
            border: 1px solid black;
            padding: 10px;
            width: 50%;
            margin: auto;
        }
        .center-text {
            text-align: center;
        }
        .detalle-habitacion {
            width: 90px;
        }
    </style>
</head>
<body>
    <h1 class="center-text">Registro de Reserva</h1>
    <div class="form-section">
        <table>
            <tr>
                <td>Número de Reserva:</td>
                <td><input type="text" value="${pres.doc[0]}" readonly></td>
            </tr>
            <tr>
                <td>Fecha de Reserva:</td>
                <td><input type="text" value="${pres.doc[1]}" readonly></td>
            </tr>
            <tr>
                <td>Hora de Reserva:</td>
                <td><input type="text" value="${pres.doc[2]}" readonly></td>
            </tr>
            <tr>
                <td>DNI de cliente:</td>
                <td><input type="text" value="${pres.doc[3]}" readonly></td>
            </tr>
            <tr>
                <td>Nombre de cliente:</td>
                <td><input type="text" value="${pres.doc[4]}" readonly></td>
            </tr>
        </table>
    </div>
    <h2 class="center-text">Detalle de Habitaciones</h2>
    <table border="1" class="center">
        <tr>
            <th>Número</th>
            <th>Tipo</th>
            <th>Precio</th>
            <th>Fecha Entrada</th>
            <th>Fecha Salida</th>
            <th>Número de Días</th>
            <th>Total</th>
            <th>Acción</th>
        </tr>
        <c:forEach var="detalle" items="${pres.detalles}">
            <tr>
                <td><input type="text" value="${detalle[0]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[1]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[2]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[3]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[4]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[5]}" readonly class="detalle-habitacion"></td>
                <td><input type="text" value="${detalle[6]}" readonly class="detalle-habitacion"></td>
                <td>
                    <form action="ControlReserva" method="post">
                        <input type="hidden" name="acc" value="Quitar Habitación">
                        <input type="hidden" name="numh" value="${detalle[0]}">
                        <input type="submit" value="Quitar Habitación">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p class="center">Total ===> <input type="text" value="${pres.reserva.calcularTotal()}" readonly></p>
    <div class="center">
        <form action="ControlReserva" method="post" style="display:inline;">
            <input type="hidden" name="acc" value="Listar Habitacion">
            <input type="submit" value="Listar Habitacion">
        </form>
        <form action="ControlReserva" method="post" style="display:inline;">
            <input type="hidden" name="acc" value="Grabar Reserva">
            <input type="submit" value="Grabar Reserva">
        </form>
    </div>
    <c:if test="${not empty pres.msg}">
        <p>${pres.msg}</p>
    </c:if>
</body>
</html>
