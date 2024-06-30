package persistencia;

import java.util.List;

public class DaoCliente implements IDaoCliente {
    @Override
    public List<Object[]> listar() {
        return Acceso.listar("SELECT * FROM Cliente");
    }
}