package controller;

import java.io.*;
import java.util.List;

import dao.EHRDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.EHR;

@WebServlet("/ehr")
public class EHRServlet extends HttpServlet {
    private EHRDAO dao = new EHRDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            EHR ehr = new EHR(
                Integer.parseInt(req.getParameter("patientId")),
                req.getParameter("diagnosis"),
                req.getParameter("treatment"),
                req.getParameter("doctorName"),
                new java.util.Date(), 
                req.getParameter("notes")
            );

            dao.addEHR(ehr);
            res.sendRedirect(req.getContextPath() + "/ehr");

        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding EHR record");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String deleteId = req.getParameter("deleteId");

   
        if (deleteId != null) {
            dao.deleteEHR(Integer.parseInt(deleteId));
            res.sendRedirect(req.getContextPath() + "/ehr");
            return;
        }

    
        String patientIdParam = req.getParameter("patientId");
        List<EHR> ehrList;

        if (patientIdParam != null && !patientIdParam.isEmpty()) {
            ehrList = dao.getEHRByPatientId(Integer.parseInt(patientIdParam));
        } else {
            ehrList = dao.getAllEHR();
        }

        req.setAttribute("ehrList", ehrList);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/ehrList.jsp");
        rd.forward(req, res);
    }

}
