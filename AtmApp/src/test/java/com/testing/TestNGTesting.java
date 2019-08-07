package com.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.srikanth.Dao.Impl.CustomerDaoImplimentation;

@Test
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestNGTesting extends AbstractTestNGSpringContextTests{
	
	@Autowired
	CustomerDaoImplimentation dao;
	
	@Test
	public void testDaoObj() {
		System.out.println("dao obj = "+dao);
	}

}
