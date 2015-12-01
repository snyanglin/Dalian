package com.founder.jzym.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.jzym.bean.JqChart;
import com.founder.jzym.bean.Jz_jqxxb;
import com.founder.jzym.vo.Sf_Organization;
import com.founder.xjpt.vo.ZzjgVo;

@Repository("jzDao")
public class JzDao extends BaseDaoImpl {
	
	/**
	 * @Title: queryJq
	 * @描述:查询警情信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryJq(EasyUIPage page, Jz_jqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			//sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("jqxxb", entity);
		
		 String zzjgdm = entity.getGxdwdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 
		//page.setTotal((Integer)queryForObject("Zdryjbxxb.queryCountZdryjbxxNoPt",map));
		//page.setRows(queryForList("Zdryjbxxb.queryZdryjbxxNoPt", map));
		//后期修改增加延时加载
		List<?> list = queryForList("Jz.queryJq", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);		
		return page;
	}
	
	/**
	 * @Title: queryCountJq
	 * @描述:查询警情数量信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值:long 返回类型
	 * @throws
	 */
	public long queryCountJq(Jz_jqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jqxxb", entity);
		
		 String zzjgdm = entity.getGxdwdm();
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000") || zero4.equals("0000")){
			 map.put("flag", "PCS");
		 } 
//		 else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
//			 map.put("flag", "ZRQ");
//		 }
		 
		Integer count = (Integer) queryForObject("Jz.queryCountJq",map);
		return count.longValue();
	}
	
	/**
	 * @Title: jqShiChart
	 * @描述:查询警情柱状图信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:43:03
	 * @返回值: List<JqChart> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<JqChart> jqShiChart(String zzjgdm, String kssj, String jssj, String jqlxdm) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 Jz_jqxxb entity  = new Jz_jqxxb();
		 entity.setGxdwdm(zzjgdm);
		 entity.setFqsj(kssj);
		 entity.setJssj(jssj);
		 entity.setJqlbdm(jqlxdm);
		 map.put("jqxxb", entity);
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		return queryForList("Jz.jqShiChart", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<JqChart> jqShiCharts(String zzjgdm, String kssj, String jssj, String jqlxdm, String zrq) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 Jz_jqxxb entity  = new Jz_jqxxb();
		 entity.setGxdwdm(zzjgdm);
		 entity.setFqsj(kssj);
		 entity.setJssj(jssj);
		 entity.setJqlbdm(jqlxdm);
		 map.put("jqxxb", entity);
		 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
		 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
		 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
		 String zero2 = zzjgdm.substring(zzjgdm.length()-2, zzjgdm.length());
		 if (zero8.equals("00000000")) {
			 map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 if(zrq!=null && ("`").equals(zrq)){
				 map.put("flag", "ZRQ");
			 } else{
				 map.put("flag", "PCS");
			 }
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && !zero4.equals("0000") && zero2.equals("00")){
			 map.put("flag", "ZRQ");
		 }
		return queryForList("Jz.jqShiCharts", map);
	}
	
	/**
	 * @Title: queryXjZzjg
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义
	 * @返回值: List<ZzjgVo> 返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> querySsyj(String zzjgdm) {
		List<ZzjgVo> list = new ArrayList<ZzjgVo>();
		String [] str = zzjgdm.split(",");
		for (int i = 0; i < str.length; i++) {
			ZzjgVo entity = new ZzjgVo();
			entity.setId(str[i]);
			list.add(entity);
		}
		return queryForList("Jz.querySsyj", list);
	}
	
	/**
	 * @Title: queryTree
	 * @描述: 获取分局组织机构
	 * @参数: 传入参数定义
	 * @返回值: List<Sf_Organization> 返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	 public List<Sf_Organization> queryTree(String id, String orgcode, String flag) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("id", id);
		 map.put("orgcode", orgcode);
		 String zero8 = orgcode.substring(orgcode.length()-8, orgcode.length());
		 String zero6 = orgcode.substring(orgcode.length()-6, orgcode.length());
		 String zero4 = orgcode.substring(orgcode.length()-4, orgcode.length());
		 if (zero8.equals("00000000")) {
			map.put("flag", "FJ");
		 } else if(zero6.equals("000000")){
			 map.put("flag", "PCS");
		 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
			 map.put("flag", "ZRQ");
		 }
		 if (null != flag && "line".equals(flag)) {
			 map.put("line", "line");
		 } 
		 return queryForList("Jz.queryTree", map);
 	 }
	 
	 /**
		 * @Title: querySf
		 * @描述: 获取四色预警算法结果
		 * @参数: 传入参数定义
		 * @返回值: List<Sf_Organization> 返回类型 
		 * @throws
	 */
	 @SuppressWarnings("unchecked")
	 public List<Sf_Organization> querySf(Sf_Organization sf) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 String dm = sf.getZzjgdm();
		 String [] str = dm.split(",");
		 StringBuffer temp = new StringBuffer("'");
		 for (int i = 0; i < str.length; i++) {
			temp.append(str[i]).append("','");
		 }
		 temp.replace(temp.lastIndexOf("','"), temp.length(), "'");
		 sf.setZzjgdm(temp.toString());
		 map.put("sf", sf);
		 List<Sf_Organization> sfLi = queryForList("Jz.querySf", map);
		 return sfLi;
 	 }
	 
	    /**
		 * @Title: queryXjZzjgxj
		 * @描述: 获取分局组织机构
		 * @参数: 传入参数定义
		 * @返回值: List<Sf_Organization> 返回类型 
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<Sf_Organization> queryXjZzjgxj(String zzjgdm) {
			List<Sf_Organization> list = new ArrayList<Sf_Organization>();
			String [] str = zzjgdm.split(",");
			for (int i = 0; i < str.length; i++) {
				Sf_Organization entity = new Sf_Organization();
				entity.setId(str[i]);
				list.add(entity);
			}
			return queryForList("Jz.queryXjZzjgxj", list);
		}
		
		 /**
		 * @Title: jqSsyjChart
		 * @描述: 四色预警柱状图
		 * @参数: 传入参数定义
		 * @返回值: List<JqChart>返回类型 
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<JqChart> jqSsyjChart(Sf_Organization sf) {
			 Map<String, Object> map = new HashMap<String, Object>();
			 String zzjgdm = sf.getOrgcode();
			 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
			 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
			 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
			 if (zero8.equals("00000000")) {
				 map.put("flag", "FJ");
			 } else if(zero6.equals("000000")){
				 map.put("flag", "PCS");
			 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
				 map.put("flag", "ZRQ");
			 }
			 map.put("sf", sf);
			 List<JqChart> li = new ArrayList<JqChart>();
			 if(sf.getDown()!=null && "_".equals(sf.getDown())){ //down
				 sf.setChestr("1");//下钻是按日期查询
				 li = queryForList("Jz.jqSsyjCharts", map);
			 } else {
				 li = queryForList("Jz.jqSsyjChart", map);
			 }
			return li;
		}
		
		 /**
		 * @Title: jqShidbChart
		 * @描述: 警情柱状图
		 * @参数: 传入参数定义
		 * @返回值: List<JqChart>返回类型 
		 * @throws
		 */
		@SuppressWarnings("unchecked")
		public List<JqChart> jqShidbChart(String zzjgdm, String kssj, String jssj, String jqlxdm) {
			 Map<String, Object> map = new HashMap<String, Object>();
			 Jz_jqxxb entity  = new Jz_jqxxb();
			 entity.setGxdwdm(zzjgdm);
			 entity.setFqsj(kssj);
			 entity.setJssj(jssj);
			 entity.setJqlbdm(jqlxdm);
			 String zero8 = zzjgdm.substring(zzjgdm.length()-8, zzjgdm.length());
			 String zero6 = zzjgdm.substring(zzjgdm.length()-6, zzjgdm.length());
			 String zero4 = zzjgdm.substring(zzjgdm.length()-4, zzjgdm.length());
			 if (zero8.equals("00000000")) {
				 map.put("flag", "FJ");
			 } else if(zero6.equals("000000")){
				 map.put("flag", "PCS");
			 } else if(!zero8.equals("00000000") && !zero6.equals("000000") && zero4.equals("0000")){
				 map.put("flag", "ZRQ");
			 }
			//entity.setFqsj(kssj.substring(0, 4));
			//entity.setJssj(jssj.substring(0, 4));
		    map.put("jqxxb", entity);
			return queryForList("Jz.jqShidbChart", map);
		}
		
}
