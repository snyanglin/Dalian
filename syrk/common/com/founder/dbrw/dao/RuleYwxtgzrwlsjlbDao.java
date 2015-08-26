/**********************************************************************   
 * <p>文件名：RuleYwxtgzrwlsjlbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-3 下午9:36:50 
 * @history
 * @department：研发部
 *
*/
package com.founder.dbrw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;

/******************************************************************************
 * @Package:      [com.founder.dbrw.dao.RuleYwxtgzrwlsjlbDao.java]  
 * @ClassName:    [RuleYwxtgzrwlsjlbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-3 下午9:36:50]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-3 下午9:36:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("ruleYwxtgzrwlsjlbDao")
public class RuleYwxtgzrwlsjlbDao extends BaseDaoImpl {
	/**
	 * 根据发起人和处理人查询详细信息
	 * @return
	 */
	public EasyUIPage queryRuleYwxtgzrwlsjlb(EasyUIPage page,Map map) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		page.setTotal((Integer) queryForObject(
				"RuleYwxtgzrwlsjlb.queryCount", map));
		page.setRows( queryForList("RuleYwxtgzrwlsjlb.query", map));

		return page;
	}
	
}
