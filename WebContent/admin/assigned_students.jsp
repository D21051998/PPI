<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  <script>
  var tick=function(){
	  document.getElementById('m').style.color = 'green';
	  document.getElementById('m').innerHTML = '&#10004';
  }
  </script>
  <style type="text/css">
  span.a{
  margin-left:10%;
  color:green;
  font-weight:bold;
  font-sikariyeze:18px;
  }</style>
<title>Insert title here</title>
</head>
<body>
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PPI PORTAL</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
<!--       <li><a href="student_skills.jsp">Student skills</a></li>
      <li><a href="#">Student knowledge</a></li> -->
      
    </ul>
      
      <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><span class="glyphicon glyphicon-log-in"></span><%= session.getAttribute( "Name" )%></a></li>
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
    </ul>
    
  </div>
</nav>
      
      
         <!-- Sidebar -->
             
        <div id="sidebar_collapse" style="background-color: lightblue;margin-top: 100px"  class="col-sm-3 col-lg-2 sidebar collapse in">
            <div style="margin-left: 0px">
                <h3 class="text-left" style="color: #555D50;">Dashboard</h3>
            </div>

            <ul class="nav menu" style="margin-top: 10px">
            <li id="upload"><a href="admin_mainpage.jsp"><span class="glyphicon glyphicon-book"></span> File Upload</a></li>
                 <li id="student"><a href="view_data.jsp"><span class="glyphicon glyphicon-book"></span> View Student Data</a></li>
                <li id="transfer"><a href="transfer_data.jsp"><span class="glyphicon glyphicon-book"></span> Transfer Data</a></li>
              <li id="expert"><a href="view_expert_data.jsp"><span class="glyphicon glyphicon-book"></span>View Expert Data</a></li>
          <li id="expert"><a href="assign_stud.jsp"><span class="glyphicon glyphicon-book"></span>View Assigned Students</a></li>
      <li id="expert"><a href="analysis.jsp"><span class="glyphicon glyphicon-book"></span>Analysis of Students</a></li>
            </ul>
        </div>
        <!-- Sidebar ends --> 

 <div class="col-sm-2 col-lg-8">


            <table class="table">
                <thead>
                    <tr class="info">
                        <th> Expert Id</th>
                        <th> Student Id</th>
                        <th> PPI Complete </th>
                    </tr>
            </thead>
            <tbody>
                
<%
String s1="",s2="";
ResultSet rs=null;
PreparedStatement pr=null;
Connection con=null;
            try 
            {  
                 Class.forName("com.mysql.jdbc.Driver");
             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ppi","root","root");
            con.setAutoCommit(false);
           

                
                 pr=con.prepareStatement("select * from assign");
          
            
            rs=pr.executeQuery();
            
   %>       <%
            while(rs.next())
            {
               
             s1= rs.getString(1);
             s2= rs.getString(2);  
             
             
             
            
            %> 
             
             <tr class="success">
                
                    <td><%= s1%> </td> 
                    <td><%= s2%></td>
                    <% 
                    
                    ResultSet rs1=null;
PreparedStatement pr1=null;


            try 
            {       

                
                 pr1=con.prepareStatement("select stud_id from ppi_taken where stud_id=?");
                 pr1.setString(1,s2);
          
            
            rs1=pr1.executeQuery();
            if(rs1.next())
                    
            {
                   
                    %>
                    <td>   
                    </td>
  <%        }      
  else
 { 
%>
  <td> <span class="a"><%out.print("&#10004"); %></td>
 </tr>  
  <%
  }
            
          %> <%
            
          }
            catch(Exception e)
          {
              
        }
%>
    
              			
      <%      }	
            
            }  
            catch(Exception e)
            {
                System.out.println(e);
            }
    //con.close();
    
 %>    
                     
            </tbody>
            </table>
            </div>
</body>
</html>