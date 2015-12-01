package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdry.bean.ZdryHsb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.dao.ZdryHsbDao;
import com.founder.zdry.dao.ZdryLczywblbDao;
import com.founder.zdry.dao.ZdryYwspbDao;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryYwspbService;
import com.founder.zdry.vo.ZdryYwspbVo;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.service.impl.ZdryYwspbServiceImpl.java]
 * @ClassName: [ZdryYwspbServiceImpl]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-16 下午9:05:05]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-16 下午9:05:05，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryYwspbService")
@Transactional
public class ZdryYwspbServiceImpl extends BaseService implements
		ZdryYwspbService {

	@Resource(name = "zdryYwspbDao")
	private ZdryYwspbDao zdryYwspbDao;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "zdryLczywblbDao")
	private ZdryLczywblbDao zdryLczywblbDao;
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	@Resource(name = "zdryHsbDao")
	private ZdryHsbDao zdryHsbDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Override
	public void updateZdryYwspb(ZdryYwspb zdryYwspb, SessionBean sessionBean,
			String messageid) {
		super.setUpdateProperties(zdryYwspb, sessionBean);
		zdryYwspbDao.update(zdryYwspb);
		zdryYwspb = zdryYwspbDao.queryById(zdryYwspb.getId());
		try{
			SysMessage sysmessage = new SysMessage();
			sysmessage.setId(Long.valueOf(messageid));
			sysmessage.setCksj(DateUtils.getSystemDateTimeString());
			sysMessageDao.upadate(sysmessage);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		ZdryLczywblb zdryLczywblb = zdryLczywblbDao.queryById(zdryYwspb
				.getYwbid());
		if (zdryLczywblb != null) {
			// 根据审批结果修改业务状态
			if (ZdryLczywblb.YWCLJG_CG.equals(zdryYwspb.getSpjg())) {// 审批通过
				zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_CG);
			} else if ("0".equals(zdryYwspb.getSpjg())) {
				zdryLczywblb.setYwcljg(ZdryLczywblb.YWCLJG_SB);
			}
			super.setUpdateProperties(zdryLczywblb, sessionBean);
			zdryLczywblbDao.update(zdryLczywblb);
			zdryLcgService.sendMessageByLczywb(zdryLczywblb.getId(),
					sessionBean);
		} else {// 这里处理核实审批
			String xxnr = "";
			String xxbt = "重点人员核实撤管审批结果";
			String spbm = orgOrganizationService
					.queryOrgNameByOrgcodes(zdryYwspb.getSpbm());
			ZdryHsb zdryHsb = zdryHsbDao.queryById(zdryYwspb.getYwbid());
			if ("0".equals(zdryYwspb.getSpjg())) {
				xxnr = spbm +"所长"+ zdryYwspb.getSpr_xm() + "审批不同意重点人员"
						+ zdryHsb.getXm() + "的核实撤管申请。";
				zdryHsb.setHszt("0");
			} else if ("1".equals(zdryYwspb.getSpjg())) {
				zdryHsb.setHszt("2");
				xxnr = spbm +"所长"+ zdryYwspb.getSpr_xm() + "已同意重点人员"
						+ zdryHsb.getXm() + "的核实撤管申请。";
			}
			super.setUpdateProperties(zdryHsb, sessionBean);
			zdryHsbDao.update(zdryHsb);
			// 这里核实审批发送消息
			SysMessage message = new SysMessage();
			message.setFsr(sessionBean.getUserName());
			message.setFsrdm(sessionBean.getUserId());
			message.setFssj(DateUtils.getSystemDateTimeString());
			message.setFsrssdw(sessionBean.getUserOrgName());
			message.setFsrssdwdm(sessionBean.getUserOrgCode());
			message.setXxnr(xxnr);
			message.setXxbt(xxbt);
			message.setXxlb("1");
			sysMessageDao.saveMessageByUser(message, zdryYwspb.getSqr_id());
		}
	}

	@Override
	public ZdryYwspb queryById(String id) {
		return zdryYwspbDao.queryById(id);
	}

	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO(审批列表查询)
	 * @param @param entity
	 * @param @param page
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryList(ZdryYwspbVo entity, EasyUIPage page,
			SessionBean sessionBean) {
		entity.setSpbm(sessionBean.getUserOrgCode());
		entity.setSpr_id(sessionBean.getUserId());
		if(StringUtils.isBlank(entity.getSfsp())){//默认未审批
			entity.setSfsp("0");
		}
		return zdryYwspbDao.queryList(entity, page);		

	}
}
