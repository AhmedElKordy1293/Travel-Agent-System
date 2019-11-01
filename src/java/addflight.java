/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win7
 */
@WebServlet(urlPatterns = {"/addflight"})
public class addflight extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
                    try {
                /* TODO output your page here. You may use following sample code. */
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(getcon.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
         
           
                
            try {
                
                String id = request.getParameter("flightid");
         String classnum = request.getParameter("classnum");
         String source = request.getParameter("source");
         String Destination = request.getParameter("Destination");
         String date = request.getParameter("date");
         String seats = request.getParameter("seats");
          String price = request.getParameter("price");
        
   
        
         getcon c =new getcon();
            Connection con = c.myconnection();
              
          
              Statement  stmt = con.createStatement();
               
                stmt.executeUpdate("INSERT INTO flight (id,date,source,destination,class,numofseats,price) " + "VALUES ('"+id+"', '"+date+"', '"+source+"', '"+Destination+"', '"+classnum+"', '"+seats+"', '"+price+"')");
               RequestDispatcher requestDispatcher;
                          requestDispatcher = request.getRequestDispatcher("/profile.jsp");
                          requestDispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(addflight.class.getName()).log(Level.SEVERE, null, ex);
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
