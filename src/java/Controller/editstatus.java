/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(name = "editstatus", urlPatterns = {"/editstatus"})
public class editstatus extends HttpServlet {

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

        HttpSession session = request.getSession();
        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);
        String id = request.getParameter("id");
        String pname = request.getParameter("pname");
        int status = Integer.parseInt(request.getParameter("status"));
        int amount = Integer.parseInt(request.getParameter("a"));
        if (status == 0) {
            dao.updateStatusOrder(2, Integer.parseInt(id), pname);
            
//            dao.getAmountByPid(amount)
            dao.updateAmountProduct(dao.getProductByName(pname).get(0).getPid(),
                     dao.getProductByName(pname).get(0).getAmount() - amount);
        }
        String[] acc = session.getAttribute("acc").toString().split(" ");
        List<OrderDetail> od = dao.getOrderByAccount(acc[0]);
        request.setAttribute("myorder", od);
        request.getRequestDispatcher("ManagerMyOrder.jsp").forward(request, response);

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
