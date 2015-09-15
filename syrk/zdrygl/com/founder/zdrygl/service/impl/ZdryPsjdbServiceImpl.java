package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryPsjdb;
import com.founder.zdrygl.dao.ZdryPsjdbDao;
import com.founder.zdrygl.service.ZdryPsjdbService;
import com.founder.zdrygl.service.ZdryZdryzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryPsjdbService.java]  
 * @ClassName:    [ZdryPsjdbService]   
 * @Description:  [评审鉴定 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:29:27]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:29:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryPsjdbService")
@Transactional
public class ZdryPsjdbServiceImpl implements ZdryPsjdbService {

	@Resource(name = "zdryPsjdbDao")
	private ZdryPsjdbDao zdryPsjdbDao;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;



	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 *
	public EasyUIPage queryList(EasyUIPage page, ZdryPsjdb entity) {
		return zdryPsjdbDao.queryList(page, entity);
	}
*/
	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryPsjdb 返回类型
	 * @throws
	 */
	@Override
	public ZdryPsjdb queryById(String id) {
		return zdryPsjdbDao.queryById(id);
	}

	
	@Override
	public void save(ZdryPsjdb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryPsjdbDao.save(entity, sessionBean);
		//sendMessage(entity, sessionBean);
	}

	@Override
	public void update(ZdryPsjdb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryPsjdbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 *
	public void delete(ZdryPsjdb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryPsjdbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 *
	public void deletePatch(ZdryPsjdb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryPsjdbDao.delete(entityArray[i], sessionBean);
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送考察（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 *
	public void sendMessage(ZdryPsjdb entity, SessionBean sessionBean) {
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
				sysMessage.setXxbt("重点人员评审鉴定");
				sysMessage.setXxnr(entity.getNrjy());
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
				//xxnr.append(zdryZdryzb.getXm());
				xxnr.append("评审鉴定信息。");
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
