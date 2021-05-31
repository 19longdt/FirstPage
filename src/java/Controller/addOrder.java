/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Order;
import Entity.OrderDetail;
import Entity.User;
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
@WebServlet(name = "addOrder", urlPatterns = {"/addOrder"})
public class addOrder extends HttpServlet {

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
        User user = (User) session.getAttribute("authcode");

        String code = request.getParameter("authcode");
        System.out.println("test code " + code);
        User u = (User) session.getAttribute("authcode");
        String ver = "";
        if (code.equals(user.getCode())) {
            DBConnection dbconn = new DBConnection();
            DAO dao = new DAO(dbconn);

            /// ADD Order
//            String name = (String) session.getAttribute("n");
//            String address = (String) session.getAttribute("a");
//            String phone = (String) session.getAttribute("p");
//            String mail = (String) session.getAttribute("m");
            double totalall = Double.parseDouble(session.getAttribute("allTotal").toString());
            int id = dao.getAllOrder1().get(dao.getAllOrder1().size() - 1).getOrderid() + 1;
            dao.addOrder(new Order(id, totalall));

            List<Entity.Product> listp = (List<Entity.Product>) session.getAttribute("list");
            for (int i = 0; i < listp.size(); i++) {
                dao.addOrderDetail(new OrderDetail(id,
                        listp.get(i).getPname(), listp.get(i).getPrice(),
                        listp.get(i).getAmount(), listp.get(i).getAmount() * listp.get(i).getPrice(),
                        listp.get(i).getPid(), 0, java.time.LocalDate.now().toString(),
                        u.getAccount(), u.getAddress(), u.getPhone()));
            }
            response.sendRedirect("thanks.jsp");
            /////////////
        } else {
            ver = "Incorrect verification code, Try again!!\n"
                    + "                                        <form action=\"addOrder\" method=\"post\">\n"
                    + "                                        <input type=\"text\" name=\"authcode\" placeholder=\"Enter Code\">\n"
                    + "                                        <!--<a href=\"#\" onclick=\"check()\" class=\"btn btn-dark\">Submit</a>-->\n"
                    + "                                        <input type=\"submit\" value=\"Submit\" />\n"
                    + "                                        </form>";
            request.setAttribute("ver", ver);

            request.setAttribute("u", u);
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
