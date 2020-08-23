package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatabaseConnection;

@WebServlet("/AuthenticateUser")
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try{
    		Connection con = DatabaseConnection.initializeDatabase(); 
    		PreparedStatement st = con.prepareStatement("select * from users where email = ? and password = ?");
    		st.setString(1, request.getParameter("inputEmail")); 
            st.setString(2, request.getParameter("inputPassword"));
            ResultSet rs = st.executeQuery();
    		HttpSession session = request.getSession();
			if(rs.next()){
				PreparedStatement st1 = con.prepareStatement("select * from departments where dept_id = ?");
	    		st1.setString(1, rs.getString("dept_id")); 
	            ResultSet rs1 = st1.executeQuery();
	            rs1.next();
				PreparedStatement st2 = con.prepareStatement("select * from roles where role_id = ?");
	    		st2.setString(1, rs.getString("role_id")); 
	            ResultSet rs2 = st2.executeQuery();
	            rs2.next();
	            session.setAttribute("username", rs.getString("username")); 
	            session.setAttribute("useremail", rs.getString("email")); 
	            session.setAttribute("userdept", rs1.getString("dept_name")); 
	            session.setAttribute("userrole", rs2.getString("role_name")); 
	            
	            if(rs1.getString("dept_name").equals("Works Department")){response.sendRedirect("works_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Health Department")){response.sendRedirect("health_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Council Department")){response.sendRedirect("council_department.jsp");}
	            else if(rs1.getString("dept_name").equals("General Department")){response.sendRedirect("general_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Revenue Department")){response.sendRedirect("revenue_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Buildings Department")){response.sendRedirect("buildings_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Family Welfare Department")){response.sendRedirect("family_welfare_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Land and Estate Department")){response.sendRedirect("land_and_estate_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Financial Management Department")){response.sendRedirect("financial_management_department.jsp");}
	            else if(rs1.getString("dept_name").equals("Solid Waste Management Department")){response.sendRedirect("solid_waste_management_department.jsp");}
	            else{ // redirect on default page 
	            	RequestDispatcher rd=request.getRequestDispatcher("/view_book.jsp");
	                rd.forward(request,response);
	                }
	        }
			else{
				System.out.println("dept_name");
			}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    

}
