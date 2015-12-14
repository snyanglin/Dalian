package com.founder.ggfw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.message.bean.SysMessage;
import com.founder.ggfw.bean.Ywxtgzrwb;

@Repository("ywxtgzrwbDao")
public class YwxtgzrwbDao extends BaseDaoImpl {
	
	/**
	 * 根据id查询'业务协同规则任务表'
	 * 
	 * @param id
	 * @return
	 */
	public SysMessage queryYwxtgzrwbById(String id) {
		return (SysMessage) super.queryForObject("Ywxtgzrwb.queryYwxtgzrwbById", id);
	}
	
	public void savaYwxtgzrwb(Ywxtgzrwb entity){
		super.insert("Ywxtgzrwb.insertYwxtgzrwb", entity);
	}
	public void updateYwxtgzrwb(Ywxtgzrwb entity){
		super.insert("Ywxtgzrwb.updateYwxtgzrwb", entity);
	}

}
