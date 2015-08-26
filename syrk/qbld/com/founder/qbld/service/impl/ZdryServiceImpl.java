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

	/**
	 * @Title: queryZdryList
	 * @Description: TODO(重点人员列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdryb
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdryb    返回类型
	 * @throws
	 */
	@Override
	public Zdryb queryZdryb(Zdryb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryb(map);
	}
	
	/**
	 * @Title: saveZdryb
	 * @Description: TODO(重点人员 - 保存重点人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdryb(Zdryb entity) {
		return zdryDao.saveZdryb(entity);
	}
	
	/**
	 * @Title: updateZdryxxb
	 * @Description: TODO(更新重点人员)
	 * @param @param qsfkzt
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdryZtList
	 * @Description: TODO(重点人员在逃列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdryZtb
	 * @Description: TODO(重点人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZt    返回类型
	 * @throws
	 */
	@Override
	public ZdryZt queryZdryZtb(ZdryZt entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZtb(map);
	}
	
	/**
	 * @Title: saveZdryZtb
	 * @Description: TODO(重点人员 - 保存在逃人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdryZtb(ZdryZt entity) {
		return zdryDao.saveZdryZtb(entity);
	}
	
	/**
	 * @Title: saveZdryZtb
	 * @Description: TODO(重点人员 - 保存在逃人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdrySwb
	 * @Description: TODO(重点涉稳人员详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySw    返回类型
	 * @throws
	 */
	@Override
	public ZdrySw queryZdrySwb(ZdrySw entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySwb(map);
	}
	
	/**
	 * @Title: saveZdrySwb
	 * @Description: TODO(重点人员 - 保存涉稳人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdrySwb(ZdrySw entity) {
		return zdryDao.saveZdrySwb(entity);
	}
	
	/**
	 * @Title: queryZdryZszhjsbList
	 * @Description: TODO(肇事肇祸精神病表列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdryZszhjsbb
	 * @Description: TODO(肇事肇祸精神病表详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZszhjsb    返回类型
	 * @throws
	 */
	@Override
	public ZdryZszhjsb queryZdryZszhjsb(ZdryZszhjsb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZszhjsb(map);
	}
	
	/**
	 * @Title: saveZdryZszhjsbb
	 * @Description: TODO(重点人员 - 保存肇事肇祸精神病人员表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdryZszhjsb(ZdryZszhjsb entity) {
		return zdryDao.saveZdryZszhjsb(entity);
	}
	
	/**
	 * @Title: queryZdryZdxsfzqkList
	 * @Description: TODO(重大刑事犯罪前科查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdryZdxsfzqkb
	 * @Description: TODO(重大刑事犯罪前科详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdryZdxsfzqk    返回类型
	 * @throws
	 */
	@Override
	public ZdryZdxsfzqk queryZdryZdxsfzqk(ZdryZdxsfzqk entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdryZdxsfzqk(map);
	}
	
	/**
	 * @Title: saveZdryZdxsfzqkb
	 * @Description: TODO(重点人员 - 保存重大刑事犯罪前科)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdryZdxsfzqk(ZdryZdxsfzqk entity) {
		return zdryDao.saveZdryZdxsfzqk(entity);
	}
	
	/**
	 * @Title: queryZdrySfList
	 * @Description: TODO(涉访查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdrySf
	 * @Description: TODO(涉访详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySf    返回类型
	 * @throws
	 */
	@Override
	public ZdrySf queryZdrySf(ZdrySf entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySf(map);
	}
	
	/**
	 * @Title: saveZdrySf
	 * @Description: TODO(重点人员 - 保存涉访)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdrySf(ZdrySf entity) {
		return zdryDao.saveZdrySf(entity);
	}
	
	/**
	 * @Title: queryZdrySdFdList
	 * @Description: TODO(贩毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdrySdFdb
	 * @Description: TODO(贩毒详情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdFd    返回类型
	 * @throws
	 */
	@Override
	public ZdrySdFd queryZdrySdFd(ZdrySdFd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdFd(map);
	}
	
	/**
	 * @Title: saveZdrySdFd
	 * @Description: TODO(重点人员 - 保存贩毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdrySdFd(ZdrySdFd entity) {
		return zdryDao.saveZdrySdFd(entity);
	}
	
	/**
	 * @Title: queryZdrySdXdList
	 * @Description: TODO(吸毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdrySdXd
	 * @Description: TODO(制毒情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdXd    返回类型
	 * @throws
	 */
	@Override
	public ZdrySdXd queryZdrySdXd(ZdrySdXd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdXd(map);
	}
	
	/**
	 * @Title: saveZdrySdXdb
	 * @Description: TODO(重点人员 - 保存吸毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdrySdXd(ZdrySdXd entity) {
		return zdryDao.saveZdrySdXd(entity);
	}
	
	/**
	 * @Title: queryZdryZdxsfzqkList
	 * @Description: TODO(制毒查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdrySdZd
	 * @Description: TODO(制毒情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZdrySdZd    返回类型
	 * @throws
	 */
	@Override
	public ZdrySdZd queryZdrySdZd(ZdrySdZd entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdrySdZd(map);
	}
	
	/**
	 * @Title: saveZdrySdZd
	 * @Description: TODO(重点人员 - 保存制毒)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdrySdZd(ZdrySdZd entity) {
		return zdryDao.saveZdrySdZd(entity);
	}
	
	/**
	 * @Title: queryShgxrList
	 * @Description: TODO(社会关系人查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryShgxr
	 * @Description: TODO(社会关系人情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Shgxr    返回类型
	 * @throws
	 */
	@Override
	public Shgxrb queryShgxr(Shgxrb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryShgxr(map);
	}

	/**
	 * @Title: saveShgxr
	 * @Description: TODO(重点人员 - 保存社会关系人)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveShgxr(Shgxrb entity) {
		return zdryDao.saveShgxr(entity);
	}
	
	/**
	 * @Title: querySaxxList
	 * @Description: TODO(涉案查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: querySaxx
	 * @Description: TODO(涉案情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Saxx    返回类型
	 * @throws
	 */
	@Override
	public Saxxb querySaxx(Saxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.querySaxx(map);
	}
	
	/**
	 * @Title: saveSaxx
	 * @Description: TODO(重点人员 - 保存涉案)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveSaxx(Saxxb entity) {
		return zdryDao.saveSaxx(entity);
	}
	
	/**
	 * @Title: queryClxxList
	 * @Description: TODO(车辆查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryClxx
	 * @Description: TODO(车辆查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Clxx    返回类型
	 * @throws
	 */
	@Override
	public Clxxb queryClxx(Clxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryClxx(map);
	}
	
	/**
	 * @Title: saveClxx
	 * @Description: TODO(重点人员 - 保存车辆)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveClxx(Clxxb entity) {
		return zdryDao.saveClxx(entity);
	}
	
	/**
	 * @Title: queryZdjlList
	 * @Description: TODO(诊断查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZdjl
	 * @Description: TODO(诊断情查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zdjl    返回类型
	 * @throws
	 */
	@Override
	public Zdjlb queryZdjl(Zdjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZdjl(map);
	}
	
	/**
	 * @Title: saveZdjlb
	 * @Description: TODO(重点人员 - 保存诊断)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZdjl(Zdjlb entity) {
		return zdryDao.saveZdjl(entity);
	}
	
	/**
	 * @Title: queryZsjlList
	 * @Description: TODO(肇事肇祸查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: queryZsjl
	 * @Description: TODO(肇事肇祸查询服务)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zsjl    返回类型
	 * @throws
	 */
	@Override
	public Zsjlb queryZsjl(Zsjlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryb", entity);
		return zdryDao.queryZsjl(map);
	}
	
	/**
	 * @Title: saveZsjl
	 * @Description: TODO(重点人员 - 保存肇事肇祸)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveZsjl(Zsjlb entity) {
		return zdryDao.saveZsjl(entity);
	}
	
	/**
	 * @Title: queryGxbgList
	 * @Description: TODO(重点人员管辖变更 )
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * @Title: updateGxbg
	 * @Description: TODO(变更管辖单位)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String updateGxbg(ZdryGxbg entity) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setXgsj(nowStr);
		return zdryDao.updateGxdw(entity);
	}
}
