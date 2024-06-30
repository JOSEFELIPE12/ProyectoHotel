package negocio;

import java.util.*;
import servicio.Fecha;

public class Reserva {
    private String numr;
    private int numh;
    private String hor;
    private String fent;
    private String fsal;
    private String dni;
    private String nom;
    private List<Object[]> detallesReserva;

    public Reserva() {
        detallesReserva = new ArrayList<>();
    }

    public Reserva(String numr, int numh, String hor, String fent, String fsal, String dni) {
        this.numr = numr;
        this.numh = numh;
        this.hor = hor;
        this.fent = fent;
        this.fsal = fsal;
        this.dni = dni;
        this.detallesReserva = new ArrayList<>();
    }

    public String getNumr() {
        return numr;
    }

    public void setNumr(String numr) {
        this.numr = numr;
    }

    public int getNumh() {
        return numh;
    }

    public void setNumh(int numh) {
        this.numh = numh;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public String getFent() {
        return fent;
    }

    public void setFent(String fent) {
        this.fent = fent;
    }

    public String getFsal() {
        return fsal;
    }

    public void setFsal(String fsal) {
        this.fsal = fsal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Object[]> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<Object[]> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public void agregarDetalle(int numh, String tipo, double pre, String fent, String fsal, int numd, double total) {
        Object[] detalle = new Object[7];
        detalle[0] = numh;
        detalle[1] = tipo;
        detalle[2] = pre;
        detalle[3] = fent;
        detalle[4] = fsal;
        detalle[5] = numd;
        detalle[6] = total;
        detallesReserva.add(detalle);
    }

    public void quitarDetalle(int numh) {
        detallesReserva.removeIf(detalle -> detalle[0].equals(numh));
    }

    public double calcularTotal() {
        return detallesReserva.stream().mapToDouble(detalle -> (double) detalle[6]).sum();
    }

    public int calcularNumeroDias(String fent, String fsal) {
        return Fecha.calcularNumeroDias(fent, fsal);
    }
}