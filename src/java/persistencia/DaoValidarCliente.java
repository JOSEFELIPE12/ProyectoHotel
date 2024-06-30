package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoValidarCliente implements IDaoValidarCliente {
    @Override
    public Object[] validar(String dni, String pas) {
        String sql = "SELECT dni, nom FROM Cliente WHERE dni = ? AND pas = ?";
        Object[] fila = null;
        try (Connection conn = Acceso.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            pstmt.setString(2, pas);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    fila = new Object[]{rs.getString("dni"), rs.getString("nom")};
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fila;
    }
}