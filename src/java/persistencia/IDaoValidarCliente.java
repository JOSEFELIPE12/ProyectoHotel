package persistencia;


public interface IDaoValidarCliente {
    Object[] validar(String dni, String pas);
}