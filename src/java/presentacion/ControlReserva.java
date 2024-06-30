package presentacion;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.IServicioHabitacion;
import servicio.IServicioReserva;
import servicio.ServHabitacion;
import servicio.ServReserva;
import persistencia.DaoHabitacion;
import persistencia.DaoReserva;

@WebServlet(name = "ControlReserva", urlPatterns = {"/ControlReserva"})
public class ControlReserva extends HttpServlet {
    private PresReserva pres;
    private IServicioReserva serv;
    private IServicioHabitacion servHabitacion;

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("acc");
        
        if (acc.equals("Nueva Reserva")) {
            pres = new PresReserva();
            serv = new ServReserva();
            String dni = request.getParameter("dni");
            String nom = request.getParameter("nom");
            pres.setDoc(serv.nuevaReserva(dni, nom));
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaReserva.jsp");
            
        } else if (acc.equals("Listar Habitacion")) {
            pres.setHabitaciones(serv.listarHabitacion());
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaHabitaciones.jsp");
            
        } else if (acc.equals("Agregar Habitacion")) {
            String numh = request.getParameter("numh");
            String tipo = request.getParameter("tipo");
            String pre = request.getParameter("pre");
            String fent = request.getParameter("fent");
            String fsal = request.getParameter("fsal");

            if (numh != null && !numh.isEmpty() &&
                tipo != null && !tipo.isEmpty() &&
                pre != null && !pre.isEmpty() &&
                fent != null && !fent.isEmpty() &&
                fsal != null && !fsal.isEmpty()) {
                try {
                    int numeroDias = serv.calcularNumeroDias(fent, fsal);
                    double precio = Double.parseDouble(pre);
                    double total = precio * numeroDias;
                    List<Object[]> detalles = serv.agregarHabitacion(Integer.parseInt(numh), tipo, fent, fsal, total);
                    pres.setDetalles(detalles);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    pres.setMsg("Error en la conversión de valores numéricos. Verifique los datos ingresados.");
                }
            } else {
                pres.setMsg("Por favor, complete todos los campos.");
            }
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaReserva.jsp");
            
        } else if (acc.equals("Quitar Habitacion")) {
            String numh = request.getParameter("numh");
            if (numh != null && !numh.isEmpty()) {
                List<Object[]> detalles = serv.quitarHabitacion(Integer.parseInt(numh));
                pres.setDetalles(detalles);
            }
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaReserva.jsp");
            
        } else if (acc.equals("Grabar Reserva")) {
            String msg = serv.grabarReserva(pres.getReserva());
            pres.setMsg(msg);
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaReserva.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}