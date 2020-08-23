package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DatabaseConnection;

import org.json.simple.JSONObject;

@WebServlet("/FetchProfiles")
public class FetchProfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}  
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
    	try { 
    		JSONObject json = new JSONObject();
            Connection con = DatabaseConnection.initializeDatabase();  
            Statement statement = con.createStatement() ;
            ResultSet resultset = statement.executeQuery("SELECT * FROM roles") ;
            while(resultset.next()){
            	json.put(resultset.getInt(1), resultset.getString(2));
            }
            String jsonData = json.toString();
            response.setContentType("application/json");
            response.getWriter().write(jsonData);
        } 
        catch (Exception e) { 
            e.printStackTrace();
        } 
    }
}
