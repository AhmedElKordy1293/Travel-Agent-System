/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.google.common.base.Strings;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
                                         getcon c = new getcon();
               // Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagent", "root", "1234");
            Connection Con = c.myconnection();
                boolean flag=false;
             String email = request.getParameter("mail");
            String password = request.getParameter("pass");
            String nameofuser = "";
                        String type="";
                            Statement stmt = Con.createStatement();
                             ResultSet RS =stmt.executeQuery("select * from users" );
                             
                             while(RS.next()){
                   
                   
                             if(RS.getString("email").equals(email)   &&  RS.getString("password").equals(password) ){
                                 //response.sendRedirect("courses.jsp");
                                 HttpSession session = request.getSession(true);
                                // session.setMaxInactiveInterval(10); ems7ly el session b3d 10 sawany
                                 if(session.isNew() == false){
                                 session.invalidate();
                                 session = request.getSession(true);
                               
                                 }
                                 String salary = RS.getString("salary");
                               
                                   String bd = RS.getString("birthdate");
                                    String gender = RS.getString("gender");
                                      type = RS.getString("type");
                                      String id = RS.getString("id");
                                     String address = RS.getString("address");
                                 session.setAttribute("email", email);
                                 session.setAttribute("password", password);
                                 session.setAttribute("salary", salary);
                                 session.setAttribute("address", address);
                                 session.setAttribute("birthdate",bd );
                                 session.setAttribute("gender",gender );
                                 session.setAttribute("type",type );
                                 session.setAttribute("id",id );
                                 Statement Stmt4 = Con.createStatement();
            
            ResultSet RS4 =Stmt4.executeQuery("select username from travelagent.users where email = '"+ email +"'");
            while(RS4.next()){
                 nameofuser = RS4.getString("username");
                 session.setAttribute("username", nameofuser);
                                
            }
                                
                                 flag=true;
                                  break; 
//                                 //response.sendRedirect("courses.jsp?name="+ssn);
//                                
                              
//                              
                        }  
                         }
                         
                        
                      if(flag==false){
                         //out.println("<");
                         
                         out.println ("<script type='text/javascript'>");
          
             out.println ("alert(' Wrong Email or Password');");
           
           
              
             out.println ("</script>");
             
              response.sendRedirect("index.html");
                        
                          
                           
                      }  
                      else{
                         if(type.equals("admin")){
                                                   RequestDispatcher requestDispatcher;
                          requestDispatcher = request.getRequestDispatcher("/profile.jsp");
                          requestDispatcher.forward(request, response);
                         }
                         else{
                             //response.sendRedirect("userprofile.jsp");
                          RequestDispatcher requestDispatcher;
                          requestDispatcher = request.getRequestDispatcher("userprofile.jsp");
                          requestDispatcher.forward(request, response);
                         }

                       //out.println("<center><h1> <span style='color:blue'> Welcome </span>  "+ nameofuser +"</h1></center>");  
                      }
                 
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
