package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.core.inteface.ZdryGllxEntityDaoService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao.java]  
 * @ClassName:    [ZdryShbzdryxxbDao]   
 * @Description:  [涉环保重点人员 dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 下午2:51:16]   
 * @UpdateUser:   [cong_rihong@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 下午2:51:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryShbzdryxxbDao")
public class ZdryShbzdryxxbDao extends BaseDaoImpl implements ZdryGllxEntityDaoService{

	@Resource
	private OrgOrganizationService orgOrganizationService;

	@Override
	public void insert(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.save", shb);
	}

	@Override
	public void update(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.update", shb);
	}

	@Override
	public void delete(Zdry zdry) {
		ZdryShbzdryxxb shb = (ZdryShbzdryxxb)zdry;
		super.insert("ZdryShbzdryxxb.delete", shb);
	}

	@Override
	public Zdry queryById(String entityId) {
		return (Zdry)super.queryForObject("ZdryShbzdryxxb.queryById", entityId);
	}
	public ZdryShbzdryxxb queryZdryShbzdryxxbById(String entityId) {
		return (ZdryShbzdryxxb)super.queryForObject("ZdryShbzdryxxb.queryById", entityId);
	}
	@Override
	public Zdry queryViewByMap(Map<String, Object> queryMap) {
		return (Zdry)super.queryForObject("ZdryShbzdryxxb.queryViewByMap", queryMap);
	}
	/**
	 *
	 * @Title: querySyrk
	 * @Description: TODO(查询列表，涉环保重点人员单独查询)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryShbzdryxxb entity, EasyUIPage page,SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("zdryShbzdryxxb", entity);

		String userOrgCode=sessionBean.getUserOrgCode();
		String userOrgLevel=sessionBean.getUserOrgLevel();
		if("30".equals(userOrgLevel)){
			map.put("userOrgCode", userOrgCode);
		}else if("31".equals(userOrgLevel)){
			OrgOrganization parentOrganization=this.orgOrganizationService.queryParentOrgByOrgcode(userOrgCode);
			map.put("userOrgCode", parentOrganization.getOrgcode());
		}
		page.setTotal((Integer) queryForObject("ZdryShbzdryxxb.queryCount", map)==null?0:(Integer) queryForObject("ZdryShbzdryxxb.queryCount", map));
		//orgCode2orgName set to sszrqdm
		List<ZdryShbzdryxxb> list =queryForList("ZdryShbzdryxxb.query", map);
		for(ZdryShbzdryxxb xxb:list){
			OrgOrganization fxj = orgOrganizationService.queryByOrgcode(xxb.getSsfxjdm());
			xxb.setSsfxjdm(fxj.getOrgname());

			if("30".equals(userOrgLevel)){
				xxb.setQx("view");
			}else if("31".equals(userOrgLevel)){
				xxb.setQx("edit");
			}

		}
		page.setRows(list);
		return page;

	}
}
