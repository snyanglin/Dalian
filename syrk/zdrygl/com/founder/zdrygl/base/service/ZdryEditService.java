package com.founder.zdrygl.base.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.dao.ZpfjFjxxbDao;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.base.dao.ZdryDtjsXsDao;
import com.founder.zdrygl.base.dao.ZdryEditDao;
import com.founder.zdrygl.base.dao.ZdryFzcsfryxxbDao;
import com.founder.zdrygl.base.dao.ZdryJgdxqxjdjbDao;
import com.founder.zdrygl.base.dao.ZdryJgdxxxbDao;
import com.founder.zdrygl.base.dao.ZdryJkbjllxxbDao;
import com.founder.zdrygl.base.dao.ZdryNrsxdxxxbDao;
import com.founder.zdrygl.base.dao.ZdryPsjdbDao;
import com.founder.zdrygl.base.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdrySqjzryxxbDao;
import com.founder.zdrygl.base.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdryWffzjlxxbDao;
import com.founder.zdrygl.base.dao.ZdryZagltdxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdrykcxxbDao;
import com.founder.zdrygl.base.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;
import com.founder.zdrygl.base.model.ZdryFzcsfryxxb;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.model.ZdryJgdxxxb;
import com.founder.zdrygl.base.model.ZdryJkbjllxxb;
import com.founder.zdrygl.base.model.ZdryNrsxdxxxb;
import com.founder.zdrygl.base.model.ZdryPsjdb;
import com.founder.zdrygl.base.model.ZdrySgafzdryxxb;
import com.founder.zdrygl.base.model.ZdrySqjzryxxb;
import com.founder.zdrygl.base.model.ZdrySqsbzdryxxb;
import com.founder.zdrygl.base.model.ZdryWffzjlxxb;
import com.founder.zdrygl.base.model.ZdryZagltdxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
import com.founder.zdrygl.base.model.ZdryZdrykcxxb;
import com.founder.zdrygl.base.model.ZdryZszhjsbrxxb;
import com.founder.zdrygl.base.vo.ZdrygnVO;
import com.founder.zdrygl.base.vo.ZdryxxzsVO;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.ZdryEditServiceImpl.java]  
 * @ClassName:    [ZdryEditServiceImpl]   
 * @Description:  [重点人员编辑服务]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午6:20:34]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午6:20:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryEditService")
@Transactional
public class ZdryEditService extends BaseService {
	
	@Resource(name="zdryEditDao")
	private ZdryEditDao zdryEditDao;	

	@Resource(name="zdryZdrkxxbDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;

	@Resource(name = "zpfjFjxxbDao")
	ZpfjFjxxbDao zpfjFjxxbDao;

	@Autowired
	private ZdryConstant zdryConstant;
	
	@Resource(name="zdrySqjzryxxbDao")
	private ZdrySqjzryxxbDao zdrySqjzryxxbDao;	
	@Resource
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;	
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource(name="zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;
	@Resource(name="zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	@Resource(name="zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;
	@Resource(name = "zdryJkbjllxxbDao")
	private ZdryJkbjllxxbDao zdryJkbjllxxbDao;
	@Resource(name = "zdryJgdxqxjdjbDao")
	private ZdryJgdxqxjdjbDao zdryJgdxqxjdjbDao;
	@Resource(name = "zdryPsjdbDao")
	private ZdryPsjdbDao zdryPsjdbDao;
	@Resource(name = "zdryNrsxdxxxbDao")
	private ZdryNrsxdxxxbDao zdryNrsxdxxxbDao;
	@Resource(name = "zdryJgdxxxbDao")
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	@Resource(name = "zdryZagltdxxbDao")
	private ZdryZagltdxxbDao zdryZagltdxxbDao;
	@Resource(name = "zdryWffzjlxxbDao")
	private ZdryWffzjlxxbDao zdryWffzjlxxbDao;
	@Resource(name = "zdryZdrykcxxbDao")
	private ZdryZdrykcxxbDao zdryZdrykcxxbDao;
	@Resource
	private ZdryDtjsXsDao zdryDtjsXsDao;
	@Resource
	private ZdryInfoQueryService zdryInfoQueryService;
	
	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	/**
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(业务办理菜单查询)
	 * @param @param gnlxdm
	 * @param @return    设定文件
	 * @return List<ZdrygnVO>    返回类型
	 * @throw
	 */
	public List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return zdryEditDao.queryYwglgn(gnlxdm);
	}

	/**
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(人员展示信息菜单查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryxxzsVO>    返回类型
	 * @throw
	 */
	public List<ZdryxxzsVO> queryRyzsxx(Map<String, Object> map) {
		List<Map<String,String>> list = new Gson().fromJson((String)map.get("zdrylxJson"), new TypeToken<List<Map<String,String>>>() {}.getType());
		map.remove("zdrylxJson");
		List<ZdryxxzsVO> infoList = new ArrayList<ZdryxxzsVO>();
		List<ZdryxxzsVO> temp = null;
		//循环查询重点人口信息，不去重复
		for (Map<String,String> zdrkMap : list) {
			map.remove("dlbh");
			map.put("zdryid",zdrkMap.get("zdryid"));
			map.put("isEdit",zdrkMap.get("isEdit"));
			map.put("zdrylx",zdrkMap.get("zdrylx"));//由于各个区域的重点人员类型代码不一样，所以用区域代码+重点人员管理类型代码 来区分
			map.put("gxzrq",zdrkMap.get("GXZRQ"));			
			map.put("xxdxlxdm","1");
			
			temp = zdryEditDao.queryRyzsxx(map);
			if(temp != null && !temp.isEmpty()){
				map.put("xxdxlxdm","2");
				for (int i = 0; i < temp.size(); i++) {
					temp.get(i).setZdrylxdm(zdrkMap.get("zdrylx"));
					map.put("dlbh",temp.get(i).getXxbh().substring(0, 2));
					temp.get(i).setList( zdryEditDao.queryRyzsxx(map));
				}
				infoList.addAll(temp);
			}
		}
		
		//查询重点人员公共菜单
		map.remove("dlbh");
		//map.put("zdryid",zdrkMap.get("zdryid"));
		map.put("isEdit","1");
		map.put("zdrylx","ZDRYPUBLIC");//由于各个区域的重点人员类型代码不一样，所以改用分组来区分用什么界面显示
		map.remove("gxzrq");			
		map.put("xxdxlxdm","1");
		
		temp = zdryEditDao.queryRyzsxx(map);
		if(temp != null && !temp.isEmpty()){
			map.put("xxdxlxdm","2");
			for (int i = 0; i < temp.size(); i++) {				
				map.put("dlbh",temp.get(i).getXxbh().substring(0, 2));
				temp.get(i).setList( zdryEditDao.queryRyzsxx(map));
			}
			infoList.addAll(temp);
		}
		
		//实现排序接口
		Comparator<Object> c = new Comparator<Object>(){
			public int compare( Object a, Object b ){
				 int one =((ZdryxxzsVO)a).getPx();
				 int two =((ZdryxxzsVO)b).getPx();
				return one-two;
			}
		};
		

		Collections.sort(infoList,c);				
		return infoList;
	}

	
	public void delete_xxzsnrb(Map<String, Object> map) {
		zdryEditDao.delete_xxzsnrb(map);
	}	
	
	/**
	 * 
	 * @Title: fjxx_query
	 * @Description: TODO(附件列表查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZpfjFjxxb>    返回类型
	 * @throw
	 */
	public List<ZpfjFjxxb> fjxx_query(Map<String, Object> map) {
		return zpfjFjxxbDao.queryListByLybmAndId("ZDRY_ZDRYZB",(String)map.get("zdryid"));
	}

	/**
	 * 
	 * @Title: zdrkxxb_query
	 * @Description: TODO(重点人口信息 查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryZdrkxxb    返回类型
	 * @throw
	 */
	public ZdryZdrkxxb zdrkxxb_query(Map<String, Object> map) {	
		ZdryZdrkxxb entity=(ZdryZdrkxxb) zdryZdrkxxbDao.queryViewByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}
	
	/**
	 * 
	 * @Title: sqjz_query
	 * @Description: TODO(社区矫正人员信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdrySqjzryxxb    返回类型
	 * @throw
	 */
	public ZdrySqjzryxxb sqjz_query(Map<String, Object> map) {
		ZdrySqjzryxxb entity = (ZdrySqjzryxxb) zdrySqjzryxxbDao.queryViewByMap(map);	
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return 	entity;
	}
	
	/**
	 * 
	 * @Title: sgafzdryxxb_query
	 * @Description: TODO(涉公安访信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdrySgafzdryxxb    返回类型
	 * @throw
	 */
	public ZdrySgafzdryxxb sgafzdryxxb_query(Map<String, Object> map) {
		ZdrySgafzdryxxb entity = (ZdrySgafzdryxxb) zdrySgafzdryxxbDao.queryViewByMap(map);
		return entity;
	}

	/**
	 * 
	 * @Title: zszhjsbrxxb_query
	 * @Description: TODO(肇事肇祸精神病人信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryZszhjsbrxxb    返回类型
	 * @throw
	 */
	public ZdryZszhjsbrxxb zszhjsbrxxb_query(Map<String, Object> map) {		
		ZdryZszhjsbrxxb entity = (ZdryZszhjsbrxxb)zdryZszhjsbrxxbDao.queryViewByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}
				
	/**
	 * 
	 * @Title: fzcfryxxb_query
	 * @Description: TODO(非正常上访人员信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryFzcsfryxxb    返回类型
	 * @throw
	 */
	public ZdryFzcsfryxxb fzcfryxxb_query (Map<String,Object> map){		
		ZdryFzcsfryxxb entity =  (ZdryFzcsfryxxb)zdryFzcsfryxxbDao.queryViewByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}
	
	/**
	 * 
	 * @Title: sqsbzdry_query
	 * @Description: TODO(涉枪涉暴信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdrySqsbzdryxxb    返回类型
	 * @throw
	 */
	public ZdrySqsbzdryxxb sqsbzdry_query (Map<String,Object> map){
		return (ZdrySqsbzdryxxb)zdrySqsbzdryxxbDao.queryViewByMap(map);
	}
	
	
	public ZdryJgdxxxb jgdxxxb_query(Map<String, Object> map) {
		ZdryJgdxxxb entity = (ZdryJgdxxxb)zdryJgdxxxbDao.queryViewByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}
	
	
	/**
	 * 
	 * @Title: jkbjryxxb_query
	 * @Description: TODO(帮教力量查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List<ZdryJkbjllxxb> jkbjryxxb_query (Map<String,Object> map){
		map.put("maxNum", "10");
		return zdryJkbjllxxbDao.queryViewList(map);
	}

	/**
	 * 
	 * @Title: qxjdjb_query
	 * @Description: TODO(请销假登记查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List<ZdryJgdxqxjdjb>  qxjdjb_query(Map<String, Object> map){
		map.put("maxNum", "10");
		return zdryJgdxqxjdjbDao.queryViewList(map);
	}
	
	/**
	 * 
	 * @Title: psjdb_query
	 * @Description: TODO(评审鉴定查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List<ZdryPsjdb> psjdb_query(Map<String, Object> map){
		map.put("maxNum", "10");
		return zdryPsjdbDao.queryViewList(map);
	}
	
	/**
	 * 
	 * @Title: nrsxdxxxb_query
	 * @Description: TODO(纳入实现对象查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryNrsxdxxxb    返回类型
	 * @throw
	 */
	public ZdryNrsxdxxxb nrsxdxxxb_query(Map<String, Object> map){
		ZdryNrsxdxxxb entity = (ZdryNrsxdxxxb)zdryNrsxdxxxbDao.queryViewByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}

	/**
	 * 
	 * @Title: zagltdb_query
	 * @Description: TODO(作案规律特点 查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryZagltdxxb>    返回类型
	 * @throw
	 */
	public List<ZdryZagltdxxb> zagltdb_query(Map<String, Object> map) {
		return zdryZagltdxxbDao.queryViewList(map);
	}

	/**
	 * 
	 * @Title: wffzjlb_query
	 * @Description: TODO(违法犯罪记录信息查询)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryWffzjlxxb>    返回类型
	 * @throw
	 */
	public List<ZdryWffzjlxxb> wffzjlb_query(Map<String, Object> map) {
		return zdryWffzjlxxbDao.queryViewList(map);
	}

	/**
	 * 
	 * @Title: zdrykcb_query
	 * @Description: TODO(重点人员考察)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryZdrykcxxb>    返回类型
	 * @throw
	 */
	public List<ZdryZdrykcxxb> zdrykcb_query(Map<String, Object> map) {
		return zdryZdrykcxxbDao.queryViewList(map);
	}

	/*
	
	public ZdryShbzdryxxb shbzdry_query (Map<String,Object> map){
		return zdryShbzdryxxbDao.queryZsxxById((String) map.get("zdryid"));
	}

	
	public List<ZdryXdryxxb> zdryXdryxxb_query(Map<String, Object> map) {
		List<ZdryXdryxxb> list=zdryXdryxxbDao.queryList((String) map.get("zdryid"));

		return list;
	}

	
	public List<ZdryXdrynjxxb> zdryXdrynjxx_query(Map<String, Object> map) {
		
		return (List<ZdryXdrynjxxb>)zdryXdrynjxxbDao.queryList((String) map.get("zdryid"));
	}

				*/
	/**
	 * 动态纪实写实基本信息
	 * @param map
	 * @return
	 */
	/**
	 * 动态纪实写实基本信息
	 * @param map
	 * @return
	 */
	public List<ZdryDtjsXsxxb> dtjsxsjbxx_query(Map<String,Object> map){
		  String id = map.get("zdryid").toString();
	        ZdryZb zb = (ZdryZb) this.zdryInfoQueryService.queryById(id);
	        RyRyjbxxb ryjbxxb = this.ryRyjbxxbService.queryById(zb.getRyid());
		
		return this.zdryDtjsXsDao.queryZdryDtjsXsxxbByZdryZjhm(ryjbxxb.getZjhm());
	}
}
