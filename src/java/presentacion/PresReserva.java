package presentacion;

import java.util.ArrayList;
import java.util.List;
import negocio.Reserva;

public class PresReserva {
    private String msg = "";
    private String pre = "";
    private Object[] doc = {"", "", "", "", "", ""};
    private List<Object[]> detalles = new ArrayList<>();
    private List<Object[]> habitaciones = new ArrayList<>();
    private Reserva reserva;

    public PresReserva() {
        detalles.add(new Object[]{"", "", "", "", "", "", ""});
        reserva = new Reserva();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public Object[] getDoc() {
        return doc;
    }

    public void setDoc(Object[] doc) {
        this.doc = doc;
    }

    public List<Object[]> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Object[]> detalles) {
        this.detalles = detalles;
    }

    public List<Object[]> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Object[]> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}