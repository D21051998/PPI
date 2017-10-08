package com.ppi.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
 * Servlet implementation class AssignService
 */
@WebServlet("/AssignService")
public class AssignService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignService() {
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
		
		
		
		Connection con=null;
        try
        {        	
                   Class.forName("com.mysql.jdbc.Driver");
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppi","root","root");
                   con.setAutoCommit(false);
                   PreparedStatement pstm = null;
                   List<Ppi> list=new ArrayList<Ppi>();
                   int a = 0,b = 0,c,d,e=5;
                   String x = null,y = null;
                   
//                   String sql6 = "DELETE FROM ASSIGN";
//                   pstm = con.prepareStatement(sql6);
//                   pstm.execute();

                   String sql = "Select count(*) from records where ppi_assigned=?";
          
                   pstm=con.prepareStatement(sql);
                   pstm.setInt(1, 0);
                   ResultSet rs= pstm.executeQuery();
                   
                   while(rs.next()){
                	   a=rs.getInt(1);
                   }
                   
                   String sql2 = "Select count(*) from expert_login";
                   pstm=con.prepareStatement(sql2);
                   ResultSet rs2= pstm.executeQuery();
                   
                   while(rs2.next()){
                	   b=rs2.getInt(1);
                   }
                   
                   c=a/b;
                   d=a%b;
                   
                   System.out.println("a : "+a);
                   System.out.println("b : "+b);
                   System.out.println("c : "+c);
                   System.out.println("d : "+d);
                   
                   
                   
                   String sql4 = "Select id from expert_login";
        		   String sql5 = "Select rno from records  where ppi_assigned=?";
        		   pstm=con.prepareStatement(sql4);
                   ResultSet rs3= pstm.executeQuery();
                   pstm=con.prepareStatement(sql5);
                   pstm.setInt(1, 0);
                   ResultSet rs4= pstm.executeQuery();
                  // String sql7 = "update records set ppi_assigned=? where rno=?";
 

                   int k=0;
                  
                   
                	  
                    	   for(int j=0;j<c;j++){   
                    		   for(int i=0;i<b;i++){
                               
                               if(k!=a){
                            	   System.out.println("k : "+(k+1));  
                            	   if(rs3.absolute(i+1)){
                            	   x=rs3.getString(1);
                            	   System.out.println("x : "+x);
                            	   }
                            	   if(rs4.absolute(k+1)){
                                	   y=rs4.getString(1);
                                	   System.out.println("y : "+y);
                                	   }
                           		
                      				Ppi p=new Ppi();
                      				p.setExpert(x);
                      				p.setRoll(y);
                      				if((k+1)<=e){
                      				p.setAssign(1);
                      				}
                      				else{
                      					p.setAssign(0);
                      				}
                      				list.add(p);
                               }
                    		   k++;
                    		   
                    	 }  

                   }
                	   
                	   if(d!=0){
                         
                	   
                	   for(int i=0,j=k;i<d && j<k+d;i++,j++){

                           
                           System.out.println("k : "+(j+1));  
                           if(rs3.absolute(i+1)){               	   
                        	   x=rs3.getString(1);
                        	   System.out.println("x : "+x);
                           }
     
                        	   if(rs4.absolute(j+1)){
                            	   y=rs4.getString(1);
                            	   System.out.println("y : "+y);
                            	   }

                        	   
                        	   Ppi p=new Ppi();
                 				p.setExpert(x);
                 				p.setRoll(y);
                 				if((j)<=e){
                 				p.setAssign(1);
                 				}
                 				else{
                 					p.setAssign(0);
                 				}
                 				list.add(p);
                 				
                           
                	   }
                	   
            		   
           	   }
                	   Iterator<Ppi> itr=list.iterator();

                	    while(itr.hasNext())
                	    {
                	        Ppi p = itr.next();

                	        System.out.print("expert:"+p.getExpert());
                	        System.out.print("Stud:"+p.getRoll());
                	        System.out.println("Assign:"+p.getAssign());
                	        
                	    }

                	    HttpSession sess=request.getSession();  
                        sess.setAttribute("list",list);
                  
                   con.commit();
                   pstm.close();
                   } 
                   catch (Exception e) 
                   {
                       e.printStackTrace();
                   }
        
        
       
            
	}

}
