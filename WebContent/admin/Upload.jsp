<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico"/>
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
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
      </ul>  </div>
        <!-- Sidebar ends -->     
        <div class="col-sm-3 col-lg-4" style="margin-top: 100px;margin-left: 50px">
         <form id="abcd" action="#" method="POST" enctype="multipart/form-data">   
         <div class="form-group">
                            <label for="certiupload"> Upload List<font color="red">*</font></label>
                            <input type="file" class="form-control" name="certi_pdf" >
                        </div>
        
         <button type="submit"  class="btn btn-success">Submit</button>
                    </form>
        
        </div>
    </body>
</html>