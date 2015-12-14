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
import com.founder.qbld.bean.LkyjzlQsb;
import com.founder.qbld.bean.LkyjzlczFkb;
import com.founder.qbld.bean.Lkyjzlb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.LkyjzlDao;
import com.founder.qbld.service.LkyjzlService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjzlServiceImpl.java]  
 * @ClassName:    [LkyjzlServiceImpl]   
 * @Description:  [临控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("lkyjzlService")
@Transactional
public class LkyjzlServiceImpl extends BaseService implements LkyjzlService {
	
	@Resource(name = "lkyjzlDao")
	private LkyjzlDao lkyjzlDao;

	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;
	
	@Override
	public EasyUIPage queryLkyjzlList(EasyUIPage page, Lkyjzlb entity) {
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
		map.put("lkyjzlb", entity);
		List<?> list = lkyjzlDao.queryLkyjzlList(page, map);
		int count = (int) lkyjzlDao.queryLkyjzlCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	@Override
	public Lkyjzlb queryLkyjzl(Lkyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlb", entity);
		return lkyjzlDao.queryLkyjzl(map);
	}

	@Override
	public LkyjzlczFkb queryLkyjzlFkb(LkyjzlczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlfkb", entity);
		return lkyjzlDao.queryLkyjzlFkb(map);
	}

	@Override
	public int updateLkyjzlb(String qsfkzt, Lkyjzlb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		//更新临控预警指令表状态等信息
		return lkyjzlDao.updateLkyjzlb(entity);
	}

	@Override
	public String saveLkyjzlqs(LkyjzlQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsrxm(session.getUserName());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsdw(session.getUserOrgNameQc());
		entity.setQsdwjgdm(session.getUserOrgCode());
		//插入预警签收表数据
		return lkyjzlDao.saveLkyjzlQs(entity);
	}
	
	@Override
	public String saveLkyjzlfk(LkyjzlczFkb entity, SessionBean session) {
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
		//map放入seqName、position配置序列取值和返回样式
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqName", "SEQ_YJ");
		map.put("position", "10");
		String seq = ckyjDao.queryYjSeq(map);
		String czfkxxbh = orgcode.substring(0, 6) + yymmdd + seq;
		entity.setCzfkxxbh(czfkxxbh);
		//插入临控预警指令反馈表数据
		return lkyjzlDao.saveLkyjzlFk(entity);
	}
	
	@Override
	public EasyUIPage queryLkyjzlFkList(EasyUIPage page, LkyjzlczFkb entity) {
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
		map.put("lkyjzlczFkb", entity);
		List<?> list = lkyjzlDao.queryLkyjzlFkList(page, map);
		int count = (int) lkyjzlDao.queryLkyjzlFkCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	@Override
	public List<Map<String, String>> lkyjzlb_query_export(Lkyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lkyjzlb", entity);
		List<Map<String, String>> list = lkyjzlDao.lkyjzlb_query_export(map);
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
