package com.founder.gzjk.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.ComboBox;
import com.founder.gzjk.bean.Dttjb;
import com.founder.gzjk.bean.Gzdt;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.Gzjk;
import com.founder.gzjk.vo.GzjkBzdz;
import com.founder.gzjk.vo.GzjkSydw;
import com.founder.gzjk.vo.GzjkSyfw;
import com.founder.gzjk.vo.GzjkTemp;
import com.founder.gzjk.vo.GzjkZdry;

@Repository("gzjkDao")
public class GzjkDao extends BaseDaoImpl {

	// 鐎圭偞婀佹禍鍝勫經 - 閺屻儴顕楅崣妯哄З閺佺増宓�
	public List<Gzjk> queryInitGzjk(Map<String, String> map) {
		return super.queryForList("Gzjk.queryInitGzjk", map);
	}

	// 鐎圭偞婀佹禍鍝勫經 - 鐎圭偞妞傞弻銉嚄閸欐ê濮╅弫鐗堝祦
	public List<Gzjk> queryDynamicGzjk(Map<String, String> map) {
		return super.queryForList("Gzjk.queryDynamicGzjk", map);
	}

	// 鐎圭偞婀佹禍鍝勫經 - 缂佺喕顓搁幀缁樻殶閹癸拷 鐢倸鐪�
	public int queryInitCountSj(String ssbmdm) {
		return (Integer) super.queryForObject("Gzjk.queryInitCountSj", ssbmdm);
	}

	// 鐎圭偞婀佹禍鍝勫經 - 缂佺喕顓搁幀缁樻殶閹癸拷 閸掑棗骞欑仦锟�
	public int queryInitCountFxj(String bmdm) {
		return (Integer) super.queryForObject("Gzjk.queryInitCountFxj", bmdm);
	}

	// 鐎圭偞婀佹禍鍝勫經 - 缂佺喕顓搁幀缁樻殶閹癸拷 濞叉儳鍤幍锟�
	public int queryInitCountPcs(String bmdm) {
		return (Integer) super.queryForObject("Gzjk.queryInitCountPcs", bmdm);
	}

	// 閺嶅洤鍣崷鏉挎絻 - 閺屻儴顕楅崣妯哄З閺佺増宓�
	public List<GzjkBzdz> queryBzdzInitGzjk(Map<String, String> map) {
		return super.queryForList("Gzjk.queryBzdzInitGzjk", map);
	}

	// 閺嶅洤鍣崷鏉挎絻 - 鐎圭偞妞傞弻銉嚄閸欐ê濮╅弫鐗堝祦
	public List<GzjkBzdz> queryBzdzDynamicGzjk(Map<String, String> map) {
		return super.queryForList("Gzjk.queryBzdzDynamicGzjk", map);
	}

	// 閺嶅洤鍣崷鏉挎絻 - 缂佺喕顓搁幀缁樻殶閹癸拷 鐢倸鐪�
	public int queryInitBzdzCountSj(String bmdm) {
		return (Integer) super
				.queryForObject("Gzjk.queryInitBzdzCountSj", bmdm);
	}

	// 閺嶅洤鍣崷鏉挎絻 - 缂佺喕顓搁幀缁樻殶閹癸拷 閸掑棗骞欑仦锟�
	public int queryInitBzdzCountFxj(String bmdm) {
		return (Integer) super.queryForObject("Gzjk.queryInitBzdzCountFxj",
				bmdm);
	}

	// 閺嶅洤鍣崷鏉挎絻 - 缂佺喕顓搁幀缁樻殶閹癸拷 濞叉儳鍤幍锟�
	public int queryInitBzdzCountPcs(String bmdm) {
		return (Integer) super.queryForObject("Gzjk.queryInitBzdzCountPcs",
				bmdm);
	}

	// 閺屻儴顕楁稉锟介獓闁劑妫�
	public List<ComboBox> searchOrgList() {
		return super.queryForList("Gzjk.searchOrgList");
	}

	// 閺屻儴顕楁禍宀�獓闁劑妫�
	public List<ComboBox> searchOrgListLower(String orgCode) {
		return super.queryForList("Gzjk.searchOrgListLower", orgCode);
	}

	// cdx add at 2014-09-112
	public List<ComboBox> searchOrgListLowest(String orgCode) {
		return super.queryForList("Gzjk.searchOrgListLowest", orgCode);
	}

	/********* 閺傦拷 **************************************************/

	public GzjkTemp queryGzjkByRyid(String ryid,String orgcode,String level) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ryid", ryid);
		map.put("orgcode", orgcode);
		map.put("level", level);
		
		return (GzjkTemp) queryForObject("Gzjk.queryGzjkByRyid", map);
	}
	
	public GzjkTemp queryGzjkByBzdzid(String dzid) {
		return (GzjkTemp) queryForObject("Gzjk.queryGzjkByBzdzId", dzid);
	}

	/**
	 * 实有人口
	 * 
	 * @return
	 */
	public Map<String, CountBean> queryOrgAll() {
		List<String> list = queryForList("Gzjk.queryOrgAll");
		Map<String,CountBean> map = new HashMap<String,CountBean>();
		
		List<CountBean> listCount = queryForList("Gzjk.selectCountBeanSyrk");
		for (int i = 0; i < list.size(); i++) {
			String orgcode = list.get(i);
			String linshiValue ="0";
			for(int a = 0;a<listCount.size();a++){
				if(orgcode.equals(listCount.get(a).getOrgcode())){
					map.put(orgcode,listCount.get(a));
					linshiValue = "1";
				}
			}
			if("0".equals(linshiValue)){
				map.put(orgcode,new CountBean());
			}
		}
		return map;
	}

	/**
	 * 标准地址
	 * 
	 * @return
	 */
	public Map<String, CountBean> queryBzdzOrgAll() {
		List<String> list = queryForList("Gzjk.queryBzdzCountList");
		Map<String,CountBean> map = new HashMap<String,CountBean>();
		List<CountBean> listCount = queryForList("Gzjk.selectCountBeanBzdz1");
		for (int i = 0; i < list.size(); i++) {
			String orgcode = list.get(i);
			String linshiValue ="0";
			for(int a = 0;a<listCount.size();a++){
				if(orgcode.equals(listCount.get(a).getOrgcode())){
					map.put(orgcode,listCount.get(a));
					linshiValue = "1";
				}
			}
			if("0".equals(linshiValue)){
				map.put(orgcode,new CountBean());
			}
		}
		return map;
	}
	
	
	
	/**
	 * 重点人员
	 * 
	 * @return
	 */
	public Map<String, CountBean> queryZdryOrgAll() {
		List<String> list = queryForList("Gzjk.queryZdryCountList");
		Map<String,CountBean> map = new HashMap<String,CountBean>();
		List<CountBean> listCount = queryForList("Gzjk.selectCountBeanZdry1");
		for (int i = 0; i < list.size(); i++) {
			String orgcode = list.get(i);
			String linshiValue ="0";
			for(int a = 0;a<listCount.size();a++){
				if(orgcode.equals(listCount.get(a).getOrgcode())){
					map.put(orgcode,listCount.get(a));
					linshiValue = "1";
				}
			}
			if("0".equals(linshiValue)){
				map.put(orgcode,new CountBean());
			}
		}
		return map;
	}
	
	
	/**
	 * 实有单位
	 * @return
	 */
	public Map<String, CountBean> querySydwOrgAll() {
		List<String> list = queryForList("Gzjk.querySydwCountList");
		Map<String,CountBean> map = new HashMap<String,CountBean>();
		List<CountBean> listCount = queryForList("Gzjk.selectCountBeanSydw");
		for (int i = 0; i < list.size(); i++) {
			String orgcode = list.get(i);
			String linshiValue ="0";
			for(int a = 0;a<listCount.size();a++){
				if(orgcode.equals(listCount.get(a).getOrgcode())){
					map.put(orgcode,listCount.get(a));
					linshiValue = "1";
				}
			}
			if("0".equals(linshiValue)){
				map.put(orgcode,new CountBean());
			}
		}
		
		
		return map;
	}
    /**
     * 实有房屋
     * @return
     */
	public Map<String, CountBean> querySyfwOrgAll() {
		List<String> list = queryForList("Gzjk.querySyfwCountList");
		Map<String,CountBean> map = new HashMap<String,CountBean>();
		List<CountBean> listCount = queryForList("Gzjk.selectCountBeanSyfw");
		for (int i = 0; i < list.size(); i++) {
			String orgcode = list.get(i);
			String linshiValue ="0";
			for(int a = 0;a<listCount.size();a++){
				if(orgcode.equals(listCount.get(a).getOrgcode())){
					map.put(orgcode,listCount.get(a));
					linshiValue = "1";
				}
			}
			if("0".equals(linshiValue)){
				map.put(orgcode,new CountBean());
			}
		}
		return map;
	}

	public List<Gzjk> queryTop20(String key) {
		return queryForList("Gzjk.queryTop20", key);
	}

	public List<GzjkBzdz> queryTop20Bzdz(String key) {
		return queryForList("Gzjk.queryTop20Bzdz", key);
	}



	/**
	 * 闁插秶鍋ｆ禍鍝勬喅閸擄拷0閺夛拷
	 * 
	 * @param key
	 * @return
	 */
	public List<GzjkZdry> queryTop20Zdry(String key) {
		return queryForList("Gzjk.queryTop20Zdry", key);
	}

	public GzjkTemp queryGzjkZdryByRyid(String ryid,String orgcode,String level) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ryid", ryid);
		map.put("orgcode", orgcode);
		map.put("level", level);
		return (GzjkTemp) queryForObject("Gzjk.queryGzjkByZdryid", map);
	}

	public List<GzjkSydw> queryTop20Sydw(String key) {
		return queryForList("Gzjk.queryTop20Dw", key);
	}

	

	public GzjkTemp queryGzjkSydwById(String id) {
		return (GzjkTemp) queryForObject("Gzjk.queryGzjkSydwById", id);
	}

	public List<GzjkSyfw> queryTop20Syfw(String key) {
		return queryForList("Gzjk.queryTop20Fw", key);
	}

	public GzjkTemp queryGzjkSyfwById(String id) {
		return (GzjkTemp) queryForObject("Gzjk.queryGzjkSyfwById", id);
	}

	public List<GzjkZdry> queryZdryRylb(String dwdm, String rylbdm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dwdm", dwdm);
		map.put("rylbdm", rylbdm);
		return queryForList("Gzjk.queryZdryRylb", map);
	}

	public GzjkZdry queryGzjkZdryLg(String ryid) {
		return (GzjkZdry) queryForObject("Gzjk.queryGzjkZdryLg", ryid);
	}

	public GzjkZdry queryGzjkZdryGK(String ryid) {
		return (GzjkZdry) queryForObject("Gzjk.queryGzjkZdryGK", ryid);
	}

	public GzjkZdry queryGzjkZdrycg(String ryid) {
		return (GzjkZdry) queryForObject("Gzjk.queryGzjkZdrycg", ryid);
	}

	public CountBean count(GzjkZdry co) {
		return (CountBean) queryForObject("Gzjk.selectCountBeanZdryLbzs", co);
	}

	public Map<String,String> queryZzjgMapForGzjk() {
		return queryForMap("Gzjk.queryListForPublicSelect", "", "key", "value");
	}

	public void insertLSB(GzjkTemp dzjkTemp){
		insert("Gzjk.insertLSB", dzjkTemp);
	}

	public void insertTop20(String key) {
		insert("Gzjk.insertTop20", key);
	}

	public void deleteGztslsb(){
		delete("Gzjk.deleteGztslsb", null);
	}
    /**
     * 查询选择单位的下级统计数据
     * @param dwdm
     * @param level
     * @return
     */
	public List<GzjkTemp> queryListByLevel(String dwdm, Integer level,String ywlx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dwdm", dwdm);
		map.put("level", level);
		map.put("ywlx", ywlx);
		map.put("begin", 0);
		map.put("end", 20);
		map.put("sort", "xt_lrsj");
		map.put("order", "desc");
		return queryForList("Gzjk.queryListByLevel", map);
	}

	public void insertSyfwTop20(String key) {
		insert("Gzjk.insertSyfwTop20", key);
	}

	public void insertSydwTop20(String key) {
		insert("Gzjk.insertSydwTop20", key);
	}

	public void insertZdryTop20(String key) {
		insert("Gzjk.insertZdryTop20", key);
	}

	public void insertBzdzTop20(String key) {
		insert("Gzjk.insertBzdzTop20", key);
	}

	
	
	
	/**
	 * 调用存储过程
	 */
	public void insertAllTop20() {
		queryForObject("Gzjk.progzts", null);
	}
	
	
	
	
	//重构
		/**
		 * 
		 * @Title: querySyrkGzdt
		 * @Description: TODO(实有人口今日统计)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Gzdt querySyrkGzdt(Gzdt Gzdt) {
			return (Gzdt) queryForObject("Gzjk.querySyrkCount", Gzdt);
		}
		
		/**
		 * 
		 * @Title: querySyrkGzdt
		 * @Description: TODO(实有房屋今日统计)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Gzdt querySyfwGzdt(Gzdt Gzdt) {
			return (Gzdt) queryForObject("Gzjk.querySyfwCount", Gzdt);
		}
		
		/**
		 * 
		 * @Title: querySyrkGzdt
		 * @Description: TODO(实有单位今日统计)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Gzdt querySydwGzdt(Gzdt Gzdt) {
			return (Gzdt) queryForObject("Gzjk.querySydwCount", Gzdt);
		}
		
		/**
		 * 
		 * @Title: querySyrkGzdt
		 * @Description: TODO(标准地址今日统计)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Gzdt queryBzdzGzdt(Gzdt Gzdt) {
			return (Gzdt) queryForObject("Gzjk.queryBzdzCount", Gzdt);
		}
		
		/**
		 * 
		 * @Title: querySyrkGzdt
		 * @Description: TODO(重点人员今日统计)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Gzdt queryZdryGzdt(Gzdt Gzdt) {
			return (Gzdt) queryForObject("Gzjk.queryZdryCount", Gzdt);
		}
		
		/**
		 * 
		 * @Title: queryAllCount
		 * @Description: TODO(统计所有)
		 * @param @param Gzdt
		 * @param @return    设定文件
		 * @return Gzdt    返回类型
		 * @throws
		 */
		public Dttjb queryAllCount(Gzdt Gzdt) {
			Dttjb a = (Dttjb)queryForObject("Gzjk.queryAllCount", Gzdt.getDwdm());
			return a;
		}
		
	
}
