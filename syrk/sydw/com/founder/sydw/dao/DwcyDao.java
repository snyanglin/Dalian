package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.Dwcyxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.DwcyDao.java]  
 * @ClassName:    [DwcyDao]   
 * @Description:  单次抽样
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-7-8 上午9:15:02]   
 * @UpdateUser:   [xu_haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 上午9:15:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("dwcyDao")
public class DwcyDao extends BaseDaoImpl {
	/**
	 * @Title: saveXfdwcyxxb
	 * @Description: 保存消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		insert("Dwcy.saveXfdwcyxxb", entity);
	}
	/**
	 * 
	 * @Title: modifyXfdwcyxxb
	 * @Description: 修改消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void modifyXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		update("Dwcy.modifyXfdwcyxxb", entity);
	}
	/**
	 * 
	 * @Title: deleteXfdwcyxxb
	 * @Description: 删除消防单位单次抽样信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteXfdwcyxxb(Dwcyxxb entity, SessionBean sessionBean) {
		update("Dwcy.deleteXfdwcyxxb", entity);
	}
	/**
	 * 
	 * @Title: queryXfdwcyxxbForPage
	 * @Description: 分页查询消防单位单次抽样信息
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryXfdwcyxxbForPage(EasyUIPage page,Dwcyxxb entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "nf";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("dwcyxxb", entity);
		page.setTotal((Integer) queryForObject("Dwcy.queryXfdwcyxxbCount", map));
		page.setRows(queryForList("Dwcy.queryXfdwcyxxbForPage", map));
		return page;
	}
	/**
	 * querycccs
	 * @Title: queryXfdwcyxxb
	 * @Description: 查询单条消防单位单次抽样信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Dwcyxxb    返回类型
	 * @throws
	 */
	public Dwcyxxb queryXfdwcyxxb(Dwcyxxb entity){
		Dwcyxxb vo = (Dwcyxxb)queryForObject("Dwcy.queryXfdwcyxxb", entity);
		return vo;
	}
	/**
	 * 
	 * @Title: querycccs
	 * @Description: 查询抽查次数
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public String querycccs(Dwcyxxb entity){
		String vo = String.valueOf(queryForObject("Dwcy.querycccs", entity));
		return vo;
	}
	
	/**
	 * 
	 * @Title: queryXfdwcyxxbList
	 * @Description: 查询多条消防单位单次抽样信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Dwcyxxb>    返回类型
	 * @throws
	 */
	public List<Dwcyxxb> queryXfdwcyxxbList(Dwcyxxb entity){
		List<Dwcyxxb> list = queryForList("Dwcy.queryXfdwcyxxb", entity);
		return list;
	}
	/**
	 * 
	 * @Title: querysydw
	 * @Description: 查询所有单位
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> querysydw(Dwcyxxb entity) {
		List<DwOwnXFBean> list = queryForList("Dwcy.querysydw", entity);
		return list;
	}
	/**
	 * 
	 * @Title: queryycdw
	 * @Description: 查询已抽单位
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> queryycdw(Dwcyxxb entity) {
		List<DwOwnXFBean> list = queryForList("Dwcy.queryycdw", entity);
		return list;
	}
	/**
	 * 
	 * @Title: querywcdw
	 * @Description: 查询未抽单位
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<DwOwnXFBean>    返回类型
	 * @throws
	 */
	public List<DwOwnXFBean> querywcdw(Dwcyxxb entity) {
		List<DwOwnXFBean> list = queryForList("Dwcy.querywcdw", entity);
		return list;
	}
}
