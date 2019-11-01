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
               
              String id=request.getParameter("flightid");
            
               
    
       
             
         
              Connection  Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagent", "root", "1234");
          
             // getcon c=new getcon();
              String date="";
              String source="";
              String destination="";
              String classofflight="";
              String numofseats = "";
              String price="";
             // System.out.println("here");
            //  Connection con=c.myconnection();
              Statement stmt =Con.createStatement();
              ResultSet rs= stmt.executeQuery("select * from flight where id = '"+id+"'");
              while(rs.next()){
                  date=rs.getString("date");
                 source=rs.getString("source");
                 destination=rs.getString("destination");
                 classofflight=rs.getString("class");
                 numofseats=rs.getString("numofseats");
                 price=rs.getString("price");
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
        <div class="codrops-top">
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
		
                                    <a style="font-size: 20px" href="Add_Aircraft.html">Add AirCraft</a>
                                <a style="font-size: 20px" href="Update_Aircraft.jsp">Update AirCraft</a>
                                <a style="font-size: 20px" href="Add_Flight.html">Add flight</a>
                                <a style="font-size: 20px" href="Update_Flight.jsp">Update flight</a>
				</p>
                                
        </div>
            <br><br><br>
            <form  method="GET" action="Update_Flight.jsp" >
               
                <div class="col-md-offset-2 col-md-5">
                   
                    <input type="submit" class="btn btn-default" name="submit" value="back">
                </div>
            
            </form>
      
          
            <form   method="GET" action="update_flight" >
            <div class="container">
                <div class="col-md-offset-2 col-md-5">
                   		
                    	 <div class="form-group">
                        <label for="productserial">date</label>
                        <input type="date" required  class="form-control"  name="date" value="<%=date%>">
                    </div>
                    
                    	 <div class="form-group">
                        <label for="productserial">class</label>
                       
                        <select  name="classnum">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                    
                    
					 <div class="form-group">
                        <label for="productserial">source</label>
                        <input type="text" required  class="form-control"  name="source" value="<%=source%>">
                    </div>
			 <div class="form-group">
                        <label for="productserial">destination</label>
                        <input type="text" required  class="form-control"  name="destination" value="<%=destination%>">
                    </div>	
                     <div class="form-group">
                        <label for="productserial">no.of seats</label>
                        <input type="text" required  class="form-control"  name="numofseats" value="<%=numofseats%>">
                    </div>
                      <div class="form-group">
                        <label for="productserial">price</label>
                        <input type="text" required  class="form-control"  name="price" value="<%=price%>">
                    </div>
                    <div class="form-group">
                        
                        <input type="hidden"   class="form-control"  name="flightid" value="<%=id%>">
                    </div>
					               
                     <button type="submit" style="background-color: #333" class="btn btn-default" name="submit" >Update</button>
                    
                </div>
            </div>
        </form> 
    </body>
</html>
