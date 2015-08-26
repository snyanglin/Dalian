/**********************************************************************   
 * <p>文件名：QzbServiceImpl.java </p>
 * <p>文件描述：犬只管理服务实现类</p>
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-5-12 上午9:45:07 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service.impl;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.QzbServiceImpl.java]  
 * @ClassName:    [QzbServiceImpl]   
 * @Description:  [犬只管理服务实现类]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-5-12 上午9:45:07]   
 * @UpdateUser:   [liushuai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 上午9:45:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zafffwqz.bean.Qzb;
import com.founder.zafffwqz.bean.Qzgz;
import com.founder.zafffwqz.dao.QzbDao;
import com.founder.zafffwqz.service.QzbService;

@Service("qzbService")
@Transactional
public class QzbServiceImpl extends BaseService implements QzbService {
	
	@Resource(name = "qzbDao")
	private QzbDao qzbDao;

	@Resource(name="ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Override
	public void delete(Qzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		qzbDao.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		 return qzbDao.queryList(page, map);
	}

	@Override
	public Qzb queryQzb(Qzb entity) {
		return qzbDao.queryQzb(entity);
	}

	@Override
	public void saveQzb(Qzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		entity.setRyid(UUID.create());
		setSaveProperties(entity, sessionBean);
		qzbDao.saveQzb(entity);
		ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}

	@Override
	public void updateQzb(Qzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		qzbDao.updateQzb(entity);
		ryRylxfsxxbService.saveLxdh(entity.getRyid(), entity.getLxdh(), sessionBean);

	}

	@Override
	public List<Qzgz> queryGz(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return qzbDao.queryGz(map);
	}


}
