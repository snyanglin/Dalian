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
import com.founder.zdrygl.base.dao.ZdryEditDao;
import com.founder.zdrygl.base.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
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

	@Resource(name="ZdryZdrkDao")
	private ZdryZdrkxxbDao zdryZdrkxxbDao;

	@Resource(name = "zpfjFjxxbDao")
	ZpfjFjxxbDao zpfjFjxxbDao;

	@Autowired
	private ZdryConstant zdryConstant;
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
			map.put("zdrylx",zdrkMap.get("zdrylx"));//由于各个区域的重点人员类型代码不一样，所以改用分组来区分用什么界面显示
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
		ZdryZdrkxxb entity=zdryZdrkxxbDao.queryByMap(map);
		entity.setBz(zdryConstant.zdryDict().get(entity.getBz()));
		return entity;
	}
	
	/*
	public ZdrySgafzdryxxb sgafzdryxxb_query(Map<String, Object> map) {
		ZdrySgafzdryxxb entity = zdrySgafzdryxxbDao.queryById((String) map.get("zdryid"));
		return entity;
	}
	
	
	public ZdrySqjzryxxb sqjz_query(Map<String, Object> map) {
		map.put("qydm", zdryUntil.querySYSConfig());
		return zdrySqjzryxxbDao.queryByMap(map);		
	}

	
	public ZdryZszhjsbrxxb zszhjsbrxxb_query(Map<String, Object> map) {
		map.put("qydm", zdryUntil.querySYSConfig());
		return zdryZszhjsbrxxbDao.queryByMap(map);
	}
				
	
	public ZdryFzcsfryxxb fzcfryxxb_query (Map<String,Object> map){
		map.put("qydm", zdryUntil.querySYSConfig());
		return zdryFzcsfryxxbDao.queryByMap(map);
	}
	
	public ZdrySqsbzdryxxb sqsbzdry_query (Map<String,Object> map){
		return zdrySqsbzdryxxbDao.queryById((String) map.get("zdryid"));
	}
	
	public ZdryJgdxxxb jgdxxxb_query(Map<String, Object> map) {
		map.put("qydm", zdryUntil.querySYSConfig());
		return zdryJgdxxxbDao.queryByMap(map);
	}
	
	
	
	public List jkbjryxxb_query (Map<String,Object> map){
		map.put("maxNum", "10");
		return zdryJkbjllxxbDao.queryViewList(map);
	}

	
	public List qxjdjb_query(Map<String, Object> map){
		map.put("maxNum", "10");
		return zdryJgdxqxjdjbDao.queryViewList(map);
	}
	
	
	public List psjdb_query(Map<String, Object> map){
		map.put("maxNum", "10");
		return zdryPsjdbDao.queryViewList(map);
	}
	
	*/	
	
	
	/**
	 * 
	 * @Title: zdryZl
	 * @Description: TODO(重点人员转类)
	 * @param @param zdryVO
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 *
	
	public void zdryZl(ZdryVO zdryVO,SessionBean sessionBean) {
		ZdryZdryzb zdryZdryzb = zdryVO.getZdryZdryzb();		
		BaseService.setUpdateProperties(zdryZdryzb, sessionBean);
		zdryZdryzbDao.update(zdryZdryzb);
	}
	
	/**
	 * 
	 * @Title: queryIsZL
	 * @Description: TODO(查询是否可转类)
	 * @param @param zdrylx(重点人员类型)
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 *
	
	public boolean queryIsZL(String zdrylx){
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdrylx,zdryUntil.querySYSConfig());
		if(zdryGzb!=null && "0".equals(zdryGzb.getSfkzl())){//可转类
			return true;
		}
		return false;
	} 
	*/
}
