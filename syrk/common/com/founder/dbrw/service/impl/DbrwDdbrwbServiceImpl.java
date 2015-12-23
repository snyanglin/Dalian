package com.founder.dbrw.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.bean.DbrwDdbrwsjmxb;
import com.founder.dbrw.dao.DbrwDdbrwbDao;
import com.founder.dbrw.service.DbrwDdbrwbService;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.dao.OrgOrganizationDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;

@Service("dbrwDdbrwbService")
@Transactional
public class DbrwDdbrwbServiceImpl implements DbrwDdbrwbService {

	@Resource(name = "dbrwDdbrwbDao")
	private DbrwDdbrwbDao dbrwDdbrwbDao;

	@Resource
	private SysMessageDao sysMessageDao;

	@Resource(name = "orgOrganizationDao")
	private OrgOrganizationDao orgOrganizationDao;

	/**
	 * 查询单条待督办任务<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDdbrwb queryDdbrwb(String id) {
		return dbrwDdbrwbDao.queryDdbrwb(id);
	}

	/**
	 * 查询待督办任务数据明细列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage querySjmxbList(EasyUIPage page, DbrwDdbrwb entity) {
		return dbrwDdbrwbDao.querySjmxbList(page, entity);
	}

	/**
	 * 删除单条待督办任务数据明细<br>
	 * 
	 * @param id
	 *            待督办任务数据明细ID
	 */
	public void deleteDdbrwSjmxbById(DbrwDdbrwsjmxb entity) {
		dbrwDdbrwbDao.deleteDdbrwSjmxbById(entity.getId());
	}

	/**
	 * 删除批量待督办任务数据明细<br>
	 * 
	 * @param entityArray
	 */
	public void deleteDdbrwSjmxbPatch(DbrwDdbrwsjmxb[] entityArray) {
		for (int i = 0; i < entityArray.length; i++) {
			dbrwDdbrwbDao.deleteDdbrwSjmxbById(entityArray[i].getId());
		}
	}

	/**
	 * 新增督办任务<br>
	 * 
	 * @param entity
	 * @param ddbrwid
	 * @param sessionBean
	 */
	public void insertDbrwb(DbrwDbrwb entity, Map<String, String> coultMap,
			SessionBean sessionBean) {
		String dbrwid = UUID.create();
		entity.setId(dbrwid);
		entity.setRwzt("0");
		entity.setRwfqsj(DateUtils.getSystemDateTimeString());
		BaseService.setSaveProperties(entity, sessionBean);
		dbrwDdbrwbDao.insertDbrwb(entity);
		coultMap.put("dbrwid", dbrwid);
		dbrwDdbrwbDao.insertDbsjmxb(coultMap);
		String messageOrgCodes = dbrwDdbrwbDao.queryDbrwMessageOrg(coultMap);
		if (!StringUtils.isBlank(messageOrgCodes)) {
			SysMessage sysMessage = new SysMessage(); // 发送消息
			sysMessage.setXxnr(entity.getRwbt());
			sysMessage.setXxlb("5");
			sysMessage.setYwurl("/dbrwRwcl/rwcl?id=" + dbrwid);
			sysMessage.setFsr(sessionBean.getUserName());
			sysMessage.setFsrdm(sessionBean.getUserId());
			sysMessage.setFssj(DateUtils.getSystemDateTimeString());
			sysMessage.setFsrssdw(sessionBean.getUserOrgName());
			sysMessage.setFsrssdwdm(sessionBean.getUserOrgCode());
			sysMessage.setDxzt("0");
			sysMessage.setXxbt(entity.getRwbt());
			sysMessageDao.saveMessageByOrg(sysMessage, messageOrgCodes, false,
					true);

			DbrwDbrwfkb dbrwDbrwfkb = new DbrwDbrwfkb(); // 插入督办任务反馈表
			dbrwDbrwfkb.setDbrwid(dbrwid);
			dbrwDbrwfkb.setWcrwzsl(new Long(0));
			dbrwDbrwfkb.setZdhssl(new Long(0));
			dbrwDbrwfkb.setSdhssl(new Long(0));
			dbrwDbrwfkb.setXzywsjl(new Long(0));
			dbrwDbrwfkb.setZxywsjl(new Long(0));
			BaseService.setSaveProperties(dbrwDbrwfkb, sessionBean);
			String[] orgCodeArray = messageOrgCodes.split(",");
			for (int i = 0; i < orgCodeArray.length; i++) {
				dbrwDbrwfkb.setId(UUID.create());
				dbrwDbrwfkb.setFkbmdm(orgCodeArray[i]);
				dbrwDbrwfkb.setFkbmmc(orgOrganizationDao
						.queryOrgNameByOrgcodes(orgCodeArray[i]));

				coultMap.put("sszrqdm", orgCodeArray[i]);
				dbrwDbrwfkb.setRwzsl(dbrwDdbrwbDao.queryDbrwfkbRwzsl(coultMap));
				dbrwDdbrwbDao.insertDbrwDbrwfkb(dbrwDbrwfkb);
			}
		}
		dbrwDdbrwbDao.deleteDdbrwb(coultMap);
	}
}
