package servicio;

import java.util.List;
import negocio.Reserva;


public interface IServicioReserva {
    Object[] nuevaReserva(String dni, String nom);
    int calcularNumeroDias(String fent, String fsal);
    List<Object[]> agregarHabitacion(int numh, String tipo, String fent, String fsal, double total);
    List<Object[]> quitarHabitacion(int numh);
    String grabarReserva(Reserva reserva);
    
    // Añadir la declaración del método listarHabitacion
    List<Object[]> listarHabitacion();
}