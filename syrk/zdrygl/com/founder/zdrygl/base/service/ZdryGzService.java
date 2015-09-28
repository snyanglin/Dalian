package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.config.SystemConfig;
import com.founder.zdrygl.base.dao.ZdryGzbDao;
import com.founder.zdrygl.base.model.ZdryGzb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryGzService.java]  
 * @ClassName:    [ZdryGzService]   
 * @Description:  [重点人员规则服务]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月28日 上午10:07:42]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月28日 上午10:07:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Service("zdryGzService")
public class ZdryGzService  extends BaseService {
	@Resource(name="zdryGzbDao")
	private ZdryGzbDao zdryGzbDao;	
	
	public String queryKcglx(String zdrylxdm){
		ZdryGzb zdryGzb=zdryGzbDao.queryByZdrylx(zdrylxdm,SystemConfig.getString("systemXzqh")==""?"210000":SystemConfig.getString("systemXzqh"));
		if(zdryGzb!=null) return zdryGzb.getCglx();
		return null;
	}
}
