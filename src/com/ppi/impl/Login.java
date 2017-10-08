package com.ppi.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppi.model.Bcrypt;
import com.ppi.model.LoginCreds;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 public String rString() {
	        UUID uuid = UUID.randomUUID();
	        return uuid.toString();
	    }
	
    public Login() {
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
		PrintWriter out = response.getWriter();
        if (request.getParameter("username") == null || request.getParameter("password") == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Every field must be filled');");
            out.println("location='index.jsp';");
            out.println("</script>");
            out.close();
        }

        LoginCreds creds = LoginObjs.getLoginByID(request.getParameter("username"));
        try {
            if (creds.getPassword().equals(Bcrypt.hashpw(request.getParameter("password"), creds.getBase()))) {
//                if (creds.getStatus().equals("active")) {
//                    if (creds.getRole().equals("ROLE_STUDENT")) {
//                        LoginObjs.addIP(creds.getId(), request.getParameter("client_add"));
//                        String s_id = rString();
//                        LoginObjs.setS_ID(request.getParameter("username"), s_id);
//                        request.getSession().setAttribute("s_id", s_id);
//                        response.sendRedirect("student/student_dashboard.jsp");
//                    }    
//                    if (creds.getRole().equals("ROLE_EXPERT")) {
//                        LoginObjs.addIP(creds.getId(), request.getParameter("client_add"));
//                        String s_id = rString();
//                        LoginObjs.setS_ID(request.getParameter("username"), s_id);
//                        request.getSession().setAttribute("s_id", s_id);
//                        response.sendRedirect("industry/expert_dashboard.jsp");
//                    }
//                    if (creds.getRole().equals("ROLE_ADMIN")) {
                        LoginObjs.addIP(creds.getId(), request.getParameter("client_add"));
                        String s_id = rString();
                        LoginObjs.setS_ID(request.getParameter("username"), s_id);
                        request.getSession().setAttribute("s_id", s_id);
                        response.sendRedirect("admin/assigned_students.jsp");
//                    }
//                } else {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Cannot Login: Account is disabled for Security Reasons.');");
//                    out.println("location='index.jsp';");
//                    out.println("</script>");
//                }

            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Wrong Password');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        } catch (NullPointerException n) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('No Such Account found!');");
            out.println("location='index.jsp';");
            out.println("</script>");
        }
        finally{
            out.close();
        }
	}

}
