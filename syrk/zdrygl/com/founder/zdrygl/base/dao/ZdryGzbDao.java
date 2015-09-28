package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryGzb;

/***
 * 	****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryGzbDao.java]  
 * @ClassName:    [ZdryGzbDao]   
 * @Description:  [规则配置表DAO]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年7月24日 下午3:07:08]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年7月24日 下午3:07:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryGzbDao")
public class ZdryGzbDao extends BaseDaoImpl{

	/**
	 * 
	 * @Title: queryByZdrylx
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param zdrylx
	 * @param @return    设定文件
	 * @return ZdryGzb    返回类型
	 * @throws
	 */
	public ZdryGzb queryByZdrylx(String zdrylx,String qydm){
		Map map=new HashMap();
		map.put("qydm", qydm);
		map.put("zdrylx", zdrylx);
		return (ZdryGzb) queryForObject("ZdryGzb.queryLglxByZdrylx", map);
	}		
	
}
