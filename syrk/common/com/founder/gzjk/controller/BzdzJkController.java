package com.founder.gzjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.framework.base.controller.BaseController;
import com.founder.gzjk.romcache.BzdzRamCache;
import com.founder.gzjk.vo.GzjkBzdz;
/**
 * 标准地址任务监控接口
 * @author Administrator
 *
 */
@Controller
public class BzdzJkController extends BaseController {
	
	@Autowired
	private BzdzRamCache bzdzRamCache;

	@RequestMapping("/dzjk")
	public void service(GzjkBzdz dz){
		bzdzRamCache.addGzjkList(dz.getId(),dz.getBdlx());
	}
}
