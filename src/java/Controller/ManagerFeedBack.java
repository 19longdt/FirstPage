/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.FeedBack;
import Entity.OrderDetail;
import Model.DAO;
import Model.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "ManagerFeedBack", urlPatterns = {"/ManagerFeedBack"})
public class ManagerFeedBack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        List<FeedBack> listfb = dao.getFeedBackByStatus();
        
        if (action == null) {
            request.setAttribute("listfb", listfb);
            request.getRequestDispatcher("ControllerProduct").forward(request, response);
        }

        if (action.equals("edit")) {
            if (dao.getStatusFeedBack(Integer.parseInt(id)) == 1) {
                dao.updateStatusFeedBack(0, Integer.parseInt(id));
            } else {
                dao.updateStatusFeedBack(1, Integer.parseInt(id));
            }
            response.sendRedirect("ManagerFeedBack");
        }
        if (action.equals("delete")) {
            dao.deleteOrder(id);
            request.setAttribute("listfb", listfb);
            request.getRequestDispatcher("ControllerProduct").forward(request, response);
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
