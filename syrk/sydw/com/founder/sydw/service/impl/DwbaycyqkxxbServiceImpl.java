/**********************************************************************   
 * <p>文件名：DwbaycyqkxxbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author liang_lihe@founder.com.cn 
 * @date 2015-7-9 上午9:04:36 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwbacyqkxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.dao.DwbaycyqkxxbDao;
import com.founder.sydw.dao.DwxyaqxxbBayDao;
import com.founder.sydw.service.DwbaycyqkxxbService;
import com.founder.sydw.service.DwxyaqBayService;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwbaycyqkxxbServiceImpl.java]  
 * @ClassName:    [DwbaycyqkxxbServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [liang_lihe@founder.com.cn]  
 * @CreateDate:   [2015-7-9 上午9:04:36]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-9 上午9:04:36，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("dwbaycyqkxxbService")
@Transactional
public class DwbaycyqkxxbServiceImpl extends BaseService implements
		DwbaycyqkxxbService{
	
	@Resource(name = "dwbaycyqkxxbdao")
	private DwbaycyqkxxbDao dwbaycyqkxxbdao;

	@Override
	public Dwbacyqkxxb query(String id) {
		return dwbaycyqkxxbdao.queryEntityById(id);
	}
	
	@Override
	public void save(Dwbacyqkxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwbaycyqkxxbdao.saveEntity(entity);

	}
	
	@Override
	public void update(Dwbacyqkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwbaycyqkxxbdao.updateEntity(entity);

	}

}
