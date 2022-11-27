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
	
	public boolean addUser(User u) {
		String query = "insert into user(nom, prenom, email, motpasse, tel, sexe, age, location, type) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			if(!authentify(u)) {
				
			st = this.Connect.prepareStatement(query);
			st.setString(1, u.getFirstName());
			st.setString(2, u.getLastName());
			st.setString(3, u.getEmail());
			st.setString(4, u.getPassword());
			st.setString(5, u.getPhone());
			st.setString(6, u.getSexe());
			st.setInt(7, u.getAge());
			st.setString(8, u.getLocation());
			st.setString(9, u.getType());

			
			r = st.executeUpdate();
			st.close();
			b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	
	//update les info de etablissement


	public boolean updateEtab(User x) {
		String query = "update users set nom = '"+x.getFirstName()+"',prenom='"+x.getLastName()+"', email='"+x.getEmail()+ "', motpasse ='"+x.getPassword()+ "', tel ='"+x.getPhone()+ "', sexe ='"+x.getSexe()+ "', age ='"+x.getAge()+"' where email='"+x.getEmail()+"'";
		
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			
			st = this.Connect.prepareStatement(query);
			r = st.executeUpdate();
			st.close();
			b=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}

	
	
}
