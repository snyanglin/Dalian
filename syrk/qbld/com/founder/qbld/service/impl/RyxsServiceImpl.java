package com.founder.qbld.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.Ryxsb;
import com.founder.qbld.dao.RyxsDao;
import com.founder.qbld.service.RyxsService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.ryxsServiceImpl.java]  
 * @ClassName:    [ryxsServiceImpl]   
 * @Description:  [人员写实服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryxsService")
@Transactional
public class RyxsServiceImpl extends BaseService implements RyxsService {
	
	@Resource(name = "ryxsDao")
	private RyxsDao ryxsDao;

	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryRyxsList(EasyUIPage page, Ryxsb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "cjsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xscjb", entity);
		List<?> list = ryxsDao.queryRyxsList(page, map);
		int count = (int) ryxsDao.queryRyxsListCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	/**
	 * @Title: queryRyxs
	 * @Description: TODO(根据id获取人员写实详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ryxsb    返回类型
	 * @throws
	 */
	@Override
	public Ryxsb queryRyxs(Ryxsb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryxsb", entity);
		return ryxsDao.queryRyxs(map);
	}

	/**
	 * @Title: saveRyxsb
	 * @Description: TODO(人员写实表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveRyxsb(Ryxsb entity) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setCjsj(nowStr);
		return ryxsDao.saveRyxsb(entity);
	}
	
}
