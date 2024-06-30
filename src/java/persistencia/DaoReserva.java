package persistencia;

import java.sql.*;

import negocio.Reserva;

public class DaoReserva implements IDaoReserva {
    @Override
    public String getNumGenerado() {
        return Acceso.getNum("SELECT numr FROM Reserva ORDER BY numr DESC FETCH FIRST 1 ROWS ONLY");
    }

    @Override
    public String grabar(Reserva m) {
        String msg = null;
        String sql = "INSERT INTO Reserva (numr, numh, hor, fent, fsal, dni) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Acceso.getConexion()) {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, m.getNumr());
            pst.setInt(2, m.getNumh());
            pst.setString(3, m.getHor());
            pst.setString(4, m.getFent());
            pst.setString(5, m.getFsal());
            pst.setString(6, m.getDni());
            pst.executeUpdate();
        } catch (SQLException e) {
            msg = e.getMessage();
        }
        return msg;
    }
}