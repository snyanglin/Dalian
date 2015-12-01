package com.founder.sydw_dl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.sydw_dl.service.DwjbxxbService;
import com.founder.sydw_dl.vo.DwxzxxVO;

@Service("dwjbxxbService")
@Transactional
public class DwjbxxbServiceImpl implements DwjbxxbService {

	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;

	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;


	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwjbxxb entity) {
		return dwjbxxbDao.queryList(page, entity);
	}

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjbxxb query(Dwjbxxb entity) {
		return dwjbxxbDao.query(entity);
	}

	/**
	 * 查询未核实ById<br>
	 * 
	 * @param id
	 * @return
	 */
	public Dwjbxxb queryWhsById(String id) {
		return dwjbxxbDao.queryWhsById(id);
	}

	/**
	 * 查询单条，根据单位名称与单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public Dwjbxxb queryByDwmcDwdzdm(String dwmc, String dz_dwdzdm) {
		return dwjbxxbDao.queryByDwmcDwdzdm(dwmc, dz_dwdzdm);
	}

	/**
	 * 判断是否存在该单位，根据单位ID、单位名称、单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public boolean queryExistDw(String id, String dz_dwdzdm, String dwmc) {
		return dwjbxxbDao.queryExistDw(id, dz_dwdzdm, dwmc);
	}


	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public String save(Dwjbxxb entity,  Dwbmxxb [] dwbmxxbArray,
			String hsrwid, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		entity.setGlbmid(sessionBean.getUserOrgCode());
		entity.setZagldwbm(CreateDWbh(sessionBean.getUserOrgCode()));

		//判断是否存在地址描述业务流程【zhang_guoliang@founder.com】
		if(!StringUtils.isBlank(entity.getDzms_sspcsdm())&&!StringUtils.isBlank(entity.getDzms_zbx())){
			 StringBuffer sb = new StringBuffer();
		     sb.append("(描述)");
		     sb.append(entity.getDzms_dwdzmlpxz());
		     sb.append(entity.getDzms_chdz());
		     entity.setDzms(sb.toString());
			 String dzms = entity.getDzms_dwdzmlpxz()+entity.getDzms_chdz();
			
			//发送部门ID
			String orgCode = entity.getDzms_sszrqdm();
			if("".equals(orgCode)){
				orgCode = entity.getDzms_sspcsdm();
			}
			//发送内容
			SysMessage sysMsg = new SysMessage();
			String xxnr = "因登记实有单位‘"+entity.getDwmc()+"’无法选择‘"+dzms+"’，请尽快维护该地址！";
			sysMsg.setXxnr(xxnr);
			sysMsg.setXxlb("1");
			sysMsg.setYwurl(","+entity.getId()+","+dzms+","+entity.getDzms_zbx()+","+entity.getDzms_zby()+",0");
			sysMsg.setFsr(sessionBean.getUserName());
			sysMsg.setFsrdm(sessionBean.getUserId());
			sysMsg.setFsrssdw(sessionBean.getUserOrgName());
			sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
			sysMsg.setFssj(DateUtils.getSystemDateTimeString());
			sysMsg.setSfck("0");
			sysMsg.setXxbt("标准地址维护");
			//发送消息提醒
			sysMessageDao.saveMessageByOrg(sysMsg,orgCode, false, false);
		}
		dwjbxxbDao.save(entity, sessionBean);
		//另存为到DW_DWXZXXB表数据
		DwxzxxVO dwxzvo = new DwxzxxVO();
		dwxzvo.setId(entity.getId());
		dwxzvo.setSydwlx(entity.getDwlbdm());
		dwxzvo.setGlbmid(entity.getGlbmid());
		dwxzvo.setGlpcsid(StringUtils.isBlank(entity.getGlpcsid())?entity.getGlbmid():entity.getGlpcsid());
		dwxzvo.setGlfxjid(StringUtils.isBlank(entity.getGlfxjid())?entity.getGlbmid():entity.getGlfxjid());
		dwxzvo.setDwbh(entity.getZagldwbm());
		dwxzvo.setDwmc(entity.getDwmc());
		dwxzvo.setXt_zhxgsj(entity.getXt_zhxgsj());
		if(!StringUtils.isBlank(dwxzvo.getDwmc())){
			dwxzvo.setDwqcjm(ContextSearchUtils.getPasswordString(dwxzvo.getDwmc()));
			dwxzvo.setDwqcpyjm(ContextSearchUtils.getPasswordString(dwjbxxbDao.queryPy(dwxzvo.getDwmc())));
		}
		dwjbxxbDao.dwXzSave(dwxzvo);
		//		applicationContext.publishEvent(new SydwModifyEvent(new EventObject(entity.getId(), "add")));
		String dwid = entity.getId();
		if(dwbmxxbArray != null){
			for (int i = 0; i < dwbmxxbArray.length; i++) {
				Dwbmxxb dwbmxxb = dwbmxxbArray[i];
				if (!"1".equals(dwbmxxb.getXt_zxbz()) && !StringUtils.isBlank(dwbmxxb.getDwbm())) {
					dwbmxxb.setId(UUID.create()); // 生成主键
					dwbmxxb.setDwid(dwid);
					BaseService.setSaveProperties(dwbmxxb, sessionBean);
					dwjbxxbDao.saveDwbmxxb(dwbmxxb, sessionBean);
				}
			}
		}
		return entity.getId();
		//		applicationContext.publishEvent(new TempModifyEvent(new EventObjectTemp(entity.getId(), "add", "sydw", sessionBean)));
	}
	@Override
	public boolean queryLxfsValid(String lxdh, String dwid) {
		return dwjbxxbDao.queryLxfsValid(lxdh, dwid);
	}


	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(Dwjbxxb entity,  Dwbmxxb [] dwbmxxbArray,
			String hsrwid, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		//判断是否存在地址描述业务流程【zhang_guoliang@founder.com】
		if(!StringUtils.isBlank(entity.getDzms_sspcsdm())&&!StringUtils.isBlank(entity.getDzms_zbx())){
			 StringBuffer sb = new StringBuffer();
		     sb.append("(描述)");
		     sb.append(entity.getDzms_dwdzmlpxz());
		     sb.append(entity.getDzms_chdz());
		     entity.setDzms(sb.toString());
			 String dzms = entity.getDzms_dwdzmlpxz()+entity.getDzms_chdz();
			
			//发送部门ID
			String orgCode = entity.getDzms_sszrqdm();
			if("".equals(orgCode)){
				orgCode = entity.getDzms_sspcsdm();
			}
			//发送内容
			SysMessage sysMsg = new SysMessage();
			String xxnr = "因登记实有单位‘"+entity.getDwmc()+"’无法选择‘"+dzms+"’，请尽快维护该地址！";
			sysMsg.setXxnr(xxnr);
			sysMsg.setXxlb("1");
			sysMsg.setYwurl(","+entity.getId()+","+dzms+","+entity.getDzms_zbx()+","+entity.getDzms_zby()+",0");
			sysMsg.setFsr(sessionBean.getUserName());
			sysMsg.setFsrdm(sessionBean.getUserId());
			sysMsg.setFsrssdw(sessionBean.getUserOrgName());
			sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
			sysMsg.setFssj(DateUtils.getSystemDateTimeString());
			sysMsg.setSfck("0");
			sysMsg.setXxbt("标准地址维护");
			//发送消息提醒
			sysMessageDao.saveMessageByOrg(sysMsg,orgCode, false, false);
		}
		dwjbxxbDao.update(entity, sessionBean);
		//另存为到DW_DWXZXXB表数据更新
		DwxzxxVO dwxzvo = new DwxzxxVO();
		dwxzvo.setId(entity.getId());
		dwxzvo.setSydwlx(entity.getDwlbdm());
		dwxzvo.setGlbmid(entity.getGlbmid());
		dwxzvo.setGlpcsid(StringUtils.isBlank(entity.getGlpcsid())?entity.getGlbmid():entity.getGlpcsid());
		dwxzvo.setGlfxjid(StringUtils.isBlank(entity.getGlfxjid())?entity.getGlbmid():entity.getGlfxjid());
		dwxzvo.setDwbh(entity.getZagldwbm());
		dwxzvo.setDwmc(entity.getDwmc());
		dwxzvo.setXt_zhxgsj(entity.getXt_zhxgsj());
		if(!StringUtils.isBlank(dwxzvo.getDwmc())){
			dwxzvo.setDwqcjm(ContextSearchUtils.getPasswordString(dwxzvo.getDwmc()));
			dwxzvo.setDwqcpyjm(ContextSearchUtils.getPasswordString(dwjbxxbDao.queryPyqp(dwxzvo.getDwmc())));
		}
		dwjbxxbDao.dwXzUpdate(dwxzvo);
		//applicationContext.publishEvent(new SydwModifyEvent(new EventObject(entity.getId(), "update")));
		String dwid = entity.getId();
		dwjbxxbDao.deteleDwbm(dwid);
		if(dwbmxxbArray!=null){
			for (int i = 0; i < dwbmxxbArray.length; i++) {
				Dwbmxxb dwbmxxb = dwbmxxbArray[i];
				if (!"".equals(dwbmxxb.getDwbm())) {
					dwbmxxb.setDwid(dwid);
					BaseService.setSaveProperties(dwbmxxb, sessionBean);
					dwbmxxb.setId(UUID.create()); // 生成主键
					dwjbxxbDao.saveDwbmxxb(dwbmxxb, sessionBean);
				}
			}
		}
	}

	@Override
	public List<Dwbmxxb> queryDwbmxxbByDwid(String dwid) {
		return dwjbxxbDao.queryDwbmxxbByDwid(dwid);
	}
	/**
	 * 判断是否存在该单位，根据单位ID、单位别名
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	@Override
	public boolean queryExistBm(String id, String dwbm) {
		return dwjbxxbDao.queryExistBm(id,dwbm);
	}
	/**
	 * @param str
	 * @return
	 */
	public String CreateDWbh(String str){
		String bh = str.substring(0, 4);
		String dateDate = DateUtils.getSystemDateString();
		String nowDate = dateDate.substring(0,4);
		bh+=nowDate;
		String xh[] = dwjbxxbDao.queryDwbh(bh,1).split(",");
		String newxh = StringUtils.getRightSpecifyString(xh[2], 8, "0");
		String dwbh="";
		dwbh=bh+newxh;
		return dwbh;
	}

	/* (非 Javadoc)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw_dl.service.DwjbxxbService#delete(com.founder.sydw_dl.bean.Dwjbxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void delete(Dwjbxxb entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub

	}
}