/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Items;
import Entity.Order;
import Entity.OrderDetail;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(name = "addtoCart", urlPatterns = {"/addtoCart"})
public class addtoCart extends HttpServlet {

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
        String quan = request.getParameter("quantity");

        DBConnection dbconn = new DBConnection();
        DAO dao = new DAO(dbconn);
        HttpSession session = request.getSession();
        double allTotal = 0;
        try {
            String value = session.getAttribute("tt").toString();
            if (value == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            session.setAttribute("tt", allTotal);
        }
//        session.removeAttribute("k");
        int c = Integer.parseInt(session.getAttribute("count").toString());
        Product pro = (Product) session.getAttribute(pid);

        String k = "";
        Product p = dao.getProductById(pid);
        if (pro == null) {

            pro = dao.getProductById(pid);
            if (quan == null) {
                pro.setAmount(1);
                c++;
//                allTotal += pro.getPrice();

            }
            if (quan != null) {
                pro.setAmount(Integer.parseInt(quan));
                c += Integer.parseInt(quan);
//                allTotal += pro.getPrice() * Integer.parseInt(quan);
//                session.setAttribute("tt", allTotal);
            }
            session.setAttribute(pid, pro);

//            System.out.println("Test " + pro.getAmount());
        } // pro != null
        else {

            if (pro.getAmount() <= p.getAmount() - 1) {

                // add to cart from home
                if (quan == null) {
                    pro.setAmount(pro.getAmount() + 1);
                    c++;
                }

                // add to cart from detail
                if (quan != null) {
                    pro.setAmount(Integer.parseInt(quan) + 1);
                    c += Integer.parseInt(quan);
                }

                session.setAttribute(pid, pro);
            } else {
                k += "1";
                session.setAttribute("k", k);
                session.setAttribute(pid, pro);
            }

            java.util.Enumeration em = session.getAttributeNames();
            while (em.hasMoreElements()) {
                String id = em.nextElement().toString(); //get key
                try {
                    allTotal += pro.getPrice() * pro.getAmount();
//                    session.setAttribute("tt", allTotal);
                } catch (ClassCastException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

//        List<Integer> listAllPid = (List<Integer>) session.getAttribute("allpid");
//        listAllPid.add(Integer.parseInt(pid));
//        session.setAttribute("allpid", listAllPid);
//        c++;
//        session.setAttribute("tt", allTotal);
        session.setAttribute("pname", pro.getPname());
        session.setAttribute("pid", pid);
        session.setAttribute("count", c);
        request.getRequestDispatcher("ControllerProduct").forward(request, response);
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
