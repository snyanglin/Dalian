package com.founder.xlff.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlff.bean.Fkzl;
import com.founder.xlff.bean.Zlqsfk;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.service.ZlxfService.java]  
 * @ClassName:    [ZlxfService]   
 * @Description:  [指令下发服务]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-24 上午10:16:22]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 上午10:16:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("指令下发")
public interface ZlxfService {

	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(指令下发查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zlxf    返回类型
	 * @throws
	 */
	public EasyUIPage queryZlxfList(EasyUIPage page, Fkzl entity);
	
	/**
	 * @Title: saveZlxf
	 * @Description: TODO(保存指令下发)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveZlxf(Fkzl entity);

	/**
	 * @Title: saveFkzlqsfk
	 * @Description: TODO(批量保存指令签收反馈数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveFkzlqsfk(Fkzl entity, SessionBean sessionBean);
	
	/**
	 * @Title: queryZlxfList
	 * @Description: TODO(指令下发查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Zlxf    返回类型
	 * @throws
	 */
	public EasyUIPage queryZlqsfkList(EasyUIPage page, Fkzl entity);
	
	/**
	 * @Title: updateZlqsfk
	 * @Description: TODO(更新指令签收反馈数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String updateZlqsfk(Zlqsfk entity);
}
