package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.dao.ZdryInitializeDao;
import com.founder.zdrygl.core.inteface.ZdryQueryService;
import com.founder.zdrygl.core.model.Zdry;

@Service("zdryQueryService")
public class ZdryInfoQueryService extends ZdryQueryService {
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Autowired
	private ZdryInitializeDao zdryInitializeDao;

	@Override
	public EasyUIPage queryList(EasyUIPage page, Object object) {
		Map map=new HashMap();
		map.put("zdryZb", object);
		return zdryZdryZbDao.queryPageList(map, page);
	}

	@Override
	public EasyUIPage getQueryList(EasyUIPage page, Object object) {
		Map map=new HashMap();
		map.put("zdryZb", object);
		return zdryZdryZbDao.getQueryList(map, page);
	}

	@Override
	public List<?> queryListByRyid(String ryid) {
		// TODO Auto-generated method stub
		return zdryZdryZbDao.queryListByRyId(ryid, null);
	}

	@Override
	public List<?> queryListBySyrkId(String syrkId) {
		// TODO Auto-generated method stub
		return zdryZdryZbDao.queryListBySyrkId(syrkId, null);
	}

	/**
	 * 
	 * @Title: queryListByEntity
	 * @Description: TODO(通过重点人员总表对象查询List)
	 * @param @param zdryZb
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */	
	public List queryListByEntity(ZdryZb zdryZb) {
		return zdryZdryZbDao.queryListByEntity(zdryZb,null);		
	}
	
	@Override
	public Zdry queryById(String zdryzbId) {
		// TODO Auto-generated method stub
		return zdryZdryZbDao.queryById(zdryzbId);
	}
	
	/**
	 * 
	 * @Title: getChildList
	 * @Description: TODO(查询重点人员类型下的子类列表，递归可以避免树级别不确定时写死的树层数不符合要求 )
	 * @param @param lbdm_p 上级类型
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List getChildList(String lbdm_p) {		
		String  qydm =SystemConfig.getString("systemXzqh");		
		if(org.springframework.util.StringUtils.isEmpty(qydm)) qydm="210000";
		List list = zdryInitializeDao.queryZdryDict(lbdm_p,qydm);
		Map map;
		List childList;
		String id,text;
		for(int i=0;i<list.size();i++){
			map=(Map) list.get(i);
			//树结构必须是id和text
			id=(String) map.get("key");
			text=(String) map.get("value");
			map.clear();
			map.put("id", id);
			map.put("text", text);
			
			childList=this.getChildList(id);
			if(childList!=null && childList.size()>0){//下级树结构
				map.put("state", "closed");
				map.put("children", childList);				
			}
		}	
		return list;
	}

}
