package com.founder.spsxt.service;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.spsxt.bean.Spjkxt;
import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.bean.Spsxt;
import com.founder.spsxt.bean.Sxtpath;
import com.founder.spsxt.vo.SpsxtZBVO;

@TypeAnnotation("摄像头管理")
public interface SptglService {
	@MethodAnnotation(value = "查询坐标")
	//public SpsxtZBVO getSpsxtZB(String tm);
	public Map<String, String> getSpsxtZB(String tm);

	@MethodAnnotation(value = "查询建设单位")
	public List getSpsxtJsdw(String xt_lrrid);
	@MethodAnnotation(value = "查询监控系统")
	public List getSpjkxtByDw(String dwbm);
	@MethodAnnotation(value = "查询所在区域")
	public List getSzdlqy(String xt_lrrbmid);
	public List getSzdlqyQS();
	
	@MethodAnnotation(value = "新增摄像头", type = logType.insert)
	public void save(Spsxt entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "更新摄像头")
	public void update(Spsxt entity, SessionBean sessionBean);
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryListForSxtName(EasyUIPage page,Map map);
	
	@MethodAnnotation(value = "查询摄像头视图")
	public EasyUIPage queryListByBmid(EasyUIPage page,Map map);
	
	@MethodAnnotation(value = "通过id查询")
	public Spsxt queryById(String id);
	
	@MethodAnnotation(value = "通过tm查询")
	public Integer queryByTm(String tm);
	
	
	@MethodAnnotation(value = "删除摄像头")
	public int delete(String id);
	
	public List querySpsxtForMap(String pcsbm,String policeId,String add);
	
	//根据主键修改摄像头坐标
	public int modifyCoordinateById(String jd,String wd,String id);
	
	//根据摄像头id查找建设单位
	public Spjsdw queryJsdwBySxtId(String id);
	//根据摄像头id查找监控系统
    public Spjkxt queryJkxtBySxtId(String id);
    
	public Integer queryJsdwCount(Map map);
	public Integer queryPTCount(Map map);

	public Integer querySpjkxtCount(Map map);
	public Integer queryNVRCount(Map map);
	
	public String getOrgLevel(String xt_lrrbmid);
	//根据ssjgdm查找机构名称
	public String getSsjgdmName(String ssjgdm);
	//根据xt_lrrbmid查找派出所（分局）机构代码
	public Map<String, String> getSsjgdm(String xt_lrrbmid);
		
	//根据用户orgCode前8位获得其所在派出所的所有责任区
	public List getSxtZrq(String orgCode8);

	public Integer checkSameName(Map map);
	public Integer checkSameNameSH(Map map);
	//监控系统lwsx属性与视频摄像头sfrw属性不一致时提醒用户
	public Integer getRemindInfo(String currentUser);
	
	//摄像头纠偏分页查询2014.12.20
	public EasyUIPage querySpsxtForMap2(EasyUIPage page, Map map);	

	public Integer checkXTIDBM(Map map);

	//2015.03.30--PDA端采集的照片
	public Sxtpath getPDASxtPic(String sxtid);
	
}
