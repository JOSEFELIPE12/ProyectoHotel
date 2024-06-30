package servicio;
import persistencia.IDaoValidarCliente;

public class ServValidarCliente implements IServicioValidarCliente {
    private IDaoValidarCliente daoValidarCliente;

    public ServValidarCliente(IDaoValidarCliente daoValidarCliente) {
        this.daoValidarCliente = daoValidarCliente;
    }

    @Override
    public Object[] validarCliente(String dni, String pas) {
        return daoValidarCliente.validar(dni, pas);
    }
}