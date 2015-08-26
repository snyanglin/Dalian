package com.founder.service.memcached;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc-servlet.xml")
public class MemCachedManagerJunit {
	Logger logger = Logger.getLogger(getClass());

	@Test
	@Transactional(propagation=Propagation.SUPPORTS)
	public void test() {
		MemCachedManager cache = MemCachedManager.getInstance();
		cache.set("lee", "my name is limaolin" , 1);
		cache.flushAll();
		//cache.delete("lee");
		System.out.print("get value : " + cache.get("lee"));
	}
}
