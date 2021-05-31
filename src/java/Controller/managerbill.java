/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Order;
import Entity.OrderDetail;
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
@WebServlet(name = "managerbill", urlPatterns = {"/managerbill"})
public class managerbill extends HttpServlet {

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

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        DBConnection dbcom = new DBConnection();
        DAO dao = new DAO(dbcom);
        List<OrderDetail> listod = dao.getAllOrderDetail();
        if (action == null) {
            List<OrderDetail> listo = dao.getOrderDetailbyID(Integer.parseInt(id));
//            System.out.println(listo);
            int total = 0;
            List<OrderDetail> list = dao.getOrderDetailbyID(Integer.parseInt(id));
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i).getIntomoney();
            }
//            System.out.println(listo.get(0).getAddress());
            request.setAttribute("total", total);
            request.setAttribute("listod", listo);
            request.getRequestDispatcher("ManagerAllOrder.jsp").forward(request, response);
        }

//        if (action.equals("edit")) {
//            String pname = request.getParameter("pname");
//            if (dao.getStatusOrder(Integer.parseInt(id), pname) == 1) {
//                dao.updateStatusOrder(0, Integer.parseInt(id), pname);
//            } else {
//                dao.updateStatusOrder(1, Integer.parseInt(id), pname);
//            }
//            response.sendRedirect("managerbill");
//        }
        if (action.equals("delete")) {
            dao.deleteOrder(id);
            request.setAttribute("listod", listod);
            request.getRequestDispatcher("ManagerAllOrder.jsp").forward(request, response);
        }
        
        
        
        if (action.equals("back")) {
            response.sendRedirect("ControllerProduct");
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
