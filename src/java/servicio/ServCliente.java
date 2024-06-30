package servicio;
import java.util.List;
import persistencia.IDaoCliente;

public class ServCliente implements IServicioCliente {
    private IDaoCliente daoCliente;

    public ServCliente(IDaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    @Override
    public List<Object[]> listarCliente() {
        return daoCliente.listar();
    }
}