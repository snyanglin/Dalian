/**********************************************************************   
 * <p>文件名：DxqzxhdSplJbxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:43:35 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.DxqzxhdSplJbxxb;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.DxqzxhdSplJbxxbDao.java]  
 * @ClassName:    [DxqzxhdSplJbxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:43:35]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:43:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Repository("dxqzxhdSplJbxxbDao")
public class DxqzxhdSplJbxxbDao extends BaseDaoImpl{

	/**
	 * @Title: query
	 * @Description: 查询
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage query(EasyUIPage page,DxqzxhdSplJbxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "hdkssj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		page.setRows(queryForList("dxqzxhdspljbxxb.queryList", map));
		page.setTotal((Integer) queryForObject("dxqzxhdspljbxxb.queryListCount", map));
		return page;
	}
	
	/**
	 * @Title: query
	 * @Description: 查询单条
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return DxqzxhdSplJbxxb    返回类型
	 * @throws
	 */
	public DxqzxhdSplJbxxb query(String hdid){
		DxqzxhdSplJbxxb entity=(DxqzxhdSplJbxxb)queryForObject("dxqzxhdspljbxxb.query", hdid);
		return entity;
	}
	
	/**
	 * @Title: saveJbxx
	 * @Description: save
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveJbxx(DxqzxhdSplJbxxb entity){
		insert("dxqzxhdspljbxxb.save",entity);
	}
	
	/**
	 * @Title: updateJbxx
	 * @Description: update
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void updateJbxx(DxqzxhdSplJbxxb entity){
		update("dxqzxhdspljbxxb.update",entity);
	}
	
	/**
	 * @Title: deleteJbxx
	 * @Description: delete
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteJbxx(DxqzxhdSplJbxxb entity){
		update("dxqzxhdspljbxxb.delete",entity);
	}
	
	/**
	 * @Title: isExist
	 * @Description: 判断是否存在
	 * @param @param hdid
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean isExist(String hdid){ 
		return ((Integer)queryForObject("dxqzxhdspljbxxb.isExist",hdid))>0;
	}
}
