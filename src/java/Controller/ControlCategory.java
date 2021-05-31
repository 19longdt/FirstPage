/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Category;
import Entity.Product;
import Entity.newPro;
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
@WebServlet(name = "ControlCategory", urlPatterns = {"/categoryy"})
public class ControlCategory extends HttpServlet {

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

        String id = request.getParameter("cid");

        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);
        List<Product> cate = dao.getProductByCid(id);
        List<Category> listc = dao.getCategory();
        Product last = dao.getLast();

        int size = dao.countProductByCid(Integer.parseInt(id));
        int end = size / 6;
        if (size % 6 != 0) {
            end++;
        }

        int index;
        String i = request.getParameter("i");
        if (i == null) {
            index = 1;
        } else {
            index = Integer.parseInt(i);
        }
        List<Product> listpage = dao.pageProductByCid(index, Integer.parseInt(id));

//        request.setAttribute("listp", list);
        request.setAttribute("listc", listc);
        request.setAttribute("plast", last);
        request.setAttribute("size", size);
        request.setAttribute("end", end);
        request.setAttribute("listpage", listpage);
        
        //tabs/////
        List<newPro> listnew = dao.getTop4(1);
        request.setAttribute("listnew", listnew);
        request.setAttribute("pn1", listnew.get(3).getPname().substring(0, 13));
        List<newPro> listnew1 = dao.getTop4(2);
        request.setAttribute("listnew1", listnew1);
        List<newPro> listnew2 = dao.getTop4(3);
        request.setAttribute("listnew2", listnew2);
        List<newPro> listnew3 = dao.getTop4(4);
        request.setAttribute("listnew3", listnew3);
        
        request.getRequestDispatcher("Home.jsp").forward(request, response);

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
