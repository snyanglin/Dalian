package com.founder.ggfw.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;

/**
 * 业务协同规则Dao
 * @author Administrator
 *
 */
@Repository("ywxtRuleDao")
public class YwxtRuleDao extends BaseDaoImpl{

	/**
	 * 联系电话变更 - 同意
	 */
	public Object lxdh_agree() {
		System.out.println("llll");
		return null;
	}                                                                                                                                          

	/**
	 * 联系电话变更 - 拒绝
	 */
	public Object lxdh_refuse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 联系电话变更 - 共存
	 */
	public Object lxdh_coexist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 服务处所变更 - 同意
	 */
	public Object fwcs_agree() {
		
		return null;
	}                                                                                                                                          

	/**
	 * 服务处所变更 - 拒绝
	 */
	public Object fwcs_refuse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 服务处所变更 - 共存
	 */
	public Object fwcs_coexist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 从业人员核实 - 同意
	 */
	public Object cyryhs_agree() {
		
		return null;
	}                                                                                                                                          

	/**
	 * 从业人员核实 - 拒绝
	 */
	public Object cyryhs_refuse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 从业人员核实 - 共存
	 */
	public Object cyryhs_coexist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 实有人口新增核实 - 同意
	 */
	public Object syrkxzhs_agree() {
		
		return null;
	}                                                                                                                                          

	/**
	 * 实有人口新增核实 - 拒绝
	 */
	public Object syrkxzhs_refuse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 实有人口新增核实 - 共存
	 */
	public Object syrkxzhs_coexist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 实有人口注销核实 - 同意
	 */
	public Object syrkzxhs_agree() {
		
		return null;
	}                                                                                                                                          

	/**
	 * 实有人口注销核实 - 拒绝
	 */
	public Object syrkzxhs_refuse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 实有人口注销核实 - 共存
	 */
	public Object syrkzxhs_coexist() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取部门的上级部门代码
	 * @param orgcode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> getLeaderOrgcode(String orgcode){
		return (Map<String, String>) queryForObject("Ywxtgzrwb.getLeaderOrgcode", orgcode);
	}
	
	/**
	 * 根据id更新任务查看状态
	 * @param id
	 */
	public void updateMessageSfck(Long id){
		update("Ywxtgzrwb.updateMessageSfck", id);
	}
	
}
