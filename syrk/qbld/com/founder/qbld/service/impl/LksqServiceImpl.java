package com.founder.qbld.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.founder.qbld.bean.Lksqb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.LksqDao;
import com.founder.qbld.service.LksqService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LksqServiceImpl.java]  
 * @ClassName:    [LksqServiceImpl]   
 * @Description:  [临控申请服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:45:56]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:45:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("lksqService")
@Transactional
public class LksqServiceImpl extends BaseService implements LksqService {
	
	@Resource(name = "lksqDao")
	private LksqDao lksqDao;

	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	/**
	 * @Title: queryLksqList
	 * @Description: TODO(临控申请列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryLksqList(EasyUIPage page, Lksqb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "bc_fbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("lksqb", entity);
		List<?> list = lksqDao.queryLksqList(page, map);
		int count = (int) lksqDao.queryLksqListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	/**
	 * @Title: queryLksqListCount
	 * @Description: TODO(临控申请表总数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	@Override
	public long queryLksqListCount(Lksqb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lksqb", entity);
		return lksqDao.queryLksqListCount(map);
	}
	
	/**
	 * @Title: queryCkyj
	 * @Description: TODO(临控申请详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lksqb    返回类型
	 * @throws
	 */
	@Override
	public Lksqb queryLksqb(Lksqb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lksqb", entity);
		return lksqDao.queryLksqb(entity, map);
	}
	
	/**
	 * @Title: saveLkyjxxb
	 * @Description: TODO(临控申请 - 保存临控申请表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveLksqb(Lksqb entity, SessionBean sessionBean) {
		//Xxbkzxbh字段要求210000+YYYYMMDD+8位序列组成编号
		Map<String, Object> map = new HashMap<String, Object>();
		//map放入seqName、position配置序列取值和返回样式
		map.put("seqName", "SEQ_YJ");
		map.put("position", "8");
		String seq = ckyjDao.queryYjSeq(map);
		String head = "210000";
		SimpleDateFormat formats = new SimpleDateFormat("yyyyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String yymmdd = formats.format(cal.getTime());
		String last = head + yymmdd + seq;
		entity.setXxbkzxbh(last);
		String orgcode = sessionBean.getUserOrgCode();
		entity.setYjrdm(orgcode);
		entity.setYjdwdm(orgcode);
		entity.setBc_fbr(sessionBean.getUserName());
		entity.setBc_fbrsfzh(sessionBean.getUserId());
		return lksqDao.saveLksqb(entity);
	}
	
}
