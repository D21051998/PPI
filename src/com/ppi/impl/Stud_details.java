package com.ppi.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Stud_Knowledge
 */
@WebServlet("/Stud_details")
public class Stud_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stud_details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        String name= request.getParameter("name");
        String rno= request.getParameter("rno");
       
        
        String data= request.getParameter("data");

        String logic= request.getParameter("logic");
      
        String cao= request.getParameter("cao");
    
        String dbms= request.getParameter("dbms");

        String os= request.getParameter("os");
        
        String cn= request.getParameter("cn");
  
        String app= request.getParameter("app");

        
        String team= request.getParameter("team");
        
        String enth= request.getParameter("enth");

        String conf= request.getParameter("conf");

        String clean= request.getParameter("clean");

        String oral= request.getParameter("oral");
        
        String lang= request.getParameter("lang");

        String prob= request.getParameter("prob");
 
        String skill= request.getParameter("skill");

        
        String remarks= request.getParameter("remarks");
    

    try{
   
        RecordsIMPL.addKnowledge(rno, name, data, logic, cao, dbms, os, cn, app);
        RecordsIMPL.addSkills(rno, name, team, enth, conf, clean, oral, lang, prob, skill);
        RecordsIMPL.addRemarks(rno, remarks);
        AssignIMPL.updateAssign(rno);
  
    }
    catch(Exception e)
    {
       System.out.println(e); 
    }
    
    response.sendRedirect("expert/expert.jsp");
   
    
    }
}
