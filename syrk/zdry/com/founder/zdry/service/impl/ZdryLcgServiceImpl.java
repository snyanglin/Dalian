package com.founder.zdry.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.assign.service.OrgAssignPublic;
import com.founder.framework.organization.assign.vo.OrgUserInfo;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.RyRylxfsxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.tzgg.bean.Org_Organization;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryJgdxxxb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryNrsxdxxxb;
import com.founder.zdry.bean.ZdryShbzdryxxb;
import com.founder.zdry.bean.ZdrySqjzryxxb;
import com.founder.zdry.bean.ZdrySqsbzdryxxb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdrkxxb;
import com.founder.zdry.bean.ZdryZdrylbb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
import com.founder.zdry.bean.Zdrylxylbdyb;
import com.founder.zdry.dao.ZdryFzcsfryxxbDao;
import com.founder.zdry.dao.ZdryJgdxxxbDao;
import com.founder.zdry.dao.ZdryLczywblbDao;
import com.founder.zdry.dao.ZdryNrsxdxxxbDao;
import com.founder.zdry.dao.ZdryShbzdryxxbDao;
import com.founder.zdry.dao.ZdrySqjzryxxbDao;
import com.founder.zdry.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdry.dao.ZdryYwspbDao;
import com.founder.zdry.dao.ZdryZdrkxxbDao;
import com.founder.zdry.dao.ZdryZdrylbbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdry.service.ZdryGlpzpzbService;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryLczywblbService;
import com.founder.zdry.vo.ZdryVO;
import com.founder.zdry.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.service.impl.ZdryLcgServiceImpl.java]
 * @ClassName: [ZdryLcgServiceImpl]
 * @Description: [列撤功能实现]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:34:08]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:34:08，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("zdryLcgService")
@Transactional
public class ZdryLcgServiceImpl extends BaseService implements ZdryLcgService {

	@Resource(name = "zdryGlpzpzbService")
	private ZdryGlpzpzbService zdryGlpzpzbService;
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;
	@Resource(name = "zdryZdrylbbDao")
	private ZdryZdrylbbDao zdryZdrylbbDao;
	@Resource(name = "zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	@Resource(name = "zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	@Resource(name = "zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;
	@Resource(name = "zdryLczywblbDao")
	private ZdryLczywblbDao zdryLczywblbDao;
	@Resource(name = "zdryYwspbDao")
	private ZdryYwspbDao zdryYwspbDao;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	@Resource(name = "zdryLczywblbService")
	private ZdryLczywblbService zdryLczywblbService;
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "ryRylxfsxxbDao")
	private RyRylxfsxxbDao ryRylxfsxxbDao;
	@Resource(name = "zdrySqjzryxxbDao")
	private ZdrySqjzryxxbDao zdrySqjzryxxbDao;
	@Resource(name = "zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;
	@Resource(name = "zdryNrsxdxxxbDao")
	private ZdryNrsxdxxxbDao zdryNrsxdxxxbDao;
	
	/**
	 * @throws BussinessException
	 *             *
	 * 
	 * @Title: saveLg
	 * @Description: TODO(列管保存逻辑)
	 * @param @param zdryVO
	 * @param @param lgType
	 *        列管类型，用于区别是正常列管需要审批，或者是核实列管/上级指定列管不用审批,type分类为ZdryLczywblb
	 *        .NORMALTYPE / ZdryLczywblb.NOAPPROVALTYPE
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@Override
	public Map<String, String> saveLg(ZdryVO zdryVO, String lcgtype,
			SessionBean sessionBean) throws BussinessException {
		//大连版还是辽宁省厅版
	    String placeVersion = SystemConfig.getString("PlaceVersion");
		Map<String, String> returnMap;
		// 这里到人口复用基本信息，实有人口重构需要修改
		RyRyjbxxb ryjbxxb;
		ZdryZdryzb zdryZdryzb;
		SyrkSyrkxxzb SyrkSyrkxxzb;
		if (!StringUtils.isBlank(zdryVO)) {
			zdryZdryzb = zdryVO.getZdryZdryzb();
		} else {
			throw new BussinessException("zdryVO is not exist");
		}
		if (!StringUtils.isBlank(zdryZdryzb)) {
			SyrkSyrkxxzb = syrkSyrkxxzbService.queryById(zdryZdryzb.getSyrkid());
		} else {
			throw new BussinessException("zdryVO.zdryZdyzb is not exist");
		}
		if (!StringUtils.isBlank(SyrkSyrkxxzb)) {
			ryjbxxb = ryRyjbxxbService.queryById(SyrkSyrkxxzb.getRyid());
		} else {
			throw new BussinessException(
					"zdryVO.zdryZdyzb.Syrkid matching Syrkzb is not exist");
		}
		try {
			BeanUtils.copyObjectSameProperties(ryjbxxb, zdryZdryzb);
			BeanUtils.copyObjectSameProperties(SyrkSyrkxxzb, zdryZdryzb);
			zdryZdryzb.setDz_hjdzdm(ryjbxxb.getHjd_dzid());
			zdryZdryzb.setDz_hjdzmlpdm(ryjbxxb.getHjd_mlpdm());
			zdryZdryzb.setDz_hjdzmlpxz(ryjbxxb.getHjd_mlpxz());
			zdryZdryzb.setDz_hjdzxz(ryjbxxb.getHjd_dzxz());
			zdryZdryzb.setDz_jzdzdm(SyrkSyrkxxzb.getJzd_dzid());
			zdryZdryzb.setDz_jzdzmlpdm(SyrkSyrkxxzb.getJzd_mlpdm());
			zdryZdryzb.setDz_jzdzmlpxz(SyrkSyrkxxzb.getJzd_mlpxz());
			zdryZdryzb.setDz_jzdzxz(SyrkSyrkxxzb.getJzd_dzxz());
			String lxdh = ryRylxfsxxbDao.queryLastLxfs(ryjbxxb.getId()); // 查询最新的联系电话
			zdryZdryzb.setLxdh(lxdh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		zdryZdryzb.setDz_hjdzmlpdm(ryjbxxb.getHjd_mlpdm());
		zdryZdryzb.setDz_hjdzmlpxz(ryjbxxb.getHjd_mlpxz());
		zdryZdryzb.setDz_jzdzmlpdm(SyrkSyrkxxzb.getJzd_mlpdm());
		zdryZdryzb.setDz_jzdzmlpxz(SyrkSyrkxxzb.getJzd_mlpxz());
		zdryZdryzb.setSsfxjdm(SyrkSyrkxxzb.getGxfjdm());
		zdryZdryzb.setSspcsdm(SyrkSyrkxxzb.getGxpcsdm());
		zdryZdryzb.setSszrqdm(SyrkSyrkxxzb.getGxzrqdm());
		if (StringUtils.isBlank(zdryZdryzb.getSfzkdm())) {
			zdryZdryzb.setSfzkdm("1");// 默认在空
		}
		zdryZdryzb.setSfjm("0");// 默认不加密
		zdryZdryzb.setGlzt("1");
		zdryZdryzb.setId(UUID.create());
		super.setSaveProperties(zdryZdryzb, sessionBean);
		zdryZdryzbDao.insert(zdryZdryzb);
		// 保存类别字表,重口小类.
		String zdrylbs[] = zdryVO.getZdrylbStr().split(",");
		for (int i = 0; i < zdrylbs.length; i++) {
			ZdryZdrylbb zdryZdrylbb = new ZdryZdrylbb();
			zdryZdrylbb.setId(UUID.create());
			zdryZdrylbb.setZdryid(zdryZdryzb.getId());
			zdryZdrylbb.setZdrylbdm(zdrylbs[i]);
			super.setSaveProperties(zdryZdrylbb, sessionBean);
			zdryZdrylbbDao.insert(zdryZdrylbb);
		}


		if("大连版".equals(placeVersion)){
			// 这里分别存储类型，判断写死，如需要可用配置表配置类型和表名的对应关系，则代码逻辑可写成统一逻辑
			if ("02".equals(zdryZdryzb.getZdrygllxdm())||"03".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
				ZdryZdrkxxb zdryzdrkxxb = zdryVO.getZdryZdrkxxb();
				if (StringUtils.isBlank(zdryzdrkxxb)) {
					zdryzdrkxxb = new ZdryZdrkxxb();
				}
				zdryzdrkxxb.setId(zdryZdryzb.getId());
			
				BaseService.setSaveProperties(zdryzdrkxxb, sessionBean);
				zdryZdrkxxbDao.insert(zdryzdrkxxb);
			} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
				ZdryJgdxxxb zdryJgdxxxb = zdryVO.getZdryJgdxxxb();
				if (StringUtils.isBlank(zdryJgdxxxb)) {
					zdryJgdxxxb = new ZdryJgdxxxb();
				}
				zdryJgdxxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryJgdxxxb, sessionBean);
				zdryJgdxxxbDao.insert(zdryJgdxxxb);
			} else if ("04".equals(zdryZdryzb.getZdrygllxdm())||"05".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
				ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryVO.getZdryZszhjsbrxxb();
				if (zdryZszhjsbrxxb == null) {
					zdryZszhjsbrxxb = new ZdryZszhjsbrxxb();
				}
				zdryZszhjsbrxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryZszhjsbrxxb, sessionBean);
				zdryZszhjsbrxxbDao.insert(zdryZszhjsbrxxb);
			} else if ("06".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
				ZdryFzcsfryxxb zdryFzcsfryxxb = zdryVO.getZdryFzcsfryxxb();
				if (zdryFzcsfryxxb == null) {
					zdryFzcsfryxxb = new ZdryFzcsfryxxb();
				}
				zdryFzcsfryxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryFzcsfryxxb, sessionBean);
				zdryFzcsfryxxbDao.insert(zdryFzcsfryxxb);
			}else if ("07".equals(zdryZdryzb.getZdrygllxdm())) {// 纳入视线对象
				ZdryNrsxdxxxb zdryNrsxdxxxb = zdryVO.getZdryNrsxdxxxb();
				if (zdryNrsxdxxxb == null) {
					zdryNrsxdxxxb = new ZdryNrsxdxxxb();
				}
				zdryNrsxdxxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryNrsxdxxxb, sessionBean);
				zdryNrsxdxxxbDao.insert(zdryNrsxdxxxb);
	            if(lcgtype.equals(ZdryLczywblb.NORMALTYPE)){
					zdryZdryzb.setGlzt("2");
					 this.zdryZdryzbDao.update(zdryZdryzb);
		                return new HashMap<String, String>();
				}else if(lcgtype.equals(ZdryLczywblb.AFTERCGTYPE)){
					zdryZdryzb.setGlzt("1");
					 this.zdryZdryzbDao.update(zdryZdryzb);

				}
               
			}
			
		}else if("辽宁省厅版".equals(placeVersion)){
			// 这里分别存储类型，判断写死，如需要可用配置表配置类型和表名的对应关系，则代码逻辑可写成统一逻辑
			if ("02".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
				ZdryZdrkxxb zdryzdrkxxb = zdryVO.getZdryZdrkxxb();
				if (StringUtils.isBlank(zdryzdrkxxb)) {
					zdryzdrkxxb = new ZdryZdrkxxb();
				}
				zdryzdrkxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryzdrkxxb, sessionBean);
				zdryZdrkxxbDao.insert(zdryzdrkxxb);
			} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
				ZdrySqjzryxxb sqjzryxxb = zdryVO.getZdrySqjzryxxb();
				if (StringUtils.isBlank(sqjzryxxb)) {
					sqjzryxxb = new ZdrySqjzryxxb();
				}
				sqjzryxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(sqjzryxxb, sessionBean);
				zdrySqjzryxxbDao.save(sqjzryxxb);
			} else if ("03".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
				ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryVO.getZdryZszhjsbrxxb();
				if (zdryZszhjsbrxxb == null) {
					zdryZszhjsbrxxb = new ZdryZszhjsbrxxb();
				}
				zdryZszhjsbrxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryZszhjsbrxxb, sessionBean);
				zdryZszhjsbrxxbDao.insert(zdryZszhjsbrxxb);
			} else if ("04".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
				ZdryFzcsfryxxb zdryFzcsfryxxb = zdryVO.getZdryFzcsfryxxb();
				if (zdryFzcsfryxxb == null) {
					zdryFzcsfryxxb = new ZdryFzcsfryxxb();
				}
				zdryFzcsfryxxb.setId(zdryZdryzb.getId());
				BaseService.setSaveProperties(zdryFzcsfryxxb, sessionBean);
				zdryFzcsfryxxbDao.insert(zdryFzcsfryxxb);
			}
			
			 else if ("08".equals(zdryZdryzb.getZdrygllxdm())) {//涉枪涉爆重点人员
				 ZdrySqsbzdryxxb zdrySqsbzdryxxb = zdryVO.getZdrySqsbzdryxxb();
					if (zdrySqsbzdryxxb == null) {
						zdrySqsbzdryxxb = new ZdrySqsbzdryxxb();
					}
					zdrySqsbzdryxxb.setId(zdryZdryzb.getId());
					BaseService.setSaveProperties(zdrySqsbzdryxxb, sessionBean);
					zdrySqsbzdryxxbDao.insert(zdrySqsbzdryxxb);
				}
		}
		
		// 基础数据保存完成,开始保存业务表数据
		ZdryLczywblb zdryLczywblb = zdryVO.getZdryLczywblb();
		if (StringUtils.isBlank(zdryLczywblb)) {
			throw new BussinessException("zdryVO.zdryLczywblb  is not exist");
		}
		returnMap = saveLczywb(zdryZdryzb, zdryLczywblb, ZdryLczywblb.YWLX_LG,
				sessionBean, lcgtype);
		returnMap.put("zdryLczywblb", zdryLczywblb.getId());
		return returnMap;
	}

	/***
	 * 
	 * @Title: saveCg
	 * @Description: TODO(撤管保存逻辑)
	 * @param @param zdryZbId
	 * @param @param lgType
	 *        列管类型，用于区别是正常列管需要审批，或者是核实列管/上级指定列管不用审批,type分类为ZdryLczywblb
	 *        .NORMALTYPE / ZdryLczywblb.NOAPPROVALTYPE
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@Override
	public Map<String, String> saveCg(ZdryVO zdryVO, String lcgtype,
			SessionBean sessionBean, String cglxdm) throws BussinessException {
	    String placeVersion = SystemConfig.getString("PlaceVersion");
		ZdryZdryzb zdryZdyzb;
		zdryZdyzb = zdryZdryzbDao.queryBySyrkidAndgllx(zdryVO.getZdryZdryzb()
				.getSyrkid(), cglxdm);// 根据实有人口ID重点人员管理类型代码
		if (StringUtils.isBlank(zdryZdyzb)) {
			throw new BussinessException("check the param zdryZbId");
		}
		//如果是纳入视线对象撤管 直接撤 不需要审批
		if("07".equals(cglxdm)){
			zdryZdyzb.setXt_zxbz("1");
			zdryZdyzb.setGlzt("4");
			super.setUpdateProperties(zdryZdyzb, sessionBean);
			zdryZdryzbDao.update(zdryZdyzb);
			
			ZdryNrsxdxxxb zdryNrsxdxxxb = this.zdryNrsxdxxxbDao.queryById(zdryVO.getZdryZdryzb().getId());
			if(zdryNrsxdxxxb!=null){
				zdryNrsxdxxxb.setXt_zxbz("1");
				BaseService.setUpdateProperties(zdryNrsxdxxxb, sessionBean);
				zdryNrsxdxxxbDao.update(zdryNrsxdxxxb);
			}
		
			return new HashMap<String, String>();
		}else{
			zdryZdyzb.setGlzt("3");
			super.setUpdateProperties(zdryZdyzb, sessionBean);
			zdryZdryzbDao.update(zdryZdyzb);
			// 处理业务表
			ZdryLczywblb zdryLczywblb = zdryVO.getZdryLczywblb();
			if (StringUtils.isBlank(zdryLczywblb)) {
				throw new BussinessException("zdryVO.zdryLczywblb  is not exist");
			}
			Map<String, String> cgMap = saveLczywb(zdryZdyzb, zdryLczywblb,
					ZdryLczywblb.YWLX_CG, sessionBean, lcgtype);
			// 保存撤管后的重口类型
			if("大连版".equals(placeVersion)){
				if (!"09".equals(zdryVO.getZdryZdryzb().getZdrygllxdm())) {// 如果撤管后为放心对象并且不是纳入视线对象不进入列管流程
					zdryLczywblb.setYwfqyy("撤管后并且列管");
					zdryLczywblb.setQxywid(cgMap.get("zdryLczywblbId"));
					saveLg(zdryVO, ZdryLczywblb.AFTERCGTYPE, sessionBean);
				}
			}else if("辽宁省厅版".equals(placeVersion)){
				if (!"09".equals(zdryVO.getZdryZdryzb().getZdrygllxdm())) {// 如果撤管后为放心对象不进入列管流程
					if("08".equals(zdryVO.getZdryZdryzb().getZdrygllxdm())){//如果是涉枪涉爆重点人员 保存撤管时间和撤管原因
						ZdrySqsbzdryxxb sqsbzdryxxb=this.zdrySqsbzdryxxbDao.queryById(zdryVO.getZdryZdryzb().getId());
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");					
						sqsbzdryxxb.setCgsj(sdf.format(new Date()));
						this.zdrySqsbzdryxxbDao.update(sqsbzdryxxb);
					}
					zdryLczywblb.setYwfqyy("撤管后并且列管");
					zdryLczywblb.setQxywid(cgMap.get("zdryLczywblbId"));
					saveLg(zdryVO, ZdryLczywblb.AFTERCGTYPE, sessionBean);
				}
			}
			return cgMap;
		}
	
		

	

	}

	/***
	 * 
	 * @Title: saveLczywb
	 * @Description: TODO(保存业务表)
	 * @param @param zdryZdyzb
	 * @param @param zdryLczywblb
	 * @param @param ywlx
	 * @param @param sessionBean
	 * @param @param lcgtype
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	@Override
	public Map<String, String> saveLczywb(ZdryZdryzb zdryZdyzb,
			ZdryLczywblb zdryLczywblb, String ywlx, SessionBean sessionBean,
			String lcgtype) throws BussinessException {
	    String placeVersion = SystemConfig.getString("PlaceVersion");

		Map<String, String> returnMap = new HashMap<String, String>();
		String messageId = "";
		zdryLczywblb.setZdryid(zdryZdyzb.getId());
		zdryLczywblb.setYwlx(ywlx);
		try {
			BeanUtils.copyObjectSameProperties(zdryZdyzb, zdryLczywblb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		zdryLczywblb.setId(UUID.create());
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		zdryLczywblbDao.save(zdryLczywblb);
		// 处理审批
		if (ZdryLczywblb.NOAPPROVALTYPE.equals(lcgtype)||("5".equals(zdryZdyzb.getZdrygllxdm())&&!ZdryLczywblb.AFTERCGTYPE.equals(lcgtype))||("8".equals(zdryZdyzb.getZdrygllxdm())&&!ZdryLczywblb.AFTERCGTYPE.equals(lcgtype))) {// 非正常流程不走审批,类型为纳入实现，不走审批流程
			zdryLczywblb.setYwcljg("1");
			
		}else if (ZdryLczywblb.AFTERCGTYPE.equals(lcgtype)) {// 撤管后并列管,列管不生效等待撤管审批
			zdryLczywblb.setYwcljg("0");
		}
		 else if (ZdryLczywblb.NORMALTYPE.equals(lcgtype)
					|| StringUtils.isBlank(lcgtype)) {// 正常流程需要审批
				zdryLczywblb.setYwcljg("0");
				// 审批逻辑为，如没有上级部门，所长审批，有上级部门升级部门审批。所有审批只有一级
				ZdryGlpzpzb zdryglpzpzb = zdryGlpzpzbService
						.queryByZdrygllxdm(zdryZdyzb.getZdrygllxdm());
				if (StringUtils.isBlank(zdryglpzpzb)) {// 如果没有上级部门,所长审批
				//	messageId = sendApproval(zdryZdyzb.getSspcsdm(), "SZ",
				//			zdryLczywblb.getId(), sessionBean);
				
					if("大连版".equals(placeVersion)){
						//肇事肇祸、轻微滋事、非正常上访发给治安管理支队派出所工作大队
						if("04".equals(zdryZdyzb.getZdrygllxdm())||"05".equals(zdryZdyzb.getZdrygllxdm())||"06".equals(zdryZdyzb.getZdrygllxdm())){
							messageId = sendApproval("210200240700", null,
									zdryLczywblb.getId(), sessionBean);
							
						}else{
							messageId = sendApproval(zdryZdyzb.getSspcsdm(), "SZ",
									zdryLczywblb.getId(), sessionBean);
						}
					}else if("辽宁省厅版".equals(placeVersion)){
						messageId = sendApproval(zdryZdyzb.getSspcsdm(), "SZ",
								zdryLczywblb.getId(), sessionBean);
					}
					
				} else {
					messageId = sendApproval(zdryglpzpzb.getJgbmdm(), null,
							zdryLczywblb.getId(), sessionBean);
				}
			} 
		
		zdryLczywblbDao.update(zdryLczywblb);
		zdryLczywblbService.changeStateByYwjg(zdryLczywblb.getId(), sessionBean);
		if(ZdryLczywblb.NOAPPROVALTYPE.equals(lcgtype)){
			//并且发送消息给所长
			Map<String, String> dictMap = new HashMap<String, String>();
			try {
				dictMap = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
			} catch (Exception e) {
				e.printStackTrace();
			}
			SysMessage message = new SysMessage();
			message.setFsr(sessionBean.getUserName());
			message.setFsrdm(sessionBean.getUserId());
			message.setFssj(DateUtils.getSystemDateTimeString());
			message.setFsrssdw(sessionBean.getUserOrgName());
			message.setFsrssdwdm(sessionBean.getUserOrgCode());
			message.setXxnr("重点人员["+zdryZdyzb.getXm()+"]已被核实为["+dictMap.get(zdryZdyzb.getZdrygllxdm())+"]");
			message.setXxbt("重点人员核实");
			message.setXxlb("1");
			
		}
		returnMap.put("messageId", messageId);
		returnMap.put("zdryZbId", zdryZdyzb.getId());
		returnMap.put("zdryLczywblbId", zdryLczywblb.getId());
		return returnMap;
	}

	/***
	 * 
	 * @Title: sendApproval
	 * @Description: TODO(审批信息发送，如果postion为null，则发送至部门。针对某条业务表信息发送审批任务)
	 * @param @param orgcode 部门
	 * @param @param position 岗位
	 * @param @param lczywbId 业务信息ID
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@Override
	public String sendApproval(String orgcode, String position,
			String lczywbId, SessionBean sessionBean) throws BussinessException {

		OrgAssignPublic orgAssignPublic = new OrgAssignPublic();
		List<OrgUserInfo> list = orgAssignPublic.queryUserByOrgAndPos(orgcode,position);
		if((list == null || list.isEmpty())&&!StringUtils.isBlank(position)){
			throw new BussinessException("没有配置岗位，无法找到审批人，申请失败！");
		}
		// 根据业务表数据,构造代办消息
		SysMessage message = new SysMessage();
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(lczywbId);
		if (StringUtils.isBlank(zdryLczywblb)) {
			throw new BussinessException("check the param lczywbId");
		}
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		Map<String, String> dictMap = new HashMap<String, String>();
		try {
			dictMap = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 记录审批表
		ZdryYwspb zdryYwspb = new ZdryYwspb();
		if (!ZdryLczywblb.YWLX_ZDJS.equals(zdryLczywblb.getYwlx())) {
			zdryYwspb.setId(UUID.create());
			zdryYwspb.setSqr_id(zdryLczywblb.getYwblr_id());
			zdryYwspb.setSqr_xm(zdryLczywblb.getYwblr_xm());
			zdryYwspb.setSqsj(zdryLczywblb.getYwclsj());
			if((list == null || list.isEmpty())&&!StringUtils.isBlank(position)){
				zdryYwspb.setSpbm(orgcode);
			}else{
				zdryYwspb.setSpbm(orgcode);
				zdryYwspb.setSpr_id(list.get(0).getUserid());
			}
			zdryYwspb.setSqyj(zdryLczywblb.getYwfqyy());
			zdryYwspb.setYwbm("ZDRY_LCZYWBLB");
			zdryYwspb.setYwbid(zdryLczywblb.getId());
			super.setSaveProperties(zdryYwspb, sessionBean);
			zdryYwspbDao.save(zdryYwspb);
		}
		String xxnr = "";
		String url = "";
		String orgName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSszrqdm());
		String pcsName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSspcsdm());
		
		if (ZdryLczywblb.YWLX_LG.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员列管审批");
			xxnr = orgName + "民警" + zdryLczywblb.getYwblr_xm() + "提交"
					+ dictMap.get(zdryZdryzb.getZdrygllxdm())
					+ zdryZdryzb.getXm() + "的列管申请，请审批。";
			url = "/zdryLcg/creatLcgApporval?zdryYwspbId=" + zdryYwspb.getId();
		} else if (ZdryLczywblb.YWLX_CG.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员撤管审批");
			String fjName=	orgOrganizationService
					.queryParentOrgByOrgcode(zdryLczywblb.getSspcsdm()).getOrgname();
			xxnr =fjName+pcsName+orgName + "民警" + zdryLczywblb.getYwblr_xm() + "提交"
					+ dictMap.get(zdryZdryzb.getZdrygllxdm())
					+ zdryZdryzb.getXm() + "的撤管申请，请审批。";
			url = "/zdryLcg/creatLcgApporval?zdryYwspbId=" + zdryYwspb.getId();
		} else if (ZdryLczywblb.YWLX_ZDJS.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员转递请求");
			ZdryLczywblb fqyw = zdryLczywblbDao.queryById(zdryLczywblb.getQxywid());
			pcsName = orgOrganizationService.queryOrgNameByOrgcodes(fqyw
					.getSszrqdm());
			orgName = orgOrganizationService.queryOrgNameByOrgcodes(fqyw
					.getSspcsdm());
			xxnr = pcsName + "、" + orgName + "民警" + fqyw.getYwblr_xm()
					+ "将" + dictMap.get(zdryZdryzb.getZdrygllxdm())
					+ zdryZdryzb.getXm() + "转递给你辖区，请处理。";
			url = "/zdryZd/createZdjs?zdryLczywblbId=" + lczywbId;
		} else if (ZdryLczywblb.YWLX_ZDCJ.equals(zdryLczywblb.getYwlx())) {
			// 查询前序业务信息
			ZdryLczywblb jsyw = zdryLczywblbDao.queryById(zdryLczywblb
					.getQxywid());
			ZdryLczywblb fqyw = zdryLczywblbDao.queryById(jsyw.getQxywid());
			pcsName = orgOrganizationService.queryOrgNameByOrgcodes(jsyw
					.getSszrqdm());
			orgName = orgOrganizationService.queryOrgNameByOrgcodes(jsyw
					.getSspcsdm());
			String qx_orgName = orgOrganizationService
					.queryOrgNameByOrgcodes(fqyw.getSszrqdm());
			String qx_pcsName = orgOrganizationService
					.queryOrgNameByOrgcodes(fqyw.getSspcsdm());
			message.setXxbt("重点人员转递裁定");
			xxnr = qx_pcsName + "、" + qx_orgName + fqyw.getYwblr_xm() + "将"
					+ dictMap.get(zdryZdryzb.getZdrygllxdm())
					+ zdryZdryzb.getXm() + "转递至" + pcsName + "、" + orgName
					+ "该辖区民警" + jsyw.getYwblr_xm() + "拒绝接收，请裁定。";
			url = "/zdryZd/createZdjs?zdryLczywblbId=" + lczywbId
					+ "&type=sjcj";
		}else if (ZdryShbzdryxxbServiceImpl.ZDRYGLLXDM.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("涉环保重点人员列管审批");
			
			xxnr = zdryLczywblb.getBz()  + zdryLczywblb.getYwblr_xm() + "提交"
					+ "涉环保重点人员"
					+ zdryZdryzb.getXm() + "的列管申请，请审批。";
			String spdj="1";
			if(position.equals("ZDZ")||position.equals("FJZ")){
				spdj="2";
			}
			url = "/zdryLcg/creatLcgApporval?zdryYwspbId=" + zdryYwspb.getId()+"&spdj="+spdj;

		}
		
		message.setXxnr(xxnr);
		message.setYwurl(url);
		message.setXxlb("5");
		if (StringUtils.isBlank(position)) {
			sysMessageDao.saveMessageByOrg(message, orgcode, false, false);
		} else {
			sysMessageDao.saveMessageByOrgAndPos(message, orgcode, position);
		}

		return String.valueOf(message.getId());
	}

	/***
	 * 
	 * @Title: sendMessageByLczywb
	 * @Description: TODO(根据不同业务给不同的人发送不同的消息内容)
	 * @param @param lczywbId
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void sendMessageByLczywb(String lczywbId, SessionBean sessionBean) {
	    String placeVersion = SystemConfig.getString("PlaceVersion");

		Map<String, String> dictMap = new HashMap<String, String>();
		try {
			dictMap = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据业务表数据,构造代办消息
		SysMessage message = new SysMessage();
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(lczywbId);
		String xxnr = "";
		String userIDString = "";
		String orgcode="";
		// 根据业务查询相关的审批表
		ZdryYwspb zdryYwspb = new ZdryYwspb();
		zdryYwspb.setYwbid(zdryLczywblb.getId());
		zdryYwspb.setYwbm("ZDRY_LCZYWBLB");
		List<ZdryYwspb> zdryYwspbList = zdryYwspbDao.query(zdryYwspb);
		// 这里如果以个业务多次审批,则取最后一条记录为准
		if (zdryYwspbList != null && zdryYwspbList.size() > 0) {
			zdryYwspb = zdryYwspbList.get(0);
		}
		// 查询相关重点人员总表
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		String spbm = orgOrganizationService.queryOrgNameByOrgcodes(zdryYwspb
				.getSpbm());
		String pcsName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSspcsdm());
		String orgName = orgOrganizationService
				.queryOrgNameByOrgcodes(zdryLczywblb.getSszrqdm());
		if (ZdryLczywblb.YWLX_LG.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员列管审批结果");
			if (zdryLczywblb.getYwcljg().equals("1")) {
				xxnr = spbm + zdryYwspb.getSpr_xm() + "审批同意重点人员"
						+ zdryZdryzb.getXm() + "的列管申请。";
			} else if (zdryLczywblb.getYwcljg().equals("2")) {
				xxnr = spbm + zdryYwspb.getSpr_xm() + "审批不同意重点人员"
						+ zdryZdryzb.getXm() + "的列管申请。";
			}
			userIDString = zdryLczywblb.getYwblr_id();
		} else if (ZdryLczywblb.YWLX_CG.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员撤管审批结果");
			// 撤管，找寻撤管后类型
			ZdryZdryzb cghZdryZb=null;
			ZdryLczywblb cghyw = queryQxyw(zdryLczywblb.getId());
			if(StringUtils.isBlank(cghyw.getId())){
				cghZdryZb =new ZdryZdryzb();
				if("大连版".endsWith(placeVersion)){
					cghZdryZb.setZdrygllxdm("06");

				}else if("辽宁省厅版".endsWith(placeVersion)){
					cghZdryZb.setZdrygllxdm("09");

				}
			}else{
			 cghZdryZb = zdryZdryzbDao.queryById(cghyw.getZdryid());
	
			}
			if (zdryLczywblb.getYwcljg().equals("1")) {
				xxnr = spbm + zdryYwspb.getSpr_xm() + "审批同意将重点人员"
						+ zdryZdryzb.getXm() + "撤管为"
						+ dictMap.get(cghZdryZb.getZdrygllxdm()) + "的申请。";
				if(cghZdryZb!=null){
					cghZdryZb.setGlzt("4");
					this.zdryZdryzbDao.update(cghZdryZb);
				}
					 
				 
			} else if (zdryLczywblb.getYwcljg().equals("2")) {
				xxnr = spbm + zdryYwspb.getSpr_xm() + "审批不同意将重点人员"
						+ zdryZdryzb.getXm() + "撤管为"
						+ dictMap.get(cghZdryZb.getZdrygllxdm()) + "的申请。";
				
				if(cghZdryZb!=null){
					cghZdryZb.setGlzt("2");
					this.zdryZdryzbDao.update(cghZdryZb);

				}
					 
				 
			}
			userIDString = zdryLczywblb.getYwblr_id();
		} else if (ZdryLczywblb.YWLX_ZDJS.equals(zdryLczywblb.getYwlx())) {
			// 发起辖区
			ZdryLczywblb fqyw = zdryLczywblbDao.queryById(zdryLczywblb
					.getQxywid());
			message.setXxbt("重点人员转递结果");
			if (zdryLczywblb.getYwcljg().equals("1")) {
				xxnr = pcsName + "、" + orgName + "民警"
						+ zdryLczywblb.getYwblr_xm() + "已同意接收"
						+ dictMap.get(zdryZdryzb.getZdrygllxdm())
						+ zdryZdryzb.getXm() + "。";
			} else if (zdryLczywblb.getYwcljg().equals("2")) {
				xxnr = pcsName + "、" + orgName + "民警"
						+ zdryLczywblb.getYwblr_xm() + "拒绝"
						+ dictMap.get(zdryZdryzb.getZdrygllxdm())
						+ zdryZdryzb.getXm() + "转递请求，已发送给" + spbm + "进行裁定。";
			}
			userIDString = fqyw.getYwblr_id();
		} else if (ZdryLczywblb.YWLX_ZDCJ.equals(zdryLczywblb.getYwlx())) {
			message.setXxbt("重点人员裁定结果");
			// 查询原辖区和现辖区
			// 接收辖区
			ZdryLczywblb jsyw = zdryLczywblbDao.queryById(zdryLczywblb
					.getQxywid());
			ZdryLczywblb fqyw = zdryLczywblbDao.queryById(jsyw.getQxywid());
			// 发起辖区
			String ypcs = orgOrganizationService.queryOrgNameByOrgcodes(fqyw
					.getSspcsdm());
			String yzrq = orgOrganizationService.queryOrgNameByOrgcodes(fqyw
					.getSszrqdm());
			String xpcs = orgOrganizationService.queryOrgNameByOrgcodes(jsyw
					.getSspcsdm());
			String xzrq = orgOrganizationService.queryOrgNameByOrgcodes(jsyw
					.getSszrqdm());
			if (zdryLczywblb.getYwcljg().equals("0")) {
				xxnr = "原辖区为" + ypcs + "、" + yzrq + "的"
						+ dictMap.get(zdryZdryzb.getZdrygllxdm())
						+ zdryZdryzb.getXm() + "裁定为由原辖区继续管理。";
			} else if (zdryLczywblb.getYwcljg().equals("1")) {
				xxnr = "原辖区为" + ypcs + "、" + yzrq + "的"
						+ dictMap.get(zdryZdryzb.getZdrygllxdm())
						+ zdryZdryzb.getXm() + "裁定为由接收辖区" + xpcs + xzrq + "管理。";
			}
			userIDString = jsyw.getYwblr_id() + "," + fqyw.getYwblr_id();
			orgcode= jsyw.getSszrqdm() + "," + fqyw.getSszrqdm();
		}
		message.setXxnr(xxnr);
		message.setXxlb("1");
		sysMessageDao.saveMessageByUser(message, userIDString);
		sysMessageDao.saveMessageByOrgAndPos(message, orgcode, "SZ");
	}

	/***
	 * 
	 * @Title: queryQxyw
	 * @Description: 私有方法,根据业务ID取得后续业务对象,多用于撤管业务后取得列管内容
	 * @param @param zdryLczywblbId
	 * @param @return 设定文件
	 * @return ZdryLczywblb 返回类型
	 * @throws
	 */
	public ZdryLczywblb queryQxyw(String zdryLczywblbId) {
		// 撤管，找寻撤管后类型
		
		ZdryLczywblb zdryLczywblb = new ZdryLczywblb();
		zdryLczywblb.setQxywid(zdryLczywblbId);
		List<ZdryLczywblb> list = zdryLczywblbDao.query(zdryLczywblb);
		if (list != null && list.size() > 0) {
			zdryLczywblb = list.get(0);
		}
		return zdryLczywblb;
	}

	/***
	 * 
	 * @Title: getZdryGlLxByList
	 * @Description: 根据查询结果处理要显示的STR和撤管可选择的过滤条件
	 * @param @param list
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型包含要显示的str和可以过滤的条件
	 * @throws
	 */
	@Override
	public Map<String, String> getZdryGlLxByList(List<ZdryZdryzbVO> list,String syrkid) {
		Map<String, String> returnMap = new HashMap<String, String>();
		Map<String, String> dictMap=new HashMap<String, String>();;
		try {
			dictMap = sysDictGlService.getDictMap("BD_D_ZDRYLBDM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String  displayStr= "";
		String  filterStr= "";
		String filterZdStr="";
		for (int i = 0; i < list.size(); i++) {
			ZdryZdryzbVO zdryZdryzbVO= list.get(i);
			//这里只要有监管类型就放入已列管,全市只能有一个监管
			if(zdryZdryzbVO.getZdrygllxdm().equals("01")){
				filterStr="01";
			}
			//end
			if(zdryZdryzbVO.getSyrkid().equals(syrkid)){
				displayStr+=dictMap.get(zdryZdryzbVO.getZdrygllxdm());
				
				if(!StringUtils.isBlank(zdryZdryzbVO.getJgbmmc())&&"1".equals(zdryZdryzbVO.getSfsjsp())){
					displayStr+="("+zdryZdryzbVO.getJgbmmc()+")";
				}
				if("1".equals(zdryZdryzbVO.getGlzt())){
					displayStr+="(列管中),";
				}else if("3".equals(zdryZdryzbVO.getGlzt())){
					displayStr+="(撤管中),";
				}else if("5".equals(zdryZdryzbVO.getGlzt())){
					displayStr+="(转递中),";
				}
				else {
					displayStr+=",";
					if(StringUtils.isBlank(filterZdStr)){
						filterZdStr=zdryZdryzbVO.getZdrygllxdm();
					}else{
						filterZdStr+="|"+zdryZdryzbVO.getZdrygllxdm();
					}
				}
				if(StringUtils.isBlank(filterStr)){
					filterStr=zdryZdryzbVO.getZdrygllxdm();
				}else{
					filterStr+="|"+zdryZdryzbVO.getZdrygllxdm();
				}
			}
		}
		if(StringUtils.isBlank(filterZdStr)){
			filterZdStr="9999";//如有没有，则所有不可以选
		}
		if(!StringUtils.isBlank(displayStr)){
			displayStr=displayStr.substring(0,displayStr.length()-1);
		}
		returnMap.put("displayStr", displayStr);
		returnMap.put("filterStr", filterStr);
		returnMap.put("filterZdStr", filterZdStr);
		return returnMap;
	}

	/***
	 * 
	 * @Title: getZdrylbdmExceptYlg
	 * @Description: 根据大类取小类,去掉已列管在
	 *               这里为降低时间复杂度,把2个list<object>转为list<String>,时间复制度由M*N降为M+M+N
	 * @author wu_chunhui@founder.com.cn
	 * @param zdrylxdm
	 *            大类代码
	 * @param zdryid
	 *            重点人员ID
	 * @return String 过来字符串,直接传入setDataFilter方法就可以
	 * @throws
	 */
	@Override
	public List<String> getZdrylbdmExceptYlg(List<Zdrylxylbdyb> zdrylbdmList,
			String zdryid) {

		List<ZdryZdrylbb> ylglbList = zdryZdrylbbDao.queryByZdryid(zdryid);
		// 这里为降低时间复杂度,把2个list转为list<String>,时间复制度由M*N降为M+M+N
		List<String> zdrylbdmListStr = new ArrayList<String>();
		List<String> ylglbListStr = new ArrayList<String>();
		for (int i = 0; i < zdrylbdmList.size(); i++) {
			zdrylbdmListStr.add(zdrylbdmList.get(i).getZdrylbdm());
		}
		for (int i = 0; i < ylglbListStr.size(); i++) {
			ylglbListStr.add(ylglbList.get(i).getZdrylbdm());
		}
		zdrylbdmListStr.removeAll(ylglbListStr);// 重集合内移除已经列管的集合

		return zdrylbdmListStr;
	}

	
	/***
	 * 
	 * @Title: getALLZdrylb
	 * @Description: TODO(根据重点人员ID取得所有类别小类)
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getALLZdrylb(String zdryid){
		String zdrylb="";
		List<ZdryZdrylbb> list =zdryZdrylbbDao.queryByZdryid(zdryid);
		for (ZdryZdrylbb zdryZdrylbb : list) {
			if(StringUtils.isBlank(zdrylb)){
				zdrylb=zdryZdrylbb.getZdrylbdm();
			}else{
				zdrylb+=","+zdryZdrylbb.getZdrylbdm();
			}
		}
		return zdrylb;
		
	}

	/***
	 * 
	 * @Title: queryByZdrylx
	 * @Description: TODO()
	 * @param @param zdryVO
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	@Override
	public ZdryVO queryByZdrylx(String zdryid) {
	    String placeVersion = SystemConfig.getString("PlaceVersion");

		ZdryVO zdryVO =new ZdryVO();
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryid);
		zdryVO.setZdryZdryzb(zdryZdryzb);
		if(zdryZdryzb!=null){
			// 取得小类.
			String zdrylbs=getALLZdrylb(zdryid);
			zdryVO.setZdrylbStr(zdrylbs);
			if("大连版".equals(placeVersion)){
				// 取得对应信息
				if ("02".equals(zdryZdryzb.getZdrygllxdm())||"03".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
					ZdryZdrkxxb zdryzdrkxxb = zdryZdrkxxbDao.queryById(zdryid);
					zdryVO.setZdryZdrkxxb(zdryzdrkxxb);
				} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
					ZdryJgdxxxb zdryJgdxxxb = zdryJgdxxxbDao.queryById(zdryid);
					zdryVO.setZdryJgdxxxb(zdryJgdxxxb);
				} else if ("04".equals(zdryZdryzb.getZdrygllxdm())||"05".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
					ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryZszhjsbrxxbDao.queryById(zdryid);
					zdryVO.setZdryZszhjsbrxxb(zdryZszhjsbrxxb);
				} else if ("06".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
					ZdryFzcsfryxxb zdryFzcsfryxxb = zdryFzcsfryxxbDao.queryById(zdryid);
					zdryVO.setZdryFzcsfryxxb(zdryFzcsfryxxb);
				}else if ("07".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
					ZdryNrsxdxxxb nrsx = zdryNrsxdxxxbDao.queryById(zdryid);
					zdryVO.setZdryNrsxdxxxb(nrsx);
				}
			}else if("辽宁省厅版".equals(placeVersion)){
				// 取得对应信息
				if ("02".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
					ZdryZdrkxxb zdryzdrkxxb = zdryZdrkxxbDao.queryById(zdryid);
					zdryVO.setZdryZdrkxxb(zdryzdrkxxb);
				} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {//社区矫正
					ZdrySqjzryxxb zdrySqjzryxxb = zdrySqjzryxxbDao.queryById(zdryid);
					zdryVO.setZdrySqjzryxxb(zdrySqjzryxxb);
				} else if ("03".equals(zdryZdryzb.getZdrygllxdm())) {// 肇事肇祸
					ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryZszhjsbrxxbDao.queryById(zdryid);
					zdryVO.setZdryZszhjsbrxxb(zdryZszhjsbrxxb);
				} else if ("04".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
					ZdryFzcsfryxxb zdryFzcsfryxxb = zdryFzcsfryxxbDao.queryById(zdryid);
					zdryVO.setZdryFzcsfryxxb(zdryFzcsfryxxb);
				}else if ("06".equals(zdryZdryzb.getZdrygllxdm())) {//其他关注对象
					ZdryFzcsfryxxb zdryFzcsfryxxb = zdryFzcsfryxxbDao.queryById(zdryid);
					zdryVO.setZdryFzcsfryxxb(zdryFzcsfryxxb);
				}
				else if ("08".equals(zdryZdryzb.getZdrygllxdm())) {// 涉枪涉爆
					ZdrySqsbzdryxxb zdrySqsbzdryxxb = zdrySqsbzdryxxbDao.queryById(zdryid);
					zdryVO.setZdrySqsbzdryxxb(zdrySqsbzdryxxb);
				}
				
			}
		
		}
		return zdryVO;
	}

	@Override
	public void updateByZdrylx(ZdryVO zdryVO,SessionBean sessionBean) {
		//大连版还是辽宁省厅版
	    String placeVersion = SystemConfig.getString("PlaceVersion");
		ZdryZdryzb zdryZdryzb = zdryVO.getZdryZdryzb();
				// 保存类别字表,重口小类.先删除以前小类
		        ZdryZdrylbb zdryZdrylbbDel = new ZdryZdrylbb();
		        zdryZdrylbbDel.setZdryid(zdryZdryzb.getId());
		        super.setCrossoutProperties(zdryZdrylbbDel, sessionBean);
				zdryZdrylbbDao.deleteByZdryid(zdryZdrylbbDel);
				String zdrylbs[] = zdryVO.getZdrylbStr().split(",");
				for (int i = 0; i < zdrylbs.length; i++) {
					ZdryZdrylbb zdryZdrylbb = new ZdryZdrylbb();
					zdryZdrylbb.setId(UUID.create());
					zdryZdrylbb.setZdryid(zdryZdryzb.getId());
					zdryZdrylbb.setZdrylbdm(zdrylbs[i]);
					super.setSaveProperties(zdryZdrylbb, sessionBean);
					zdryZdrylbbDao.insert(zdryZdrylbb);
				}
				if("大连版".equals(placeVersion)){
					//根据类型更新
					if ("02".equals(zdryZdryzb.getZdrygllxdm())||"03".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
						ZdryZdrkxxb zdryzdrkxxb = zdryVO.getZdryZdrkxxb();
						if (StringUtils.isBlank(zdryzdrkxxb)) {
							zdryzdrkxxb = new ZdryZdrkxxb();
						}
						zdryzdrkxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryzdrkxxb, sessionBean);
						zdryZdrkxxbDao.update(zdryzdrkxxb);
					} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 监管对象
						ZdryJgdxxxb zdryJgdxxxb = zdryVO.getZdryJgdxxxb();
						if (StringUtils.isBlank(zdryJgdxxxb)) {
							zdryJgdxxxb = new ZdryJgdxxxb();
						}
						zdryJgdxxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryJgdxxxb, sessionBean);
						zdryJgdxxxbDao.update(zdryJgdxxxb);
					} else if ("04".equals(zdryZdryzb.getZdrygllxdm())||"05".equals(zdryZdryzb.getZdrygllxdm())) {// 精神病人
						ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryVO.getZdryZszhjsbrxxb();
						if (zdryZszhjsbrxxb == null) {
							zdryZszhjsbrxxb = new ZdryZszhjsbrxxb();
						}
						zdryZszhjsbrxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryZszhjsbrxxb, sessionBean);
						zdryZszhjsbrxxbDao.update(zdryZszhjsbrxxb);
					} else if ("06".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
						ZdryFzcsfryxxb zdryFzcsfryxxb = zdryVO.getZdryFzcsfryxxb();
						if (zdryFzcsfryxxb == null) {
							zdryFzcsfryxxb = new ZdryFzcsfryxxb();
						}
						zdryFzcsfryxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryFzcsfryxxb, sessionBean);
						zdryFzcsfryxxbDao.update(zdryFzcsfryxxb);
					} else if ("07".equals(zdryZdryzb.getZdrygllxdm())) {// 纳入视线
						ZdryNrsxdxxxb zdryNrsxdxxxb = zdryVO.getZdryNrsxdxxxb();
						if (zdryNrsxdxxxb == null) {
							zdryNrsxdxxxb = new ZdryNrsxdxxxb();
						}
						zdryNrsxdxxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryNrsxdxxxb, sessionBean);
						zdryNrsxdxxxbDao.update(zdryNrsxdxxxb);
					}
				}else if("辽宁省厅版".equals(placeVersion)){
					//根据类型更新
					if ("02".equals(zdryZdryzb.getZdrygllxdm())) {// 重口
						ZdryZdrkxxb zdryzdrkxxb = zdryVO.getZdryZdrkxxb();
						if (StringUtils.isBlank(zdryzdrkxxb)) {
							zdryzdrkxxb = new ZdryZdrkxxb();
						}
						zdryzdrkxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryzdrkxxb, sessionBean);
						zdryZdrkxxbDao.update(zdryzdrkxxb);
					} else if ("01".equals(zdryZdryzb.getZdrygllxdm())) {// 社区矫正
						ZdrySqjzryxxb sqjz = zdryVO.getZdrySqjzryxxb();
						if (StringUtils.isBlank(sqjz)) {
							sqjz = new ZdrySqjzryxxb();
						}
						sqjz.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(sqjz, sessionBean);
						zdrySqjzryxxbDao.update(sqjz);
					} else if ("03".equals(zdryZdryzb.getZdrygllxdm())) {// 肇事肇祸
						ZdryZszhjsbrxxb zdryZszhjsbrxxb = zdryVO.getZdryZszhjsbrxxb();
						if (zdryZszhjsbrxxb == null) {
							zdryZszhjsbrxxb = new ZdryZszhjsbrxxb();
						}
						zdryZszhjsbrxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryZszhjsbrxxb, sessionBean);
						zdryZszhjsbrxxbDao.update(zdryZszhjsbrxxb);
					} else if ("04".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
						ZdryFzcsfryxxb zdryFzcsfryxxb = zdryVO.getZdryFzcsfryxxb();
						if (zdryFzcsfryxxb == null) {
							zdryFzcsfryxxb = new ZdryFzcsfryxxb();
						}
						zdryFzcsfryxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdryFzcsfryxxb, sessionBean);
						zdryFzcsfryxxbDao.update(zdryFzcsfryxxb);
					} else if ("08".equals(zdryZdryzb.getZdrygllxdm())) {// 非正常访
						ZdrySqsbzdryxxb zdrySqsbzdryxxb = zdryVO.getZdrySqsbzdryxxb();
						if (zdrySqsbzdryxxb == null) {
							zdrySqsbzdryxxb = new ZdrySqsbzdryxxb();
						}
						zdrySqsbzdryxxb.setId(zdryZdryzb.getId());
						BaseService.setUpdateProperties(zdrySqsbzdryxxb, sessionBean);
						zdrySqsbzdryxxbDao.update(zdrySqsbzdryxxb);
					}
				}
		
	}

	@Override
	public List<String> getYlgZdrylb(String zdryid) {
		List<ZdryZdrylbb> ylglbList = zdryZdrylbbDao.queryByZdryid(zdryid);
		List<String> strList=new ArrayList<String>();
        for(ZdryZdrylbb lb:ylglbList){
        	strList.add(lb.getZdrylbdm());
        }
		return strList;
	}
}
