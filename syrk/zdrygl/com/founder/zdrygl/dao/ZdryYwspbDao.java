package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryYwspb;
import com.founder.zdrygl.vo.ZdryYwspbVo;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.Ywspb.java]  
 * @ClassName:    [Ywspb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午7:27:34]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午7:27:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryYwspbDao")
public class ZdryYwspbDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(新增)
	 * @param @param ZdryYwspb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdryYwspb zdryYwspb){
		super.insertForObject("ZdryYwspb.save", zdryYwspb);
	}
	 
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryYwspb    返回类型
	 * @throws
	 */
	public ZdryYwspb queryById(String id){
		return (ZdryYwspb) queryForObject("ZdryYwspb.queryById", id);
	}
	
	/***
	 * 
	 * @Title: update
	 * @Description: TODO(更新)
	 * @param @param zdryYwspb    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(ZdryYwspb zdryYwspb){
		super.update("ZdryYwspb.updateZdryYwspb", zdryYwspb);
	}
	/***
	 * 
	 * @Title: query
	 * @Description: TODO(通用查找,按照时间倒叙)
	 * @param @param zdryYwspb
	 * @param @return    设定文件
	 * @return List<ZdryYwspb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZdryYwspb> query(ZdryYwspb zdryYwspb){
		return super.queryForList("ZdryYwspb.query", zdryYwspb);
	}
	
	
	public EasyUIPage queryList(ZdryYwspbVo entity, EasyUIPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "a.sqsj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryYwspbVo", entity);
		page.setTotal((Integer) queryForObject("ZdryYwspb.queryListCount", map));
		page.setRows(queryForList("ZdryYwspb.queryList", map));
		return page;
	}
	
}
