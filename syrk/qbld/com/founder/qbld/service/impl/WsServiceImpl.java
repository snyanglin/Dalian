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
import com.founder.qbld.bean.WsRecord;
import com.founder.qbld.dao.WsDao;
import com.founder.qbld.service.WsService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.WsServiceImpl.java]  
 * @ClassName:    [WsServiceImpl]   
 * @Description:  [临控申请服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:45:56]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:45:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("wsService")
@Transactional
public class WsServiceImpl extends BaseService implements WsService {
	
	@Resource(name = "wsDao")
	private WsDao wsDao;

	/**
	 * @Title: queryWsList
	 * @Description: TODO(ws记录表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryWsList(EasyUIPage page, WsRecord entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "sys";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("WsRecord", entity);
		List<?> list = wsDao.queryWsList(page, map);
		int count = (int) wsDao.queryWsListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: queryWsListCount
	 * @Description: TODO(临控申请表总数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	@Override
	public long queryWsListCount(WsRecord entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("WsRecord", entity);
		return wsDao.queryWsListCount(map);
	}
	
}
