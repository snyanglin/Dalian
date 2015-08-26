/**********************************************************************   
 * <p>文件名：RuleYwxtgzrwlsjlbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-3 下午9:38:33 
 * @history
 * @department：研发部
 *
*/
package com.founder.dbrw.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.dbrw.dao.RuleYwxtgzrwlsjlbDao;
import com.founder.dbrw.service.RuleYwxtgzrwlsjlbService;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;

/******************************************************************************
 * @Package:      [com.founder.dbrw.service.impl.RuleYwxtgzrwlsjlbServiceImpl.java]  
 * @ClassName:    [RuleYwxtgzrwlsjlbServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-3 下午9:38:33]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-3 下午9:38:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("ruleYwxtgzrwlsjlbService")
@Transactional
public class RuleYwxtgzrwlsjlbServiceImpl extends BaseService implements RuleYwxtgzrwlsjlbService {
	@Resource(name = "ruleYwxtgzrwlsjlbDao")
	private RuleYwxtgzrwlsjlbDao ruleYwxtgzrwlsjlbDao;

	/* (非 Javadoc)
	 * <p>Title: list</p>
	 * <p>Description: </p>
	 * @param page
	 * @param map
	 * @return
	 * @see com.founder.dbrw.service.RuleYwxtgzrwlsjlbService#list(com.founder.framework.utils.EasyUIPage, java.util.Map)
	 */
	@Override
	public EasyUIPage list(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return ruleYwxtgzrwlsjlbDao.queryRuleYwxtgzrwlsjlb(page,map);
	}

}
