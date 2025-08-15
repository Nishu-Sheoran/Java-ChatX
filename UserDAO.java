package com.Nishu.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Nishu.chatapp.dto.UserDTO;
import com.Nishu.chatapp.utils.Encryption;

// USER CRUD
public class UserDAO {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException , Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="Select userid from users where userid=? and password=?";
		try {
			con=CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,userDTO.getUserid() );
			String encryptedPwd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setNString(2, encryptedPwd);
			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	// public int add(String userid,String password,byte age,String phine,String email,String country ){
		
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException ,Exception{
		System.out.println("Rec "+userDTO.getUserid()+" "+userDTO.getPassword());
		Connection connection=null;
		Statement stmt=null; // query
		try {
		connection=CommonDAO.createConnection(); // step-1 connection create
		// step-2 we do a query
		stmt = connection.createStatement();
		//  insert into users(userid,password) values('ram','ram123');
		int record = stmt.executeUpdate("insert into users(userid,password) values ('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')"); // Insert,Delete,Update
		return record;
		}
		finally { // Always execute (Resource cleanup)
			if(stmt!=null) {
		stmt.close();
			}
			if(connection!=null) {
		connection.close();
			}
		}
		
	}

	

}
