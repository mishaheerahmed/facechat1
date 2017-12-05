package com.facechat.facechatbackend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facechat.facechatbackend.model.Blog;
import com.facechat.facechatbackend.model.UserDetail;

//import java.util.List;


@Service
public interface UserDAO {

   public boolean addUser(UserDetail user);
   public boolean updateOnlineStatus(String status,UserDetail user);
   public boolean updateUser(UserDetail user);
public List<UserDetail> getAllUsers();
public UserDetail getUser(int userId);
public boolean deleteUser(UserDetail user);
}
