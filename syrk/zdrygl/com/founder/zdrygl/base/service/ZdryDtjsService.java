package com.founder.zdrygl.base.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryDtjsClxxb;
import com.founder.zdrygl.base.model.ZdryDtjsGxbgxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSaxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSfxxb;
import com.founder.zdrygl.base.model.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSwxxb;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZszhjlxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.base.model.ZdryDtjsZtxxb;
import com.founder.zdrygl.core.dao.ZdryDtjsSxDao;
import com.founder.zdrygl.core.dao.ZdryDtjsXsDao;


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
@Service("zdryDtjsService")
@Transactional
public class ZdryDtjsService extends BaseService {
	
	@Resource(name = "zdryDtjsXsDao")
	private ZdryDtjsXsDao zdryDtjsXsDao;

	@Resource(name = "zdryDtjsSxDao")
	private ZdryDtjsSxDao zdryDtjsSxDao;
	
	public EasyUIPage queryRyxsList(EasyUIPage page, ZdryDtjsXsxxb entity) {
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
		map.put("zdryDtjsXsxxb", entity);
		List<?> list = zdryDtjsXsDao.queryRyxsList(page, map);
		int count = (int) zdryDtjsXsDao.queryRyxsListCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}		

	
	public String saveDtjs(ZdryDtjsXsxxb entity) {		
		entity.setCjsj(gerNowDateTimeStr());
		return zdryDtjsXsDao.saveRyxsb(entity);
	}
	
	
	public void saveZtxxb(ZdryDtjsZtxxb entity){
		entity.setTxrq(gerNowDateTimeStr());
		zdryDtjsSxDao.saveZtxxb(entity);		
	}
	
	public void saveSwxxb(ZdryDtjsSwxxb entity){
		entity.setTxrq(gerNowDateTimeStr());
		zdryDtjsSxDao.saveSwxxb(entity);	
	}
	
	public void saveSfxxb(ZdryDtjsSfxxb entity){
		entity.setTjsj(gerNowDateTimeStr());
		zdryDtjsSxDao.saveSfxxb(entity);	
	}
	
	public void saveSdxdxxb(ZdryDtjsSdxdxxb entity){
		entity.setCjsj(gerNowDateTimeStr());
		zdryDtjsSxDao.saveSdxdxxb(entity);	
	}
	
	public void saveSdfdxxb(ZdryDtjsSdfdxxb entity){
		entity.setCjsj(gerNowDateTimeStr());
		zdryDtjsSxDao.saveSdfdxxb(entity);	
	}
	
	public void saveSdzdxxb(ZdryDtjsSdzdxxb entity){
		zdryDtjsSxDao.saveSdzdxxb(entity);	
	}
	
	public void saveZdxsfzqkxxb(ZdryDtjsZdxsfzqkxxb entity){
		zdryDtjsSxDao.saveZdxsfzqkxxb(entity);	
	}
	
	public void saveZszhjsbrxxb(ZdryDtjsZszhjsbrxxb entity){
		entity.setXxbh(String.valueOf(new Date().getTime()));//如果由页面生成，在点击历史数据后修改，再保存，可能会重复，因此改为后台生成。
		zdryDtjsSxDao.saveZszhjsbrxxb(entity);	
	}
	
	public void saveZszhjsbrZdjlxxb(ZdryDtjsZszhjsbrZdjlxxb entity){
		entity.setTjsj(gerNowDateTimeStr());
		zdryDtjsSxDao.saveZszhjsbrZdjlxxb(entity);	
	}
	
	public void saveZszhjsbrZszhjlxxb(ZdryDtjsZszhjsbrZszhjlxxb entity){
		entity.setTjsj(gerNowDateTimeStr());
		zdryDtjsSxDao.saveZszhjsbrZszhjlxxb(entity);	
	}
	
	
	public void updateGxbg(ZdryDtjsGxbgxxb entity) {	
		entity.setXgsj(gerNowDateTimeStr());
		zdryDtjsXsDao.updateGxdw(entity);
	}
	
	public String saveShgxr(ZdryDtjsShgxrxxb entity){		
		entity.setRksj(gerNowDateTimeStr());
		return zdryDtjsXsDao.saveShgxr(entity);
	}
	
	public String saveSaxx(ZdryDtjsSaxxb entity){
		return zdryDtjsXsDao.saveSaxx(entity);
	}	
	
	public String saveClxx(ZdryDtjsClxxb entity){
		
		entity.setCjsj(gerNowDateTimeStr());
		return zdryDtjsXsDao.saveClxx(entity);
	}
	
	
	public EasyUIPage queryDtjsZtxxList(EasyUIPage page, ZdryDtjsZtxxb entity) {
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
		map.put("Ztxxb", entity);
		List<?> list = zdryDtjsSxDao.queryDtjsZtxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsZtxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsSwxxList(EasyUIPage page, ZdryDtjsSwxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsSwxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsSwxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsSfxxList(EasyUIPage page, ZdryDtjsSfxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsSfxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsSfxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsSdxdxxList(EasyUIPage page, ZdryDtjsSdxdxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsSdxdxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsSdxdxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsSdfdxxList(EasyUIPage page, ZdryDtjsSdfdxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsSdfdxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsSdfdxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsSdzdxxList(EasyUIPage page, ZdryDtjsSdzdxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsSdzdxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsSdzdxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsZdxsfzqkxxList(EasyUIPage page, ZdryDtjsZdxsfzqkxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsZdxsfzqkxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsZdxsfzqkxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsZszhjsbrxxList(EasyUIPage page, ZdryDtjsZszhjsbrxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsZszhjsbrxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsZszhjsbrxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsZszhjsbrZdjlxxList(EasyUIPage page, ZdryDtjsZszhjsbrZdjlxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsZszhjsbrZdjlxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsZszhjsbrZdjlxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	
	public EasyUIPage queryDtjsZszhjsbrZszhjlxxList(EasyUIPage page, ZdryDtjsZszhjsbrZszhjlxxb entity) {
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
		List<?> list = zdryDtjsSxDao.queryDtjsZszhjsbrZszhjlxxList(page, map);
		int count = (int) zdryDtjsSxDao.queryDtjsZszhjsbrZszhjlxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	public EasyUIPage queryGxbgList(EasyUIPage page, ZdryDtjsGxbgxxb entity){
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
		List<?> list = zdryDtjsXsDao.queryGxbgList(page, map);
		int count = (int) zdryDtjsXsDao.queryGxbgListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	public EasyUIPage queryShgxrList(EasyUIPage page, ZdryDtjsShgxrxxb entity){
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
		List<?> list = zdryDtjsXsDao.queryShgxrList(page, map);
		int count = (int) zdryDtjsXsDao.queryShgxrListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	public EasyUIPage querySaxxList(EasyUIPage page, ZdryDtjsSaxxb entity){
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
		List<?> list = zdryDtjsXsDao.querySaxxList(page, map);
		int count = (int) zdryDtjsXsDao.querySaxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	public EasyUIPage queryClxxList(EasyUIPage page, ZdryDtjsClxxb entity){
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
		List<?> list = zdryDtjsXsDao.queryClxxList(page, map);
		int count = (int) zdryDtjsXsDao.queryClxxListCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}
	
	private SimpleDateFormat formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	private String gerNowDateTimeStr(){		
		Calendar cal = Calendar.getInstance();		
		return formatStr.format(cal.getTime());
	}
}
