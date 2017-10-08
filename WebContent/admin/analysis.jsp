<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico"/>
 <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<title>Pie Chart Demo</title>
<style>
img.a{
margin-left:15%;
}
img.b{
margin-left:31.7%;
}

</style>
</head>
<body><nav class="navbar navbar-inverse">
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

<!--        <h3>Analysis</h3> -->
           <br> <img class="a" src="../ChartServlet" />
           <br>
           <br>
           <br>
           <img class="b" src="../PieChart" />
           <br>
           <br>
</body>
</html>