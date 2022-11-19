package com.example.demo.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.demo.dao.User;



public class userOperations {

	private static ConnexionBase con;
	private static Connection Connect;

	public userOperations() {
		con = new ConnexionBase();
		Connect = con.getConnection();
	}
	
	/**
	 * User Login
	 * @param x
	 * @return boolean
	 */
	public boolean authentify(User x) {
		String query = "select * from user where email= ? and motPasse = ?";
		PreparedStatement st = null;
		ResultSet r = null;
		boolean b=false;
		try {
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getEmail());
			st.setString(2, x.getPassword());
			

			r = st.executeQuery();
			if (r.next())
				b = true;
			st.close();
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	
	/**
	 * Get User by Email
	 * @param x
	 * @return
	 * @throws SQLException
	 */
	public User getUserByEmail(String x) throws SQLException {
		User  U =null ;
		String readData = "select * from user where email = '" + x +"'";
		Statement st = Connect.createStatement();
		 ResultSet rs = st.executeQuery(readData);
		
		while (rs.next()) {
			
			
			String FirstName = rs.getString("nom");
	        String LastName = rs.getString("prenom");
	        String Email = rs.getString("email");
			String Password = rs.getString("motpasse");
	        String Phone = rs.getString("tel");
	        String Sexe = rs.getString("sexe");
			int Age = rs.getInt("age");
	        String location = rs.getString("location");
	        String Type = rs.getString("type");
			
	        
		
	        U= new User(FirstName, LastName, Email,Password, Phone,Sexe,  Age, location, Type);
		}
		return U;
	}
	
	
}
