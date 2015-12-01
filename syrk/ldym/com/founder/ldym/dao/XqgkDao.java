package com.founder.ldym.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.ldym.pojo.SysDict;
import com.founder.ldym.util.StringUtil;
import com.founder.ldym.util.SystemConfig;
import com.founder.ldym.vo.XqgkDataCountVo;
import com.founder.sydw_dl.bean.Dwjbxxb;


/**
 * 
 * <p>标题：字典持久层</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-3-12</p>
 * @author	yi_chu
 */
@Repository("xqgkDao")
public class XqgkDao extends BaseDaoImpl {

	public XqgkDataCountVo queryYxsjCount(String orgCode){		
		return (XqgkDataCountVo)queryForObject("xqgk.queryYxsjCount", orgCode);	
	}
	
	
	
	public List<Dwjbxxb> querySydwList(Map<String,String> map){		
		return (List<Dwjbxxb>)queryForList("xqgk.querySydwList", map);	
	}
	
}