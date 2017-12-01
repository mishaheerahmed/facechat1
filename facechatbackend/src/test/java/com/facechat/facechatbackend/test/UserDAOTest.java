package com.facechat.facechatbackend.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.facechat.facechatbackend.dao.UserDAO;
import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.UserDetail;




public class UserDAOTest {
  
	static UserDAO userDAO;
	


	@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.facechat.facechatbackend");
			context.refresh();
			
			userDAO=(UserDAO)context.getBean("userDAO");
		}

	@Test
	public void addTest()
	{
		UserDetail user=new UserDetail();		
		user.setUserName("abc");
		user.setRole("user");
		user.setEmailId("abc@gmail.com");
		user.setIsOnline("N");
		user.setPassword("aabb");	
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
		
		System.out.println("check1");
		System.out.println("userdao");
	
		System.out.println("check2");
		System.out.println("EmailID:"+user.getEmailId());
		System.out.println("UserName:"+user.getUserName());
	}





}