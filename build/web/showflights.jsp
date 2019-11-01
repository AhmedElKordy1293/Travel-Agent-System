<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Fullscreen Background Image Slideshow with CSS3 - A Css-only fullscreen background image slideshow" />
        <meta name="keywords" content="css3, css-only, fullscreen, background, slideshow, images, content" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css1/demo.css" />
         <link rel="stylesheet" type="text/css" href="css1/style1.css" />
        <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="css/style1.css">
       <link rel="stylesheet" href="css/reset.css">
       
		<script type="text/javascript" src="js1/modernizr.custom.86080.js"></script>
               
    </head>
    <body>
       
              <%
               
           
           
               
    
       
             
         
              Connection  Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagent", "root", "1234");
          
             // getcon c=new getcon();
//              String date="";
//              String source="";
//              String destination="";
//              String numofseat="";
             // System.out.println("here");
            //  Connection con=c.myconnection();
              Statement stmt =Con.createStatement();
              ResultSet rs= stmt.executeQuery("select * from flight");
              %>
          
       
        
        
          <ul class="cb-slideshow">
            <li><span>Image 01</span><div></div></li>
            <li><span>Image 02</span><div></div></li>
            <li><span>Image 03</span><div></div></li>
            <li><span>Image 04</span><div></div></li>
            <li><span>Image 05</span><div></div></li>
            <li><span>Image 06</span><div></div></li>
        </ul>
        
      
            <!-- Codrops top bar -->
            <div  class="codrops-top">
            <!-- Codrops top bar -->
           
                <a href="../index.html">
                    <strong>&laquo; Back to customer site: </strong>
                </a>
                <span class="right">
                    
                    
                    <strong> | </strong>
                    <a href="logout">
                        <strong >logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
             
           <!--/ Codrops top bar -->
            <header>
                <img style="float:left ;display:inline-block;height:100px;width:280px" src="images/12355894_971761582870861_504423863_o.png" />
                <center><div style="height: 80px"></div> </center>
               
                    <p style="padding-left: 30px" class="codrops-demos">
                        <a style="font-size: 20px" href="profile.jsp" >Edit profile</a>
		
                                  <a style="font-size: 20px" href="showflights.jsp">Show flights</a>
                                <a style="font-size: 20px" href="bookflight.jsp">Book flight</a>
                                <a style="font-size: 20px" href="cancelflight">Cancel flight</a>
                                <a style="font-size: 20px" href="changeclass.jsp">Change Class</a>
                              
				</p>
                                
        </div>
            <br><br><br>
            
    <center>  <div style="display: inline-block;width: 380px" class="codrops-top">
                 <table border="1" cellspacing="1" cellpadding="2">
                <thead>
                    <tr>
                        <th>ID   </th>
                        <th>date   </th>
                        <th>source   </th>
                        <th>destination   </th>
                        <th>available seats   </th>
                        <th>price   </th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                     <%
                  while(rs.next()){
                      out.println("<tr>");
                      
                      out.println("<td>");
                  out.println(rs.getString("id"));
                   out.print("     ");
                  out.println("</td>");
                  
                  out.println("<td>");
                  out.println(rs.getString("date"));
                  out.print("     ");
                  out.println("</td>");
                  
                  out.println("<td>");
                  out.println(rs.getString("source"));
                  out.print("     ");
                  out.println("</td>");
                  
                  out.println("<td>");
                  out.println(rs.getString("destination"));
                  out.print("     ");
                  out.println("</td>");
                  
                  out.println("<td>");
                  out.println(rs.getString("numofseats"));
                  out.print("     ");
                  out.println("</td>");
                  
                  out.println("<td>");
                  out.println(rs.getString("price"));
                  out.print("     ");
                  out.println("</td>");
                  
                  out.println("</tr>");
                 
              }
                   %>
                </tbody>
            </table>

                
            </div>
    </center>
               
       </body>
</html>
