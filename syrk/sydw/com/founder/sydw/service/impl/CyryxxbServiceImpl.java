package com.founder.sydw.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Cyryxxb;
import com.founder.sydw.bean.Dictxxb;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.dao.CyryxxbDao;
import com.founder.sydw.dao.DwjbxxbDao;
import com.founder.sydw.service.CyryxxbService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;

@Service("cyryxxbService")
@Transactional
public class CyryxxbServiceImpl extends BaseService implements CyryxxbService {

	@Resource(name = "cyryxxbDao")
	private CyryxxbDao cyryxxbDao;

	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	@Override
	public Cyryxxb queryById(String id) {
		return cyryxxbDao.queryById(id);
	}

	@Override
	public Cyryxxb queryByZjlx(Cyryxxb entity) {
		return cyryxxbDao.queryByZjlx(entity);
	}

	@Override
	public void add(Cyryxxb entity,SessionBean sessionBean) {

		// SYS_SYRK_516. 若从业人员没有复用数据在保存时向人员基本信息表插入从业人员信息并返回人员ＩＤ
		String ryid = saveRyjbxxb(entity, sessionBean);
		if(!ryid.equals("")){
			entity.setRyid(ryid);			
		}

		// SYS_SYRK_522. 若紧急联系人没有复用数据在保存时向人员基本信息表插入紧急情况联系人信息并返回人员ＩＤ。
		String jjlxryid = saveJjlxRyjbxxb(entity, sessionBean);
		if(!jjlxryid.equals("")){
			entity.setJjlxr_ryid(jjlxryid);			
		}
		
		Map<String, String> map1 = new HashMap<String, String>();
		//通过dwid查询单位
		Dwjbxxb dwjbxxb=new Dwjbxxb();
		dwjbxxb.setId(entity.getDwid());
		dwjbxxb=dwjbxxbDao.query(dwjbxxb);
	/*	if(null!=entity.getRyid()&&!"".equals(entity.getRyid())){
			// 实有人口核实提醒begin
			if(!"".equals(entity.getDz_xzzdm())&&entity.getDz_xzzdm()!=null){
				map1.put("ryid", entity.getRyid());
				map1.put("jzdzdm", entity.getDz_xzzdm());
				map1.put("jzdzssxdm",entity.getDz_xzzxzqhdm());
				map1.put("jzdzmlpdm", entity.getDz_xzzdmlpdm());
				map1.put("jzdzmlpxz", entity.getDz_xzzdmlpxz());
				map1.put("xm", entity.getXm());
				map1.put("dwmc", dwjbxxb.getDwmc());
				map1.put("lyid", entity.getId());
				map1.put("lybm", "dw_cyryxxb");
				map1.put("type","2");//从业人员
				map1.put("jzdzxz", entity.getDz_xzzxz());
				sysMessageDao.syrkHSTX(map1, null, sessionBean);
			}
			// 实有人口核实提醒end
		}*/

		//调用发送服务处所注销任务
	/*	Map<String, String> dwmap=new HashMap<String, String>();
		dwmap.put("ryid", entity.getRyid());
		dwmap.put("dwid", entity.getDwid());
		dwmap.put("hslx", "1");//注销
		sysMessageDao.syrkFWCSZX(dwmap, sessionBean);*/

//		//服务处所变更提醒begin
//		map1=new HashMap();
//		map1.put("ryid", entity.getRyid());
//		map1.put("dwmc",dwjbxxb.getDwmc());
//		map1.put("dwid",entity.getDwid());
//		map1.put("xm",entity.getXm());
//		map1.put("ywmc","从业人员");
//		sysMessageDao.syrkFWCSBG(map1, sessionBean);
//		//服务处所变更提醒end
		
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setId(UUID.create());
		cyryxxbDao.insert(entity);
		
		
		//联系方式变更提醒
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getRyid());
		map.put("lxdh", entity.getLxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxfs");
		map.put("tableName", "rk_rylxfszb");
		map.put("ywmc", "【实有单位 - 从业人员登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);
		
		//从业人员核实提醒
		/*map = new HashMap<String, Object>();
		map.put("ryid", entity.getRyid());
		map.put("dwid", entity.getDwid());
		sysMessageDao.cyryHsTx(map, sessionBean);
		
		applicationContext.publishEvent(new TempModifyEvent(new EventObjectTemp(entity.getId(), "add", "cyry", sessionBean)));*/
	}

	@Override
	public void update(Cyryxxb entity, SessionBean sessionBean) {

		// SYS_SYRK_516. 若从业人员没有复用数据在保存时向人员基本信息表插入从业人员信息并返回人员ＩＤ
		String ryid = saveRyjbxxb(entity, sessionBean);
		if(!ryid.equals("")){
			entity.setRyid(ryid);			
		}

		// SYS_SYRK_522. 若紧急联系人没有复用数据在保存时向人员基本信息表插入紧急情况联系人信息并返回人员ＩＤ。
		String jjlxryid = saveJjlxRyjbxxb(entity, sessionBean);
		if(!jjlxryid.equals("")){
			entity.setJjlxr_ryid(jjlxryid);			
		}
		
		//通过dwid查询单位
		Dwjbxxb dwjbxxb=new Dwjbxxb();
		dwjbxxb.setId(entity.getDwid());
		dwjbxxb=dwjbxxbDao.query(dwjbxxb);
		Map<String, String> map1 = new HashMap<String, String>();
		/*if(null!=entity.getRyid()&&!"".equals(entity.getRyid())){
			// 实有人口核实提醒begin
			if(!"".equals(entity.getDz_xzzdm())&&entity.getDz_xzzdm()!=null){
				map1.put("ryid", entity.getRyid());
				map1.put("jzdzdm", entity.getDz_xzzdm());
				map1.put("jzdzssxdm",entity.getDz_xzzxzqhdm());
				map1.put("jzdzmlpdm", entity.getDz_xzzdmlpdm());
				map1.put("jzdzmlpxz", entity.getDz_xzzdmlpxz());
				map1.put("xm", entity.getXm());
				map1.put("dwmc", dwjbxxb.getDwmc());
				map1.put("lyid", entity.getId());
				map1.put("lybm", "dw_cyryxxb");
				map1.put("type","2");//从业人员
				map1.put("jzdzxz", entity.getDz_xzzxz());
				sysMessageDao.syrkHSTX(map1, null, sessionBean);
			}
			// 实有人口核实提醒end
		}*/
		
		//服务处所变更提醒begin
//		map1=new HashMap();
//		map1.put("ryid", entity.getRyid());
//		map1.put("dwmc",dwjbxxb.getDwmc());
//		map1.put("dwid",entity.getDwid());
//		map1.put("xm",entity.getXm());
//		map1.put("ywmc","从业人员");
//		sysMessageDao.syrkFWCSBG(map1, sessionBean);
		//服务处所变更提醒end
		
		//联系方式变更提醒
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getRyid());
		map.put("lxdh", entity.getLxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxdh");
		map.put("tableName", "dw_cyryxxb");
		map.put("idColName", "dwid");
		map.put("idColValue", entity.getDwid());
		map.put("ywmc", "【实有单位 - 从业人员登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);
		
		BaseService.setUpdateProperties(entity, sessionBean);
		cyryxxbDao.update(entity);
		
		
	}

	/**
	 * SYS_SYRK_516. 若从业人员没有复用数据在保存时向人员基本信息表插入从业人员信息并返回人员ＩＤ
	 * 
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public String saveRyjbxxb(Cyryxxb entity, SessionBean sessionBean) {
		String ryid = "";
		if (StringUtils.isBlank(entity.getRyid())) {
			String xt_lrrxm = "从业人员新增";
			ryid = UUID.create();

			// 写入人员基本信息
			RyRyjbxxb ryjbxx = new RyRyjbxxb();
			BaseService.setSaveProperties(ryjbxx, sessionBean);
			ryjbxx.setId(ryid);
			ryjbxx.setCyzjdm(entity.getCyzjdm());
			ryjbxx.setZjhm(entity.getZjhm());
			ryjbxx.setXm(entity.getXm());
			ryjbxx.setXbdm(entity.getXbdm());
			ryjbxx.setCsrq(entity.getCsrq());
			ryjbxx.setMzdm(entity.getMzdm());
			ryjbxx.setXldm(entity.getWhcddm());
			ryjbxx.setGjdm(entity.getGjdm());
			ryjbxx.setJggjdqdm(entity.getGjdm());
			ryjbxx.setHjd_dzid(entity.getDz_hjddm());
			ryjbxx.setHjd_dzxz(entity.getDz_hjdxzqhdm());
			ryjbxx.setHjd_xzqhdm(entity.getDz_hjdxzqhdm());
			ryjbxx.setXt_lrrxm(xt_lrrxm);
			ryRyjbxxbDao.save(ryjbxx,sessionBean);
		}
		return ryid;
	}

	/**
	 * SYS_SYRK_522. 若紧急联系人没有复用数据在保存时向人员基本信息表插入紧急情况联系人信息并返回人员ＩＤ。
	 * 
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public String saveJjlxRyjbxxb(Cyryxxb entity, SessionBean sessionBean) {
		String ryid = "";
		if (StringUtils.isBlank(entity.getJjlxr_ryid()) && !StringUtils.isBlank(entity.getJjlxr_cyzjdm()) && !StringUtils.isBlank(entity.getJjlxr_zjhm())) {
			String xt_lrrxm = "从业人员紧急情况联系人新增";
			ryid = UUID.create();

			// 写入人员基本信息
			RyRyjbxxb ryjbxx = new RyRyjbxxb();
			BaseService.setSaveProperties(ryjbxx, sessionBean);
			ryjbxx.setId(ryid);
			ryjbxx.setCyzjdm(entity.getJjlxr_cyzjdm());
			ryjbxx.setZjhm(entity.getJjlxr_zjhm());
			ryjbxx.setXm(entity.getJjlxr_xm());
			ryjbxx.setXbdm(entity.getJjlxr_xbdm());
			ryjbxx.setXt_lrrxm(xt_lrrxm);
			ryRyjbxxbDao.save(ryjbxx, sessionBean);
		}
		return ryid;
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, String dwid) {
		return cyryxxbDao.queryList(page,dwid);
	}

	@Override
	public void delete(Cyryxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		cyryxxbDao.delete(entity);
	}
	
	/**
	 * @Title: query
	 * @描述: 实有单位添加从业人员比对重点人员获取字典项词条信息
	 * @作者: liang_lihe@founder.com
	 * @参数: 传入参数定义
	 * @throws
	 */
	@Override
	public Dictxxb getCt(String sfzh) {
		return cyryxxbDao.getCt(sfzh);
	}

	

}
