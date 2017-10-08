<%@ page import="java.sql.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page import="com.ppi.database.ConnectionFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico"/>
          <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

 <script src="js/bootstrap.min.js"></script>

<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
<style>
.nav-tabs > li.active > a:focus, .nav-tabs > li.active > a
{
    margin-top: 1px;
}
.nav-tabs > li {
    margin-bottom: 0px; 
}
.nav-tabs > li.active {
    margin-bottom: -1px;    
}</style>
     
    </head>
    <body background="images/e.jpg">
       <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PPI PORTAL</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="">Home</a></li>

      
    </ul>
      <ul class="nav navbar-nav navbar-right">
       <li><a href="#"><span class="glyphicon glyphicon-log-in"></span><%//= session.getAttribute("Name")%></a></li>   
      <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
    </ul>
    
  </div>
</nav>

<%

           //String id=session.getAttribute( "Name" ).toString();
           String id="gaurav";
    
                    
     %>  
     
     
     <jsp:useBean id="ExpertDao" class="com.ppi.impl.ExpertIMPL"></jsp:useBean>
<%
		request.setAttribute("expert1", ExpertDao.getStudents(id, 0));
        request.setAttribute("expert2", ExpertDao.getStudents(id, 1));
	%>
     
             
<div style="width: 100%;">
   <div style="float:left; width: 20%">
            <div id="sidebar_collapse" style="background-color: lightblue;margin-left: 0px"  class="col-sm-4 col-lg-12 sidebar collapse in">
            <div style="margin-left: 0px">
                <h3 class="text-left" style="color: #555D50;">PPI remaining students</h3>
            </div>

            <ul class="nav menu" style="margin-top: 0px">
             <c:forEach items="${expert1}" var="studs">
             <li><a href="expert.jsp?roll=${studs.roll}&name=${studs.name}">${studs.name}</a></li>
		</c:forEach>   
             
    </ul>
    <div style="margin-left: 0px">
                <h3 class="text-left" style="color: #555D50;">PPI Completed students</h3>
            </div>

            <ul class="nav menu" style="margin-top: 10px">
            <c:forEach items="${expert2}" var="studs">
             <li><a href="edit.jsp?roll=${studs.roll}">${studs.name} <span class="glyphicon glyphicon-edit"></span></a></li>
		</c:forEach> 

    </ul>
        </div>
   </div>
   <div style="float:right; width:80%">
   <div class="container">  
  
  <ul class="nav nav-tabs">  
    <li><a data-toggle="tab" href="#stud_knowledge">Student Knowledge</a></li>  
    <li><a data-toggle="tab" href="#stud_skills">Student Skills</a></li>  
    <li><a data-toggle="tab" href="#stud_remarks">Student Remarks</a></li>    
  </ul>  
  
  <form class="form-horizontal" role="form" action="../Stud_details" method="post">
 
  <div class="tab-content">  
    <div id="stud_knowledge" class="tab-pane fade in active">  
 <div class="container">
 
       <div class="row" >
       

                <div class="col-sm-4 col-sm-offset-0" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
                
                  
                     
                        
                        <div class="form-group">
                            <label for="name" class="control-label">Name</label>
                            <%if(request.getParameter("name")==null){%>
                            	<input type="text" class="form-control" readonly value=''  id="name" name="name" required placeholder="Enter Student Name">
                            	
                            <% }else{%>
                            <input type="text" class="form-control" readonly value='<%=request.getParameter("name")%>' id="name" name="name" required placeholder="Enter Student Name">
                        
                             <%} %>
                        </div>
                        
                        <div class="form-group">
                            <label for="rno" class="control-label">Roll No.</label>
                            <input type="text" class="form-control" readonly id="rno" value='<%= request.getParameter("roll")%>' name="rno" required placeholder="Enter Student Roll. No.">
                        </div>
                        
                         <div class="form-group">
                            <label for="data" class="control-label">Data Structures</label>
                            <input type="number" class="form-control" max="5" id="data" name="data" required placeholder="Eg. 3">
                        </div>
                        
                        <div class="form-group">
                            <label for="logic" class="control-label">Logic Building</label>
                            <input type="number" class="form-control" max="5" id="logic" name="logic" required placeholder="Eg. 5">
                        </div>
                       
                         <div class="form-group">
                            <label for="cao" class="control-label">Computer arch. and Organization</label>
                            <input type="number" class="form-control" max="5" id="cao" name="cao" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="dbms" class="control-label">DBMS</label>
                            <input type="number" class="form-control" max="5" id="dbms" name="dbms" required placeholder="Eg. 3">
                        </div>
                     
                        
                         <div class="form-group">
                            <label for="os" class="control-label">Operating Systems</label>
                            <input type="number" class="form-control" max="5" id="os" name="os" required placeholder="Eg. 5">
                        </div>
                       
                         <div class="form-group">
                            <label for="cn" class="control-label">Computer Networks</label>
                            <input type="number" class="form-control" max="5" id="cn" name="cn" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="app" class="control-label">Application development using C/C++/PHP/Java</label>
                            <input type="number" class="form-control" max="5" id="app" name="app" required placeholder="Eg. 3">
                        </div>
                           
                        
                        <div class="form-group">
                        
                       
                        <a class ="btn btn-primary btn-block" data-toggle="tab" type="submit" href="#stud_skills">Next -></a>
                         
                        </div>
                   
                </div>
            </div>
        </div>
    </div>  

    <div id="stud_skills" class="tab-pane fade">  
          <div class="col-sm-4 col-sm-offset-0" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
                        
                        <div class="form-group">
                            <label for="name" class="control-label">Name</label>
                            <input type="text" readonly value='<%=request.getParameter("name")%>' class="form-control"  id="name" name="name" required placeholder="Enter Student Name">
                        </div>
                        <div class="form-group">
                            <label for="rno" class="control-label">Roll. No.</label>
                            <input type="text" readonly value='<%=request.getParameter("roll") %>'  class="form-control" id="rno" name="rno" required placeholder="Enter Student Roll. No.">
                        </div>
                         <div class="form-group">
                            <label for="team_spirit" class="control-label">Team Spirit</label>
                            <input type="number" class="form-control" id="team_spirit" max="5" name="team" required placeholder="Eg. 3">
                        </div>
                        <div class="form-group">
                            <label for="enth" class="control-label">Enthusiasm</label>
                            <input type="number" class="form-control" id="enth" max="5" name="enth" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="conf" class="control-label">Self Confidence</label>
                            <input type="number" class="form-control" max="5" id="conf" name="conf" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="cleanliness" class="control-label">Cleanliness</label>
                            <input type="number" class="form-control" max="5" id="cleanliness" name="clean" required placeholder="Eg. 3">
                        </div>
                       
                        
                         <div class="form-group">
                            <label for="oral" class="control-label">Oral Communication</label>
                            <input type="number" class="form-control" max="5" id="oral" name="oral" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="lang" class="control-label">Body Language</label>
                            <input type="number" class="form-control" max="5" id="lang" name="lang" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="prob" class="control-label">Problem Solving</label>
                            <input type="number" class="form-control" max="5" id="prob" name="prob" required placeholder="Eg. 3">
                        </div>
                        
                        <div class="form-group">
                            <label for="skill" class="control-label">Analytical Skills</label>
                            <input type="number" class="form-control" max="5" id="skill" name="skill" required placeholder="Eg. 3">
                        </div>
                        
                        
                        <div class="form-group">
                         
                        <a class ="btn btn-primary btn-block" data-toggle="tab" href="#stud_remarks">Next -></a>
   
                        </div>
                       
                   
                </div>

    </div>  
    <div id="stud_remarks" class="tab-pane fade">  
    
        <div class="container">   
     
       <div class="row" >
                <br><br>
               
                
                <div class="col-sm-4 col-sm-offset-0" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
       
                        
                          <div class="form-group">
                            <label for="id" class="control-label">Student ID</label>
                            <input type="text" class="form-control" readonly value='<%=request.getParameter("roll")%>' id="id" name="id" required placeholder="Enter Student ID">
                        </div>
                        
                       <div class="form-group">
                            <label for="remarks">Student Remarks<font color="red">*</font></label>
                            <textarea class="form-control" rows="10" name="remarks" required maxlength="500" ></textarea>
                        </div> 
                      
                        
                        <div class="form-group">
                            <input type="submit" name="sub" class="btn btn-primary btn-block" value="Submit">
                        </div>
                       
                    
                </div>
            </div>
        </div>            
    </div>  
  
  </div>  
   </form>
</div>  
   </div>
</div>
<div style="clear:both"></div>


  


 
        
        
 
        
 

 <script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>

        </body>
</html>
 
