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
import com.founder.qbld.bean.CkyjzlczFkb;
import com.founder.qbld.bean.CkyjzlQsb;
import com.founder.qbld.bean.Ckyjzlb;
import com.founder.qbld.dao.CkyjDao;
import com.founder.qbld.dao.CkyjzlDao;
import com.founder.qbld.service.CkyjzlService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.CkyjzlServiceImpl.java]  
 * @ClassName:    [CkyjzlServiceImpl]   
 * @Description:  [常控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ckyjzlService")
@Transactional
public class CkyjzlServiceImpl extends BaseService implements CkyjzlService {
	
	@Resource(name = "ckyjzlDao")
	private CkyjzlDao ckyjzlDao;
	
	@Resource(name = "ckyjDao")
	private CkyjDao ckyjDao;

	@Override
	public EasyUIPage queryCkyjzlList(EasyUIPage page, Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "fbsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("ckyjzlb", entity);
		List<?> list = ckyjzlDao.queryCkyjzlList(page, map);
		int count = (int) ckyjzlDao.queryCkyjzlCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	@Override
	public Ckyjzlb queryCkyjzl(Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlb", entity);
		return ckyjzlDao.queryCkyjzl(map);
	}

	@Override
	public CkyjzlczFkb queryCkyjzlFkb(CkyjzlczFkb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlfkb", entity);
		return ckyjzlDao.queryCkyjzlFkb(map);
	}

	@Override
	public int updateCkyjzlb(String qsfkzt, Ckyjzlb entity, SessionBean session) {
		entity.setQsfkzt(qsfkzt);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String now = format.format(cal.getTime());
		entity.setQssj(now);
		//更新常控预警指令表状态等信息
		return ckyjzlDao.updateCkyjzlb(entity);
	}

	@Override
	public String saveCkyjzlQsb(CkyjzlQsb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setQssj(nowStr);
		entity.setQsrxm(session.getUserName());
		entity.setQsrsfzh(session.getUserId());
		entity.setQsdw_dm(session.getUserOrgCode());
		entity.setQsdw_mc(session.getUserOrgNameQc());
		//插入预警签收表数据
		return ckyjzlDao.saveCkyjzlQs(entity);
	}
	
	@Override
	public String saveCkyjzlFkb(CkyjzlczFkb entity, SessionBean session) {
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		SimpleDateFormat formatShort = new SimpleDateFormat("yyMMdd"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		entity.setFksj(nowStr);
		entity.setFkdwjgdm(session.getUserOrgCode());
		entity.setFkdw(session.getUserOrgNameQc());
		entity.setFkrxm(session.getUserName());
		entity.setFkrsfzh(session.getUserId());
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
		//插入常控预警指令反馈表数据
		return ckyjzlDao.saveCkyjzlFk(entity);
	}
	
	@Override
	public String updateCkyjzlbAndSaveFkb(Ckyjzlb entity, SessionBean session) {
		entity.setQsfkzt("2");
		SimpleDateFormat formatStr = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Calendar cal = Calendar.getInstance();
		String nowStr = formatStr.format(cal.getTime());
		//更新常控预警指令表状态等信息
		int id = ckyjzlDao.updateCkyjzlb(entity);
		String restStr = "";
		if(id > 0){
			CkyjzlczFkb fkb = new CkyjzlczFkb();
			fkb.setYjzlbh(entity.getYjzlbh());
			fkb.setFksj(nowStr);
			fkb.setFkrxm(session.getUserName());
			fkb.setFkrsfzh(session.getUserId());
			//插入常控预警指令反馈表数据
			restStr = ckyjzlDao.saveCkyjzlFk(fkb);
		}
		return restStr;
	}
	
	@Override
	public EasyUIPage queryCkyjzlFkList(EasyUIPage page, CkyjzlczFkb entity) {
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
		map.put("ckyjzlczFkb", entity);
		List<?> list = ckyjzlDao.queryCkyjzlFkList(page, map);
		int count = (int) ckyjzlDao.queryCkyjzlFkCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}
	
	@Override
	public String updateCkyjzlczFkb(CkyjzlczFkb entity) {
		return ckyjzlDao.updateCkyjzlczFkb(entity);
	}
	
	@Override
	public List<Map<String, String>> ckyjzlxxb_query_export(Ckyjzlb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ckyjzlb", entity);
		List<Map<String, String>> list = ckyjzlDao.ckyjzlb_query_export(map);
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
