package com.founder.jzym.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xjpt.vo.ZzjgVo;
import com.founder.jzym.bean.Ryjzdzzb;
import com.founder.xjpt.bean.Zdryjbxxb;

@TypeAnnotation("局长基础信息")
public interface JzjcxxService {

	/**
	 * @Title: queryJcxx
	 * @描述: 查询基础信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryJcxx(Map<String, Object> params);

	public EasyUIPage querySyrkList(EasyUIPage page, Ryjzdzzb entity, Long count);

	public EasyUIPage queryZdryList(EasyUIPage page, Zdryjbxxb entity, Long count);
}
