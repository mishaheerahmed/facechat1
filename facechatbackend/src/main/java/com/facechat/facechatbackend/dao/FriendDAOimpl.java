package com.facechat.facechatbackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facechat.facechatbackend.model.Friend;


@Repository("friendDAO")
public class FriendDAOimpl implements FriendDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	

	public FriendDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;

	}

	
	@Transactional
	public List<Friend> getAllFriendRequest(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname");
		query.setParameter("uname", username);
		List<Friend> listfriends=query.list();
		return listfriends;
	}

	@Override
	public List<Friend> getApprovedFriends(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname and status='A'");
		query.setParameter("uname", username);
		List<Friend> listfriends=query.list();
		return listfriends;
	}




	@Override
	public boolean createFriend(com.facechat.facechatbackend.model.Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			return false;
		}
		}


	@Override
	public Friend getFriend(int friendId) {
		Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class, friendId);
		return friend;

	}


	@Override
	public boolean rejectFriendRequest(com.facechat.facechatbackend.model.Friend friend) {
		try
		{
			friend.setStatus("R");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}	}


	@Override
	public boolean approveFriendRequest(com.facechat.facechatbackend.model.Friend friend) {
		try
		{
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised"+e);
			return false;
		}
			}


}//class close
