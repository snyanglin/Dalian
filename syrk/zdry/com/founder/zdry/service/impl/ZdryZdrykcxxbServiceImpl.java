package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryZdrykcxxb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdryZdrykcxxbDao;
import com.founder.zdry.service.ZdryGlpzpzbService;
import com.founder.zdry.service.ZdryZdrykcxxbService;
import com.founder.zdry.service.ZdryZdryzbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryZdrykcxxbServiceImpl.java]
 * @ClassName: [ZdryZdrykcxxbServiceImpl]
 * @Description: [重点人员补充信息－考察]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryZdrykcxxbService")
@Transactional
public class ZdryZdrykcxxbServiceImpl implements ZdryZdrykcxxbService {

	@Resource(name = "zdryZdrykcxxbDao")
	private ZdryZdrykcxxbDao zdryZdrykcxxbDao;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	@Resource(name = "zdryGlpzpzbService")
	private ZdryGlpzpzbService zdryGlpzpzbService;

	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryZdrykcxxb entity) {
		return zdryZdrykcxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryZdrykcxxb 返回类型
	 * @throws
	 */
	public ZdryZdrykcxxb queryById(String id) {
		return zdryZdrykcxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryZdrykcxxbDao.save(entity, sessionBean);
		sendMessage(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryZdrykcxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryZdrykcxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryZdrykcxxb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryZdrykcxxbDao.delete(entityArray[i], sessionBean);
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送考察（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendMessage(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		if (entity != null) {
			ZdryZdryzb zdryZdryzb = zdryZdryzbService.queryById(entity
					.getZdryid());
			if (zdryZdryzb != null) {
				SysMessage sysMessage = new SysMessage();
				sysMessage.setXxlb("1");
				sysMessage.setFsr(sessionBean.getUserName());
				sysMessage.setFsrdm(sessionBean.getUserId());
				sysMessage.setFssj(DateUtils.getSystemDateTimeString());
				sysMessage.setFsrssdw(sessionBean.getUserOrgName());
				sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
				sysMessage.setDxzt("0");
				sysMessage.setJslx("0"); // 默认接收类型为人员
				String ywurl = "";
				sysMessage.setYwurl(ywurl);
				sysMessage.setXxbt("重点人员考察");
				sysMessage.setXxnr(entity.getKcqk());
				sysMessageDao.saveMessageByOrgAndPos(sysMessage,
						sessionBean.getExtendValue("ssPcsCode"), "SZ");
				String zdrygllxdm = zdryZdryzb.getZdrygllxdm();
				StringBuffer xxnr = new StringBuffer();
				xxnr.append(sessionBean.getUserName());
				xxnr.append("已登记");
				try {
					xxnr.append(sysDictGlService.getDictCt("D_RK_ZDRYLXDM",
							zdrygllxdm));
				} catch (Exception e) {
				}
				xxnr.append(zdryZdryzb.getXm());
				xxnr.append("考察信息。");
				sysMessage.setXxnr(xxnr.toString());
				sysMessageDao.saveMessageByOrgAndPos(sysMessage,
						sessionBean.getExtendValue("ssPcsCode"), "SZ");

				String jgbmdm = "";
			
				if (!StringUtils.isBlank(jgbmdm)) { // 上级指定列管的需要发送给监督部门
					sysMessageDao.saveMessageByOrg(sysMessage, jgbmdm, false,
							false);
				}
			}
		}
	}

}
