package com.founder.zdry.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
import com.founder.zdry.dao.ZdryFzcsfryxxbDao;
import com.founder.zdry.dao.ZdryJgdxxxbDao;
import com.founder.zdry.dao.ZdryLczywblbDao;
import com.founder.zdry.dao.ZdryZdrkxxbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryLczywblbService;

@Service("zdryLczywblbService")
@Transactional
public class ZdryLczywblbServiceImpl extends BaseService implements
		ZdryLczywblbService {

	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryLczywblbDao")
	private ZdryLczywblbDao zdryLczywblbDao;
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;
	@Resource(name = "zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	@Resource(name = "zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	@Resource(name = "zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;

	@SuppressWarnings("unused")
	@Override
	public void changeStateByYwjg(String zdryLczywblbId, SessionBean sessionBean) {
		ZdryZdrkxxb	zdryZdrkxxb=null;
		ZdryZszhjsbrxxb zdryZszhjsbrxxb=null;
		ZdryJgdxxxb  zdryJgdxxxb=null;
		ZdryFzcsfryxxb zdryFzcsfryxxb=null;
		
		ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(zdryLczywblbId);
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		//列管成功，向其他居住地址发送协同消息。
		//并且发送消息给所长
		Map<String, String> dictMap = new HashMap<String, String>();
		Map<String, String> zjDictMap = new HashMap<String, String>();
		Map<String, String> syrklbDictMap = new HashMap<String, String>();
		try {
			dictMap = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
			zjDictMap = sysDictGlService.getDictMap("KX_D_CYZJDM");
			syrklbDictMap = sysDictGlService.getDictMap("D_RK_SYRKGLLB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fxjName = orgOrganizationService
				.queryParentOrgByOrgcode(zdryLczywblb.getSspcsdm()).getOrgname();
		String pcsName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSspcsdm());
		String orgName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSszrqdm());
		SysMessage message = new SysMessage();
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setXxbt("重点人员业务协同");
		message.setXxlb("1");
		if (ZdryLczywblb.YWCLJG_CG.equals(zdryLczywblb.getYwcljg())) {
			if (ZdryLczywblb.YWLX_LG.equals(zdryLczywblb.getYwlx())) {//列管成功
				zdryZdryzb.setGlzt("2");
				List<SyrkSyrkxxzb> list =syrkSyrkxxzbService.queryListByRyid(zdryZdryzb.getRyid());
				for (SyrkSyrkxxzb syrkSyrkxxzb : list) {
					message.setXxnr("你辖区[实有人口管理类型]"+zdryZdryzb.getXm()+"("+zjDictMap.get(zdryZdryzb.getCyzjdm())+zdryZdryzb.getZjhm()+")已被"+fxjName+pcsName+orgName+"列管为"+dictMap.get(zdryZdryzb.getZdrygllxdm()));
					if(!syrkSyrkxxzb.getId().equals(zdryZdryzb.getSyrkid())){
					message.setXxnr(message.getXxnr().replace("[实有人口管理类型]", syrklbDictMap.get("0"+syrkSyrkxxzb.getSyrkywlxdm())));
					sysMessageDao.saveMessageByOrg(message, syrkSyrkxxzb.getGxzrqdm(), false, false);
					}
				}
				//这里判断是上级审批发送消息到局长

			} else if (ZdryLczywblb.YWLX_CG.equals(zdryLczywblb.getYwlx())) {//撤管成功
				zdryZdryzb.setGlzt("4");
				zdryZdryzb.setXt_zxbz("1");
				//注销4类重口表
				if ("02".equals(zdryZdryzb.getZdrygllxdm())||"03".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
					zdryZdrkxxb=zdryZdrkxxbDao.queryById(zdryZdryzb.getId());
				}else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
					zdryJgdxxxb =zdryJgdxxxbDao.queryById(zdryZdryzb.getId());
				}else if ("04".equals(zdryZdryzb.getZdrygllxdm())||"05".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
					zdryZszhjsbrxxb =zdryZszhjsbrxxbDao.queryById(zdryZdryzb.getId());
				}else if ("06".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
					zdryFzcsfryxxb=zdryFzcsfryxxbDao.queryById(zdryZdryzb.getId());
				}
				
				
				//这里生成后续成功列管
				ZdryLczywblb cghywb = zdryLcgService.queryQxyw(zdryLczywblbId);
				if(!StringUtils.isBlank(cghywb.getZdryid())){
					ZdryZdryzb zdryCghzb=zdryZdryzbDao.queryById(cghywb.getZdryid());
					zdryCghzb.setGlzt("2");
					super.setUpdateProperties(zdryCghzb, sessionBean);
					zdryZdryzbDao.update(zdryCghzb);
					message.setXxnr("你辖区"+dictMap.get(zdryZdryzb.getZdrygllxdm())+zdryZdryzb.getXm()+"("+zjDictMap.get(zdryZdryzb.getCyzjdm())+zdryZdryzb.getZjhm()+")在"
					+fxjName+pcsName+orgName+"已被撤管为"+dictMap.get(zdryCghzb.getZdrygllxdm()));
				}else{
					message.setXxnr("你辖区"+dictMap.get(zdryZdryzb.getZdrygllxdm())+zdryZdryzb.getXm()+"("+zjDictMap.get(zdryZdryzb.getCyzjdm())+zdryZdryzb.getZjhm()+")在"
							+fxjName+pcsName+orgName+"已被撤管为放心对象");
				}
				//这里生成后续成功列管 end
				List<ZdryZdryzb> list =zdryZdryzbDao.queryZdryByRyid(zdryZdryzb.getRyid());
				for (ZdryZdryzb zdryZdryzb1 : list) {
					if(!zdryZdryzb1.getId().equals(zdryZdryzb.getSyrkid())){
					sysMessageDao.saveMessageByOrg(message, zdryZdryzb1.getSszrqdm(), false, false);
					}
				}
			}

		} else if (ZdryLczywblb.YWCLJG_SB.equals(zdryLczywblb.getYwcljg())) {
			if (ZdryLczywblb.YWLX_LG.equals(zdryLczywblb.getYwlx())) {//列管失败
				zdryZdryzb.setXt_zxbz("1");
				//注销4类重口表
				if ("2".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
					zdryZdrkxxb=zdryZdrkxxbDao.queryById(zdryZdryzb.getId());
				}else if ("1".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
					zdryJgdxxxb =zdryJgdxxxbDao.queryById(zdryZdryzb.getId());
				}else if ("3".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
					zdryZszhjsbrxxbDao.queryById(zdryZdryzb.getId());
				}else if ("4".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
					zdryFzcsfryxxb=zdryFzcsfryxxbDao.queryById(zdryZdryzb.getId());
				}
			} else if (ZdryLczywblb.YWLX_CG.equals(zdryLczywblb.getYwlx())) {//撤管失败
				zdryZdryzb.setGlzt("2");
				//这里生成后续列管是注销
				ZdryLczywblb cghywb = zdryLcgService.queryQxyw(zdryLczywblbId);
				if(!StringUtils.isBlank(cghywb.getZdryid())){
					ZdryZdryzb zdryCghzb=zdryZdryzbDao.queryById(cghywb.getZdryid());
					super.setCrossoutProperties(zdryCghzb, sessionBean);
					zdryZdryzbDao.delete(zdryCghzb);
				}
				//这里生成后续列管注销 end
			}
		}
		super.setUpdateProperties(zdryZdryzb, sessionBean);
		zdryZdryzbDao.update(zdryZdryzb);
		//注销4类重口表
		if(zdryZdrkxxb!=null){
		super.setCrossoutProperties(zdryZdrkxxb, sessionBean);
		zdryZdrkxxbDao.delete(zdryZdrkxxb);
		}else if(zdryJgdxxxb!=null){
		super.setCrossoutProperties(zdryJgdxxxb, sessionBean);
		zdryJgdxxxbDao.delete(zdryJgdxxxb);
		}else if(zdryZszhjsbrxxb!=null){
		super.setCrossoutProperties(zdryZszhjsbrxxb, sessionBean);
		zdryZszhjsbrxxbDao.delete(zdryZszhjsbrxxb);
		}else if(zdryFzcsfryxxb!=null){
		super.setCrossoutProperties(zdryFzcsfryxxb, sessionBean);
		zdryFzcsfryxxbDao.delete(zdryFzcsfryxxb);
		}
		//注销业务办理和审批表
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryLczywblb entity, SessionBean sessionBean) {
		super.setUpdateProperties(entity, sessionBean);
		zdryLczywblbDao.update(entity);
	}

	public ZdryLczywblb queryById(String id) {
		return zdryLczywblbDao.queryById(id);
	}

}
