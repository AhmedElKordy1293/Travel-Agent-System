

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
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
@WebServlet(urlPatterns = {"/signup"})
public class signup extends HttpServlet {
   

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
         
            response.setContentType("text/html;charset=UTF-8");
            
            try (PrintWriter out = response.getWriter()) {
                
                Class.forName("com.mysql.jdbc.Driver");
             
             
                getcon c = new getcon();
                Connection Con = c.myconnection();
                String username = request.getParameter("username");
                String password = request.getParameter("pass");
                String email = request.getParameter("email");
                String gender = request.getParameter("gender");
                String birthday = request.getParameter("bday");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String salary = request.getParameter("salary");
                String admintype = "admin";
                String usertype = "user";
                Statement stmt = Con.createStatement();
                if(salary.isEmpty()){
                    
                    int ar  =     stmt.executeUpdate("INSERT INTO users (username,email,address,gender,birthdate,type,password) " + "VALUES ('"+username+"', '"+email+"', '"+address+"', '"+gender+"', '"+birthday+"', '"+usertype+"', '"+password+"')");
                    if(ar == 1){
                        HttpSession session = request.getSession(true);
                        // session.setMaxInactiveInterval(10); ems7ly el session b3d 10 sawany
                        if(session.isNew() == false){
                            session.invalidate();
                            session = request.getSession(true);
                            session.setMaxInactiveInterval(10);
                        }
                        session.setAttribute("email", email);
                        session.setAttribute("password", password);
                        session.setAttribute("username", username);
                        session.setAttribute("type", usertype);
                        
                        String res="Your account has been created";
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Message</title>");
                        out.println("</head>");
                        
                        out.print(res + "\n" +
                                "<form action=\"userprofile.jsp\" method=\"POST\">\n" +
                                "<input type=\"submit\" value=\"back\">\n" + "\n" +
                                "</form>");
                        out.println("</html>");
                        
                    }
                }
                else{
                    int ar =  stmt.executeUpdate("INSERT INTO users (username,email,address,gender,salary,birthdate,type,password) " + "VALUES ('"+username+"', '"+email+"', '"+address+"', '"+gender+"', '"+salary+"', '"+birthday+"', '"+admintype+"', '"+password+"')");
                    if(ar == 1){
                        HttpSession session = request.getSession(true);
                        // session.setMaxInactiveInterval(10); ems7ly el session b3d 10 sawany
                        if(session.isNew() == false){
                            session.invalidate();
                            session = request.getSession(true);
                            session.setMaxInactiveInterval(10);
                        }
                        session.setAttribute("email", email);
                        session.setAttribute("password", password);
                        session.setAttribute("username", username);
                        session.setAttribute("type", admintype);
                        String res="Account has been created";
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Message</title>");
                        out.println("</head>");
                        
                        out.print(res + "\n" +
                                "<form action=\"profile.jsp\" method=\"POST\">\n" +
                                "<input type=\"submit\" value=\"Back\">\n" + "\n" +
                                "</form>");
                        out.println("</html>");
                    }
                }
             
                     
                } catch (SQLException ex) {
                          Logger.getLogger(getcon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
//            if(x.equals("usersubmit")){
//                
//                 out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet signup</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Welcome user " + a + "</h1>");
//            out.println("</body>");
//           out.println("</html>");
//
//            
//            }
//            else {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet signup</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Welcome admin " + a + "</h1>");
//            out.println("</body>");
//           out.println("</html>");
//            }
//
//            
           
            
            
            
            
            
            
            
           
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
        }
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