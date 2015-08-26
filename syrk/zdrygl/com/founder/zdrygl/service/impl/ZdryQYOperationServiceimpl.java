package com.founder.zdrygl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.service.ZdryOperationService;
import com.founder.zdrygl.until.ZdryUntil;
import com.founder.zdrygl.vo.ZdryVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.ZdryQYOperationServiceimpl.java]  
 * @ClassName:    [ZdryQYOperationServiceimpl]   
 * @Description:  [重点人员区域服务类]   
 * @Author:       [zhang.hai]  
 * @CreateDate:   [2015-07-27 9:00:00]   
 * @UpdateUser:   [zhang.hai]   
 * @UpdateDate:   [2015-07-27 9:00:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Transactional
public abstract class ZdryQYOperationServiceimpl implements ZdryOperationService {
	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;

	@Override
	public void saveLg(ZdryVO vo) throws BussinessException {
		//这里根据地域不同分配不同默认权限
		ZdryZdryzb  zdryZdryzb = vo.getZdryZdryzb();
		String  address =zdryUntil.querySYSConfig();
		if(!StringUtils.isEmpty(address)&&"210".equals(address)){
			zdryZdryzb.setGlbm("");
			zdryZdryzb.setCxbm("");
		}else if(!StringUtils.isEmpty(address)&&"210201".equals(address)){
			zdryZdryzb.setGlbm("");
		}
		//这里根据地域判断是否可列管
	}

	@Override
	public void saveZd(ZdryVO vo) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ZdryVO queryByZdryID(String zdryid) {
		return null;
	}
	
	@Override
	public List queryByZdrylx(String zdrylx){
		return null;
	}

	@Override
	public void updateByZdrylx(ZdryVO zdryVO, SessionBean sessionBean) {}

}
