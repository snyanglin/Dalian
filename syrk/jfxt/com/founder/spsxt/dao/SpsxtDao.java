package com.founder.spsxt.dao;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.bean.Spsxt;
import com.founder.spsxt.bean.Sxtpath;
import com.founder.spsxt.vo.SpsxtZBVO;
import com.founder.sydw_dl.bean.Dwjbxxb;

@Repository("spsxtDao")
public class SpsxtDao extends BaseDaoImpl {
//public SpsxtZBVO getSpsxtZB(String id){
//	return (SpsxtZBVO) super.queryForObject("Spsxt.getSpsxtZB", id);
//}
	public Map<String, String> getSpsxtZB(String tm) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("tm", tm);
		//List list = queryForList("Spsxt.getSpsxtZBZP", map);//
		List list = queryForList("Spsxt.getSpsxtZB", map);//
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
	public List getSpsxtJsdw(String xt_lrrid){
		Map<String, String> map = new HashMap<String, String>();
		map.put("xt_lrrid", xt_lrrid);
		return super.queryForList("Spsxt.getSpsxtJsdw", map);
	}
	public List getSpjkxtByDw(String dwbm){
		Map<String, String> map = new HashMap<String, String>();
		map.put("dwbm", dwbm);
		return super.queryForList("Spsxt.getSpjkxtByDw", map);
	}
	public List getSzdlqy(String xt_lrrbmid){
		Map<String, String> map = new HashMap<String, String>();
		map.put("xt_lrrbmid", xt_lrrbmid);
		return super.queryForList("Spsxt.getSzdlqy", map);
	}
	
	public List getSzdlqyQS(){
		
		return super.queryForList("Spsxt.getSzdlqyQS");
	}
	public void save(Spsxt entity) {
		insert("Spsxt.save", entity);
	}
	public void update(Spsxt entity) {
		update("Spsxt.update", entity);
	}
	
	public Spsxt queryById(String id){
		return (Spsxt) super.queryForObject("Spsxt.queryById", id);
	}
	
	public Integer queryByTm(String tm){
		return (Integer) super.queryForObject("Spsxt.queryByTm", tm);
	}
	
	public Integer querySpjsdwCount(Map map){
		return (Integer) super.queryForObject("Spsxt.querySpjsdwCount",map);
	}
	public Integer queryPTCount(Map map){
		return (Integer) super.queryForObject("Spsxt.queryPTCount",map);
	}
	public Integer querySpjkxtCount(Map map){
		return (Integer) super.queryForObject("Spsxt.querySpjkxtCount",map);
	}
	public Integer queryNVRCount(Map map){
		return (Integer) super.queryForObject("Spsxt.queryNVRCount",map);
	}
	
	public EasyUIPage queryList(EasyUIPage page, Map map){
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spsxt.querySpsxtCount", map));
		page.setRows(queryForList("Spsxt.queryList", map));
		return page;
	}
	
	
	public EasyUIPage queryListForSxtName(EasyUIPage page, Map map){
		System.out.println("daoCENG dwmc:"+map.get("dwmc"));
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spsxt.querySpsxtCountForSxtName", map));
		page.setRows(queryForList("Spsxt.queryListForSxtName", map));
		return page;
	}
	
	
	
	public EasyUIPage queryListByBmid(EasyUIPage page, Map map){
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spsxt.querySpsxtCountByBmid", map));
		page.setRows(queryForList("Spsxt.querySpsxtListByBmid", map));
		return page;
	}
	
	public int delete(String id) {
		return delete("Spsxt.delete", id);
	}
	
	//根据派出所编码和民警警号查询(为摄像头人工纠偏)
	public List querySpsxtForMap(Map paramMap){
		return super.queryForList("Spsxt.querySpsxtForMap", paramMap);
		
	}	
	
	//根据主键修改摄像头坐标
	public int modifyCoordinateByXh(Map paramMap){
		return super.update("Spsxt.modifyCoordinateByXh", paramMap);
		
	}
	
	//根据摄像头id查找建设单位
	public Spjsdw queryJsdwBySxtId(String id){
		return (Spjsdw) super.queryForObject("Spsxt.queryJsdwBySxtId", id);
	}
	//根据摄像头id查询监控系统
	public Spjkxt queryJkxtBySxtId(String id){
		return (Spjkxt) super.queryForObject("Spsxt.queryJkxtBySxtId", id);
	}
	
	//根据单位编码删除所有摄像头
	public int deleteSxtByDwbm(String dwbm){
		return delete("Spsxt.deleteSxtByDwbm", dwbm);
	}
	//根据监控系统删除所有摄像头
	public int deleteSxtByJkxt(String jkxt){
		return delete("Spsxt.deleteSxtByJkxt", jkxt);
	}	
	//根据ssjgdm查找机构名称
	public String getSsjgdmName(String ssjgdm){
		return (String)super.queryForObject("Spsxt.getSsjgdmName",ssjgdm);
	}
	//根据xt_lrrbmid查找派出所（分局）机构代码
	public Map<String, String> getSsjgdm(String xt_lrrbmid){
		Map<String, String> map = new HashMap<String, String>();
		List list=super.queryForList("Spsxt.getSsjgdm", xt_lrrbmid);
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
	public Map<String, String> getSsjgdmPCS(String xt_lrrbmid){
		Map<String, String> map = new HashMap<String, String>();
		List list=super.queryForList("Spsxt.getSsjgdmPCS", xt_lrrbmid);
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
	//获得orglevel
	public String  getOrgLevel(String xt_lrrbmid){
		return (String)super.queryForObject("Spsxt.getOrgLevel", xt_lrrbmid);
	}
	//查找摄像头所在的责任区
	public List getSxtZrq(String orgCode8){
		return super.queryForList("Spsxt.getSxtZrq", orgCode8);
	}
	
	public Integer checkSameName(Map map){
		return (Integer) super.queryForObject("Spsxt.checkSameName",map);
	}
	public Integer checkSameNameSH(Map map){
		return (Integer) super.queryForObject("Spsxt.checkSameNameSH",map);
	}
	public Integer getRemindInfo(String currentUser){
		return (Integer) super.queryForObject("Spsxt.getRemindInfo",currentUser);
	}	
	//根据平台ID删除关联的摄像头
	public Integer deleteSxtByPtId(String ptId){
		return (Integer) super.delete("Spsxt.deleteSxtByPtId",ptId);
	}
 	//根据视频单位ID删除关联的摄像头
	public Integer deleteSxtBySpdwId(String id){
		return (Integer) super.delete("Spsxt.deleteSxtBySpdwId",id);
	}
	//根据NVR删除关联的摄像头
	public Integer deleteSxtByNvrId(String id){
		return (Integer) super.delete("Spsxt.deleteSxtByNvrId",id);
	}
	//根据监控系统Xh(主键)删除所有摄像头
	public int deleteSxtByJkxtXh(String jkxt){
		return delete("Spsxt.deleteSxtByJkxtXh", jkxt);
	}

	//根据管理单位代码取摄像头编号的最大值
	public String  getSxtBHByGldw(String gldw){
		return (String)super.queryForObject("Spsxt.getSxtBHByGldw", gldw);
	}
	//根据责任区代码取摄像头编号的最大值
	public String  getSxtBHBySRQ(String sszrq){
		return (String)super.queryForObject("Spsxt.getSxtBHBySRQ", sszrq);
	}
	//摄像头纠偏分页查询2014.12.20
	public EasyUIPage querySpsxtForMap2(EasyUIPage page, Map map){
		
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Spsxt.querySpsxtCountForMap2", map));
		page.setRows(queryForList("Spsxt.querySpsxtForMap2", map));
		return page;
	}	

	//根据分局代码获得摄像头编号当前的最大值
	public String  getSxtBhInFj(String fjCode6){
		return (String)super.queryForObject("Spsxt.getSxtBhInFj", fjCode6);
	}	
	//在派出所范围内查找摄像头编号当前的最大值
	public String  getSxtBhInPcs(String pcsCode6){
		return (String)super.queryForObject("Spsxt.getSxtBhInPcs", pcsCode6);
	}	
	// 在责任区范围内查找摄像头编号的最大值 
	public String  getSxtBhInZrq(String zrqCode8){
		return (String)super.queryForObject("Spsxt.getSxtBhInZrq", zrqCode8);
	}

	// 在支队范围内查找摄像头编号的最大值 
	public String  getSxtBhInZd(String zdCode6){
		return (String)super.queryForObject("Spsxt.getSxtBhInZd", zdCode6);
	}
	public Integer checkXTIDBM(Map map){
		return (Integer) super.queryForObject("Spsxt.checkXTIDBM",map);
	}
	
	//2015.03.30--PDA端采集的照片
	
	public Sxtpath getPDASxtPic(String sxtid){
		return (Sxtpath)super.queryForObject("Spsxt.getPDASxtPic",sxtid);
	}
}
