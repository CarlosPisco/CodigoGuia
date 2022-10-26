package servlets;

import Beans.JobBean;
import Daos.JobDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "JobServlet", value = "/JobServlet")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion")==null?"listar":request.getParameter("accion");
        RequestDispatcher view;
        JobDao jobDao = new JobDao();
        switch (accion) {
            case "listar":
                ArrayList<JobBean> listaTrabajos = jobDao.obtenerTrabajos();

                request.setAttribute("listaTrabajdos", listaTrabajos);

                view = request.getRequestDispatcher("listaTrabajos.jsp");
                view.forward(request, response);
                break;
            case "crear":
                view = request.getRequestDispatcher("nuevoTrabajo.jsp");
                view.forward(request, response);
                break;
            case "editar":
                String idTrabajo = request.getParameter("id");
                JobBean job = jobDao.obtenerTrabajo(idTrabajo);

                request.setAttribute("trabajo", job);

                view = request.getRequestDispatcher("editarTrabajo.jsp");
                view.forward(request, response);
                break;
            case "eliminar":
                String idTrabajo2 = request.getParameter("id");
                jobDao.eliminarTrabajo(idTrabajo2);
                response.sendRedirect(request.getContextPath()+"/JobServlet");
                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")==null?"crear":request.getParameter("accion");

        JobDao jobDao = new JobDao();
        switch (accion){
            case "crear":
                String jobId = request.getParameter("jobId");
                String jobTitle = request.getParameter("jobTitle");
                String minSalary = request.getParameter("minSalary");
                String maxSalary = request.getParameter("maxSalary");

                jobDao.crearTrabajo(jobId, jobTitle, Integer.parseInt(minSalary), Integer.parseInt(maxSalary));

                response.sendRedirect(request.getContextPath()+"/JobServlet");
                break;

            case "editar":
                String jobId2 = request.getParameter("jobId");
                String jobTitle2 = request.getParameter("jobTitle");
                String minSalary2 = request.getParameter("minSalary");
                String maxSalary2 = request.getParameter("maxSalary");

                jobDao.editarTrabajo(jobId2, jobTitle2, Integer.parseInt(minSalary2), Integer.parseInt(maxSalary2));

                response.sendRedirect(request.getContextPath()+"/JobServlet");
                break;
        }
    }
}
