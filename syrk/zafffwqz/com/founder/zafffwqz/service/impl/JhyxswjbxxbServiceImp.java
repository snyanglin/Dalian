/**********************************************************************   
 * <p>文件名：JhyxswjbxxbServiceImp.java </p>
 * <p>文件描述：TODO(集会游行示威服务实现类) 
 * @project_name：syrk
 * @author tian_chengwei@founder.com.cn 
 * @date 2015-5-18 上午10:13:10 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Jhyxswjbxxb;
import com.founder.zafffwqz.dao.JhyxswjbxxbDao;
import com.founder.zafffwqz.service.JhyxswjbxxbService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.JhyxswjbxxbServiceImp.java]  
 * @ClassName:    [JhyxswjbxxbServiceImp]   
 * @Description:  [业务处理]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-18 上午10:13:10]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-18 上午10:13:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("jhyxswjbxxbService")
@Transactional
public class JhyxswjbxxbServiceImp extends BaseService implements JhyxswjbxxbService {
	@Resource(name = "jhyxswjbxxbDao")
	private JhyxswjbxxbDao jhyxswjbxxbDao;

	/* (查询基本信息)
	 * <p>Title: queryAfxxb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @return Jhyxswjbxxb
	 * @see com.founder.zafffwqz.service.AfxxbService#queryAfxxb(com.founder.zafffwqz.bean.Afxxb)
	 */
	@Override
	public Jhyxswjbxxb queryJhyxswjbxxb(Jhyxswjbxxb entity) {
		return jhyxswjbxxbDao.queryJhyxswjbxxb(entity);
	}

	/* (保存基本信息)
	 * <p>Title: saveAfxxb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.zafffwqz.service.AfxxbService#saveAfxxb(com.founder.zafffwqz.bean.Afxxb)
	 */
	@Override
	public void saveJhyxswjbxxb(Jhyxswjbxxb entity,SessionBean sessionBean) {
		entity.setId(UUID.create());
	    setSaveProperties(entity, sessionBean);
	    jhyxswjbxxbDao.saveJhyxswjbxxb(entity);

	}

	/* (修改基本信息)
	 * <p>Title: updateAfxxb</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.zafffwqz.service.AfxxbService#updateAfxxb(com.founder.zafffwqz.bean.Afxxb)
	 */
	@Override
	public void updateJhyxswjbxxb(Jhyxswjbxxb entity,SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		jhyxswjbxxbDao.updateJhyxswjbxxb(entity);

	}

	/* (删除基本信息)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param entity
	 * @see com.founder.zafffwqz.service.AfxxbService#delete(com.founder.zafffwqz.bean.Afxxb)
	 */
	@Override
	public void delete(Jhyxswjbxxb entity,SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		jhyxswjbxxbDao.delete(entity);

	}

	/* (列表查询信息)
	 * <p>Title: queryList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param map
	 * @return EasyUIPage
	 * @see com.founder.zafffwqz.service.AfxxbService#queryList(com.founder.framework.utils.EasyUIPage, java.util.Map)
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Jhyxswjbxxb entity) {
		return jhyxswjbxxbDao.queryList(page, entity);
	}

}
