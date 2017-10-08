<%@page import="com.ppi.model.Remarks"%>
<%@ page import="java.sql.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@page import="com.ppi.model.Knowledge"%>
<%@page import="com.ppi.model.Remarks"%>
<%@page import="com.ppi.model.Skills"%>
<%@page import="com.ppi.impl.RecordsIMPL"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
          <link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

 <script src="js/bootstrap.min.js"></script>

<script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
     
    </head>
    <body background="images/e.jpg">
       <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PPI PORTAL</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="expert.jsp">Home</a></li>

      
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
           String roll=request.getParameter("roll");
           Knowledge k = RecordsIMPL.getRecordById(roll);
           Skills s = RecordsIMPL.getSkillsById(roll);
           Remarks r = RecordsIMPL.getRemarksById(roll);
                    
     %>  


  
<div class="container">  
  
  <ul class="nav nav-tabs">  
    <li><a data-toggle="tab" href="#stud_knowledge">Student Knowledge</a></li>  
    <li><a data-toggle="tab" href="#stud_skills">Student Skills</a></li>  
    <li><a data-toggle="tab" href="#stud_remarks">Student Remarks</a></li>    
  </ul>  
  
  <form class="form-horizontal" role="form" action="../EditDetails" method="post">
  <div class="tab-content">  
    <div id="stud_knowledge" class="tab-pane fade in active">  
 <div class="container">
       <div class="row" >

                <div class="col-sm-4 col-sm-offset-4" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
      
                        
                        <div class="form-group">
                            <label for="name" class="control-label">Name</label>
                            <input type="text" class="form-control" readonly value='<%=k.getName()%>' id="name" name="name" required placeholder="Enter Student Name">
                        </div>
                        
                        <div class="form-group">
                            <label for="rno" class="control-label">Roll No.</label>
                            <input type="text" class="form-control" readonly id="rno" value='<%=k.getRoll()%>' name="rno" required placeholder="Enter Student Roll. No.">
                        </div>
                        
                         <div class="form-group">
                            <label for="data" class="control-label">Data Structures</label>
                            <input type="number" class="form-control" max="5" id="data" value='<%=k.getData()%>' name="data" required placeholder="Eg. 3">
                        </div>
                        
                        <div class="form-group">
                            <label for="logic" class="control-label">Logic Building</label>
                            <input type="number" class="form-control" max="5" id="logic" value='<%=k.getLogic()%>' name="logic" required placeholder="Eg. 5">
                        </div>
                       
                         <div class="form-group">
                            <label for="cao" class="control-label">Computer arch. and Organization</label>
                            <input type="number" class="form-control" max="5" id="cao" name="cao" value='<%=k.getCao()%>' required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="dbms" class="control-label">DBMS</label>
                            <input type="number" class="form-control" max="5" id="dbms" name="dbms" value='<%=k.getDbms()%>' required placeholder="Eg. 3">
                        </div>
                     
                        
                         <div class="form-group">
                            <label for="os" class="control-label">Operating Systems</label>
                            <input type="number" class="form-control" max="5" id="os" name="os" value='<%=k.getOs()%>' required placeholder="Eg. 5">
                        </div>
                       
                         <div class="form-group">
                            <label for="cn" class="control-label">Computer Networks</label>
                            <input type="number" class="form-control" max="5" id="cn" name="cn" value='<%=k.getCn()%>' required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="app" class="control-label">Application development using C/C++/PHP/Java</label>
                            <input type="number" class="form-control" max="5" id="app" name="app" value='<%=k.getApp()%>' required placeholder="Eg. 3">
                        </div>
                           
                        
                        <div class="form-group">
                        
                       
                        <a class ="btn btn-primary btn-block" data-toggle="tab" type="submit" href="#stud_skills">Next -></a>
                         
                        </div>
                   
                </div>
            </div>
        </div>
    </div>  

    <div id="stud_skills" class="tab-pane fade">  
          <div class="col-sm-4 col-sm-offset-4" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
                        
                        <div class="form-group">
                            <label for="name" class="control-label">Name</label>
                            <input type="text" readonly value='<%=s.getName()%>' class="form-control"  id="name" name="name" required placeholder="Enter Student Name">
                        </div>
                        <div class="form-group">
                            <label for="rno" class="control-label">Roll. No.</label>
                            <input type="text" readonly value='<%=s.getRoll()%>'  class="form-control" id="rno" name="rno" required placeholder="Enter Student Roll. No.">
                        </div>
                         <div class="form-group">
                            <label for="team_spirit" class="control-label">Team Spirit</label>
                            <input type="number" class="form-control" id="team_spirit" value='<%=s.getTeam()%>'  max="5" name="team" required placeholder="Eg. 3">
                        </div>
                        <div class="form-group">
                            <label for="enth" class="control-label">Enthusiasm</label>
                            <input type="number" class="form-control" id="enth" value='<%=s.getEnth()%>'  max="5" name="enth" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="conf" class="control-label">Self Confidence</label>
                            <input type="number" class="form-control" max="5" id="conf" value='<%=s.getConf()%>'  name="conf" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="cleanliness" class="control-label">Cleanliness</label>
                            <input type="number" class="form-control" max="5" id="clean" value='<%=s.getClean()%>'  name="clean" required placeholder="Eg. 3">
                        </div>
                       
                        
                         <div class="form-group">
                            <label for="oral" class="control-label">Oral Communication</label>
                            <input type="number" class="form-control" max="5" id="oral" value='<%=s.getOral()%>'  name="oral" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="lang" class="control-label">Body Language</label>
                            <input type="number" class="form-control" max="5" id="lang" value='<%=s.getLang()%>'  name="lang" required placeholder="Eg. 5">
                        </div>
                        
                         <div class="form-group">
                            <label for="prob" class="control-label">Problem Solving</label>
                            <input type="number" class="form-control" max="5" id="prob" value='<%=s.getProb()%>'  name="prob" required placeholder="Eg. 3">
                        </div>
                        
                        <div class="form-group">
                            <label for="skill" class="control-label">Analytical Skills</label>
                            <input type="number" class="form-control" max="5" id="skill" value='<%=s.getSkill()%>' name="skill" required placeholder="Eg. 3">
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
               
                
                <div class="col-sm-4 col-sm-offset-4" style="background-color: rgba(255,255,255,0);border-radius: 10px;">
       
                        
                          <div class="form-group">
                            <label for="id" class="control-label">Student ID</label>
                            <input type="text" class="form-control" readonly value='<%=r.getRoll()%>' id="id" name="id" required placeholder="Enter Student ID">
                        </div>
                        
                       <div class="form-group">
                            <label for="remarks">Student Remarks<font color="red">*</font></label>
                            <textarea class="form-control" rows="10" name="remarks" required maxlength="500" ><%=r.getRemarks()%></textarea>
                        </div> 
                      
                        
                        <div class="form-group">
                            <input type="submit" name="sub" class="btn btn-primary btn-block" value="Update">
                        </div>
                       
                    
                </div>
            </div>
        </div>            
    </div>  
  
  </div>  
   </form>
</div>  


        </body>
</html>
 
