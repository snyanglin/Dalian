package com.founder.zdry.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.bean.ZdryYwspb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdryGlpzpzbDao;
import com.founder.zdry.dao.ZdryLczywblbDao;
import com.founder.zdry.dao.ZdryYwspbDao;
import com.founder.zdry.dao.ZdryZdryzbDao;
import com.founder.zdry.service.ZdryLcgService;
import com.founder.zdry.service.ZdryZdService;
import com.founder.zdry.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.service.impl.ZdryZdServiceImpl.java]
 * @ClassName: [ZdryZdServiceImpl]
 * @Description: [重点人员转递逻辑处理]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:38:59]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:38:59，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("zdryZdService")
@Transactional
public class ZdryZdServiceImpl extends BaseService implements ZdryZdService {

	@Resource(name = "zdryLczywblbDao")
	private ZdryLczywblbDao zdryLczywblbDao;
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "zdryLcgService")
	private ZdryLcgService zdryLcgService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "zdryGlpzpzbDao")
	private ZdryGlpzpzbDao zdryGlpzpzbDao;
	@Resource(name = "zdryYwspbDao")
	private ZdryYwspbDao zdryYwspbDao;

	@Override
	public String sendZd(ZdryLczywblb zdryLczywblb, ZdryZdryzbVO zdryZdryzbVo,
			SessionBean sessionBean) throws BussinessException {
		ZdryLczywblb zdjsyw = new ZdryLczywblb();
		// 保存业务,发起业务
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryBySyrkidAndgllx(zdryZdryzbVo.getSyrkid(),zdryZdryzbVo.getZdrygllxdm());
		//修改总表状态为5
		zdryZdryzb.setGlzt("5");
		super.setSaveProperties(zdryZdryzb, sessionBean);
		zdryZdryzbDao.update(zdryZdryzb);
		zdryLczywblb.setZdryid(zdryZdryzb.getId());
		zdryLczywblb.setYwlx(ZdryLczywblb.YWLX_ZDFQ);
		zdryLczywblb.setId(UUID.create());

		try {
			// 页面传递地址为现居住地址,应该保存在接收业务中.
			BeanUtils.copyObjectSameProperties(zdryLczywblb, zdjsyw);
			// 地址处理end
			BeanUtils.copyObjectSameProperties(zdryZdryzbVo, zdryLczywblb);// 发起业务沿用总表地址信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		zdryLczywblb.setYwcljg("1");
		zdryLczywblb.setSspcsdm(zdryZdryzbVo.getYgxpcsdm());
		zdryLczywblb.setSszrqdm(zdryZdryzbVo.getYgxzrqdm());
		BaseService.setSaveProperties(zdryLczywblb, sessionBean);
		zdryLczywblb.setId(UUID.create());
		zdryLczywblbDao.save(zdryLczywblb);
		// 保存业务，接收业务
		zdjsyw.setYwlx(ZdryLczywblb.YWLX_ZDJS);
		zdjsyw.setId(UUID.create());
		// 接收业务还没处理,处理情况字段设置为null
		zdjsyw.setYwblr_id("");
		zdjsyw.setYwblr_xm("");
		zdjsyw.setYwclsj("");
		zdjsyw.setYwfqyy("");
		// 地址信息取得end
		BaseService.setSaveProperties(zdjsyw, sessionBean);
		zdjsyw.setQxywid(zdryLczywblb.getId());
		//zdjsyw.setYwcljg("0");
		zdjsyw.setId(UUID.create());
		zdryLczywblbDao.save(zdjsyw);
		// 发起转递代办业务
		return zdryLcgService.sendApproval(zdjsyw.getSszrqdm(), null,
				zdjsyw.getId(), sessionBean);
	}

	@Override
	public String receiveZd(String messageID, ZdryLczywblb zdryLczywblb,
			SessionBean sessionBean, String xgxzrqdm, String xgxpcsdm)
			throws BussinessException {
		SysMessage sysMessage = new SysMessage();
		if(!StringUtils.isBlank(messageID)){
		sysMessage.setId(Long.valueOf(messageID));
		sysMessageDao.upadate(sysMessage);
		}
		// 这里判断处理结构,进行业务逻辑.如果同意则业务转递，如果不同意则上级裁定
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		BaseService.setUpdateProperties(zdryLczywblb, sessionBean);
		zdryLczywblbDao.update(zdryLczywblb);
		zdryLcgService.sendMessageByLczywb(zdryLczywblb.getId(), sessionBean);
		if (zdryLczywblb.getYwcljg().equals("1")) {// 同意转移
			zdryLczywblb.setSszrqdm(xgxzrqdm);
			zdryLczywblb.setSspcsdm(xgxpcsdm);
			zdZdryZb(zdryLczywblb,sessionBean);
		} else if (zdryLczywblb.getYwcljg().equals("2")) {// 拒绝转递,发送裁决任务
			zdryLczywblb = zdryLczywblbDao.queryById(zdryLczywblb.getId());
			//查询发起业务信息
			ZdryLczywblb zdfqyw = zdryLczywblbDao.queryById(zdryLczywblb.getQxywid());
			ZdryLczywblb zdcjyw = new ZdryLczywblb();
			try {
				BeanUtils.copyObjectSameProperties(zdryLczywblb, zdcjyw);
			} catch (Exception e) {
				e.printStackTrace();
			}
			zdcjyw.setYwblr_id("");
			zdcjyw.setYwblr_xm("");
			zdcjyw.setYwclsj("");
			zdcjyw.setYwfqyy("");
			zdcjyw.setYwcljg("");
			zdcjyw.setId(UUID.create());
			zdcjyw.setQxywid(zdryLczywblb.getId());
			zdcjyw.setYwlx(ZdryLczywblb.YWLX_ZDCJ);
			zdcjyw.setSspcsdm(xgxpcsdm);
			zdcjyw.setSszrqdm(xgxzrqdm);
			BaseService.setSaveProperties(zdcjyw, sessionBean);
			zdryLczywblbDao.save(zdcjyw);
			// 发送裁决代办任务
			/*	OrgOrganization orgOrganization = orgOrganizationService
						.querySameParentOrg(zdryLczywblb.getSszrqdm(),
								zdcjyw.getSszrqdm());*/
				ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb.getZdryid());
				ZdryGlpzpzb zdryGlpzpzb =zdryGlpzpzbDao.queryByZdrygllxdmWhitOutSfsp(zdryZdryzb.getZdrygllxdm());
				if(zdryGlpzpzb!=null){
					return zdryLcgService.sendApproval(zdryGlpzpzb.getJgbmdm(),
							null, zdcjyw.getId(), sessionBean);
				}

		}
		return null;
	}

	@Override
	public void ruleZd(String messageID, ZdryLczywblb zdryLczywblb,
			SessionBean sessionBean) throws BussinessException {
		SysMessage sysMessage = new SysMessage();
		if(!StringUtils.isBlank(messageID)){
		sysMessage.setId(Long.valueOf(messageID));
		sysMessageDao.upadate(sysMessage);}
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		if (StringUtils.isBlank(zdryZdryzb)) {
			throw new BussinessException("zdryZdryzb is not exist");
		}
		zdryLczywblb.setYwblr_id(sessionBean.getUserId());
		zdryLczywblb.setYwblr_xm(sessionBean.getUserName());
		zdryLczywblb.setYwclsj(DateUtils.getSystemDateString());
		BaseService.setUpdateProperties(zdryLczywblb, sessionBean);
		zdryLczywblbDao.update(zdryLczywblb);
		//修改审批表结果
		zdryLczywblb = zdryLczywblbDao.queryById(zdryLczywblb.getId());
		ZdryYwspb zdryYwspb = new ZdryYwspb();
		zdryYwspb.setYwbid(zdryLczywblb.getId());
		List<ZdryYwspb> list =zdryYwspbDao.query(zdryYwspb);
		if(list!=null&&list.size()>0){
			zdryYwspb=list.get(0);
		}
		//修改审批表结果 end 
		zdryLcgService.sendMessageByLczywb(zdryLczywblb.getId(), sessionBean);
		if (zdryLczywblb.getYwcljg().equals("0")) {// 拒绝转递,返回原籍,业务结束
			zdryZdryzb.setGlzt("2");
			super.setUpdateProperties(zdryZdryzb, sessionBean);
			zdryZdryzbDao.update(zdryZdryzb);
			zdryYwspb.setSpjg("2");
		} else if (zdryLczywblb.getYwcljg().equals("1")) {// 同意转递
			ZdryLczywblb zdjsyw=zdryLczywblbDao.queryById(zdryLczywblb.getQxywid());
			zdryYwspb.setSpjg("1");
			zdjsyw.setYwcljg("");
		/*	ZdryYwspb jssp =new ZdryYwspb();
			jssp.setYwbid(zdjsyw.getId());
			jssp=zdryYwspbDao.query(jssp).get(0);
			jssp.setSpjg("");
			zdryYwspbDao.update(jssp)*/
			zdryLczywblbDao.update(zdjsyw);
			zdZdryZb(zdjsyw,sessionBean);
			//任务打回接收民警选择人员居住地址，重新发起转递任务
			 zdryLcgService.sendApproval(zdjsyw.getSszrqdm(), null,
					zdjsyw.getId(), sessionBean);
		}
		BaseService.setUpdateProperties(zdryYwspb, sessionBean);
		zdryYwspbDao.update(zdryYwspb);

	}

	/***
	 * 
	 * @Title: zdZdryZb
	 * @Description: TODO(转递中业务逻辑变动)
	 * @param @param zdryLczywblb
	 * @param @throws BussinessException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void zdZdryZb(ZdryLczywblb zdryLczywblb,SessionBean sessionBean) throws BussinessException {
		ZdryZdryzb zdryZdryzb = zdryZdryzbDao.queryById(zdryLczywblb
				.getZdryid());
		zdryZdryzb.setGlzt("2");
		zdryZdryzbDao.update(zdryZdryzb);
		if (StringUtils.isBlank(zdryZdryzb)) {
			throw new BussinessException("zdryZdryzb is not exist");
		}
		if (!StringUtils.isBlank(zdryLczywblb.getSyrkid())) {
			zdryZdryzb.setSyrkid(zdryLczywblb.getSyrkid());
			zdryZdryzb.setSszrqdm(zdryLczywblb.getSszrqdm());
			zdryZdryzb.setSspcsdm(zdryLczywblb.getSspcsdm());
			zdryZdryzb.setDz_jzdzdm(zdryLczywblb.getDz_jzdzdm());
			zdryZdryzb.setDz_jzdzmlpdm(zdryLczywblb.getDz_jzdzmlpdm());
			zdryZdryzb.setDz_jzdzmlpxz(zdryLczywblb.getDz_jzdzmlpxz());
			zdryZdryzb.setDz_jzdzxz(zdryLczywblb.getDz_jzdzxz());
			BaseService.setUpdateProperties(zdryLczywblb, sessionBean);
			zdryLczywblbDao.update(zdryLczywblb);
			BaseService.setUpdateProperties(zdryZdryzb, sessionBean);
			zdryZdryzbDao.update(zdryZdryzb);
		} else {
			throw new BussinessException("zdryZd Failuer,转递失败,不能找到当前责任区实有人口信息 ");
		}
	}

}
