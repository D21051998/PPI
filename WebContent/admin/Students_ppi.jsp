<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.* "%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico"/>
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  
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
            <li id="upload"><a href="Upload.jsp"><span class="glyphicon glyphicon-book"></span> File Upload</a></li>
                 <li id="student"><a href="view_data.jsp"><span class="glyphicon glyphicon-book"></span> View Student Data</a></li>
                <li id="transfer"><a href="transfer_data.jsp"><span class="glyphicon glyphicon-book"></span> Transfer Data</a></li>
              <li id="expert"><a href="view_expert_data.jsp"><span class="glyphicon glyphicon-book"></span>View Expert Data</a></li>
          <li id="expert"><a href="assigned_students.jsp"><span class="glyphicon glyphicon-book"></span>View Assigned Students</a></li>
      <li id="expert"><a href="Analysis.jsp"><span class="glyphicon glyphicon-book"></span>Analysis of Students</a></li>
            </ul>
        </div>
        <!-- Sidebar ends --> 
        
<form method="post" action="../uploadDetails" >         
        
	<jsp:useBean id="RecordsDao" class="com.ppi.impl.RecordsIMPL"></jsp:useBean>
<%
		request.setAttribute("students", RecordsDao.getStudents());

        
	%>

 <div class="col-sm-2 col-lg-8">


            <table class="table">
                <thead>
                    <tr class="info">
                        <th> Expert Id</th>
                        <th> Student Id</th>
                        <th> PPI Assigned </th>
                    </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">

				<tr class="info">
					<td>${student.roll}</td>
					<td>${student.name}</td>
					<td><c:if test="${student.assign == 1}"> <input type="checkbox" name="checkbox" value="${student.roll}" checked></c:if>
						<c:if test="${student.assign == 0}"> <input type="checkbox" name="checkbox" value="${student.roll}"></c:if>
					</td>
					
				</tr>
		</c:forEach>           
            </tbody>
            </table>
            </div>
            
            <input type="submit" name="submit" value="SUBMIT">
            
            </form>
</body>
</html>