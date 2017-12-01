package com.facechat.facechatbackend.dao;

import org.springframework.stereotype.Service;

import com.facechat.facechatbackend.model.UserDetail;

//import java.util.List;


@Service
public interface UserDAO {

   public boolean addUser(UserDetail user);
   public boolean updateOnlineStatus(String status,UserDetail user);
	 //boolean saveUser(User user);
}
