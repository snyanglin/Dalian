package com.founder.qbld.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.XxfbArticle;
import com.founder.qbld.bean.XxfbClass;
import com.founder.qbld.dao.XxfbDao;
import com.founder.qbld.service.XxfbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.XxfbServiceImpl.java]  
 * @ClassName:    [lksqService]   
 * @Description:  [信息发布服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 下午2:32:39]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 下午2:32:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("xxfbService")
@Transactional
public class XxfbServiceImpl extends BaseService implements XxfbService {
	
	@Resource(name = "xxfbDao")
	private XxfbDao xxfbDao;

	/**
	 * @Title: queryClassList
	 * @Description: TODO(信息发布类型列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryClassList(EasyUIPage page, XxfbClass entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "tjsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xxfb", entity);
		List<?> list = xxfbDao.queryClassList(page, map);
		page.setRows(list);		
		return page;
	}
	
	/**
	 * @Title: queryArticleList
	 * @Description: TODO(信息发布内容列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryArticleList(EasyUIPage page, XxfbArticle entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "createtime";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xxfb", entity);
		List<?> list = xxfbDao.queryArticleList(page, map);
		int count = (int) xxfbDao.queryArticleCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	/**
	 * @Title: queryArticleListFive
	 * @Description: TODO(信息发布内容列表5条查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryArticleListFive(EasyUIPage page, XxfbArticle entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", 0);
		map.put("end", 5);
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "createtime";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xxfb", entity);
		List<?> list = xxfbDao.queryArticleList(page, map);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: queryArticle
	 * @Description: TODO(信息发布内容详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return XxfbArticle    返回类型
	 * @throws
	 */
	@Override
	public XxfbArticle queryArticle(XxfbArticle entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xxfb", entity);
		return xxfbDao.queryArticle(entity, map);
	}
	
}
