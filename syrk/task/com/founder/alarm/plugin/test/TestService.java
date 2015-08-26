package com.founder.alarm.plugin.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.founder.alarm.BaseDock;
import com.founder.alarm.Docking;

@Service()
public class TestService extends BaseDock implements Docking {
	
//	@Autowired
//	private TestDao testDao;
	
	@Override
	public Map<String,Object> main(HttpServletRequest request) {
//		Map<String,Object> result = new HashMap<String, Object>();
		result.put("message", "TEST执行成功");
		result.put("status", true);
		return result;
	}

}
