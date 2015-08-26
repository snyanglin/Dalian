package com.founder.syrkgl.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.StringUtils;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.syrkgl.bean.Jzzblxxb;
import com.founder.syrkgl.bean.RyRybmchxxb;
import com.founder.syrkgl.bean.RyRyhykxxb;
import com.founder.syrkgl.bean.RyRyjlxxb;
import com.founder.syrkgl.bean.RyRyjtcyxxb;
import com.founder.syrkgl.bean.RyRylxfsxxb;
import com.founder.syrkgl.bean.RyRytbtsbjxxb;
import com.founder.syrkgl.bean.RyRytbtstzxxb;
import com.founder.syrkgl.bean.RyRytmtzxxb;
import com.founder.syrkgl.bean.RyRyxnsfxxb;
import com.founder.syrkgl.bean.RyRyzjxxb;
import com.founder.syrkgl.bean.RyZyjwryxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.dao.JzzblxxbDao;
import com.founder.syrkgl.dao.RyRybmchxxbDao;
import com.founder.syrkgl.dao.RyRyhykxxbDao;
import com.founder.syrkgl.dao.RyRyjlxxbDao;
import com.founder.syrkgl.dao.RyRyjtcyxxbDao;
import com.founder.syrkgl.dao.RyRylxfsxxbDao;
import com.founder.syrkgl.dao.RyRytbtsbjxxbDao;
import com.founder.syrkgl.dao.RyRytbtstzxxbDao;
import com.founder.syrkgl.dao.RyRytmtzxxbDao;
import com.founder.syrkgl.dao.RyRyxnsfxxbDao;
import com.founder.syrkgl.dao.RyRyzjxxbDao;
import com.founder.syrkgl.dao.RyZyjwryxxbDao;
import com.founder.syrkgl.dao.SyrkCzrkxxbDao;
import com.founder.syrkgl.dao.SyrkEditDao;
import com.founder.syrkgl.dao.SyrkJwryxxbDao;
import com.founder.syrkgl.dao.SyrkJzrkxxbDao;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.dao.SyrkWlhryxxbDao;
import com.founder.syrkgl.service.SyrkEditService;
import com.founder.syrkgl.vo.SyrkgnVo;
import com.founder.syrkgl.vo.SyrkxxzsVo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.service.impl.SyrkEditServiceImpl.java]
 * @ClassName: [SyrkEditServiceImpl]
 * @Description: [实有人口编辑页面逻辑实现]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-4-3 下午2:31:13]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 下午2:31:13，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("syrkEditService")
@Transactional
public class SyrkEditServiceImpl extends BaseService implements SyrkEditService {

	@Resource(name = "syrkEditDao")
	private SyrkEditDao syrkEditDao;
	@Resource(name = "syrkCzrkxxbDao")
	private SyrkCzrkxxbDao syrkCzrkxxbDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "syrkJzrkxxbDao")
	private SyrkJzrkxxbDao syrkJzrkxxbDao;
	@Resource(name = "syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;
	@Resource(name = "syrkJwryxxbDao")
	private SyrkJwryxxbDao syrkJwryxxbDao;
	@Resource(name = "syrkWlhryxxbDao")
	private SyrkWlhryxxbDao syrkWlhryxxbDao;
	
	@Resource(name = "ryRyzjxxbDao")
	private RyRyzjxxbDao ryRyzjxxbDao;
	@Resource(name = "ryRylxfsxxbDao")
	private RyRylxfsxxbDao ryRylxfsxxbDao;
	
	@Resource(name = "ryRybmchxxbDao")
	private RyRybmchxxbDao ryRybmchxxbDao;
	
	@Resource(name = "ryRyjlxxbDao")
	private RyRyjlxxbDao ryRyjlxxbDao;
	
	@Resource(name = "ryRyhykxxbDao")
	private RyRyhykxxbDao ryRyhykxxbDao;
	@Resource(name = "ryZyjwryxxbDao")
	private RyZyjwryxxbDao ryZyjwryxxbDao;
	
	@Resource(name = "ryRyxnsfxxbDao")
	private RyRyxnsfxxbDao ryRyxnsfxxbDao;
	
	@Resource(name = "ryRyjtcyxxbDao")
	private RyRyjtcyxxbDao ryRyjtcyxxbDao;
	
	@Resource(name = "ryRytmtzxxbDao")
	private RyRytmtzxxbDao ryRytmtzxxbDao;
	
	@Resource(name = "ryRytbtstzxxbDao")
	private RyRytbtstzxxbDao ryRytbtstzxxbDao;
	
	@Resource(name = "ryRytbtsbjxxbDao")
	private RyRytbtsbjxxbDao ryRytbtsbjxxbDao;
	
	@Resource(name = "jzzblxxbDao")
	private JzzblxxbDao jzzblxxbDao;
	
	@Override
	public List<SyrkgnVo> queryYwglgn(String gnlxdm,String syrklx) {
		List<SyrkgnVo> infoList = new ArrayList<SyrkgnVo>();
		infoList=syrkEditDao.queryYwglgn(gnlxdm,syrklx);
		//查询编号为00的公共功能
		infoList.addAll(syrkEditDao.queryYwglgn(gnlxdm,"00"));
		return infoList;
		
	}

	@Override
	public List<SyrkxxzsVo> queryRyzsxx(Map<String, Object> map) {
		List<Map<String, String>> list = new Gson().fromJson(
				(String) map.get("syrkJson"),
				new TypeToken<List<Map<String, String>>>() {
				}.getType());
		map.remove("syrkJson");
		List<SyrkxxzsVo> infoList = new ArrayList<SyrkxxzsVo>();
		List<SyrkxxzsVo> temp = null;

		// 循环查询大类人口信息
		for (Map<String, String> syrkMap : list) {
			map.remove("dlbh");
			map.put("isEdit", syrkMap.get("isEdit"));
			map.put("gxzrq", orgOrganizationService
					.queryOrgNameByOrgcodes(syrkMap.get("gxzrq")));
			map.put("xxdxlxdm", "1");
			map.put("syrklx", syrkMap.get("syrklx"));
			map.put("syrkid", syrkMap.get("syrkid"));
			temp = syrkEditDao.queryRyzsxx(map);
			
			if (temp != null && !temp.isEmpty()) {
				map.put("xxdxlxdm", "2");
				for (int i = 0; i < temp.size(); i++) {
					map.put("dlbh", temp.get(i).getXxbh().substring(0, 2));
					temp.get(i).setList(syrkEditDao.queryRyzsxx(map));
					if(syrkMap.get("isEdit").equals("1")){
						temp.get(i).setPx(0);
					}
				}
				infoList.addAll(temp);
			}
		}
		//查询编号为00的公共功能
		map.remove("dlbh");
		map.put("isEdit", "1");
		map.put("xxdxlxdm", "1");
		map.put("syrklx", "00");
		map.remove("gxzrq");
		temp = syrkEditDao.queryRyzsxx(map);
		if (temp != null && !temp.isEmpty()) {
			map.put("xxdxlxdm", "2");
			for (int i = 0; i < temp.size(); i++) {
				map.put("dlbh", temp.get(i).getXxbh().substring(0, 2));
				temp.get(i).setList(syrkEditDao.queryRyzsxx(map));
			}
			infoList.addAll(temp);
		}
		
		// 实现排序接口
		Comparator<Object> c = new Comparator<Object>() {
			public int compare(Object a, Object b) {
				int one = ((SyrkxxzsVo) a).getPx();
				int two = ((SyrkxxzsVo) b).getPx();
				return one - two;
			}
		};
		Collections.sort(infoList, c);
		return infoList;
	}

	@Override
	public void delete_xxzsnrb(Map<String, Object> map) {
		syrkEditDao.delete_xxzsnrb(map);
	}

	@Override
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return syrkEditDao.fjxx_query(map);
	}

	@Override
	public SyrkCzrkxxb czrkxxb_query(Map<String, Object> map) {
		return syrkCzrkxxbDao.queryById((String) map.get("syrkid"));
	}

	@Override
	public SyrkJzrkxxb jzrkxxb_query(Map<String, Object> map) {
		return syrkJzrkxxbDao.queryById((String) map.get("syrkid"));
	}

	@Override
	public SyrkLdrkxxb ldrkxxb_query(Map<String, Object> map) {
		return syrkLdrkxxbDao.queryById((String) map.get("syrkid"));
	}

	@Override
	public SyrkJwryxxb jwryxxb_query(Map<String, Object> map) {
		return syrkJwryxxbDao.queryById((String) map.get("syrkid"));
	}

	@Override
	public SyrkWlhryxxb wlhryxxb_query(Map<String, Object> map) {
		return syrkWlhryxxbDao.queryById((String) map.get("syrkid"));
	}

	@Override
	public List<RyRyzjxxb> ryzjxxzb_query(Map<String, Object> map) {
		return ryRyzjxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRylxfsxxb> rylxfsxxb_query(Map<String, Object> map) {
		return ryRylxfsxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRybmchxxb> rybmchxxb_query(Map<String, Object> map) {
		return ryRybmchxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRyjlxxb> ryjlxxb_query(Map<String, Object> map) {
		return ryRyjlxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRyhykxxb> ryhykxxb_query(Map<String, Object> map) {
		return ryRyhykxxbDao.queryViewList(map);
	}
	
	@Override
	public List<RyZyjwryxxb> ryzyjwryxxb_query(Map<String, Object> map) {
		return ryZyjwryxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRyxnsfxxb> ryxysfxxb_query(Map<String, Object> map) {
		return ryRyxnsfxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRyjtcyxxb> ryjtcyxxb_query(Map<String, Object> map) {
		return ryRyjtcyxxbDao.queryViewList(map);
	}

	@Override
	public RyRytmtzxxb rytmtzxxb_query(Map<String, Object> map) {
		return ryRytmtzxxbDao.queryByRyid(map);
	}

	@Override
	public List<RyRytbtstzxxb> rytbtstzxxb_query(Map<String, Object> map) {
		return ryRytbtstzxxbDao.queryViewList(map);
	}

	@Override
	public List<RyRytbtsbjxxb> tbtsbjxxb_query(Map<String, Object> map) {
		return ryRytbtsbjxxbDao.queryViewList(map);
	}

	@Override
	public List<Jzzblxxb> jzzblxxb_query(Map<String, Object> map) {
		String ryid = (String) map.get("ryid");
		List<Jzzblxxb> list =null;
		if(!StringUtils.isBlank(ryid)){
			list = jzzblxxbDao.queryJzzblxxList(ryid);
		}
		return list;
	}
}
