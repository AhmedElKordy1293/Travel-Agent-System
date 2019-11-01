/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.*;
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
@WebServlet(urlPatterns = {"/changeclass"})
public class changeclass extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                
                Class.forName("com.mysql.jdbc.Driver");
            
            
            
            
            
            getcon c=new getcon();
            Connection con = c.myconnection();
            
            SendEmail m = new SendEmail();
            
            String userid=request.getSession().getAttribute("id").toString();
            
            String flightid=request.getParameter("flightid");
            String newclass=request.getParameter("newclass");
            System.out.print(flightid);
            String email=request.getSession().getAttribute("email").toString();
            String oldclass="";
            boolean flag = false;
            String msg="Your Request has been approved and the Class has been changed";
            String bookedflight=userid.concat(flightid);
            Statement stmt = con.createStatement();
            ResultSet rs   =  stmt.executeQuery("select * from bookedflights");
            while(rs.next()){
                if(bookedflight.equals(rs.getString("id"))){
                flag = true;
                break;
                }
         
            }
            if(flag == true){
            
            Statement stmt2=con.createStatement();
            
              stmt2.executeUpdate("update bookedflights set flightclass='"+newclass+"' where id='"+bookedflight+"'");
              m.send( email, msg);
              
               String res="Updated";
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Message</title>");  
            out.println("</head>");
 
              out.print(res + "\n" +
                "<form action=\"userprofile.jsp\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Back\">\n" + "\n" +
                "</form>");
              out.println("</html>");
              
              
                  // RequestDispatcher requestDispatcher;
                    //requestDispatcher = getServletContext().getRequestDispatcher("/userprofile.jsp");
                   //requestDispatcher.forward(request, response);

             
    
            
            }
            else{
                 String res="Please Enter Flight ID";
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Message</title>");  
            out.println("</head>");
 
              out.print(res + "\n" +
                "<form action=\"changeclass.jsp\" method=\"POST\">\n" +
                "<input type=\"submit\" value=\"Back\">\n" + "\n" +
                "</form>");
              out.println("</html>");
              
              
                   // response.sendRedirect("changeclass.jsp"); 
                //RequestDispatcher requestDispatcher;
                  //        requestDispatcher = request.getRequestDispatcher("/changeclass.jsp");
                    //     requestDispatcher.forward(request, response);
                
            }
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(getcon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
                Logger.getLogger(changeclass.class.getName()).log(Level.SEVERE, null, ex);
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
