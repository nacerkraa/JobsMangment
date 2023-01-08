package com.example.demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.demo.dao.Service;



public class ServiceOperation {
	private static ConnexionBase con;
	private static Connection Connect;

	public ServiceOperation() {
		con = new ConnexionBase();
		Connect = con.getConnection();
	}
	
	
	public boolean addService(Service s) {
		String query = "insert into service(name, description, location, emailUser) values (?, ?, ?, ?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			st = this.Connect.prepareStatement(query);
			st.setString(1, s.getTitle());
			st.setString(2, s.getDescription());
			st.setString(3, s.getLocation());
			st.setString(4, s.getEmailUser());
			
			
			r = st.executeUpdate();
			st.close();
			b=true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	
	public ArrayList<Service> viewAll() throws SQLException {
		Service S ;
		ArrayList<Service> list = new ArrayList<Service>();
		String readData = "select * from service";
		Statement st = Connect.createStatement();
		 ResultSet rs = st.executeQuery(readData);
		
		while (rs.next()) {
			String title = rs.getString("name");
	    	String description = rs.getString("description");
	    	String emailUser = rs.getString("emailUser");
	    	String location  = rs.getString("location");
	    	
	    	 S = new Service(title, description, location, emailUser);
		     list.add(S);
		}
		
 
        return list;
	}
	
}
