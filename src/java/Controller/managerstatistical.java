/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
@WebServlet(name = "managerstatistical", urlPatterns = {"/managerstatistical"})
public class managerstatistical extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            DBConnection dbconn = new DBConnection();
            DAO dao = new DAO(dbconn);
            
            List<String> listbest1 = dao.getMAXbyCid(1);
            List<String> listbest2 = dao.getMAXbyCid(2);
            List<String> listbest3 = dao.getMAXbyCid(3);
            List<String> listbest4 = dao.getMAXbyCid(4);
            
            String l1 = listbest1.get(1) + "(" + listbest1.get(2) +")";
            request.setAttribute("l1", l1);
            request.setAttribute("l2", listbest2.get(1) + "(" + listbest2.get(2) +")");
            request.setAttribute("l3", listbest3.get(1) + "(" + listbest3.get(2) +")");
            request.setAttribute("l4", listbest4.get(1) + "(" + listbest4.get(2) +")");
            
           request.setAttribute("a1", dao.hangtonkhoByCid(1)); 
           request.setAttribute("a2", dao.hangtonkhoByCid(2)); 
           request.setAttribute("a3", dao.hangtonkhoByCid(3)); 
           request.setAttribute("a4", dao.hangtonkhoByCid(4)); 
           
           request.setAttribute("b1", dao.hangdabanByLikeName("iphone"));
           request.setAttribute("b2", dao.hangdabanByLikeName("mac"));
           request.setAttribute("b3", dao.hangdabanByLikeName("watch"));
           request.setAttribute("b4", dao.hangdabanByLikeName("pod"));
           
           request.getRequestDispatcher("Statistical.jsp").forward(request, response);
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
