package com.founder.xlff.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.xlff.bean.Fkzl;
import com.founder.xlff.bean.Zlqsfk;
import com.founder.xlff.dao.ZlxfDao;
import com.founder.xlff.service.ZlxfService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zlxf.service.impl.ZlxfServiceImpl.java]  
 * @ClassName:    [ZlxfServiceImpl]   
 * @Description:  [指令下发服务实现]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-24 上午10:19:36]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 上午10:19:36，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zlxfService")
@Transactional
public class ZlxfServiceImpl extends BaseService implements ZlxfService {
	
	@Resource(name = "zlxfDao")
	private ZlxfDao zlxfDao;

	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(指令下发查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zlxf    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryZlxfList(EasyUIPage page, Fkzl entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		// 默认排序
		if (StringUtils.isBlank(sort)) { 
			sort = "xfsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zlxf", entity);
		List<?> list = zlxfDao.queryZlxfList(page, map);
		int count = (int) zlxfDao.queryZlxfCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	/**
	 * @Title: saveZlxf
	 * @Description: TODO(保存指令下发)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZlxf(Fkzl entity) {
		entity.setId(UUID.create());
		return zlxfDao.saveZlxf(entity);
	}
	
	/**
	 * @Title: saveFkzlqsfk
	 * @Description: TODO(批量保存指令签收反馈数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveFkzlqsfk(Fkzl entity, SessionBean sessionBean) {
		List<Zlqsfk> list = new ArrayList<Zlqsfk>();
		String xfdwdm[] = entity.getXfdwdm().split(",");
		String xfdwmc[] = entity.getXfdwmc().split(",");
		//装配入库的bean
		Zlqsfk entitys;
		for (int i = 0; i < xfdwdm.length; i++) {
			entitys = new Zlqsfk();
			entitys.setId(UUID.create());
			entitys.setFkzlid(StringUtils.nullToStr(entity.getId()));
			entitys.setXfdwdm(StringUtils.nullToStr(xfdwdm[i]));
			entitys.setXfdwmc(StringUtils.nullToStr(xfdwmc[i]));
			list.add(entitys);
		}
		return zlxfDao.saveFkzlqsfk(list);
	}
	
	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(指令下发查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zlxf    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryZlqsfkList(EasyUIPage page, Fkzl entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		// 默认排序
		if (StringUtils.isBlank(sort)) { 
			sort = "xfsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zlxf", entity);
		List<?> list = zlxfDao.queryZlqsfkList(page, map);
		int count = (int) zlxfDao.queryZlqsfkCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	/**
	 * @Title: updateZlqsfk
	 * @Description: TODO(更新指令签收反馈数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String updateZlqsfk(Zlqsfk entity) {
		return zlxfDao.updateZlqsfk(entity);
	}
}
