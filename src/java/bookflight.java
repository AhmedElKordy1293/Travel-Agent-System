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
@WebServlet(urlPatterns = {"/bookflight"})
public class bookflight extends HttpServlet {

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
            String userid=request.getSession().getAttribute("id").toString();
            SendEmail m = new SendEmail();
            //System.out.print("ana hena");
             String flightid=request.getSession().getAttribute("flightid").toString();
             String email=request.getSession().getAttribute("email").toString();
            String oldnumofseats="";
            String bookedflight=userid.concat(flightid);
             String class1=request.getParameter("class");
              String approve=request.getParameter("approve");
                String msg="Your Request has been approved and the flight is Reserved";
              int newnumofseats;
            if(approve.equals("accept")){
                Statement stmt=con.createStatement();
                
                stmt.executeUpdate("INSERT INTO bookedflights (id,flightclass,acceptpayment,usermail) " + "VALUES ('"+bookedflight+"', '"+class1+"', '"+approve+"', '"+email+"')");
            
                //na22s el num of seats 
                Statement stmt1=con.createStatement();
            ResultSet rs1   =    stmt1.executeQuery("select * from flight where id = "+flightid);
                while(rs1.next()){
                    oldnumofseats =   rs1.getString("numofseats");
                }
               
                
              newnumofseats  = Integer.parseInt(oldnumofseats) - 1;
             
              //update b2a w ehda
              
              Statement stmt2=con.createStatement();
              stmt2.executeUpdate("update flight set numofseats='"+newnumofseats+"' where id='"+flightid+"'");
                m.send( email, msg);
                    response.sendRedirect("userprofile.jsp");
               
                    }
            else{
            // response.sendRedirect("userprofile.jsp");
                out.print("<jsp:forward page='userprofile.jsp'/>");
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
