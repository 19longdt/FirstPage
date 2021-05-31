/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Admin;
import Entity.User;
import Model.DAO;
import Model.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControllerRegister", urlPatterns = {"/register"})
public class ControllerRegister extends HttpServlet {

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

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String name = request.getParameter("name");
        String dob = request.getParameter("date");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");

        String[] s = dob.split("-");
        String r = s[2] + "-" + s[1] + "-" + s[0];

        String add = request.getParameter("address");
        String ans = request.getParameter("ans");

        String mess = "";

        if (!pass.equals(repass)) {
            request.setAttribute("messr", "RePassword not matching Password!");
            request.getRequestDispatcher("LoginRegister.jsp").forward(request, response);

        } else {
            DBConnection dbonn = new DBConnection();
            DAO dao = new DAO(dbonn);

            User u = dao.checkUser(user);
//            Admin a = dao.checkAdmin(user);

            if (u == null) {
//                System.out.println(mail);
                //create instance object of the SendEmail Class
                SendEmail sm = new SendEmail();
                //get the 6-digit code
                String code = sm.getRandom();
//                System.out.println(mail + phone);
                //craete new user using all information
                User user1 = new User(user, pass, name, r, gender, add,
                        "What is your dream job?", ans,
                        Integer.parseInt(phone), mail, code);

                //call the send email method
                boolean test = sm.sendEmail(user1);

                //check if the email send successfully
                if (test) {
                    session.setAttribute("authcode", user1);
                    request.setAttribute("suc", "We already send a verification  code to your email.");
                    request.getRequestDispatcher("LoginRegister.jsp").forward(request, response);
                } else {
                    request.setAttribute("messr", "Failed to send verification email");
                    request.getRequestDispatcher("LoginRegister.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("messr", "Exist User or RePassword not matching Password!");
                request.getRequestDispatcher("LoginRegister.jsp").forward(request, response);
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
