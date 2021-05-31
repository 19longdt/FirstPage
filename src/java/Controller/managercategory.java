/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Category;
import Model.DAO;
import Model.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "managercategory", urlPatterns = {"/managercategory"})
public class managercategory extends HttpServlet {

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
        String action = request.getParameter("action");
//        System.out.println(action);
        if (action == null) {
            java.util.List<Entity.Category> list = dao.getCategory();
            int cidlast = dao.getCategory().get(dao.getCategory().size() - 1).getCid();
            request.setAttribute("list", list);
            request.setAttribute("cidlast", cidlast);

            request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
        } else if (action.equals("add")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            dao.addCategory(new Category(Integer.parseInt(id), name));
            java.util.List<Entity.Category> list = dao.getCategory();
            request.setAttribute("list", list);
            request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
        } else if (action.equals("preupdate")) {
//            System.out.println("upppppp");
            java.util.List<Entity.Category> list = dao.getCategory();
            int cidlast = dao.getCategory().get(dao.getCategory().size() - 1).getCid();
            request.setAttribute("list", list);
            request.setAttribute("cidlast", cidlast);

            String cid = request.getParameter("cid");
            String cname = request.getParameter("cname");
            request.setAttribute("cid", cid);
            request.setAttribute("cname", cname);
            request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
        } else if (action.equals("update")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            dao.updateCategory(new Category(Integer.parseInt(id), name));
            java.util.List<Entity.Category> list = dao.getCategory();
            int cidlast = dao.getCategory().get(dao.getCategory().size() - 1).getCid();
            request.setAttribute("list", list);
            request.setAttribute("cidlast", cidlast);
            request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);

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
