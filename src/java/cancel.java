/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author win7
 */
@WebServlet(urlPatterns = {"/cancel"})
public class cancel extends HttpServlet {

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
              
                    getcon c=new getcon();
            Connection con = c.myconnection();
            SendEmail m = new SendEmail();
            
            
            String userid=request.getSession().getAttribute("id").toString();
            
             String flightid=request.getParameter("flightid");
             System.out.print(flightid);
             String email=request.getSession().getAttribute("email").toString();
            String oldnumofseats="";
           int  newnumofseats;
            String bookedflight=userid.concat(flightid);
             boolean flag = false;
             String msg="Your Request has been approved and the flight is Canceled";
                           Statement stmt=con.createStatement();
                           
                           ResultSet rs1   =  stmt.executeQuery("select * from bookedflights");
                           
              while(rs1.next()){
              if(bookedflight.equals(rs1.getString("id"))){
              flag = true;
              break;
              }
              }
              
              if(flag == true){
              //habd2 a3mel cancel
              //ha3mel 7agten ams7 el booked flight where id = bookedflight w tany 7aga hazwed wa7ed 3al numofseats
                Statement stmt1 = con.createStatement();
                 m.send( email, msg);
                stmt1.executeUpdate("delete from bookedflights where id = "+bookedflight);
               
                //zaawed wa7ed 3al numofseats
                Statement stmt2=con.createStatement();
                
            ResultSet rs3   =    stmt2.executeQuery("select * from flight where id = "+flightid);
            
                while(rs3.next()){
                    oldnumofseats =   rs3.getString("numofseats");
                }
               
                
              newnumofseats  = Integer.parseInt(oldnumofseats) + 1;
             
              //update b2a w ehda
              
              Statement stmt4=con.createStatement();
              System.out.print("yewzaaaaaaaaaa33333");
              stmt4.executeUpdate("update flight set numofseats='"+newnumofseats+"' where id='"+flightid+"'");
              System.out.print("kora goaaaaaaaaaaaaal");
              response.sendRedirect("userprofile.jsp");
              }
              else{
              response.sendRedirect("userprofile.jsp");
              
              }
              
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(bookflight.class.getName()).log(Level.SEVERE, null, ex);
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
