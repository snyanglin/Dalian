package com.founder.zdrygl.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.BeanUtils;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryGlpzpzb;
import com.founder.zdrygl.bean.ZdryYwspb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryGlpzpzbDao;
import com.founder.zdrygl.dao.ZdryYwspbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.ZdryZdService;
import com.founder.zdrygl.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.service.impl.ZdryZdServiceImpl.java]
 * @ClassName: [ZdryZdServiceImpl]
 * @Description: [重点人员转递逻辑处理]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 下午3:38:59]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 下午3:38:59，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("zdryZdService")
@Transactional
public class ZdryZdServiceImpl extends BaseService implements ZdryZdService {

	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Override
	public void sendZd(ZdryZdryzbVO zdryZdryzbVo,
			SessionBean sessionBean) throws BussinessException {
		List<ZdryZdryzb> zdryZdList = zdryZdryzbDao.queryZdryBySyrkid(zdryZdryzbVo.getSyrkid());
		for (int i = 0; i < zdryZdList.size(); i++) {
			ZdryZdryzb entity= zdryZdList.get(i);
			entity.setGlzt("5");
			zdryZdryzbDao.update(entity);
		}
		

	}

}
