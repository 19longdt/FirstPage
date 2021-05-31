/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Category;
import Entity.FeedBack;
import Entity.OrderDetail;
import Entity.Product;
import Entity.newPro;
import Model.DAO;
import Model.DBConnection;
import java.io.IOException;
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
@WebServlet(name = "ControllerProduct", urlPatterns = {"/ControllerProduct"})
public class HOME extends HttpServlet {

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
        HttpSession session = request.getSession();
//        session.invalidate();
        /// Báo số lượng không đủ ///
        session.removeAttribute("result");
//        session.removeAttribute("k");
//        session.removeAttribute("allpid");

        /////////////////////////////// USER INTERFACE //////////////////////////////////
        int c;
        try {
            String value = session.getAttribute("count").toString();
            if (value == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            c = 0;
            session.setAttribute("count", c);
        }

        List<Product> list = dao.getProduct();
        List<Category> listc = dao.getCategory();
        Product last = dao.getLast();
        
        // PHÂN TRANG
        int size = dao.countProduct();
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
        
        // TOP SELLING
        List<Product> listpage = dao.pageProduct(index);
        List<newPro> listnew = dao.getTop4(1);
        List<newPro> listnew1 = dao.getTop4(2);
        List<newPro> listnew2 = dao.getTop4(3);
        List<newPro> listnew3 = dao.getTop4(4);

        /////////////////////////////// USER INTERFACE //////////////////////////////////
        
        // CHECK ORDER, FEEDBACK,  AMOUNT = 0 
        List<OrderDetail> listod = dao.getOrderDetailDescStaus();
        List<FeedBack> listfb = dao.getFeedBackByStatus();

//        System.out.println(list);
        String fb = "", od = "";
        if (listfb.isEmpty()) {
            fb += "You are checked all FeedBack";
            request.setAttribute("fb", fb);
        }
        if (listod.isEmpty()) {
            od += "You are checked all Bills";
            request.setAttribute("od", od);
        }
        
        String amount = "";
        int check = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getAmount() == 0) {
                amount += "Pid: " + list.get(j).getPid() + " " + " - Pname: " + list.get(j).getPname();
                check = 1;
            }
        }
        if (check == 1) {
            request.setAttribute("amount", "sold out " + amount);
        }
//        request.getRequestDispatcher("test.jsp").forward(request, response);
        ///
//        List<Integer> listAllPid = new ArrayList<>();
//        try {
//            String allPid = session.getAttribute("allpid").toString();
//        } catch (Exception e) {
//            session.setAttribute("allpid", listAllPid);
//        }
//        System.out.println("1test " + listAllPid);
        
        /////////////////////////
        request.setAttribute("listod", listod);
        request.setAttribute("listfb", listfb);
        request.setAttribute("listp", list);
        request.setAttribute("listc", listc);
        request.setAttribute("plast", last);
        request.setAttribute("size", size);
        request.setAttribute("end", end);
        request.setAttribute("listpage", listpage);
        request.setAttribute("listnew", listnew);
        request.setAttribute("listnew1", listnew1);
        request.setAttribute("listnew2", listnew2);
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
