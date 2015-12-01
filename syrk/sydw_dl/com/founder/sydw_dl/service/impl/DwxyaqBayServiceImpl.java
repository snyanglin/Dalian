/**********************************************************************   
 * <p>文件名：DwxyaqBayServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-5 下午12:26:27 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.DwxyaqxxbBay;
import com.founder.sydw_dl.dao.DwxyaqxxbBayDao;
import com.founder.sydw_dl.service.DwxyaqBayService;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.service.impl.DwxyaqBayServiceImpl.java]  
 * @ClassName:    [DwxyaqBayServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-5 下午12:26:27]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-5 下午12:26:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("dwxyaqBayService")
@Transactional
public class DwxyaqBayServiceImpl extends BaseService implements
		DwxyaqBayService {
	@Resource(name = "dwxyaqxxbBaydao")
	private DwxyaqxxbBayDao dwxyaqxxbBaydao;
	
	@Override
	public DwxyaqxxbBay query(String id) {
		return dwxyaqxxbBaydao.queryEntityById(id);
	}

	@Override
	public void save(DwxyaqxxbBay entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwxyaqxxbBaydao.saveEntity(entity);

	}

	@Override
	public void update(DwxyaqxxbBay entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwxyaqxxbBaydao.updateEntity(entity);

	}

}
