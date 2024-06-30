package servicio;

import java.util.List;
import persistencia.IDaoHabitacion;

public class ServHabitacion implements IServicioHabitacion {
    private IDaoHabitacion daoHabitacion;

    public ServHabitacion(IDaoHabitacion daoHabitacion) {
        this.daoHabitacion = daoHabitacion;
    }

    @Override
    public List<Object[]> listarHabitacion() {
        return daoHabitacion.listar();
    }
}