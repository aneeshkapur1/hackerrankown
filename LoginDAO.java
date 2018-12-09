package com.hackerrankspring.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hackerrankspring.exceptions.HackerRankException;
import com.hackerrankspring.model.LoginDetails;
import com.hackerrankspring.model.encrypt;
import com.hackerrankspring.util.ConnectionUtil;




public class LoginDAO {
	
	public boolean loginCheck( LoginDetails loginDetails) throws HackerRankException
	{
		boolean flag = false;
		String query = "select password from details where username = ?";
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Connection connObj = null;
		encrypt td= null;
		try{
			td = new encrypt();
			connObj = ConnectionUtil.getConnection();
		pstmt = connObj.prepareStatement(query);
		pstmt.setString(1, loginDetails.getUsername());
		
		result = pstmt.executeQuery();
		if(result.next())
			
			
		{
			String decrypted=result.getString("password");
			if(decrypted.equals(loginDetails.getPassword()))
			flag = true;
		}
		}
		catch(SQLException s)
		{
			s.printStackTrace();
			throw new HackerRankException("connection or query problem" + s);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			throw new HackerRankException("connection or query problem" + e);
			
		}
		finally
		{
			if(result !=  null)
				
			{
				
				try
				{
					result.close();
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new HackerRankException("connection or query problem" + e);
				}
			}
			if(connObj != null)
			{
				
				try
				{
					connObj.close();
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					throw new HackerRankException("connection or query problem" + e);
				}
			}
			
		}
		return flag;
		}

}
