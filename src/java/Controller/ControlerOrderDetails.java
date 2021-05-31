/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.OrderDetail;
import Entity.OrderforAdmin;
import Entity.Product;
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
@WebServlet(name = "ControlerOrderDetails", urlPatterns = {"/ControlerOrderDetails"})
public class ControlerOrderDetails extends HttpServlet {

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

        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);

        String id = request.getParameter("id");
        String action = request.getParameter("action");
        List<OrderforAdmin> listod = dao.getAllOrderforAdmin();

        if (action == null) {
            double total = 0;
            for (int i = 0; i < listod.size(); i++) {
                total += listod.get(i).getTotal();
            }
            request.setAttribute("total", total);

            request.setAttribute("listo", listod);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            if (dao.getStatusOrder(Integer.parseInt(id)) == 0) {
                dao.updateStatusOrderforAdmin(2, Integer.parseInt(id));
                /// Giảm số lượng trong kho, tăng tiền
                double money = 0;
                List<OrderforAdmin> listod1 = dao.getOrderByOid(Integer.parseInt(id));
                int pid, amountProduct, amountOrder;
                for (int i = 0; i < listod1.size(); i++) {
                    pid = listod1.get(i).getPid();
                    amountOrder = listod1.get(i).getAmount();
                    amountProduct = dao.getAmountByPid(pid);
                    money += listod1.get(i).getTotal();
                    dao.updateAmountProduct(pid, amountProduct - amountOrder);
                }
                double total = 0;
                for (int i = 0; i < listod.size(); i++) {
                    total += listod.get(i).getTotal();
                }
                total += money;
                response.sendRedirect("ControlerOrderDetails");
            }

        } else if (action.equals("edit1")) {
//            String pname = request.getParameter("pname");
            if (dao.getStatusOrder(Integer.parseInt(id)) == 0) {
                dao.updateStatusOrderforAdmin(1, Integer.parseInt(id));
                /// Giảm số lượng trong kho, tăng tiền
                double money = 0;
                List<OrderforAdmin> listod1 = dao.getOrderByOid(Integer.parseInt(id));
                int pid, amountProduct, amountOrder;
                for (int i = 0; i < listod1.size(); i++) {
                    pid = listod1.get(i).getPid();
                    amountOrder = listod1.get(i).getAmount();
                    amountProduct = dao.getAmountByPid(pid);
                    money += listod1.get(i).getTotal();
                    dao.updateAmountProduct(pid, amountProduct - amountOrder);
                }
                double total = 0;
                for (int i = 0; i < listod.size(); i++) {
                    total += listod.get(i).getTotal();
                }
                total += money;
                response.sendRedirect("ControlerOrderDetails");
            } else if (dao.getStatusOrder(Integer.parseInt(id)) == 2) {
                dao.updateStatusOrderforAdmin(1, Integer.parseInt(id));
                response.sendRedirect("ControlerOrderDetails");
            }

        } else if (action.equals("edit2")) {
            if (dao.getStatusOrder(Integer.parseInt(id)) == 2) {
                dao.updateStatusOrderforAdmin(0, Integer.parseInt(id));

                /// Tăng số lượng trong kho, giảm tiền
                double money = 0;
                List<OrderforAdmin> listod1 = dao.getOrderByOid(Integer.parseInt(id));
                int pid, amountProduct, amountOrder;
                for (int i = 0; i < listod1.size(); i++) {
                    pid = listod1.get(i).getPid();
                    amountOrder = listod1.get(i).getAmount();
                    amountProduct = dao.getAmountByPid(pid);
                    money += listod1.get(i).getTotal();
                    dao.updateAmountProduct(pid, amountProduct + amountOrder);
                }
                double total = 0;
                for (int i = 0; i < listod.size(); i++) {
                    total += listod.get(i).getTotal();
                }
                total -= money;
                response.sendRedirect("ControlerOrderDetails");
            }
        } else if (action.equals("delete")) {
            dao.deleteOrder(id);
            request.setAttribute("listod", listod);
            request.getRequestDispatcher("ControllerProduct").forward(request, response);
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
