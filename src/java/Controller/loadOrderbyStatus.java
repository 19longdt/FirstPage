/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Order;
import Entity.OrderforAdmin;
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
@WebServlet(name = "loadOrderbyStatus", urlPatterns = {"/loadOrderbyStatus"})
public class loadOrderbyStatus extends HttpServlet {

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

            String op = request.getParameter("option");
            System.out.println(op);
            if (op.equals("2")) {
                DBConnection dbconn = new DBConnection();
                DAO dao = new DAO(dbconn);

                List<OrderforAdmin> listo = dao.getAllOrderbyStatus(2);
                double total = 0;
                for (int i = 0; i < listo.size(); i++) {
                    total += listo.get(i).getTotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("op", 2);
                request.setAttribute("listo", listo);
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }
            if (op.equals("0")) {
                DBConnection dbconn = new DBConnection();
                DAO dao = new DAO(dbconn);

                List<OrderforAdmin> listo = dao.getAllOrderbyStatus(0);
                double total = 0;
                for (int i = 0; i < listo.size(); i++) {
                    total += listo.get(i).getTotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("op", 0);
                request.setAttribute("listo", listo);
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }
            if (op.equals("1")) {
                DBConnection dbconn = new DBConnection();
                DAO dao = new DAO(dbconn);
                List<OrderforAdmin> listo = dao.getAllOrderforAdmin();
                double total = 0;
                for (int i = 0; i < listo.size(); i++) {
                    total += listo.get(i).getTotal();
                }
                request.setAttribute("total", total);
                request.setAttribute("op", 1);
                request.setAttribute("listo", listo);
                request.getRequestDispatcher("order.jsp").forward(request, response);
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
