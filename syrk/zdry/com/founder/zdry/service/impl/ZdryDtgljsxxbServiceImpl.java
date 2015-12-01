package com.founder.zdry.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.dictionary.service.SysDictGlService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryDtgljsxxb;
import com.founder.zdry.bean.ZdryGlpzpzb;
import com.founder.zdry.bean.ZdryJsmbpzb;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.dao.ZdryDtgljsxxbDao;
import com.founder.zdry.service.ZdryDtgljsxxbService;
import com.founder.zdry.service.ZdryGlpzpzbService;
import com.founder.zdry.service.ZdryJsmbpzbService;
import com.founder.zdry.service.ZdryZdryzbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryDtgljsxxbServiceImpl.java]
 * @ClassName: [ZdryDtgljsxxbServiceImpl]
 * @Description: [重点人员补充信息－动态管理纪实]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryDtgljsxxbService")
@Transactional
public class ZdryDtgljsxxbServiceImpl implements ZdryDtgljsxxbService {

	@Resource(name = "zdryDtgljsxxbDao")
	private ZdryDtgljsxxbDao zdryDtgljsxxbDao;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;

	@Resource(name = "zdryGlpzpzbService")
	private ZdryGlpzpzbService zdryGlpzpzbService;

	@Resource(name = "zdryJsmbpzbService")
	private ZdryJsmbpzbService zdryJsmbpzbService;

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
	public EasyUIPage queryList(EasyUIPage page, ZdryDtgljsxxb entity) {
		return zdryDtgljsxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryDtgljsxxb 返回类型
	 * @throws
	 */
	public ZdryDtgljsxxb queryById(String id) {
		return zdryDtgljsxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryDtgljsxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtgljsxxbDao.save(entity, sessionBean);
		sendMessage(entity, sessionBean);
	}

	
	/**
	 * 自动新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void autoSave(ZdryDtgljsxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtgljsxxbDao.save(entity, sessionBean);
	}
	
	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryDtgljsxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryDtgljsxxbDao.update(entity, sessionBean);

		ZdryZdryzb zdryZdryzb = new ZdryZdryzb();
		zdryZdryzb.setId(entity.getZdryid());
		zdryZdryzb.setSfzkdm(entity.getSfzkdm());
		zdryZdryzbService.update(zdryZdryzb, sessionBean); // 更新总表是否在控字段
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryDtgljsxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryDtgljsxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryDtgljsxxb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryDtgljsxxbDao.delete(entityArray[i], sessionBean);
		}
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送动态管理纪实（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendMessage(ZdryDtgljsxxb entity, SessionBean sessionBean) {
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
				String ywurl = "/zdryDtgljsxxb/view?id=" + entity.getId();
				sysMessage.setYwurl(ywurl);
				sysMessage.setXxbt("重点人员动态管理纪实");

				String zdrygllxdm = zdryZdryzb.getZdrygllxdm();
				StringBuffer xxnr = new StringBuffer();
				xxnr.append(sessionBean.getExtendValue("ssFsxName"));
				xxnr.append(sessionBean.getExtendValue("ssPcsName"));
				xxnr.append(sessionBean.getUserOrgName());
				xxnr.append("管辖");
				try {
					xxnr.append(sysDictGlService.getDictCt("D_RK_ZDRYLXDM",
							zdrygllxdm));
				} catch (Exception e) {
				}
				xxnr.append(zdryZdryzb.getXm());
				xxnr.append("动态纪实已经由");
				xxnr.append(sessionBean.getUserName());
				xxnr.append("完成登记。动态纪实内容：");
				xxnr.append(entity.getDtjs());
				sysMessage.setXxnr(xxnr.toString());
				sysMessageDao.saveMessageByOrgAndPos(sysMessage,
						sessionBean.getExtendValue("ssPcsCode"), "SZ");

				String jgbmdm = "";
				if (!StringUtils.isBlank(zdryZdryzb.getZdlgbmid())) {
					jgbmdm = zdryZdryzb.getZdlgbmid();
				}
				if (!StringUtils.isBlank(jgbmdm)) { // 上级指定列管的需要发送给监督部门
					sysMessageDao.saveMessageByOrg(sysMessage, jgbmdm, false,
							false);
				}
			}
		}
	}

	/**
	 * @Title: getJsmbListJson
	 * @Description: TODO(取得纪实模板combobox的json格式字符串)
	 * @param @param zdrygllxdm
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getJsmbListJson(String zdrygllxdm) {
		StringBuffer sb = new StringBuffer();
		sb.append("[" + StringUtils.enterNewline);
		if (!StringUtils.isBlank(zdrygllxdm)) {
			List<ZdryJsmbpzb> list = zdryJsmbpzbService
					.queryForList(zdrygllxdm);
			if (list != null && list.size() > 0) {
				String dm, mc, mbnr;
				long countAdd = 0;
				long count = list.size();
				for (int i = 0; i < list.size(); i++) {
					ZdryJsmbpzb entity = (ZdryJsmbpzb) list.get(i);
					countAdd++;
					dm = "" + (i + 1);
					mc = StringUtils.nullToStr(entity.getMbmc());
					mbnr = StringUtils.nullToStr(entity.getMbnr());
					dm = dm.replaceAll("\n", "");
					mc = mc.replaceAll("\n", "");
					mc = mc.replaceAll("\\\\", "\\\\\\\\");
					mc = mc.replaceAll("\"", "\\\\\"");
					mbnr = mbnr.replaceAll("\\\\", "\\\\\\\\");
					mbnr = mbnr.replaceAll("\"", "\\\\\"");
					mbnr = mbnr.replaceAll(StringUtils.enterNewline, "\\\\n");
					mbnr = mbnr.replaceAll(StringUtils.enterNewline_linux, "\\\\n");
					//mbnr = mbnr.replaceAll("\r\n", "");
					String optionString = "\"id\":\"" + dm + "\",\"text\":\""
							+ mc + "\",\"mbnr\":\"" + mbnr + "\"";
					sb.append("{" + optionString + "}");
					if (countAdd < count) {
						sb.append(",");
					}
					sb.append(StringUtils.enterNewline);
				}
			}
		}
		sb.append("]" + StringUtils.enterNewline);
		return sb.toString();
	}
}
