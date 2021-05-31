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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
@WebServlet(name = "ControlerBuy", urlPatterns = {"/buy"})
public class ControlerBuy extends HttpServlet {

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

        session.removeAttribute("result");
        
        if (session.getAttribute("acc") == null) {
            response.sendRedirect("login");
        } else {
            
            //create instance object of the SendEmail Class
            SendEmail sm = new SendEmail();
            //get the 6-digit code
            String code = sm.getRandom();
//                System.out.println(mail + phone);
            //craete new user using all information
            User user1 = (User) session.getAttribute("acc");
            user1.setCode(code);
            user1.setAddress(request.getParameter("address"));
            user1.setMail(request.getParameter("mail"));
//            session.setAttribute("n", request.getParameter("name"));
//            session.setAttribute("p", request.getParameter("phone"));
//            session.setAttribute("a", request.getParameter("address"));
//            session.setAttribute("m", request.getParameter("mail"));
            //call the send email method
            boolean test = sm.sendEmail(user1);

            //check if the email send successfully
            if (test) {
                request.setAttribute("u", user1);
                session.setAttribute("authcode", user1);
                request.setAttribute("suc", "We already send a code to your email.");
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
            } else {
                request.setAttribute("u", user1);
//                session.setAttribute("authcode", user1);
                request.setAttribute("fail", "Failed to send a code to your email");
                request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
