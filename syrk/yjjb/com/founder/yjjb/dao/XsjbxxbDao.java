package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.role.bean.OrgRole;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.service.XscljlbService;
import com.founder.yjjb.utils.MessageUtils;

/**
 * 线索基本信息表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-17
 */
@Repository("xsjbxxbDao")
public class XsjbxxbDao extends BaseDaoImpl {
	
	@Autowired
	private SysMessageDao sysMessageDao;

	// 日志处理
	@Resource(name="xscljlbService")
	private XscljlbService xscljlbService;
	String xsbh = "";
	String czlx = "";
	StringBuffer cznrBF = new StringBuffer();
	
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryList(EasyUIPage page, Xsjbxxb entity) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			
			sort = "xt_lrsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xsjbxxb", entity);
		
		page.setTotal((Integer) queryForObject("xsjbxxb.queryCount", map));
		page.setRows(queryForList("xsjbxxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xsjbxxb queryList(Xsjbxxb entity){
		
		return (Xsjbxxb)super.queryForObject("xsjbxxb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xsjbxxb queryById(Xsjbxxb entity){
		
		return (Xsjbxxb)super.queryForObject("xsjbxxb.queryById", entity);
	}
	
	/**
	 * 查询待初查数据</br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public List<Xsjbxxb> queryCCById(){
		
		return super.queryForList("xsjbxxb.queryCCById","");
	}
	
	/**
	 * 查询待复查数据</br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public List<Xsjbxxb> queryFCById(){
		
		return super.queryForList("xsjbxxb.queryFCById","");
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void save(Xsjbxxb entity, SessionBean sessionBean) {
		
		insert("xsjbxxb.save", entity);
		
		// ********************************************日志处理
		String userName = sessionBean.getUserName();
		String orgName = sessionBean.getUserOrgName();
		czlx = "00";
		xsbh = entity.getId();
		cznrBF = new StringBuffer();
		cznrBF.append(orgName);
		cznrBF.append(" 的 ");
		cznrBF.append(userName);
		cznrBF.append(", 受理新线索, 当前线索状态为'待初查'");
		xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
		// ********************************************日志处理
		
		
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Xsjbxxb entity, SessionBean sessionBean) {
		
		update("xsjbxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void delete(Xsjbxxb entity, SessionBean sessionBean) {
		
		update("xsjbxxb.delete", entity);
		
		// ********************************************日志处理
		String userName = sessionBean.getUserName();
		String orgName = sessionBean.getUserOrgName();
		
		czlx = "40";
		xsbh = entity.getId();
		cznrBF = new StringBuffer();
		cznrBF.append(orgName);
		cznrBF.append(" 的 ");
		cznrBF.append(userName);
		
		cznrBF.append(", 注销本记录");
		xscljlbService.saveLog(xsbh, cznrBF.toString(),czlx, sessionBean);
		// ********************************************日志处理
	}
	
	/**
	 * 查询所有线索
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryAllList(EasyUIPage page, Xsjbxxb entity) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			
			sort = "xt_lrsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xsjbxxb", entity);
		
		page.setTotal((Integer) queryForObject("xsjbxxb.queryAllCount", map));
		page.setRows(queryForList("xsjbxxb.queryAllList", map));
		return page;
	}

	/**
	 * @Title: queryUserAssignRole
	 * @Description: 通过session查到当前权限列表
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return List<OrgRole>    返回类型
	 * @throws
	 */
	public List<Xsjbxxb> queryUserAssignRole(SessionBean sessionBean) {
		return queryForList("xsjbxxb.queryUserAssignRole", sessionBean);
	}
}