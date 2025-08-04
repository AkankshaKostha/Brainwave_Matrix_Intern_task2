package controller;
import java.io.*;
import dao.BillingDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Bill;

@WebServlet("/billing")
public class BillingServlet extends HttpServlet {
    private BillingDAO dao = new BillingDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Bill b = new Bill();
        b.setPatientId(Integer.parseInt(req.getParameter("patientId")));
        b.setAmount(Double.parseDouble(req.getParameter("amount")));
        b.setStatus(req.getParameter("status"));

        dao.addBill(b);
        res.sendRedirect(req.getContextPath() + "/billing");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("bills", dao.getAllBills());
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/billingList.jsp");
        rd.forward(req, res);
    }
}
