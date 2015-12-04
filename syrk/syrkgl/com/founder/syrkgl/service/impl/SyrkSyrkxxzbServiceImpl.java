package com.founder.syrkgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.MapUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.gis.service.GisService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.RyRyzjxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.dao.SyrkCzrkxxbDao;
import com.founder.syrkgl.dao.SyrkJwryxxbDao;
import com.founder.syrkgl.dao.SyrkJzrkxxbDao;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.syrkgl.dao.SyrkWlhryxxbDao;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.syrkgl.service.RyRyzjxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.syrkgl.vo.SyrkAddVO;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;



/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.syrkgl.service.impl.SyrkSyrkxxzbServiceImpl.java]
 * @ClassName: [SyrkSyrkxxzbServiceImpl]
 * @Description: [实有人口总表业务实现]
 * @Author: [weiwen]
 * @CreateDate: [2015-4-2 下午4:47:19]
 * @UpdateUser: [weiwen]
 * @UpdateDate: [2015-4-2 下午4:47:19，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("syrkSyrkxxzbService")
@Transactional
public class SyrkSyrkxxzbServiceImpl extends BaseService implements
		SyrkSyrkxxzbService {

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;

	@Resource(name = "ryRyzjxxbService")
	private RyRyzjxxbService ryRyzjxxbService;

	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;

	@Resource(name = "syrkCzrkxxbDao")
	private SyrkCzrkxxbDao syrkCzrkxxbDao;

	@Resource(name = "syrkJzrkxxbDao")
	private SyrkJzrkxxbDao syrkJzrkxxbDao;

	@Resource(name = "syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;

	@Resource(name = "syrkJwryxxbDao")
	private SyrkJwryxxbDao syrkJwryxxbDao;

	@Resource(name = "syrkWlhryxxbDao")
	private SyrkWlhryxxbDao syrkWlhryxxbDao;

	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
	@Resource(name="syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkxxzbService;

	@Resource(name = "gisService")
	private GisService gisService;
	
	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Override
	public SyrkSyrkxxzb queryById(String id) {
		return syrkSyrkxxzbDao.queryById(id);
	}

	@Override
	public List<SyrkSyrkxxzb> queryListByRyid(String ryid) {
		return syrkSyrkxxzbDao.queryListByRyid(ryid);
	}

	@Override
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		return syrkSyrkxxzbDao.queryListByRyidYwlx(entity);
	}

	@Override
	public SyrkSyrkxxzb queryCzrkByRyid(String ryid) {
		return syrkSyrkxxzbDao.queryCzrkByRyid(ryid);
	}

	@Override
	public String isValidSyrkAdd(SyrkAddVO syrkAddVO, SessionBean sessionBean) {
		String errorMessage = "";
		String districtOrgCode = SystemConfig.getString("districtOrgCode");
		String ssFsxCode = sessionBean.getExtendValue("ssFsxCode");
		String syrkywlxdm = syrkAddVO.getSyrkywlxdm();
		RyRyjbxxb jbxx = syrkAddVO.getJbxx();
		String ryid = jbxx.getId();
		String jzd_dzid = "";
		
		if (!StringUtils.isBlank(ryid)) { // 人员基本表有数据
			SyrkSyrkxxzb syrkSyrkxxzb = queryCzrkByRyid(ryid);
			String hjd_gxfjdm = ""; // 户籍地管辖分局
			if (syrkSyrkxxzb != null) {
				hjd_gxfjdm = StringUtils.nullToStr(syrkSyrkxxzb.getGxfjdm());
			}
			if ("1".equals(syrkywlxdm)) { // 新增常住人口
				jzd_dzid = syrkAddVO.getCzrk().getJzd_dzid();
				if (syrkSyrkxxzb != null) {
					errorMessage = "该人员已经登记为常住人口！";
				}
			} else if ("2".equals(syrkywlxdm)) { // 新增寄住人口
				jzd_dzid = syrkAddVO.getJzrk().getJzd_dzid();
				if (StringUtils.isBlank(hjd_gxfjdm)) { // 户籍地管辖分局为空（不是本地常口）
					// errorMessage = "该人员不是常住人口，不能登记为寄住人口！";
				} else {
					if (districtOrgCode.indexOf("," + hjd_gxfjdm + ",") != -1) { // 户籍地为市辖区分局
						if (districtOrgCode.indexOf("," + ssFsxCode + ",") == -1) { // 现住址不为市辖区分局
							errorMessage = "该人员已跨市区管辖分局，不能登记为寄住人口！";
						}
					} else { // 户籍地为其他分局
						if (!hjd_gxfjdm.equals(ssFsxCode)) { // 现住址不为户籍地分局
							errorMessage = "该人员已跨户籍地管辖分局，不能登记为寄住人口！";
						}
					}
				}
			} else if ("3".equals(syrkywlxdm)) { // 新增流动人员
				if("12".equals(sessionBean.getUserOrgBiztype())){
					//内保登记时，不需要校验
					return errorMessage;
				}
				
				jzd_dzid = syrkAddVO.getLdrk().getJzd_dzid();
				if (!StringUtils.isBlank(hjd_gxfjdm)) { // 户籍地管辖分局不为空（本地常口）
					if (districtOrgCode.indexOf("," + hjd_gxfjdm + ",") != -1) { // 户籍地为市辖区分局
						if (districtOrgCode.indexOf("," + ssFsxCode + ",") != -1) { // 现住址为市辖区分局
							errorMessage = "该人员户籍地为市区管辖分局，不能登记为流动人员！";
						}
					} else { // 户籍地为其他分局
						if (hjd_gxfjdm.equals(ssFsxCode)) { // 现住址为户籍地分局
							errorMessage = "该人员户籍地为当前管辖分局，不能登记为流动人员！";
						}
					}
				}
			} else if ("4".equals(syrkywlxdm)) { // 新增境外人员
				jzd_dzid = syrkAddVO.getJwry().getJzd_dzid();
				if (syrkSyrkxxzb != null) {
					errorMessage = "该人员为常住人口，不能登记为境外人员！";
				}
			} else if ("5".equals(syrkywlxdm)) { // 新增未落户人员
				jzd_dzid = syrkAddVO.getWlrk().getJzd_dzid();
				if (syrkSyrkxxzb != null) {
					errorMessage = "该人员为常住人口，不能登记为未落户人员！";
				}
			}
			if (StringUtils.isBlank(errorMessage)
					&& !StringUtils.isBlank(jzd_dzid)) { // 有居住地址的判断同一个人在同一个地址下不能重复录入
				if (syrkSyrkxxzbDao.isExistRyDz(ryid, jzd_dzid)) {
					errorMessage = "该人员在此居住地址已登记，不能重复录入！";
				}
			}
		}
		return errorMessage;
	}

	@Override
	public String syrkAdd(SyrkAddVO syrkAddVO, SessionBean sessionBean)
			throws Exception {
		RyRyjbxxb jbxx = syrkAddVO.getJbxx();
		String syrkywlxdm = syrkAddVO.getSyrkywlxdm();
		SyrkSyrkxxzb syrk = new SyrkSyrkxxzb();
		String syrkid = UUID.create();
		String ryid="";
		
		if ("1".equals(syrkywlxdm)) { // 新增常住人口
			SyrkCzrkxxb czrk = syrkAddVO.getCzrk();
			jbxx.setSyrkbz("1");
			jbxx.setHjd_dzid(czrk.getHjd_dzid());
			jbxx.setHjd_dzxz(czrk.getHjd_dzxz());
			jbxx.setHjd_mlpdm(czrk.getHjd_mlpdm());
			jbxx.setHjd_mlpxz(czrk.getHjd_mlpxz());
			jbxx.setHjd_xzqhdm(czrk.getHjd_xzqhdm());
			jbxx.setHjd_pcsdm(sessionBean.getUserOrgCode());
			jbxx.setJzd_dzid(czrk.getJzd_dzid());
			jbxx.setJzd_dzxz(czrk.getJzd_dzxz());
			jbxx.setJzd_mlpdm(czrk.getJzd_mlpdm());
			jbxx.setJzd_mlpxz(czrk.getJzd_mlpxz());
			jbxx.setJzd_xzqhdm(czrk.getJzd_xzqhdm());
			ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);
			//因为ryjbxxb的id有可能为空，所以保存完重新查一遍
			RyRyjbxxb savejbxx =this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
		    ryid = savejbxx.getId();

			syrk.setJzd_xzqhdm(czrk.getJzd_xzqhdm());
			syrk.setJzd_mlpdm(czrk.getJzd_mlpdm());
			syrk.setJzd_mlpxz(czrk.getJzd_mlpxz());
			syrk.setJzd_dzid(czrk.getJzd_dzid());
			syrk.setJzd_dzxz(czrk.getJzd_dzxz());
			syrk.setJzd_zbx(czrk.getJzd_zbx());
			syrk.setJzd_zby(czrk.getJzd_zby());

			czrk.setId(syrkid);
			czrk.setRyid(ryid);
			czrk.setGmsfhm(jbxx.getZjhm());
			czrk.setXm(jbxx.getXm());
			czrk.setXbdm(jbxx.getXbdm());
			czrk.setMzdm(jbxx.getMzdm());
			czrk.setCsrq(jbxx.getCsrq());
			czrk.setCsdgjhdqdm(jbxx.getCsdgjhdqdm());
			czrk.setCsdssxdm(jbxx.getCsdssxdm());
			czrk.setJggjdqdm(jbxx.getJggjdqdm());
			czrk.setJgssxdm(jbxx.getJgssxdm());
			czrk.setXldm(jbxx.getXldm());
			czrk.setHyzkdm(jbxx.getHyzkdm());
			czrk.setZzmmdm(jbxx.getZzmmdm());
			czrk.setZjxydm(jbxx.getZjxydm());
			czrk.setByzkdm(jbxx.getByzkdm());
			czrk.setXxdm(jbxx.getXxdm());
			czrk.setLxdh(jbxx.getLxdh());
			czrk.setZy(jbxx.getZy());
			czrk.setZylbdm(jbxx.getZylbdm());
			czrk.setGzdw(syrkAddVO.getGzdw());
			czrk.setGzdwid(syrkAddVO.getGzdwid());
			czrk.setHjd_dzms(jbxx.getHjd_dzms());
			setSaveProperties(czrk, sessionBean);
			syrkCzrkxxbDao.insert(czrk);
		} else if ("2".equals(syrkywlxdm)) { // 新增寄住人口
			SyrkJzrkxxb jzrk = syrkAddVO.getJzrk();
			jbxx.setSyrkbz("1");
			jbxx.setJzd_dzid(jzrk.getJzd_dzid());
			jbxx.setJzd_dzxz(jzrk.getJzd_dzxz());
			jbxx.setJzd_mlpdm(jzrk.getJzd_mlpdm());
			jbxx.setJzd_mlpxz(jzrk.getJzd_mlpxz());
			jbxx.setJzd_xzqhdm(jzrk.getJzd_xzqhdm());
			ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);
			//因为ryjbxxb的id有可能为空，所以保存完重新查一遍
			RyRyjbxxb savejbxx =this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
			ryid = savejbxx.getId();


			syrk.setJzd_xzqhdm(jzrk.getJzd_xzqhdm());
			syrk.setJzd_mlpdm(jzrk.getJzd_mlpdm());
			syrk.setJzd_mlpxz(jzrk.getJzd_mlpxz());
			syrk.setJzd_dzid(jzrk.getJzd_dzid());
			syrk.setJzd_dzxz(jzrk.getJzd_dzxz());
			syrk.setJzd_zbx(jzrk.getJzd_zbx());
			syrk.setJzd_zby(jzrk.getJzd_zby());

			jzrk.setId(syrkid);
			jzrk.setRyid(ryid);
			jzrk.setGmsfhm(jbxx.getZjhm());
			jzrk.setXm(jbxx.getXm());
			jzrk.setXbdm(jbxx.getXbdm());
			jzrk.setMzdm(jbxx.getMzdm());
			jzrk.setCsrq(jbxx.getCsrq());
			jzrk.setHjd_xzqhdm(jbxx.getHjd_xzqhdm());
			jzrk.setHjd_mlpdm(jbxx.getHjd_mlpdm());
			jzrk.setHjd_mlpxz(jbxx.getHjd_mlpxz());
			jzrk.setHjd_dzid(jbxx.getHjd_dzid());
			jzrk.setHjd_dzxz(jbxx.getHjd_dzxz());
			jzrk.setHjd_dzms(jbxx.getHjd_dzms());
			jzrk.setLxdh(jbxx.getLxdh());
			jzrk.setZy(jbxx.getZy());
			jzrk.setZylbdm(jbxx.getZylbdm());
			jzrk.setGzdw(syrkAddVO.getGzdw());
			jzrk.setGzdwid(syrkAddVO.getGzdwid());

			setSaveProperties(jzrk, sessionBean);
			syrkJzrkxxbDao.insert(jzrk);
		} else if ("3".equals(syrkywlxdm)) { 
			
			RyRyjbxxb oldRyjbxxb=this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
			
			// 新增流动人员
			SyrkLdrkxxb ldrk = syrkAddVO.getLdrk();
			jbxx.setSyrkbz("1");
			jbxx.setJzd_dzid(ldrk.getJzd_dzid());
			jbxx.setJzd_dzxz(ldrk.getJzd_dzxz());
			jbxx.setJzd_mlpdm(ldrk.getJzd_mlpdm());
			jbxx.setJzd_mlpxz(ldrk.getJzd_mlpxz());
			jbxx.setJzd_xzqhdm(ldrk.getJzd_xzqhdm());
			ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);
			//因为ryjbxxb的id有可能为空，所以保存完重新查一遍
			RyRyjbxxb savejbxx =this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
			ryid = savejbxx.getId();

			syrk.setJzd_xzqhdm(ldrk.getJzd_xzqhdm());
			syrk.setJzd_mlpdm(ldrk.getJzd_mlpdm());
			syrk.setJzd_mlpxz(ldrk.getJzd_mlpxz());
			syrk.setJzd_dzid(ldrk.getJzd_dzid());
			syrk.setJzd_dzxz(ldrk.getJzd_dzxz());
			syrk.setJzd_zbx(ldrk.getJzd_zbx());
			syrk.setJzd_zby(ldrk.getJzd_zby());

			ldrk.setId(syrkid);
			ldrk.setRyid(ryid);
			ldrk.setCyzjdm(jbxx.getCyzjdm());
			ldrk.setZjhm(jbxx.getZjhm());
			ldrk.setXm(jbxx.getXm());
			ldrk.setCym(jbxx.getCym());
			ldrk.setXbdm(jbxx.getXbdm());
			ldrk.setXldm(jbxx.getXldm());
			ldrk.setMzdm(jbxx.getMzdm());
			ldrk.setCsrq(jbxx.getCsrq());
			ldrk.setLxdh(jbxx.getLxdh());
			ldrk.setHyzkdm(jbxx.getHyzkdm());
			ldrk.setZzmmdm(jbxx.getZzmmdm());
			ldrk.setHjd_xzqhdm(jbxx.getHjd_xzqhdm());
			ldrk.setHjd_mlpdm(jbxx.getHjd_mlpdm());
			ldrk.setHjd_mlpxz(jbxx.getHjd_mlpxz());
			ldrk.setHjd_dzid(jbxx.getHjd_dzid());
			ldrk.setHjd_dzxz(jbxx.getHjd_dzxz());
			ldrk.setHjd_dzms(jbxx.getHjd_dzms());
			ldrk.setZy(jbxx.getZy());
			ldrk.setZylbdm(jbxx.getZylbdm());
			ldrk.setGzdw(syrkAddVO.getGzdw());
			ldrk.setGzdwid(syrkAddVO.getGzdwid());

			setSaveProperties(ldrk, sessionBean);
			syrkLdrkxxbDao.insert(ldrk);
			
			//如果户籍地址描述和人员基本信息表的不一样则
			//给其他地区的此实有人口发消息提醒 提醒户籍地址变更
			String oldHjd_ms="";
			String newHjd_ms=StringUtils.isBlank(jbxx.getHjd_dzms())?"":jbxx.getHjd_dzms();

		    if(oldRyjbxxb!=null){
		    	oldHjd_ms=oldRyjbxxb.getHjd_dzms();
		    	//新户籍地址和旧户籍地址都不等，则发消息给其他责任区的民警提醒户籍地址已变更
				if(!newHjd_ms.equals(oldHjd_ms)){
					//判断这个人是否在其他地区是实有人口  是的话 给其他责任区发消息提醒
					SyrkSyrkxxzb syrkzb=new SyrkSyrkxxzb();
					syrkzb.setCyzjdm(ldrk.getCyzjdm());
					syrkzb.setZjhm(ldrk.getZjhm());
					List<SyrkSyrkxxzb> syrkZbs=this.syrkxxzbService.queryList(syrkzb);
					if(syrkZbs!=null && syrkZbs.size()>0){
						for(SyrkSyrkxxzb zb:syrkZbs){
								SysMessage message = new SysMessage();
								message.setFsr(sessionBean.getUserName());
								message.setFsrdm(sessionBean.getUserId());
								message.setFssj(DateUtils.getSystemDateTimeString());
								message.setFsrssdw(sessionBean.getUserOrgName());
								message.setFsrssdwdm(sessionBean.getUserOrgCode());
								if(StringUtils.isBlank(newHjd_ms)){
									message.setXxnr(sessionBean.getUserOrgName()+"民警"+sessionBean.getUserName()+"删除了实有人口"+ldrk.getXm()+"的户籍地址描述");
			
								}else{
									message.setXxnr(sessionBean.getUserOrgName()+"民警"+sessionBean.getUserName()+"将实有人口"+ldrk.getXm()+"的户籍地址描述修改为"+jbxx.getHjd_dzms());

								}
								message.setXxbt("流动人口户籍地址描述修改提醒");
								message.setXxlb("1");
								sysMessageDao.saveMessageByOrgCondition(message, zb.getGxzrqdm(), "01", "50", "04", false, false);
							
						}
					}
					
					oldRyjbxxb.setHjd_dzms(newHjd_ms);
					this.ryRyjbxxbService.saveOrUpdate(oldRyjbxxb, sessionBean);
					
				}
		    }else{
				this.ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);

		    }	    
		
			
		} else if ("4".equals(syrkywlxdm)) { // 新增境外人员
			SyrkJwryxxb jwry = syrkAddVO.getJwry();
			jbxx.setSyrkbz("1");
			jbxx.setJzd_dzid(jwry.getJzd_dzid());
			jbxx.setJzd_dzxz(jwry.getJzd_dzxz());
			jbxx.setJzd_mlpdm(jwry.getJzd_mlpdm());
			jbxx.setJzd_mlpxz(jwry.getJzd_mlpxz());
			jbxx.setJzd_xzqhdm(jwry.getJzd_xzqhdm());
			jbxx.setWwx(jwry.getWwx());
			jbxx.setWwm(jwry.getWwm());
			jbxx.setGjdm(jwry.getGjdm());
			jbxx.setCsrq(jwry.getCsrq());
			jbxx.setXbdm(jwry.getXbdm());
			jbxx.setLxdh(jwry.getLxdh());
			ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);
			//因为ryjbxxb的id有可能为空，所以保存完重新查一遍
			RyRyjbxxb savejbxx  =this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
			ryid = savejbxx.getId();

			syrk.setJzd_xzqhdm(jwry.getJzd_xzqhdm());
			syrk.setJzd_mlpdm(jwry.getJzd_mlpdm());
			syrk.setJzd_mlpxz(jwry.getJzd_mlpxz());
			syrk.setJzd_dzid(jwry.getJzd_dzid());
			syrk.setJzd_dzxz(jwry.getJzd_dzxz());
			syrk.setJzd_zbx(jwry.getJzd_zbx());
			syrk.setJzd_zby(jwry.getJzd_zby());

			jwry.setId(syrkid);
			jwry.setRyid(ryid);
			jwry.setCyzjdm(jbxx.getCyzjdm());
			jwry.setZjhm(jbxx.getZjhm());
			jwry.setXm(jbxx.getXm());
			setSaveProperties(jwry, sessionBean);
			syrkJwryxxbDao.insert(jwry);
		} else if ("5".equals(syrkywlxdm)) { // 新增未落户人员
			SyrkWlhryxxb wlrk = syrkAddVO.getWlrk();
			jbxx.setSyrkbz("1");
			jbxx.setJzd_dzid(wlrk.getJzd_dzid());
			jbxx.setJzd_dzxz(wlrk.getJzd_dzxz());
			jbxx.setJzd_mlpdm(wlrk.getJzd_mlpdm());
			jbxx.setJzd_mlpxz(wlrk.getJzd_mlpxz());
			jbxx.setJzd_xzqhdm(wlrk.getJzd_xzqhdm());
			ryRyjbxxbService.saveOrUpdate(jbxx, sessionBean);
			//因为ryjbxxb的id有可能为空，所以保存完重新查一遍
			RyRyjbxxb savejbxx  =this.ryRyjbxxbService.queryByCyzjdmZjhm(jbxx.getCyzjdm(), jbxx.getZjhm());
			ryid = savejbxx.getId();

			syrk.setJzd_xzqhdm(wlrk.getJzd_xzqhdm());
			syrk.setJzd_mlpdm(wlrk.getJzd_mlpdm());
			syrk.setJzd_mlpxz(wlrk.getJzd_mlpxz());
			syrk.setJzd_dzid(wlrk.getJzd_dzid());
			syrk.setJzd_dzxz(wlrk.getJzd_dzxz());
			syrk.setJzd_zbx(wlrk.getJzd_zbx());
			syrk.setJzd_zby(wlrk.getJzd_zby());

			wlrk.setId(syrkid);
			wlrk.setRyid(ryid);
			wlrk.setCyzjdm(jbxx.getCyzjdm());
			wlrk.setZjhm(jbxx.getZjhm());
			wlrk.setXm(jbxx.getXm());
			wlrk.setCym(jbxx.getCym());
			wlrk.setXbdm(jbxx.getXbdm());
			wlrk.setMzdm(jbxx.getMzdm());
			wlrk.setCsrq(jbxx.getCsrq());
			wlrk.setLxdh(jbxx.getLxdh());
			wlrk.setXldm(jbxx.getXldm());
			wlrk.setHyzkdm(jbxx.getHyzkdm());
			wlrk.setZzmmdm(jbxx.getZzmmdm());
			wlrk.setZjxydm(jbxx.getZjxydm());
			wlrk.setByzkdm(jbxx.getByzkdm());
			wlrk.setXxdm(jbxx.getXxdm());
			wlrk.setCsdgjhdqdm(jbxx.getCsdgjhdqdm());
			wlrk.setCsdssxdm(jbxx.getCsdssxdm());
			wlrk.setZy(jbxx.getZy());
			wlrk.setZylbdm(jbxx.getZylbdm());
			wlrk.setGzdw(syrkAddVO.getGzdw());
			wlrk.setGzdwid(syrkAddVO.getGzdwid());

			setSaveProperties(wlrk, sessionBean);
			
			syrkWlhryxxbDao.insert(wlrk);

			if (!StringUtils.isBlank(wlrk.getQtcyzjdm())
					&& !StringUtils.isBlank(wlrk.getQtzjhm())) { // 其他常用证件不为空
				RyRyzjxxb ryRyzjxxb = new RyRyzjxxb();
				ryRyzjxxb.setRyid(ryid);
				ryRyzjxxb.setCyzjdm(wlrk.getQtcyzjdm());
				ryRyzjxxb.setZjhm(wlrk.getQtzjhm());
				ryRyzjxxbService.save(ryRyzjxxb, sessionBean);
			}
		} else {
			throw new Exception("实有人口业务类型代码错误！");
		}
		syrk.setId(syrkid);
		syrk.setRyid(ryid);
		syrk.setSyrkywlxdm(syrkywlxdm);
		syrk.setCyzjdm(jbxx.getCyzjdm());
		syrk.setZjhm(jbxx.getZjhm());
		syrk.setXm(jbxx.getXm());
		syrk.setXbdm(jbxx.getXbdm());
		syrk.setMzdm(jbxx.getMzdm());
		syrk.setCsrq(jbxx.getCsrq());
		syrk.setJgssxdm(jbxx.getJgssxdm());
		
		if("12".equals(sessionBean.getUserOrgBiztype())){
			if("20".equals(sessionBean.getUserOrgLevel())){//内保支队
				syrk.setGxfjdm(sessionBean.getUserOrgCode());
			}else{//内保大队
				OrgOrganization org = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
				syrk.setGxfjdm(org.getOrgcode());
				syrk.setGxpcsdm(sessionBean.getUserOrgCode());
			}
		}else{
			syrk.setGxfjdm(sessionBean.getExtendValue("ssFsxCode"));
			syrk.setGxpcsdm(sessionBean.getExtendValue("ssPcsCode"));
			syrk.setGxzrqdm(sessionBean.getUserOrgCode());
		}
		
		syrk.setHjd_xzqhdm(jbxx.getHjd_xzqhdm());
		syrk.setHjd_mlpdm(jbxx.getHjd_mlpdm());
		syrk.setHjd_mlpxz(jbxx.getHjd_mlpxz());
		syrk.setHjd_dzid(jbxx.getHjd_dzid());
		syrk.setHjd_dzxz(jbxx.getHjd_dzxz());
		setSaveProperties(syrk, sessionBean);
		syrkSyrkxxzbDao.save(syrk);

		if (!StringUtils.isBlank(jbxx.getLxdh())) { // 保存联系电话
			ryRylxfsxxbService.saveLxdh(ryid, jbxx.getLxdh(), sessionBean);
		}

		// 保存证件信息
		RyRyzjxxb ryRyzjxxb = new RyRyzjxxb();
		ryRyzjxxb.setRyid(ryid);
		ryRyzjxxb.setCyzjdm(jbxx.getCyzjdm());
		ryRyzjxxb.setZjhm(jbxx.getZjhm());
		ryRyzjxxbService.save(ryRyzjxxb, sessionBean);
		List<SyrkSyrkxxzb> syrkList = syrkSyrkxxzbDao.queryRyGxzrqList(ryid);

		if (syrkList != null && syrkList.size() > 0) { // 发送消息
			Map<String, String> sendZrqMap = new HashMap<String, String>();
			SysMessage sysMessage = new SysMessage();
			sysMessage.setXxlb("1");
			sysMessage.setFsr(sessionBean.getUserName());
			sysMessage.setFsrdm(sessionBean.getUserId());
			sysMessage.setFssj(DateUtils.getSystemDateTimeString());
			sysMessage.setFsrssdw(sessionBean.getUserOrgName());
			sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
			sysMessage.setDxzt("0");
			sysMessage.setJslx("1"); // 默认接收类型为部门
			String ywurl = "";
			sysMessage.setYwurl(ywurl);
			sysMessage.setXxbt("实有人口新增提醒");
			String syrkywlxmc = syrkywlxdm;
			try {
				syrkywlxmc = sysDictGlService.getDictCt("BD_D_SYRKYWLXDM",
						syrkywlxdm);
			} catch (Exception e) {
			}
			for (int i = 0; i < syrkList.size(); i++) {
				SyrkSyrkxxzb syrkDB = syrkList.get(i);
				String gxzrqdm = StringUtils.nullToStr(syrkDB.getGxzrqdm());
				if (!StringUtils.isBlank(gxzrqdm)
						&& !gxzrqdm.equals(sessionBean.getUserOrgCode())) { // 不是本责任区的发送消息
					if (!sendZrqMap.containsKey(gxzrqdm)) { // 同一责任区只发送一条消息
						StringBuffer xxnr = new StringBuffer();
						xxnr.append("你辖区");
						try {
							xxnr.append(sysDictGlService.getDictCt(
									"BD_D_SYRKYWLXDM", syrkDB.getSyrkywlxdm()));
						} catch (Exception e) {
						}
						xxnr.append(syrkDB.getXm());
						xxnr.append("（");
						try {
							xxnr.append(sysDictGlService.getDictCt(
									"KX_D_CYZJDM", syrkDB.getCyzjdm()));
						} catch (Exception e) {
						}
						xxnr.append("：");
						xxnr.append(syrkDB.getZjhm());
						xxnr.append("）已被");
						xxnr.append(sessionBean.getExtendValue("ssFsxName"));
						xxnr.append(sessionBean.getExtendValue("ssPcsName"));
						xxnr.append(sessionBean.getUserOrgName());
						xxnr.append("民警");
						xxnr.append(sessionBean.getUserName());
						xxnr.append("登记为");
						xxnr.append(syrkywlxmc);
						xxnr.append("。");
						sysMessage.setXxnr(xxnr.toString());
						sysMessageDao.saveMessageByOrg(sysMessage, gxzrqdm,
								false, false);
						sendZrqMap.put(gxzrqdm, "");
					}
				}
			}
		}
		return syrkid;
	}

	/**
	 * @Title: queryList
	 * @描述: 查询实有人口管理列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-14 上午11:24:36
	 * @throws
	 */
	public EasyUIPage queryList(SyrkSyrkxxzb entity, EasyUIPage page) {
		return syrkSyrkxxzbDao.queryList(entity, page);
	}

	@Override
	public void save(SyrkSyrkxxzb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		syrkSyrkxxzbDao.save(entity);
	}

	
	public void update(SyrkSyrkxxzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		syrkSyrkxxzbDao.update(entity);
	}

	/**
	 * @Title: cancelSyrk
	 * @描述: 实有人口注销【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-4-15 下午5:15:42
	 * @throws
	 */
	@Override
	public String deleteSyrk(SyrkAddVO entity, SessionBean sessionBean) {
		
		SyrkSyrkxxzb syrk = new SyrkSyrkxxzb();
		setCrossoutProperties(syrk, sessionBean);
		String xxnr = "";
		String errorMessage="";
		if ("1".equals(entity.getSyrkywlxdm())) {
			//判断是否为重点人口
			int zdrkCount = zdryQueryService.queryForCount(entity.getCzrk().getId());
            if(zdrkCount>0){
            	errorMessage="此实有人口是重点人口，不能注销";
            	return errorMessage;

            }
			
			// 注销【常住人口】表数据
			setCrossoutProperties(entity.getCzrk(), sessionBean);
			syrkCzrkxxbDao.delete(entity.getCzrk());
			// 赋值给人员信息总表
			syrk.setId(entity.getCzrk().getId());
			syrk.setRyid(entity.getCzrk().getRyid());
			syrk.setXt_zxbz(entity.getCzrk().getXt_zxbz());
		} else if ("2".equals(entity.getSyrkywlxdm())) {
			//判断是否为重点人口
			int zdrkCount = zdryQueryService.queryForCount(entity.getJzrk().getId());
            if(zdrkCount>0){
            	errorMessage="此实有人口是重点人口，不能注销";
            	return errorMessage;

            }
			// 注销【寄住人口】表数据
			setCrossoutProperties(entity.getJzrk(), sessionBean);
			syrkJzrkxxbDao.delete(entity.getJzrk());
			// 赋值给人员信息总表
			syrk.setId(entity.getJzrk().getId());
			syrk.setRyid(entity.getJzrk().getRyid());
			syrk.setXt_zxbz(entity.getJzrk().getXt_zxbz());
		} else if ("3".equals(entity.getSyrkywlxdm())) {
			//判断是否为重点人口
			int zdrkCount = zdryQueryService.queryForCount(entity.getLdrk().getId());
            if(zdrkCount>0){
            	errorMessage="此实有人口是重点人口，不能注销";
            	return errorMessage;

            }
			// 注销【流动人员】表数据
			setCrossoutProperties(entity.getLdrk(), sessionBean);
			syrkLdrkxxbDao.delete(entity.getLdrk());
			// 赋值给人员信息总表
			syrk.setId(entity.getLdrk().getId());
			syrk.setRyid(entity.getLdrk().getRyid());
			syrk.setXt_zxbz(entity.getLdrk().getXt_zxbz());
		} else if ("4".equals(entity.getSyrkywlxdm())) {
			//判断是否为重点人口
			int zdrkCount = zdryQueryService.queryForCount(entity.getJwry().getId());
            if(zdrkCount>0){
            	errorMessage="此实有人口是重点人口，不能注销";
            	return errorMessage;

            }
			// 注销【境外人员】表数据
			setCrossoutProperties(entity.getJwry(), sessionBean);
			syrkJwryxxbDao.delete(entity.getJwry());
			// 赋值给人员信息总表
			syrk.setId(entity.getJwry().getId());
			syrk.setRyid(entity.getJwry().getRyid());
			syrk.setXt_zxbz(entity.getJwry().getXt_zxbz());
		} else if ("5".equals(entity.getSyrkywlxdm())) {
			//判断是否为重点人口
			int zdrkCount = zdryQueryService.queryForCount(entity.getWlrk().getId());
            if(zdrkCount>0){
            	errorMessage="此实有人口是重点人口，不能注销";
            	return errorMessage;
            }
			// 注销【未落户人员】表数据
			setCrossoutProperties(entity.getWlrk(), sessionBean);
			syrkWlhryxxbDao.delete(entity.getWlrk());
			// 赋值给人员信息总表
			syrk.setId(entity.getWlrk().getId());
			syrk.setRyid(entity.getWlrk().getRyid());
			syrk.setXt_zxbz(entity.getWlrk().getXt_zxbz());
		}
		// 注销实有人口总表数据
		syrkSyrkxxzbDao.delete(syrk);
		// 更新人员基本信息表数据
		List<SyrkSyrkxxzb> syrkxblist = syrkSyrkxxzbDao.queryListByRyid(syrk
				.getRyid());
		if (syrkxblist == null || syrkxblist.size() == 0) {
			RyRyjbxxb jbxxb = new RyRyjbxxb();
			setUpdateProperties(jbxxb, sessionBean);
			jbxxb.setId(syrk.getRyid());
			jbxxb.setSyrkbz("0");
			ryRyjbxxbService.update(jbxxb, sessionBean);
		}
		return errorMessage;
	}

	@Override
	public void synchronizeCrossoutSyrkxxzb(Object entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		syrkSyrkxxzbDao.delete(syrkxxb);
	}

	@Override
	public void synchronizeSyrkxxzb(SyrkCzrkxxb entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		syrkxxb.setZjhm(StringUtils.nullToStr(entity.getGmsfhm()));
		syrkxxb.setCyzjdm("111");
		saveOrUpdate(syrkxxb, "1");

	}

	@Override
	public void synchronizeSyrkxxzb(SyrkJwryxxb entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		saveOrUpdate(syrkxxb, "4");
	}

	@Override
	public void synchronizeSyrkxxzb(SyrkJzrkxxb entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		syrkxxb.setZjhm(StringUtils.nullToStr(entity.getGmsfhm()));
		syrkxxb.setCyzjdm("111");
		saveOrUpdate(syrkxxb, "2");
	}

	@Override
	public void synchronizeSyrkxxzb(SyrkLdrkxxb entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		saveOrUpdate(syrkxxb, "3");
	}

	@Override
	public void synchronizeSyrkxxzb(SyrkWlhryxxb entity) {
		SyrkSyrkxxzb syrkxxb = new SyrkSyrkxxzb();
		BeanUtils.copyProperties(entity, syrkxxb);
		saveOrUpdate(syrkxxb, "5");
	}

	/**
	 * 
	 * @Title: saveOrUpdate
	 * @Description: TODO(根据id判断是新增还是修改总表)
	 * @param @param syrkxxb
	 * @param @param syrkywlxdm 实有人口业务类型代码
	 * @return void 返回类型
	 * @throws
	 */
	private void saveOrUpdate(SyrkSyrkxxzb syrkxxb, String syrkywlxdm) {
		if (!syrkSyrkxxzbDao.isExist(syrkxxb.getId())) {
			syrkxxb.setSyrkywlxdm(syrkywlxdm);
			syrkSyrkxxzbDao.save(syrkxxb);
		} else
			syrkSyrkxxzbDao.update(syrkxxb);
	}

	/**
	 * @Title: querySyrk
	 * @描述: 查询实有人口查询列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 如果有空间查询执行if语句，BZDZ_ADD_MLDZDXB_PT 空间表名字
	 * @日期： 2015-4-15 上午10:07:32
	 * @throws
	 */
	public EasyUIPage querySyrk(SyrkSyrkxxzb entity, EasyUIPage page) {
		if (!StringUtils.isBlank(entity.getDrawType())
				&& !StringUtils.isBlank(entity.getDrawZbz())) {
			entity.setDrawSrid(gisService
					.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));// 获取地图图层SRID，为公共方法查询
																// 不止一个空间表名。
			if (!"drawRect".equals(entity.getDrawType())) {
				entity.setDrawZbz(MapUtils.getSdeZbz(entity.getDrawZbz()));
			}
		}
		return syrkSyrkxxzbDao.querySyrk(entity, page);
	}

	/**
	 * @Title: querySyrkCount
	 * @描述: 查询实有人口查询列表数据总数【服务接口】
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 如果有空间查询执行if语句，BZDZ_ADD_MLDZDXB_PT 空间表名字
	 * @日期： 2015-4-15 上午10:16:23
	 * @返回值: long 返回类型
	 * @throws
	 */
	public long querySyrkCount(SyrkSyrkxxzb entity) {
		if (!StringUtils.isBlank(entity.getDrawType())
				&& !StringUtils.isBlank(entity.getDrawZbz())) {
			entity.setDrawSrid(gisService
					.getShapeTableSrid("BZDZ_ADD_MLDZDXB_PT"));// 获取地图图层SRID，为公共方法查询
																// 不止一个空间表名。
			if (!"drawRect".equals(entity.getDrawType())) {
				entity.setDrawZbz(MapUtils.getSdeZbz(entity.getDrawZbz()));
			}
		}
		return syrkSyrkxxzbDao.querySyrkCount(entity);
	}

	@Override
	public List<SyrkSyrkxxzb> queryList(SyrkSyrkxxzb entity) {
		
		return this.syrkSyrkxxzbDao.queryList(entity);
	}
}