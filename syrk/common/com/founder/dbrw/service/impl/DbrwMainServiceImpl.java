package com.founder.dbrw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDdbrwb;
import com.founder.dbrw.dao.DbrwMainDao;
import com.founder.dbrw.service.DbrwMainService;
import com.founder.dbrw.vo.DbrwMainVo;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;

@Service("dbrwMainService")
@Transactional
public class DbrwMainServiceImpl implements DbrwMainService {

	@Resource(name = "dbrwMainDao")
	private DbrwMainDao dbrwMainDao;

	public EasyUIPage queryDdbrwsjmxb(EasyUIPage page, DbrwDdbrwb entity) {
		return dbrwMainDao.queryDdbrwsjmxb(page, entity);
	}
	
	public int queryDdbrwsjmxbCount(String dbrwfqpcsdm, String dbmxid){
		DbrwDdbrwb entity = new DbrwDdbrwb();
		HashMap map = new HashMap();
		entity.setDbmxid(dbmxid);
		entity.setDbrwfqpcsdm(dbrwfqpcsdm);
		map.put("entity", entity);
		return dbrwMainDao.queryDdbrwsjmxbCount(map);
	}

	public EasyUIPage queryDbrwsjmxb(EasyUIPage page, DbrwDbrwb entity) {
		return dbrwMainDao.queryDbrwsjmxb(page, entity);
	}
	
	public int queryDbrwsjmxbCount(String dbrwfqpcsdm, String dbmxid, String sfwcdm){
		DbrwDbrwb entity = new DbrwDbrwb();
		HashMap map = new HashMap();
		entity.setDbmxid(dbmxid);
		entity.setDbrwfqpcsdm(dbrwfqpcsdm);
		entity.setSfwcdm(sfwcdm);
		map.put("entity", entity);
		return dbrwMainDao.queryDbrwsjmxbCount(map);
	}
	

	/**
	 * 
	 * @Title: querySydwChart
	 * @Description: TODO(实有单位饼状图)
	 * @param @param zzjgdm
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> querySydwChart(HashMap paramMap) {
		String dbrwfqpcsdm = paramMap.get("dbrwfqpcsdm").toString();
		String dbzt = paramMap.get("dbzt").toString();

		// 创建一个Flash统计图Map返回对象
		Map map = new HashMap<String, Object>();

		// 创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);

		Map<String, String> mapan = new HashMap<String, String>();
		mapan.put("type", "fade");
		Map<String, Object> mapantype = new HashMap<String, Object>();
		mapantype.put("type", "bounce");
		mapantype.put("distance", 2);
		Object[] animates = { mapan, mapantype };
		elements.put("animate", animates);

		String[] colours = { "#ee431b", "#fdbe63" };
		elements.put("colours", colours);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");

		String ldxjdqyDbmxid = "32264DA2945A424297C18613666A6077";
		String wrqyDbmxid = "3BC189E54F99495EB87411255C1D8A9A";

		int cyryldxdqyCount = 0;// 从业人员流动性较大的企业
		int wcyryqyCount = 0;// 无从业人员的企业
		HashMap selectMap = new HashMap();
		if (dbzt.equals("wdb")) {// 未督办
			DbrwDdbrwb entity = new DbrwDdbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(ldxjdqyDbmxid);
			selectMap.put("entity", entity);
			cyryldxdqyCount = dbrwMainDao.queryDdbrwsjmxbCount(selectMap);

			selectMap = new HashMap();
			entity = new DbrwDdbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrqyDbmxid);
			selectMap.put("entity", entity);
			wcyryqyCount = dbrwMainDao.queryDdbrwsjmxbCount(selectMap);

		} else if (dbzt.equals("dbz")) {// 督办中
			DbrwDbrwb entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(ldxjdqyDbmxid);
			selectMap.put("entity", entity);
			cyryldxdqyCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrqyDbmxid);
			selectMap.put("entity", entity);
			wcyryqyCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

		} else if (dbzt.equals("ydb")) {// 已督办
			DbrwDbrwb entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(ldxjdqyDbmxid);
			entity.setSfwcdm("1");
			selectMap.put("entity", entity);
			cyryldxdqyCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrqyDbmxid);
			entity.setSfwcdm("1");
			selectMap.put("entity", entity);
			wcyryqyCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);
		}

		// 总数
		int all = cyryldxdqyCount + wcyryqyCount;

		Object[] values = new Object[2];
		Map<String, Object> valMap = new HashMap<String, Object>();
		valMap.put("value", cyryldxdqyCount);
		valMap.put("label", "流动性大(" + cyryldxdqyCount + ")");
		valMap.put("font-size", "12");
		valMap.put("on-click", "showSydwList('人员流动性大企业（"+cyryldxdqyCount+"）', 'ldxjdqy', '"
				+ ldxjdqyDbmxid + "', '" + dbzt + "')");
		values[0] = valMap;

		valMap = new HashMap<String, Object>();
		valMap.put("value", wcyryqyCount);
		valMap.put("label", "无人企业(" + wcyryqyCount + ")");
		valMap.put("font-size", "12");
		valMap.put("on-click", "showSydwList('无人企业（"+wcyryqyCount+"）', 'wrqy', '" + wrqyDbmxid
				+ "', '" + dbzt + "')");
		values[1] = valMap;

		// String titletext = "实有单位分布图(" + all + ")";
		// Map<String, Object> title = new HashMap<String, Object>();
		// title.put("text", titletext);
		// title.put("style", "width: 100%;font-size:18px;color: #000000;");

		// 将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = { elements };
		map.put("elements", elementsObject);
		// map.put("title", title);
		map.put("bg_colour", "#FFFFFF");// 背景色

		return map;
	}

	/**
	 * 
	 * @Title: querySyfwChart
	 * @Description: TODO(实有房屋饼状图)
	 * @param @param dbrwfqpcsdm
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> querySyfwChart(HashMap paramMap) {
		String dbrwfqpcsdm = paramMap.get("dbrwfqpcsdm").toString();
		String dbzt = paramMap.get("dbzt").toString();

		// 创建一个Flash统计图Map返回对象
		Map map = new HashMap<String, Object>();

		// 创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);

		Map<String, String> mapan = new HashMap<String, String>();
		mapan.put("type", "fade");
		Map<String, Object> mapantype = new HashMap<String, Object>();
		mapantype.put("type", "bounce");
		mapantype.put("distance", 3);
		Object[] animates = { mapan, mapantype };
		elements.put("animate", animates);

		String[] colours = { "#85d021", "#4dc2ed", "#ff7a7b" };
		elements.put("colours", colours);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");

		String wrjz = "15D9845505C14BEF8F3C658986536318";
		String dj = "3F93097553E34BEC9DD7F70767FB5925";
		String qj = "CC51C3AAB08448668A1F0D0A5385DD15";

		int wrjzfwCount = 0;
		int djczfwCount = 0;
		int qjczfwCount = 0;
		if (dbzt.equals("wdb")) {// 未督办
			// 无人居住房屋
			HashMap selectMap = new HashMap();
			DbrwDdbrwb entity = new DbrwDdbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrjz);
			selectMap.put("entity", entity);
			wrjzfwCount = dbrwMainDao.queryDdbrwsjmxbCount(selectMap);

			// 独居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDdbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(dj);
			selectMap.put("entity", entity);
			djczfwCount = dbrwMainDao.queryDdbrwsjmxbCount(selectMap);

			// 群居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDdbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(qj);
			selectMap.put("entity", entity);
			qjczfwCount = dbrwMainDao.queryDdbrwsjmxbCount(selectMap);

		} else if (dbzt.equals("dbz")) {// 督办中
			// 无人居住房屋
			HashMap selectMap = new HashMap();
			DbrwDbrwb entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrjz);
			selectMap.put("entity", entity);
			wrjzfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			// 独居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(dj);
			selectMap.put("entity", entity);
			djczfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			// 群居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(qj);
			selectMap.put("entity", entity);
			qjczfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

		} else if (dbzt.equals("ydb")) {// 已督办
			// 无人居住房屋
			HashMap selectMap = new HashMap();
			DbrwDbrwb entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(wrjz);
			entity.setSfwcdm("1");
			selectMap.put("entity", entity);
			wrjzfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			// 独居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(dj);
			entity.setSfwcdm("1");
			selectMap.put("entity", entity);
			djczfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);

			// 群居出租房屋
			selectMap = new HashMap();
			entity = new DbrwDbrwb();
			entity.setDbrwfqpcsdm(dbrwfqpcsdm);
			entity.setDbmxid(qj);
			entity.setSfwcdm("1");
			selectMap.put("entity", entity);
			qjczfwCount = dbrwMainDao.queryDbrwsjmxbCount(selectMap);
		}

		// 总数
		int all = wrjzfwCount + djczfwCount + qjczfwCount;

		Object[] values = new Object[3];
		Map<String, Object> valMap = new HashMap<String, Object>();
		valMap.put("value", wrjzfwCount);
		valMap.put("label", "空置房屋(" + wrjzfwCount + ")");
		valMap.put("font-size", "12");
		valMap.put("on-click", "showSyfwList('wrjz', '" + wrjz + "', '空置房屋（"+wrjzfwCount+"）', '"
				+ dbzt + "')");
		values[0] = valMap;

		valMap = new HashMap<String, Object>();
		valMap.put("value", djczfwCount);
		valMap.put("label", "独居房屋(" + djczfwCount + ")");
		valMap.put("font-size", "12");
		valMap.put("on-click", "showSyfwList('dj', '" + dj + "', '独居房屋（"+djczfwCount+"）', '"
				+ dbzt + "')");
		values[1] = valMap;

		valMap = new HashMap<String, Object>();
		valMap.put("value", qjczfwCount);
		valMap.put("label", "群居房屋(" + qjczfwCount + ")");
		valMap.put("font-size", "12");
		valMap.put("on-click", "showSyfwList('qj', '" + qj + "', '群居房屋（"+qjczfwCount+"）', '"
				+ dbzt + "')");
		values[2] = valMap;

		// String titletext = "实有房屋分布图(" + all + ")";
		// Map<String, Object> title = new HashMap<String, Object>();
		// title.put("text", titletext);
		// title.put("style", "width: 100%;font-size:18px;color: #000000;");

		// 将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = { elements };
		map.put("elements", elementsObject);
		// map.put("title", title);
		map.put("bg_colour", "#FFFFFF");// 背景色

		return map;
	}

	/**
	 * 
	 * @Title: queryGwryChart
	 * @Description: TODO(高危人员柱状图)
	 * @param @param dbrwfqpcsdm
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> queryGwryChart(HashMap selectMap) {
		// 创建一个Flash统计图Map对象
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String dbzt = selectMap.get("dbzt").toString();

		// 获取数据
		List<DbrwMainVo> list = new ArrayList<DbrwMainVo>();
		if (dbzt.equals("wdb")) {// 未督办
			list = dbrwMainDao.queryGwryList(selectMap);
		} else if (dbzt.equals("dbz")) {// 督办中
			list = dbrwMainDao.queryDbGwryList(selectMap);
		} else if (dbzt.equals("ydb")) {// 已督办
			selectMap.put("sfwcdm", "1");
			list = dbrwMainDao.queryDbGwryList(selectMap);
		}

		// 柱状颜色
		Object[] colors = new Object[list.size()];
		Object[] colorsTemp = { "#85d021", "#4dc2ed", "#ee431b", "#e96a3b",
				"#ee9539", "#fdbe63", "#f1e740", "#ffb543", "#ff7a7b",
				"#008080", "#AA4400", "#0000FF" };
		for (int i = 0; i < colors.length; i++) {
			colors[i] = colorsTemp[i];
		}

		String dbmxid = "DC4A5D794B2D42E9862B5B978D1B21BA";

		// 生命对应值和名称
		int lszs = list.size();
		Object[] values = new Object[lszs];
		String[] labels = new String[lszs];
		Object[] valuestags = new Object[lszs];
		Integer max = 10;
		Integer zs = 0;
		for (int i = 0; i < lszs; i++) {
			DbrwMainVo vo = list.get(i);
			if (i < lszs) {
				String name = "";
				if (StringUtils.isBlank(vo.getName())) {
					name = "未标识类型";
				} else {
					name = vo.getName();
				}

				// 将数字放置到柱子上
				Map<String, Object> valtag = new HashMap<String, Object>();
				valtag.put("colour", colors[i]);
				valtag.put("tip", vo.getValue() + "人");
				valtag.put("top", Integer.parseInt(vo.getValue()));
				valtag.put("on-click", "showGwryList('" + name + "（"+vo.getValue()+"）', '"
						+ dbmxid + "', '', '" + dbzt + "')");
				values[i] = valtag;
				labels[i] = name;
				if (max < Integer.parseInt(vo.getValue())) {
					max = Integer.parseInt(vo.getValue());
				}
				// 将数字放置到柱子上
				Map<String, Object> tag = new HashMap<String, Object>();
				tag.put("y", Integer.parseInt(vo.getValue()));
				tag.put("x", i);
				// 加载到柱子上
				valuestags[i] = tag;
			}
			zs += Integer.parseInt(vo.getValue());
		}
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "bar_filled");
		elements.put("values", values);

		// String titletext = "辖区内重点人口统计图("+zs+")";
		// Map<String, Object> title = new HashMap<String, Object>();
		// title.put("text", titletext);
		// title.put("style", "font-size:18px;color: #000000;");

		// 柱子上显示数字
		Map<String, Object> tags = new HashMap<String, Object>();
		tags.put("type", "tags");
		tags.put("values", valuestags);
		tags.put("font", "Verdana");
		tags.put("font-size", 12);
		tags.put("colour", "#000000");
		tags.put("align-x", "center");
		tags.put("text", "#y# 人");

		// 设置y轴
		Map<String, Object> yaxisMap = new HashMap<String, Object>();
		Integer steps = 0;
		if (max > lszs && lszs != 0) {
			steps = max / lszs;
		} else {
			steps = max;
		}
		yaxisMap.put("max", steps + max);
		yaxisMap.put("steps", steps);
		yaxisMap.put("min", 0);

		// 设置X轴
		Map<String, Object> xaxisMap = new HashMap<String, Object>();
		xaxisMap.put("labels", labels);
		xaxisMap.put("size", 12);
		Map<String, Object> xaxisMap2 = new HashMap<String, Object>();
		xaxisMap2.put("labels", xaxisMap);

		// 生成JSON格式
		Object[] elementsObject = { elements, tags };
		returnMap.put("elements", elementsObject);
		returnMap.put("y_axis", yaxisMap);
		returnMap.put("x_axis", xaxisMap2);
		// returnMap.put("title", title);
		returnMap.put("bg_colour", "#FFFFFF");// 背景色
		return returnMap;
	}

	/**
	 * 
	 * @Title: queryZdryChart
	 * @Description: TODO(重点人员饼状图)
	 * @param @param dbrwfqpcsdm
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> queryZdryChart(HashMap selectMap) {
		Map map = new HashMap<String, Object>();
		String dbzt = selectMap.get("dbzt").toString();

		// 获取数据
		List<DbrwMainVo> list = new ArrayList<DbrwMainVo>();
		if (dbzt.equals("wdb")) {// 未督办
			list = dbrwMainDao.queryZdryList(selectMap);
		} else if (dbzt.equals("dbz")) {// 督办中
			list = dbrwMainDao.queryDbZdryList(selectMap);
		} else if (dbzt.equals("ydb")) {// 已督办
			selectMap.put("sfwcdm", "1");
			list = dbrwMainDao.queryDbZdryList(selectMap);
		}

		// 创建一个Flash统计图Map对象
		Map<String, Object> elements = new HashMap<String, Object>();
		elements.put("type", "pie");
		elements.put("alpha", 1);
		elements.put("start-angle", 35);

		Map<String, String> mapan = new HashMap<String, String>();
		mapan.put("type", "fade");
		Map<String, Object> mapantype = new HashMap<String, Object>();
		mapantype.put("type", "bounce");
		mapantype.put("distance", list.size());
		Object[] animates = { mapan, mapantype };
		elements.put("animate", animates);

		// 颜色
		String[] colours = new String[list.size()];
		String[] coloursTemp = { "#85d021", "#4dc2ed", "#ee431b", "#e96a3b",
				"#ee9539", "#fdbe63", "#f1e740", "#ffb543", "#ff7a7b",
				"#008080", "#AA4400", "#0000FF" };
		for (int i = 0; i < colours.length; i++) {
			colours[i] = coloursTemp[i];
		}
		elements.put("colours", colours);
		elements.put("tip", "#label# <br> #val# / #total#<br> 占总数的 #percent#");

		String dbmxid = "9AD87AE4A63F4B089F52544CC3E4B07E";

		int all = 0;
		Object[] values = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			DbrwMainVo vo = list.get(i);
			String name = "";
			if (StringUtils.isBlank(vo.getName())) {
				name = "未标识类型";
			} else {
				name = vo.getName();
			}
			Map<String, Object> valMap = new HashMap<String, Object>();
			valMap.put("value", Integer.parseInt(vo.getValue()));
			valMap.put("label", name + "(" + vo.getValue() + ")");
			valMap.put("font-size", "12");
			valMap.put("on-click", "showZdryList('" + name + "（"+vo.getValue()+"）', '" + dbmxid
					+ "', '', '" + dbzt + "')");
			values[i] = valMap;
			all += Integer.parseInt(vo.getValue());
		}

		// String titletext = "重点人员分布图(" + all + ")";
		// Map<String, Object> title = new HashMap<String, Object>();
		// title.put("text", titletext);
		// title.put("style", "width: 100%;font-size:18px;color: #000000;");

		// 将数据放入统计图中
		elements.put("values", values);
		Object[] elementsObject = { elements };
		map.put("elements", elementsObject);
		// map.put("title", title);
		map.put("bg_colour", "#FFFFFF");// 背景色

		return map;
	}

	@Override
	public EasyUIPage queryDbrwList(EasyUIPage page, String dbrwfqpcsdm) {
		return dbrwMainDao.queryDbrwList(page, dbrwfqpcsdm);
	}

	@Override
	public List<DbrwDdbrwb> queryDdbrwbList(HashMap map) {
		return dbrwMainDao.queryDdbrwbList(map);
	}

	/**
	 * 
	 * @Title: getSydwMax
	 * @Description: TODO(对“从业人员流动性较大的企业”和“无从业人员的企业”统计数据进行比较，并返回最大的类别)
	 * @param @param dbrwfqpcsdm
	 * @param @return 设定文件
	 * @return DbrwMainVo 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DbrwMainVo getSydwMax(String dbrwfqpcsdm) {
		DbrwMainVo returnVo = new DbrwMainVo();
		HashMap map = new HashMap();
		map.put("sspcsdm", dbrwfqpcsdm);
		map.put("ywzlid",
				"'32264DA2945A424297C18613666A6077', '3BC189E54F99495EB87411255C1D8A9A'");

		String dbzt = dbrwMainDao.queryShowType(map);
		if (dbzt.equals("wdb")) {
			returnVo = dbrwMainDao.getSydwMax(dbrwfqpcsdm);
		} else if (dbzt.equals("dbz")) {
			HashMap dbMap = new HashMap();
			dbMap.put("dbrwfqpcsdm", dbrwfqpcsdm);
			returnVo = dbrwMainDao.getDbSydwMax(dbMap);
		} else if (dbzt.equals("ydb")) {
			HashMap dbMap = new HashMap();
			dbMap.put("dbrwfqpcsdm", dbrwfqpcsdm);
			dbMap.put("sfwcdm", "1");
			returnVo = dbrwMainDao.getDbSydwMax(dbMap);
		}
		returnVo.setDbzt(dbzt);
		return returnVo;
	}

	/**
	 * 
	 * @Title: getSyfwMax
	 * @Description: TODO(对“无人居住房屋”、“独居出租房屋”和“群居出租房屋”统计数据进行比较，并返回最大的类别)
	 * @param @param dbrwfqpcsdm
	 * @param @return 设定文件
	 * @return HashMap 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DbrwMainVo getSyfwMax(String dbrwfqpcsdm) {
		DbrwMainVo returnVo = new DbrwMainVo();
		HashMap map = new HashMap();
		map.put("sspcsdm", dbrwfqpcsdm);
		map.put("ywzlid",
				"'15D9845505C14BEF8F3C658986536318', '3F93097553E34BEC9DD7F70767FB5925', 'CC51C3AAB08448668A1F0D0A5385DD15'");

		String dbzt = dbrwMainDao.queryShowType(map);
		if (dbzt.equals("wdb")) {
			returnVo = dbrwMainDao.getSyfwMax(dbrwfqpcsdm);
		} else if (dbzt.equals("dbz")) {
			HashMap dbMap = new HashMap();
			dbMap.put("dbrwfqpcsdm", dbrwfqpcsdm);
			returnVo = dbrwMainDao.getDbSyfwMax(dbMap);
		} else if (dbzt.equals("ydb")) {
			HashMap dbMap = new HashMap();
			dbMap.put("dbrwfqpcsdm", dbrwfqpcsdm);
			dbMap.put("sfwcdm", "1");
			returnVo = dbrwMainDao.getDbSyfwMax(dbMap);
		}
		returnVo.setDbzt(dbzt);
		return returnVo;
	}

	@SuppressWarnings("unchecked")
	public String getMaxByDbmxid(String dbrwfqpcsdm, String dbmxid){
		DbrwMainVo returnVo = new DbrwMainVo();
		HashMap map = new HashMap();
		map.put("sspcsdm", dbrwfqpcsdm);
		map.put("ywzlid", dbmxid);
		
		return dbrwMainDao.queryShowType(map);
	}

	@Override
	public String queryShowType(Map<String, String> map) {
		return dbrwMainDao.queryShowType(map);
	}
	
	@Override
	public EasyUIPage queryJctjList(EasyUIPage page, String dbrwfqpcsdm) {
		return dbrwMainDao.queryJctjList(page, dbrwfqpcsdm);
	}

}
