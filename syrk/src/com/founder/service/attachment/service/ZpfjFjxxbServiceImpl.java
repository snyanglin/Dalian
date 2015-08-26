package com.founder.service.attachment.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.systemconfig.bean.SysXtcsGlobal;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.bean.ZpfjFjxzjlb;
import com.founder.service.attachment.dao.ZpfjFjxxbDao;

@Service("zpfjFjxxbService")
@Transactional
public class ZpfjFjxxbServiceImpl implements ZpfjFjxxbService {

	@Resource(name = "zpfjFjxxbDao")
	private ZpfjFjxxbDao zpfjFjxxbDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZpfjFjxxb entity) {
		return zpfjFjxxbDao.queryList(page, entity);
	}

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjFjxxb queryZpfjFjxxbById(String id) {
		return zpfjFjxxbDao.queryZpfjFjxxbById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void saveZpfjFjxxb(List<ZpfjFjxxb> list, SessionBean sessionBean) {
		for (int i = 0; i < list.size(); i++) {
			ZpfjFjxxb entity = list.get(i);
			entity.setId(UUID.create()); // 生成主键
			BaseService.setSaveProperties(entity, sessionBean);
			zpfjFjxxbDao.saveZpfjFjxxb(entity, sessionBean);
		}
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void updateZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean) {
		String id = zpfjFjxxbDao.queryZpfjFjxxbId(entity.getLybm(),
				entity.getLyid());
		if (StringUtils.isBlank(id)) {
			entity.setId(UUID.create()); // 生成主键
			BaseService.setSaveProperties(entity, sessionBean);
			zpfjFjxxbDao.saveZpfjFjxxb(entity, sessionBean);
		} else {
			entity.setId(id);
			BaseService.setUpdateProperties(entity, sessionBean);
			zpfjFjxxbDao.updateZpfjFjxxb(entity, sessionBean);
		}
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void deleteZpfjFjxxb(ZpfjFjxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zpfjFjxxbDao.deleteZpfjFjxxb(entity, sessionBean);
	}

	/**
	 * 下载单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public ZpfjFjxxb downloadZpfjFjxxbById(String id, SessionBean sessionBean) {
		ZpfjFjxxb entity = zpfjFjxxbDao.queryZpfjFjxxbById(id);
		if (entity != null) {
			zpfjFjxxbDao.addDownLoadTimes(id);
			ZpfjFjxzjlb zpfjFjxzjlb = new ZpfjFjxzjlb();
			zpfjFjxzjlb.setId(UUID.create()); // 生成主键
			zpfjFjxzjlb.setWjid(id);
			BaseService.setSaveProperties(zpfjFjxzjlb, sessionBean);
			zpfjFjxxbDao.saveZpfjFjxzjlb(zpfjFjxzjlb, sessionBean);
		}
		return entity;
	}

	/**
	 * 新增下载记录 <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public void saveZpfjFjxzjlb(ZpfjFjxzjlb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zpfjFjxxbDao.saveZpfjFjxzjlb(entity, sessionBean);
	}

	public ZpfjFjxxb showZpByLyid(String lyid) {

		return zpfjFjxxbDao.queryZpByLyid(lyid);
	}

	/**
	 * 查询附件ID列表，多个时用（如多张图片时控制上一张、下一张显示） <br>
	 * 
	 * @param ZpfjFjxxb
	 */
	public String queryZpfjIdList(String lybm, String lyid) {
		return zpfjFjxxbDao.queryZpfjIdList(lybm, lyid);
	}

	/***
	 * @Title: saveFj
	 * @Description: 保存多个附件到系统附件表
	 * @author wu_chunhui@founder.com.cn
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @return void
	 * @throws
	 */
	public void saveSystemFj(SessionBean sessionBean,
			CommonsMultipartFile[] uploadFile, String lybm, String lyid,
			String lyms) {
		// 这里把附件存储到公共附件表
		List<ZpfjFjxxb> list = new ArrayList<ZpfjFjxxb>();
		for (int i = 0; i < uploadFile.length; i++) {
			CommonsMultipartFile multipartFile = uploadFile[i];
			if (!multipartFile.isEmpty()) {
				FileItem fileItem = multipartFile.getFileItem();
				ZpfjFjxxb entity = new ZpfjFjxxb();
				entity.setLybm(lybm);
				entity.setLyid(lyid);
				entity.setLyms(lyms);
				String wjmc = fileItem.getName();
				String wjhzlx = "";
				int atI = wjmc.lastIndexOf(".");
				if (atI != -1) {
					wjhzlx = wjmc.substring(atI + 1);
					wjhzlx = wjhzlx.toLowerCase();
				}
				entity.setWjmc(wjmc);
				entity.setWjhzlx(wjhzlx);
				entity.setWj(multipartFile.getBytes());
				long wjdx = entity.getWj().length;
				entity.setWjdx(new Long(wjdx));
				String wjdxsm = "";
				if (wjdx < 1024) {
					wjdxsm = "" + wjdx + " B";
				} else if (wjdx > 1048576) {
					double mb = Math.floor(wjdx / 1048576);
					DecimalFormat formater = new DecimalFormat("###,###,###.00");
					wjdxsm = "" + formater.format(mb) + " MB";
				} else {
					long kb = (long) Math.floor(wjdx / 1024);
					wjdxsm = "" + kb + " KB";
				}
				entity.setWjdxsm(wjdxsm);
				entity.setWjxzcs(new Long(0));
				list.add(entity);
			}
		}
		if (list.size() > 0) {
			saveZpfjFjxxb(list, sessionBean);
		}
	}

}
