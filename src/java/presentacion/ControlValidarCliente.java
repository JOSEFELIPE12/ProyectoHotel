package presentacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.IServicioValidarCliente;
import servicio.ServValidarCliente;
import persistencia.DaoValidarCliente;

@WebServlet(name = "ControlValidarCliente", urlPatterns = {"/ControlValidarCliente"})
public class ControlValidarCliente extends HttpServlet {
    private PresValidarCliente pres;
    private IServicioValidarCliente serv;

    public ControlValidarCliente() {
        this.serv = new ServValidarCliente(new DaoValidarCliente());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("acc");
        if (acc.equals("Reservar")) {
            pres = new PresValidarCliente();
            request.getSession().setAttribute("pres", pres);
            response.sendRedirect("VistaValidarCliente.jsp");
        } else if (acc.equals("Validarse")) {
            String dni = request.getParameter("dni");
            String pas = request.getParameter("pas");
            Object[] fil = serv.validarCliente(dni, pas);
            if (fil != null) {
                pres.setFil(fil);
                response.sendRedirect("VistaMenuCliente.jsp");
            } else {
                pres.setMsg("Datos Incorrectos");
                response.sendRedirect("VistaValidarCliente.jsp");
            }
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
        return "Controlador de Validación de Cliente";
    }
}