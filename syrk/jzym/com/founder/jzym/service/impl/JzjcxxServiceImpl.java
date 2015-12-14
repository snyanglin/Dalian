package com.founder.jzym.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.utils.EasyUIPage;
import com.founder.jzym.dao.JzjcxxDao;
import com.founder.jzym.service.JzjcxxService;
import com.founder.xjpt.vo.ZzjgVo;
import com.founder.jzym.bean.Ryjzdzzb;
import com.founder.xjpt.bean.Zdryjbxxb;

@Service("jzjcxxService")
public class JzjcxxServiceImpl implements JzjcxxService {

	@Resource(name = "jzjcxxDao")
	private JzjcxxDao jzjcxxDao;

	/**
	 * @Title: queryJcxx
	 * @描述: 查询基础信息
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryJcxx(Map<String, Object> params) {
		return jzjcxxDao.queryJcxx(params);
	}

	public EasyUIPage querySyrkList(EasyUIPage page, Ryjzdzzb entity, Long count) {
		return jzjcxxDao.querySyrkList(page, entity, count);
	}
	
	public EasyUIPage queryZdryList(EasyUIPage page, Zdryjbxxb entity, Long count) {
		return jzjcxxDao.queryZdryList(page, entity, count);
	}
}
