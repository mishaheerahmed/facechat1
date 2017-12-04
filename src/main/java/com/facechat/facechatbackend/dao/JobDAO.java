package com.facechat.facechatbackend.dao;

import com.facechat.facechatbackend.model.Job;

public interface JobDAO {

public boolean addJob(Job job);
public boolean updateJob(Job job);
public boolean deleteJob(Job job);
public Job getJob(int jobId);
}
