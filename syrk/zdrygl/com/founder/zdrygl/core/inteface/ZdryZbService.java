package com.founder.zdrygl.core.inteface;

import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.vo.ZdryVO;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.ZdryZbService.java]  
 * @ClassName:    [ZdryZbService]   
 * @Description:  [定制总表自己的行为 ]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年10月9日 下午3:25:59]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月9日 下午3:25:59，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryZbService extends ZdryService {
	/**
	 * 
	 * @Title: queryById
	 * @Description: 根据Id查询总表信息 
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryZdryzb    返回类型
	 * @throws
	 */
	public ZdryZb queryById(String id);
}
