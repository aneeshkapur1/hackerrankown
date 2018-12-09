package com.hackerrankspring.controller;



import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hackerrankspring.exceptions.HackerRankException;
import com.hackerrankspring.model.HackerRankRegister;
import com.hackerrankspring.model.LoginDetails;
import com.hackerrankspring.model.encrypt;
import com.hackerrankspring.service.HackerRankRegisterService;
import com.hackerrankspring.service.LoginDetailsService;
import com.hackerrankspring.util.ConnectionUtil;

@ComponentScan({"com.hackerrankspring"})
@Controller
public class TestController {

	public TestController() {
	
		
	}
	
	@GetMapping("/home")
	public String home(){
		System.out.println("Home");
		return "HackerRank";
		
	}
	
	@PostMapping("/loginController")
	public ModelAndView login(LoginDetails loginDetails, LoginDetailsService loginDetailsService) 
	{
		String view="Success";
		ModelAndView mav=null;
		
		boolean check = false;
		
		try 
		{
			check = loginDetailsService.loginCheck(loginDetails);
			if(check)
			{
				
				
				
				 mav=new ModelAndView(view);
				mav.addObject("user",loginDetails);
				
				
				
		 	}
			else 
			{
				
				view = "HackerRank";
				mav=new ModelAndView(view);
				mav.addObject("error","error Login");
				
			}
		}catch(HackerRankException h) 
		{
			h.printStackTrace();
		}
		return mav;
		
	}

	@PostMapping("/Register")
	public ModelAndView Register(@RequestParam("pass1") String target, @RequestParam("user1") String user1, @RequestParam("email") String email, HackerRankRegisterService hackerRankRegisterService) 
	{
		
		ModelAndView mav= new ModelAndView();
		Connection connObj = null;
		String page = "";
		encrypt td= null;
		try 
		{
			td = new encrypt();
			
		 	String encrypted=td.encryptpass(target);
		 	connObj = ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
		HackerRankRegister hackerRankRegister = new HackerRankRegister(user1,encrypted,email);
		int userId = hackerRankRegisterService.registerUser(connObj, hackerRankRegister);
		hackerRankRegister.setUserId(userId);
		if(userId != 0)
		{
			System.out.println("Your EMployee Id is" + userId);
			System.out.println("Please Remember for future");
			page = "Register";
			mav.setViewName(page);
			
		}
		else 
		{
			
			page = "HackerRank";
			mav.setViewName(page);
			mav.addObject("error","error registering");
		}
		connObj.commit();
		}catch(SQLException s)
		{
			try {
				connObj.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.printStackTrace();
		} catch (HackerRankException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.addObject("error", "error registering try again");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(connObj != null)
				{
					connObj.close();
				}
				
			}catch(SQLException s)
			{
				s.printStackTrace();
			}
		}
		
		
	return mav;	
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession(true).invalidate();
		
		return "HackerRank";
		
	}
	
}
