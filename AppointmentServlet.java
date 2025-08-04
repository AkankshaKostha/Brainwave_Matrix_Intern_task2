package controller;
import java.io.*;
import java.sql.Timestamp;
import dao.AppointmentDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Appointment;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet {
    private AppointmentDAO dao = new AppointmentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            Appointment a = new Appointment();
            a.setPatientId(Integer.parseInt(req.getParameter("patientId")));
            a.setStaffId(Integer.parseInt(req.getParameter("staffId")));

            String dateTimeStr = req.getParameter("dateTime");
            if (dateTimeStr != null && !dateTimeStr.isEmpty()) {
                if (dateTimeStr.contains("T")) {
                    dateTimeStr = dateTimeStr.replace("T", " ") + ":00";
                }
                Timestamp appointmentDate = Timestamp.valueOf(dateTimeStr);

                Timestamp now = new Timestamp(System.currentTimeMillis());
                if (appointmentDate.before(now)) {
                    req.setAttribute("errorMessage", " You cannot select a past date and time!");
                    RequestDispatcher rd = req.getRequestDispatcher("/jsp/appointmentForm.jsp");
                    rd.forward(req, res);
                    return;
                }
                a.setDateTime(appointmentDate);
            }

            a.setStatus(req.getParameter("status"));

            dao.addAppointment(a);
            res.sendRedirect(req.getContextPath() + "/appointment");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Invalid date format. Please use yyyy-MM-dd HH:mm.");
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/appointmentForm.jsp");
            rd.forward(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("appointments", dao.getAllAppointments());
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/appointmentList.jsp");
        rd.forward(req, res);
    }
}
