/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
@WebServlet(name = "managerInforUser", urlPatterns = {"/managerInforUser"})
public class managerInforUser extends HttpServlet {

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

        String user = request.getParameter("user");
        String action = request.getParameter("action");
        if (action == null) {

            User u = dao.checkUser(user);
            request.setAttribute("u", u);
            request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
        }
        if (action.equals("update")) {
            String acc = request.getParameter("acc");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");

            String a = null;

            if (!pass.equals(repass)) {

                HttpSession session = request.getSession();
                User u1 = (User) session.getAttribute("acc");
                String uu = u1.toString();
                String[] s = uu.split(" ");

                User k = dao.checkUser(s[0]);

                request.setAttribute("a", "Password must be match with repassword");
                request.setAttribute("u", k);
                request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
            }

            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String add = request.getParameter("add");
            String ans = request.getParameter("ans");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            HttpSession session = request.getSession();
            User u1 = (User) session.getAttribute("acc");
            String uu = u1.toString();
            String[] s = uu.split(" ");

            
            dao.updateUser(new User(acc, pass, name,
                    dob, Integer.parseInt(gender), add,
                    "What is your dream job?", ans, Integer.parseInt(phone), mail));
            User k = dao.checkUser(s[0]);
            request.setAttribute("a", "Update Your Information Successfull!!");
            request.setAttribute("u", k);
            request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);

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
