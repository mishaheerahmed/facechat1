package com.facechat.facechatbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friend
{
@Id
@GeneratedValue
int friendId;

String username;
String friendname;
String status;

public int getFriendId()
{
	return friendId;
}
public void setFriendId(int friendId)
{
	this.friendId = friendId;
}
public String getUsername() 
{
	return username;
}
public void setUsername(String username)
{
	this.username = username;
}
public String getFriendname() 
{
	return friendname;
}
public void setFriendname(String friendname) 
{
	this.friendname = friendname;
}
public String getStatus()
{
	return status;
}
public void setStatus(String status)
{
	this.status = status;
}


}
