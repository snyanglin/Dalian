package com.founder.gzjk.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.ComboBox;
import com.founder.gzjk.bean.Dttjb;
import com.founder.gzjk.bean.Gzdt;
import com.founder.gzjk.vo.CountBean;
import com.founder.gzjk.vo.GzjkTemp;
import com.founder.gzjk.vo.GzjkZdry;

/**
 * 宸ヤ綔鐩戞帶涓氬姟鎺ュ彛
 * @author Administrator
 *
 */
@TypeAnnotation("宸ヤ綔鐩戞帶")
public interface GzjkService {
	
	public List<ComboBox> searchOrgList();

	public List<ComboBox> searchOrgListLower(String orgCode);
	
	public List<ComboBox> searchOrgListLowest(String orgCode);

	public List<GzjkZdry> queryZdryRylb(String dwdm, String rylbdm);
	
	public CountBean queryBean(String dwdm, String rylbdm);
	
	public Map<String, Object> gzdxChart(String dwdm);

	public List<GzjkTemp> queryListByLevel(String dwdm,
			Integer level,String ywlx); 
	
	
	
	
	
	/**
	 * 
	 * @Title: querySyrkGzdt
	 * @Description: TODO(实有人口今日统计)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt querySyrkGzdt(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: querySyrkGzdt
	 * @Description: TODO(实有房屋今日统计)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt querySyfwGzdt(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: querySyrkGzdt
	 * @Description: TODO(实有单位今日统计)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt querySydwGzdt(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: querySyrkGzdt
	 * @Description: TODO(标准地址今日统计)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt queryBzdzGzdt(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: querySyrkGzdt
	 * @Description: TODO(重点人员今日统计)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt queryZdryGzdt(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(统计新增修改注销总数)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Gzdt    返回类型
	 * @throws
	 */
	public Gzdt queryCount(Gzdt Gzdt);
	
	/**
	 * 
	 * @Title: queryAllCount
	 * @Description: TODO(统计总数)
	 * @param @param Gzdt
	 * @param @return    设定文件
	 * @return Dttjb    返回类型
	 * @throws
	 */
	public Dttjb queryAllCount(Gzdt Gzdt);
	
	
}
