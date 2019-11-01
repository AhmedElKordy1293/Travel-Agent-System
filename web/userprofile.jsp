
<%--
  Document   : profile
    Created on : Dec 25, 2015, 1:53:29 PM
    Author     : win7
    <% 
        String username = request.getSession().getAttribute("username").toString();
       String password = request.getSession().getAttribute("password").toString();
       String email = request.getSession().getAttribute("email").toString();
        String gender = request.getSession().getAttribute("gender").toString();
        String bd = request.getSession().getAttribute("birthdate").toString();
         String salary = request.getSession().getAttribute("salary").toString();
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String s; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>welcome <%= request.getSession().getAttribute("username").toString() %></title>
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
                <script>
                     $(document).ready(function() {
    $("form#msform").removeClass("hidden");
    
});
                  
                  function edite(){
                      
                   $("#msform").show();  
                   
                  }
                  
                  function exitform(){
        $("#msform").hide();
        }

                </script>
    </head>
    <body id="body">
        
     
        
        
          <ul class="cb-slideshow">
            <li><span>Image 01</span><div></div></li>
            <li><span>Image 02</span><div></div></li>
            <li><span>Image 03</span><div></div></li>
            <li><span>Image 04</span><div></div></li>
            <li><span>Image 05</span><div></div></li>
            <li><span>Image 06</span><div></div></li>
        </ul>
        <div class="codrops-top">
            <!-- Codrops top bar -->
           
                <a href="../index.html">
                    <strong>&laquo; Back to customer site: </strong>
                </a>
                <span class="right">
                    
                    <strong>Welcome</strong>
                    <a href="#">
                        <strong style="color: #269abc;font-size: 15px"> <%= request.getSession().getAttribute("username").toString() %> </strong>
                    </a>
                    <strong> | </strong>
                    <a href="#">
                        <strong >logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
             
           <!--/ Codrops top bar -->
           
                <img style="float:left ;display:inline-block;height:100px;width:280px" src="images/12355894_971761582870861_504423863_o.png" />
                <center><div style="height: 80px"></div> </center>
               
                    <p style="padding-left: 30px" class="codrops-demos">
                    
		
                                    <a style="font-size: 20px" href="showflights.jsp">Show flights</a>
                                <a style="font-size: 20px" href="bookflight.jsp">Book flight</a>
                                <a style="font-size: 20px" href="cancelflight.jsp">Cancel flight</a>
                                <a style="font-size: 20px" href="changeclass.jsp">Change Class</a>
				</p>
                            
                                
                                
                                
                                
                                
                                
                                
                                
                                <form  id="msform" class="hidden"  method="GET" action="updateinfo">
                                 
    
	<fieldset>
        <a onclick="exitform()" style="cursor:pointer;border-style:solid;color:blue;float:right">X</a>
	<h2 id="usertext" ></h2>	
        <h3 class="fs-title">Create your account</h3>
        <hr> 
        <br>
        <h3 class="fs-title">Username</h3>
        <input value="<%= request.getSession().getAttribute("username").toString() %>" type="text" name="username"  required />
        <h3 class="fs-title">Password</h3>
        <input value="<%= request.getSession().getAttribute("password").toString() %>" type="password" name="pass" required  />

                <input type="button" name="next" onclick="if (form.username.value == '') alert('username and password are required! registration process will not be completed correctly!');" class="next action-button" value="Next" />
	</fieldset>
	
	<fieldset>
        <a onclick="exitform()" style="cursor:pointer;border-style:solid;color:blue;float:right">X</a>
		<h2 class="fs-title">Personal Details</h2>
                <hr>
                
	<select  name="gender">
                       
							<option value="male" >Male</option>
							<option value="female" >Female</option>
							
                        </select><br><br>
                        <input value="<%= request.getSession().getAttribute("birthdate").toString() %>" type="date" name="bday" />
                
        <textarea  name="address"  ><%= request.getSession().getAttribute("address").toString() %></textarea>
         
		<input style="display:inline;float:left" type="button" name="previous"  class="previous action-button" value="Previous" />
		<!--<input type="submit" style="display:inline;float:right" id="submittype" name="sub" class="submit action-button" value="submit" />-->
	     <input type="submit" class="action-button" style="display:inline;float:right" id="submittype" name="sub" value="submit" />
        </fieldset>
</form>
                                
                                
                                
                                
                  
                                
             </div>                   
                                
                                <script src="js/index.js"></script>

     <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://thecodeplayer.com/uploads/js/jquery.easing.min.js'></script>

        <script src="js/index1.js"></script>
    </body>
</html>
