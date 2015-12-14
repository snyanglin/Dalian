package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.dao.ZdryFzcsfryxxbDao;
import com.founder.zdrygl.base.dao.ZdryNrsxdxxxbDao;
import com.founder.zdrygl.base.dao.ZdrySgafzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdrySqjzryxxbDao;
import com.founder.zdrygl.base.dao.ZdrySqsbzdryxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdrkxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.dao.ZdryZszhjsbrxxbDao;
import com.founder.zdrygl.base.dao.ZdryJgdxxxbDao;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.inteface.ZdryQueryService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryInfoQueryService.java]  
 * @ClassName:    [ZdryInfoQueryService]   
 * @Description:  [重点人员信息查询服务]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年12月2日 下午5:37:21]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月2日 下午5:37:21，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryQueryService")
public class ZdryInfoQueryService extends ZdryQueryService {
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Resource(name="zdrySqjzryxxbDao")
	private ZdrySqjzryxxbDao zdrySqjzryxxbDao;	
	@Resource(name="zdrySgafzdryxxbDao")
	private ZdrySgafzdryxxbDao zdrySgafzdryxxbDao;	
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource(name="zdrySqsbzdryxxbDao")
	private ZdrySqsbzdryxxbDao zdrySqsbzdryxxbDao;
	@Resource(name="zdryZszhjsbrxxbDao")
	private ZdryZszhjsbrxxbDao zdryZszhjsbrxxbDao;
	@Resource(name="zdryFzcsfryxxbDao")
	private ZdryFzcsfryxxbDao zdryFzcsfryxxbDao;
	@Autowired
	private ZdryZdrkxxbDao zdryZdrkxxbDao;
	@Autowired
	private ZdryJgdxxxbDao zdryJgdxxxbDao;
	@Autowired
	private ZdryNrsxdxxxbDao zdryNrsxdxxxbDao;
	
	@Autowired
	private ZdryConstant zdryConstant;

	@Override
	public EasyUIPage queryList(EasyUIPage page, Object object) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("zdryZb", object);
		return zdryZdryZbDao.queryPageList(map, page);
	}

	@Override
	public EasyUIPage getQueryList(EasyUIPage page, Object object) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("zdryZb", object);
		return zdryZdryZbDao.getQueryList(map, page);
	}

	@Override
	public List<?> queryListByRyid(String ryid) {
		return zdryZdryZbDao.queryListByRyId(ryid, null);
	}

	@Override
	public List<?> queryListBySyrkId(String syrkId) {
		return zdryZdryZbDao.queryListBySyrkId(syrkId, null);
	}

	/**
	 * 
	 * @Title: queryListByEntity
	 * @Description: (通过重点人员总表对象查询List)
	 * @param @param zdryZb
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */	
	public List<?> queryListByEntity(ZdryZb zdryZb) {
		return zdryZdryZbDao.queryListByEntity(zdryZb,null);		
	}
	
	@Override
	public Zdry queryById(String zdryzbId) {
		return zdryZdryZbDao.queryById(zdryzbId);
	}
	
	@Override
	public Integer queryForCount(String syrkId) {
		return zdryZdryZbDao.queryCount(syrkId);
	}
	/**
	 * 
	 * @Title: getChildList
	 * @Description: (查询重点人员类型下的子类列表，递归可以避免树级别不确定时写死的树层数不符合要求 )
	 * @param @param lbdm_p 上级类型
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<?> getChildList(String lbdm_p) {		
		String  qydm = SystemConfig.getString("systemXzqh");		
		if(StringUtils.isEmpty(qydm)) qydm="210000";
		List<?> list = zdryConstant.queryChildByQydm(lbdm_p,qydm);
		Map<String,Object> map;
		List<?> childList;
		String id,text;
		for(int i=0;i<list.size();i++){
			map = (Map) list.get(i);
			//树结构必须是id和text
			id=(String) map.get("key");
			text=(String) map.get("value");
			map.clear();
			map.put("id", id);
			map.put("text", text);
			
			childList = this.getChildList(id);
			if(childList!=null && childList.size()>0){//下级树结构
				map.put("state", "closed");
				map.put("children", childList);				
			}
		}	
		return list;
	}

	@Override
	public Zdry queryZdryzbById(final String zdryId,final String zdrygllxdm) {
		if("210000".equals(SystemConfig.getString(AppConst.XZQH))){//辽宁
			if("01".equals(zdrygllxdm))//社区矫正人员
				return zdrySqjzryxxbDao.queryById(zdryId);
			if("02".equals(zdrygllxdm))//重点人口
				return zdryZdrkxxbDao.queryById(zdryId);
			if("03".equals(zdrygllxdm))//肇事肇祸精神病人
				return zdryZszhjsbrxxbDao.queryById(zdryId);
			if("04".equals(zdrygllxdm))//非正常上访重点人员
				return zdryFzcsfryxxbDao.queryById(zdryId);
			if("05".equals(zdrygllxdm))//涉公安访重点人员
				return zdrySgafzdryxxbDao.queryById(zdryId);
			//if("06".equals(zdrygllxdm))//其他关注对象
			//	return this.
			if("07".equals(zdrygllxdm))//涉环保重点人员
				return zdryShbzdryxxbDao.queryById(zdryId);
			if("08".equals(zdrygllxdm))//涉枪涉爆重点人员
				return zdrySqsbzdryxxbDao.queryById(zdryId);
		}else{
			if("01".equals(zdrygllxdm)){//监管对象
				return zdryJgdxxxbDao.queryById(zdryId);
			}
			
			if("02".equals(zdrygllxdm))//重点人口
				return zdryZdrkxxbDao.queryById(zdryId);
			if("03".equals(zdrygllxdm)){//其它重点管理对象
				return zdryZdrkxxbDao.queryById(zdryId);
			}
				
			if("04".equals(zdrygllxdm)){//肇事肇祸精神病人
				return zdryZszhjsbrxxbDao.queryById(zdryId);
			}
				
			if("05".equals(zdrygllxdm)){//肇事肇祸精神病人
				return zdryZszhjsbrxxbDao.queryById(zdryId);
			}
			if("06".equals(zdrygllxdm)){//非正常上访重点人员
				return zdryFzcsfryxxbDao.queryById(zdryId);
			}
			if("07".equals(zdrygllxdm)){//纳入实现对象
				return zdryNrsxdxxxbDao.queryById(zdryId);			
			}
		}		
		return null;
	}

}
