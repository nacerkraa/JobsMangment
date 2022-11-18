package com.example.demo.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.tomcat.util.http.fileupload.FileUpload;

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
		String query = "select * from user where email= ? and password = ?";
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
	

	public void addUser(String nom,String prenom,String email,String passworrd,String tel,String inscrire,String gender,String file) {
		try {
			PreparedStatement pr=Connect.prepareStatement("INSERT INTO Utilisateur(Nom,Prenom,E_mail,Password,Tel,T_inscrire,Gender,file) VALUES(?,?,?,?,?,?,?,?)");
			pr.setString(1, nom);
			pr.setString(2, prenom);
			pr.setString(3, email);
			pr.setString(4, passworrd);
			pr.setString(5, tel);
			pr.setString(6, inscrire);
			pr.setString(7, gender);
			pr.setString(8, file);
			pr.executeUpdate();
					if(inscrire.equals("Apprenant")) {
						PreparedStatement pr2=Connect.prepareStatement("INSERT INTO Apprenant(E_mail_apprenant) VALUES(?)");
			        	pr2.setString(1, email);
			        	
			         
			        	pr2.executeUpdate();
		     
				
					  }
			/*	else {
			
				if(inscrire.equals("Formateur")) {		
				
				PreparedStatement pr3=Connect.prepareStatement("INSERT INTO Formateur VALUES(?,?,?)");
				pr3.setString(1, email);
			
				pr3.setString(2, "programation");
				pr3.setString(3, file);
				
				pr3.executeUpdate();
			
				}
				}*/
				 pr.close();
			
					} catch (Exception e) {
			System.out.println("erreur0"+e);
		}
	}
	
	// get User by Id
		public User getUserById(String x) throws SQLException {
			User  U =null ;
			String readData = "select * from utilisateur where E_mail = '" + x +"'";
			Statement st = Connect.createStatement();
			 ResultSet rs = st.executeQuery(readData);
			
			while (rs.next()) {
				
				
				String Nom = rs.getString("first_name");
		        String Prenom = rs.getString("last_name");
		        String Email = rs.getString("email");
				String Password = rs.getString("password");

				
		        
			
		        U= new User(Nom,Prenom,Email,Password);
			}
			return U;
		}
	
	//update les info de user
	

	public boolean updateUser(User x) {
		String query = "update utilisateur set first_name= '"+x.getFirstName()+"', last_name='"+x.getLastName()+"',email='"+x.getEmail()+"', Password='"+x.getPassword()+"' where E_mail='"+x.getEmail()+"'";
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
	
	// List des apprenant
	
	public ArrayList<User> viewListAprenant() throws SQLException {
		User U ;
		ArrayList<User> list = new ArrayList<User>();
		String readData = "select * from utilisateur where T_inscrire='Apprenant'";
		Statement st = Connect.createStatement();
		 ResultSet rs = st.executeQuery(readData);
		
		while (rs.next()) {
			 
	        
	        
	    	String FirstName = rs.getString("first_name");
	    	String LastName = rs.getString("last_name");
	    	String Email = rs.getString("email");
	    	String Password = rs.getString("password");
	    	
	    	U = new User(FirstName,LastName,Email,Password);
		        list.add(U);
		}
		
 
        return list;
	}
	
	
	
	
	public ArrayList<User> afficherUser(){
		User U ;
		Boolean f=false;
		ArrayList<User> l=new ArrayList<User>();
		String fvalid="SELECT etat from Formateur";
		try {
			Statement st32 =Connect.createStatement();
			ResultSet re32=st32.executeQuery(fvalid);
			while(re32.next()) {
				if(re32.getString("etat").equals("en_travail")) {
					f=true;
				}
			}
		}catch(Exception e) {
			System.out.println("empty"+e);
		}
		if(f==true) {
		String query22="SELECT * FROM Utilisateur where T_inscrire='Apprenant'";
		
		try {
			Statement st =Connect.createStatement();
			ResultSet re=st.executeQuery(query22);
			while(re.next()) {
				
			    String FirstName=re.getString("Nom");
			    String LastName=re.getString("Prenom");
				String Email =re.getString("E_mail");
				
				 U =new User(FirstName,LastName,Email);
				l.add(U);
			}
			 re.close();
			 st.close();
			
		}catch(Exception e) {
			System.out.println("erreur");
		}
		return l;
	}else {
		System.out.println("No etude");
		return null;
	}}
	
	
	public void updateEtatAp(String ap) {
		String upd="UPDATE Apprenant SET etat='valide' WHERE E_mail_apprenant= '"+ap+"'";
		PreparedStatement st = null;
	
		try {
			
			st = this.Connect.prepareStatement(upd);
			st.executeUpdate();
			
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//delete apprenant
	public void deleteApp(String apd) {
		String del="DELETE FROM Apprenant WHERE  E_mail_apprenant='"+apd+"'" ;
         PreparedStatement st;
		
		try {
			
			 
			 st = Connect.prepareStatement(del);
			 
		     st.executeUpdate();
		     String del1="DELETE FROM Utilisateur WHERE  E_mail='"+apd+"'" ;
	         PreparedStatement st1;
             st1 = Connect.prepareStatement(del1);
			 
		     st1.executeUpdate();
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
	//Update etat de  formation proposer
	public void UpEtatform(int ID_F) {
	String upF="UPDATE Formation SET etat='valide' WHERE Id_formation= '"+ID_F+"'";
	PreparedStatement st = null;

	try {
		
		st = this.Connect.prepareStatement(upF);
		st.executeUpdate();
		st.close();
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	//delete formation proposer
		public void deleteForm(int id_f) {
			String delf="DELETE FROM Formation WHERE  Id_formation='"+id_f+"'" ;		
	         PreparedStatement st;		
			try { 
				 st = Connect.prepareStatement(delf);
                 st.executeUpdate();
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
}
