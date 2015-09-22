package com.founder.xlff.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.xlff.bean.Jz_jqxxb;
import com.founder.xlff.bean.Option;
import com.founder.xlff.dao.XlffDao;
import com.founder.xlff.service.XlffService;
import com.founder.xlff.vo.Sf_Organization;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.service.impl.XlffServiceImpl.java]  
 * @ClassName:    [XlffServiceImpl]   
 * @Description:  [巡逻防范实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:33:31]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:33:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("xlffService")
@Transactional
public class XlffServiceImpl extends BaseService implements XlffService {
	
	@Resource(name = "xlffDao")
	private XlffDao xlffDao;

	/**
	 * @Title: queryOption
	 * @Description: TODO(查询设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Option    返回类型
	 * @throws
	 */
	@Override
	public Option queryOption(Option entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("option", entity);
		return xlffDao.queryOption(map);
	}

	/**
	 * @Title: saveOption
	 * @Description: TODO(保存设置)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@Override
	public String saveOption(Option entity) {
		return xlffDao.saveOption(entity);
	}

	/**
	 * @Title: updateOption
	 * @Description: TODO(修改设置)
	 * @param @param qsfkzt
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	@Override
	public int updateOption(Option qsfkzt) {
		return xlffDao.updateOption(qsfkzt);
	}
	
	/**
	 * @Title: downMap
	 * @Description: TODO(四色预警画面)
	 * @param @param orgcode
	 * @param @return    设定文件
	 * @return List<Sf_Organization>    返回类型
	 * @throws
	 */
	@Override
	public List<Sf_Organization> downMap(String orgcode) {
		List<Sf_Organization> lists = new ArrayList<Sf_Organization>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgcode", orgcode);
		String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
		String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		} else if(zero6.equals("000000")){
			map.put("flag", "PCS");
		} else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			map.put("flag", "ZRQ");
		}
		lists = xlffDao.queryTree(map);
		//过滤掉该组织机构，只取该组织机构下的单位。否则画面将多画一层大的组织机构面
		if (zero8.equals("00000000")) {
			Sf_Organization org = new Sf_Organization();
			for (int i = 0; i < lists.size(); i++) {
				org = (Sf_Organization)lists.get(i);
				String temp = org.getOrgcode().substring(org.getOrgcode().length()-8, org.getOrgcode().length());
				if (("00000000").equals(temp)) {
					lists.remove(i);
				} 
			}
		} else if(zero6.equals("000000")){
			 Sf_Organization org = new Sf_Organization();
			 for (int i = 0; i < lists.size(); i++) {
				    org = (Sf_Organization)lists.get(i);
				    String temp = org.getOrgcode().substring(org.getOrgcode().length()-6, org.getOrgcode().length());
					if (("000000").equals(temp)) {
						lists.remove(i);
					} 
				}
		} else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 Sf_Organization org = new Sf_Organization();
			 for (int i = 0; i < lists.size(); i++) {
				 org = (Sf_Organization)lists.get(i);
				 String temp = org.getOrgcode().substring(org.getOrgcode().length()-4, org.getOrgcode().length());
					if (("0000").equals(temp)) {
						lists.remove(i);
					} 
				}
		}
		return lists;
	}
	
	/**
	 * @Title: queryXjZzjgxj
	 * @Description: TODO(获取组织机构)
	 * @param @param zzjgdm
	 * @param @return    设定文件
	 * @return List<Sf_Organization>    返回类型
	 * @throws
	 */
	@Override
	public List<Sf_Organization> queryXjZzjgxj(String zzjgdm) {
		List<Sf_Organization> list = new ArrayList<Sf_Organization>();
		String [] str = zzjgdm.split(",");
		for (int i = 0; i < str.length; i++) {
			Sf_Organization entity = new Sf_Organization();
			entity.setId(str[i]);
			list.add(entity);
		}
		return xlffDao.queryXjZzjgxj(list);
	}
	
	/**
	 * @Title: ssyjColor
	 * @Description: TODO(四色预警算法)
	 * @param @param orgcode
	 * @param @param sf
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String ssyjColor(Sf_Organization sf) {
		long ajCount = 0;
		Jz_jqxxb entity = new Jz_jqxxb();
		entity.setGxdwdm(sf.getZzjgdm());
		entity.setFqsj(sf.getKssj());
		entity.setJssj(sf.getJssj());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jqxxb", entity);
		String zzjgdm = entity.getGxdwdm();
		String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		if (zero8.equals("00000000")) {
		 map.put("flag", "FJ");
		} else if(zero6.equals("000000") || zero4.equals("0000")){
		 map.put("flag", "PCS");
		} 
		ajCount = xlffDao.queryCountJq(map);
		//颜色
		int f1 = Integer.parseInt(sf.getF1());
		int f2 = Integer.parseInt(sf.getF2());
		int f3 = Integer.parseInt(sf.getF3());
		int f4 = Integer.parseInt(sf.getF4());
		String color = "green";
		if (ajCount >= f1 && ajCount < f2) {
			color = "green";
		} else if (ajCount >= f2 && ajCount < f3) {
			color = "yellow";
		} else if (ajCount >= f3 && ajCount < f4) {
			color = "orange";
		} else if (ajCount >= f4) {
			color = "red";
		}
		return color;
	}
}
