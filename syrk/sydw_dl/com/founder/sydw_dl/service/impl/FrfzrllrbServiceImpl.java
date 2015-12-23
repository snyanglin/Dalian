package com.founder.sydw_dl.service.impl;

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
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.bean.Frfzrllrb;
import com.founder.sydw_dl.dao.CyryxxbDao;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.sydw_dl.dao.FrfzrllrbDao;
import com.founder.sydw_dl.service.FrfzrllrbService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;

@Service("frfzrllrbService")
@Transactional
public class FrfzrllrbServiceImpl  extends BaseService implements FrfzrllrbService{
	
	@Resource(name = "frfzrllrbDao")
	private FrfzrllrbDao frfzrllrbDao;
	
	@Resource(name = "cyryxxbDao")
	private CyryxxbDao cyryxxbDao;
	
	@Resource
	private SysMessageDao sysMessageDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	@Override
	public Frfzrllrb queryById(String id) {
		return frfzrllrbDao.queryById(id);
	}

	@Override
	public boolean add(Frfzrllrb entity, SessionBean sessionBean) {
		
		// SYS_SYRK_476.	数据保存时进行一个单位只能有一个法人校验，校验不通过不能保存。
		if("1".equals(entity.getDwrylxdm())){
			Frfzrllrb queryBean = new Frfzrllrb();
			queryBean.setDwid(entity.getDwid());
			queryBean.setDwrylxdm("1");
			queryBean = frfzrllrbDao.queryByDwidAndDwrylx(queryBean);
			if(queryBean != null){
				return false;
			}	
		}
		if(null!=entity.getRyid()&&!"".equals(entity.getRyid())){
			//通过dwid查询单位
			Dwjbxxb dwjbxxb=new Dwjbxxb();
			dwjbxxb.setId(entity.getDwid());
			dwjbxxb=dwjbxxbDao.query(dwjbxxb);
			// 实有人口核实提醒begin
		/*	Map<String, String> map = new HashMap<String, String>();
			if(!"".equals(entity.getDz_xjzdzdm())&&entity.getDz_xjzdzdm()!=null){
				map.put("ryid", entity.getRyid());
				map.put("jzdzdm", entity.getDz_xjzdzdm());
				map.put("jzdzssxdm",entity.getDz_xjzdzssxdm());
				map.put("jzdzmlpdm", entity.getDz_xjzdmlpdm());
				map.put("jzdzmlpxz", entity.getDz_xjzdmlpxz());
				map.put("xm", entity.getXm());
				map.put("dwmc", dwjbxxb.getDwmc());
				map.put("lyid", entity.getId());
				map.put("lybm", "DW_DWFRFZRLLYXXB");
				if("1".equals(entity.getDwrylxdm())){
					map.put("type","5");//法人
				}else if("2".equals(entity.getDwrylxdm())){
					map.put("type","6");//联络人
				}else if("3".equals(entity.getDwrylxdm())){
					map.put("type","7");//负责人
				}else{
					map.put("ywmc","法人/负责人/联络员");//法人
				}
				map.put("jzdzxz", entity.getDz_xjzdzxz());
				sysMessageDao.syrkHSTX(map, null, sessionBean);
			}*/
			// 实有人口核实提醒end
			//服务处所变更提醒begin
//			map=new HashMap();
//			map.put("ryid", entity.getRyid());
//			map.put("dwmc",dwjbxxb.getDwmc());
//			map.put("dwid",entity.getDwid());
//			map.put("xm",entity.getXm());
//			if("1".equals(entity.getDwrylxdm())){
//				map.put("ywmc","单位法人");//法人
//			}else if("2".equals(entity.getDwrylxdm())){
//				map.put("ywmc","单位联络人");//联络人
//			}else if("3".equals(entity.getDwrylxdm())){
//				map.put("ywmc","单位负责人");//负责人
//			}else{
//				map.put("ywmc","法人/负责人/联络员");//法人
//			}
//			sysMessageDao.syrkFWCSBG(map, sessionBean);
			//服务处所变更提醒end
		}
		//SYS_SYRK_477.	若没有复用到数据则向人员基本信息表插入数据并返回人员ＩＤ。
		String ryid = saveRyjbxxb(entity, sessionBean);
		if(!ryid.equals("")){
			entity.setRyid(ryid);			
		}
		// SYS_SYRK_522. 若紧急联系人没有复用数据在保存时向人员基本信息表插入紧急情况联系人信息并返回人员ＩＤ。
		String jjlxryid = saveJjlxRyjbxxb(entity, sessionBean);
			if(!jjlxryid.equals("")){
				entity.setJjlxr_ryid(jjlxryid);			
		}
		//SYS_SYRK_479.	若是否在公司任职的值为“是”且从业人员信息表无此人信息，向从业人员信息表插入数据。
		if("1".equals(entity.getSfzgsrzdm())){
			Cyryxxb cyryxxb = new Cyryxxb();
			cyryxxb.setDwid(entity.getDwid());
			cyryxxb.setCyzjdm(entity.getCyzjdm());
			cyryxxb.setZjhm(entity.getZjhm());
			cyryxxb = cyryxxbDao.queryByZjlx(cyryxxb);
			if(cyryxxb == null){
				cyryxxb = new Cyryxxb();
				cyryxxb.setRyid(entity.getRyid());
				cyryxxb.setDwid(entity.getDwid());
				cyryxxb.setCyzjdm(entity.getCyzjdm());
				cyryxxb.setZjhm(entity.getZjhm());
				cyryxxb.setXm(entity.getXm());
				cyryxxb.setCsrq(entity.getCsrq());
				cyryxxb.setXbdm(entity.getXbdm());
				cyryxxb.setMzdm(entity.getMzdm());
				cyryxxb.setGjdm(entity.getGjdm());
				cyryxxb.setLxdh(entity.getLxdh());
				cyryxxb.setDz_hjddm(entity.getDz_hjdzdm());
				cyryxxb.setDz_hjdxz(entity.getDz_hjdzxz());
				cyryxxb.setDz_hjdxzqhdm(entity.getDz_hjdzssxdm());
				cyryxxb.setDz_xzzdm(entity.getDz_xjzdzdm());
				cyryxxb.setDz_xzzxz(entity.getDz_xjzdzxz());
				cyryxxb.setDz_xzzxzqhdm(entity.getDz_xjzdzssxdm());
				BaseService.setSaveProperties(cyryxxb, sessionBean);
				cyryxxb.setId(UUID.create());
				cyryxxbDao.insert(cyryxxb);
			}
		}
		
		//新增
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setId(UUID.create());
		frfzrllrbDao.insert(entity);
		
		//先不调用电话提醒了，电话提醒用的sql是老版的实有人口
		//联系电话变更提醒
	/*	Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getRyid());
		map.put("lxdh", entity.getLxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxfs");
		map.put("tableName", "rk_rylxfszb");
		map.put("ywmc", "【实有单位 - 法人/负责人/联络人登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);*/
		
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ryid", entity.getRyid());
//		map.put("lxdh", entity.getLxdh());
//		map.put("ywmc", "【实有单位 - 法人/负责人/联络人登记】");
//		sysMessageDao.lxdhBgTx(map, sessionBean, false);
		return true;
	}

	@Override
	public boolean update(Frfzrllrb entity, SessionBean sessionBean) {
		// SYS_SYRK_476.	数据保存时进行一个单位只能有一个法人校验，校验不通过不能保存。
		if("1".equals(entity.getDwrylxdm())){
			Frfzrllrb queryBean = new Frfzrllrb();
			queryBean.setDwid(entity.getDwid());
			queryBean.setDwrylxdm("1");
			queryBean = frfzrllrbDao.queryByDwidAndDwrylx(queryBean);
			if(queryBean != null){
				if(!queryBean.getId().equals(entity.getId())){
					return false;					
				}
			}		
		}
		if(null!=entity.getRyid()&&!"".equals(entity.getRyid())){
			//通过dwid查询单位
			Dwjbxxb dwjbxxb=new Dwjbxxb();
			dwjbxxb.setId(entity.getDwid());
			dwjbxxb=dwjbxxbDao.query(dwjbxxb);
	/*		// 实有人口核实提醒begin
			Map<String, String> map = new HashMap<String, String>();
			if(!"".equals(entity.getDz_xjzdzdm())&&entity.getDz_xjzdzdm()!=null){
				map.put("ryid", entity.getRyid());
				map.put("jzdzdm", entity.getDz_xjzdzdm());
				map.put("jzdzssxdm",entity.getDz_xjzdzssxdm());
				map.put("jzdzmlpdm", entity.getDz_xjzdmlpdm());
				map.put("jzdzmlpxz", entity.getDz_xjzdmlpxz());
				map.put("xm", entity.getXm());
				map.put("dwmc", dwjbxxb.getDwmc());
				map.put("lyid", entity.getId());
				map.put("lybm", "DW_DWFRFZRLLYXXB");
				if("1".equals(entity.getDwrylxdm())){
					map.put("type","5");//法人
				}else if("2".equals(entity.getDwrylxdm())){
					map.put("type","6");//联络人
				}else if("3".equals(entity.getDwrylxdm())){
					map.put("type","7");//负责人
				}else{
					map.put("ywmc","法人/负责人/联络员");//法人
				}
				map.put("jzdzxz", entity.getDz_xjzdzxz());
				sysMessageDao.syrkHSTX(map, null, sessionBean);
			}*/
			// 实有人口核实提醒end
			//服务处所变更提醒begin
//			map=new HashMap();
//			map.put("ryid", entity.getRyid());
//			map.put("dwmc",dwjbxxb.getDwmc());
//			map.put("dwid",entity.getDwid());
//			map.put("xm",entity.getXm());
//			if("1".equals(entity.getDwrylxdm())){
//				map.put("ywmc","法人");//法人
//			}else if("2".equals(entity.getDwrylxdm())){
//				map.put("ywmc","联络人");//联络人
//			}else if("3".equals(entity.getDwrylxdm())){
//				map.put("ywmc","负责人");//负责人
//			}else{
//				map.put("ywmc","法人/负责人/联络员");//法人
//			}
//			sysMessageDao.syrkFWCSBG(map, sessionBean);
			//服务处所变更提醒end
		}
		//SYS_SYRK_477.	若没有复用到数据则向人员基本信息表插入数据并返回人员ＩＤ。
		String ryid = saveRyjbxxb(entity, sessionBean);
		if(!ryid.equals("")){
			entity.setRyid(ryid);			
		}
		// SYS_SYRK_522. 若紧急联系人没有复用数据在保存时向人员基本信息表插入紧急情况联系人信息并返回人员ＩＤ。
		String jjlxryid = saveJjlxRyjbxxb(entity, sessionBean);
				if(!jjlxryid.equals("")){
					entity.setJjlxr_ryid(jjlxryid);			
				}
		
		//SYS_SYRK_479.	若是否在公司任职的值为“是”且从业人员信息表无此人信息，向从业人员信息表插入数据。
		if("1".equals(entity.getSfzgsrzdm())){
			Cyryxxb cyryxxb = new Cyryxxb();
			cyryxxb.setDwid(entity.getDwid());
			cyryxxb.setCyzjdm(entity.getCyzjdm());
			cyryxxb.setZjhm(entity.getZjhm());
			cyryxxb = cyryxxbDao.queryByZjlx(cyryxxb);
			if(cyryxxb == null){
				cyryxxb = new Cyryxxb();
				cyryxxb.setRyid(entity.getRyid());
				cyryxxb.setXm(entity.getXm());
				cyryxxb.setCsrq(entity.getCsrq());
				cyryxxb.setXbdm(entity.getXbdm());
				cyryxxb.setMzdm(entity.getMzdm());
				cyryxxb.setGjdm(entity.getGjdm());
				cyryxxb.setLxdh(entity.getLxdh());
				cyryxxb.setDz_hjddm(entity.getDz_hjdzdm());
				cyryxxb.setDz_hjdxz(entity.getDz_hjdzxz());
				cyryxxb.setDz_hjdxzqhdm(entity.getDz_hjdzssxdm());
				cyryxxb.setDz_xzzdm(entity.getDz_xjzdzdm());
				cyryxxb.setDz_xzzxz(entity.getDz_xjzdzxz());
				cyryxxb.setDz_xzzxzqhdm(entity.getDz_xjzdzssxdm());
				BaseService.setSaveProperties(cyryxxb, sessionBean);
				cyryxxb.setId(UUID.create());
				cyryxxbDao.insert(cyryxxb);
			}
		}
		//先不调用电话提醒了，电话提醒用的sql是老版的实有人口
		//联系电话变更提醒
	/*	Map<String, Object> map = new HashMap<String, Object>();
		map.put("ryid", entity.getRyid());
		map.put("lxdh", entity.getLxdh());
		map.put("lxdhlxdm", "1");
		map.put("lxfsColName", "lxdh");
		map.put("tableName", "DW_DWFRFZRLLYXXB");
		map.put("idColName", "dwid");
		map.put("idColValue", entity.getDwid());
		map.put("ywmc", "【实有单位 - 法人/负责人/联络人登记】");
		sysMessageDao.lxdhBgTx(map, sessionBean, false);*/
		
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("ryid", entity.getRyid());
//		map.put("lxdh", entity.getLxdh());
//		map.put("ywmc", "【实有单位 - 法人/负责人/联络人登记】");
//		sysMessageDao.lxdhBgTx(map, sessionBean, false);
		//修改
		BaseService.setUpdateProperties(entity, sessionBean);
		frfzrllrbDao.update(entity);
		return true;
	}
	
	/**
	 * SYS_SYRK_477.	若没有复用到数据则向人员基本信息表插入数据并返回人员ＩＤ。
	 * 
	 * @param entity
	 * @param sessionBean
	 * @return
	 */
	public String saveRyjbxxb(Frfzrllrb entity, SessionBean sessionBean) {
		String ryid = "";
		if (StringUtils.isBlank(entity.getRyid())) {
			String xt_lrrxm = "法人/负责人/联络员新增";
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
			ryjbxx.setGjdm(entity.getGjdm());
			ryjbxx.setHjd_dzid(entity.getDz_hjdzdm());
			ryjbxx.setHjd_dzxz(entity.getDz_hjdzxz());
			ryjbxx.setHjd_xzqhdm(entity.getDz_hjdzssxdm());
			ryjbxx.setXt_lrrxm(xt_lrrxm);
			ryjbxx.setSyrkbz("0");
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
	public String saveJjlxRyjbxxb(Frfzrllrb entity, SessionBean sessionBean) {
		String ryid = "";
		if (StringUtils.isBlank(entity.getJjlxr_ryid()) && !StringUtils.isBlank(entity.getJjlxr_cyzjdm()) && !StringUtils.isBlank(entity.getJjlxr_zjhm())) {
			String xt_lrrxm = "法人/负责人/联络员紧急情况联系人新增";
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
			ryRyjbxxbDao.save(ryjbxx,sessionBean);
		}
		return ryid;
	}
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, String dwid) {
		return frfzrllrbDao.queryList(page, dwid);
	}

	@Override
	public void delete(Frfzrllrb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		frfzrllrbDao.delete(entity);
	}
	@Override
	public boolean queryLxfsValid(String lxdh, String dwid) {
		return dwjbxxbDao.queryLxfsValid(lxdh, dwid);
	}

	@Override
	public Frfzrllrb queryFrByDwid(String dwid) {
		return frfzrllrbDao.queryFrByDwid(dwid);
	}

}
