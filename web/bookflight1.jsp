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
                  
         System.out.println(session.getAttribute("flightid").toString());
              Connection  Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagent", "root", "1234");
              String price="";
          String flightid =session.getAttribute("flightid").toString();
            Statement stmt =Con.createStatement();
              ResultSet rs= stmt.executeQuery("select * from flight where id = "+flightid);
              while(rs.next()){
              price = rs.getString("price");
              }
              
              
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
           <form action="bookflight" method="get">
                <div class="container">
                <div class="col-md-offset-2 col-md-5">
               
                    <div class="form-group">
                        <label style="border-radius: 5px;background-color: black ;font-weight: bold;font-size: 20px;color: #FFFFFF" for="productname">class</label>
                        <select name="class">
                            <option value="1">1</option>
                            
                              <option value="2">2</option>
                                <option value="3">3</option>
                                  <option value="4">4</option>
                              
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label style="border-radius: 5px;background-color: black ;font-weight: bold;font-size: 20px;color: #FFFFFF" for="productname">price of flight is <%=price%></label>
                         <select name="approve">
                            <option value="accept">accept</option>
                            
                              <option value="ignore">ignore</option>
                              
                              
                        </select>
                    </div>
                         
                           <div class="form-group">
                               <input name="flightid" type="hidden" value="<%=flightid%>">
                    </div>
                         
                         
                    <button type="submit"  id="login-button" name="submit" >Book Flight</button>
                </div>
            </div>
            </form>  
            
            
    </body>
</html>
