package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.dao.ZdryZdrykcxxbDao;
import com.founder.zdrygl.base.model.ZdryZdrykcxxb;
import com.founder.zdrygl.core.utils.ZdryConstant;

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
public class ZdryZdrykcxxbService{

	@Resource(name = "zdryZdrykcxxbDao")
	private ZdryZdrykcxxbDao zdryZdrykcxxbDao;
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Autowired
	private ZdryConstant zdryConstant;
/*
	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;
/
	@Resource
	private SysMessageDao sysMessageDao;

	@Resource(name = "sysDictGlService")
	private SysDictGlService sysDictGlService;
*/
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
	 * @Description: (根据ID查询单条记录)
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
	 * @Description: (发送考察（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 *
	public void sendMessage(ZdryZdrykcxxb entity, SessionBean sessionBean) {
		if (entity != null) {
			ZdryZb zdryZdryzb = (ZdryZb)zdryZdryZbDao.queryById(entity
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
					xxnr.append(zdryConstant.getValueOfZdryDict(zdrygllxdm));
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
	*/

}
