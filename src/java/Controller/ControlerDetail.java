/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Category;
import Entity.Product;
import Model.DAO;
import Model.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "detail", urlPatterns = {"/detail"})
public class ControlerDetail extends HttpServlet {

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
        String pid = request.getParameter("pid");
        
        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);
        Product p = dao.getProductById(pid);
        List<Category> listc = dao.getCategory();
        Product last = dao.getLast();
        
        request.setAttribute("listc", listc);
        request.setAttribute("plast", last);
        
        String d = p.getDescription();
        String [] a = d.split("-");
        List<String> listdes = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            listdes.add(a[i]);
        }
        request.setAttribute("detail", p);
        request.setAttribute("listdes", listdes);
        request.setAttribute("a0", a[0]);
        request.setAttribute("a1", a[1]);
        request.setAttribute("a2", a[2]);
        request.setAttribute("a3", a[3]);
        request.setAttribute("a4", a[4]);
        request.setAttribute("a5", a[5]);
        request.setAttribute("a6", a[6]);
        request.setAttribute("a7", a[7]);
        
        request.setAttribute("amount", p.getAmount());
        request.getRequestDispatcher("Detail.jsp").forward(request, response);
        
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
