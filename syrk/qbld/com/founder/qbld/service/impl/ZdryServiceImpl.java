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
import com.founder.qbld.bean.Clxxb;
import com.founder.qbld.bean.Saxxb;
import com.founder.qbld.bean.Shgxrb;
import com.founder.qbld.bean.Zdjlb;
import com.founder.qbld.bean.ZdryGxbg;
import com.founder.qbld.bean.ZdrySdFd;
import com.founder.qbld.bean.ZdrySdXd;
import com.founder.qbld.bean.ZdrySdZd;
import com.founder.qbld.bean.ZdrySf;
import com.founder.qbld.bean.ZdrySw;
import com.founder.qbld.bean.ZdryZdxsfzqk;
import com.founder.qbld.bean.ZdryZszhjsb;
import com.founder.qbld.bean.ZdryZt;
import com.founder.qbld.bean.Zdryb;
import com.founder.qbld.bean.Zsjlb;
import com.founder.qbld.dao.ZdryDao;
import com.founder.qbld.service.ZdryService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.ZdryServiceImpl.java]  
 * @ClassName:    [ZdryServiceImpl]   
 * @Description:  [重点人员服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:45:56]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:45:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryService")
@Transactional
public class ZdryServiceImpl extends BaseService implements ZdryService {
	
	@Resource(name = "zdryDao")
	private ZdryDao zdryDao;

	@Override
	public EasyUIPage queryZdryList(EasyUIPage page, Zdryb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdryList(page, map);
		int count = (int) zdryDao.queryZdryListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Zdryb queryZdryb(Zdryb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryb(map);
	}
	
	@Override
	public String saveZdryb(Zdryb entity) {
		return zdryDao.saveZdryb(entity);
	}
	
	@Override
	public int updateZdryxxb(String sfzh) {
		Zdryb entity = new Zdryb();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setXssj(now);
		entity.setSfzh(sfzh);
		return zdryDao.updateZdryxxb(entity);
	}
	
	@Override
	public EasyUIPage queryZdryZtList(EasyUIPage page, ZdryZt entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdryZtList(page, map);
		int count = (int) zdryDao.queryZdryZtListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdryZt queryZdryZtb(ZdryZt entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZtb(map);
	}
	
	@Override
	public String saveZdryZtb(ZdryZt entity) {
		return zdryDao.saveZdryZtb(entity);
	}
	
	@Override
	public EasyUIPage queryZdrySwList(EasyUIPage page, ZdrySw entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdrySwList(page, map);
		int count = (int) zdryDao.queryZdrySwListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdrySw queryZdrySwb(ZdrySw entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySwb(map);
	}
	
	@Override
	public String saveZdrySwb(ZdrySw entity) {
		return zdryDao.saveZdrySwb(entity);
	}
	
	@Override
	public EasyUIPage queryZdryZszhjsbList(EasyUIPage page, ZdryZszhjsb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdryZszhjsbList(page, map);
		int count = (int) zdryDao.queryZdryZszhjsbListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdryZszhjsb queryZdryZszhjsb(ZdryZszhjsb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZszhjsb(map);
	}
	
	@Override
	public String saveZdryZszhjsb(ZdryZszhjsb entity) {
		return zdryDao.saveZdryZszhjsb(entity);
	}
	
	@Override
	public EasyUIPage queryZdryZdxsfzqkList(EasyUIPage page, ZdryZdxsfzqk entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdryZdxsfzqkList(page, map);
		int count = (int) zdryDao.queryZdryZdxsfzqkListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdryZdxsfzqk queryZdryZdxsfzqk(ZdryZdxsfzqk entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZdxsfzqk(map);
	}
	
	@Override
	public String saveZdryZdxsfzqk(ZdryZdxsfzqk entity) {
		return zdryDao.saveZdryZdxsfzqk(entity);
	}
	
	@Override
	public EasyUIPage queryZdrySfList(EasyUIPage page, ZdrySf entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdrySfList(page, map);
		int count = (int) zdryDao.queryZdrySfListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdrySf queryZdrySf(ZdrySf entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySf(map);
	}
	
	@Override
	public String saveZdrySf(ZdrySf entity) {
		return zdryDao.saveZdrySf(entity);
	}
	
	@Override
	public EasyUIPage queryZdrySdFdList(EasyUIPage page, ZdrySdFd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdrySdFdList(page, map);
		int count = (int) zdryDao.queryZdrySdFdListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdrySdFd queryZdrySdFd(ZdrySdFd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdFd(map);
	}
	
	@Override
	public String saveZdrySdFd(ZdrySdFd entity) {
		return zdryDao.saveZdrySdFd(entity);
	}
	
	@Override
	public EasyUIPage queryZdrySdXdList(EasyUIPage page, ZdrySdXd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdrySdXdList(page, map);
		int count = (int) zdryDao.queryZdrySdXdListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdrySdXd queryZdrySdXd(ZdrySdXd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdXd(map);
	}
	
	@Override
	public String saveZdrySdXd(ZdrySdXd entity) {
		return zdryDao.saveZdrySdXd(entity);
	}
	
	@Override
	public EasyUIPage queryZdrySdZdList(EasyUIPage page, ZdrySdZd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdrySdZdList(page, map);
		int count = (int) zdryDao.queryZdrySdZdListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public ZdrySdZd queryZdrySdZd(ZdrySdZd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdZd(map);
	}
	
	@Override
	public String saveZdrySdZd(ZdrySdZd entity) {
		return zdryDao.saveZdrySdZd(entity);
	}
	
	@Override
	public EasyUIPage queryShgxrList(EasyUIPage page, Shgxrb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryShgxrList(page, map);
		int count = (int) zdryDao.queryShgxrListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Shgxrb queryShgxr(Shgxrb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryShgxr(map);
	}
	
	@Override
	public String saveShgxr(Shgxrb entity) {
		return zdryDao.saveShgxr(entity);
	}
	
	@Override
	public EasyUIPage querySaxxList(EasyUIPage page, Saxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.querySaxxList(page, map);
		int count = (int) zdryDao.querySaxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Saxxb querySaxx(Saxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.querySaxx(map);
	}
	
	@Override
	public String saveSaxx(Saxxb entity) {
		return zdryDao.saveSaxx(entity);
	}
	
	@Override
	public EasyUIPage queryClxxList(EasyUIPage page, Clxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryClxxList(page, map);
		int count = (int) zdryDao.queryClxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Clxxb queryClxx(Clxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryClxx(map);
	}
	
	@Override
	public String saveClxx(Clxxb entity) {
		return zdryDao.saveClxx(entity);
	}
	
	@Override
	public EasyUIPage queryZdjlList(EasyUIPage page, Zdjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZdjlList(page, map);
		int count = (int) zdryDao.queryZdjlListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Zdjlb queryZdjl(Zdjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdjl(map);
	}
	
	@Override
	public String saveZdjl(Zdjlb entity) {
		return zdryDao.saveZdjl(entity);
	}
	
	@Override
	public EasyUIPage queryZsjlList(EasyUIPage page, Zsjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryZsjlList(page, map);
		int count = (int) zdryDao.queryZsjlListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public Zsjlb queryZsjl(Zsjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZsjl(map);
	}
	
	@Override
	public String saveZsjl(Zsjlb entity) {
		return zdryDao.saveZsjl(entity);
	}
	
	@Override
	public EasyUIPage queryGxbgList(EasyUIPage page, ZdryGxbg entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryb", entity);
		List<?> list = zdryDao.queryGxbgList(page, map);
		int count = (int) zdryDao.queryGxbgListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	@Override
	public String updateGxbg(ZdryGxbg entity) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setXgsj(nowStr);
		return zdryDao.updateGxdw(entity);
	}
}
