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
@WebServlet(name = "loadProduct", urlPatterns = {"/loadProduct"})
public class loadProduct extends HttpServlet {

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

        // load to manage
        String id = request.getParameter("id");

//        String index = request.getParameter("index");
//
//        if (index != null) {
//            DBConnection db = new DBConnection();
//            DAO dao = new DAO(db);
//            int size = dao.countProduct();
//            int end = size / 6;
//            if (size % 6 != 0) {
//                end++;
//            }
//            List<Product> listpage = dao.pageProduct(1);
//            request.setAttribute("size", size);
//            request.setAttribute("end", end);
//            request.setAttribute("listpage", listpage);
//            request.getRequestDispatcher("Home.jsp").forward(request, response);
//        } else {

            DBConnection db = new DBConnection();
            DAO dao = new DAO(db);
            Product p = dao.getProductById(id);
            List<Category> listc = dao.getCategory();
            request.setAttribute("p", p);
            request.setAttribute("list", listc);
//        System.out.println(p.getDescription());
            request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
            ///
        

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
