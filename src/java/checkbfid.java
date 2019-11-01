/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win7
 */
@WebServlet(urlPatterns = {"/checkbfid"})
public class checkbfid extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
                        try {
                /* TODO output your page here. You may use following sample code. */
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(getcon.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
     
            try {
               boolean flag=false;
                    getcon c=new getcon();
            Connection con = c.myconnection();
                System.out.println(request.getParameter("flightid"));
               
                String email = request.getSession().getAttribute("email").toString();
                System.out.println(email);
            String userid = request.getSession().getAttribute("id").toString();
                System.out.println(userid);
                System.out.println("hereeee5555555555");
            String flightid=request.getParameter("flightid");
            
                System.out.println(flightid);
            String bookedflight=userid.concat(flightid);
            
                Statement stmt=con.createStatement();
                System.out.println("hereeee");
                ResultSet rs= stmt.executeQuery("select * from bookedflights");
               
               System.out.println("hereeee1");
                while (rs.next()){
                 if(bookedflight.equals(rs.getString("id"))){
                     flag=true;
                    break;
                 }   
                }
                
                if(flag==true){
                    //l2 enta 7agzt abl kda
                    System.out.println("okkkkkkkkkkkkkk");
                    response.sendRedirect("bookflight.jsp");
                }
                else{
                    System.out.println("yaraaaaaab");
                    System.out.println(bookedflight);
                    out.println("hereeeeeeeee");
                   // response.sendRedirect("bookflight.jsp"); 
//                    HttpSession session = request.getSession(true);
//                                // session.setMaxInactiveInterval(10); ems7ly el session b3d 10 sawany
//                                 if(session.isNew() == false){
//                                 //session.invalidate();
//                                 session = request.getSession(true);
//                               
//                                 }
                               
                     request.getSession().setAttribute("flightid", flightid);
                     
                  response.sendRedirect("bookflight1.jsp");
                }
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(checkbfid.class.getName()).log(Level.SEVERE, null, ex);
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
