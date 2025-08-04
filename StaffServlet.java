package controller;
import java.io.*;
import dao.StaffDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Staff;

@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    private StaffDAO dao = new StaffDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Staff s = new Staff();
        s.setName(req.getParameter("name"));
        s.setRole(req.getParameter("role"));
        s.setPhone(req.getParameter("phone"));

        dao.addStaff(s);
        res.sendRedirect(req.getContextPath() + "/staff");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("staffList", dao.getAllStaff());
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/staffList.jsp");
        rd.forward(req, res);
    }
}
