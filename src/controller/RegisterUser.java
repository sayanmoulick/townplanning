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

import model.DatabaseConnection;

//Servlet Name 
@WebServlet("/InsertData")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
    	boolean unique = true;
    	String email=request.getParameter("inputEmail");
    	try { 
            // Initialize the database 
            Connection con = DatabaseConnection.initializeDatabase(); 
            // Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
            Statement statement = con.createStatement() ;
            ResultSet resultset = statement.executeQuery("SELECT * FROM users") ;
            while(resultset.next()){
                if(resultset.getString("email").equalsIgnoreCase(email)){
                    unique = false;
                }
            }
            if(unique){
            	PreparedStatement st = con.prepareStatement("insert into users(emp_id,username,email,password,dept_id,role_id,registrationDate) values(?, ?, ?, ?, ?, ?, ?)"); 
                // For the first parameter, 
                // get the data using request object 
                // sets the data to st pointer 
                st.setInt(1, Integer.valueOf(request.getParameter("inputEmpId"))); 
                st.setString(2, request.getParameter("inputFirstName")+" "+request.getParameter("inputLastName"));
                // Same for second parameter 
                st.setString(3, request.getParameter("inputEmail")); 
                // Same for third parameter 
                st.setString(4, request.getParameter("inputPassword"));
                st.setInt(5, Integer.valueOf(request.getParameter("inputDepartment")));
                st.setInt(6, Integer.valueOf(request.getParameter("inputProfile")));
                st.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
                
                // Execute the insert command using executeUpdate() 
                // to make changes in database 
                st.executeUpdate(); 
      
                // Close all the connections 
                st.close(); 
                con.close(); 
      
                // Get a writer pointer  
                // to display the successful result 
                PrintWriter out = response.getWriter(); 
                // out.println("<html><body><b>Successfully Inserted </b></body></html>");
                response.sendRedirect("index.html");
            }
            else{
            	// PrintWriter out = response.getWriter(); 
                // out.println("<html><body><b>Registration Failed!</b></body></html>");
            	/*out.println("<script src='assets/js/sweetalert2.all.js'></script>");
            	out.println("<script src='assets/js/jquery.min.js'></script>");
            	out.println("<script>");
            	out.println("$(document).ready(function(){");
            	out.println("swal ( 'Oops' ,  'Something went wrong!' ,  'error' )");
            	out.println("});");
            	out.println("</script>");
            	RequestDispatcher rd = request.getRequestDispatcher("index.html");
            	rd.include(request, response);*/
            	response.sendRedirect("index.html?registration=false");
            }
        } 
        catch (Exception e) { 
            e.printStackTrace();
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Internal Server Error!"
                        + "</b></body></html>");
        } 
    }
}
