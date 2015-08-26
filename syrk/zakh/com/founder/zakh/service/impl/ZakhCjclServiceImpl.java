/**********************************************************************   
 * <p>文件名：ZakhCjclServiceImpl.java </p>
 * <p>文件描述：治安考核-基本信息采集常量服务实现类
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-4-17 上午9:43:38 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.service.impl;

import java.util.*;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.zakh.bean.ZakhCjclBean;
import com.founder.zakh.dao.ZakhCjclDao;
import com.founder.zakh.service.ZakhCjclService;

/******************************************************************************
 * @Package:      [com.founder.zakh.service.impl.ZakhCjclServiceImpl.java]  
 * @ClassName:    [ZakhCjclServiceImpl]   
 * @Description:  [治安考核-基本信息采集常量服务实现类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午9:43:38]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午9:43:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("zakhCjclService")
@Transactional
public class ZakhCjclServiceImpl implements ZakhCjclService{
	
	@Resource(name="zakhCjclDao")
	private ZakhCjclDao cjDao;

	/* (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.zakh.service.ZakhCjclService#save(com.founder.zakh.bean.ZakhCjclBean)
	 */
	@Override
	public void save(ZakhCjclBean entity) {
		cjDao.save(entity);
		
	}

	/* (非 Javadoc)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.zakh.service.ZakhCjclService#delete(com.founder.zakh.bean.ZakhCjclBean)
	 */
	@Override
	public int delete(String orgid) {
		return cjDao.delete(orgid);
	}

	/* (非 Javadoc)
	 * <p>Title: update</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return
	 * @see com.founder.zakh.service.ZakhCjclService#update(com.founder.zakh.bean.ZakhCjclBean)
	 */
	@Override
	public int update(ZakhCjclBean entity) {
		return cjDao.update(entity);
	}

	/* (非 Javadoc)
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * @param orgid 
	 * @return
	 * @see com.founder.zakh.service.ZakhCjclService#query(java.util.Map)
	 */
	@Override
	public List<ZakhCjclBean> query(String orgid) {
		if("".equals(orgid.trim())){
			orgid=null;
		}
		Map<String,String> clMap=new HashMap<String, String>();
		clMap.put("orgid", orgid);
		List<ZakhCjclBean> list = cjDao.query(clMap);
		return list;
	}

}
