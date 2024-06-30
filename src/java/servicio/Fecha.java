package servicio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Fecha {
    public static String getFec() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(d);
    }

    public static String getHor() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }

    public static int calcularNumeroDias(String fent, String fsal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaEntrada = LocalDate.parse(fent, formatter);
        LocalDate fechaSalida = LocalDate.parse(fsal, formatter);
        return (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }
}