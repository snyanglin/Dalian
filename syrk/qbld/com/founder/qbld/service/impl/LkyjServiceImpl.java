package com.founder.qbld.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.qbld.bean.LkyjxxQsb;
import com.founder.qbld.bean.LkyjczFkb;
import com.founder.qbld.bean.Lkyjxxb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.LkyjDao;
import com.founder.qbld.service.LkyjService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjServiceImpl.java]  
 * @ClassName:    [LkyjServiceImpl]   
 * @Description:  [临控预警服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:59:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:59:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("lkyjService")
@Transactional
public class LkyjServiceImpl extends BaseService implements LkyjService {
	
	@Resource(name = "lkyjDao")
	private LkyjDao lkyjDao;

	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	@Override
	public EasyUIPage queryLkyjList(EasyUIPage page, Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "zlfbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("lkyjxxb", entity);
		List<?> list = lkyjDao.queryLkyjList(page, map);
		int count = (int) lkyjDao.queryLkyjCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	@Override
	public Lkyjxxb queryLkyj(Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjxxb", entity);
		return lkyjDao.queryLkyj(map);
	}

	@Override
	public LkyjczFkb queryLkyjFkb(LkyjczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjczfkb", entity);
		return lkyjDao.queryLkyjFkb(map);
	}

	@Override
	public int updateLkyjxxb(String qsfkzt, Lkyjxxb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setXgsj(now);
		//更新临控预警表状态等信息
		return lkyjDao.updateLkyjxxb(entity);
	}

	@Override
	public String saveLkyjzlQsb(LkyjxxQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsdwjgdm(session.getUserOrgCode());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsrxm(session.getUserName());
		entity.setQsdw(session.getUserOrgNameQc());
		//插入预警签收表数据
		return lkyjDao.saveLkyjQs(entity);
	}
	
	@Override
	public String saveLkyjzlFkb(LkyjczFkb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatShort = new SimpleDateFormat("yyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setFksj(nowStr);
		entity.setFkrxm(session.getUserName());
		entity.setFkrsfzh(session.getUserId());
		entity.setFkdwjgdm(session.getUserOrgCode());
		entity.setFkdw(session.getUserOrgNameQc());
		//yjxxbh为组织结构前6位+日期YYMMDD+0000000001序列
		String orgcode = session.getUserOrgCode();
		String yymmdd = formatShort.format(cal.getTime());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		return lkyjDao.saveLkyjFk(entity);
	}
	
	@Override
	public EasyUIPage queryLkyjFkList(EasyUIPage page, LkyjczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "fksj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("lkyjczfkb", entity);
		List<?> list = lkyjDao.queryLkyjFkList(page, map);
		int count = (int) lkyjDao.queryLkyjFkCount(map);
		page.setTotal(count);
		page.setRows(list);		
		return page;
	}

	@Override
	public List<Map<String, String>> lkyjxxb_query_export(Lkyjxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjxxb", entity);
		List<Map<String, String>> list = lkyjDao.lkyjxxb_query_export(map);
		for (int i = 0; i < list.size(); i++) {
			Map<String,String> maps = list.get(i);
			String qsfkzt = maps.get("QSFKZT");
			if ("1".equals(qsfkzt)) {
				qsfkzt = "已签收";
			} else if("2".equals(qsfkzt)) {
				qsfkzt = "已反馈";
			} else {
				qsfkzt = "未签收";
			}
			maps.put("QSFKZT", qsfkzt);
		}
		return list;
	}
	
}
