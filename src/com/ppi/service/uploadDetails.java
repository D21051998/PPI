package com.ppi.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppi.model.Ppi;

/**
 * Servlet implementation class uploadDetails
 */
@WebServlet("/uploadDetails")
public class uploadDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String roll[]= request.getParameterValues("checkbox");
		for(int i=0;i<roll.length;i++){
			System.out.println(roll[i]);
		}
		
		
		Connection con=null;
        try
        {        	
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppi","root","root");
                   con.setAutoCommit(false);
                   PreparedStatement pstm = null;
                   
                   HttpSession session=request.getSession(false);  
                   List<Ppi> n=(List<Ppi>) session.getAttribute("list");  

                   
                   String sql3 = "insert into assign(expert_id,student_id,ppi_assigned) values(?,?,?)";
          		   pstm=con.prepareStatement(sql3);
          		   
          		   
          		 Iterator<Ppi> itr=n.iterator();

         	    while(itr.hasNext())
         	    {
         	        Ppi p = itr.next();

         	        System.out.print("expert:"+p.getExpert());
         	        System.out.print("Stud:"+p.getRoll());
         	        System.out.println("Assign:"+p.getAssign());
         	        
         	    }
          		   
        
        for(int i=0;i<roll.length;i++)
        {
        	
        	Iterator<Ppi> itr1=n.iterator();

     	    while(itr1.hasNext())
     	    {
     	        Ppi p = itr1.next();

     	       if(roll[i].equals(p.getRoll())){
           		pstm.setString(1,p.getExpert());
                   pstm.setString(2,p.getRoll());
                   pstm.setInt(3,1);
                   System.out.println(pstm.executeUpdate());
           	}
     	        
     	    }
           
        	
  		     
        }
        

        response.sendRedirect("admin/assigned_students.jsp");
	}catch(Exception e){
		e.printStackTrace();
	}

	}

}
