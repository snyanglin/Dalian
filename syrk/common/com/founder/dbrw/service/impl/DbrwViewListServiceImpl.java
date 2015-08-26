package com.founder.dbrw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwfkb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.dbrw.dao.DbrwDbrwbDao;
import com.founder.dbrw.service.DbrwViewListService;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;
import com.founder.ggfw.dao.YwxtgzrwbDao;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.dbrw.service.impl.DbrwViewListServiceImpl.java]
 * @ClassName: [DbrwViewListServiceImpl]
 * @Description: [领导查看督办任务]
 * @Author: [weiwen]
 * @CreateDate: [2014-10-26 下午4:27:47]
 * @UpdateUser: [weiwen(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-10-26 下午4:27:47，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("dbrwViewListService")
public class DbrwViewListServiceImpl extends BaseService implements
		DbrwViewListService {

	@Resource(name = "dbrwDbrwbDao")
	private DbrwDbrwbDao dbrwDbrwbDao;

	@Override
	public DbrwDbrwb getRwById(String id) {
		return dbrwDbrwbDao.queryById(id);
	}

	@Override
	public EasyUIPage list(EasyUIPage page, DbrwDbrwb rwb) {
		return dbrwDbrwbDao.queryList(page, rwb);
	}

	@Override
	public EasyUIPage list(EasyUIPage page, DbrwDbrwb rwb, String id) {
		return dbrwDbrwbDao.queryList(page, rwb, id);
	}

	@Override
	public EasyUIPage rwmxlist(EasyUIPage page, DbrwDbrwsjmxb entity) {
		return dbrwDbrwbDao.rwmxlist(page, entity);
	}

	@Override
	public Map<String, Object> gzdxChart(String rwid) {
		// 创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<DbrwDbrwfkb> list = dbrwDbrwbDao.queryCountTotal(rwid);
		list.addAll(dbrwDbrwbDao.queryCountArray(rwid));

		int rwCount = Integer.parseInt(list.get(0).getRwzsl().toString());
		int jgNumber = 0;

		if (rwCount > 10) {
			jgNumber = (rwCount / 10);
		} else {
			jgNumber = 1;
		}

		Integer[] a1 = new Integer[list.size()];

		Integer[] a2 = new Integer[list.size()];

		String[] labels = new String[list.size()];
		DbrwDbrwfkb fkb = null;
		/* 总数 */
		Map<String, Object> map = new HashMap<String, Object>();
		/* 已完成数 */
		Map<String, Object> map2 = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			fkb = list.get(i);
			a1[i] = Integer.valueOf(fkb.getRwzsl().toString());
			a2[i] = Integer.valueOf(fkb.getWcrwzsl().toString());
			labels[i] = fkb.getFkbmmc();
		}

		map.put("type", "bar");
		map.put("colour", "#32CD32");
		map.put("text", "总数");
		map.put("font-size", 12);
		map.put("values", a1);

		Map<String, Object> map_tags = new HashMap<String, Object>();
		map_tags.put("type", "tags");
		map_tags.put("colour", "#000000");
		map_tags.put("text", "总数");
		map_tags.put("font-size", 12);
		map_tags.put("values", a1);

		map2.put("type", "bar");
		map2.put("colour", "#00BFFF");
		map2.put("text", "完成数");
		map2.put("font-size", 12);
		map2.put("values", a2);

		Object[] elements = { map, map_tags, map2 };

		Map<String, Object> xaxisMap = new HashMap<String, Object>();
		xaxisMap.put("labels", labels);
		xaxisMap.put("size", 12);
		Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
		xaxisMap2.put("labels", xaxisMap);
		// xaxisMap2.put("3d", 10);

		Map<String, Object> title = new HashMap<String, Object>();
		title.put("text", "统计");

		Map<String, Object> y_axisMap = new HashMap<String, Object>();
		y_axisMap.put("min", 0);
		y_axisMap.put("max", rwCount);
		y_axisMap.put("steps", jgNumber);

		// 生成JSON格式
		returnMap.put("elements", elements);
		returnMap.put("y_axis", y_axisMap);
		returnMap.put("x_axis", xaxisMap2);
		returnMap.put("title", title);
		return returnMap;
	}

	public EasyUIPage listDb(EasyUIPage page, DbrwDbrwb rwb) {
		return dbrwDbrwbDao.queryDbList(page, rwb);
	}

	public long listDbTotal(DbrwDbrwb rwb) {
		return dbrwDbrwbDao.queryDbTotal(rwb);
	}

	//begin
	public EasyUIPage listXt(EasyUIPage page, RuleYwxtgzrwlsjlb rwb) {
		return dbrwDbrwbDao.queryXtList(page, rwb);
	}

	public long listXtTotal(RuleYwxtgzrwlsjlb rwb) {
		return dbrwDbrwbDao.queryXtTotal(rwb);
	}
	
	@Override
	public RuleYwxtgzrwlsjlb getXtById(String id) {
		return dbrwDbrwbDao.queryXtById(id);
	}
	
	public EasyUIPage listMsg(EasyUIPage page, SysMessage rwb) {
		return dbrwDbrwbDao.queryMsgList(page, rwb);
	}

	public long listMsgTotal(SysMessage rwb) {
		return dbrwDbrwbDao.queryMsgTotal(rwb);
	}
	
	@Override
	public String backMsg(String id) {
		return dbrwDbrwbDao.backMsg(id);
	}
	
	@Resource(name = "ywxtgzrwbDao")
	private YwxtgzrwbDao ywxtgzrwbDao;
	
	
}
