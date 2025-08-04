package controller;
import java.io.*;
import dao.InventoryDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.InventoryItem;

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
    private InventoryDAO dao = new InventoryDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        InventoryItem item = new InventoryItem();
        item.setName(req.getParameter("name"));
        item.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        item.setPrice(Double.parseDouble(req.getParameter("price")));

        dao.addItem(item);
        res.sendRedirect(req.getContextPath() + "/inventory");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("items", dao.getAllItems());
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/inventoryList.jsp");
        rd.forward(req, res);
    }
}
