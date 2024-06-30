package persistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoHabitacion {
    public static List<Object[]> listar() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitacion";
        try (Connection conn = Acceso.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("numh");
                fila[1] = rs.getString("tipo");
                fila[2] = rs.getDouble("pre");
                lista.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}