package servicio;

import java.util.List;
import negocio.Reserva;
import persistencia.DaoReserva;
import persistencia.IDaoReserva;
import persistencia.DaoHabitacion;

public class ServReserva implements IServicioReserva {
    private IDaoReserva daoReserva;
    private Reserva res;
    
    public ServReserva() {
        this.daoReserva = new DaoReserva();
    }
    
    public ServReserva(IDaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    @Override
    public Object[] nuevaReserva(String dni, String nom) {
        res = new Reserva();
        res.setNumr(daoReserva.getNumGenerado());
        res.setFent(Fecha.getFec());
        res.setHor(Fecha.getHor());
        res.setDni(dni);
        res.setNom(nom);
        Object[] doc = new Object[6];
        doc[0] = res.getNumr();
        doc[1] = res.getFent();
        doc[2] = res.getHor();
        doc[3] = res.getDni();
        doc[4] = nom;
        doc[5] = res.calcularTotal();
        return doc;
    }

    @Override
    public int calcularNumeroDias(String fent, String fsal) {
        return Fecha.calcularNumeroDias(fent, fsal);
    }

    @Override
    public List<Object[]> agregarHabitacion(int numh, String tipo, String fent, String fsal, double total) {
        res.agregarDetalle(numh, tipo, total, fent, fsal, calcularNumeroDias(fent, fsal), total);
        return res.getDetallesReserva();
    }

    @Override
    public List<Object[]> quitarHabitacion(int numh) {
        res.quitarDetalle(numh);
        return res.getDetallesReserva();
    }

    @Override
    public String grabarReserva(Reserva reserva) {
        return daoReserva.grabar(reserva);
    }
    @Override
    public List<Object[]> listarHabitacion() {
        return DaoHabitacion.listar();
    }
}
