package controller;
import java.io.*;
import dao.PatientDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Patient;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    private PatientDAO dao = new PatientDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Patient p = new Patient();
        p.setName(req.getParameter("name"));
        p.setAge(Integer.parseInt(req.getParameter("age")));
        p.setGender(req.getParameter("gender"));
        p.setPhone(req.getParameter("phone"));
        p.setAddress(req.getParameter("address"));

        dao.addPatient(p);
        res.sendRedirect(req.getContextPath() + "/patient");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("patients", dao.getAllPatients());
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/patientList.jsp");
        rd.forward(req, res);
    }
}
