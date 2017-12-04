package com.facechat.facechatbackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.facechat.facechatbackend.dao.BlogDAO;
import com.facechat.facechatbackend.dao.JobDAO;
import com.facechat.facechatbackend.model.Job;


public class JobDAOTest {

	static JobDAO jobDAO;
	


	@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.facechat.facechatbackend");
			context.refresh();
			
			jobDAO=(JobDAO)context.getBean("jobDAO");
		}
@Test
public  void addJobTest() {
Job job = new Job();
job.setJobId(1000);
job.setJobdate("22dec2011");
job.setJobprofile("be");
job.setPostdate(new java.util.Date());
job.setQualification("be");
job.setStatus("A");
assertEquals("Failed to add!",true,jobDAO.addJob(job));
} 

@Ignore
@Test
public void updateJobTest(){
//Blog blog = (Blog)blogDAO.getBlog(1);
Job job=(Job)jobDAO.getJob(1);
    job.setQualification("software engineer");
assertTrue("Problem in updation",jobDAO.updateJob(job));
}
}
