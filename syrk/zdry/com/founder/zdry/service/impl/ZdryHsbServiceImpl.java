package com.founder.zdry.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryHsbZdls;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.dao.ZdryHsbDao;
import com.founder.zdry.dao.ZdryYwspbDao;
import com.founder.zdry.service.ZdryGlpzpzbService;
import com.founder.zdry.service.ZdryHsbService;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.service.impl.ZdryHsbServiceImpl.java]
 * @ClassName: [ZdryHsbServiceImpl]
 * @Description: [核实接口实现类]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-17 下午7:43:51]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-17 下午7:43:51，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Transactional
@Service("zdryHsbService")
public class ZdryHsbServiceImpl extends BaseService implements ZdryHsbService {

	@Resource(name = "zdryHsbDao")
	private ZdryHsbDao zdryHsbDao;
	@Resource(name = "zdryYwspbDao")
	private ZdryYwspbDao zdryYwspbDao;
	@Resource(name = "zdryGlpzpzbService")
	private ZdryGlpzpzbService zdryGlpzpzbService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Override
	public EasyUIPage queryList(ZdryHsb entity, EasyUIPage page,
			SessionBean sessionBean) {
		entity.setSspcs(sessionBean.getExtendValue("ssPcsCode"));
		return zdryHsbDao.queryList(entity, page);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryHsb 返回类型
	 * @throws
	 */
	public ZdryHsb queryById(String id) {
		return zdryHsbDao.queryById(id);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(跟新对象)
	 * @param @param zdryHsb 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void update(ZdryHsb zdryHsb, SessionBean sessionBean) {
		zdryHsbDao.update(zdryHsb);
	}

	/***
	 * 
	 * @Title: saveHsCg
	 * @Description: TODO(核实撤管，发送审批
	 * @param @param id
	 * @param @param zdryYwspb 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveHsCg(ZdryHsb zdryHsb, ZdryYwspb zdryYwspb,
			SessionBean sessionBean) {
		// 修改状态为4
		zdryHsb.setHszt("4");
		super.setUpdateProperties(zdryHsb, sessionBean);
		zdryHsbDao.update(zdryHsb);
		// 添加审批表数据，发送message
		zdryYwspb.setYwbid(zdryHsb.getId());
		zdryYwspb.setYwbm("ZDRY_ZDRYHSB");
		zdryYwspb.setSqr_id(sessionBean.getUserId());
		zdryYwspb.setSqr_xm(sessionBean.getUserName());
		zdryYwspb.setSqsj(DateUtils.getSystemDateString());
		zdryYwspb.setId(UUID.create());
		super.setSaveProperties(zdryYwspb, sessionBean);
		zdryYwspbDao.save(zdryYwspb);
		SysMessage message = new SysMessage();
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		message.setXxbt("重点人员核实审批");
		message.setXxnr(sessionBean.getUserOrgName() + "民警"
				+ zdryYwspb.getSqr_xm() + "提交重点人员核实撤管申请，请审批。");
		message.setYwurl("/zdryHsb/creatCgApporval?zdryYwspbId="
				+ zdryYwspb.getId() + "&zdryHsbId=" + zdryHsb.getId());
		message.setXxlb("5");
		// 审批逻辑为，如没有上级部门，所长审批，有上级部门升级部门审批。所有审批只有一级
		ZdryGlpzpzb zdryglpzpzb = zdryGlpzpzbService.queryByZdrygllxdm(zdryHsb
				.getZdrygllxdm());
		if (StringUtils.isBlank(zdryglpzpzb)) {// 如果没有上级部门,所长审批
			sysMessageDao.saveMessageByOrgAndPos(message, zdryHsb.getSspcs(),
					"SZ");
		} else {
			sysMessageDao.saveMessageByOrg(message, zdryglpzpzb.getJgbmdm(),
					false, false);
		}

	}

	/***
	 * 
	 * @Title: saveApproval
	 * @Description: TODO(保存审批状态 )
	 * @param @param zdryYwspb
	 * @param @param messageid
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void saveApproval(ZdryYwspb zdryYwspb, String messageid,
			SessionBean sessionBean) {
		SysMessage sysmessage = new SysMessage();
		sysmessage.setId(Long.valueOf(messageid));
		sysMessageDao.upadate(sysmessage);
		super.setUpdateProperties(zdryYwspb, sessionBean);
		zdryYwspbDao.save(zdryYwspb);
		ZdryHsb zdryHsb = zdryHsbDao.queryById(zdryYwspb.getYwbid());
		if ("1".equals(zdryYwspb.getSpjg())) {
			zdryHsb.setHszt("2");
		} else {
			zdryHsb.setHszt("0");
		}
		super.setUpdateProperties(zdryHsb, sessionBean);
		zdryHsbDao.update(zdryHsb);
	}

	/**
	 * 新增转递历史<br>
	 * 
	 * @param entity
	 */
	public void saveHszd(ZdryHsbZdls entity, SessionBean sessionBean) {
		ZdryHsb zdryHsb = new ZdryHsb();
		zdryHsb.setId(entity.getHsid());
		zdryHsb.setSspcs(entity.getSspcs());
		zdryHsbDao.update(zdryHsb);
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryHsbDao.saveZdls(entity, sessionBean);
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
		sysMessage.setXxbt("重点人员核实转递");
		StringBuffer xxnr = new StringBuffer();
		xxnr.append(sessionBean.getExtendValue("ssFsxName"));
		xxnr.append(sessionBean.getExtendValue("ssPcsName"));
		xxnr.append(sessionBean.getUserOrgName());
		xxnr.append(sessionBean.getUserName());
		xxnr.append("将待核实重点人员");
		xxnr.append(entity.getXm());
		xxnr.append("转交给你辖区，请核实。");
		sysMessage.setXxnr(xxnr.toString());
		sysMessageDao.saveMessageByOrg(sysMessage, entity.getSszrq(), false,
				true);
	}


}
