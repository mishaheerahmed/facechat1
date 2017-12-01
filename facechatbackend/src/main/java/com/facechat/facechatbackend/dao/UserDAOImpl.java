package com.facechat.facechatbackend.dao;

import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.UserDetail;

@Repository("userDAO")
public class UserDAOImpl  implements UserDAO{
    
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean addUser(UserDetail user) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
   
	//@Override
	public boolean updateOnlineStatus(String status, UserDetail user) {
			return false;
	}

	
}
