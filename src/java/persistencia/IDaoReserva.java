package persistencia;


import negocio.Reserva;

public interface IDaoReserva {
    String getNumGenerado();
    String grabar(Reserva m);
}
