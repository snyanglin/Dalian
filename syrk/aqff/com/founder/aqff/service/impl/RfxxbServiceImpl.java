package com.founder.aqff.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.aqff.bean.Aqffrfryxxb;
import com.founder.aqff.bean.AqffRfxxb;
import com.founder.aqff.dao.RfxxbDao;
import com.founder.aqff.service.RfxxbService;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
/******************************************************************************
 * @Package:      [com.founder.aqff.service.impl.RfxxbServiceImpl]  
 * @ClassName:    [RfxxbServiceImpl]   
 * @Description:  [人防信息ServiceImpl]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-2 上午2:12:09]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 上午2:12:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("rfxxbService")
@Transactional
public class RfxxbServiceImpl extends BaseService implements RfxxbService {
	@Resource(name = "rfxxbDao")
	private RfxxbDao rfxxbDao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Override
	public EasyUIPage queryRf(EasyUIPage page, String lrrbmid) {
		OrgOrganization org = this.orgOrganizationService.queryByOrgcode(lrrbmid);
		return rfxxbDao.queryDownListByParentID(page, org.getId(), "01", "50", "04");
	}
	
	/**
	 * 人防信息精确查询
	 */
	@Override
	public EasyUIPage queryJQRf(EasyUIPage page, AqffRfxxb entity) {
		return rfxxbDao.queryJQRf(page, entity);
	}
	/**
	 * 人防信息模糊查询
	 */
	@Override
	public EasyUIPage queryMHRf(EasyUIPage page, AqffRfxxb entity) {
		return rfxxbDao.queryMHRf(page, entity);
	}
	/**
	 * 人防信息添加
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public void insertRfxx(AqffRfxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		entity.setRfid(entity.getId());
		rfxxbDao.insertRfxx(entity);
		List<Aqffrfryxxb> list = new ArrayList<Aqffrfryxxb>();
		JSONArray  jcxmxJsonArray =JSONArray.fromObject(entity.getRyAll());
		List<Aqffrfryxxb> listForIU = new ArrayList<Aqffrfryxxb>();
		listForIU = (List<Aqffrfryxxb>)jcxmxJsonArray.toCollection(jcxmxJsonArray, Aqffrfryxxb.class);
		for(int i = 0;i<listForIU.size();i++){
			Aqffrfryxxb rfry = listForIU.get(i);
			rfry.setRfid(entity.getId());
			if(null!=rfry.getId()&&rfry.getId()!=""&&!"".equals(rfry.getId())){
				setUpdateProperties(rfry, sessionBean);
				rfxxbDao.updateRfcyxx(rfry);
			}else{
				rfry.setId(UUID.create());
				setSaveProperties(rfry, sessionBean);
				rfxxbDao.saveRfcyxx(rfry);
			}
		}
		if(null!=entity.getRydelete()||entity.getRydelete().equals("")){
			JSONArray deleteJsonArray = JSONArray.fromObject(entity.getRydelete());
			list=null;
			list=(List<Aqffrfryxxb>) deleteJsonArray.toCollection(deleteJsonArray, Aqffrfryxxb.class);
			for(int i=0;i<list.size();i++){
				Aqffrfryxxb rfry = list.get(i);
				if(!"null".equals(rfry)&&null!=rfry){
					rfry.setRfid(entity.getId());
					setUpdateProperties(rfry, sessionBean);
					rfxxbDao.deleteRfcyxx(rfry);
				}
			}
		}
	}
	/**
	 * 人防信息通过id查询
	 */
	@Override
	public AqffRfxxb queryRfxxById(AqffRfxxb entity) {
		AqffRfxxb AqffRfxxb =  rfxxbDao.queryRfxxById(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rfid", entity.getId());
		List<Aqffrfryxxb> list = rfxxbDao.queryRfcyxxByrfid(map);
		AqffRfxxb.setRyAllList(list);
		return AqffRfxxb;
	}
	/**
	 * 人防信息修改
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public int updateRfxx(AqffRfxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		entity.setRfid(entity.getId());
		List<Aqffrfryxxb> list = new ArrayList<Aqffrfryxxb>();
		JSONArray  jcxmxJsonArray =JSONArray.fromObject(entity.getRyAll());
		List<Aqffrfryxxb> listForIU = new ArrayList<Aqffrfryxxb>();
		listForIU = (List<Aqffrfryxxb>)jcxmxJsonArray.toCollection(jcxmxJsonArray, Aqffrfryxxb.class);
		for(int i = 0;i<listForIU.size();i++){
			Aqffrfryxxb rfry = listForIU.get(i);
			rfry.setRfid(entity.getId());
			if(null!=rfry.getId()&&!"".equals(rfry.getId())){
				setUpdateProperties(rfry, sessionBean);
				rfxxbDao.updateRfcyxx(rfry);
			}else{
				rfry.setId(UUID.create());
				setSaveProperties(rfry, sessionBean);
				rfxxbDao.saveRfcyxx(rfry);
			}
		}
		if(null!=entity.getRydelete()||entity.getRydelete().equals("")){
			JSONArray deleteJsonArray = JSONArray.fromObject(entity.getRydelete());
			list=null;
			list=(List<Aqffrfryxxb>) deleteJsonArray.toCollection(deleteJsonArray, Aqffrfryxxb.class);
			for(int i=0;i<list.size();i++){
				if(null!=list.get(i)){
					Aqffrfryxxb rfry = list.get(i);
					rfry.setRfid(entity.getId());
					setCrossoutProperties(rfry, sessionBean);
					rfxxbDao.deleteRfcyxx(rfry);
				}
			}
		}
		return rfxxbDao.updateRfxx(entity);
	}
	/**
	 * 人防信息删除
	 */
	@Override
	public int deleteRfxx(AqffRfxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		rfxxbDao.deleteRfglry(entity);
		return rfxxbDao.deleteRfxx(entity);
	}
	/**
	 * 人防成员信息添加
	 */
	@Override
	public void saveRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		rfxxbDao.saveRfcyxx(entity);
	}
	/**
	 * 人防成员信息修改
	 */
	@Override
	public int updateRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return rfxxbDao.updateRfcyxx(entity);
	}
	/**
	 * 人防成员信息删除
	 */
	@Override
	public int deleteRfcyxx(Aqffrfryxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		return rfxxbDao.deleteRfcyxx(entity);
	}
	/**
	 * 通过id查找人防成员信息
	 */
	@Override
	public Aqffrfryxxb queryRfcyxxById(Aqffrfryxxb entity) {
		return rfxxbDao.queryRfcyxxById(entity);
	}
	/**
	 * 通过证件查找人防成员信息
	 */
	@Override
	public int queryRfcyxxByZjhm(Aqffrfryxxb entity) {
		return rfxxbDao.queryRfcyxxByZjhm(entity);
	}
	/**
	 * 管理页面中人员列表信息
	 */
	@Override
	public EasyUIPage queryRfcyxx(EasyUIPage page, Aqffrfryxxb entity) {
		return rfxxbDao.queryRfcyxx(page, entity);
	}
	/**
	 * 删除人防关联人员信息
	 */
	public void deleteRfryxx(AqffRfxxb entity) {
		rfxxbDao.deleteRfryxx(entity);
	}
	/**
	 * 人防信息重复性查询
	 */
	public int queryRfxxCF(AqffRfxxb entity) {
		return rfxxbDao.queryRfxxCF(entity);
	}
	/**
	 * 人防人员单位查询
	 */
	public Aqffrfryxxb queryRfcyxxByZjhmForDW(Aqffrfryxxb entity) {
		return rfxxbDao.queryRfcyxxByZjhmForDW(entity);
	}
}
