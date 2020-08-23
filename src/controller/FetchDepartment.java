package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.DatabaseConnection;

@WebServlet("/FetchDepartment")
public class FetchDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}  
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{ 
    	try { 
    		// Integer i=0;
    		JSONObject json = new JSONObject();
            // Initialize the database 
            Connection con = DatabaseConnection.initializeDatabase();  
            Statement statement = con.createStatement() ;
            ResultSet resultset = statement.executeQuery("SELECT * FROM departments") ;
            List<Object> departments=new ArrayList<Object>();
            Map <Object, Object> map = new HashMap<Object, Object>();
            while(resultset.next()){
                // map.put(resultset.getInt(1), resultset.getString(2));
                // departments.add(map);
            	// json.put("department_id"+i, resultset.getInt(1));
            	// json.put("department_name"+i, resultset.getString(2));
            	// i++;
            	json.put(resultset.getInt(1), resultset.getString(2));
            }
            // String jsonData = map.toString();
            String jsonData = json.toString();
            response.setContentType("application/json");
            response.getWriter().write(jsonData);
        } 
        catch (Exception e) { 
            e.printStackTrace();
        } 
    }

}
