package com.facechat.facechatbackend.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
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
@Ignore
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


	@Test
	public void getAllUser()
	{
		List<UserDetail> userList=(List<UserDetail>)userDAO.getAllUsers();
		assertNotNull("User not found",userList.get(0));
		for(UserDetail user:userList)
		{
			System.out.println("User Id:"+ user.getUserId()+":::"+ "User Name"+user.getUserName());
		}
		
	}
@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetail user=(UserDetail)userDAO.getUser(1001);
		assertTrue("Problem in deletion", userDAO.deleteUser(user));
	}

@Ignore	
	@Test
	public void UpdateUserTest()
	{
		UserDetail user=(UserDetail)userDAO.getUser(2);
		user.setUserName("Shaheer");
		user.setEmailId("shaheerahmed@gmsil.com");
		assertTrue("Problem in updating", userDAO.updateUser(user));
	}

	
	@Test 
	public void setOnlineStatus()
	{
		UserDetail user=(UserDetail)userDAO.getUser(2);
		assertTrue("Problem in Updating", userDAO.updateOnlineStatus("Y", user));
		
		}

	
}